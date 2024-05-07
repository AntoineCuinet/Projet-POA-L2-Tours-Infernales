import java.util.ArrayList;
import java.util.List;

public class Grid {
    private int width;
    private int height;
    private List<Occupant> occupantsList;

    private String tour = "\u25A1";
    private String tourPleine = "\u25A3";
    private String perso = "\u263A";
    private String mur = Main.ANSI_RED + "\u2588" + Main.ANSI_RESET;
    private String murBas = Main.ANSI_RED + "\u2584" + Main.ANSI_RESET;
    private String murHaut = Main.ANSI_RED + "\u2580" + Main.ANSI_RESET;



    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.occupantsList = new ArrayList<Occupant>();
    }

    public Grid() {
        this(20, 10);
    }

    public void addOccupant(Occupant occupant) {
        this.occupantsList.add(occupant);
    }


    @Override
    public String toString() {
        String res = mur;
        for (int j = 0; j < this.width; j++) {
            res += murHaut + murHaut + murHaut + murHaut;
        }
        res += murHaut + mur + "\n";

        for (int i = 0; i < this.height; i++) {
            res += mur + " ";
            for (int j = 1; j < this.width + 1; j++) {
                res += " " + perso + " |";
            }
            res = res.substring(0, res.length() - 1);
            res += " " + mur + "\n" + mur;

            if (i < this.height - 1) {
                for (int j = 0; j < this.width; j++) {
                    res += " ---";
                }
            } else {
                res = res.substring(0, res.length() - 17);
            }
            res += " " + mur + "\n";
        }
        
        res += mur;
        for (int j = 0; j < this.width; j++) {
            res += murBas + murBas + murBas + murBas;
        }
        res += murBas + mur + "\n";

        return res;
    }
}
