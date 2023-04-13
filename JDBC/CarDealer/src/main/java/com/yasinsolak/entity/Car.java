package com.yasinsolak.entity;

public class Car {

    private long id;
    private String brand;
    private String carModel;
    private String modelYear;
    private long dealerShipId;
    
     public Car(String brand, String carModel, String modelYear) {
        this.brand = brand;
        this.carModel = carModel;
        this.modelYear = modelYear;
    }

    public Car(long id, String brand, String carModel, String modelYear, long dealerShipId) {
        this.id = id;
        this.brand = brand;
        this.carModel = carModel;
        this.modelYear = modelYear;
        this.dealerShipId = dealerShipId;
    }

    public Car(String brand, String carModel, String modelYear, long dealerShipId) {
        this.brand = brand;
        this.carModel = carModel;
        this.modelYear = modelYear;
        this.dealerShipId = dealerShipId;
    }

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public long getDealerShipId() {
        return dealerShipId;
    }

    public void setDealerShipId(long dealerShipId) {
        this.dealerShipId = dealerShipId;
    }

    @Override
    public String toString() {
        return "car{" + "id=" + id + ", brand=" + brand + ", carModel=" + carModel + ", modelYear=" + modelYear + ", dealerShipId=" + dealerShipId + '}';
    }

}
