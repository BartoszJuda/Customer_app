package com.project.services;

import com.project.exceptions.ResourceNotFoundException;
import com.project.mapper.LinkDtoMapper;
import com.project.mapper.OperatorDtoMapper;
import com.project.models.Link;
import com.project.models.Operator;
import com.project.models.dtos.LinkDto;
import com.project.repositories.LinkRepository;
import com.project.repositories.OperatorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@EnableJpaRepositories("com.project.repositories")
public class LinkDtoService {

    private static final Logger logger = LoggerFactory.getLogger(LinkDtoService.class);

    private LinkRepository linkRepository;
    private LinkDtoMapper linkDtoMapper;
    private OperatorDtoMapper operatorDtoMapper;
    private OperatorRepository operatorRepository;

    public LinkDtoService(LinkRepository linkRepository, LinkDtoMapper linkDtoMapper, OperatorDtoMapper operatorDtoMapper, OperatorRepository operatorRepository) {
        this.linkRepository = linkRepository;
        this.linkDtoMapper = linkDtoMapper;
        this.operatorDtoMapper = operatorDtoMapper;
        this.operatorRepository = operatorRepository;
    }

    public List<LinkDto> getLinks() {
        List<LinkDto> linkDtos = new ArrayList<>();
        linkRepository.findAll().forEach(l -> {
            linkDtos.add(linkDtoMapper.map(l));
        });
        return linkDtos;
    }

    public LinkDto create(LinkDto linkDto) {
        logger.info("Received linkDto {}", linkDto);
        Link link = new Link();
        link.setCityA(linkDto.getCityA());
        link.setCityB(linkDto.getCityB());
        link.setLinkName(linkDto.getLinkName());
        link.setZipCodeA(linkDto.getZipCodeA());
        link.setZipCodeB(linkDto.getZipCodeB());
        link.setDescription(linkDto.getDescription());
        link.setStreetA(linkDto.getStreetA());
        link.setStreetB(linkDto.getStreetB());
        link.setLinkLength(linkDto.getLinkLength());
        link.setSubscriptionFee(linkDto.getSubscriptionFee());
        link.setTechnology(linkDto.getTechnology());

        Operator operator = operatorRepository.findOperatorByOperatorName(linkDto.getOperator());
       // if (operator == null) {
        //    logger.error("Error while getting Operator!");
         //   return null;
       // }

        link.setOperator(operator);
        logger.info("Try to save Link to DB {}", link);
        Link result = linkRepository.save(link);
        if (result == null) {
            logger.error("Error while saving Link to DB!");
            return null;
        }
        return linkDtoMapper.map(link);
    }

    public ResponseEntity<?> delete(long id) {
        return linkRepository.findById(id).map(l -> {
            linkRepository.deleteById(id);
            return new ResponseEntity<>("Link by id " + id + " deleted succesfully!", HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("Link by id: " + id + " not found"));
    }

     public LinkDto update(long id, LinkDto linkDto) {
        return linkRepository.findById(id).map(l -> {
            l.setLinkName(linkDto.getLinkName());
            l.setZipCodeA(linkDto.getZipCodeA());
            l.setZipCodeB(linkDto.getZipCodeB());
            l.setCityA(linkDto.getCityA());
            l.setCityB(linkDto.getCityB());
            l.setStreetA(linkDto.getStreetA());
            l.setStreetB(linkDto.getStreetB());
            l.setSubscriptionFee(linkDto.getSubscriptionFee());
            l.setLinkLength(linkDto.getLinkLength());
            l.setDescription(linkDto.getDescription());
            l.setTechnology(linkDto.getTechnology());
            Operator operator = operatorRepository.findOperatorByOperatorName(linkDto.getOperator());
            l.setOperator(operator);
            linkRepository.save(l);
             return linkDtoMapper.map(l);
     }).orElseThrow(() -> new ResourceNotFoundException("Link by id: "+ id + " not found"));
 }
}
