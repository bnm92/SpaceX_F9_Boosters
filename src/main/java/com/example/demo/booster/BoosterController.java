package com.example.demo.booster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/booster")
public class BoosterController {
    private final BoosterService boosterService;

    @Autowired
    public BoosterController(BoosterService boosterService) {
        this.boosterService = boosterService;
    }

    @GetMapping
    public List<Booster> getBoosters() {
        return boosterService.getBoosters();
    }

    @PostMapping
    public void registerNewBooster(@RequestBody Booster booster) {
        boosterService.addNewBooster(booster);
    }

    @DeleteMapping(path = "{boosterID}")
    public void deleteBooster(@PathVariable("boosterID") Long boosterID){
        boosterService.deleteBooster(boosterID);
    }

    @PutMapping(path = "{boosterID}")
    public void updateBooster(
            @PathVariable("boosterID") Long boosterID,
            @RequestParam(required = false) String serialNumber) {
        boosterService.updateBoosterSerialNumberByID(boosterID, serialNumber);
    }

}
