package com.LucasJ.GameProject.Game.Assets;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ColorGradientBuilder {
    private List<Color> colors;

    public ColorGradientBuilder(Color... colors) {
        if (colors.length < 2) {
            throw new IllegalArgumentException("At least two colors are required to create a gradient");
        }
        this.colors = List.of(colors);
    }

    public Color[] generateGradient(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Number of colors in the gradient must be at least 1");
        }

        List<Color> gradientColors = new ArrayList<>();
        int sections = colors.size() - 1;
        int totalColorsPerSection = n / sections;
        int remainingColors = n % sections;

        for (int i = 0; i < sections; i++) {
            Color startColor = colors.get(i);
            Color endColor = colors.get(i + 1);
            int colorsInThisSection = totalColorsPerSection + (remainingColors-- > 0 ? 1 : 0);
            for (int j = 0; j < colorsInThisSection; j++) {
                double ratio = (double) j / (colorsInThisSection - 1);
                Color interpolatedColor = interpolateColor(startColor, endColor, ratio);
                gradientColors.add(interpolatedColor);
            }
        }

        return gradientColors.toArray(new Color[0]);
    }

    private Color interpolateColor(Color startColor, Color endColor, double ratio) {
        int red = (int) (startColor.getRed() + ratio * (endColor.getRed() - startColor.getRed()));
        int green = (int) (startColor.getGreen() + ratio * (endColor.getGreen() - startColor.getGreen()));
        int blue = (int) (startColor.getBlue() + ratio * (endColor.getBlue() - startColor.getBlue()));
        return new Color(red, green, blue);
    }
}
