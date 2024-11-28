package monuno.model;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;
    private List<Carte> main;
    private boolean estIA; // Indique si le joueur est une IA

    // Constructeur pour un joueur humain
    public Joueur(String nom) {
        this.nom = nom;
        this.main = new ArrayList<>();
        this.estIA = false;
    }

    // Constructeur pour une IA
    public Joueur(String nom, boolean estIA) {
        this.nom = nom;
        this.main = new ArrayList<>();
        this.estIA = estIA;
    }

    // Ajouter une carte à la main
    public void ajouterCarte(Carte carte) {
        main.add(carte);
    }

    // Retirer une carte de la main
    public boolean retirerCarte(Carte carte) {
        return main.remove(carte);
    }

    // Obtenir le nombre de cartes dans la main
    public int nombreDeCartes() {
        return main.size();
    }

    // Vérifier si le joueur a une carte spécifique (par couleur ou valeur)
    public boolean aCarte(String couleur, String valeur) {
        return main.stream().anyMatch(carte -> carte.getCouleur().equals(couleur) && carte.getValues().equals(valeur));
    }

    // Afficher les cartes du joueur
    public void afficherMain() {
        System.out.println("Main de " + nom + ":");
        for (Carte carte : main) {
            System.out.println(carte);
        }
    }

    // Getter pour le nom
    public String getNom() {
        return nom;
    }

    // Setter pour le nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour estIA
    public boolean isEstIA() {
        return estIA;
    }

    // Setter pour estIA
    public void setEstIA(boolean estIA) {
        this.estIA = estIA;
    }

    // Getter pour la main
    public List<Carte> getMain() {
        return main;
    }

    // Setter pour la main
    public void setMain(List<Carte> main) {
        this.main = main;
    }
}