package utils;
import java.util.*;

public class GestionCartes <T> {
	
	private GestionCartes() {}

    private static final Random random = new Random();
	
	public static <T> T extraire(List<T> liste) {
        int index = (int) (Math.random() * liste.size());
        return liste.remove(index);
    }
	
	public static <T> T extraire_it(List<T> liste) {
		int index = random.nextInt(liste.size());
        ListIterator<T> it = liste.listIterator();
        int currentIndex = 0;
        T element = null;
        while (it.hasNext()) {
            element = it.next();
            if (currentIndex == index) {
                it.remove();
                return element;
            }
            currentIndex++;
        }
        return null;
    }
	
	public static <T> List<T> melanger (List<T> liste) {
		List<T> melange = new ArrayList<>();

        while (!liste.isEmpty()) {
            melange.add(extraire(liste));
        }

        return melange;
	}
	
	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
	    if (liste1.size() != liste2.size()) {
	        return false;
	    }
	    ListIterator<T> it = liste1.listIterator();
	    while (it.hasNext()) {
	        T element = it.next();
	        if (Collections.frequency(liste1, element) != Collections.frequency(liste2, element)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	
}
