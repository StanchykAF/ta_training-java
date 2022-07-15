package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.service;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.CalculatedForm;

import java.util.List;

public class CreateCalculatedForm {

    public static CalculatedForm completeCalculatedForm(List<String> calculatedFormData, String totalMonthlyPrice) {
        CalculatedForm form = new CalculatedForm();
        form.setInstanceType(searchInList(calculatedFormData, "Instance type"));
        form.setLocalSSD(searchInList(calculatedFormData, "Local SSD"));
        form.setOperationSystem(searchInList(calculatedFormData, "Operating System"));
        form.setCommitmentTerm(searchInList(calculatedFormData, "Commitment term"));
        form.setRegion(searchInList(calculatedFormData, "Region"));
        form.setProvisioningModel(searchInList(calculatedFormData, "Provisioning model"));
        form.setEstimatedComponentCostPerMonth(searchInList(calculatedFormData, "Estimated Component Cost"));
        form.setTotalEstimatedCostPerMonth(totalMonthlyPrice);
//            TODO: delete sout
        for (String str : calculatedFormData) {
            System.out.println(str);
        }
        System.out.println(form.getRegion());
        System.out.println(form.getCommitmentTerm());
        System.out.println(form.getProvisioningModel());
        System.out.println(form.getInstanceType());
        System.out.println(form.getOperationSystem());
        System.out.println(form.getLocalSSD());
        System.out.println(form.getEstimatedComponentCostPerMonth());
        System.out.println(form.getTotalEstimatedCostPerMonth());

        return form;
    }

    private static String searchInList (List<String> list, String term) {
        String result = "";
        if (list.isEmpty()) {
            return null;
        }
        for (String string : list) {
            if (string.contains(term)) {
                list.remove(term);
                result = string.split(":")[1].trim();
                break;
            }
        }
        return result;
    }
}
