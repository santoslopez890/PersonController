package io.zipcoder.crudapp.PersonControllerH2Onlypluswebplusjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonRepository people;

    @RequestMapping(value = "/people",method = RequestMethod.POST)
    ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(people.save(p), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/people/{id}",method = RequestMethod.GET)
    ResponseEntity<Person> getPerson(@PathVariable int id) {
        return new ResponseEntity<Person>(people.findById(id).get(),HttpStatus.OK);
    }
    @RequestMapping(value = "/people",method = RequestMethod.GET)
    ResponseEntity<List<Person>> getPersonList() {
        List<Person> personList = new ArrayList<>();
        people.findAll().forEach(personList::add);
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }
    @RequestMapping (value = "/people/{id}",method = RequestMethod.PUT)
    ResponseEntity<Person> updatePerson(Person p){
        return new ResponseEntity<>(people.save(p), HttpStatus.OK);
    }
    @RequestMapping(value = "/people/{id}",method = RequestMethod.DELETE)
    void DeletePerson(@PathVariable int id) {
        people.deleteById(id);
    }
}
