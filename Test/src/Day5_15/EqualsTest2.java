package Day5_15;

import java.util.Objects;

public class EqualsTest2 {
    public static void main(String[] args) {
        Address address = new Address("广州","番禺区","512220");
        Address address1 = new Address("广州","番禺区","512220");
        User user = new User("张三",address);
        User user1 = new User("张三",address1);
        System.out.println(user.equals(user1));
    }
}
class User{
    String name;
    Address address;

    public User() {
    }

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && address.equals(user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
class Address{
    String city;
    String street;
    String zipcode;

    public Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        if (o == null || !(o instanceof Address)) return false;
        Address address = (Address) o;
        return city.equals(address.city) &&
                street.equals(address.street) &&
                zipcode.equals(address.zipcode);
    }
}