package monuno.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import monuno.controller.Controller;

public class InterfaceGraphique extends Application {

    @Override
    public void start(Stage primaryStage) {
        Controller controller = new Controller(); // Initialiser le contrôleur

        // Créer la fenêtre principale
        BorderPane root = new BorderPane();

        // Haut : Titre
        Label titre = new Label("Jeu de Uno");
        titre.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        root.setTop(titre);

        // Centre : Zone de jeu
        VBox zoneDeJeu = new VBox(10);
        Label carteTopDefausse = new Label("Carte sur la défausse : ");
        carteTopDefausse.setStyle("-fx-font-size: 18px;");
        zoneDeJeu.getChildren().add(carteTopDefausse);
        root.setCenter(zoneDeJeu);

        // Bas : Commandes utilisateur
        HBox commandes = new HBox(10);
        Button jouerCarte = new Button("Jouer une carte");
        Button piocherCarte = new Button("Piocher une carte");
        commandes.getChildren().addAll(jouerCarte, piocherCarte);
        root.setBottom(commandes);

        // Actions des boutons
        jouerCarte.setOnAction(event -> {
            // Logique pour jouer une carte (interaction avec Controller)
            System.out.println("Jouer une carte : fonctionnalité en cours d'ajout.");
        });

        piocherCarte.setOnAction(event -> {
            // Logique pour piocher une carte (interaction avec Controller)
            System.out.println("Piocher une carte : fonctionnalité en cours d'ajout.");
        });

        // Configuration de la scène et de la fenêtre
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Uno - Interface Graphique");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
