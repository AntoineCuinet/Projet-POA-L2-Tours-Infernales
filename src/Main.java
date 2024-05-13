import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidVelocityException, InterruptedException {
        // display initial screen
        displayMenu();

        // start playing
        Supervisor game = new Supervisor(10, 5, 5, 5, 500);
        Perso[] results = game.play(50);

        // display results
        displayGameOver(results);
    }

    /**
     * Displays the game menu.
     */
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        Supervisor.clearScreen();
        System.out.print(Color.red());
        System.out.println("█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
        System.out.println("█                                                                                 █");
        System.out.println("█     ██╗     ███████╗███████╗    ████████╗ ██████╗ ██╗   ██╗██████╗ ███████╗     █");
        System.out.println("█     ██║     ██╔════╝██╔════╝    ╚══██╔══╝██╔═══██╗██║   ██║██╔══██╗██╔════╝     █");
        System.out.println("█     ██║     █████╗  ███████╗       ██║   ██║   ██║██║   ██║██████╔╝███████╗     █");
        System.out.println("█     ██║     ██╔══╝  ╚════██║       ██║   ██║   ██║██║   ██║██╔══██╗╚════██║     █");
        System.out.println("█     ███████╗███████╗███████║       ██║   ╚██████╔╝╚██████╔╝██║  ██║███████║     █");
        System.out.println("█     ╚══════╝╚══════╝╚══════╝       ╚═╝    ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚══════╝     █");
        System.out.println("█                                                                                 █");
        System.out.println("█ ██╗███╗   ██╗███████╗███████╗██████╗ ███╗   ██╗ █████╗ ██╗     ███████╗███████╗ █");
        System.out.println("█ ██║████╗  ██║██╔════╝██╔════╝██╔══██╗████╗  ██║██╔══██╗██║     ██╔════╝██╔════╝ █");
        System.out.println("█ ██║██╔██╗ ██║█████╗  █████╗  ██████╔╝██╔██╗ ██║███████║██║     █████╗  ███████╗ █");
        System.out.println("█ ██║██║╚██╗██║██╔══╝  ██╔══╝  ██╔══██╗██║╚██╗██║██╔══██║██║     ██╔══╝  ╚════██║ █");
        System.out.println("█ ██║██║ ╚████║██║     ███████╗██║  ██║██║ ╚████║██║  ██║███████╗███████╗███████║ █");
        System.out.println("█ ╚═╝╚═╝  ╚═══╝╚═╝     ╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝ █");
        System.out.println("█                                                                                 █");
        System.out.println("█                                                                                 █");
        System.out.println("█                  Bienvenue dans le jeu des tours infernales !                   █");
        System.out.println("█                    Appuyez sur Entrée pour commencer le jeu.                    █");
        System.out.println("█                                                                                 █");
        System.out.println("█                                                                                 █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.print(Color.reset());
        waitForEnter(scanner);
        scanner.close();
        Supervisor.clearScreen();
    }

    /**
     * Displays the game over screen with results.
     *
     * @param results The game's results to display.
     */
    public static void displayGameOver(Perso[] results) {
        Supervisor.clearScreen();
        System.out.print(Color.red());
        System.out.println("█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
        System.out.println("█                                                                                 █");
        System.out.println("█                           ███████╗ ██╗ ███╗   ██╗                               █");
        System.out.println("█                           ██╔════╝ ██║ ████╗  ██║                               █");
        System.out.println("█                           █████╗   ██║ ██╔██╗ ██║                               █");
        System.out.println("█                           ██╔══╝   ██║ ██║╚██╗██║                               █");
        System.out.println("█                           ██║      ██║ ██║ ╚████║ ██╗                           █");
        System.out.println("█                           ╚═╝      ╚═╝ ╚═╝  ╚═══╝ ╚═╝                           █");
        System.out.println("█                                                                                 █");
        // display scores
        System.out.println("█                    ____   __            _ _        _                            █");
        System.out.println("█                   |  _ \\ /_/  ___ _   _| | |_ __ _| |_ ___                      █");
        System.out.println("█                   | |_) / _ \\/ __| | | | | __/ _` | __/ __|                     █");
        System.out.println("█                   |  _ <  __/\\__ \\ |_| | | || (_| | |_\\__ \\                     █");
        System.out.println("█                   |_| \\_\\___||___/\\__,_|_|\\__\\__,_|\\__|___/                     █");
        System.out.println("█                                                                                 █");

        for (int i=0 ; i < results.length ; i++) {
            int nbrTower = results[i].getOwnedTowers().size();
            String prompt = "█ " + Color.reset() + "\t\t\t     N°" + (i+1) + " : [" + results[i] + "] | Avec " + nbrTower + " tour";
            if (nbrTower > 1) {
                prompt += 's' + Color.red() + "\t\t\t          █";
            } else {
                prompt += Color.red() + "\t\t\t          █";
            }
            System.out.println(prompt);
        }
        System.out.println("█                                                                                 █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.print(Color.reset());
    }

    /**
     * Waits for the user to press Enter.
     *
     * @param scanner The scanner object to use for input.
     */
    public static void waitForEnter(Scanner scanner) {
        scanner.nextLine();
    }
}