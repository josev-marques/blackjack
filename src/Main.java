import java.util.Scanner;

public class Main {
    public static void showScore(BlackJack p_Game) {
        System.out.println("Pontuação atual: " + p_Game.getPoints() + "\n");
    }

    public static void showPlayerHand(BlackJack p_Game) {
        System.out.println(p_Game.showPlayerHand());
    }

    public static void showDeck(BlackJack p_Game) {
        System.out.println(p_Game.showDeck());
    }

    public static void showCheckScore(BlackJack p_Game) {
        System.out.println(p_Game.checkPoints());
    }

    public static void showOptions() {
        System.out.println("1: Comprar carta");
        System.out.println("2: Verificar pontuação");
        System.out.println("3: Mostrar mão do jogador");
        System.out.println("4: Mostrar pontuação");
        System.out.println("5: Iniciar novo jogo");
        System.out.println("6: Monstrar deck completo");
        System.out.println("7: Finalizar");
    }

    public static void drawCard(BlackJack p_Game) {
        System.out.println(p_Game.drawCard());
    }

    public static BlackJack startNewGame() {
        BlackJack v_Game = new BlackJack();
        showPlayerHand(v_Game);
        showScore(v_Game);
        showOptions();

        return v_Game;
    }


    public static void main(String[] args) {
        Scanner v_Scanner = new Scanner(System.in);
        BlackJack v_NewGame = startNewGame();

        int v_Option = 0;

        while(v_Option != 7) {
            v_Option = v_Scanner.nextInt();
            switch (v_Option) {
                case 1 -> drawCard(v_NewGame);
                case 2 -> showCheckScore(v_NewGame);
                case 3 -> showPlayerHand(v_NewGame);
                case 4 -> showScore(v_NewGame);
                case 5 -> v_NewGame = startNewGame();
                case 6 -> showDeck(v_NewGame);
                case 7 -> System.out.println("Finalizando...");
            }

            if (v_Option > 7)
                System.out.println("Opção não reconhecida");
        }
    }


}