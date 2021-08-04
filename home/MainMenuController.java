package home;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenuController implements Initializable {
    @FXML private ImageView mainMenuPlayButton;
    @FXML private ImageView gameLogoLeftO;
    @FXML private ImageView gameLogoRightO;
    @FXML private ImageView innerLoop;
    @FXML private ImageView outerLoop;
    @FXML private Pane mainPain;
    
    @FXML private Button mainMenuButtonOne;
    @FXML private Button mainMenuButtonTwo;
    @FXML private Button mainMenuButtonThree;
    @FXML private Button mainMenuButtonFour;
    @FXML private Pane mainPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization
        RotateTransition rotateTransitionInnerLoop = new RotateTransition(Duration.millis(3000), innerLoop);
        RotateTransition rotateTransitionOuterLoop = new RotateTransition(Duration.millis(3000), outerLoop);
        RotateTransition rotateTransitionGameLogoLeftO = new RotateTransition(Duration.millis(3000), gameLogoLeftO);
        RotateTransition rotateTransitionGameLogoRightO = new RotateTransition(Duration.millis(3000), gameLogoRightO);
        FadeTransition fadeTransitionPlayButton = new FadeTransition(Duration.millis(1000), mainMenuPlayButton);

        // Setting up transitional constraints
        rotateTransitionInnerLoop.setByAngle(360);
        rotateTransitionOuterLoop.setByAngle(-360);
        rotateTransitionGameLogoLeftO.setByAngle(-360);
        rotateTransitionGameLogoRightO.setByAngle(360);
        fadeTransitionPlayButton.setFromValue(1);
        fadeTransitionPlayButton.setToValue(0.5);

        // Infinite transition
        rotateTransitionInnerLoop.setCycleCount(Animation.INDEFINITE);
        rotateTransitionOuterLoop.setCycleCount(Animation.INDEFINITE);
        rotateTransitionGameLogoLeftO.setCycleCount(Animation.INDEFINITE);
        rotateTransitionGameLogoRightO.setCycleCount(Animation.INDEFINITE);
        fadeTransitionPlayButton.setCycleCount(Animation.INDEFINITE);

        // Reversing transitions
        fadeTransitionPlayButton.setAutoReverse(true);

        // Playing transitions
        rotateTransitionInnerLoop.play();
        rotateTransitionGameLogoLeftO.play();
        rotateTransitionGameLogoRightO.play();
        rotateTransitionOuterLoop.play();
        fadeTransitionPlayButton.play();
    }

    @FXML public void aboutPage(MouseEvent event) throws IOException {
        String mediaPath = System.getProperty("user.dir") + "/src/Sounds/button.wav";
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
        mediaPlayer.play();
        Stage primaryStage = new Stage();
        primaryStage.setTitle("About");
        Parent root = FXMLLoader.load(getClass().getResource("/home/about.fxml"));
        Scene scene = new Scene(root, 300, 600);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML public void backToMainMenu(MouseEvent event) throws IOException {
        String mediaPath = System.getProperty("user.dir") + "/src/Sounds/button.wav";
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
        mediaPlayer.play();
        Stage primaryStage = new Stage();
        primaryStage.setTitle("About");
        Parent root = FXMLLoader.load(getClass().getResource("/home/mainmenu.fxml"));
        Scene scene = new Scene(root, 300, 600);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML public void backToLoginScreen(ActionEvent event) throws IOException {
        String mediaPath = System.getProperty("user.dir") + "/src/Sounds/button.wav";
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
        mediaPlayer.play();
        Stage primaryStage = new Stage();
        primaryStage.setTitle("About");
        Parent root = FXMLLoader.load(getClass().getResource("/home/login.fxml"));
        Scene scene = new Scene(root, 300, 600);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    public void StartNewGame(ActionEvent event) throws IOException {
        String mediaPath = System.getProperty("user.dir") + "/src/Sounds/start.wav";
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
        mediaPlayer.play();
		Stage primaryStage = new Stage();
		primaryStage.setTitle("GAME PLAY");
		Parent root = FXMLLoader.load(getClass().getResource("/home/gameplay.fxml"));
		Scene scene = new Scene(root,300,600);
		primaryStage.setScene(scene);
        primaryStage.setResizable(false);
		primaryStage.show();
		(((Node) event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    public void LoadSavedGameMenu(ActionEvent event) {
        String mediaPath = System.getProperty("user.dir") + "/src/Sounds/button.wav";
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
        mediaPlayer.play();
        System.out.println("WORK IN PROGRESS");
    }

    @FXML
    public void ExitGame(ActionEvent event) {
        String mediaPath = System.getProperty("user.dir") + "/src/Sounds/button.wav";
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
        mediaPlayer.play();
    	System.out.println("EXITING");
    	System.exit(0);
    }
    
}
