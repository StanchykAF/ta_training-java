package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model;

import java.util.Objects;

public class FormData {

    private String numberOfInstances;
    private String operationSystem;
    private String VMClass;
    private String instanceSeries;
    private String instanceType;
    private String numberOfGPUs;
    private String GPUType;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public FormData() {
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getVMClass() {
        return VMClass;
    }

    public void setVMClass(String VMClass) {
        this.VMClass = VMClass;
    }

    public String getInstanceSeries() {
        return instanceSeries;
    }

    public void setInstanceSeries(String instanceSeries) {
        this.instanceSeries = instanceSeries;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getGPUType() {
        return GPUType;
    }

    public void setGPUType(String GPUType) {
        this.GPUType = GPUType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormData formData = (FormData) o;
        return Objects.equals(numberOfInstances, formData.numberOfInstances) &&
                Objects.equals(operationSystem, formData.operationSystem) &&
                Objects.equals(VMClass, formData.VMClass) &&
                Objects.equals(instanceType, formData.instanceType) &&
                Objects.equals(numberOfGPUs, formData.numberOfGPUs) &&
                Objects.equals(GPUType, formData.GPUType) &&
                Objects.equals(localSSD, formData.localSSD) &&
                Objects.equals(datacenterLocation, formData.datacenterLocation) &&
                Objects.equals(committedUsage, formData.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operationSystem, VMClass, instanceType, numberOfGPUs, GPUType, localSSD, datacenterLocation, committedUsage);
    }
}
