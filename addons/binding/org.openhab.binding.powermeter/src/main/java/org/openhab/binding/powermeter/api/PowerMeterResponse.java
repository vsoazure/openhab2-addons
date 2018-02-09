/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.powermeter.api;

import com.google.gson.annotations.SerializedName;

/**
 * The {@link PowerMeterResponse} is responsible for storing
 * the "data" node of the JSON response
 *
 * @author Florian Pazour - Initial contribution
 */
public class PowerMeterResponse {
    /* General */
    @SerializedName("F")
    private Float Frequency;
    @SerializedName("T")
    private Float Temperature;
    @SerializedName("TIME")
    private Float OperationalTime;

    /* Voltage */
    @SerializedName("VA")
    private Float VoltagePhase1;
    @SerializedName("VB")
    private Float VoltagePhase2;
    @SerializedName("VC")
    private Float VoltagePhase3;
    @SerializedName("VCB")
    private Float VoltagePhase3ToPhase2;
    @SerializedName("VBA")
    private Float VoltagePhase2ToPhase1;
    @SerializedName("VAC")
    private Float VoltagePhase1ToPhase3;
    @SerializedName("VPT")
    private Float AverageVoltagePhaseToPhase;
    @SerializedName("VT")
    private Float AverageVoltageNeutralToPhase;

    /* Current */
    @SerializedName("IA")
    private Float CurrentPhase1;
    @SerializedName("IB")
    private Float CurrentPhase2;
    @SerializedName("IC")
    private Float CurrentPhase3;
    @SerializedName("IN")
    private Float CurrentSum;

    /* Angles */
    @SerializedName("IAA")
    private Float PhaseAngleCurrentToVoltagePhase1;
    @SerializedName("IAB")
    private Float PhaseAngleCurrentToVoltagePhase2;
    @SerializedName("IAC")
    private Float PhaseAngleCurrentToVoltagePhase3;
    @SerializedName("UAA")
    private Float PhaseAnglePhase1To3;
    @SerializedName("UAB")
    private Float PhaseAnglePhase2To3;

    /* Power */
    @SerializedName("PA")
    private Float ActivePowerPhase1;
    @SerializedName("PB")
    private Float ActivePowerPhase2;
    @SerializedName("PC")
    private Float ActivePowerPhase3;
    @SerializedName("PT")
    private Float ActivePowerSum;

    @SerializedName("PAF")
    private Float ActiveFundamentalPowerPhase1;
    @SerializedName("PBF")
    private Float ActiveFundamentalPowerPhase2;
    @SerializedName("PCF")
    private Float ActiveFundamentalPowerPhase3;
    @SerializedName("PTF")
    private Float ActiveFundamentalPowerSum;

    @SerializedName("PAH")
    private Float ActiveHarmonicPowerPhase1;
    @SerializedName("PBH")
    private Float ActiveHarmonicPowerPhase2;
    @SerializedName("PCH")
    private Float ActiveHarmonicPowerPhase3;
    @SerializedName("PTH")
    private Float ActiveHarmonicPowerSum;

    @SerializedName("QA")
    private Float ReactivePowerPhase1;
    @SerializedName("QB")
    private Float ReactivePowerPhase2;
    @SerializedName("QC")
    private Float ReactivePowerPhase3;
    @SerializedName("QT")
    private Float ReactivePowerSum;

    @SerializedName("SA")
    private Float ApparentPowerPhase1;
    @SerializedName("SB")
    private Float ApparentPowerPhase2;
    @SerializedName("SC")
    private Float ApparentPowerPhase3;
    @SerializedName("ST")
    private Float ApparentPowerSum;

    /* Forward Energy */
    @SerializedName("EFAA")
    private Float ForwardActiveEnergyPhase1;
    @SerializedName("EFAB")
    private Float ForwardActiveEnergyPhase2;
    @SerializedName("EFAC")
    private Float ForwardActiveEnergyPhase3;
    @SerializedName("EFAT")
    private Float ForwardActiveEnergySum;

    @SerializedName("EFAF")
    private Float ForwardActiveFundamentalEnergyPhase1;
    @SerializedName("EFBF")
    private Float ForwardActiveFundamentalEnergyPhase2;
    @SerializedName("EFCF")
    private Float ForwardActiveFundamentalEnergyPhase3;
    @SerializedName("EFTF")
    private Float ForwardActiveFundamentalEnergySum;

    @SerializedName("EFAH")
    private Float ForwardActiveHarmonicEnergyPhase1;
    @SerializedName("EFBH")
    private Float ForwardActiveHarmonicEnergyPhase2;
    @SerializedName("EFCH")
    private Float ForwardActiveHarmonicEnergyPhase3;
    @SerializedName("EFTH")
    private Float ForwardActiveHarmonicEnergySum;

    @SerializedName("EFRA")
    private Float ForwardReactiveEnergyPhase1;
    @SerializedName("EFRB")
    private Float ForwardReactiveEnergyPhase2;
    @SerializedName("EFRC")
    private Float ForwardReactiveEnergyPhase3;
    @SerializedName("EFRT")
    private Float ForwardReactiveEnergySum;

    /* Reverse Energy */
    @SerializedName("ERAA")
    private Float ReverseActiveEnergyPhase1;
    @SerializedName("ERAB")
    private Float ReverseActiveEnergyPhase2;
    @SerializedName("ERAC")
    private Float ReverseActiveEnergyPhase3;
    @SerializedName("ERAT")
    private Float ReverseActiveEnergySum;

    @SerializedName("ERAF")
    private Float ReverseActiveFundamentalEnergyPhase1;
    @SerializedName("ERBF")
    private Float ReverseActiveFundamentalEnergyPhase2;
    @SerializedName("ERCF")
    private Float ReverseActiveFundamentalEnergyPhase3;
    @SerializedName("ERTF")
    private Float ReverseActiveFundamentalEnergySum;

    @SerializedName("ERAH")
    private Float ReverseActiveHarmonicEnergyPhase1;
    @SerializedName("ERBH")
    private Float ReverseActiveHarmonicEnergyPhase2;
    @SerializedName("ERCH")
    private Float ReverseActiveHarmonicEnergyPhase3;
    @SerializedName("ERTH")
    private Float ReverseActiveHarmonicEnergySum;

    @SerializedName("ERRA")
    private Float ReverseReactiveEnergyPhase1;
    @SerializedName("ERRB")
    private Float ReverseReactiveEnergyPhase2;
    @SerializedName("ERRC")
    private Float ReverseReactiveEnergyPhase3;
    @SerializedName("ERRT")
    private Float ReverseReactiveEnergySum;

    /* Apparent Energy */
    @SerializedName("ESA")
    private Float ApparentEnergyConsumptionPhase1;
    @SerializedName("ESB")
    private Float ApparentEnergyConsumptionPhase2;
    @SerializedName("ESC")
    private Float ApparentEnergyConsumptionPhase3;
    @SerializedName("EST")
    private Float ApparentEnergyConsumptionSum;

    /* Getters and Setters */
    public Float getFrequency() {
        return Frequency;
    }

    public void setFrequency(Float frequency) {
        Frequency = frequency;
    }

    public Float getTemperature() {
        return Temperature;
    }

    public void setTemperature(Float temperature) {
        Temperature = temperature;
    }

    public Float getOperationalTime() {
        return OperationalTime;
    }

    public void setOperationalTime(Float operationalTime) {
        OperationalTime = operationalTime;
    }

    public Float getVoltagePhase1() {
        return VoltagePhase1;
    }

    public void setVoltagePhase1(Float voltagePhase1) {
        VoltagePhase1 = voltagePhase1;
    }

    public Float getVoltagePhase2() {
        return VoltagePhase2;
    }

    public void setVoltagePhase2(Float voltagePhase2) {
        VoltagePhase2 = voltagePhase2;
    }

    public Float getVoltagePhase3() {
        return VoltagePhase3;
    }

    public void setVoltagePhase3(Float voltagePhase3) {
        VoltagePhase3 = voltagePhase3;
    }

    public Float getVoltagePhase3ToPhase2() {
        return VoltagePhase3ToPhase2;
    }

    public void setVoltagePhase3ToPhase2(Float voltagePhase3ToPhase2) {
        VoltagePhase3ToPhase2 = voltagePhase3ToPhase2;
    }

    public Float getVoltagePhase2ToPhase1() {
        return VoltagePhase2ToPhase1;
    }

    public void setVoltagePhase2ToPhase1(Float voltagePhase2ToPhase1) {
        VoltagePhase2ToPhase1 = voltagePhase2ToPhase1;
    }

    public Float getVoltagePhase1ToPhase3() {
        return VoltagePhase1ToPhase3;
    }

    public void setVoltagePhase1ToPhase3(Float voltagePhase1ToPhase3) {
        VoltagePhase1ToPhase3 = voltagePhase1ToPhase3;
    }

    public Float getAverageVoltagePhaseToPhase() {
        return AverageVoltagePhaseToPhase;
    }

    public void setAverageVoltagePhaseToPhase(Float averageVoltagePhaseToPhase) {
        AverageVoltagePhaseToPhase = averageVoltagePhaseToPhase;
    }

    public Float getAverageVoltageNeutralToPhase() {
        return AverageVoltageNeutralToPhase;
    }

    public void setAverageVoltageNeutralToPhase(Float averageVoltageNeutralToPhase) {
        AverageVoltageNeutralToPhase = averageVoltageNeutralToPhase;
    }

    public Float getCurrentPhase1() {
        return CurrentPhase1;
    }

    public void setCurrentPhase1(Float currentPhase1) {
        CurrentPhase1 = currentPhase1;
    }

    public Float getCurrentPhase2() {
        return CurrentPhase2;
    }

    public void setCurrentPhase2(Float currentPhase2) {
        CurrentPhase2 = currentPhase2;
    }

    public Float getCurrentPhase3() {
        return CurrentPhase3;
    }

    public void setCurrentPhase3(Float currentPhase3) {
        CurrentPhase3 = currentPhase3;
    }

    public Float getCurrentSum() {
        return CurrentSum;
    }

    public void setCurrentSum(Float currentSum) {
        CurrentSum = currentSum;
    }

    public Float getPhaseAngleCurrentToVoltagePhase1() {
        return PhaseAngleCurrentToVoltagePhase1;
    }

    public void setPhaseAngleCurrentToVoltagePhase1(Float phaseAngleCurrentToVoltagePhase1) {
        PhaseAngleCurrentToVoltagePhase1 = phaseAngleCurrentToVoltagePhase1;
    }

    public Float getPhaseAngleCurrentToVoltagePhase2() {
        return PhaseAngleCurrentToVoltagePhase2;
    }

    public void setPhaseAngleCurrentToVoltagePhase2(Float phaseAngleCurrentToVoltagePhase2) {
        PhaseAngleCurrentToVoltagePhase2 = phaseAngleCurrentToVoltagePhase2;
    }

    public Float getPhaseAngleCurrentToVoltagePhase3() {
        return PhaseAngleCurrentToVoltagePhase3;
    }

    public void setPhaseAngleCurrentToVoltagePhase3(Float phaseAngleCurrentToVoltagePhase3) {
        PhaseAngleCurrentToVoltagePhase3 = phaseAngleCurrentToVoltagePhase3;
    }

    public Float getPhaseAnglePhase1To3() {
        return PhaseAnglePhase1To3;
    }

    public void setPhaseAnglePhase1To3(Float phaseAnglePhase1To3) {
        PhaseAnglePhase1To3 = phaseAnglePhase1To3;
    }

    public Float getPhaseAnglePhase2To3() {
        return PhaseAnglePhase2To3;
    }

    public void setPhaseAnglePhase2To3(Float phaseAnglePhase2To3) {
        PhaseAnglePhase2To3 = phaseAnglePhase2To3;
    }

    public Float getActivePowerPhase1() {
        return ActivePowerPhase1;
    }

    public void setActivePowerPhase1(Float activePowerPhase1) {
        ActivePowerPhase1 = activePowerPhase1;
    }

    public Float getActivePowerPhase2() {
        return ActivePowerPhase2;
    }

    public void setActivePowerPhase2(Float activePowerPhase2) {
        ActivePowerPhase2 = activePowerPhase2;
    }

    public Float getActivePowerPhase3() {
        return ActivePowerPhase3;
    }

    public void setActivePowerPhase3(Float activePowerPhase3) {
        ActivePowerPhase3 = activePowerPhase3;
    }

    public Float getActivePowerSum() {
        return ActivePowerSum;
    }

    public void setActivePowerSum(Float activePowerSum) {
        ActivePowerSum = activePowerSum;
    }

    public Float getActiveFundamentalPowerPhase1() {
        return ActiveFundamentalPowerPhase1;
    }

    public void setActiveFundamentalPowerPhase1(Float activeFundamentalPowerPhase1) {
        ActiveFundamentalPowerPhase1 = activeFundamentalPowerPhase1;
    }

    public Float getActiveFundamentalPowerPhase2() {
        return ActiveFundamentalPowerPhase2;
    }

    public void setActiveFundamentalPowerPhase2(Float activeFundamentalPowerPhase2) {
        ActiveFundamentalPowerPhase2 = activeFundamentalPowerPhase2;
    }

    public Float getActiveFundamentalPowerPhase3() {
        return ActiveFundamentalPowerPhase3;
    }

    public void setActiveFundamentalPowerPhase3(Float activeFundamentalPowerPhase3) {
        ActiveFundamentalPowerPhase3 = activeFundamentalPowerPhase3;
    }

    public Float getActiveFundamentalPowerSum() {
        return ActiveFundamentalPowerSum;
    }

    public void setActiveFundamentalPowerSum(Float activeFundamentalPowerSum) {
        ActiveFundamentalPowerSum = activeFundamentalPowerSum;
    }

    public Float getActiveHarmonicPowerPhase1() {
        return ActiveHarmonicPowerPhase1;
    }

    public void setActiveHarmonicPowerPhase1(Float activeHarmonicPowerPhase1) {
        ActiveHarmonicPowerPhase1 = activeHarmonicPowerPhase1;
    }

    public Float getActiveHarmonicPowerPhase2() {
        return ActiveHarmonicPowerPhase2;
    }

    public void setActiveHarmonicPowerPhase2(Float activeHarmonicPowerPhase2) {
        ActiveHarmonicPowerPhase2 = activeHarmonicPowerPhase2;
    }

    public Float getActiveHarmonicPowerPhase3() {
        return ActiveHarmonicPowerPhase3;
    }

    public void setActiveHarmonicPowerPhase3(Float activeHarmonicPowerPhase3) {
        ActiveHarmonicPowerPhase3 = activeHarmonicPowerPhase3;
    }

    public Float getActiveHarmonicPowerSum() {
        return ActiveHarmonicPowerSum;
    }

    public void setActiveHarmonicPowerSum(Float activeHarmonicPowerSum) {
        ActiveHarmonicPowerSum = activeHarmonicPowerSum;
    }

    public Float getReactivePowerPhase1() {
        return ReactivePowerPhase1;
    }

    public void setReactivePowerPhase1(Float reactivePowerPhase1) {
        ReactivePowerPhase1 = reactivePowerPhase1;
    }

    public Float getReactivePowerPhase2() {
        return ReactivePowerPhase2;
    }

    public void setReactivePowerPhase2(Float reactivePowerPhase2) {
        ReactivePowerPhase2 = reactivePowerPhase2;
    }

    public Float getReactivePowerPhase3() {
        return ReactivePowerPhase3;
    }

    public void setReactivePowerPhase3(Float reactivePowerPhase3) {
        ReactivePowerPhase3 = reactivePowerPhase3;
    }

    public Float getReactivePowerSum() {
        return ReactivePowerSum;
    }

    public void setReactivePowerSum(Float reactivePowerSum) {
        ReactivePowerSum = reactivePowerSum;
    }

    public Float getApparentPowerPhase1() {
        return ApparentPowerPhase1;
    }

    public void setApparentPowerPhase1(Float apparentPowerPhase1) {
        ApparentPowerPhase1 = apparentPowerPhase1;
    }

    public Float getApparentPowerPhase2() {
        return ApparentPowerPhase2;
    }

    public void setApparentPowerPhase2(Float apparentPowerPhase2) {
        ApparentPowerPhase2 = apparentPowerPhase2;
    }

    public Float getApparentPowerPhase3() {
        return ApparentPowerPhase3;
    }

    public void setApparentPowerPhase3(Float apparentPowerPhase3) {
        ApparentPowerPhase3 = apparentPowerPhase3;
    }

    public Float getApparentPowerSum() {
        return ApparentPowerSum;
    }

    public void setApparentPowerSum(Float apparentPowerSum) {
        ApparentPowerSum = apparentPowerSum;
    }

    public Float getForwardActiveEnergyPhase1() {
        return ForwardActiveEnergyPhase1;
    }

    public void setForwardActiveEnergyPhase1(Float forwardActiveEnergyPhase1) {
        ForwardActiveEnergyPhase1 = forwardActiveEnergyPhase1;
    }

    public Float getForwardActiveEnergyPhase2() {
        return ForwardActiveEnergyPhase2;
    }

    public void setForwardActiveEnergyPhase2(Float forwardActiveEnergyPhase2) {
        ForwardActiveEnergyPhase2 = forwardActiveEnergyPhase2;
    }

    public Float getForwardActiveEnergyPhase3() {
        return ForwardActiveEnergyPhase3;
    }

    public void setForwardActiveEnergyPhase3(Float forwardActiveEnergyPhase3) {
        ForwardActiveEnergyPhase3 = forwardActiveEnergyPhase3;
    }

    public Float getForwardActiveEnergySum() {
        return ForwardActiveEnergySum;
    }

    public void setForwardActiveEnergySum(Float forwardActiveEnergySum) {
        ForwardActiveEnergySum = forwardActiveEnergySum;
    }

    public Float getForwardActiveFundamentalEnergyPhase1() {
        return ForwardActiveFundamentalEnergyPhase1;
    }

    public void setForwardActiveFundamentalEnergyPhase1(Float forwardActiveFundamentalEnergyPhase1) {
        ForwardActiveFundamentalEnergyPhase1 = forwardActiveFundamentalEnergyPhase1;
    }

    public Float getForwardActiveFundamentalEnergyPhase2() {
        return ForwardActiveFundamentalEnergyPhase2;
    }

    public void setForwardActiveFundamentalEnergyPhase2(Float forwardActiveFundamentalEnergyPhase2) {
        ForwardActiveFundamentalEnergyPhase2 = forwardActiveFundamentalEnergyPhase2;
    }

    public Float getForwardActiveFundamentalEnergyPhase3() {
        return ForwardActiveFundamentalEnergyPhase3;
    }

    public void setForwardActiveFundamentalEnergyPhase3(Float forwardActiveFundamentalEnergyPhase3) {
        ForwardActiveFundamentalEnergyPhase3 = forwardActiveFundamentalEnergyPhase3;
    }

    public Float getForwardActiveFundamentalEnergySum() {
        return ForwardActiveFundamentalEnergySum;
    }

    public void setForwardActiveFundamentalEnergySum(Float forwardActiveFundamentalEnergySum) {
        ForwardActiveFundamentalEnergySum = forwardActiveFundamentalEnergySum;
    }

    public Float getForwardActiveHarmonicEnergyPhase1() {
        return ForwardActiveHarmonicEnergyPhase1;
    }

    public void setForwardActiveHarmonicEnergyPhase1(Float forwardActiveHarmonicEnergyPhase1) {
        ForwardActiveHarmonicEnergyPhase1 = forwardActiveHarmonicEnergyPhase1;
    }

    public Float getForwardActiveHarmonicEnergyPhase2() {
        return ForwardActiveHarmonicEnergyPhase2;
    }

    public void setForwardActiveHarmonicEnergyPhase2(Float forwardActiveHarmonicEnergyPhase2) {
        ForwardActiveHarmonicEnergyPhase2 = forwardActiveHarmonicEnergyPhase2;
    }

    public Float getForwardActiveHarmonicEnergyPhase3() {
        return ForwardActiveHarmonicEnergyPhase3;
    }

    public void setForwardActiveHarmonicEnergyPhase3(Float forwardActiveHarmonicEnergyPhase3) {
        ForwardActiveHarmonicEnergyPhase3 = forwardActiveHarmonicEnergyPhase3;
    }

    public Float getForwardActiveHarmonicEnergySum() {
        return ForwardActiveHarmonicEnergySum;
    }

    public void setForwardActiveHarmonicEnergySum(Float forwardActiveHarmonicEnergySum) {
        ForwardActiveHarmonicEnergySum = forwardActiveHarmonicEnergySum;
    }

    public Float getForwardReactiveEnergyPhase1() {
        return ForwardReactiveEnergyPhase1;
    }

    public void setForwardReactiveEnergyPhase1(Float forwardReactiveEnergyPhase1) {
        ForwardReactiveEnergyPhase1 = forwardReactiveEnergyPhase1;
    }

    public Float getForwardReactiveEnergyPhase2() {
        return ForwardReactiveEnergyPhase2;
    }

    public void setForwardReactiveEnergyPhase2(Float forwardReactiveEnergyPhase2) {
        ForwardReactiveEnergyPhase2 = forwardReactiveEnergyPhase2;
    }

    public Float getForwardReactiveEnergyPhase3() {
        return ForwardReactiveEnergyPhase3;
    }

    public void setForwardReactiveEnergyPhase3(Float forwardReactiveEnergyPhase3) {
        ForwardReactiveEnergyPhase3 = forwardReactiveEnergyPhase3;
    }

    public Float getForwardReactiveEnergySum() {
        return ForwardReactiveEnergySum;
    }

    public void setForwardReactiveEnergySum(Float forwardReactiveEnergySum) {
        ForwardReactiveEnergySum = forwardReactiveEnergySum;
    }

    public Float getReverseActiveEnergyPhase1() {
        return ReverseActiveEnergyPhase1;
    }

    public void setReverseActiveEnergyPhase1(Float reverseActiveEnergyPhase1) {
        ReverseActiveEnergyPhase1 = reverseActiveEnergyPhase1;
    }

    public Float getReverseActiveEnergyPhase2() {
        return ReverseActiveEnergyPhase2;
    }

    public void setReverseActiveEnergyPhase2(Float reverseActiveEnergyPhase2) {
        ReverseActiveEnergyPhase2 = reverseActiveEnergyPhase2;
    }

    public Float getReverseActiveEnergyPhase3() {
        return ReverseActiveEnergyPhase3;
    }

    public void setReverseActiveEnergyPhase3(Float reverseActiveEnergyPhase3) {
        ReverseActiveEnergyPhase3 = reverseActiveEnergyPhase3;
    }

    public Float getReverseActiveEnergySum() {
        return ReverseActiveEnergySum;
    }

    public void setReverseActiveEnergySum(Float reverseActiveEnergySum) {
        ReverseActiveEnergySum = reverseActiveEnergySum;
    }

    public Float getReverseActiveFundamentalEnergyPhase1() {
        return ReverseActiveFundamentalEnergyPhase1;
    }

    public void setReverseActiveFundamentalEnergyPhase1(Float reverseActiveFundamentalEnergyPhase1) {
        ReverseActiveFundamentalEnergyPhase1 = reverseActiveFundamentalEnergyPhase1;
    }

    public Float getReverseActiveFundamentalEnergyPhase2() {
        return ReverseActiveFundamentalEnergyPhase2;
    }

    public void setReverseActiveFundamentalEnergyPhase2(Float reverseActiveFundamentalEnergyPhase2) {
        ReverseActiveFundamentalEnergyPhase2 = reverseActiveFundamentalEnergyPhase2;
    }

    public Float getReverseActiveFundamentalEnergyPhase3() {
        return ReverseActiveFundamentalEnergyPhase3;
    }

    public void setReverseActiveFundamentalEnergyPhase3(Float reverseActiveFundamentalEnergyPhase3) {
        ReverseActiveFundamentalEnergyPhase3 = reverseActiveFundamentalEnergyPhase3;
    }

    public Float getReverseActiveFundamentalEnergySum() {
        return ReverseActiveFundamentalEnergySum;
    }

    public void setReverseActiveFundamentalEnergySum(Float reverseActiveFundamentalEnergySum) {
        ReverseActiveFundamentalEnergySum = reverseActiveFundamentalEnergySum;
    }

    public Float getReverseActiveHarmonicEnergyPhase1() {
        return ReverseActiveHarmonicEnergyPhase1;
    }

    public void setReverseActiveHarmonicEnergyPhase1(Float reverseActiveHarmonicEnergyPhase1) {
        ReverseActiveHarmonicEnergyPhase1 = reverseActiveHarmonicEnergyPhase1;
    }

    public Float getReverseActiveHarmonicEnergyPhase2() {
        return ReverseActiveHarmonicEnergyPhase2;
    }

    public void setReverseActiveHarmonicEnergyPhase2(Float reverseActiveHarmonicEnergyPhase2) {
        ReverseActiveHarmonicEnergyPhase2 = reverseActiveHarmonicEnergyPhase2;
    }

    public Float getReverseActiveHarmonicEnergyPhase3() {
        return ReverseActiveHarmonicEnergyPhase3;
    }

    public void setReverseActiveHarmonicEnergyPhase3(Float reverseActiveHarmonicEnergyPhase3) {
        ReverseActiveHarmonicEnergyPhase3 = reverseActiveHarmonicEnergyPhase3;
    }

    public Float getReverseActiveHarmonicEnergySum() {
        return ReverseActiveHarmonicEnergySum;
    }

    public void setReverseActiveHarmonicEnergySum(Float reverseActiveHarmonicEnergySum) {
        ReverseActiveHarmonicEnergySum = reverseActiveHarmonicEnergySum;
    }

    public Float getReverseReactiveEnergyPhase1() {
        return ReverseReactiveEnergyPhase1;
    }

    public void setReverseReactiveEnergyPhase1(Float reverseReactiveEnergyPhase1) {
        ReverseReactiveEnergyPhase1 = reverseReactiveEnergyPhase1;
    }

    public Float getReverseReactiveEnergyPhase2() {
        return ReverseReactiveEnergyPhase2;
    }

    public void setReverseReactiveEnergyPhase2(Float reverseReactiveEnergyPhase2) {
        ReverseReactiveEnergyPhase2 = reverseReactiveEnergyPhase2;
    }

    public Float getReverseReactiveEnergyPhase3() {
        return ReverseReactiveEnergyPhase3;
    }

    public void setReverseReactiveEnergyPhase3(Float reverseReactiveEnergyPhase3) {
        ReverseReactiveEnergyPhase3 = reverseReactiveEnergyPhase3;
    }

    public Float getReverseReactiveEnergySum() {
        return ReverseReactiveEnergySum;
    }

    public void setReverseReactiveEnergySum(Float reverseReactiveEnergySum) {
        ReverseReactiveEnergySum = reverseReactiveEnergySum;
    }

    public Float getApparentEnergyConsumptionPhase1() {
        return ApparentEnergyConsumptionPhase1;
    }

    public void setApparentEnergyConsumptionPhase1(Float apparentEnergyConsumptionPhase1) {
        ApparentEnergyConsumptionPhase1 = apparentEnergyConsumptionPhase1;
    }

    public Float getApparentEnergyConsumptionPhase2() {
        return ApparentEnergyConsumptionPhase2;
    }

    public void setApparentEnergyConsumptionPhase2(Float apparentEnergyConsumptionPhase2) {
        ApparentEnergyConsumptionPhase2 = apparentEnergyConsumptionPhase2;
    }

    public Float getApparentEnergyConsumptionPhase3() {
        return ApparentEnergyConsumptionPhase3;
    }

    public void setApparentEnergyConsumptionPhase3(Float apparentEnergyConsumptionPhase3) {
        ApparentEnergyConsumptionPhase3 = apparentEnergyConsumptionPhase3;
    }

    public Float getApparentEnergyConsumptionSum() {
        return ApparentEnergyConsumptionSum;
    }

    public void setApparentEnergyConsumptionSum(Float apparentEnergyConsumptionSum) {
        ApparentEnergyConsumptionSum = apparentEnergyConsumptionSum;
    }
}
