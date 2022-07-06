package ru.netology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {


//    protected List<Player> players = new ArrayList<>();

    protected Map<String, Integer> players = new HashMap<>();

    public void registerPlayer(Player player) {
        players.put(player.getName(), player.strength);
    }

    public int findByName(String name) throws NotRegisteredException {
        if (!players.containsKey(name)) {
            throw new NotRegisteredException("Игрок " + name + " не зарегистрирован");
        }
        return players.get(name);
    }

    public int round(String name1, String name2) throws NotRegisteredException {

        int playerStrange1 = findByName(name1);
        int playerStrange2 = findByName(name2);

        if (playerStrange1 > playerStrange2) {
            return 1;
        }
        if (playerStrange1 < playerStrange2) {
            return 2;
        }
        return 0;
    }
}
