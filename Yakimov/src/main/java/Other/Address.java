package Other;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class Address {
    public Address() {
    }

    public String country;
    public String city;
    public String street;
    public int house;
    public int floor;
    public int flat;

    public Address(String country, String city, String street, int house, int floor, int flat){
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.floor = floor;
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", floor=" + floor +
                ", flat=" + flat +
                '}';
    }
}
