package testsFonctionnels;
import cartes.*;

public final class TestJeuDeCartes {
    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();

        System.out.print(jeu.affichageJeuDeCartes());

        Carte[] cartes = jeu.donnerCartes();
        
        System.out.println("\n	V�rification du jeu de cartes :");
        boolean resultat = jeu.checkCount();

        if (resultat) {
            System.out.println("Le jeu de cartes contient le bon nombre d'exemplaires.");
        } else {
            System.out.println("Le jeu de cartes est incorrect.");
        }
    }
}