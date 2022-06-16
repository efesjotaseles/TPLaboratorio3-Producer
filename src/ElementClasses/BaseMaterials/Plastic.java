package ElementClasses.BaseMaterials;

public class Plastic extends BaseMaterial {

    public Plastic() {
        super(3);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Plastic);
    }

    @Override
    public String toString() {
        return "Plastic";
    }
}
