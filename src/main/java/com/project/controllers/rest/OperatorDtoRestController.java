package com.project.controllers.rest;

import com.project.commons.CreatorXLS;
import com.project.models.dtos.OperatorDto;
import com.project.services.OperatorDtoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@CrossOrigin
@RestController
public class OperatorDtoRestController {

    private OperatorDtoService operatorDtoService;

    public OperatorDtoRestController(OperatorDtoService operatorDtoService) {
        this.operatorDtoService = operatorDtoService;
    }

    @GetMapping("/api/links/operator/dto")
    public List<OperatorDto> getOperators() {
        return operatorDtoService.getOperators();
    }

    @GetMapping("/api/links/operator/dto/xls")
    public List<OperatorDto> getOperatorsToXlsFile() {
        List<OperatorDto> series = operatorDtoService.getOperators();

        CreatorXLS<OperatorDto> creatorXLS = new CreatorXLS<>(OperatorDto.class);
        try {
            creatorXLS.createFile(operatorDtoService.getOperators(), "src/main/resources/", "operators");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return series;
    }

    @PostMapping("/api/operators/dto")
    public ResponseEntity<OperatorDto> createOperator(@RequestBody OperatorDto operatorDto) {
        OperatorDto result = operatorDtoService.create(operatorDto);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
