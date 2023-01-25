package xpto.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xpto.model.CorporateStructure;
import xpto.repository.PartnersRepository;
import xpto.repository.PersonRepository;

import java.util.Iterator;
import java.util.LinkedList;

@Service
@Slf4j
public class PartnersService {

    private final PartnersRepository repository;
    private final PersonRepository personRepository;

    public PartnersService(PartnersRepository repository, PersonRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    public CorporateStructure buildStructureByPartners(){
        var partnersList = repository.findAll();

        var personNumbers = personRepository.count();

        var comporateStructure = new CorporateStructure((int) personNumbers);

        partnersList.stream()
                .forEach(partner -> comporateStructure.addCorporateRelation(partner.getIdPessoa(), partner.getIdPartner()));

        return comporateStructure;
    }

    void bfs(int companyId, CorporateStructure corporateStructure) {
        
        boolean visited[] = new boolean[corporateStructure.getVertex()];

        // Create a queue for BFS
        var queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[companyId] = true;
        queue.add(companyId);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            companyId = queue.poll();

            incrementPropertie(companyId, corporateStructure);

            // Get all adjacent vertices of the dequeued
            // vertex companyId If a adjacent has not been visited,
            // then mark it visited and enqueue it
            Iterator<Integer> i = corporateStructure.getPartners()[companyId].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void incrementPropertie(int partnerId, CorporateStructure corporateStructure){
        var partner = personRepository.findById((long) partnerId).get();
        corporateStructure.addCorporateProperties(partner.getProperties());
    }



}
