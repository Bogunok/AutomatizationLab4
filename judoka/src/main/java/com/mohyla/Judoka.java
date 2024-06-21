package com.mohyla;

@GenerateAthleteInfo(sport = "Judo")
public class Judoka {
    private String name;

    @ValidateAge(min = 18, max = 40)
    private int age;

    public Judoka(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSport() {
        return "Judo";
    }
}