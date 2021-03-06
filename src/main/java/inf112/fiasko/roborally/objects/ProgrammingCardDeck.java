package inf112.fiasko.roborally.objects;

import java.util.List;

/**
 * This class represents a deck containing programming cards
 */
public class ProgrammingCardDeck extends AbstractDeck<ProgrammingCard> {

    /**
     * Initializes the PlayerDeck with a list of cards
     *
     * @param cardList list of programing cards
     */
    public ProgrammingCardDeck(List<ProgrammingCard> cardList) {
        super(cardList);
    }

    /**
     * Empty constructor required by KryoNet. DO NOT REMOVE THIS!!!
     */
    public ProgrammingCardDeck() {
    }
}
