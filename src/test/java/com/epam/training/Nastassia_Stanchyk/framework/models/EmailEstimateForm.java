package com.epam.training.Nastassia_Stanchyk.framework.models;

import java.util.Objects;

public class EmailEstimateForm {
    private String emailAddress;

    public static class Builder {
        private String emailAddress;

        private Builder() {}

        private Builder(EmailEstimateForm form) {
            this.emailAddress = form.emailAddress;
        }

        public Builder withEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public EmailEstimateForm build() {
            EmailEstimateForm form = new EmailEstimateForm();
            form.setEmailAddress(emailAddress);
            return form;
        }
    }

    public Builder edit() {
        return new Builder(this);
    }

    public static Builder create() {
        return new Builder();
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "EmailEstimateForm{" +
                "emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailEstimateForm that = (EmailEstimateForm) o;
        return Objects.equals(emailAddress, that.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }

    private void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
