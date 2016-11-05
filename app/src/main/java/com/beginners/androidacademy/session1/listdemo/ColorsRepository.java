package com.beginners.androidacademy.session1.listdemo;

/**
 * Created by Britt on 05/11/2016.
 */

public class ColorsRepository {

    public static class ColorEntry {
        String name;
        String color;

        public ColorEntry(String name, String color) {
            this.name = name;
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public String getName() {
            return name;
        }
    }

    public static ColorEntry[] getColorsArray() {
        ColorEntry[] array = {
                new ColorEntry("Red", "#F44336"),
                new ColorEntry("Pink", "#E91E63"),
                new ColorEntry("Purple", "#9C27B0"),
                new ColorEntry("Deep Purple", "#673AB7"),
                new ColorEntry("Indigo", "#3F51B5"),
                new ColorEntry("Blue", "#2196F3"),
                new ColorEntry("Light Blue", "#03A9F4"),
                new ColorEntry("Cyan", "#00BCD4"),
                new ColorEntry("Teal", "#009688"),
                new ColorEntry("Green", "#4CAF50"),
                new ColorEntry("Light Green", "#8BC34A"),
                new ColorEntry("Lime", "#CDDC39"),
                new ColorEntry("Yellow", "#FFEB3B"),
                new ColorEntry("Amber", "#FFC107"),
                new ColorEntry("Orange", "#FF9800"),
                new ColorEntry("Deep Orange", "#FF5722"),
                new ColorEntry("Brown", "#795548")
        };
        return array;
    }

}
