package com.demonstrate.concepts.polymorphism.example1;

public class AppleIphone6s extends AppleIphone {

    protected static final String MANUFACTURED_IN = "Malaysia";
    protected int noOfCameras = 3;

    public AppleIphone6s(int height, int width, int length, int screenLength, int screenWidth, boolean homeButton) {
        super(height, width, length, screenLength, screenWidth, homeButton);
    }

    public static void capturePhoto() {
        System.out.println("Photo taken by Iphone 6s");
    }

    @Override
    public String about() {
        final StringBuffer sb = new StringBuffer("AppleIphone6s{");
        sb.append("ManufacturedIn=").append(MANUFACTURED_IN);
        sb.append(", number of cameras =").append(noOfCameras);
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append(", length=").append(length);
        sb.append(", screenLength=").append(screenLength);
        sb.append(", screenWidth=").append(screenWidth);
        sb.append(", homeButton=").append(homeButton);
        sb.append('}');
        return sb.toString();
    }
}
