import java.util.HashMap;
import java.util.Map;

public class Grid {
    private int width;
    private int height;
    private Map<Position, Occupant> occupants;

    private String tour = "\u25A1";
    private String tourPleine = "\u25A3";
    private String mur = Main.ANSI_RED + "\u2588" + Main.ANSI_RESET;
    private String murBas = Main.ANSI_RED + "\u2584" + Main.ANSI_RESET;
    private String murHaut = Main.ANSI_RED + "\u2580" + Main.ANSI_RESET;



    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.occupants = new HashMap<Position, Occupant>();
    }

    public Grid() {
        this(20, 10);
    }

    public void addOccupant(Occupant occupant) {
        this.occupants.put(occupant.getPosition(), occupant);
    }

    public void moveOccupant(Occupant occupant, Position position) {
        this.occupants.remove(occupant.getPosition());
        occupant.setPosition(position);
        this.occupants.put(position, occupant);
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
                res += " ";
                
                res += Perso.toString;
                res += " |";
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
