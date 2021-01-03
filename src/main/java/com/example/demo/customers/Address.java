package com.example.demo.customers;

public class Address {

    private Integer addressId;
    private Country country;
    private City city;
    private Street street;

    public Address(Integer addressId, Country country, City city, Street street) {
        this.addressId = addressId;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Address() {
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
}
