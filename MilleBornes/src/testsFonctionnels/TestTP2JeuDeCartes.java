package testsFonctionnels;

import java.util.*;
import cartes.*;
import utils.GestionCartes;

public class TestTP2JeuDeCartes {
    public static <T> boolean verifierOccurrences(List<T> avant, List<T> apres) {
        if (avant.size() != apres.size()) return false;
        Set<T> uniques = new HashSet<>(avant);
        uniques.addAll(apres);

        for (T elem : uniques) {
            int f1 = Collections.frequency(avant, elem);
            int f2 = Collections.frequency(apres, elem);
            if (f1 != f2) {
                System.out.println("❌ Erreur : " + elem + " apparaît " + f1 + " fois avant et " + f2 + " fois après.");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        JeuDeCartes jeu = new JeuDeCartes();
        List<Carte> listeCarteNonMelangee = new LinkedList<>();
        for (Carte carte : jeu.donnerCartes()) {
            listeCarteNonMelangee.add(carte);
        }

        List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);

        System.out.println("=== Jeu original ===");
        System.out.println(listeCarteNonMelangee);
        System.out.println();

        listeCartes = GestionCartes.melanger(listeCartes);
        System.out.println("=== Jeu mélangé ===");
        System.out.println(listeCartes);
        System.out.println();

        System.out.println("Même contenu ? "
                + verifierOccurrences(listeCarteNonMelangee, listeCartes));
        System.out.println("Mélange conforme ? "
                + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
        System.out.println();

        listeCartes = GestionCartes.rassembler(listeCartes);
        System.out.println("=== Jeu rassemblé ===");
        System.out.println(listeCartes);
        System.out.println("Rassemblement correct ? "
                + GestionCartes.verifierRassemblement(listeCartes));
        System.out.println();

        System.out.println("=== Tests unitaires ===");
        System.out.println(GestionCartes.verifierRassemblement(Arrays.asList()));                // []
        System.out.println(GestionCartes.verifierRassemblement(Arrays.asList(1,1,2,1,3)));       // faux
        System.out.println(GestionCartes.verifierRassemblement(Arrays.asList(1,4,3,2)));         // vrai
        System.out.println(GestionCartes.verifierRassemblement(Arrays.asList(1,1,2,3,1)));       // faux
    }
}
