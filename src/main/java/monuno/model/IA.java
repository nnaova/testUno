package monuno.model;

public class IA extends Joueur {

    // Constructeur pour une IA
    public IA(String nom) {
        super(nom, true);
    }

    // Méthode pour jouer une carte selon une stratégie simple
    public Carte jouerCarte(Carte carteTopDefausse) {
        // Vérifie si une carte de la main peut être jouée
        for (Carte carte : getMain()) {
            if (peutJouer(carte, carteTopDefausse)) {
                retirerCarte(carte);
                return carte;
            }
        }
        return null; // Aucun coup possible, l'IA devra piocher
    }

    // Vérifie si une carte est jouable selon la règle Uno
    private boolean peutJouer(Carte carte, Carte carteTopDefausse) {
        return carte.getCouleur().equals(carteTopDefausse.getCouleur()) ||
                carte.getValues().equals(carteTopDefausse.getValues()) ||
                carte.getCouleur().equals("Noir"); // Les cartes spéciales sont jouables sur tout
    }

    // Méthode pour piocher une carte (simulation d'une action de l'IA)
    public void piocherCarte(Deck deck) {
        Carte cartePiochee = deck.tirerCarte();
        if (cartePiochee != null) {
            ajouterCarte(cartePiochee);
        }
    }
}