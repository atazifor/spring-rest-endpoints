package org.spring.start.restservices.controller;

import org.spring.start.restservices.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/cm")
    public Country cameroon() {
        return Country.of("Cameroon", 25);
    }

    @GetMapping("/all")
    public List<Country> countries() {
        Country c1 = Country.of("Nigeria", 270);
        Country c2 = Country.of("Tchad", 15);
        return List.of(c1, c2);
    }
}
