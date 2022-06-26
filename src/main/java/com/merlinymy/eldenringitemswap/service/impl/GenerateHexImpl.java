package com.merlinymy.eldenringitemswap.service.impl;

import com.merlinymy.eldenringitemswap.entity.CharacterSlots;
import com.merlinymy.eldenringitemswap.entity.Items;
import com.merlinymy.eldenringitemswap.entity.Weapons;
import com.merlinymy.eldenringitemswap.payload.HexCodeDTO;
import com.merlinymy.eldenringitemswap.payload.ItemDTO;
import com.merlinymy.eldenringitemswap.repository.CharacterHexCodeRepo;
import com.merlinymy.eldenringitemswap.repository.ItemsHexCodeRepo;
import com.merlinymy.eldenringitemswap.repository.WeaponsHexCodeRepo;
import com.merlinymy.eldenringitemswap.service.GenerateHexCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenerateHexImpl implements GenerateHexCodeService {
    private WeaponsHexCodeRepo weaponsHexCodeRepo;
    private CharacterHexCodeRepo characterHexCodeRepo;
    private ItemsHexCodeRepo itemsHexCodeRepo;

    @Autowired
    public GenerateHexImpl(WeaponsHexCodeRepo weaponsHexCodeRepo, CharacterHexCodeRepo characterHexCodeRepo, ItemsHexCodeRepo itemsHexCodeRepo) {
        this.weaponsHexCodeRepo = weaponsHexCodeRepo;
        this.characterHexCodeRepo = characterHexCodeRepo;
        this.itemsHexCodeRepo = itemsHexCodeRepo;
    }

    @Override
    public String getItemHexByName(String itemName) {
        Items items = itemsHexCodeRepo.findItemsByItemName(itemName);
        return items.getItemXXXX() + items.getItemNNNN();
    }

    @Override
    public String generateSwapItemHexCode(HexCodeDTO hexCodeDTO) {

        String characterHex = getCharacterHexBySlot(hexCodeDTO.getCharacterSlotNum());
        String oldItemHex = getItemHexByName(hexCodeDTO.getOldItemName());
        String newItemHex = getItemHexByName(hexCodeDTO.getNewItemName());

        String firstPart = "95000000" + " " + characterHex;
        String secPart = "88010006 0000" + oldItemHex.substring(0,4);
        String thirdPart = oldItemHex.substring(4) + "0000 00000000";
        String forthPart = "A8000002 00000004";
        String fifthPart = newItemHex + " " + "00000000";

        return firstPart + "\n" +
                secPart + "\n" +
                thirdPart + "\n" +
                forthPart + "\n" +
                fifthPart;
    }

    @Override
    public String generateSwapWeaponHexCode(HexCodeDTO hexCodeDTO) {

        String oldWeaponHex = getWeaponHexByName(hexCodeDTO.getOldWeaponName());
        String newWeaponHex = getWeaponHexByName(hexCodeDTO.getNewWeaponName());
        String characterHex = getCharacterHexBySlot(hexCodeDTO.getCharacterSlotNum());

        String swapHexFirstPart = "95000000" + " " +characterHex;
        String swapHexSecPart = "88010006" + " " + oldWeaponHex.substring(0, 8);
        String swapHexThirdPart = oldWeaponHex.substring(8)+"0000 00000000";
        String swapHexForthPart = "A8000000 00000006";
        String swapHexFifthPart = newWeaponHex.substring(0, 8) + " " + newWeaponHex.substring(8) + "0000";

        return swapHexFirstPart + "\n" +
                swapHexSecPart + "\n" +
                swapHexThirdPart + "\n" +
                swapHexForthPart + "\n" +
                swapHexFifthPart;
    }

    @Override
    public String getWeaponHexByName(String weaponName) {
        Weapons weapon =  weaponsHexCodeRepo.findWeaponsByWeaponName(weaponName);
        String weaponNNNN = weapon.getWeaponNNNN();
        String weaponXXXX = weapon.getWeaponXXXXXXXX();
        return weaponNNNN + weaponXXXX;
    }

    @Override
    public String getCharacterHexBySlot(int slotNum) {
        CharacterSlots characterSlots = characterHexCodeRepo.findCharacterSlotsByCharacterSlot(slotNum);
        return characterSlots.getYYYYYYYY();
    }
}
