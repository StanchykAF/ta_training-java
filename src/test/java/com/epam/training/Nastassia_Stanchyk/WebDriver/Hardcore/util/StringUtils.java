package com.epam.training.Nastassia_Stanchyk.WebDriver.Hardcore.util;

import java.util.List;

public class StringUtils {

    public static String searchInListByTerm(List<String> list, String term) {
        String result = "";
        if (list.isEmpty()) {
            return null;
        }
        for (String string : list) {
            if (string.contains(term)) {
                result = string;
                break;
            }
        }
        return result;
    }

    public static String createSearchStringForURL(String searchTerm) {
        return searchTerm.trim().replace("\s", "%20");
    }
}
