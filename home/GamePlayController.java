package home;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GamePlayController implements Initializable {
	@FXML private Pane PausePane;
	@FXML private Pane myGameplayPane;
	@FXML private Text gameplayScore;
	@FXML private Ellipse myBall;
	static boolean initialized = false;
	static int levelCounter = 0;
	static Pane lastObstacle;
	static boolean addNewObstacle = true;
	static int spacing = 250;
	static int obstacleCounter = 0;
	static Database database;
	ArrayList <Pane> obstacles = null;
	ArrayList <String> obstaclesNames = null;

	public int getCoordinateX(String type) {
		if (type.equals("Standard Circle")) {
			return 50;
		} else if (type.equals("Big Circle")) {
			return 20;
		} else if (type.equals("Square")) {
			return 75;
		} else if (type.equals("Pink Partial")) {
			return 62;
		} else if (type.equals("Purple Partial")) {
			return 62;
		} else if (type.equals("Yellow Partial")) {
			return 62;
		} else if (type.equals("Blue Partial")) {
			return 62;
		} else if (type.equals("Double Circles")) {
			return 50;
		} else if (type.equals("Color Switcher")) {
			return 112;
		} else if (type.equals("Star")) {
			return 125;
		}

		return 0;
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		if (!initialized) {
			database = new Database();
			obstacles = database.levelEasy;
			obstaclesNames = database.levelEasyNames;
			initialized = true;
			System.out.println("Gameplay initialized");
			Pane box = obstacles.get(obstacleCounter);
			addNewObstacle = false;
			lastObstacle = box;
			box.setLayoutX(getCoordinateX(obstaclesNames.get(obstacleCounter)));
			obstacleCounter++;
			box.setLayoutY(0);
			myGameplayPane.getChildren().add(box);
		}

		if (obstaclesNames != null && obstacles != null) {
			for (int i = 0 ; i < obstacles.size() ; i++) {
				database.animate(obstacles.get(i), obstaclesNames.get(i));
			}
		}
	}

	@FXML
	public void PauseButton(MouseEvent event) throws IOException {
		String mediaPath = System.getProperty("user.dir") + "/src/Sounds/button.wav";
		MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
		mediaPlayer.play();
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Pause Menu");
		Parent root = FXMLLoader.load(getClass().getResource("/home/pause.fxml"));
		Scene scene = new Scene(root,300,600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	public void Resume(ActionEvent event) {
		String mediaPath = System.getProperty("user.dir") + "/src/Sounds/button.wav";
		MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
		mediaPlayer.play();
		System.out.println("Resume");
		PausePane.getScene().getWindow().hide();
	}
	@FXML 
	public void Save(ActionEvent event) {
		String mediaPath = System.getProperty("user.dir") + "/src/Sounds/button.wav";
		MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
		mediaPlayer.play();
		System.out.println("Save");
	}

	@FXML
	public void SaveAndExit(ActionEvent event) {
		String mediaPath = System.getProperty("user.dir") + "/src/Sounds/button.wav";
		MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
		mediaPlayer.play();
		System.out.println("Save and Exit");
	}

	public static int counter = 1;
	public static int ballCounter = 1;

	public void checkCollision() {
		for (Node node : myGameplayPane.getChildren()) {
			Pane pane = (Pane) node;
			try {
				if (pane.getLayoutY() > 0 && (pane.getLayoutY() - myBall.getLayoutY()) <= 360 && (pane.getLayoutY() - myBall.getLayoutY()) >= 180) {
					if (pane.getLayoutX() == 125) {
						String mediaPath = System.getProperty("user.dir") + "/src/Sounds/star.wav";
						MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
						mediaPlayer.play();
						gameplayScore.setText(Integer.toString(Integer.parseInt(gameplayScore.getText()) + 1));
						myGameplayPane.getChildren().remove(node);
						break;
					} else if (pane.getLayoutX() == 112) {
						String mediaPath = System.getProperty("user.dir") + "/src/Sounds/colorswitch.wav";
						MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
						mediaPlayer.play();
						myGameplayPane.getChildren().remove(node);
						String [] colors = new String [] {"FAE100", "900DFF", "FF0181", "32DBF0"};
						myBall.setFill(Color.web(colors[new Random().nextInt(4)]));
						break;
					}
				}
//				if (pane.getLayoutX() == 125) {
//					System.out.println("Star Y - " + pane.getLayoutY());
//					break;
//				} else if (pane.getLayoutX() == 112) {
//					System.out.println("Color Switcher Y - " + pane.getLayoutY());
//					break;
//				}
			} catch (Exception e) {
				int x;
			}
		}
	}

	@FXML
	public void updateScore(MouseEvent event) throws IOException {
		String mediaPath = System.getProperty("user.dir") + "/src/Sounds/jump.wav";
		MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
		mediaPlayer.play();

		if (event.getClickCount() == 1) {
			new AnimationTimer() {
				@Override
				public void handle(long time) {
					if (counter % 51 != 0 && ballCounter % 51 != 0) {
						for (Node node : myGameplayPane.getChildren()) {
							Pane pane = (Pane) node;
							pane.setLayoutY(pane.getLayoutY() + 2);
						}

						myBall.setLayoutY(myBall.getLayoutY() - 1);
						counter += 1;
						ballCounter += 1;
					} else {
						if (ballCounter % 101 != 0) {
							myBall.setLayoutY(myBall.getLayoutY() + 1);
							ballCounter += 1;
						} else {
							counter = 1;
							ballCounter = 1;
							stop();
						}
					}
				}
			}.start();
		}

		if (ballCounter == 1)
			checkCollision();

		if (lastObstacle.getLayoutY() > 0) {
			if (obstacleCounter == 50) {
				System.out.println("Medium");
				obstacleCounter = 0;
				levelCounter++;
				obstacles = database.levelMedium;
				obstaclesNames = database.levelMediumNames;
			} else if (obstacleCounter == 15) {
				System.out.println("Hard I");
				obstacleCounter = 0;
				levelCounter++;
				obstacles = database.levelHardOne;
				obstaclesNames = database.levelHardOneNames;
			} else if (obstacleCounter == 20) {
				System.out.println("Hard II");
				obstacleCounter = 0;
				levelCounter++;
				obstacles = database.levelHardTwo;
				obstaclesNames = database.levelHardTwoNames;
			} else if (obstacleCounter == 25) {
				System.out.println("Insane");
				obstacleCounter = 0;
				levelCounter++;
				obstacles = database.levelInsane;
				obstaclesNames = database.levelInsaneNames;
			} else if (obstacleCounter == 200) {
				System.out.println("Insane");
				obstacleCounter = 0;
				levelCounter++;
				obstacles = database.levelInsane;
				obstaclesNames = database.levelInsaneNames;
			}

			Pane box = obstacles.get(obstacleCounter);
			lastObstacle = box;
			box.setLayoutX(getCoordinateX(obstaclesNames.get(obstacleCounter)));
			obstacleCounter++;
			box.setLayoutY(-spacing);
			myGameplayPane.getChildren().add(box);
		}

		for (Node node : myGameplayPane.getChildren()) {
			Pane pane = (Pane) node;

			if (pane.getLayoutY() > 800) {
				myGameplayPane.getChildren().remove(node);
				break;
			}
		}
	}

	@FXML
	public void MainMenu(ActionEvent event) throws IOException{
		// get to main menu
		String mediaPath = System.getProperty("user.dir") + "/src/Sounds/button.wav";
		MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(mediaPath).toURI().toString()));
		mediaPlayer.play();
		(((Node) event.getSource())).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		primaryStage.setTitle("MAIN MENU");
		Parent root = FXMLLoader.load(getClass().getResource("/home/mainmenu.fxml"));
		Scene scene = new Scene(root,300,600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
