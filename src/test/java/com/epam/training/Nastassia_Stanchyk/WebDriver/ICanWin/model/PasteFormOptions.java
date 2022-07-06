package com.epam.training.Nastassia_Stanchyk.WebDriver.ICanWin.model;

import java.util.Objects;

public class PasteFormOptions {

    private final String PASTE_TEXT = "Hello from WebDriver";
    private final String PASTE_TITLE = "helloweb";
    private final String PASTE_EXPIRATION_TIME = "10 Minutes";

    public PasteFormOptions() {
    }

    public String getPASTE_TEXT() {
        return PASTE_TEXT;
    }

    public String getPASTE_TITLE() {
        return PASTE_TITLE;
    }

    public String getPASTE_EXPIRATION_TIME() {
        return PASTE_EXPIRATION_TIME;
    }

    @Override
    public String toString() {
        return "PasteFormOptions{" +
                "PASTE_TEXT='" + PASTE_TEXT + '\'' +
                ", PASTE_TITLE='" + PASTE_TITLE + '\'' +
                ", PASTE_EXPIRATION_TIME='" + PASTE_EXPIRATION_TIME + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasteFormOptions that = (PasteFormOptions) o;
        return PASTE_TEXT.equals(that.PASTE_TEXT) &&
                PASTE_TITLE.equals(that.PASTE_TITLE) &&
                PASTE_EXPIRATION_TIME.equals(that.PASTE_EXPIRATION_TIME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PASTE_TEXT, PASTE_TITLE, PASTE_EXPIRATION_TIME);
    }
}
