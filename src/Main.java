import java.util.Scanner;

public class Main {

      /*******************************************************/
     /**  Modifications here for grid, players, towers...  **/
    /*******************************************************/
    private static final int GRID_WIDTH     = 10;
    private static final int GRID_HEIGHT    = 8;
    private static final int NBR_PLAYER     = 6;
    private static final int NBR_TOWER      = 5;
    private static final int NBR_SNOWMAN    = 5;
    private static final int REFRESH_RATE   = 400;
    private static final int MAX_ROUND      = 50;

    public static void main(String[] args) throws InvalidVelocityException, InterruptedException {
        // get scanner for user inputs
        Scanner scanner = new Scanner(System.in);

        // display initial screen and wait user interaction
        displayMenu();
        waitForEnter(scanner);

        // MAIN LOOP PROCESS
        do {

            Supervisor game;
            try {
                game = new Supervisor(GRID_WIDTH, GRID_HEIGHT, NBR_PLAYER, NBR_TOWER, NBR_SNOWMAN, REFRESH_RATE);
            } catch (NotEnoughPlaceException e) {
                Supervisor.clearScreen();
                System.err.println("Pas assez de place disponible sur la grille pour le nombre d'éléments spécifié !");
                return; // stop execution
            }
            Perso[] results = game.play(MAX_ROUND);


            // display results
            displayGameOver(results);
        } while (askForContinue(scanner));

        // close scanner
        scanner.close();
    }

    /**
     * Displays the game menu.
     */
    public static void displayMenu() {
        // Scanner scanner = new Scanner(System.in);
        Supervisor.clearScreen();
        String dst = Color.red();
        dst += "█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█\n";
        dst += "█                                                                                 █\n";
        dst += "█     ██╗     ███████╗███████╗    ████████╗ ██████╗ ██╗   ██╗██████╗ ███████╗     █\n";
        dst += "█     ██║     ██╔════╝██╔════╝    ╚══██╔══╝██╔═══██╗██║   ██║██╔══██╗██╔════╝     █\n";
        dst += "█     ██║     █████╗  ███████╗       ██║   ██║   ██║██║   ██║██████╔╝███████╗     █\n";
        dst += "█     ██║     ██╔══╝  ╚════██║       ██║   ██║   ██║██║   ██║██╔══██╗╚════██║     █\n";
        dst += "█     ███████╗███████╗███████║       ██║   ╚██████╔╝╚██████╔╝██║  ██║███████║     █\n";
        dst += "█     ╚══════╝╚══════╝╚══════╝       ╚═╝    ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚══════╝     █\n";
        dst += "█                                                                                 █\n";
        dst += "█ ██╗███╗   ██╗███████╗███████╗██████╗ ███╗   ██╗ █████╗ ██╗     ███████╗███████╗ █\n";
        dst += "█ ██║████╗  ██║██╔════╝██╔════╝██╔══██╗████╗  ██║██╔══██╗██║     ██╔════╝██╔════╝ █\n";
        dst += "█ ██║██╔██╗ ██║█████╗  █████╗  ██████╔╝██╔██╗ ██║███████║██║     █████╗  ███████╗ █\n";
        dst += "█ ██║██║╚██╗██║██╔══╝  ██╔══╝  ██╔══██╗██║╚██╗██║██╔══██║██║     ██╔══╝  ╚════██║ █\n";
        dst += "█ ██║██║ ╚████║██║     ███████╗██║  ██║██║ ╚████║██║  ██║███████╗███████╗███████║ █\n";
        dst += "█ ╚═╝╚═╝  ╚═══╝╚═╝     ╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝ █\n";
        dst += "█                                                                                 █\n";
        dst += "█                                                                                 █\n";
        dst += "█                  Bienvenue dans le jeu des tours infernales !                   █\n";
        dst += "█                    Appuyez sur Entrée pour commencer le jeu.                    █\n";
        dst += "█                                                                                 █\n";
        dst += "█                                                                                 █\n";
        dst += "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n";
        dst += Color.reset();
        System.out.print(dst);
    }

    /**
     * Displays the game over screen with results.
     *
     * @param results The game's results to display.
     */
    public static void displayGameOver(Perso[] results) {
        Supervisor.clearScreen();
        String dst = Color.red();
        dst += "█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█\n";
        dst += "█                                                                                 █\n";
        dst += "█                           ███████╗ ██╗ ███╗   ██╗                               █\n";
        dst += "█                           ██╔════╝ ██║ ████╗  ██║                               █\n";
        dst += "█                           █████╗   ██║ ██╔██╗ ██║                               █\n";
        dst += "█                           ██╔══╝   ██║ ██║╚██╗██║                               █\n";
        dst += "█                           ██║      ██║ ██║ ╚████║ ██╗                           █\n";
        dst += "█                           ╚═╝      ╚═╝ ╚═╝  ╚═══╝ ╚═╝                           █\n";
        dst += "█                                                                                 █\n";
        dst += "█                    ____   __            _ _        _                            █\n";
        dst += "█                   |  _ \\ /_/  ___ _   _| | |_ __ _| |_ ___                      █\n";
        dst += "█                   | |_) / _ \\/ __| | | | | __/ _` | __/ __|                     █\n";
        dst += "█                   |  _ <  __/\\__ \\ |_| | | || (_| | |_\\__ \\                     █\n";
        dst += "█                   |_| \\_\\___||___/\\__,_|_|\\__\\__,_|\\__|___/                     █\n";
        dst += "█                                                                                 █\n";
        // display scores
        for (int i=0 ; i < results.length ; i++) {
            int nbrTower = results[i].getOwnedTowers().size();
            String prompt = "█ " + Color.reset() + "\t\t\t     N°" + (i+1) + " : [" + results[i] + "] | Avec " + nbrTower + " tour";
            if (nbrTower > 1) {
                prompt += 's' + Color.red() + "\t\t\t          █\n";
            } else {
                prompt += Color.red() + "\t\t\t          █\n";
            }
            dst += prompt;
        }
        dst += "█                                                                                 █\n";
        dst += "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n";
        dst += Color.reset();
        System.out.print(dst);
    }

    /**
     * Waits for the user to press Enter.
     *
     * @param scanner The scanner object to use for input.
     */
    public static void waitForEnter(Scanner scanner) {
        scanner.nextLine();
    }

    public static boolean askForContinue(Scanner scanner) {
        // ask the user to continue or not
        System.out.print("\n\nVoulez-vous jouer une nouvelle partie [y/N]: ");
        // wait for the user answer and return it
        String answer = scanner.nextLine();
        return answer.equals("y") || answer.equals("o");
    }
}