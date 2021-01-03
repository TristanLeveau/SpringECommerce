package com.example.demo.customers;

public class City {

    private Integer cityId;
    private String cityName;
    private Integer postalCode;

    public City() {

    }

    public City(Integer cityId, String cityName, Integer postalCode) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.postalCode = postalCode;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
}
