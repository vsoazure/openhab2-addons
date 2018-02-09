/**
 * Copyright (c) 2014,2018 by the respective copyright holders.
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.powermeter.handler;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jetty.util.B64Code;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.smarthome.core.library.types.DecimalType;
import org.eclipse.smarthome.core.library.types.StringType;
import org.eclipse.smarthome.core.thing.Channel;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.State;
import org.eclipse.smarthome.core.types.UnDefType;
import org.eclipse.smarthome.io.net.http.HttpUtil;
import org.openhab.binding.powermeter.PowerMeterBindingConstants;
import org.openhab.binding.powermeter.PowerMeterDeviceConfiguration;
import org.openhab.binding.powermeter.api.PowerMeterResponse;
import org.openhab.binding.powermeter.api.ValueUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * The {@link PowerMeterHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Florian Pazour - Initial contribution
 */

public class PowerMeterHandler extends BaseThingHandler {

    private final Logger logger = LoggerFactory.getLogger(PowerMeterHandler.class);
    private PowerMeterResponse powerMeterResponse;
    private PowerMeterDeviceConfiguration config;
    private Gson gson;
    private static final int API_TIMEOUT = 5000; // set on 5000ms - not specified in datasheet

    public PowerMeterHandler(Thing thing) {
        super(thing);
        gson = new Gson();
        logger.debug("Created PowerMeterHandler object for {}", thing.getUID());
        System.out.println("Constructor called");
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        logger.debug("Command {} is not supported for channel: {}", command, channelUID.getId());
        logger.debug("There are no commands specified for this thing: {}", thing);
    }

    protected String getDescription() {
        return "VERBUND Power Meter";
    }

    public void refresh() {
        updateData(config);
        updateChannels();
    }

    public void updateStatus() {
        updateStatus(ThingStatus.ONLINE);
    }

    /**
     * Get new data
     *
     */
    private void updateData(PowerMeterDeviceConfiguration config) {
        powerMeterResponse = getRealtimeData(config);
    }

    private PowerMeterResponse getRealtimeData(PowerMeterDeviceConfiguration config) {
        PowerMeterResponse result = null;
        boolean resultOk = false;
        String errorMsg = null;

        try {
            String basicAuthentication = "Basic "
                    + B64Code.encode(config.username + ":" + config.password, StringUtil.__ISO_8859_1);

            Properties AuthHeader = new Properties();
            AuthHeader.setProperty("Authorization", basicAuthentication);

            String location = PowerMeterBindingConstants.POWERMETER_DATA_URL.replace("%IP%",
                    StringUtils.trimToEmpty(config.ip));
            logger.debug("URL = {}", location);

            String response = HttpUtil.executeUrl("GET", location, AuthHeader, null, null, API_TIMEOUT);
            /**
             * Executes the given <code>url</code> with the given <code>httpMethod</code>.
             * Furthermore the <code>http.proxyXXX</code> System variables are read and
             * set into the {@link HttpClient}.
             *
             * @param httpMethod the HTTP method to use
             * @param url the url to execute
             * @param httpHeaders optional http request headers which has to be sent within request
             * @param content the content to be send to the given <code>url</code> or <code>null</code> if no content
             *            should be
             *            send.
             * @param contentType the content type of the given <code>content</code>
             * @param timeout the socket timeout in milliseconds to wait for data
             *
             * @return the response body or <code>NULL</code> when the request went wrong
             * @throws IOException when the request execution failed, timed out or it was interrupted
             */

            if (response != null) {
                logger.debug("aqiResponse = {}", response);
                result = gson.fromJson(response, PowerMeterResponse.class);
            }
            if (result == null) {
                errorMsg = "no data returned";
            } else {
                resultOk = true;
            }

            if (!resultOk) {
                logger.error("Error in powermeter response: {}", errorMsg);
            }
        } catch (JsonSyntaxException e) {
            errorMsg = "Configuration is incorrect";
            logger.error("Error running powermeter request: {}", e.getMessage());
        } catch (IOException | IllegalStateException e) {
            errorMsg = "Connection failed";
            logger.error("Error running powermeter request: {}", e.getMessage());
        }

        // Update the thing status
        if (resultOk) {
            updateStatus(ThingStatus.ONLINE);
        } else {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.OFFLINE.COMMUNICATION_ERROR, errorMsg);
        }

        return resultOk ? result : null;
    }

    /**
     * Update all Channels
     */
    protected void updateChannels() {
        for (Channel channel : getThing().getChannels()) {
            updateChannel(channel.getUID().getId());
        }
    }

    /**
     * Update the channel from the last data
     *
     * @param channelId the id identifying the channel to be updated
     */
    protected void updateChannel(String channelId) {
        if (!isLinked(channelId)) {
            return;
        }
        Object value;
        value = getValue(channelId);

        State state = null;
        if (value == null) {
            state = UnDefType.UNDEF;
        } else if (value instanceof BigDecimal) {
            state = new DecimalType((BigDecimal) value);
        } else if (value instanceof Integer) {
            state = new DecimalType(BigDecimal.valueOf(((Integer) value).longValue()));
        } else if (value instanceof String) {
            state = new StringType(value.toString());
        } else if (value instanceof Double) {
            state = new DecimalType((double) value);
        } else if (value instanceof ValueUnit) {
            state = new DecimalType(((ValueUnit) value).getValue());
        } else {
            logger.warn("Update channel {}: Unsupported value type {}", channelId, value.getClass().getSimpleName());
        }
        logger.debug("Update channel {} with state {} ({})", channelId, (state == null) ? "null" : state.toString(),
                (value == null) ? "null" : value.getClass().getSimpleName());

        // Update the channel
        if (state != null) {
            updateState(channelId, state);
        }

    }

    /**
     * Update the channel from the last data retrieved
     *
     * @param channelId the id identifying the channel to be updated
     * @param data
     * @return
     */
    protected Object getValue(String channelId) {
        String[] fields = StringUtils.split(channelId, "#");

        if (powerMeterResponse == null) {
            return null;
        }

        String fieldName = fields[0];

        switch (fieldName) {
            /* General */
            case PowerMeterBindingConstants.Frequency:
                return powerMeterResponse.getFrequency();
            case PowerMeterBindingConstants.Temperature:
                return powerMeterResponse.getTemperature();
            case PowerMeterBindingConstants.OperationalTime:
                return powerMeterResponse.getOperationalTime();

            /* Voltage */
            case PowerMeterBindingConstants.VoltagePhase1:
                return powerMeterResponse.getVoltagePhase1();
            case PowerMeterBindingConstants.VoltagePhase2:
                return powerMeterResponse.getVoltagePhase2();
            case PowerMeterBindingConstants.VoltagePhase3:
                return powerMeterResponse.getVoltagePhase3();
            case PowerMeterBindingConstants.VoltagePhase3ToPhase2:
                return powerMeterResponse.getVoltagePhase3ToPhase2();
            case PowerMeterBindingConstants.VoltagePhase2ToPhase1:
                return powerMeterResponse.getVoltagePhase2ToPhase1();
            case PowerMeterBindingConstants.VoltagePhase1ToPhase3:
                return powerMeterResponse.getVoltagePhase1ToPhase3();
            case PowerMeterBindingConstants.AverageVoltagePhaseToPhase:
                return powerMeterResponse.getAverageVoltagePhaseToPhase();
            case PowerMeterBindingConstants.AverageVoltageNeutralToPhase:
                return powerMeterResponse.getAverageVoltageNeutralToPhase();

            /* Current */
            case PowerMeterBindingConstants.CurrentPhase1:
                return powerMeterResponse.getCurrentPhase1();
            case PowerMeterBindingConstants.CurrentPhase2:
                return powerMeterResponse.getCurrentPhase2();
            case PowerMeterBindingConstants.CurrentPhase3:
                return powerMeterResponse.getCurrentPhase3();
            case PowerMeterBindingConstants.CurrentSum:
                return powerMeterResponse.getCurrentSum();

            /* Angles */
            case PowerMeterBindingConstants.PhaseAngleCurrentToVoltagePhase1:
                return powerMeterResponse.getPhaseAngleCurrentToVoltagePhase1();
            case PowerMeterBindingConstants.PhaseAngleCurrentToVoltagePhase2:
                return powerMeterResponse.getPhaseAngleCurrentToVoltagePhase2();
            case PowerMeterBindingConstants.PhaseAngleCurrentToVoltagePhase3:
                return powerMeterResponse.getPhaseAngleCurrentToVoltagePhase3();
            case PowerMeterBindingConstants.PhaseAnglePhase1To3:
                return powerMeterResponse.getPhaseAnglePhase1To3();
            case PowerMeterBindingConstants.PhaseAnglePhase2To3:
                return powerMeterResponse.getPhaseAnglePhase2To3();

            /* Power */
            case PowerMeterBindingConstants.ActivePowerPhase1:
                return powerMeterResponse.getActivePowerPhase1();
            case PowerMeterBindingConstants.ActivePowerPhase2:
                return powerMeterResponse.getActivePowerPhase2();
            case PowerMeterBindingConstants.ActivePowerPhase3:
                return powerMeterResponse.getActivePowerPhase3();
            case PowerMeterBindingConstants.ActivePowerSum:
                return powerMeterResponse.getActivePowerSum();
            case PowerMeterBindingConstants.ActiveFundamentalPowerPhase1:
                return powerMeterResponse.getActiveFundamentalPowerPhase1();
            case PowerMeterBindingConstants.ActiveFundamentalPowerPhase2:
                return powerMeterResponse.getActiveFundamentalPowerPhase2();
            case PowerMeterBindingConstants.ActiveFundamentalPowerPhase3:
                return powerMeterResponse.getActiveFundamentalPowerPhase3();
            case PowerMeterBindingConstants.ActiveFundamentalPowerSum:
                return powerMeterResponse.getActiveFundamentalPowerSum();
            case PowerMeterBindingConstants.ActiveHarmonicPowerPhase1:
                return powerMeterResponse.getActiveHarmonicPowerPhase1();
            case PowerMeterBindingConstants.ActiveHarmonicPowerPhase2:
                return powerMeterResponse.getActiveHarmonicPowerPhase2();
            case PowerMeterBindingConstants.ActiveHarmonicPowerPhase3:
                return powerMeterResponse.getActiveHarmonicPowerPhase3();
            case PowerMeterBindingConstants.ActiveHarmonicPowerSum:
                return powerMeterResponse.getActiveHarmonicPowerSum();
            case PowerMeterBindingConstants.ReactivePowerPhase1:
                return powerMeterResponse.getReactivePowerPhase1();
            case PowerMeterBindingConstants.ReactivePowerPhase2:
                return powerMeterResponse.getReactivePowerPhase2();
            case PowerMeterBindingConstants.ReactivePowerPhase3:
                return powerMeterResponse.getReactivePowerPhase3();
            case PowerMeterBindingConstants.ReactivePowerSum:
                return powerMeterResponse.getReactivePowerSum();
            case PowerMeterBindingConstants.ApparentPowerPhase1:
                return powerMeterResponse.getApparentPowerPhase1();
            case PowerMeterBindingConstants.ApparentPowerPhase2:
                return powerMeterResponse.getApparentPowerPhase2();
            case PowerMeterBindingConstants.ApparentPowerPhase3:
                return powerMeterResponse.getApparentPowerPhase3();
            case PowerMeterBindingConstants.ApparentPowerSum:
                return powerMeterResponse.getApparentPowerSum();

            /* Forward Energy */
            case PowerMeterBindingConstants.ForwardActiveEnergyPhase1:
                return powerMeterResponse.getForwardActiveEnergyPhase1();
            case PowerMeterBindingConstants.ForwardActiveEnergyPhase2:
                return powerMeterResponse.getForwardActiveEnergyPhase2();
            case PowerMeterBindingConstants.ForwardActiveEnergyPhase3:
                return powerMeterResponse.getForwardActiveEnergyPhase3();
            case PowerMeterBindingConstants.ForwardActiveEnergySum:
                return powerMeterResponse.getForwardActiveEnergySum();
            case PowerMeterBindingConstants.ForwardActiveFundamentalEnergyPhase1:
                return powerMeterResponse.getForwardActiveFundamentalEnergyPhase1();
            case PowerMeterBindingConstants.ForwardActiveFundamentalEnergyPhase2:
                return powerMeterResponse.getForwardActiveFundamentalEnergyPhase2();
            case PowerMeterBindingConstants.ForwardActiveFundamentalEnergyPhase3:
                return powerMeterResponse.getForwardActiveFundamentalEnergyPhase3();
            case PowerMeterBindingConstants.ForwardActiveFundamentalEnergySum:
                return powerMeterResponse.getForwardActiveFundamentalEnergySum();
            case PowerMeterBindingConstants.ForwardActiveHarmonicEnergyPhase1:
                return powerMeterResponse.getForwardActiveHarmonicEnergyPhase1();
            case PowerMeterBindingConstants.ForwardActiveHarmonicEnergyPhase2:
                return powerMeterResponse.getForwardActiveHarmonicEnergyPhase2();
            case PowerMeterBindingConstants.ForwardActiveHarmonicEnergyPhase3:
                return powerMeterResponse.getForwardActiveHarmonicEnergyPhase3();
            case PowerMeterBindingConstants.ForwardActiveHarmonicEnergySum:
                return powerMeterResponse.getForwardActiveHarmonicEnergySum();
            case PowerMeterBindingConstants.ForwardReactiveEnergyPhase1:
                return powerMeterResponse.getForwardReactiveEnergyPhase1();
            case PowerMeterBindingConstants.ForwardReactiveEnergyPhase2:
                return powerMeterResponse.getForwardReactiveEnergyPhase2();
            case PowerMeterBindingConstants.ForwardReactiveEnergyPhase3:
                return powerMeterResponse.getForwardReactiveEnergyPhase3();
            case PowerMeterBindingConstants.ForwardReactiveEnergySum:
                return powerMeterResponse.getForwardReactiveEnergySum();

            /* Reverse Energy */
            case PowerMeterBindingConstants.ReverseActiveEnergyPhase1:
                return powerMeterResponse.getReverseActiveEnergyPhase1();
            case PowerMeterBindingConstants.ReverseActiveEnergyPhase2:
                return powerMeterResponse.getReverseActiveEnergyPhase2();
            case PowerMeterBindingConstants.ReverseActiveEnergyPhase3:
                return powerMeterResponse.getReverseActiveEnergyPhase3();
            case PowerMeterBindingConstants.ReverseActiveEnergySum:
                return powerMeterResponse.getReverseActiveEnergySum();
            case PowerMeterBindingConstants.ReverseActiveFundamentalEnergyPhase1:
                return powerMeterResponse.getReverseActiveFundamentalEnergyPhase1();
            case PowerMeterBindingConstants.ReverseActiveFundamentalEnergyPhase2:
                return powerMeterResponse.getReverseActiveFundamentalEnergyPhase2();
            case PowerMeterBindingConstants.ReverseActiveFundamentalEnergyPhase3:
                return powerMeterResponse.getReverseActiveFundamentalEnergyPhase3();
            case PowerMeterBindingConstants.ReverseActiveFundamentalEnergySum:
                return powerMeterResponse.getReverseActiveFundamentalEnergySum();
            case PowerMeterBindingConstants.ReverseActiveHarmonicEnergyPhase1:
                return powerMeterResponse.getReverseActiveHarmonicEnergyPhase1();
            case PowerMeterBindingConstants.ReverseActiveHarmonicEnergyPhase2:
                return powerMeterResponse.getReverseActiveHarmonicEnergyPhase2();
            case PowerMeterBindingConstants.ReverseActiveHarmonicEnergyPhase3:
                return powerMeterResponse.getReverseActiveHarmonicEnergyPhase3();
            case PowerMeterBindingConstants.ReverseActiveHarmonicEnergySum:
                return powerMeterResponse.getReverseActiveHarmonicEnergySum();
            case PowerMeterBindingConstants.ReverseReactiveEnergyPhase1:
                return powerMeterResponse.getReverseReactiveEnergyPhase1();
            case PowerMeterBindingConstants.ReverseReactiveEnergyPhase2:
                return powerMeterResponse.getReverseReactiveEnergyPhase2();
            case PowerMeterBindingConstants.ReverseReactiveEnergyPhase3:
                return powerMeterResponse.getReverseReactiveEnergyPhase3();
            case PowerMeterBindingConstants.ReverseReactiveEnergySum:
                return powerMeterResponse.getReverseReactiveEnergySum();

            /* Apparent Energy */
            case PowerMeterBindingConstants.ApparentEnergyConsumptionPhase1:
                return powerMeterResponse.getApparentEnergyConsumptionPhase1();
            case PowerMeterBindingConstants.ApparentEnergyConsumptionPhase2:
                return powerMeterResponse.getApparentEnergyConsumptionPhase2();
            case PowerMeterBindingConstants.ApparentEnergyConsumptionPhase3:
                return powerMeterResponse.getApparentEnergyConsumptionPhase3();
            case PowerMeterBindingConstants.ApparentEnergyConsumptionSum:
                return powerMeterResponse.getApparentEnergyConsumptionSum();
        }
        return null;
    }
}
