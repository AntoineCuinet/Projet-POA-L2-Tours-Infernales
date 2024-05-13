/**
 * Provides ANSI color codes for text formatting.
 * This class is abstract and cannot be instantiated directly. It's a singleton.
 */
public abstract class Color {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String[] ANSI_COLORS = {
        "\u001B[31m",   // red
        "\u001B[34m",   // blue
        "\u001B[32m",   // green
        "\u001B[33m",   // yellow
        "\u001B[35m",   // purple
        "\u001B[36m"    // cyan

    };

    public static String[] array() {
        return ANSI_COLORS;
    }

    public static String reset() {
        return ANSI_RESET;
    }

    public static String red() {
        return ANSI_COLORS[0];
    }

    public static String blue() {
        return ANSI_COLORS[1];
    }

    public static String green() {
        return ANSI_COLORS[2];
    }

    public static String yellow() {
        return ANSI_COLORS[3];
    }

    public static String purple() {
        return ANSI_COLORS[4];
    }

    public static String cyan() {
        return ANSI_COLORS[5];
    }
}
