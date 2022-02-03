package ru.job4j.passport.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.passport.models.Passport;
import ru.job4j.passport.services.PassportService;

@RestController
@RequestMapping("/")
public class PassportController {
    private final PassportService passportService;

    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @PostMapping("/save")
    public ResponseEntity<Passport> create(@RequestBody Passport passport) {
        return new ResponseEntity<>(
                passportService.create(passport),
                HttpStatus.CREATED
        );
    }
}
