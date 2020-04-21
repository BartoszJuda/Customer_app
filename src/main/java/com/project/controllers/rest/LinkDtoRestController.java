package com.project.controllers.rest;

import com.project.commons.CreatorXLS;
import com.project.models.dtos.LinkDto;
import com.project.services.LinkDtoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@CrossOrigin
public class LinkDtoRestController {

    public LinkDtoService linkDtoService;

    public LinkDtoRestController(LinkDtoService linkDtoService) {
        this.linkDtoService = linkDtoService;
    }

    @GetMapping("/api/links/dto")
    public List<LinkDto> getLinks(){
        return linkDtoService.getLinks();
    }

    @PostMapping("/api/links/dto")
    public ResponseEntity<LinkDto> createLink(@RequestBody LinkDto linkDto){
        LinkDto result = linkDtoService.create(linkDto);

        if (result == null){
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/api/links/dto/xls")
    public List<LinkDto> getLinksToXlsFile(){
        List<LinkDto> series = linkDtoService.getLinks();

        CreatorXLS<LinkDto> creatorXLS = new CreatorXLS<>(LinkDto.class);
        try{
            creatorXLS.createFile(linkDtoService.getLinks(), "src/main/resources/", "links");
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
            return  null;
        }
        return series;
    }

    @DeleteMapping("/api/links/dto/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return linkDtoService.delete(id);
    }

    @PutMapping("/api/links/dto/{id}")
    public LinkDto update(@PathVariable long id, @RequestBody LinkDto linkDto){
        return linkDtoService.update(id, linkDto);
    }
}
