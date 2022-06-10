package ElementClasses.BaseMaterials;

import ElementClasses.BaseMaterials.BaseMaterial;

public class Wood extends BaseMaterial {
    public Wood() {
        super(2);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Wood);
    }

    @Override
    public String toString() {
        return "Wood";
    }
}
