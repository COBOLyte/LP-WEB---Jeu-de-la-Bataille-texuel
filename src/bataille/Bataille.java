package bataille;

import java.util.ArrayList;
import java.util.Collections;

public class Bataille {
    public static void main(String[] args) {
        ArrayList<Carte> paquetCartes = new ArrayList<>();
        for (String couleur : Carte.getOrdreCouleur()) {
            for (String valeur : Carte.getOrdreValeur()) {
                paquetCartes.add(new Carte(couleur, valeur));
            }
        }
        Collections.shuffle(paquetCartes);

        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                joueur1.ajouterCarte(paquetCartes.get(i));
            } else {
                joueur2.ajouterCarte(paquetCartes.get(i));
            }
        }

        int tourCpt = 1;
        boolean batailleActive;
        Carte carteTireeJoueur1;
        Carte carteTireeJoueur2;
        ArrayList<Carte> cartesTirees = new ArrayList<>();

        while (joueur1.getPaquetCartes().size() > 0 && joueur2.getPaquetCartes().size() > 0) {
            System.out.println("                <=< Tour " + tourCpt + " >=>");

            carteTireeJoueur1 = joueur1.tirerCarte();
            System.out.println("Joueur 1 tire " + carteTireeJoueur1.toString());
            carteTireeJoueur2 = joueur2.tirerCarte();
            System.out.println("Joueur 2 tire " + carteTireeJoueur2.toString());

            cartesTirees.add(carteTireeJoueur1);
            cartesTirees.add(carteTireeJoueur2);
            Collections.shuffle(cartesTirees);

            if (Carte.compare(carteTireeJoueur1, carteTireeJoueur2) == 0) {
                batailleActive = true;
                System.out.println("*BATAILLE !*");
            } else {
                batailleActive = false;

                if (Carte.compare(carteTireeJoueur1, carteTireeJoueur2) == 1) {
                    joueur1.ajouterCarte(cartesTirees);
                    System.out.println("Joueur 1 gagne. -> +" + cartesTirees.size() + " cartes.");
                } else {
                    joueur2.ajouterCarte(cartesTirees);
                    System.out.println("Joueur 2 gagne. -> +" + cartesTirees.size() + " cartes.");
                }
            }

            if (joueur2.getPaquetCartes().size() == 0) {
                joueur1.ajouterCarte(cartesTirees);
            } else if (joueur1.getPaquetCartes().size() == 0) {
                joueur2.ajouterCarte(cartesTirees);
            }

            if (!batailleActive) {
                cartesTirees.clear();
            }

            System.out.println("Joueur 1 possède actuellement " + joueur1.getPaquetCartes().size() + " carte(s).");
            System.out.println("Joueur 2 possède actuellement " + joueur2.getPaquetCartes().size() + " carte(s).");
            System.out.println();
            tourCpt++;
        }

        if (joueur1.getPaquetCartes().size() > joueur2.getPaquetCartes().size()) {
            System.out.println("Vainqueur: Joueur 1");
            System.out.println("Perdant: Joueur 2");
        } else {
            System.out.println("Vainqueur: Joueur 2");
            System.out.println("Perdant: Joueur 1");
        }
    }
}
