package xpto.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xpto.service.FinancialCommitmentService;

@RestController
@AllArgsConstructor
public class FinancialCommitmentController {

    private final FinancialCommitmentService service;

    @GetMapping("/financial-commitment/company/{id}")
    public double calculateFinancialCommitment(@PathVariable Long id) {
        return service.getFinancialCommitment(id);
    }

}
