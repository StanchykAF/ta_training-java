package com.epam.training.Nastassia_Stanchyk.framework.service;

import com.epam.training.Nastassia_Stanchyk.framework.models.CalculatedForm;
import com.epam.training.Nastassia_Stanchyk.framework.util.StringUtils;

import java.util.List;

public class CreateCalculatedForm {

    public static CalculatedForm completeCalculatedForm(List<String> calculatedFormData, String totalMonthlyPrice) {
        CalculatedForm form = CalculatedForm.create()
                .withInstanceType(StringUtils.searchInListByTerm(calculatedFormData, "Instance type"))
                .withLocalSSD(StringUtils.searchInListByTerm(calculatedFormData, "Local SSD"))
                .withOperationSystem(StringUtils.searchInListByTerm(calculatedFormData, "Operating System"))
                .withCommitmentTerm(StringUtils.searchInListByTerm(calculatedFormData, "Commitment term"))
                .withRegion(StringUtils.searchInListByTerm(calculatedFormData, "Region"))
                .withProvisioningModel(StringUtils.searchInListByTerm(calculatedFormData, "Provisioning model"))
                .withEstimatedComponentCostPerMonth(StringUtils.searchInListByTerm(calculatedFormData, "Estimated Component Cost"))
                .withTotalEstimatedCostPerMonth(totalMonthlyPrice)
                .build();
        return form;
    }
}
