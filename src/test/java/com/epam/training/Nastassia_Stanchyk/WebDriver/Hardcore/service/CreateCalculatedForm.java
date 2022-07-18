package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.service;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.CalculatedForm;
import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.util.StringUtils;

import java.util.List;

public class CreateCalculatedForm {

    public static CalculatedForm completeCalculatedForm(List<String> calculatedFormData, String totalMonthlyPrice) {
        CalculatedForm form = new CalculatedForm();
        form.setInstanceType(StringUtils.searchInListByTerm(calculatedFormData, "Instance type"));
        form.setLocalSSD(StringUtils.searchInListByTerm(calculatedFormData, "Local SSD"));
        form.setOperationSystem(StringUtils.searchInListByTerm(calculatedFormData, "Operating System"));
        form.setCommitmentTerm(StringUtils.searchInListByTerm(calculatedFormData, "Commitment term"));
        form.setRegion(StringUtils.searchInListByTerm(calculatedFormData, "Region"));
        form.setProvisioningModel(StringUtils.searchInListByTerm(calculatedFormData, "Provisioning model"));
        form.setEstimatedComponentCostPerMonth(StringUtils.searchInListByTerm(calculatedFormData, "Estimated Component Cost"));
        form.setTotalEstimatedCostPerMonth(totalMonthlyPrice);
//            TODO: delete sout. I want to send only the data in form
//        for (String str : calculatedFormData) {
//            System.out.println(str);
//        }
//        System.out.println(form.getRegion());
//        System.out.println(form.getCommitmentTerm());
//        System.out.println(form.getProvisioningModel());
//        System.out.println(form.getInstanceType());
//        System.out.println(form.getOperationSystem());
//        System.out.println(form.getLocalSSD());
//        System.out.println(form.getEstimatedComponentCostPerMonth());
//        System.out.println(form.getTotalEstimatedCostPerMonth());

        return form;
    }
}
