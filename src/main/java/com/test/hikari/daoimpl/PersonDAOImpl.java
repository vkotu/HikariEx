package com.test.hikari.daoimpl;

import com.test.hikari.dao.PersonDAO;
import com.test.hikari.entities.Person;
import com.test.hikari.util.Hikari;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kotu on 8/18/16.
 */
public class PersonDAOImpl implements PersonDAO {


    public List<Person> selectAll() {

        Connection connnection = null;
        PreparedStatement statement = null;
        List<Person> persons = new ArrayList<Person>();
        ResultSet resultSet = null;

        try {
            connnection = Hikari.getConnection();
            statement = connnection.prepareStatement("Select * from person");
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Person p = new Person();
                p.setId(resultSet.getInt("id"));
                p.setFirstName(resultSet.getString("first_name"));
                p.setLastName(resultSet.getString("last_name"));
                persons.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(connnection != null) {
                    connnection.close();
                }
                if(statement != null) {
                    statement.close();
                }
                if(resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return persons;
    }
}
