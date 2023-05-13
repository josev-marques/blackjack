import java.util.Scanner;

public class Main {
    public static void showScore(BlackJack p_Game) {
        System.out.println("Pontuação atual: " + p_Game.getPoints() + "\n");
    }

    public static void showTurnInfo(BlackJack p_Game) {
        System.out.println(p_Game.info());
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
        System.out.println("2: Parar");
        System.out.println("3: Pular turno\n");
        System.out.println("4: Mostrar mão do jogador");
        System.out.println("5: Verificar pontuação");
        System.out.println("6: Mostrar pontuação");
        System.out.println("7: Iniciar novo jogo");
        System.out.println("8: Monstrar informações do turno");
        System.out.println("9: Monstrar deck completo");
        System.out.println("10: Parar");
        System.out.println("11: Finalizar");
    }

    public static void draw(BlackJack p_Game) {
        System.out.println(p_Game.drawCard());
    }

    public static void stop(BlackJack p_Game) {
        System.out.println(p_Game.stop());
    }

    public static void skip(BlackJack p_Game) {
        System.out.println(p_Game.skipTurn());
    }

    public static BlackJack startNewGame(Scanner p_Scan) {
        System.out.println("BlackJack - 1 a 4 JOGADORES");
        System.out.println("Digite o número de jogadores");
        int v_Players = p_Scan.nextInt();

        if (v_Players < 4) {
            v_Players = v_Players <= 0 ? 1 : v_Players;
            BlackJack v_Game = new BlackJack(v_Players);

            showOptions();
            return v_Game;
        }

        return startNewGame(p_Scan);
    }


    public static void main(String[] args) {
        Scanner v_Scanner = new Scanner(System.in);
        BlackJack v_NewGame = startNewGame(v_Scanner);

        int v_Option = 0;

        while(v_Option != 11) {
            v_Option = v_Scanner.nextInt();
            switch (v_Option) {
                case 1 -> draw(v_NewGame);
                case 2 -> stop(v_NewGame);
                case 3 -> skip(v_NewGame);
                case 4 -> showPlayerHand(v_NewGame);
                case 5 -> showCheckScore(v_NewGame);
                case 6 -> showScore(v_NewGame);
                case 7 -> v_NewGame = startNewGame(v_Scanner);
                case 8 -> showTurnInfo(v_NewGame);
                case 9 -> showDeck(v_NewGame);
                case 10 -> stop(v_NewGame);
                case 11 -> System.out.println("Finalizando...");
            }

            if (v_Option > 11)
                System.out.println("Opção não reconhecida");
        }
    }


}