package ElementClasses.BaseMaterials;

public class Plastic extends BaseMaterial implements Cloneable{

    public Plastic() {
        super(3);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Plastic);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Plastic();
    }

    @Override
    public String toString() {
        return "Plastic";
    }


}
