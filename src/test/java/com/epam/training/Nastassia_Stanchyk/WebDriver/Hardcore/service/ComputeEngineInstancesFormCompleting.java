package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.service;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.ComputeEngineInstancesForm;

public class ComputeEngineInstancesFormCompleting {

    private static ComputeEngineInstancesForm computeEngineInstancesForm;

    public static final String NUMBER_OF_INSTANCES = "testdata.number_of_instances";
    public static final String OPERATION_SYSTEM = "testdata.operation_system";
    public static final String VM_CLASS = "testdata.vm_class";
    public static final String INSTANCE_SERIES = "testdata.instance_series";
    public static final String INSTANCE_TYPE = "testdata.instance_type";
    public static final String NUMBER_OF_GPUS = "testdata.number_of_gpus";
    public static final String GPU_TYPE = "testdata.gpu_type";
    public static final String LOCAL_SSD = "testdata.local_ssd";
    public static final String DATACENTER_LOCATION = "testdata.datacenter_location";
    public static final String COMMITTED_USAGE = "testdata.committed_usage";

    public static ComputeEngineInstancesForm completeForm() {
        computeEngineInstancesForm = new ComputeEngineInstancesForm();
        computeEngineInstancesForm.setNumberOfInstances(TestDataReader.getTestData(NUMBER_OF_INSTANCES));
        computeEngineInstancesForm.setOperationSystem(TestDataReader.getTestData(OPERATION_SYSTEM));
        computeEngineInstancesForm.setVMClass(TestDataReader.getTestData(VM_CLASS));
        computeEngineInstancesForm.setInstanceSeries(TestDataReader.getTestData(INSTANCE_SERIES));
        computeEngineInstancesForm.setInstanceType(TestDataReader.getTestData(INSTANCE_TYPE));
        computeEngineInstancesForm.setNumberOfGPUs(TestDataReader.getTestData(NUMBER_OF_GPUS));
        computeEngineInstancesForm.setGPUType(TestDataReader.getTestData(GPU_TYPE));
        computeEngineInstancesForm.setLocalSSD(TestDataReader.getTestData(LOCAL_SSD));
        computeEngineInstancesForm.setDatacenterLocation(TestDataReader.getTestData(DATACENTER_LOCATION));
        computeEngineInstancesForm.setCommittedUsage(TestDataReader.getTestData(COMMITTED_USAGE));
        return computeEngineInstancesForm;
    }
}
