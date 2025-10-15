package testsFonctionnels;
import cartes.*;

public final class TestJeuDeCartes {
    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();

        System.out.print(jeu.affichageJeuDeCartes());

        Carte[] cartes = jeu.donnerCartes();
    }
}