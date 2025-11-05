package cartes;

public abstract class Carte {
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        return obj.getClass().equals(this.getClass());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
