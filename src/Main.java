import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidVelocityException, InterruptedException {
        // display initial screen
        displayMenu();

        // start playing
        Supervisor game = new Supervisor(5, 4, 4, 5, 500);
        Perso[] results = game.play(25);

        // display results
        displayGameOver(results);
    }

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
        System.out.println("█                  Bienvenue dans le jeu des tours infernales !                   █");
        System.out.println("█                    Appuyez sur Entrée pour commencer le jeu.                    █");
        System.out.println("█                                                                                 █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.print(Color.reset());
        waitForEnter(scanner);
        scanner.close();
        Supervisor.clearScreen();
    }

    public static void displayGameOver(Perso[] results) {
        Supervisor.clearScreen();
        System.out.println("  /$$$$$$                                           /$$$$$$");
        System.out.println(" /$$__  $$                                         /$$__  $$");
        System.out.println("| $$  \\__/  /$$$$$$  /$$$$$$/$$$$   /$$$$$$       | $$  \\ $$ /$$    /$$ /$$$$$$   /$$$$$$");
        System.out.println("| $$ /$$$$ |____  $$| $$_  $$_  $$ /$$__  $$      | $$  | $$|  $$  /$$//$$__  $$ /$$__  $$");
        System.out.println("| $$|_  $$  /$$$$$$$| $$ \\ $$ \\ $$| $$$$$$$$      | $$  | $$ \\  $$/$$/| $$$$$$$$| $$  \\__/");
        System.out.println("| $$  \\ $$ /$$__  $$| $$ | $$ | $$| $$_____/      | $$  | $$  \\  $$$/ | $$_____/| $$");
        System.out.println("|  $$$$$$/|  $$$$$$$| $$ | $$ | $$|  $$$$$$$      |  $$$$$$/   \\  $/  |  $$$$$$$| $$");
        System.out.println(" \\______/  \\_______/|__/ |__/ |__/ \\_______/       \\______/     \\_/    \\_______/|__/\n\n");
        // display scores
        System.out.println("\u2584\u2584\u2584\u2584\u2584\u2584\u2584\u2584\u2584\u2584\u2584\u2584");
        System.out.println("\u2588 Résultat \u2588");
        System.out.println("\u2580\u2580\u2580\u2580\u2580\u2580\u2580\u2580\u2580\u2580\u2580\u2580\n");
        for (int i=0 ; i < results.length ; i++) {
            int nbrTower = results[i].getOwnedTowers().size();
            String prompt = "\tN°" + (i+1) + " : [" + results[i] + "] | Avec " + nbrTower + " tour";
            if (nbrTower > 1) {
                prompt += 's';
            }
            System.out.println(prompt);
        }
        System.out.println('\n');
    }

    public static void waitForEnter(Scanner scanner) {
        // Attend que l'utilisateur appuie sur Entrée
        scanner.nextLine();
    }
}