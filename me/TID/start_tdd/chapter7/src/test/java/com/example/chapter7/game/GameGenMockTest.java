package com.example.chapter7.game;

import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class GameGenMockTest {

    @Test
    void init() {
        GameNumGen genMock = mock(GameNumGen.class);
        Game game = new Game(genMock);
        game.init(GameLevel.EASY);

        then(genMock).should().generate(GameLevel.EASY);
//        then(genMock).should().generate(GameLevel.NORMAL);
    }
}
