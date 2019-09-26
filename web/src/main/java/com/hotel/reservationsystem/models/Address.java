package com.hotel.reservationsystem.models;

public class Address {
    private String streetName;
    private int houseNumber;
    private String addition;
    private String zipCode;
    private String city;
    private String country;

    public Address(String streetName, int houseNumber, String addition, String zipCode, String city, String country) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.addition = addition;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
