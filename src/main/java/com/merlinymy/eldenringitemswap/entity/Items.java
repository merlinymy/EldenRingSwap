package com.merlinymy.eldenringitemswap.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

@Entity
@Table(name = "items")
public class Items {
    @Id
    private Long id;
    @Column(name = "itemXXXX")
    private String itemXXXX;
    @Column(name = "itemNNNN")
    private String itemNNNN;
    @Column(name = "itemCategory")
    private String itemCategory;
    @Column(name = "itemName")
    private String itemName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Items item = (Items) o;
        return id != null && Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
