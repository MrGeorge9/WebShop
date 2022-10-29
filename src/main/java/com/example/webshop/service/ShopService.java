package com.example.webshop.service;

import com.example.webshop.models.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ShopService {

    static char currencymodifier = 'e';
    static List<Game> games = new ArrayList<>(Arrays.asList(
            new Game("God of War", "Action-adventure", 2018, "Third person, open world game", 40, 79),
            new Game("Metro Last Light", "FPS", 2013, "First person, story driven game", 24, 36),
            new Game("Metro Exodus", "FPS", 2018, "First person, story driven game", 39, 58),
            new Game("The Witcher 3", "RPG", 2018, "Third person, open world game", 37, 82),
            new Game("Mafia", "Action-adventure", 2002, "Third person, story driven game", 18, 0),
            new Game("Skyrim", "RPG", 2011, "Third person, open world game", 36, 23)
            ));

    static List<Game> gamesExtendedEuro = new ArrayList<>(Arrays.asList(
            new Game("God of War", "Action-adventure", 2018, "Third person, open world game", 40, 79,87),
            new Game("Metro Last Light", "FPS", 2013, "First person, story driven game", 24, 36, 91),
            new Game("Metro Exodus", "FPS", 2018, "First person, story driven game", 39, 58, 86),
            new Game("The Witcher 3", "RPG", 2018, "Third person, open world game", 37, 82,97),
            new Game("Mafia", "Action-adventure", 2002, "Third person, story driven game", 18, 0,91),
            new Game("Skyrim", "RPG", 2011, "Third person, open world game", 36, 23, 92)
    ));

    static List<Game> gamesExtendedDollar = new ArrayList<>(Arrays.asList(
            new Game("God of War", "Action-adventure", 2018, "Third person, open world game", 42, 79,87),
            new Game("Metro Last Light", "FPS", 2013, "First person, story driven game", 25, 36, 91),
            new Game("Metro Exodus", "FPS", 2018, "First person, story driven game", 41, 58, 86),
            new Game("The Witcher 3", "RPG", 2018, "Third person, open world game", 39, 82,97),
            new Game("Mafia", "Action-adventure", 2002, "Third person, story driven game", 19, 0,91),
            new Game("Skyrim", "RPG", 2011, "Third person, open world game", 38, 23, 92)
    ));

    public static List<Game> getGamesExtended (){
        List<Game> gamesExtended;
        if (currencymodifier=='e') {
            gamesExtended = gamesExtendedEuro;
        } else {
            gamesExtended = gamesExtendedDollar;
        }
        return gamesExtended;
    }
    public static List<Game> getGames() {
        return games;
    }

    public static void setGames(List<Game> games) {
        ShopService.games = games;
    }

    public static char getCurrencymodifier() {
        return currencymodifier;
    }

    public static void setCurrencymodifier(char currencymodifier) {
        ShopService.currencymodifier = currencymodifier;
    }
}
