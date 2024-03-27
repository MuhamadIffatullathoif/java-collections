package org.iffat.games;

import org.iffat.games.poker.PokerGame;

public class GameController {
    public static void main(String[] args) {
        PokerGame fiveCardDraw = new PokerGame(4, 5);
        fiveCardDraw.startPlay();
    }
}
