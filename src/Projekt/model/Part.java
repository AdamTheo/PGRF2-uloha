package Projekt.model;

public class Part {
    private final String name;
    private final int start;
    private final int length;

    public Part(String name, int start, int length) {
        this.name = name;
        this.start = start;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getStart() {
        return start;
    }

    public int getLength() {
        return length;
    }
}
