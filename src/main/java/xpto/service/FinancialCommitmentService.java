package xpto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinancialCommitmentService {

    private final PartnersService partnersService;
    private final PersonService personService;

    public double getFinancialCommitment(Long companyId){
        personService.validateCompany(companyId);
        var corporateStructure = partnersService.buildStructureByPartners();
        partnersService.bfs(Math.toIntExact(companyId), corporateStructure);
        return corporateStructure.getCorporateProperties();
    }

}
