package ElementClasses.BaseMaterials;

public class Plastic extends BaseMaterial {

    public Plastic() {
        super(5);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Plastic);
    }
}
