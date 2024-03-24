package Game.Model.map;

import Game.Model.player.character;

public class NPC {
    String name = "Aurelia";
    boolean inBossRoom = false;
    boolean saved = false;

    public NPC() {}

    public int converse(character player) {
        // CASE 1: PLAYER MEETS HER IN THE DUNGEON AND SHE IS NOT CAUGHT YET
        if(!player.getHasMetAurelia() && !inBossRoom) {
            System.out.println("Aurelia: Oh, hello there! It's not often that I have visitors" +
                    " in these forgotten depths. I'm Aurelia Nightshade, " +
                    "just a humble traveler offering a few odds and ends from my journeys. ");
            player.setHasMetAurelia(true);
            inBossRoom = true;
            return 1;
        }
        // CASE 2: PLAYER MEETS HER IN THE DUNGEON AND SHE IS ALREADY CAUGHT
        else if(!player.getHasMetAurelia() && inBossRoom) {
            System.out.println("Aurelia: Thank you for ridding us of the terror that was Seith the Scalist. We are forever grateful for your bravery and valor.");
            player.setHasMetAurelia(true);
            inBossRoom = false;
            saved = true;
            return 2;
        }
        else if(player.isHasMetAurelia() && inBossRoom) {
            System.out.println("Aurelia: It's you again thank goodness. I thought you got lost into the shadows of this dungeon.");
            inBossRoom = false;
            saved = true;
            return 2;
        }
        else if(player.getHasMetAurelia() && saved) {
            System.out.println("Aurelia: It seems that your journey is coming to an end. Here take this it was my mother's pendant before she passed..");
            System.out.println("OBTAINED: SCARLET PENDANT");
            player.setHealthPoints(100);
            return 3;
        }
        else if(!player.getHasMetAurelia() && saved) {
            System.out.println("Aurelia: I don't seem to recognized your face. It seems my saviour has been lost to the fog of the dungeon..");
            System.out.println("Aurelia: Never the less here. Take this as a good luck charm...");
            System.out.println("OBTAINED: SCARLET PENDANT");
            player.setHealthPoints(100);
            player.setHasMetAurelia(true);
            return 3;
        }
        else {
            return 0;
        }
    }
    public void runsOffVoiceLine() {
        System.out.println("Aurelia: Oh no I must leave now. My BLANK seems to be telling me danger is near.");
    }
}
