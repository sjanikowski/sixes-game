package pl.edu.agh.sixes.engine.generator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.edu.agh.sixes.model.Card;
import pl.edu.agh.sixes.model.CardsStack;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DeckGeneratorTest {

    private static DeckGenerator deckGenerator;

    @BeforeAll
    static void init(){
        deckGenerator = new DeckGenerator();
    }

    @Test
    void deckSizeTest() {
        //given

        //when
        CardsStack deck = deckGenerator.initializeDeck();

        //then
        assertEquals(104, deck.getCards().size());
    }

    @Test
    void duplicatesTest(){
        //given
        CardsStack deck = deckGenerator.initializeDeck();

        //when
        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            Integer index = rand.nextInt(102);
            Card chosen = deck.getCards().get(index);

            int count = 0;
            for(Card card : deck.getCards()){
                if (chosen.equals(card))
                    count++;
            }
            assertEquals(2, count);
        }


    }

}