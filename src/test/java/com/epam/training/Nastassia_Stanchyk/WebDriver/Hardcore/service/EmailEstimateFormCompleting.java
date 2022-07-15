package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.service;

import com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.model.EmailEstimateForm;

public class EmailEstimateFormCompleting {

    public static EmailEstimateForm completeEmailEstimateForm (String emailAddress) {
        EmailEstimateForm form = new EmailEstimateForm();
        form.setEmailAddress(emailAddress);
        return form;
    }
}
