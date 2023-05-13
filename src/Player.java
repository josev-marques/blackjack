import java.util.ArrayList;

public class Player {
    private final ArrayList<Card> m_PlayerHand;

    private int m_Points;

    public boolean m_Playing;

    public Player() {
        this.m_PlayerHand = new ArrayList<>();
        this.m_Playing = true;
        this.m_Points = 0;
    }

    public String drawCard(Deck p_Deck) {
        Card v_Card = p_Deck.draw();
        this.m_PlayerHand.add(v_Card);
        this.m_Points += v_Card.getValue();

        return v_Card.toString();
    }

    public StringBuilder showPlayerHand() {
        StringBuilder v_Str = new StringBuilder();
        if (m_PlayerHand.isEmpty())
            return v_Str.append("Sua mão está vazia");

        for (Card c_Card : m_PlayerHand)
            v_Str.append(c_Card.toString()).append("\n");

        return v_Str;
    }

    public int getPoints() {
        return this.m_Points;
    }

    @Override
    public String toString() {
        StringBuilder v_Str = new StringBuilder();
        v_Str.append("Pontuação: ").append(this.m_Points).append("\n");
        v_Str.append(showPlayerHand()).append("\n");

        return new String(v_Str);
    }
}
