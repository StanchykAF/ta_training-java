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
        return form;
    }
}
