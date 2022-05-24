package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.data.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game manager = new Game();
    Player playerOne = new Player(1, "Джон", 5);
    Player playerTwo = new Player(2, "Иван", 10);
    Player playerThree = new Player(3, "Петя", 15);
    Player playerFo = new Player(4, "Сэм", 15);

    @Test
    void setup() {
        manager.register(playerOne);
        manager.register(playerTwo);
        manager.register(playerThree);
    }


    @Test
    void FirstPlayerWin() {
        manager.register(playerOne);
        manager.register(playerTwo);
        manager.register(playerThree);

        assertEquals(1, manager.round("Петя", "Джон"));
    }

    @Test
    void shouldDraw() {

        manager.register(playerOne);
        manager.register(playerTwo);
        manager.register(playerThree);
        manager.register(playerFo);

        assertEquals(0, manager.round("Петя", "Сэм"));
    }

    @Test
    void throwNotRegisteredExceptionOne() {
        manager.register(playerOne);
        manager.register(playerTwo);
        manager.register(playerThree);

        assertThrows(RuntimeException.class, () -> {
            manager.round("Тест", "Сэм");
        });
    }

    @Test
    void shouldThrowNotRegisteredExceptionTwo() {
        manager.register(playerOne);
        manager.register(playerTwo);
        manager.register(playerThree);

        assertThrows(RuntimeException.class, () -> {
            manager.round("Тэст", "Нетест");
        });
    }
}

