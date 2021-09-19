package bataille;

import java.util.Arrays;
import java.util.List;

public class Carte {
    private final String couleur;
    private final String valeur;
    private static final List<String> ORDRE_COULEUR = Arrays.asList("carreau", "coeur", "pique", "trèfle");
    private static final List<String> ORDRE_VALEUR = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "valet", "reine", "roi", "as");

    public Carte(String couleur, String valeur) {
        if (!ORDRE_COULEUR.contains(couleur.toLowerCase())) {
            throw new Error("Couleur non existente");
        } else if (!ORDRE_VALEUR.contains(valeur.toLowerCase())) {
            throw new Error("Valeur non existente");
        } else {
            this.couleur = couleur.toLowerCase();
            this.valeur = valeur.toLowerCase();
        }
    }

    public static List<String> getOrdreCouleur() {
        return ORDRE_COULEUR;
    }

    public static List<String> getOrdreValeur() {
        return ORDRE_VALEUR;
    }

    public static int compare(Carte carte1, Carte carte2) {
        if (carte1.valeur.equals(carte2.valeur)) {
            return 0;
        } else if (ORDRE_VALEUR.indexOf(carte1.valeur) > ORDRE_VALEUR.indexOf(carte2.valeur)) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return "Carte{" +
                "couleur='" + couleur + '\'' +
                ", valeur='" + valeur + '\'' +
                '}';
    }
}
