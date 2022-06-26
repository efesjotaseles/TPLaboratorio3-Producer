package ElementClasses.BaseMaterials;

public class Metal extends BaseMaterial implements Cloneable{

    public Metal() {
        super(5);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Metal);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Metal();
    }

    @Override
    public String toString() {
        return "Metal";
    }


}
