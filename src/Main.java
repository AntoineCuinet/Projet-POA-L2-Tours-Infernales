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
        Supervisor game = new Supervisor(20, 11, 7, 200);
        game.play(100);
    }
}