package com.project.controllers;

import com.project.models.Link;
import com.project.services.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkController {

    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    public LinkController() {
    }

    @GetMapping("/links")
    public String getHomePage(Model model, @RequestParam(value = "message", required = false) String resultMessage) {
        String welcome = "Welcome in DATA TRANSMISSION database";
        model.addAttribute("welcome", welcome);
        model.addAttribute("resultMessage", resultMessage);
        model.addAttribute("links", linkService.getLinks());
        return "index";
    }

    @PostMapping("/links/add")
    public String addLink(@ModelAttribute Link incomeLink) {
        Link link = new Link();
        link.setLinkName(incomeLink.getLinkName());
        link.setZipCodeA(incomeLink.getZipCodeA());
        link.setZipCodeB(incomeLink.getZipCodeB());
        link.setCityA(incomeLink.getZipCodeA());
        link.setCityB(incomeLink.getCityB());
        link.setStreetA(incomeLink.getStreetA());
        link.setStreetB(incomeLink.getStreetB());
        link.setSubscriptionFee(incomeLink.getSubscriptionFee());
        link.setLinkLength(incomeLink.getLinkLength());
        link.setDescription(incomeLink.getDescription());
        link.setTechnology(incomeLink.getTechnology());
        String operationalResult = linkService.createLink(link).getLinkName();
        return "redirect:/links?message= create link: " + operationalResult;
    }

    @GetMapping("/links/delete")
    public String deleteLink(@RequestParam long id) {
        linkService.deleteLink(id);
        return "redirect:/links";
    }

    @GetMapping("/links/update")
    public String updateLink(@RequestParam long id, Model model) {
        Link link = linkService.getLinkById(id);
        if (link == null) {
            return "Cannot find a link!";
        }
        model.addAttribute("link", link);
        return "update";
    }

    @PostMapping("/links/update/confirm")
    public String updateLinkConfirm(@ModelAttribute Link incomeLink) {
        Link link = new Link();
        link.setId(incomeLink.getId());
        link.setLinkName(incomeLink.getLinkName());
        link.setZipCodeA(incomeLink.getZipCodeA());
        link.setZipCodeB(incomeLink.getZipCodeB());
        link.setCityA(incomeLink.getZipCodeA());
        link.setCityB(incomeLink.getCityB());
        link.setStreetA(incomeLink.getStreetA());
        link.setStreetB(incomeLink.getStreetB());
        link.setSubscriptionFee(incomeLink.getSubscriptionFee());
        link.setLinkLength(incomeLink.getLinkLength());
        link.setDescription(incomeLink.getDescription());
        link.setTechnology(incomeLink.getTechnology());
        String operationalResult = linkService.updateLink(incomeLink.getId(), link).getLinkName();
        return "redirect:/links?message= update link: " + operationalResult;
    }
}
