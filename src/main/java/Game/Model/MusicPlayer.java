package Game.Model;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MusicPlayer {
    public static void openGoogleLink(String googleLink) {
        try {
            // Check if Desktop is supported
            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop not supported.");
                return;
            }

            // Create a URI object from the Google link
            URI uri = new URI(googleLink);

            // Open the Google link in the default web browser
            Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException | IOException e) {
            System.out.println("Error opening Google link: " + e.getMessage());
        }
    }
}