package com.epam.training.Nastassia_Stanchyk.framework.models;

import java.util.Objects;

public class CalculatedForm {

    private String region;
    private String commitmentTerm;
    private String provisioningModel;
    private String instanceType;
    private String operationSystem;
    private String localSSD;
    private String estimatedComponentCostPerMonth;
    private String totalEstimatedCostPerMonth;

    public static class Builder {
        private String region;
        private String commitmentTerm;
        private String provisioningModel;
        private String instanceType;
        private String operationSystem;
        private String localSSD;
        private String estimatedComponentCostPerMonth;
        private String totalEstimatedCostPerMonth;

        private Builder() {
        }

        private Builder(CalculatedForm form) {
            this.region = form.region;
            this.commitmentTerm = form.commitmentTerm;
            this.provisioningModel = form.provisioningModel;
            this.instanceType = form.instanceType;
            this.operationSystem = form.operationSystem;
            this.localSSD = form.localSSD;
            this.estimatedComponentCostPerMonth = form.estimatedComponentCostPerMonth;
            this.totalEstimatedCostPerMonth = form.totalEstimatedCostPerMonth;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withCommitmentTerm(String commitmentTerm) {
            this.commitmentTerm = commitmentTerm;
            return this;
        }

        public Builder withProvisioningModel(String provisioningModel) {
            this.provisioningModel = provisioningModel;
            return this;
        }

        public Builder withInstanceType(String instanceType) {
            this.instanceType = instanceType;
            return this;
        }

        public Builder withOperationSystem(String operationSystem) {
            this.operationSystem = operationSystem;
            return this;
        }

        public Builder withLocalSSD(String localSSD) {
            this.localSSD = localSSD;
            return this;
        }

        public Builder withEstimatedComponentCostPerMonth(String estimatedComponentCostPerMonth) {
            this.estimatedComponentCostPerMonth = estimatedComponentCostPerMonth;
            return this;
        }

        public Builder withTotalEstimatedCostPerMonth(String totalEstimatedCostPerMonth) {
            this.totalEstimatedCostPerMonth = totalEstimatedCostPerMonth;
            return this;
        }

        public CalculatedForm build() {
            CalculatedForm form = new CalculatedForm();
            form.setRegion(region);
            form.setCommitmentTerm(commitmentTerm);
            form.setInstanceType(instanceType);
            form.setLocalSSD(localSSD);
            form.setOperationSystem(operationSystem);
            form.setProvisioningModel(provisioningModel);
            form.setEstimatedComponentCostPerMonth(estimatedComponentCostPerMonth);
            form.setTotalEstimatedCostPerMonth(totalEstimatedCostPerMonth);
            return form;
        }
    }

    public Builder edit() {
        return new Builder(this);
    }

    public static Builder create() {
        return new Builder();
    }

    public String getRegion() {
        return region;
    }

    public String getCommitmentTerm() {
        return commitmentTerm;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getEstimatedComponentCostPerMonth() {
        return estimatedComponentCostPerMonth;
    }

    public String getTotalEstimatedCostPerMonth() {
        return totalEstimatedCostPerMonth;
    }

    @Override
    public String toString() {
        return "CalculatedForm{" +
                "region='" + region + '\'' +
                ", commitmentTerm='" + commitmentTerm + '\'' +
                ", provisioningModel='" + provisioningModel + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", operationSystem='" + operationSystem + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", estimatedComponentCostPerMonth='" + estimatedComponentCostPerMonth + '\'' +
                ", totalEstimatedCostPerMonth='" + totalEstimatedCostPerMonth + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculatedForm form = (CalculatedForm) o;
        return Objects.equals(region, form.region) && Objects.equals(commitmentTerm, form.commitmentTerm) &&
                Objects.equals(provisioningModel, form.provisioningModel) && Objects.equals(instanceType, form.instanceType) &&
                Objects.equals(operationSystem, form.operationSystem) && Objects.equals(localSSD, form.localSSD) &&
                Objects.equals(estimatedComponentCostPerMonth, form.estimatedComponentCostPerMonth) &&
                Objects.equals(totalEstimatedCostPerMonth, form.totalEstimatedCostPerMonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, commitmentTerm, provisioningModel, instanceType, operationSystem, localSSD,
                estimatedComponentCostPerMonth, totalEstimatedCostPerMonth);
    }

    private void setRegion(String region) {
        this.region = region;
    }

    private void setCommitmentTerm(String commitmentTerm) {
        this.commitmentTerm = commitmentTerm;
    }

    private void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    private void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    private void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    private void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    private void setEstimatedComponentCostPerMonth(String estimatedComponentCostPerMonth) {
        this.estimatedComponentCostPerMonth = estimatedComponentCostPerMonth;
    }

    private void setTotalEstimatedCostPerMonth(String totalEstimatedCostPerMonth) {
        this.totalEstimatedCostPerMonth = totalEstimatedCostPerMonth;
    }
}
