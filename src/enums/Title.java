package enums;

public enum Title {
    MR("Mr."),
    MS("Ms."),
    MRS("Mrs.");

    // declaring private variable for getting values
    private String title;

    // getter method
    public String getAction() {
        return this.title;
    }

    // enum constructor
    private Title(String title) {
        this.title = title;
    }
}