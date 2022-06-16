package ElementClasses.BaseMaterials;

public class Metal extends BaseMaterial {

    public Metal() {
        super(5);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Metal);
    }

    @Override
    public String toString() {
        return "Metal";
    }
}
