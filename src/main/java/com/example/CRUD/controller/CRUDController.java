package com.example.CRUD.controller;

import com.example.CRUD.queries.Queries;
import com.example.CRUD.model.Car;
import com.example.CRUD.model.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Api(value = "cars")
@RestController
@RequestMapping(value = "/cars")
@CrossOrigin
public class CRUDController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ApiOperation(value = "Get Cars")
    @ApiResponse(code = 200, message = "Successfully retrieving Car list")
    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        List<Car> carList = new ArrayList<>();
        String query=null;
        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(Queries.select_cars);
            for (Map<String, Object> row : rows) {
                Car car = new Car();
                car.setId((UUID) row.get("id"));
                car.setName((String)row.get("name"));
                car.setColor((String) row.get("color"));
                carList.add(car);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Car")
    @ApiResponse(code = 200, message = "Successfully deleted Car")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CommonResponse> deleteCar(@PathVariable UUID id) {
        CommonResponse response = new CommonResponse();
        try{
            jdbcTemplate.update(Queries.delete_car, id);
            response.setMessage("Deleted a car successfully.");
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Update Car")
    @ApiResponse(code = 200, message = "Successfully updated Car")
    @PutMapping(value = "/{id}")
    public ResponseEntity<CommonResponse> updateCar(@PathVariable UUID id, @RequestBody Car car) {
        CommonResponse response = new CommonResponse();
        try{
            jdbcTemplate.update(Queries.update_car, car.getName(), car.getColor(), id);
            response.setMessage("Updated a car successfully.");
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Add car")
    @ApiResponse(code = 200, message = "Successfully added Car")
    @PostMapping
    public ResponseEntity<CommonResponse> addCar(@RequestBody Car car) {
        CommonResponse response = new CommonResponse();
        try{
            jdbcTemplate.update(Queries.add_car,UUID.randomUUID(), car.getName(), car.getColor());
            response.setMessage("Added a car successfully.");
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
