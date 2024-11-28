package monuno.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Carte> pioche;
    private List<Carte> defausse;

    // Constructeur par défaut
    public Deck() {
        this.pioche = new ArrayList<>();
        this.defausse = new ArrayList<>();
    }

    // Constructeur avec listes initiales
    public Deck(List<Carte> pioche, List<Carte> defausse) {
        this.pioche = pioche;
        this.defausse = defausse;
    }

    // Fonction pour mélanger la pioche
    public void melanger() {
        Collections.shuffle(pioche);
    }

    // Fonction pour tirer une carte de la pioche
    public Carte tirerCarte() {
        if (pioche.isEmpty()) {
            recyclerDefausse();
        }
        return pioche.isEmpty() ? null : pioche.remove(0);
    }

    // Fonction pour recycler la défausse dans la pioche
    private void recyclerDefausse() {
        if (!defausse.isEmpty()) {
            pioche.addAll(defausse);
            defausse.clear();
            melanger();
        }
    }

    // Fonction pour ajouter une carte à la défausse
    public void ajouterCarteDefausse(Carte carte) {
        defausse.add(carte);
    }

    // Getter pour la pioche
    public List<Carte> getPioche() {
        return pioche;
    }

    // Setter pour la pioche
    public void setPioche(List<Carte> pioche) {
        this.pioche = pioche;
    }

    // Getter pour la défausse
    public List<Carte> getDefausse() {
        return defausse;
    }

    // Setter pour la défausse
    public void setDefausse(List<Carte> defausse) {
        this.defausse = defausse;
    }
}
