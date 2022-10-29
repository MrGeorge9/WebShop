package com.example.webshop.controllers;

import com.example.webshop.models.GamesModifier;
import com.example.webshop.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShopController {

    @GetMapping("/games")
    public String showShop (Model model){
        model.addAttribute("games", ShopService.getGames());
        return "index";
    }

    @GetMapping("/available")
    public String showAvailableGames (Model model){
        model.addAttribute("games", GamesModifier.availableGames());
        return "index";
    }

    @GetMapping("/cheapest")
    public String sortGamesByPrice (Model model){
        model.addAttribute("games", GamesModifier.sortedByPrice());
        return "index";
    }

    @GetMapping("/open")
    public String containsOpen (Model model){
        model.addAttribute("games", GamesModifier.containsOpen());
        return "index";
    }

    @GetMapping("/average")
    public String averageStock (Model model){
        model.addAttribute("average", GamesModifier.avgStock());
        return "index";
    }

    @GetMapping("/mostExpensive")
    public String mostExpensive (Model model){
        model.addAttribute("games", GamesModifier.mostExpensive());
        return "index";
    }

    @GetMapping("/search")
    public String search (Model model){
        return "index";
    }

    @PostMapping("/search")
    public String searchWord (Model model, @RequestParam(name = "word") String word){
        model.addAttribute("games", GamesModifier.searchedWord(word));
        return "index";
    }

    // Extended Web controllers

    @GetMapping("/gamesExtended")
    public String showExtendedShop (Model model){
        model.addAttribute("gamesExtended", ShopService.getGamesExtended());
        model.addAttribute("currency", ShopService.getCurrencymodifier());
        return "indexExtended";
    }

    @GetMapping("/rpg")
    public String rpgTitles (Model model){
        model.addAttribute("gamesExtended", GamesModifier.rpgTitles());
        model.addAttribute("currency", ShopService.getCurrencymodifier());
        return "indexExtended";
    }

    @GetMapping("/fps")
    public String fpsTitles (Model model){
        model.addAttribute("gamesExtended", GamesModifier.fpsTitles());
        model.addAttribute("currency", ShopService.getCurrencymodifier());
        return "indexExtended";
    }

    @GetMapping("/action")
    public String actionTitles (Model model){
        model.addAttribute("gamesExtended", GamesModifier.actionTitles());
        model.addAttribute("currency", ShopService.getCurrencymodifier());
        return "indexExtended";
    }

    @GetMapping("/euro")
    public String euro (Model model){
        ShopService.setCurrencymodifier('e');
        model.addAttribute("gamesExtended", ShopService.getGamesExtended());
        model.addAttribute("currency", ShopService.getCurrencymodifier());
        return "indexExtended";
    }

    @GetMapping("/dollar")
    public String dollar (Model model){
        ShopService.setCurrencymodifier('d');
        model.addAttribute("gamesExtended", ShopService.getGamesExtended());
        model.addAttribute("currency", ShopService.getCurrencymodifier());
        return "indexExtended";
    }

    @GetMapping("/filter")
    public String filter (Model model){
        return "indexExtended";
    }

    @PostMapping("/filter")
    public String filterByValue (Model model, @RequestParam(name = "number") int number, @RequestParam(name = "inputButton") String value){
        model.addAttribute("gamesExtended", GamesModifier.filterNumber(number, value));
        model.addAttribute("currency", ShopService.getCurrencymodifier());
        return "indexExtended";
    }
}
