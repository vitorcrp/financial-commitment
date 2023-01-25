package xpto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xpto.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByIdAndPersonType(int id, String personType);

}
