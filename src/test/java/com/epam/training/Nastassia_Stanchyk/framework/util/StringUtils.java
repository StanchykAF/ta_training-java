package com.epam.training.Nastassia_Stanchyk.framework.util;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

public class StringUtils {

    public static String searchInListByTerm(List<String> list, String term) {
        if (list.isEmpty()) {
            return null;
        }
        return list.stream().filter(str -> str.contains(term))
                .toList().get(0);
    }

    public static String copySelectedText() {
        String copiedText = "";
        try {
            copiedText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        return copiedText;
    }

    public static String createSearchStringForURL(String searchTerm) {
        return searchTerm.trim().replace("\s", "%20");
    }
}
