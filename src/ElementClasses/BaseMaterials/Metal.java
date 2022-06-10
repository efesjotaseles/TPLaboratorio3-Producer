package ElementClasses.BaseMaterials;

public class Metal extends BaseMaterial {

    public Metal() {
        super(10);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Metal);
    }
}
