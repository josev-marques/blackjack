import java.util.ArrayList;

public class BlackJack {
    private final Integer LIMIT_POINTS = 21;
    private final Deck m_Deck;
    private final ArrayList<Card> m_PlayerHand;
    private Integer m_Points;

    BlackJack() {
        this.m_Deck = new Deck();
        this.m_PlayerHand = new ArrayList<>();
        this.m_Points = 0;

        this.startGame();
    }

    private void startGame() {
        this.m_Deck.shuffle();
        this.drawCard();
        this.drawCard();
    }

    public String drawCard() {
        Card v_Card = m_Deck.draw();
        this.m_PlayerHand.add(v_Card);
        this.m_Points += v_Card.getValue();

        return v_Card.toString();
    }

    public Integer getPoints() {
        return m_Points;
    }

    public String checkPoints() {
        if (m_Points > LIMIT_POINTS)
            return "Pontuação: " + this.m_Points + "\nEstourou!";
        else if (m_Points < LIMIT_POINTS)
            return "Pontuação: " + this.m_Points + "\nAbaixo de 21.";

        return "BLACKJACK!!";
    }

    public StringBuilder showPlayerHand() {
        StringBuilder v_Str = new StringBuilder();
        if (m_PlayerHand.isEmpty())
            return v_Str.append("Sua mão está vazia");

        for (Card c_Card : m_PlayerHand)
            v_Str.append(c_Card.toString()).append("\n");

        return v_Str;
    }

    public String showDeck() {
        return m_Deck.toString();
    }
}
