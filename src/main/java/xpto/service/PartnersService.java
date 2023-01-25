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
                .forEach(partner -> comporateStructure.addCorporateRelation(partner.getIdPessoa(), partner.getIdPartner()));

        return comporateStructure;
    }

    //ToDo improve algorithm

    void bfs(int companyId, CorporateStructureModel corporateStructureModel) {
        
        var visited = new boolean[corporateStructureModel.getVertex()];

        // Create a queue for BFS
        var queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[companyId] = true;
        queue.add(companyId);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            companyId = queue.poll();

            incrementPropertie(companyId, corporateStructureModel);

            // Get all adjacent vertices of the dequeued
            // vertex companyId If a adjacent has not been visited,
            // then mark it visited and enqueue it
            for (int n : corporateStructureModel.getPartners()[companyId]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void incrementPropertie(int partnerId, CorporateStructureModel corporateStructureModel){
        var partner = personRepository.findById((long) partnerId).get();
        corporateStructureModel.addCorporateProperties(partner.getProperties());
    }



}
