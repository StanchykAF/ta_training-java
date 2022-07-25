package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.service;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.GoogleCloudMainForm;

public class GoogleCloudMainFormCompleting {

    private static GoogleCloudMainForm completeGoogleCloudMainForm;

    public static final String PRODUCT_NAME = "testdata.product_name";
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

    public static GoogleCloudMainForm completeForm() {
        completeGoogleCloudMainForm = new GoogleCloudMainForm();
        completeGoogleCloudMainForm.setProductName(TestDataReader.getTestData(PRODUCT_NAME));
        completeGoogleCloudMainForm.setNumberOfInstances(TestDataReader.getTestData(NUMBER_OF_INSTANCES));
        completeGoogleCloudMainForm.setOperationSystem(TestDataReader.getTestData(OPERATION_SYSTEM));
        completeGoogleCloudMainForm.setVMClass(TestDataReader.getTestData(VM_CLASS));
        completeGoogleCloudMainForm.setInstanceSeries(TestDataReader.getTestData(INSTANCE_SERIES));
        completeGoogleCloudMainForm.setInstanceType(TestDataReader.getTestData(INSTANCE_TYPE));
        completeGoogleCloudMainForm.setNumberOfGPUs(TestDataReader.getTestData(NUMBER_OF_GPUS));
        completeGoogleCloudMainForm.setGPUType(TestDataReader.getTestData(GPU_TYPE));
        completeGoogleCloudMainForm.setLocalSSD(TestDataReader.getTestData(LOCAL_SSD));
        completeGoogleCloudMainForm.setDatacenterLocation(TestDataReader.getTestData(DATACENTER_LOCATION));
        completeGoogleCloudMainForm.setCommittedUsage(TestDataReader.getTestData(COMMITTED_USAGE));
        return completeGoogleCloudMainForm;
    }
}
