package example.exenum;

enum Level {
    LOW("Low level"),
    MEDIUM("Medium level"),
    HIGH("High level");

    private String description;

    private Level(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

public class Enum1 {
    public static void main(String[] args) {
        for (Level var : Level.values()) {
            System.out.println(var + ": " + var.getDescription());
        }
    }
}
