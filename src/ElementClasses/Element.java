package ElementClasses;

public abstract class Element {
    private int value;

    public Element(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
