import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    public void registerAndRound() {
        Game game = new Game();
        List<Player> playerList = List.of(
                new Player(1, "Petya", 20),
                new Player(2, "Kolya", 30));

        game.register(playerList);

        int actual = game.round("Petya", "Kolya");
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    public void registerAndRound1() {
        Game game = new Game();
        List<Player> playerList = List.of(
                new Player(1, "Petya", 20),
                new Player(2, "Kolya", 30));

        game.register(playerList);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Petya", "Sacha");
        });

    }
}
