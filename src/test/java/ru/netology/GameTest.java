package ru.netology;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();


    @Test
    public void registerPlayer() throws NotRegisteredException {
        Player player1 = new Player(1, "Petya", 4);
        Player player2 = new Player(2, "Vasya", 3);

        game.registerPlayer(player1);
        game.registerPlayer(player2);

        int actual = game.round(player1.getName(), player2.getName());
        assertEquals(1, actual);
    }

    @Test
    public void WinPlayer1() throws NotRegisteredException {
        Player player1 = new Player(1, "Petya", 4);
        Player player2 = new Player(2, "Vasya", 3);

        game.registerPlayer(player1);
        game.registerPlayer(player2);

        int actual = game.round(player1.getName(), player2.getName());
        assertEquals(1, actual);
    }

    @Test
    public void WinPlayer2() throws NotRegisteredException {
        Player player1 = new Player(1, "Petya", 3);
        Player player2 = new Player(2, "Vasya", 5);

        game.registerPlayer(player1);
        game.registerPlayer(player2);

        int actual = game.round(player1.getName(), player2.getName());
        assertEquals(2, actual);
    }

    @Test
    public void draw() throws NotRegisteredException {
        Player player1 = new Player(1, "Petya", 3);
        Player player2 = new Player(2, "Vasya", 3);

        game.registerPlayer(player1);
        game.registerPlayer(player2);

        int actual = game.round(player1.getName(), player2.getName());
        assertEquals(0, actual);
    }

    @Test
    public void player1NotRegistered() throws NotRegisteredException {
        Player player1 = new Player(1, "Petya", 3);
        Player player2 = new Player(2, "Vasya", 5);

        game.registerPlayer(player2);

        assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player2.getName());
        });
    }

    @Test
    public void player2NotRegistered() throws NotRegisteredException {
        Player player1 = new Player(1, "Petya", 3);
        Player player2 = new Player(2, "Vasya", 5);

        game.registerPlayer(player1);

        assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player2.getName());
        });
    }


}