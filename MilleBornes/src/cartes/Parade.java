package cartes;

public final class Parade extends Bataille {
    public Parade(Type type) {
        super(type);
    }
    @Override
    public String toString() {
        return getType().getParade();
    }

}