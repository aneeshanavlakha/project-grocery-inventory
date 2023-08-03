package ui;

// BASED ON LogformProblemStarters/SmartHome/ButtonNames ADD LINK!!

// Names of buttons used across the GUI
public enum ButtonNames {
    VIEW_ALL("View All"),
    QUIT("Quit"),
    SAVE("Save");

    private final String name;

    ButtonNames(String name) {
        this.name = name;
    }

    //EFFECTS: returns name value of this button
    public String getValue() {
        return name;
    }
}
