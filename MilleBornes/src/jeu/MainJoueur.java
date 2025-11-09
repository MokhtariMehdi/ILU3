package jeu;
import cartes.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainJoueur implements Iterable<Carte> {
    private List<Carte> main;

    public MainJoueur() {
        main = new ArrayList<>();
    }

    public void prendre(Carte carte) {
        main.add(carte);
    }

    public void jouer(Carte carte) {
        assert main.contains(carte) : "La carte " + carte + " n’est pas dans la main !";
        main.remove(carte);
    }

    @Override
    public String toString() {
        return main.toString();
    }

    @Override
    public Iterator<Carte> iterator() {
        return main.iterator();
    }

}
