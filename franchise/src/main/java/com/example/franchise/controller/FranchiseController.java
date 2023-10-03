package com.example.franchise.controller;

import com.example.franchise.entity.Franchise;
import com.example.franchise.service.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/franchise")
public class FranchiseController {

    @Autowired
    private final FranchiseService franchiseService;

    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @GetMapping("/application")
    public ModelAndView form() {
        return new ModelAndView("index", "franchise", new Franchise());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("franchise") Franchise franchise) {
        franchiseService.create(franchise);
        return "redirect:/franchise/application?success";
    }
}
