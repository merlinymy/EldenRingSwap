package com.merlinymy.eldenringitemswap.repository;

import com.merlinymy.eldenringitemswap.entity.CharacterSlots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterHexCodeRepo extends JpaRepository<CharacterSlots, Integer> {
    CharacterSlots findCharacterSlotsByCharacterSlot(int characterSlot);
}
