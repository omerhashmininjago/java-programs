package com.demonstrate.concepts.polymorphism.example1;

public class AppleIphone {

    protected int height;
    protected int width;
    protected int length;
    protected int screenLength;
    protected int screenWidth;
    protected boolean homeButton;
    protected static final String MANUFACTURED_IN = "California";
    protected int noOfCameras = 1;

    public AppleIphone(int height, int width, int length, int screenLength, int screenWidth, boolean homeButton) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.screenLength = screenLength;
        this.screenWidth = screenWidth;
        this.homeButton = homeButton;
    }

    public static void capturePhoto() {
        System.out.println("Photo taken by Iphone");
    }

    public String about() {
        final StringBuffer sb = new StringBuffer("AppleIphone{");
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
