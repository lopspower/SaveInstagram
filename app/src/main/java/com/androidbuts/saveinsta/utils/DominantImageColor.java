package com.androidbuts.saveinsta.utils;

import android.graphics.Bitmap;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C) 2016 Mikhael LOPEZ
 * Licensed under the Apache License Version 2.0
 */
public class DominantImageColor {

    public static String getDominantColorOfImage(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        Map m = new HashMap();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = bitmap.getPixel(i, j);
                int[] rgbArr = getRGBArr(rgb);
                // Filter out grays....
                if (!isGray(rgbArr)) {
                    Integer counter = (Integer) m.get(rgb);
                    if (counter == null)
                        counter = 0;
                    counter++;
                    m.put(rgb, counter);
                }
            }
        }
        return getMostCommonColour(m);
    }

    private static String getMostCommonColour(Map map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        Map.Entry me = (Map.Entry) list.get(list.size() - 1);
        int[] rgb = getRGBArr((Integer) me.getKey());
        return "#" + Integer.toHexString(rgb[0]) + Integer.toHexString(rgb[1]) + Integer.toHexString(rgb[2]);
    }

    private static int[] getRGBArr(int pixel) {
        //int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        return new int[]{red, green, blue};
    }

    private static boolean isGray(int[] rgbArr) {
        int rgDiff = rgbArr[0] - rgbArr[1];
        int rbDiff = rgbArr[0] - rgbArr[2];
        // Filter out black, white and grays...... (tolerance within 10 pixels)
        int tolerance = 10;
        if (rgDiff > tolerance || rgDiff < -tolerance) {
            if (rbDiff > tolerance || rbDiff < -tolerance) {
                return false;
            }
        }
        return true;
    }
}
