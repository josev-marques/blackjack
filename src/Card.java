public class Card {
    private final String m_Number;

    private final Integer m_Value;
    private final String m_Suit;

    public Card(String p_Suit, String p_Number, Integer p_Value) {
        this.m_Number = p_Number;
        this.m_Suit = p_Suit;
        this.m_Value = p_Value;
    }

    public Integer getValue() {
        return m_Value;
    }

    public String getSuit() {
        return m_Suit;
    }

    @Override
    public String toString() {
        return m_Number + " de " + m_Suit;
    }
}
