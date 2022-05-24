package ru.netology.manager;

import ru.netology.data.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    private List<Player> players = new ArrayList<>();

    public Game() {
    }

    public Game(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public boolean register(Player player) {
        return players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        int indexOne = stringPlayer(playerName1);
        int indexTwo = stringPlayer(playerName2);
        if (indexOne == -1) {
            throw new RuntimeException("Игрок 1 не зарегестрирован");
        } else if (indexTwo == -1) {
            throw new RuntimeException("Игрок 2 не зарегестрирован");
        }
        if (players.get(indexOne).getStrength() > players.get(indexTwo).getStrength()) {
            return 1;
        } else if (players.get(indexOne).getStrength() < players.get(indexTwo).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    public int stringPlayer(String playerName) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(playerName)) {
                return players.indexOf(player);
            }
        }
        return -1;
    }
}