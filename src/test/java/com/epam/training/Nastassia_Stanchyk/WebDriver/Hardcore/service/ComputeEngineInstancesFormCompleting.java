package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.service;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.ComputeEngineInstancesForm;

public class ComputeEngineInstancesFormCompleting {

    private static ComputeEngineInstancesForm computeEngineInstancesForm;

    public static ComputeEngineInstancesForm completeForm() {
        computeEngineInstancesForm = new ComputeEngineInstancesForm();
        computeEngineInstancesForm.setNumberOfInstances("4");
        computeEngineInstancesForm.setOperationSystem("Free");
        computeEngineInstancesForm.setVMClass("Regular");
        computeEngineInstancesForm.setInstanceSeries("N1");
        computeEngineInstancesForm.setInstanceType("n1-standard-8");
        computeEngineInstancesForm.setNumberOfGPUs("1");
        computeEngineInstancesForm.setGPUType("NVIDIA Tesla V100");
        computeEngineInstancesForm.setLocalSSD("2x375 GB");
        computeEngineInstancesForm.setDatacenterLocation("Frankfurt");
        computeEngineInstancesForm.setCommittedUsage("1 Year");
        return computeEngineInstancesForm;
    }
}
