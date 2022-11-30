package com.epam.training.Nastassia_Stanchyk.framework.service;

import com.epam.training.Nastassia_Stanchyk.framework.models.GoogleCloudMainForm;

public class GoogleCloudMainFormCompleting {

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
        GoogleCloudMainForm completeGoogleCloudMainForm = GoogleCloudMainForm.create()
                .withProductName(TestDataReader.getTestData(PRODUCT_NAME))
                .withNumberOfInstances(TestDataReader.getTestData(NUMBER_OF_INSTANCES))
                .withOperationSystem(TestDataReader.getTestData(OPERATION_SYSTEM))
                .withVMClass(TestDataReader.getTestData(VM_CLASS))
                .withInstanceSeries(TestDataReader.getTestData(INSTANCE_SERIES))
                .withInstanceType(TestDataReader.getTestData(INSTANCE_TYPE))
                .withNumberOfGPUs(TestDataReader.getTestData(NUMBER_OF_GPUS))
                .withGPUType(TestDataReader.getTestData(GPU_TYPE))
                .withLocalSSD(TestDataReader.getTestData(LOCAL_SSD))
                .withDatacenterLocation(TestDataReader.getTestData(DATACENTER_LOCATION))
                .withCommittedUsage(TestDataReader.getTestData(COMMITTED_USAGE))
                .build();
        return completeGoogleCloudMainForm;
    }
}
