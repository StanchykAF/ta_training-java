package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model;

import lombok.Data;

@Data
public class ComputeEngineInstancesForm {

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
}