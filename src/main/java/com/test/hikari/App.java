package com.test.hikari;

import com.test.hikari.daoimpl.PersonDAOImpl;
import com.test.hikari.entities.Person;
import com.test.hikari.util.Hikari;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Hikari Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Hikari.initHikariDs();
        PersonDAOImpl pdi = new PersonDAOImpl();
        List<Person> persons = pdi.selectAll();
        for(Person person : persons) {
            System.out.println(person.getId()+", "+person.getFirstName()+ ", "+ person.getLastName());
        }




        //java 8 random ex
        //sort in previous verison
        List<String> names= Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names);
        System.out.println(names);
    }
}
