package com.demonstrate.concepts.polymorphism.example1;

public class BuildIphone {

    public static void main(String[] args) {

        AppleIphone appleIphone = new AppleIphone5(1, 4, 10, 8, 4, true);
        //Will override as its Objects behavior - Runtime Realization
        System.out.println(appleIphone.about());
        //Will not override as its class behavior - Enforced at Compiletime
        appleIphone.capturePhoto();
        //Below four sysouts demonstrate concept of Hiding - compiler needs to know what type of casting is needed at compile itself
        System.out.println("Manufactured in :: " + appleIphone.MANUFACTURED_IN);
        System.out.println("Number of cameras :: " + appleIphone.noOfCameras);
        System.out.println("Manufactured in :: " + ((AppleIphone5) appleIphone).MANUFACTURED_IN);
        System.out.println("Number of cameras :: " + ((AppleIphone5) appleIphone).noOfCameras);

        System.out.println("---------------------------------------------------------------------------");

        AppleIphone5 appleIphone5 = new AppleIphone5(1, 4, 10, 8, 4, true);
        //Will override as its Objects behavior - Runtime Realization
        System.out.println(appleIphone5.about());
        //This one is a little different than the above example -
        //here the object created belongs to subclass and not the parent class
        //Below three will override the class behavior - Enforced at Compiletime
        appleIphone5.capturePhoto();
        System.out.println("Manufactured in :: " + appleIphone5.MANUFACTURED_IN);
        System.out.println("Number of cameras :: " + appleIphone5.noOfCameras);

        System.out.println("---------------------------------------------------------------------------");

        AppleIphone appleIphone6s = new AppleIphone6s(1, 4, 10, 8, 4, true);
        //Will override as its Objects behavior - Runtime Realization
        System.out.println(appleIphone6s.about());
        //Will not override as its class behavior - Enforced at Compiletime
        appleIphone6s.capturePhoto();
        //Below four sysouts demonstrate concept of Hiding - compiler needs to know what type of casting is needed at compile itself
        System.out.println("Manufactured in :: " + appleIphone6s.MANUFACTURED_IN);
        System.out.println("Number of cameras :: " + appleIphone6s.noOfCameras);
        System.out.println("Manufactured in :: " + ((AppleIphone6s) appleIphone6s).MANUFACTURED_IN);
        System.out.println("Number of cameras :: " + ((AppleIphone6s) appleIphone6s).noOfCameras);
    }
}
