package com.project.services;

import com.project.exceptions.ResourceNotFoundException;
import com.project.models.Link;
import com.project.repositories.LinkRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {

    private LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> getLinks() {
        return linkRepository.findAll();
    }

    public Link createLink(Link link) {
        return linkRepository.save(link);
    }

    public Link getLinkById(long id) {
        return linkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("link by id: " + id + " not found"));
    }

    public Link updateLink(long id, Link link) {
        return linkRepository.findById(id).map(l -> {
            l.setLinkName(link.getLinkName());
            l.setZipCodeA(link.getZipCodeA());
            l.setZipCodeB(link.getZipCodeB());
            l.setCityA(link.getCityA());
            l.setCityB(link.getCityB());
            l.setStreetA(link.getStreetA());
            l.setStreetB(link.getStreetB());
            l.setSubscriptionFee(link.getSubscriptionFee());
            l.setLinkLength(link.getLinkLength());
            l.setDescription(link.getDescription());
            l.setTechnology(link.getTechnology());
            l.setOperator(link.getOperator()); //zakomentować
            return linkRepository.save(l);
        }).orElseThrow(() -> new ResourceNotFoundException("Link by id: " + id + " not found"));
    }

    public ResponseEntity<?> deleteLink(long id) {
        return linkRepository.findById(id).map(l -> {
            linkRepository.deleteById(id);
            return new ResponseEntity<>("Link by id" + id + " deleted successfully!", HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("Link by id: " + id + " not found"));
    }
}
