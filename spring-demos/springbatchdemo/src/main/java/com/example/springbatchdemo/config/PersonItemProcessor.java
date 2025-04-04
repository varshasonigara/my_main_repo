package com.example.springbatchdemo.config;

import com.example.springbatchdemo.business.Person;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person>{
    @Override
    public Person process(Person item) throws Exception {
        return new Person(item.firstName().toUpperCase(), item.lastName().toUpperCase());
    }
}
