package com.test.hikari.dao;

import com.test.hikari.entities.Person;

import java.util.List;

/**
 * Created by kotu on 8/18/16.
 */
public interface PersonDAO {

    public List<Person> selectAll();

}
