package ru.job4j.passport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import ru.job4j.passport.models.Passport;
import ru.job4j.passport.services.PassportService;

@SpringBootApplication
public class PassportApplication {

    private final PassportService passportService;

    public PassportApplication(PassportService passportService) {
        this.passportService = passportService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PassportApplication.class, args);
    }

    @KafkaListener(
            topics = "passport",
            groupId = "app.3",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(Passport passport) {
        passportService.create(passport);
    }
}
