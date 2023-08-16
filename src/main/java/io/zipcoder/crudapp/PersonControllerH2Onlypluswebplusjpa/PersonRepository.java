package io.zipcoder.crudapp.PersonControllerH2Onlypluswebplusjpa;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer>{


}
