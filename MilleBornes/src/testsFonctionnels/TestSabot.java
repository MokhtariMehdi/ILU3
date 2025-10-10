package testsFonctionnels;

import cartes.*;
import jeu.Sabot;

import java.util.Iterator;

public final class TestSabot {
    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();

        System.out.println("== a) piocher ==");
        Sabot sabot = new Sabot(jeu.donnerCartes());
        while (!sabot.estVide()) {
            Carte c = sabot.piocher();
            System.out.println("je pioche " + c);
        }

        System.out.println("\n== b) itérateur + remove ==");
        sabot = new Sabot(jeu.donnerCartes());
        Iterator<Carte> it = sabot.iterator();
        while (it.hasNext()) {
            Carte c = it.next();
            System.out.println("je pioche " + c);
            it.remove();
        }

        System.out.println("\n== c) exceptions attendues ==");
        sabot = new Sabot(jeu.donnerCartes());
        try {
            Iterator<Carte> it2 = sabot.iterator();
            while (it2.hasNext()) {
                it2.next();
                sabot.piocher();
            }
        } catch (Exception e) {
            System.out.println("OK: " + e.getClass().getSimpleName());
        }

        sabot = new Sabot(jeu.donnerCartes());
        sabot.piocher();
        try {
            Iterator<Carte> it3 = sabot.iterator();
            while (it3.hasNext()) {
                it3.next();
                sabot.ajouterCarte(new Borne(25));
            }
        } catch (Exception e) {
            System.out.println("OK: " + e.getClass().getSimpleName());
        }
    }
}
