package xpto.service;

import org.springframework.stereotype.Service;
import xpto.model.CorporateStructureModel;
import xpto.repository.PartnersRepository;
import xpto.repository.PersonRepository;

import java.util.LinkedList;

@Service
public class PartnersService {

    private final PartnersRepository repository;
    private final PersonRepository personRepository;

    public PartnersService(PartnersRepository repository, PersonRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    public CorporateStructureModel buildStructureByPartners(){
        var partnersList = repository.findAll();
        var personNumbers = personRepository.count();
        var comporateStructure = new CorporateStructureModel((int) personNumbers);

        partnersList
                .forEach(
                        partner -> comporateStructure.addCorporateRelation(
                                        partner.getIdPerson(), partner.getIdPartner()
                                )
                );

        return comporateStructure;
    }

    void throughCorporateStructure(int companyId, CorporateStructureModel corporateStructureModel) {
        var visitedVertex = new boolean[corporateStructureModel.getVertex()];
        var queue = new LinkedList<Integer>();

        visitedVertex[companyId] = true;
        queue.add(companyId);

        while (!queue.isEmpty()) {
            companyId = queue.poll();
            incrementPropertie(companyId, corporateStructureModel);

            for (int n : (Iterable<Integer>) corporateStructureModel.getPartners()[companyId]) {
                if (!visitedVertex[n]) {
                    visitedVertex[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void incrementPropertie(int partnerId, CorporateStructureModel corporateStructureModel){
        var partner = personRepository.findById(partnerId).get();
        corporateStructureModel.addCorporateProperties(partner.getProperties());
    }

}
