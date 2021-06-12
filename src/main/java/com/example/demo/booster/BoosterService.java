package com.example.demo.booster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BoosterService {
    private final BoosterRepository boosterRepository;

    @Autowired
    public BoosterService(BoosterRepository boosterRepository) {
        this.boosterRepository = boosterRepository;
    }

    public List<Booster> getBoosters() {
        return boosterRepository.findAll();
    }

    public void addNewBooster(Booster booster) {
        final Optional<Booster> boosterOptional =
                boosterRepository.findBoosterBySerialNumber(booster.getSerialNumber());
        if (boosterOptional.isPresent()) throw  new IllegalStateException("booster already exists");
        boosterRepository.save(booster);
    }

    public void deleteBooster(Long boosterID) {
        boolean exists = boosterRepository.existsById(boosterID);
        if (!exists) throw new IllegalStateException("Booster with ID " + boosterID + " does not exist!");
        boosterRepository.deleteById(boosterID);
    }

    @Transactional
    public void updateBoosterSerialNumberByID(Long boosterID, String serialNumber) {
        Booster booster = boosterRepository.findById(boosterID).orElseThrow(() ->
                new IllegalStateException("Booster with ID " + boosterID + " does not exist!"));
        if (serialNumber != null &&
                serialNumber.length() > 0 &&
                !Objects.equals(booster.getSerialNumber(), serialNumber)) {
            booster.setSerialNumber(serialNumber);
        }
    }

}
