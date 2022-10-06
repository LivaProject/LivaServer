package fr.liva.server.options;

public class OptionValue {

    private Object object;

    public OptionValue(Object object) {
        this.object = object;
    }

    public String getString() {
        return String.valueOf(object);
    }

    public int getInt() {
        return Integer.parseInt(String.valueOf(object));
    }
}
