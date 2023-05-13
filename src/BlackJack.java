import java.util.ArrayList;
import java.util.List;

public class BlackJack {
    private final Deck m_Deck;

    private final List<Player> m_Players;

    private final int m_NumOfPlayers;

    private int m_Turn;

    BlackJack(int p_Players) {
        this.m_Turn = 0;
        this.m_NumOfPlayers = p_Players;
        this.m_Deck = new Deck();
        this.m_Players = new ArrayList<>();

        for (int i = 0; i < p_Players; i++)
            this.m_Players.add(new Player());

        this.startGame();
    }

    private void startGame() {
        this.m_Deck.shuffle();

        for (Player c_Player : this.m_Players) {
            c_Player.drawCard(this.m_Deck);
            c_Player.drawCard(this.m_Deck);
        }
    }

    private String giveCardPlayer(Player p_Player) {
        return p_Player.drawCard(this.m_Deck);
    }

    private void skip() {
        this.m_Turn++;
        System.out.println(this.m_Turn);
        if (this.m_Turn >= this.m_NumOfPlayers)
            this.m_Turn = 0;
    }

    public String stop() {
        Player v_PlayerTurn = this.m_Players.get(this.m_Turn);
        v_PlayerTurn.m_Playing = false;

        String v_Str = "Jogador " + (this.m_Turn + 1) + " parou";
        skip();

        return v_Str;
    }

    public String drawCard() {
        Player v_PlayerTurn = this.m_Players.get(this.m_Turn);

        if (!v_PlayerTurn.m_Playing){
            skip();
            return "Jogador\n" + v_PlayerTurn + "Parou";
        }

        return giveCardPlayer(v_PlayerTurn);
    }

    public int getPoints() {
        Player v_PlayerTurn = this.m_Players.get(this.m_Turn);

        return  v_PlayerTurn.getPoints();
    }

    public String checkPoints() {
        Player v_PlayerTurn = this.m_Players.get(this.m_Turn);
        int LIMIT_POINTS = 21;

        if (v_PlayerTurn.getPoints() > LIMIT_POINTS){
            v_PlayerTurn.m_Playing = false;
            return "Pontuação: " + v_PlayerTurn.getPoints() + "\nEstourou!";

        }
        else if(v_PlayerTurn.getPoints() < LIMIT_POINTS) {
            return "Pontuação: " + v_PlayerTurn.getPoints() + "\nAbaixo de 21.";
        }

        skip();
        return "BLACKJACK!!";
    }

    public String showPlayerHand() {
        Player v_PlayerTurn = this.m_Players.get(this.m_Turn);

        return new String(v_PlayerTurn.showPlayerHand());
    }

    public String skipTurn() {
        skip();

        return "Jogador " + this.m_Turn + " pulou a vez";
    }

    public String showDeck() {
        return m_Deck.toString();
    }

    public String info() {
        Player v_PlayerTurn = this.m_Players.get(this.m_Turn);
        StringBuilder v_Str = new StringBuilder();
        v_Str.append("Jogador ").append(this.m_Turn + 1).append("\n");
        v_Str.append(v_PlayerTurn.toString());

        return new String(v_Str);
    }
}
