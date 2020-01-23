package com.projectodb.practicaJdbc.controller;

import com.projectodb.practicaJdbc.modelos.Customer;
import com.projectodb.practicaJdbc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/cantidad")
    public int cant() {
        return customerService.getCant();

    }

    @GetMapping("/{name}")
    public List<Customer> byName(@PathVariable(value="name")String nombre){
        return customerService.getCustomerByName(nombre);}


    @GetMapping("/cant/{name}")
    public int cantByName(@PathVariable(value="name")String nombre){
        return customerService.getCantByName(nombre);
        }

    @GetMapping("/cant/{name}/{ape}")
    public int cantNyL(@PathVariable(value="name")String nombre, @PathVariable(value="ape") int ape){
        return customerService.getcantNyL(nombre,ape);
    }

    @PostMapping("/insert")
    public Customer insertcust(@Valid @RequestBody Customer customer ){
        return customerService.insertCust(customer);

    }

    @DeleteMapping("/del/{id}")
    public boolean delById(@PathVariable(value="id")int id){
        return customerService.deleteById(id);
    }

}

