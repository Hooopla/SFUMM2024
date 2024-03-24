package Game;

public interface GameMessages {
    String WELCOME_MESSAGE = "Welcome to Dungeons";
    String VERSION_MESSAGE = "Alpha 1.0.1";
    String OPTIONS_MESSAGE = "\nPress 1 to enter the dungeon";
    String CREDITS_MESSAGE = "Press 2 for credits";
    String EXIT_MESSAGE = "Press 3 to exit";
    static void titleScreen() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(VERSION_MESSAGE);
        System.out.println();
        System.out.println(OPTIONS_MESSAGE);
        System.out.println(CREDITS_MESSAGE);
        System.out.println(EXIT_MESSAGE);
    }

    static void showCredits() {
        System.out.println("Jeremy Lee");
        System.out.println("Gabriel Bello");
    }

    static void clearScreen() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
