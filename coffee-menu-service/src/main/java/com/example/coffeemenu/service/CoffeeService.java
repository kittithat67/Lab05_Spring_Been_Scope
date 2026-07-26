package com.example.coffeemenu.service;
import com.example.coffeemenu.model.Coffee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeService {

    private List<Coffee> coffees = new ArrayList<>();
    private Long nextId = 3L;

    public CoffeeService(){
        coffees.add(new Coffee(1L,"Espresso", 45.0));
        coffees.add(new Coffee(2L,"Latte", 55.0));

    }

    //GET All
    public List<Coffee> getCoffees(){
        return coffees;
    }

    //GET By ID
    public Coffee getCoffee(Long id){
        for (Coffee coffee : coffees){
            if(coffee.getId().equals(id)){
                return coffee;
            }
        }
        return null;
    }

    //POST
    public Coffee addCoffee(Coffee coffee){
        coffee.setId(nextId);
        nextId++;

        coffees.add(coffee);
        return coffee;
    }



    //PUT
    public Coffee updateCoffee(Long id, Coffee updateCoffee){
        Coffee coffee = getCoffee(id);

        if(coffee == null){
            return null;
        }

        coffee.setName(updateCoffee.getName());
        coffee.setPrice(updateCoffee.getPrice());

        return coffee;
    }

    //DELETE
    public boolean deleteCoffee(Long id){
        Coffee coffee = getCoffee(id);

        if(coffee == null){
            return false;
        }

        coffees.remove(coffee);
        return true;

    }

    


}
