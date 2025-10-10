package cartes;


public final class JeuDeCartes {

    private final Configuration[] typesDeCartes;

    public JeuDeCartes() {
        typesDeCartes = new Configuration[] {
            new Configuration(new Borne(25), 10),
            new Configuration(new Borne(50), 10),
            new Configuration(new Borne(75), 10),
            new Configuration(new Borne(100), 12),
            new Configuration(new Borne(200), 4),

            new Configuration(new Parade(Type.FEU), 14), 
            new Configuration(new FinLimite(), 6),
            new Configuration(new Parade(Type.ESSENCE), 6),
            new Configuration(new Parade(Type.CREVAISON), 6),
            new Configuration(new Parade(Type.ACCIDENT), 6),

            new Configuration(new Attaque(Type.FEU), 5),       
            new Configuration(new DebutLimite(), 4),
            new Configuration(new Attaque(Type.ESSENCE), 3),
            new Configuration(new Attaque(Type.CREVAISON), 3),
            new Configuration(new Attaque(Type.ACCIDENT), 3),

            new Configuration(new Botte(Type.FEU), 1),
            new Configuration(new Botte(Type.ESSENCE), 1),
            new Configuration(new Botte(Type.CREVAISON), 1),
            new Configuration(new Botte(Type.ACCIDENT), 1)
        };
    }

    public String affichageJeuDeCartes() {
        StringBuilder sb = new StringBuilder();
        sb.append("JEU :\n\n");
        for (Configuration c : typesDeCartes) {
            sb.append(c.getNbExemplaires())
              .append(' ')
              .append(c.getCarte().toString())
              .append('\n');
        }
        return sb.toString();
    }

    public Configuration[] getTypesDeCartes() { return typesDeCartes; }

    public Carte[] donnerCartes() {
        int total = 0;
        for (Configuration c : typesDeCartes        )
            total += c.getNbExemplaires();

        Carte[] toutes = new Carte[total];
        int i = 0;

        for (Configuration c : typesDeCartes) {
            for (int k = 0; k < c.getNbExemplaires(); k++) {
                Carte carte = c.getCarte();
                if (carte instanceof Borne) {
                    toutes[i++] = new Borne(((Borne) carte).getKm());
                } else if (carte instanceof Attaque) {
                    toutes[i++] = new Attaque(((Attaque) carte).getType());
                } else if (carte instanceof Parade) {
                    toutes[i++] = new Parade(((Parade) carte).getType());
                } else if (carte instanceof Botte) {
                    toutes[i++] = new Botte(((Botte) carte).getType());
                } else if (carte instanceof DebutLimite) {
                    toutes[i++] = new DebutLimite();
                } else if (carte instanceof FinLimite) {
                    toutes[i++] = new FinLimite();
                }
            }
        }
        return toutes;
    }
}

