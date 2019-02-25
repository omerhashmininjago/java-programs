package com.demonstrate.concepts.serialization.example2;

import java.io.Serializable;

public class BasketBall implements Serializable {

    // To make sure the Sender and Receiver load the same instance of the class
    private static final long serialVersionUID = 8988888999l;

    // Static fields do not take part in serialization
    // After deserialization this field will be set back to 2 i.e. default value
    // If the value of this field had changed to 10 before Serialization
    // and the JVM was not restarted, the value be restored as 10 after deserialization
    // But if the JVM got restarted, the value will be restored as 2 after deserialization
    // Any changes after serialization will be not considered
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
