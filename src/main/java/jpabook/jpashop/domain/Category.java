package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))

    private List<Item> items = new ArrayList<>();

    //카테고리 계층 구조
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent") //같은 entity에 대해 매핑
    private List<Category> child = new ArrayList<>();
}
