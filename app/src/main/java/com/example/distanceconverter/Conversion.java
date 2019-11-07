package com.example.distanceconverter;

public class Conversion {
    public String distanceConverter (String sMiles,String sInches, String sFeet) {
        try {
            double miles = Double.parseDouble(sMiles);
            double inches = Double.parseDouble(sInches);
            double feet = Double.parseDouble(sFeet);
            double result = (miles*5280*12*2.54) + (inches*2.54) + (feet*12*2.54);
            return String.format("%3.2f", result);
        } catch (NumberFormatException nfe) {
            return "Result";
        }
    }
}
