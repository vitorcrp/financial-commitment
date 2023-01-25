package xpto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinancialCommitmentService {

    private final PartnersService partnersService;

    public int returnPartners(Long companyId){
        var corporateStructure = partnersService.buildStructureByPartners();
        partnersService.bfs(Math.toIntExact(companyId), corporateStructure);

        return corporateStructure.getCorporateProperties();
    }

}
