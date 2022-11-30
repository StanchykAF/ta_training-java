package com.epam.training.Nastassia_Stanchyk.framework.service;

import com.epam.training.Nastassia_Stanchyk.framework.models.EmailEstimateForm;

public class EmailEstimateFormCompleting {

    public static EmailEstimateForm completeEmailEstimateForm (String emailAddress) {
        EmailEstimateForm form = EmailEstimateForm.create()
                .withEmailAddress(emailAddress)
                .build();
        return form;
    }
}
