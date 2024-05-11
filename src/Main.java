import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidVelocityException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Supervisor.clearScreen();
        System.out.print(printMenu());
        // Attend que l'utilisateur appuie sur Entrée
        waitForEnter(scanner);

        Supervisor game = new Supervisor(8, 5, 2, 6, 500);
        game.play(256);


        scanner.close();
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

    public static void waitForEnter(Scanner scanner) {
        // Attend que l'utilisateur appuie sur Entrée
        scanner.nextLine();
    }
}