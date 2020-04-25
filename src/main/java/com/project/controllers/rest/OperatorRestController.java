package com.project.controllers.rest;

import com.project.models.Operator;
import com.project.services.OperatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class OperatorRestController {

    private OperatorService operatorService;

    public OperatorRestController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping("/api/links/operators")
    public List<Operator> getOperators() {
        return operatorService.getOperators();
    }

    @PostMapping("/api/links/operators")
    public Operator createOperator(@RequestBody Operator operator) {
        return operatorService.createOperator(operator);
    }

    @PutMapping("/api/links/operators/{id}")
    public Operator updateOperator(@PathVariable long id, @RequestBody Operator operator) {
        return operatorService.updateOperator(id, operator);
    }

    @DeleteMapping("/api/links/operators/{id}")
    public ResponseEntity<?> deleteOperator(@PathVariable long id) {
        return operatorService.deleteOperator(id);
    }
}
