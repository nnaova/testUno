package monuno.controller;

import monuno.model.IA;
import monuno.model.Joueur;
import monuno.model.Partie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private final Partie partie;

    // Initialisation de la partie
    public Controller() {
        List<Joueur> joueurs = creerJoueurs();
        this.partie = new Partie(joueurs);
    }

    // Créer des joueurs (humains et IA)
    private List<Joueur> creerJoueurs() {
        Scanner scanner = new Scanner(System.in);
        List<Joueur> joueurs = new ArrayList<>();

        System.out.print("Entrez le nombre de joueurs humains : ");
        int nbHumains = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        for (int i = 0; i < nbHumains; i++) {
            System.out.print("Entrez le nom du joueur humain " + (i + 1) + " : ");
            String nom = scanner.nextLine();
            joueurs.add(new Joueur(nom));
        }

        System.out.print("Entrez le nombre de joueurs IA : ");
        int nbIA = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        for (int i = 0; i < nbIA; i++) {
            joueurs.add(new IA("IA" + (i + 1)));
        }

        return joueurs;
    }

    // Lancer la partie
    public void lancerPartie() {
        System.out.println("La partie commence !");
        Joueur gagnant = null;

        while (gagnant == null) {
            partie.jouerTour();
            gagnant = partie.verifierGagnant();
        }

        System.out.println("Le gagnant est " + gagnant.getNom() + " ! Félicitations !");
    }

    // Méthode principale pour démarrer l'application
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.lancerPartie();
    }
}
