package com.demonstrate.concepts.multhithreading.example5;

import java.util.Objects;

public class FoodPlate {

    private boolean isMainCourseReady;
    private boolean isDesertReady;
    private StaffName plateServerBy;
    private double orderNumber;

    public FoodPlate(boolean isMainCourseReady, boolean isDesertReady, StaffName plateServerBy, double orderNumber) {
        this.isMainCourseReady = isMainCourseReady;
        this.isDesertReady = isDesertReady;
        this.plateServerBy = plateServerBy;
        this.orderNumber = orderNumber;
    }

    public boolean isMainCourseReady() {
        return isMainCourseReady;
    }

    public boolean isDesertReady() {
        return isDesertReady;
    }

    public double getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FoodPlate{");
        sb.append("isMainCourseReady=").append(isMainCourseReady);
        sb.append(", isDesertReady=").append(isDesertReady);
        sb.append(", plateServerBy=").append(plateServerBy);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodPlate)) return false;
        FoodPlate foodPlate = (FoodPlate) o;
        return isMainCourseReady == foodPlate.isMainCourseReady &&
                isDesertReady == foodPlate.isDesertReady &&
                Double.compare(foodPlate.orderNumber, orderNumber) == 0 &&
                Objects.equals(plateServerBy, foodPlate.plateServerBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isMainCourseReady, isDesertReady, plateServerBy, orderNumber);
    }

    public StaffName getPlateServerBy() {
        return plateServerBy;
    }

}
