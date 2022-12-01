package com.epam.training.Nastassia_Stanchyk.webdriver.task1;

import java.util.Objects;

public class PasteFormOptions {

    private String pasteText;
    private String pasteTitle;
    private String pasteExpirationTime;

    public PasteFormOptions(String pasteText, String pasteTitle, String pasteExpirationTime) {
        this.pasteText = pasteText;
        this.pasteTitle = pasteTitle;
        this.pasteExpirationTime = pasteExpirationTime;
    }

    public String getPasteText() {
        return pasteText;
    }

    public void setPasteText(String pasteText) {
        this.pasteText = pasteText;
    }

    public String getPasteTitle() {
        return pasteTitle;
    }

    public void setPasteTitle(String pasteTitle) {
        this.pasteTitle = pasteTitle;
    }

    public String getPasteExpirationTime() {
        return pasteExpirationTime;
    }

    public void setPasteExpirationTime(String pasteExpirationTime) {
        this.pasteExpirationTime = pasteExpirationTime;
    }

    @Override
    public String toString() {
        return "PasteFormOptions{" +
                "pasteText='" + pasteText + '\'' +
                ", pasteTitle='" + pasteTitle + '\'' +
                ", pasteExpirationTime='" + pasteExpirationTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasteFormOptions that = (PasteFormOptions) o;
        return Objects.equals(pasteText, that.pasteText) &&
                Objects.equals(pasteTitle, that.pasteTitle) &&
                Objects.equals(pasteExpirationTime, that.pasteExpirationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pasteText, pasteTitle, pasteExpirationTime);
    }
}
