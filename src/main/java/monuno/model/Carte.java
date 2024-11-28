package monuno.model;

public class Carte {
    private String color; // Rouge, Bleu, Vert, Jaune, ou "Noir" pour les cartes spéciales
    private String values;  // 0-9, +2, Inverse, Passer, ou "Joker" et "+4"
    private boolean estSpeciale; // Indique si la carte est spéciale

    // Constructeur
    public Carte(String couleur, String valeur) {
        this.color = couleur;
        this.values = valeur;
        this.estSpeciale = valeur.equals("+2") || valeur.equals("Inverse") || valeur.equals("Passer") || valeur.equals("Joker") || valeur.equals("+4");
    }

    // Getter pour la couleur
    public String getCouleur() {
        return color;
    }

    // Setter pour la couleur
    public void setCouleur(String couleur) {
        this.color = couleur;
    }

    // Getter pour la valeur
    public String getValues() {
        return values;
    }

    // Setter pour la valeur
    public void setValues(String values) {
        this.values = values;
        this.estSpeciale = values.equals("+2") || values.equals("Inverse") || values.equals("Passer") || values.equals("Joker") || values.equals("+4");
    }

    // Getter pour estSpeciale
    public boolean isEstSpeciale() {
        return estSpeciale;
    }

    // Méthode toString pour afficher la carte
    @Override
    public String toString() {
        return "Carte{" +
                "couleur='" + color + '\'' +
                ", valeur='" + values + '\'' +
                ", estSpeciale=" + estSpeciale +
                '}';
    }
}
