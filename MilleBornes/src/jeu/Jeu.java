package jeu;

import java.util.*;
import cartes.*;
import utils.GestionCartes;

public class Jeu {

    private Sabot sabot;

    public Jeu() {
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        List<Carte> listeCartes = new ArrayList<>();
        for (Carte c : jeuDeCartes.donnerCartes()) {
            listeCartes.add(c);
        }
        listeCartes = GestionCartes.melanger(listeCartes);
        Carte[] tableauMelange = listeCartes.toArray(new Carte[0]);
        sabot = new Sabot(tableauMelange);
        System.out.println("\nSabot créé avec " + tableauMelange.length + " cartes mélangées !");
    }

    public Sabot getSabot() {
        return sabot;
    }

    public static void main(String[] args) {
        new Jeu();
    }
}
