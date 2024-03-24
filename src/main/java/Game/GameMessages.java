package Game;

public interface GameMessages{
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
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    static void printMapText() {
        System.out.println("""

                                    \s
                 _____  _____  _____\s
                |     ||  _  ||  _  |
                | | | ||     ||   __|
                |_|_|_||__|__||__|  \s
                                    \s
                """);
    }

    static void printCombatText() {
        System.out.println("""

                                                         \s
                 _____  _____  _____  _____  _____  _____\s
                |     ||     ||     || __  ||  _  ||_   _|
                |   --||  |  || | | || __ -||     |  | | \s
                |_____||_____||_|_|_||_____||__|__|  |_| \s
                                                         \s
                """);
    }
    static void printShopKeeper() {
        System.out.println("""
                       .-""-.
                      /-.{}  \\
                      | _\\__.|
                      \\/^)^ \\/
                       \\ =  /
                  .---./`--`\\.--._
                 /     `;--'`     \\
                ;        /`       ;
                |       |*        |
                /   |   |     |    \\
                |    \\  |*    /    |
                \\_   |\\_|____/|  __/
                  \\__//======\\\\__/
                  / //_      _\\\\ \\
                  -'  |`""\""`|  `-
                      |  L   |
                      >_ || _<
                      |  ||  |
                      |  ||  |
                     /   ||   \\
                    /    /,    \\
                     `|"|`"|"|"`
                     /  )  /  )  nic/jgs
                    /__/  /__/""");
    }

    static void endingMessage() {
        System.out.println("""

                  _______ _    _ ______   ______ _   _ _____ \s
                 |__   __| |  | |  ____| |  ____| \\ | |  __ \\\s
                    | |  | |__| | |__    | |__  |  \\| | |  | |
                    | |  |  __  |  __|   |  __| | . ` | |  | |
                    | |  | |  | | |____  | |____| |\\  | |__| |
                    |_|  |_|  |_|______| |______|_| \\_|_____/\s
                                                             \s
                                                             \s
                """);
        System.out.println("As I step out into the open air, my lungs fill with the sweet scent of freedom. The weight of chains and the darkness of the dungeon are but fading memories now, \n\nreplaced by the warmth of the sun on my skin and the gentle breeze that whispers tales of liberty.\n\nFor so long, I dwelled in the depths of despair, surrounded by cold stone walls and the haunting echoes of lost hope. But today, today is different. Today, I am free.\n\nWith each step away from that accursed place, I reclaim a piece of myself that was lost in the shadows. No longer confined by iron bars or the cruel whims of fate, \n\nI am reborn with a newfound sense of purpose and determination.\n");

    }
}
