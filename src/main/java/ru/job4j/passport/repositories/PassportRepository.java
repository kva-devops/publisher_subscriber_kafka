package ru.job4j.passport.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.passport.models.Passport;

public interface PassportRepository extends CrudRepository<Passport, Integer> {
}
