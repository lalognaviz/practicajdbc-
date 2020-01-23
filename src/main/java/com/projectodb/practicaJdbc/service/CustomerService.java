package com.projectodb.practicaJdbc.service;

import com.projectodb.practicaJdbc.modelos.Customer;
import com.projectodb.practicaJdbc.repositorio.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo repo;

    public int getCant(){
        return repo.getCant();
    }

    public List<Customer> getCustomerByName(String nombre){return repo.findByName(nombre);}

    public int getCantByName(String nombre){
        return repo.getCantByName(nombre);
    }

    public Customer insertCust(Customer cust){return repo.insertCustomer(cust);}

    public boolean deleteById(int id){return repo.deleteById(id);}

    public int getcantNyL(String nombre, int ape){return repo.getCantByNyL(nombre,ape);}
}
