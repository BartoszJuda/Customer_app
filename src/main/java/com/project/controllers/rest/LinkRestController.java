package com.project.controllers.rest;

import com.project.models.Link;
import com.project.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class LinkRestController {

    private LinkService linkService;

    public LinkRestController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/api/links")
    public List<Link> getLinks(){
        return linkService.getLinks();
    }

    @GetMapping("/api/links/{id}")
    public Link getLinks(@PathVariable long id){
        return linkService.getLinkById(id);
    }

    @PostMapping("/api/links")
    public Link createLink(@RequestBody Link link){
        return linkService.createLink(link);
    }

    @PutMapping("/api/links/{id}")
    public Link updateLink(@PathVariable long id, @RequestBody Link link){
        return linkService.updateLink(id, link);
    }

    @DeleteMapping("api/links/{id}")
    public ResponseEntity<?> deleteLink(@PathVariable long id){
        return linkService.deleteLink(id);
    }
}
