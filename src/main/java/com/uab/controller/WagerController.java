package com.uab.controller;

import com.uab.model.Wager;
import com.uab.service.WagerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@AllArgsConstructor
public class WagerController {

    private final WagerService service;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("wagers", service.getAll());
        return "index";
    }

    @GetMapping("/register-bet")
    public String registerBetPage(Model model) {
        model.addAttribute("wager", new Wager());
        return "register-bet";
    }

    @PostMapping("/addwager")
    public String addWager(@Valid Wager wager, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/register-bet";
        }

        wager.setAmount(10);
        service.register(wager);

        return "redirect:/index";
    }
}