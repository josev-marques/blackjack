import java.util.*;

public class Deck {
    private final ArrayList<Card> m_Deck;

    public Deck() {
        this.m_Deck = new ArrayList<>();
        int m_ValueCounter;

        String[] NUMBERS = {"As", "Dois", "Tres", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Rainha", "Rei"};
        String[] SUITS = {"paus", "ouros", "coração", "espadas"};

        for (String c_Suit : SUITS) {
            m_ValueCounter = 1;
            for (String c_Value : NUMBERS) {
                this.m_Deck.add(new Card(c_Suit, c_Value, m_ValueCounter));
                m_ValueCounter = m_ValueCounter < 10 ? m_ValueCounter + 1 : 10;
            }
        }

    }

    public void shuffle() {
        Collections.shuffle(m_Deck);
    }

    public Card draw() {
        if (m_Deck.isEmpty())
            return null;

        return m_Deck.remove(0);
    }

    private StringBuilder stringfyDeck() {
        StringBuilder v_Str = new StringBuilder();
        if (m_Deck.isEmpty())
            return v_Str.append("O baralho está vazio");

        for (Card c_Card : m_Deck) {
            v_Str.append(c_Card.toString()).append("\n");
        }
        return v_Str;
    }

    @Override
    public String toString() {
        return new String(this.stringfyDeck());
    }
}
