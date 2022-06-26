package com.merlinymy.eldenringitemswap.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class CharacterSlots {
    @Id
    private Long id;

    private int characterSlot;
    private String YYYYYYYY;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CharacterSlots characterSlots = (CharacterSlots) o;
        return id != null && Objects.equals(id, characterSlots.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
