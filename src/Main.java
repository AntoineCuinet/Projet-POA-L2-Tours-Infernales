import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidVelocityException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        // display initial screen
        Supervisor.clearScreen();
        System.out.print(printMenu());
        // wait for user press Enter
        waitForEnter(scanner);
        scanner.close();

        // start playing
        Supervisor game = new Supervisor(5, 4, 4, 5, 500);
        Perso[] results = game.play(25);

        // display results
        Supervisor.clearScreen();
        displayGameOver(results);
    }

    public static String printMenu() {
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
        dst += "█                  Bienvenue dans le jeu des tours infernales !                   █\n";
        dst += "█                    Appuyez sur Entrée pour commencer le jeu.                    █\n";
        dst += "█                                                                                 █\n";
        dst += "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█";
        dst += Color.reset();
        return dst;
    }

    public static void displayGameOver(Perso[] results) {
        System.out.println("  /$$$$$$                                           /$$$$$$");
        System.out.println(" /$$__  $$                                         /$$__  $$");
        System.out.println("| $$  \\__/  /$$$$$$  /$$$$$$/$$$$   /$$$$$$       | $$  \\ $$ /$$    /$$ /$$$$$$   /$$$$$$");
        System.out.println("| $$ /$$$$ |____  $$| $$_  $$_  $$ /$$__  $$      | $$  | $$|  $$  /$$//$$__  $$ /$$__  $$");
        System.out.println("| $$|_  $$  /$$$$$$$| $$ \\ $$ \\ $$| $$$$$$$$      | $$  | $$ \\  $$/$$/| $$$$$$$$| $$  \\__/");
        System.out.println("| $$  \\ $$ /$$__  $$| $$ | $$ | $$| $$_____/      | $$  | $$  \\  $$$/ | $$_____/| $$");
        System.out.println("|  $$$$$$/|  $$$$$$$| $$ | $$ | $$|  $$$$$$$      |  $$$$$$/   \\  $/  |  $$$$$$$| $$");
        System.out.println(" \\______/  \\_______/|__/ |__/ |__/ \\_______/       \\______/     \\_/    \\_______/|__/\n\n");
        // display scores
        System.out.println("############");
        System.out.println("# Résultat #");
        System.out.println("############\n");
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