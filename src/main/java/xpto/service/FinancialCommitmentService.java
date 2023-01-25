package xpto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinancialCommitmentService {

    private final PartnersService partnersService;
    private final PersonService personService;

    public double getFinancialCommitment(int companyId){
        personService.validateCompany(companyId);
        var corporateStructure = partnersService.buildStructureByPartners();
        partnersService.throughCorporateStructure(companyId, corporateStructure);
        return corporateStructure.getCorporateProperties();
    }

}
