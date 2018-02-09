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
package org.openhab.binding.powermeter;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.smarthome.core.thing.ThingTypeUID;

/**
 * The {@link PowerMeterBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Florian Pazour - Initial contribution
 */
@NonNullByDefault
public class PowerMeterBindingConstants {

    private static final String BINDING_ID = "powermeter";

    // PowerMeter communicate on this port using both UDP (discovery) and TCP (commands)
    public static final int BAF_PORT = 50053;

    // Commands sent from PowerMeter are ASCII
    public static final String CHARSET = "US-ASCII";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_POWERMETER = new ThingTypeUID(BINDING_ID, "powermeter");

    /*
     * List of all Channels
     */

    // General Channels
    public static final String Frequency = "frequency";
    public static final String Temperature = "temperature";
    public static final String OperationalTime = "op_time";

    // Voltage Channels
    public static final String VoltagePhase1 = "voltage_phase1";
    public static final String VoltagePhase2 = "voltage_phase2";
    public static final String VoltagePhase3 = "voltage_phase3";

    public static final String VoltagePhase3ToPhase2 = "voltage_phase3-2";
    public static final String VoltagePhase2ToPhase1 = "voltage_phase2-1";
    public static final String VoltagePhase1ToPhase3 = "voltage_phase1-3";

    public static final String AverageVoltagePhaseToPhase = "avg_phase_phase_voltage";
    public static final String AverageVoltageNeutralToPhase = "avg_neutral_phase_voltage";

    // Current Channels
    public static final String CurrentPhase1 = "current_phase1";
    public static final String CurrentPhase2 = "current_phase2";
    public static final String CurrentPhase3 = "current_phase3";
    public static final String CurrentSum = "current_sum";

    // Angle Channels
    public static final String PhaseAngleCurrentToVoltagePhase1 = "phase_angle_currvolt_phase1";
    public static final String PhaseAngleCurrentToVoltagePhase2 = "phase_angle_currvolt_phase2";
    public static final String PhaseAngleCurrentToVoltagePhase3 = "phase_angle_currvolt_phase3";

    public static final String PhaseAnglePhase1To3 = "phase_angle_phase1-3";
    public static final String PhaseAnglePhase2To3 = "phase_angle_phase2-3";

    // Power Channels
    public static final String ActivePowerPhase1 = "activepower_phase1";
    public static final String ActivePowerPhase2 = "activepower_phase2";
    public static final String ActivePowerPhase3 = "activepower_phase3";
    public static final String ActivePowerSum = "activepower_sum";

    public static final String ActiveFundamentalPowerPhase1 = "activefundpower_phase1";
    public static final String ActiveFundamentalPowerPhase2 = "activefundpower_phase2";
    public static final String ActiveFundamentalPowerPhase3 = "activefundpower_phase3";
    public static final String ActiveFundamentalPowerSum = "activefundpower_sum";

    public static final String ActiveHarmonicPowerPhase1 = "activeharmpower_phase1";
    public static final String ActiveHarmonicPowerPhase2 = "activeharmpower_phase2";
    public static final String ActiveHarmonicPowerPhase3 = "activeharmpower_phase3";
    public static final String ActiveHarmonicPowerSum = "activeharmpower_sum";

    public static final String ReactivePowerPhase1 = "reactivepower_phase1";
    public static final String ReactivePowerPhase2 = "reactivepower_phase2";
    public static final String ReactivePowerPhase3 = "reactivepower_phase3";
    public static final String ReactivePowerSum = "reactivepower_sum";

    public static final String ApparentPowerPhase1 = "apppower_phase1";
    public static final String ApparentPowerPhase2 = "apppower_phase2";
    public static final String ApparentPowerPhase3 = "apppower_phase3";
    public static final String ApparentPowerSum = "apppower_sum";

    // Forward Energy Channels
    public static final String ForwardActiveEnergyPhase1 = "fwd_active_energy_phase1";
    public static final String ForwardActiveEnergyPhase2 = "fwd_active_energy_phase2";
    public static final String ForwardActiveEnergyPhase3 = "fwd_active_energy_phase3";
    public static final String ForwardActiveEnergySum = "fwd_active_energy_sum";

    public static final String ForwardActiveFundamentalEnergyPhase1 = "fwd_active_fund_energy_phase1";
    public static final String ForwardActiveFundamentalEnergyPhase2 = "fwd_active_fund_energy_phase2";
    public static final String ForwardActiveFundamentalEnergyPhase3 = "fwd_active_fund_energy_phase3";
    public static final String ForwardActiveFundamentalEnergySum = "fwd_active_fund_energy_sum";

    public static final String ForwardActiveHarmonicEnergyPhase1 = "fwd_active_harm_energy_phase1";
    public static final String ForwardActiveHarmonicEnergyPhase2 = "fwd_active_harm_energy_phase2";
    public static final String ForwardActiveHarmonicEnergyPhase3 = "fwd_active_harm_energy_phase3";
    public static final String ForwardActiveHarmonicEnergySum = "fwd_active_harm_energy_sum";

    public static final String ForwardReactiveEnergyPhase1 = "fwd_reactive_energy_phase1";
    public static final String ForwardReactiveEnergyPhase2 = "fwd_reactive_energy_phase2";
    public static final String ForwardReactiveEnergyPhase3 = "fwd_reactive_energy_phase3";
    public static final String ForwardReactiveEnergySum = "fwd_reactive_energy_sum";

    // Reverse Energy Channels
    public static final String ReverseActiveEnergyPhase1 = "rev_active_energy_phase1";
    public static final String ReverseActiveEnergyPhase2 = "rev_active_energy_phase2";
    public static final String ReverseActiveEnergyPhase3 = "rev_active_energy_phase3";
    public static final String ReverseActiveEnergySum = "rev_active_energy_sum";

    public static final String ReverseActiveFundamentalEnergyPhase1 = "rev_active_fund_energy_phase1";
    public static final String ReverseActiveFundamentalEnergyPhase2 = "rev_active_fund_energy_phase2";
    public static final String ReverseActiveFundamentalEnergyPhase3 = "rev_active_fund_energy_phase3";
    public static final String ReverseActiveFundamentalEnergySum = "rev_active_fund_energy_sum";

    public static final String ReverseActiveHarmonicEnergyPhase1 = "rev_active_harm_energy_phase1";
    public static final String ReverseActiveHarmonicEnergyPhase2 = "rev_active_harm_energy_phase2";
    public static final String ReverseActiveHarmonicEnergyPhase3 = "rev_active_harm_energy_phase3";
    public static final String ReverseActiveHarmonicEnergySum = "rev_active_harm_energy_sum";

    public static final String ReverseReactiveEnergyPhase1 = "rev_reactive_energy_phase1";
    public static final String ReverseReactiveEnergyPhase2 = "rev_reactive_energy_phase2";
    public static final String ReverseReactiveEnergyPhase3 = "rev_reactive_energy_phase3";
    public static final String ReverseReactiveEnergySum = "rev_reactive_energy_sum";

    // Apparent Energy Channels
    public static final String ApparentEnergyConsumptionPhase1 = "appenergy_consumption_phase1";
    public static final String ApparentEnergyConsumptionPhase2 = "appenergy_consumption_phase2";
    public static final String ApparentEnergyConsumptionPhase3 = "appenergy_consumption_phase3";
    public static final String ApparentEnergyConsumptionSum = "appenergy_consumption_sum";

    // list of all URLs
    public static final String POWERMETER_DATA_URL = "http://%IP%/wizard/public/api/measurements";
}
