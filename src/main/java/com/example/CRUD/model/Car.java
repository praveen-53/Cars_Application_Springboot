package com.example.CRUD.model;

import java.util.UUID;

public class Car {
    private UUID id;
    private String name;
    private String color;

    public Car() {
    }

    public Car(UUID id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
