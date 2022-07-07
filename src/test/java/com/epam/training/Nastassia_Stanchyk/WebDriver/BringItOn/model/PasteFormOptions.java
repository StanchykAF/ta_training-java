package com.epam.training.Nastassia_Stanchyk.WebDriver.BringItOn.model;

import java.util.Objects;

public class PasteFormOptions {

    private String pasteText;
    private String pasteTitle;
    private String pasteExpirationTime;
    private String syntaxHighlight;

    public PasteFormOptions(String pasteText, String pasteTitle, String pasteExpirationTime, String syntaxHighlight) {
        this.pasteText = pasteText;
        this.pasteTitle = pasteTitle;
        this.pasteExpirationTime = pasteExpirationTime;
        this.syntaxHighlight = syntaxHighlight;
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

    public String getSyntaxHighlight() {
        return syntaxHighlight;
    }

    public void setSyntaxHighlight(String syntaxHighlight) {
        this.syntaxHighlight = syntaxHighlight;
    }

    @Override
    public String toString() {
        return "PasteFormOptions{" +
                "pasteText='" + pasteText + '\'' +
                ", pasteTitle='" + pasteTitle + '\'' +
                ", pasteExpirationTime='" + pasteExpirationTime + '\'' +
                ", syntaxHighlight='" + syntaxHighlight + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasteFormOptions that = (PasteFormOptions) o;
        return Objects.equals(pasteText, that.pasteText) &&
                Objects.equals(pasteTitle, that.pasteTitle) &&
                Objects.equals(pasteExpirationTime, that.pasteExpirationTime) &&
                Objects.equals(syntaxHighlight, that.syntaxHighlight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pasteText, pasteTitle, pasteExpirationTime, syntaxHighlight);
    }
}
