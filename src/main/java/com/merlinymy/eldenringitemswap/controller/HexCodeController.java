package com.merlinymy.eldenringitemswap.controller;

import com.merlinymy.eldenringitemswap.payload.HexCodeDTO;
import com.merlinymy.eldenringitemswap.service.impl.GenerateHexImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/generateHex")
public class HexCodeController {
    private GenerateHexImpl generateHex;
    public HexCodeController(GenerateHexImpl generateHex) {
        this.generateHex = generateHex;
    }

    @GetMapping("/weaponSwap")
    public ResponseEntity<String> getWeaponSwapHex (@RequestBody HexCodeDTO hexCodeDTO) {
        return new ResponseEntity<>(generateHex.generateSwapWeaponHexCode(hexCodeDTO), HttpStatus.OK);
    }

    @GetMapping("/itemSwap")
    public ResponseEntity<String> getItemSwapHex (@RequestBody HexCodeDTO hexCodeDTO) {
        return new ResponseEntity<>(generateHex.generateSwapItemHexCode(hexCodeDTO), HttpStatus.OK);
    }
}
