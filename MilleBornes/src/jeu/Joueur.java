package jeu;
import cartes.*;
import jeu.MainJoueur;

public class Joueur {
    private String nom;
    private ZoneDeJeu zoneDeJeu;
    private MainJoueur main;

    public Joueur(String nom) {
        this.nom = nom;
        this.zoneDeJeu = new ZoneDeJeu();
        this.main = new MainJoueur();
    }

    public String getNom() {
        return nom;
    }

    public ZoneDeJeu getZoneDeJeu() {
        return zoneDeJeu;
    }

    public MainJoueur getMain() {
        return main;
    }

    public void donner (Carte carte) {
        main.prendre(carte);
    }

    public Carte prendreCarte (Sabot sabot) {
        if (sabot.estVide()) {
            return null;
        }
        Carte c = sabot.piocher();;
        main.prendre(c);
        return c;
    }

    public int donnerKmParcourus() {
        return zoneDeJeu.donnerKmParcourus();
    }


    @Override
    public String toString() {
        return nom + " " + main;
    }

    @Override
    public boolean equals(Object obj) {
        return this.nom.equals(((Joueur)obj).nom);
    }
}
