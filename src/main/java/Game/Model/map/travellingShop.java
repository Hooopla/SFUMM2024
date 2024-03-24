package Game.Model.map;

public class travellingShop {
    String name = "Aurelia";
    boolean hasMet = false;

    public travellingShop() {}

    public void converse() {
        if(hasMet == false) {
            System.out.println("Aurelia: Oh, hello there! It's not often that I have visitors" +
                    " in these forgotten depths. I'm Aurelia Nightshade, " +
                    "just a humble traveler offering a few odds and ends from my journeys. ");
            this.hasMet = true;
        }
        if(hasMet == true) {
            System.out.println("Aurelia: Hello there... I've been waiting for you. I've gathered some gentle treasures since our " +
                    "last encounter. Would you like to see? I believe they might bring a touch of " +
                    "tranquility to your journey.");
        }
    }
    public void runsOffVoiceLine() {
        System.out.println("Aurelia: Oh no I must leave now. My BLANK seems to be telling me danger is near.");
    }
}
