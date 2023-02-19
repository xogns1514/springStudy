package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter //값 타입은 변경 불가능하게 만들어야함, 따라서 setter제공 x
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address() {//jpa가 리플렉션과 같은 기술 사용을 위해 기본 생성자가 필요
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
