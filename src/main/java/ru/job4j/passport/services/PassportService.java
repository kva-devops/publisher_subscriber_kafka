package ru.job4j.passport.services;

import org.springframework.stereotype.Service;
import ru.job4j.passport.models.Passport;
import ru.job4j.passport.repositories.PassportRepository;

@Service
public class PassportService {
    private final PassportRepository passportRepository;

    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public Passport create(Passport passport) {
        Passport buff = Passport.of(
                passport.getName(),
                passport.getSeries()
        );
        return this.passportRepository.save(buff);
    }
}
