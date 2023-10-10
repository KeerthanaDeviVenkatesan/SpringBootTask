package com.example.RestApi.service.Impl;

import com.example.RestApi.entity.Person;
import com.example.RestApi.repository.PersonRepo;
import com.example.RestApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepo personRepo;

    @Override
    public Person createPerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    @Cacheable(value = "persons", key = "#root.methodName")
    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }

    @Override
    @Cacheable(value = "persons", key = "#id")
    public Person getPersonById(Long id) {
        return personRepo.findById(id).orElse(null);
    }

    @Override
    @CachePut(value = "persons", key = "#person.id")
    public Person updatePerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    @CacheEvict(value = "persons", key = "#id")
    public void deletePerson(Long id) {
        personRepo.deleteById(id);
    }
}
