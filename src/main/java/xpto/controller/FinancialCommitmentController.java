package xpto.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xpto.service.FinancialCommitmentService;

@RestController
@RequestMapping("/financial-commitment")
@AllArgsConstructor
public class FinancialCommitmentController {

    private final FinancialCommitmentService service;

    @GetMapping("/company/{id}")
    public double calculateFinancialCommitment(@PathVariable int id) {
        return service.getFinancialCommitment(id);
    }

}
