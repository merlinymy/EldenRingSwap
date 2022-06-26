package com.merlinymy.eldenringitemswap.repository;

import com.merlinymy.eldenringitemswap.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsHexCodeRepo extends JpaRepository<Items, String> {
    Items findItemsByItemName(String name);
}
