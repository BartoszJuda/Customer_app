package com.project.services;

import com.project.exceptions.ResourceNotFoundException;
import com.project.models.Operator;
import com.project.repositories.OperatorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorService {

    private OperatorRepository operatorRepository;

    public OperatorService(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    public List<Operator> getOperators() {
        return operatorRepository.findAll();
    }

    public Operator createOperator(Operator operator) {
        return operatorRepository.save(operator);
    }

    public Operator updateOperator(long id, Operator operator) {
        return operatorRepository.findById(id).map(o -> {
            o.setOperatorName(o.getOperatorName());
            return operatorRepository.save(o);
        }).orElseThrow(() -> new ResourceNotFoundException("Operator by id: " + id + " not found"));
    }

    public ResponseEntity<?> deleteOperator(long id) {
        return operatorRepository.findById(id).map(o -> {
            operatorRepository.deleteById(id);
            return new ResponseEntity<>("Operator by id:" + id + " deleted successfully!", HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("Operator by id" + id + " not found"));
    }
}
