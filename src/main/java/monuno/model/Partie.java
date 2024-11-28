package monuno.model;

import java.util.List;

public class Partie {
    private final List<Joueur> joueurs;
    private final Deck deck;
    private Carte carteTopDefausse;
    private int indexJoueurActuel;
    private boolean sensHoraire;

    // Constructeur
    public Partie(List<Joueur> joueurs) {
        this.joueurs = joueurs;
        this.deck = new Deck();
        this.indexJoueurActuel = 0;
        this.sensHoraire = true;
        initialiserDeck();
        distribuerCartes();
        this.carteTopDefausse = deck.tirerCarte(); // Première carte sur la défausse
    }

    // Initialiser le deck avec toutes les cartes du jeu
    private void initialiserDeck() {
        // Ajout des cartes (implémentation à faire selon les règles de Uno)
    }

    // Distribuer les cartes aux joueurs
    private void distribuerCartes() {
        for (int i = 0; i < 7; i++) { // Chaque joueur reçoit 7 cartes
            for (Joueur joueur : joueurs) {
                joueur.ajouterCarte(deck.tirerCarte());
            }
        }
    }

    // Passer au joueur suivant
    private void passerAuJoueurSuivant() {
        if (sensHoraire) {
            indexJoueurActuel = (indexJoueurActuel + 1) % joueurs.size();
        } else {
            indexJoueurActuel = (indexJoueurActuel - 1 + joueurs.size()) % joueurs.size();
        }
    }

    // Inverser le sens du jeu
    private void inverserSens() {
        sensHoraire = !sensHoraire;
    }

    // Jouer un tour
    public void jouerTour() {
        Joueur joueurActuel = joueurs.get(indexJoueurActuel);
        System.out.println("C'est au tour de " + joueurActuel.getNom());

        Carte carteJouee = null;

        if (joueurActuel instanceof IA) {
            carteJouee = ((IA) joueurActuel).jouerCarte(carteTopDefausse);
        } else {
            // Implémentation pour un joueur humain (selon interface utilisateur)
        }

        if (carteJouee != null) {
            carteTopDefausse = carteJouee;
            appliquerEffetCarte(carteJouee);
        } else {
            joueurActuel.ajouterCarte(deck.tirerCarte());
        }

        passerAuJoueurSuivant();
    }

    // Appliquer l'effet d'une carte spéciale
    private void appliquerEffetCarte(Carte carte) {
        switch (carte.getValues()) {
            case "Inverse":
                inverserSens();
                break;
            case "Passer":
                passerAuJoueurSuivant();
                break;
            case "+2":
                donnerCartesSuivant(2);
                break;
            case "+4":
                donnerCartesSuivant(4);
                break;
            case "Joker":
                // Implémentation pour choisir une couleur
                break;
        }
    }

    // Donner des cartes au joueur suivant
    private void donnerCartesSuivant(int nombreCartes) {
        passerAuJoueurSuivant();
        Joueur joueurSuivant = joueurs.get(indexJoueurActuel);
        for (int i = 0; i < nombreCartes; i++) {
            joueurSuivant.ajouterCarte(deck.tirerCarte());
        }
    }

    // Vérifier si un joueur a gagné
    public Joueur verifierGagnant() {
        for (Joueur joueur : joueurs) {
            if (joueur.nombreDeCartes() == 0) {
                return joueur;
            }
        }
        return null;
    }
}
