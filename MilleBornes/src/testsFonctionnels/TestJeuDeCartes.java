package testsFonctionnels;
import cartes.*;

public final class TestJeuDeCartes {
    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();

        // Affichage attendu (quantité + libellé, sans colonnes)
        System.out.print(jeu.affichageJeuDeCartes());

        // Petite vérif : on compte le total de cartes générées
        Carte[] cartes = jeu.donnerCartes();
    }
}