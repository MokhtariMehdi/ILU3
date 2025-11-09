package jeu;
import cartes.*;

import java.util.*;


public class ZoneDeJeu {
    private List<Limite> pileLimite;
    private List<Bataille> pileBataille;
    private List<Borne> collectionBornes;

    public ZoneDeJeu() {
        pileLimite = new ArrayList<>();
        pileBataille = new ArrayList<>();
        collectionBornes = new ArrayList<>();
    }

    public int donnerLimitationVitesse() {
        if (pileLimite.isEmpty()) {
            return 200;
        }
        Limite derniere = pileLimite.get(pileLimite.size() - 1);
        if (derniere instanceof FinLimite) {
            return 200;
        }
        return 50;
    }

    public void deposer (Carte c) {
        switch (c) {
            case Limite limite -> pileLimite.add(limite);
            case Bataille bataille -> pileBataille.add(bataille);
            case Borne borne -> collectionBornes.add(borne);
            case null, default -> System.out.println("Type de carte non pris en charge : " + c);
        }
    }

    public int donnerKmParcourus() {
        int total = 0;
        for (Borne b : collectionBornes) {
            total += b.getKm();
        }
        return total;
    }
}
