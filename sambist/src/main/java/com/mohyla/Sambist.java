package com.mohyla;

@GenerateAthleteInfo(sport = "Judo")
public class Sambist {
    private String name;

    @ValidateAge(min = 5, max = 65)
    private int age;

    public Sambist(String name, int age) {
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
        return "Sambo";
    }
}