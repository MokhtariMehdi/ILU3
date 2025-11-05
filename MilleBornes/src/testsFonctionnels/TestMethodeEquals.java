package testsFonctionnels;

import cartes.*;

public class TestMethodeEquals {

    public static void main(String[] args) {
        Borne borne1 = new Borne(25);
        Borne borne2 = new Borne(25);

        Attaque feuRouge1 = new Attaque(Type.FEU);
        Attaque feuRouge2 = new Attaque(Type.FEU);

        Attaque feuRouge3 = new Attaque(Type.FEU);
        Parade feuVert1 = new Parade(Type.FEU);

        System.out.println("Deux cartes de 25km sont identiques ? " + borne1.equals(borne2));
        System.out.println("Deux cartes de feux rouges sont identiques ? " + feuRouge1.equals(feuRouge2));
        System.out.println("Une carte Feu rouge et une Feu vert sont identiques ? " + feuRouge3.equals(feuVert1));
    }
}
