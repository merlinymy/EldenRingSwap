package com.merlinymy.eldenringitemswap.service;

import com.merlinymy.eldenringitemswap.entity.CharacterSlots;
import com.merlinymy.eldenringitemswap.entity.Weapons;
import com.merlinymy.eldenringitemswap.payload.HexCodeDTO;
import com.merlinymy.eldenringitemswap.payload.ItemDTO;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

public interface GenerateHexCodeService {
    String getWeaponHexByName(String weaponName);

    String getCharacterHexBySlot(int slotNum);
    String generateSwapWeaponHexCode(HexCodeDTO hexCodeDTO);

    String getItemHexByName(String itemName);
    String generateSwapItemHexCode(HexCodeDTO hexCodeDTO);

}
