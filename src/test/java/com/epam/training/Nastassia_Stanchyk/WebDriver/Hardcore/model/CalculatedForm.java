package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model;

import lombok.Data;

@Data
public class CalculatedForm {

    private String region;
    private String commitmentTerm;
    private String provisioningModel;
    private String instanceType;
    private String operationSystem;
    private String localSSD;
    private String estimatedComponentCostPerMonth;
    private String totalEstimatedCostPerMonth;
}
