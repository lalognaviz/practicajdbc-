package com.projectodb.practicaJdbc.repositorio;

import com.projectodb.practicaJdbc.modelos.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CustomerRepo {

    @Autowired
    private JdbcTemplate template;


    public int getCant(){
        String sql= "SELECT COUNT(*) FROM customer";

        return template.queryForObject(sql, Integer.class);
    }

    public List<Customer> findByName(String name){
        String sql= "SELECT * FROM customer WHERE first_name=?";
        return template.query(sql,new Object[]{name},((rs, rowNum) -> new Customer(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)
        ) ) );
    }
    public int getCantByName(String name){
        String sql= "SELECT COUNT(*) FROM customer WHERE first_name=?";
        return template.queryForObject(sql,new Object[]{name}, Integer.class);
    }

    public Customer insertCustomer(Customer customer){
        String sql="insert into customer (first_name, last_name) values(?,?)";
        template.update(sql,customer.getFirstName(),customer.getLastName());
        return customer;

    }

    public boolean deleteById(int id){

        String sql= "delete from customer where id=?";
        return template.update(sql,new Object[]{id})==1;
    }

    public int getCantByNyL(String name,int id){
        String sql= "SELECT COUNT(*) FROM customer WHERE first_name=? and id=?";
        return template.queryForObject(sql,new Object[]{name,id}, Integer.class);
    }

}





