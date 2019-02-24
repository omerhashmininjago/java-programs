package com.demonstrate.concepts.multhithreading.example5;

import java.util.Objects;

public final class FoodPlate {

    private final boolean isMainCourseReady;
    private final boolean isDesertReady;
    private final StaffName plateServerBy;
    private final long orderNumber;

    public FoodPlate(boolean isMainCourseReady, boolean isDesertReady, StaffName plateServerBy, long orderNumber) {
        this.isMainCourseReady = isMainCourseReady;
        this.isDesertReady = isDesertReady;
        this.plateServerBy = plateServerBy;
        this.orderNumber = orderNumber;
    }

    public long getOrderNumber() {
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

}
