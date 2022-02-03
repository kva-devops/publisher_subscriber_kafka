package ru.job4j.application.models;

import java.util.Objects;

public class Passport {
    private String series;
    private String name;

    public Passport(String series, String name) {
        this.series = series;
        this.name = name;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(series, passport.series) &&
                Objects.equals(name, passport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(series, name);
    }
}

