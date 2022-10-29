package com.example.webshop.models;

import com.example.webshop.service.ShopService;

import java.util.*;
import java.util.stream.Collectors;

public class GamesModifier {

    public static List<Game> availableGames (){
        List<Game> availableGames = ShopService.getGames().stream()
                                                          .filter(x->x.getQuantity()!=0)
                                                          .collect(Collectors.toList());
        return availableGames;
    }

    public static List<Game> sortedByPrice (){
        List<Game> sortedGames = ShopService.getGames().stream()
                                                       .sorted(Comparator.comparingInt(Game::getPrice)).collect(Collectors.toList());
                                                     //.sorted((x,y)->x.getPrice() - y.getPrice()).collect(Collectors.toList());
        return sortedGames;
    }

    public static List<Game> containsOpen (){
        List<Game> containsOpen = ShopService.getGames().stream()
                                                     .filter(x->x.getDescription().contains("open"))
                                                     .collect(Collectors.toList());
        return containsOpen;
    }

    public static int avgStock (){
        IntSummaryStatistics statistics = ShopService.getGames().stream()
                                                     .mapToInt((x) -> (x.getQuantity())).summaryStatistics();
        return (int)statistics.getAverage();
    }
    public static List<Game> mostExpensive (){
        IntSummaryStatistics statistics = ShopService.getGames().stream()
                .mapToInt((x) -> (x.getPrice())).summaryStatistics();

        List<Game> mostExpensive = ShopService.getGames().stream()
                                                    .filter(x->x.getQuantity()!=0)
                                                    .filter(x->x.getPrice()==statistics.getMax())
                                                    .collect(Collectors.toList());
        return mostExpensive;
    }

    public static List<Game> searchedWord (String word){
        List<Game> searchedWord = ShopService.getGames().stream()
                                                        .filter(x->x.getDescription().toLowerCase(Locale.ROOT).contains(word.toLowerCase(Locale.ROOT)))
                                                        .collect(Collectors.toList());
        return searchedWord;
    }

    // Extended Web modifiers

    public static List<Game> rpgTitles (){
        List<Game> rpgTitles = ShopService.getGamesExtended().stream()
                    .filter(x->x.getGenre().equals("RPG"))
                    .collect(Collectors.toList());
        return rpgTitles;
    }

    public static List<Game> fpsTitles (){
        List<Game> fpsTitles = ShopService.getGamesExtended().stream()
                    .filter(x->x.getGenre().equals("FPS"))
                    .collect(Collectors.toList());
        return fpsTitles;
    }

    public static List<Game> actionTitles (){
        List<Game> actionTitles = ShopService.getGamesExtended().stream()
                    .filter(x->x.getGenre().equals("Action-adventure"))
                    .collect(Collectors.toList());
        return actionTitles;
    }

    public static List<Game> filterNumber (int number, String value){
        List<Game> filterNumbers = new ArrayList<>();
        if (value.equals("Above")) {
            filterNumbers = ShopService.getGamesExtended().stream()
                    .filter(x->x.getPrice()>number)
                    .collect(Collectors.toList());
        } else if (value.equals("Below")) {
            filterNumbers = ShopService.getGamesExtended().stream()
                    .filter(x->x.getPrice()<number)
                    .collect(Collectors.toList());
        } else if (value.equals("Exactly")) {
            filterNumbers = ShopService.getGamesExtended().stream()
                    .filter(x->x.getPrice()==number)
                    .collect(Collectors.toList());
        }
        return filterNumbers;
    }

}
