package com.merlinymy.eldenringitemswap.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

@Entity
public class Weapons {
    @Id
    private Long id;
    @Column(name = "weaponNNNN")
    private String weaponNNNN;
    @Column(name = "weaponXXXXXXXX")
    private String weaponXXXXXXXX;
    @Column(name = "weaponCategory")
    private String category;
    @Column(name = "weaponName")
    private String weaponName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Weapons weapon = (Weapons) o;
        return id != null && Objects.equals(id, weapon.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
