package com.example.CRUD.queries;

public class Queries {

    // created private constructor So that object for this class can't be created from outside of this class.
    private Queries() {
    }

    public static final String select_cars = "SELECT id as id, name as name, color as color FROM crud.cars";

    public static final String delete_car = "DELETE FROM crud.cars WHERE id = ?";

    public static final String update_car = "UPDATE crud.cars set name = ?, color = ? where id = ?";

    public static final String add_car = "INSERT into crud.cars(id, name, color) values(?, ?, ?)";
}
