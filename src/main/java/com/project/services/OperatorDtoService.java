package com.project.services;

import com.project.mapper.OperatorDtoMapper;
import com.project.models.Operator;
import com.project.models.dtos.OperatorDto;
import com.project.repositories.OperatorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperatorDtoService {

    private static final Logger logger = LoggerFactory.getLogger(OperatorService.class);

    private OperatorRepository operatorRepository;
    private OperatorDtoMapper operatorDtoMapper;

    public OperatorDtoService(OperatorRepository operatorRepository, OperatorDtoMapper operatorDtoMapper) {
        this.operatorRepository = operatorRepository;
        this.operatorDtoMapper = operatorDtoMapper;
    }

    public List<OperatorDto> getOperators(){
        List<OperatorDto> operatorDtos = new ArrayList<>();
        operatorRepository
                .findAll()
                .forEach(o -> operatorDtos.add(operatorDtoMapper.map(o)));
        return operatorDtos;
    }

    public OperatorDto create(OperatorDto operatorDto){
        logger.info("Recieved operatorDto {}", operatorDto);
        Operator operator = new Operator();
        operator.setOperatorName(operatorDto.getOperatorName());

        logger.info("Try to save Operator to DB {}", operator);
        Operator result = operatorRepository.save(operator);
        if (result == null){
            logger.error("Error while saving Operator to DB!");
            return null;
        }
        return operatorDtoMapper.map(operator);
    }
}
