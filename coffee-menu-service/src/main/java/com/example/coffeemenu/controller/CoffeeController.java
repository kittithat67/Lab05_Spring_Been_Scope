package com.example.coffeemenu.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeemenu.model.Coffee;
import com.example.coffeemenu.service.CoffeeService;

@RestController
@RequestMapping("/coffees")

public class CoffeeController {
    
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping       //getALL
    public List<Coffee> getCoffees() {
        return coffeeService.getCoffees();
    }

    @GetMapping("/{id}")      //getById
    public ResponseEntity<Coffee> getById(@PathVariable Long id) {
        Coffee result = coffeeService.getCoffee(id);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Coffee> create(@RequestBody Coffee coffee) {
        Coffee created = coffeeService.addCoffee(coffee);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable Long id, @RequestBody Coffee coffee) {
        Coffee updated = coffeeService.updateCoffee(id, coffee);
        if (updated != null) {
        return ResponseEntity.ok(updated);
    } else {
        return ResponseEntity.notFound().build();
    }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean removed = coffeeService.deleteCoffee(id);
        if (removed) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
