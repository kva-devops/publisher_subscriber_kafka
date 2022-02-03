package ru.job4j.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.application.models.Passport;

@RestController
@RequestMapping("/app")
public class PassportController {

    @Autowired
    private KafkaTemplate<Integer, Passport> kafkaTemplate;

    @PostMapping("/create-passport")
    public ResponseEntity<Void> create(@RequestBody Passport passport) {
        kafkaTemplate.send("passport", passport);
        return ResponseEntity.ok().build();
    }
}
