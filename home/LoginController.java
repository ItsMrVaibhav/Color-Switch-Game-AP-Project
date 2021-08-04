package home;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginController implements Initializable {
    @FXML private ImageView gameLogoLeftO;
    @FXML private ImageView gameLogoRightO;
    @FXML private ImageView topInnerCircle;
    @FXML private ImageView topOuterCircle;
    @FXML private ImageView bottomInnerCircle;
    @FXML private ImageView bottomOuterCircle;

    @FXML private Button LoginButton;
    @FXML private Button RegisterButton;
    @FXML private TextField UserName;
    @FXML private TextField UserPassword;
    @FXML private Pane myPane;
    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RotateTransition rotateTransitionTopInnerLoop = new RotateTransition(Duration.millis(3000), topInnerCircle);
        RotateTransition rotateTransitionTopOuterLoop = new RotateTransition(Duration.millis(3000), topOuterCircle);
        RotateTransition rotateTransitionBottomInnerLoop = new RotateTransition(Duration.millis(3000), bottomInnerCircle);
        RotateTransition rotateTransitionBottomOuterLoop = new RotateTransition(Duration.millis(3000), bottomOuterCircle);
        RotateTransition rotateTransitionGameLogoLeftO = new RotateTransition(Duration.millis(3000), gameLogoLeftO);
        RotateTransition rotateTransitionGameLogoRightO = new RotateTransition(Duration.millis(3000), gameLogoRightO);

        // Setting up transitional constraints
        rotateTransitionTopInnerLoop.setByAngle(360);
        rotateTransitionTopOuterLoop.setByAngle(-360);
        rotateTransitionBottomInnerLoop.setByAngle(-360);
        rotateTransitionBottomOuterLoop.setByAngle(360);
        rotateTransitionGameLogoLeftO.setByAngle(-360);
        rotateTransitionGameLogoRightO.setByAngle(360);

        // Infinite transition
        rotateTransitionTopInnerLoop.setCycleCount(Animation.INDEFINITE);
        rotateTransitionTopOuterLoop.setCycleCount(Animation.INDEFINITE);
        rotateTransitionBottomInnerLoop.setCycleCount(Animation.INDEFINITE);
        rotateTransitionBottomOuterLoop.setCycleCount(Animation.INDEFINITE);
        rotateTransitionGameLogoLeftO.setCycleCount(Animation.INDEFINITE);
        rotateTransitionGameLogoRightO.setCycleCount(Animation.INDEFINITE);

        // Playing transitions
        rotateTransitionTopInnerLoop.play();
        rotateTransitionTopOuterLoop.play();
        rotateTransitionBottomInnerLoop.play();
        rotateTransitionBottomOuterLoop.play();
        rotateTransitionGameLogoLeftO.play();
        rotateTransitionGameLogoRightO.play();
    }

    @FXML TextField Username;
    @FXML PasswordField Password;

    @FXML void registerAndLoadMainMenu(ActionEvent event) throws IOException {
        boolean legitUser = true;
        String mediaPath = System.getProperty("user.dir") + "/src/Sounds/button.wav";
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
        mediaPlayer.play();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/home/profiles.txt"));
            String line;
            String username = Username.getText();
            String password = Password.getText();

            if (username.equals("") || password.equals("")) {
                System.out.println("Don't leave the blanks empty.");
                return;
            }

            // Reading each line
            while ((line = bufferedReader.readLine()) != null) {
                String [] information = line.split("~~~");
                if (information[0].equals(username)) {
                    legitUser = false;
                    break;
                }
            }

            bufferedReader.close();

            if (!legitUser) {
                System.out.println("User already exists. Please try again with some new credentials.");
                Username.setText("");
                Password.setText("");
            } else {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/src/home/profiles.txt", true));
                bufferedWriter.newLine();
                bufferedWriter.write(username + "~~~" + password);
                bufferedWriter.close();
                Stage primaryStage = new Stage();
                primaryStage.setTitle("Main Menu");
                Parent root = FXMLLoader.load(getClass().getResource("/home/mainmenu.fxml"));
                Scene scene = new Scene(root,300,600);
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.show();
                (((Node) event.getSource())).getScene().getWindow().hide();
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File couldn't be loaded." + exception.getMessage());
        }
    }

    @FXML
    public void LoadMainMenu(ActionEvent event) throws IOException {
        boolean legitUser = false;
        String mediaPath = System.getProperty("user.dir") + "/src/Sounds/button.wav";
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
        mediaPlayer.play();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/home/profiles.txt"));
            String line;
            String username = Username.getText();
            String password = Password.getText();

            if (username.equals("") || password.equals("")) {
                System.out.println("Don't leave the blanks empty.");
                return;
            }

            // Reading each line
            while ((line = bufferedReader.readLine()) != null) {
                String information [] = line.split("~~~");

                if (information[0].equals(username) && information[1].equals(password)) {
                    legitUser = true;
                    Stage primaryStage = new Stage();
                    primaryStage.setTitle("Main Menu");
                    Parent root = FXMLLoader.load(getClass().getResource("/home/mainmenu.fxml"));
                    Scene scene = new Scene(root,300,600);
                    primaryStage.setScene(scene);
                    primaryStage.setResizable(false);
                    primaryStage.show();
                    (((Node) event.getSource())).getScene().getWindow().hide();
                    break;
                }
            }

            if (!legitUser) {
                System.out.println("User doesn't exists. Please try again with some valid credentials, or maybe create a new account.");
                Username.setText("");
                Password.setText("");
            }

            bufferedReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File couldn't be loaded." + exception.getMessage());
        }
    }
}
