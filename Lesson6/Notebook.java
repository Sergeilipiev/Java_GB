package Lesson6;

public class Notebook {
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Notebook(String model, int ram, int storage, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "model='" + model + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

