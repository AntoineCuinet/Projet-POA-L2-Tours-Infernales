import java.util.Scanner;

public class Main {
    // TODO: changer la façon de gérer les couleurs
    // déclaration des couleurs utilisées pour l'affichage (pour la créativité)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String YELLOW_BG = "\u001B[43m";
    public static final String RESET_BG = "\u001B[40m";

    public static void main(String[] args) throws InvalidVelocityException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        
        Supervisor.clearScreen();
        System.out.print(printMenu());
        // Attend que l'utilisateur appuie sur Entrée
        waitForEnter(scanner);
        
        Supervisor game = new Supervisor(10, 5, 1, 5, 500);
        game.play(100);


        scanner.close();
    }

    public static String printMenu() {
        String dst = ANSI_RED;
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
        dst += ANSI_RESET;
        return dst;
    }

    public static void waitForEnter(Scanner scanner) {
        // Attend que l'utilisateur appuie sur Entrée
        scanner.nextLine();
    }
}