package com.merlinymy.eldenringitemswap.repository;

import com.merlinymy.eldenringitemswap.entity.Weapons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface WeaponsHexCodeRepo extends JpaRepository<Weapons, String> {
    Weapons findWeaponsByWeaponName(String weaponName);
}
