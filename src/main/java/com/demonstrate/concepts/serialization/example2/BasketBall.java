package com.demonstrate.concepts.serialization.example2;

import java.io.Serializable;

public class BasketBall implements Serializable {

    // To make sure the Sender and Receiver load the same instance of the class
    private static final long serialVersionUID = 8988888999l;

    // Static fields do not take part in serialization
    // After deserialization this field will be set back to 2 i.e. default value
    // Irrespective if had got its value changed before serialization;
    private static long baskets = 2;

    private int courtLength = 30;

    private int courtWidth = 10;

    private int basketHeight = 12;

    // Transient fields do not take part in Serialization
    // After deserialization this field will be set to 0 as its a default value of int primitive data type
    // if it were Reference to another object then it would have been set as null
    private transient int noOfPlayers = 10;

    public static void setBaskets(long baskets) {
        BasketBall.baskets = baskets;
    }

    public void setCourtLength(int courtLength) {
        this.courtLength = courtLength;
    }

    public void setCourtWidth(int courtWidth) {
        this.courtWidth = courtWidth;
    }

    public void setBasketHeight(int basketHeight) {
        this.basketHeight = basketHeight;
    }

    public void setNoOfPlayers(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }
}
