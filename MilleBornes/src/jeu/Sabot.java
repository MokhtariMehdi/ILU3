package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public final class Sabot implements Iterable<Carte> {

    private final Carte[] cartes;
    private int nbCartes;
    private int modCount;

    public Sabot(Carte[] cartes) {
        if (cartes == null) throw new IllegalArgumentException("tableau null");
        this.cartes = cartes;
        this.nbCartes = cartes.length;
        this.modCount = 0;
    }

    public boolean estVide() {
        return nbCartes == 0;
    }

    public void ajouterCarte(Carte carte) {
        if (nbCartes == cartes.length) {
            throw new IllegalStateException("Sabot plein");
        }
        cartes[nbCartes++] = carte;
        modCount++;
    }

    public Carte piocher() {
        Iterator<Carte> it = iterator();
        if (!it.hasNext()) return null;
        Carte c = it.next();
        it.remove();
        return c;
    }

    @Override
    public Iterator<Carte> iterator() {
        return new ItSabot();
    }

    private final class ItSabot implements Iterator<Carte> {

        private int cursor = 0;
        private int lastRet = -1;
        private int expectedModCount = modCount;

        private void checkForComodification() {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException();
        }

        @Override
        public boolean hasNext() {
            return cursor < nbCartes;
        }

        @Override
        public Carte next() {
            checkForComodification();
            if (cursor >= nbCartes) throw new NoSuchElementException();
            lastRet = cursor;
            return cartes[cursor++];
        }

        @Override
        public void remove() {
            checkForComodification();
            if (lastRet < 0) throw new IllegalStateException("next() non appelé ou déjà supprimé");

            int numMoved = nbCartes - lastRet - 1;
            if (numMoved > 0) {
                System.arraycopy(cartes, lastRet + 1, cartes, lastRet, numMoved);
            }
            cartes[--nbCartes] = null;
            cursor = lastRet;
            lastRet = -1;

            modCount++;
            expectedModCount = modCount;
        }
    }
}
