package xpto.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xpto.enums.PersonTypeEnum;
import xpto.repository.PersonRepository;

@Service
@Slf4j
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public void validateCompany(Long idCompany){
        if(repository.findByIdAndPersonType(idCompany, PersonTypeEnum.PJ.name()) == null){
            //ToDo exception
            throw new IllegalArgumentException("Empresa nao encontrada");
        }


    }

}
