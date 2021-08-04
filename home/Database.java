package home;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.File;
import java.util.Random;

import java.util.ArrayList;

public class Database {
    final ArrayList <Pane> levelEasy = new ArrayList <Pane> ();
    final ArrayList <Pane> levelMedium = new ArrayList <Pane> ();
    final ArrayList <Pane> levelHardOne = new ArrayList <Pane> ();
    final ArrayList <Pane> levelHardTwo = new ArrayList <Pane> ();
    final ArrayList <Pane> levelInsane = new ArrayList <Pane> ();
    final ArrayList <String> levelEasyNames = new ArrayList <String> ();
    final ArrayList <String> levelMediumNames = new ArrayList <String> ();
    final ArrayList <String> levelHardOneNames = new ArrayList <String> ();
    final ArrayList <String> levelHardTwoNames = new ArrayList <String> ();
    final ArrayList <String> levelInsaneNames = new ArrayList <String> ();
    final int levelEasySize = 50;
    final int levelMediumSize = 15;
    final int levelHardOneSize = 20;
    final int levelHardTwoSize = 25;
    final int levelInsaneSize = 200;
    String obstacleType = "";
    final int numberOfObstacles = 15;

    public Database () {
        for (int i = 0 ; i < levelEasySize ; i++) {
            int index = new Random().nextInt(numberOfObstacles);
            levelEasy.add(getObstacle(index));
            levelEasyNames.add(obstacleType);
        }

        for (int i = 0 ; i < levelMediumSize ; i++) {
            int index = new Random().nextInt(numberOfObstacles);
            levelMedium.add(getObstacle(index));
            levelMediumNames.add(obstacleType);
        }

        for (int i = 0 ; i < levelHardOneSize ; i++) {
            int index = new Random().nextInt(numberOfObstacles);
            levelHardOne.add(getObstacle(index));
            levelHardOneNames.add(obstacleType);
        }

        for (int i = 0 ; i < levelHardTwoSize ; i++) {
            int index = new Random().nextInt(numberOfObstacles);
            levelHardTwo.add(getObstacle(index));
            levelHardTwoNames.add(obstacleType);
        }

        for (int i = 0 ; i < levelInsaneSize ; i++) {
            int index = new Random().nextInt(numberOfObstacles);
            levelInsane.add(getObstacle(index));
            levelInsaneNames.add(obstacleType);
        }
    }

    public void animate(Pane pane, String type) {
        if (type.equals("Standard Circle")) {
            RotateTransition rotateTransitionOne = new RotateTransition(Duration.millis(3000), pane);
            rotateTransitionOne.setByAngle(360);
            rotateTransitionOne.setCycleCount(Animation.INDEFINITE);
            rotateTransitionOne.play();
        } else if (type.equals("Big Circle")) {
            RotateTransition rotateTransitionOne = new RotateTransition(Duration.millis(3000), pane);
            rotateTransitionOne.setByAngle(360);
            rotateTransitionOne.setCycleCount(Animation.INDEFINITE);
            rotateTransitionOne.play();
        } else if (type.equals("Square")) {
            RotateTransition rotateTransitionOne = new RotateTransition(Duration.millis(3000), pane);
            rotateTransitionOne.setByAngle(360);
            rotateTransitionOne.setCycleCount(Animation.INDEFINITE);
            rotateTransitionOne.play();
        } else if (type.equals("Pink Partial")) {
            RotateTransition rotateTransitionOne = new RotateTransition(Duration.millis(3000), pane);
            rotateTransitionOne.setByAngle(360);
            rotateTransitionOne.setCycleCount(Animation.INDEFINITE);
            rotateTransitionOne.play();
        } else if (type.equals("Purple Partial")) {
            RotateTransition rotateTransitionOne = new RotateTransition(Duration.millis(3000), pane);
            rotateTransitionOne.setByAngle(360);
            rotateTransitionOne.setCycleCount(Animation.INDEFINITE);
            rotateTransitionOne.play();
        } else if (type.equals("Yellow Partial")) {
            RotateTransition rotateTransitionOne = new RotateTransition(Duration.millis(3000), pane);
            rotateTransitionOne.setByAngle(360);
            rotateTransitionOne.setCycleCount(Animation.INDEFINITE);
            rotateTransitionOne.play();
        } else if (type.equals("Blue Partial")) {
            RotateTransition rotateTransitionOne = new RotateTransition(Duration.millis(3000), pane);
            rotateTransitionOne.setByAngle(360);
            rotateTransitionOne.setCycleCount(Animation.INDEFINITE);
            rotateTransitionOne.play();
        } else if (type.equals("Double Circles")) {
            RotateTransition rotateTransitionOne = new RotateTransition(Duration.millis(3000), pane.getChildren().get(0));
            RotateTransition rotateTransitionTwo = new RotateTransition(Duration.millis(3000), pane.getChildren().get(1));
            rotateTransitionOne.setByAngle(-360);
            rotateTransitionTwo.setByAngle(360);
            rotateTransitionOne.setCycleCount(Animation.INDEFINITE);
            rotateTransitionTwo.setCycleCount(Animation.INDEFINITE);
            rotateTransitionOne.play();
            rotateTransitionTwo.play();
        } else if (type.equals("Color Switcher")) {
            RotateTransition rotateTransitionOne = new RotateTransition(Duration.millis(3000), pane);
            rotateTransitionOne.setByAngle(360);
            rotateTransitionOne.setCycleCount(Animation.INDEFINITE);
            rotateTransitionOne.play();
        } else if (type.equals("Star")) {
            RotateTransition rotateTransitionOne = new RotateTransition(Duration.millis(3000), pane);
            rotateTransitionOne.setByAngle(360);
            rotateTransitionOne.setCycleCount(Animation.INDEFINITE);
            rotateTransitionOne.play();
        }
    }

    public Pane getObstacle(int index) {
        switch (index) {
            case 0:
                obstacleType = "Standard Circle";
                return getStandardCircle();
            case 1:
                obstacleType = "Big Circle";
                return getBigCircle();
            case 2:
                obstacleType = "Square";
                return getSquare();
            case 3:
                obstacleType = "Pink Partial";
                return getPinkPartial();
            case 4:
                obstacleType = "Purple Partial";
                return getPurplePartial();
            case 5:
                obstacleType = "Yellow Partial";
                return getYellowPartial();
            case 6:
                obstacleType = "Blue Partial";
                return getBluePartial();
            case 7:
                obstacleType = "Double Circles";
                return getDoubleCircles();
            case 8:
            case 12:
            case 13:
                obstacleType = "Color Switcher";
                return getColorSwitcher();
            case 9:
            case 10:
            case 11:
            case 14:
                obstacleType = "Star";
                return getStar();
        }

        return null;
    }

//    public void animateStand

    public VBox getColorSwitcher() {
        VBox vBox = new VBox();
        ImageView imageView = new ImageView(getClass().getResource("Assets/Color Switcher.png").toExternalForm());
        imageView.setFitWidth(75);
        imageView.setFitHeight(75);
        vBox.getChildren().add(imageView);

        return vBox;
    }

    public VBox getStar() {
        VBox vBox = new VBox();
        ImageView imageView = new ImageView(getClass().getResource("Assets/Star.png").toExternalForm());
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        vBox.getChildren().add(imageView);

        return vBox;
    }

    public VBox getStandardCircle() {
        VBox vBox = new VBox();
        HBox hBoxOne = new HBox();
        HBox hBoxTwo = new HBox();

        ImageView imageView = new ImageView(getClass().getResource("Assets/Circle-Yellow.png").toExternalForm());
        hBoxOne.getChildren().add(imageView);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView = new ImageView(getClass().getResource("Assets/Circle-Purple.png").toExternalForm());
        hBoxOne.getChildren().add(imageView);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView = new ImageView(getClass().getResource("Assets/Circle-Blue.png").toExternalForm());
        hBoxTwo.getChildren().add(imageView);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView = new ImageView(getClass().getResource("Assets/Circle-Pink.png").toExternalForm());
        hBoxTwo.getChildren().add(imageView);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        vBox.getChildren().addAll(hBoxOne, hBoxTwo);

        return vBox;
    }

    public VBox getBigCircle() {
        VBox vBox = new VBox();
        HBox hBoxOne = new HBox();
        HBox hBoxTwo = new HBox();
        ImageView imageView = new ImageView(getClass().getResource("Assets/Circle-Yellow.png").toExternalForm());
        imageView.setFitWidth(130);
        imageView.setFitHeight(130);
        hBoxOne.getChildren().add(imageView);
        imageView = new ImageView(getClass().getResource("Assets/Circle-Purple.png").toExternalForm());
        imageView.setFitWidth(130);
        imageView.setFitHeight(130);
        hBoxOne.getChildren().add(imageView);
        imageView = new ImageView(getClass().getResource("Assets/Circle-Blue.png").toExternalForm());
        imageView.setFitWidth(130);
        imageView.setFitHeight(130);
        hBoxTwo.getChildren().add(imageView);
        imageView = new ImageView(getClass().getResource("Assets/Circle-Pink.png").toExternalForm());
        imageView.setFitWidth(130);
        imageView.setFitHeight(130);
        hBoxTwo.getChildren().add(imageView);
        vBox.getChildren().addAll(hBoxOne, hBoxTwo);

        return vBox;
    }

    public VBox getSquare() {
        VBox vBox = new VBox();
        HBox hBoxOne = new HBox();
        HBox hBoxTwo = new HBox();
        HBox hBoxThree = new HBox();
        ImageView imageView = new ImageView(getClass().getResource("Assets/Square-Purple.png").toExternalForm());
        imageView.setFitWidth(150);
        imageView.setFitHeight(25);
        hBoxOne.getChildren().add(imageView);
        imageView = new ImageView(getClass().getResource("Assets/Square-Yellow.png").toExternalForm());
        imageView.setFitWidth(25);
        imageView.setFitHeight(150);
        hBoxTwo.getChildren().add(imageView);
        imageView = new ImageView(getClass().getResource("Assets/Square-Blue.png").toExternalForm());
        imageView.setFitWidth(25);
        imageView.setFitHeight(150);
        hBoxTwo.getChildren().add(imageView);
        imageView = new ImageView(getClass().getResource("Assets/Square-Pink.png").toExternalForm());
        imageView.setFitWidth(150);
        imageView.setFitHeight(25);
        hBoxThree.getChildren().add(imageView);

        hBoxTwo.setSpacing(100);

        vBox.getChildren().addAll(hBoxOne, hBoxTwo, hBoxThree);

        return vBox;
    }

    public VBox getPinkPartial() {
        VBox vBox = new VBox();
        ImageView imageView = new ImageView(getClass().getResource("Assets/Partial-Pink.png").toExternalForm());
        imageView.setFitWidth(175);
        imageView.setFitHeight(175);
        vBox.getChildren().add(imageView);

        return vBox;
    }

    public VBox getPurplePartial() {
        VBox vBox = new VBox();
        ImageView imageView = new ImageView(getClass().getResource("Assets/Partial-Purple.png").toExternalForm());
        imageView.setFitWidth(175);
        imageView.setFitHeight(175);
        vBox.getChildren().add(imageView);

        return vBox;
    }

    public VBox getYellowPartial() {
        VBox vBox = new VBox();
        ImageView imageView = new ImageView(getClass().getResource("Assets/Partial-Yellow.png").toExternalForm());
        imageView.setFitWidth(175);
        imageView.setFitHeight(175);
        vBox.getChildren().add(imageView);

        return vBox;
    }

    public VBox getBluePartial() {
        VBox vBox = new VBox();
        ImageView imageView = new ImageView(getClass().getResource("Assets/Partial-Blue.png").toExternalForm());
        imageView.setFitWidth(175);
        imageView.setFitHeight(175);
        vBox.getChildren().add(imageView);

        return vBox;
    }

    public HBox getDoubleCircles() {
        HBox hBox = new HBox();
        VBox vBoxOne = new VBox();
        VBox vBoxTwo = new VBox();
        HBox hBoxOne = new HBox();
        HBox hBoxTwo = new HBox();
        HBox hBoxThree = new HBox();
        HBox hBoxFour = new HBox();

        ImageView imageView = new ImageView(getClass().getResource("Assets/Left-Yellow.png").toExternalForm());
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        hBoxOne.getChildren().add(imageView);

        imageView = new ImageView(getClass().getResource("Assets/Left-Purple.png").toExternalForm());
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        hBoxOne.getChildren().add(imageView);

        imageView = new ImageView(getClass().getResource("Assets/Left-Blue.png").toExternalForm());
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        hBoxTwo.getChildren().add(imageView);

        imageView = new ImageView(getClass().getResource("Assets/Left-Pink.png").toExternalForm());
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        hBoxTwo.getChildren().add(imageView);

        imageView = new ImageView(getClass().getResource("Assets/Right-Purple.png").toExternalForm());
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        hBoxThree.getChildren().add(imageView);

        imageView = new ImageView(getClass().getResource("Assets/Right-Yellow.png").toExternalForm());
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        hBoxThree.getChildren().add(imageView);

        imageView = new ImageView(getClass().getResource("Assets/Right-Pink.png").toExternalForm());
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        hBoxFour.getChildren().add(imageView);

        imageView = new ImageView(getClass().getResource("Assets/Right-Blue.png").toExternalForm());
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        hBoxFour.getChildren().add(imageView);

        vBoxOne.getChildren().addAll(hBoxOne, hBoxTwo);
        vBoxTwo.getChildren().addAll(hBoxThree, hBoxFour);
        hBox.getChildren().addAll(vBoxOne, vBoxTwo);

        return hBox;
    }

//    public VBox getPlus() {
//        VBox vBox = new VBox();
//        HBox hBoxOne = new HBox();
//        HBox hBoxTwo = new HBox();
//        HBox hBoxThree = new HBox();
//
//        ImageView imageView = new ImageView(getClass().getResource("Assets/Plus-Purple.png").toExternalForm());
//        hBoxOne.getChildren().add(imageView);
//
//        imageView = new ImageView(getClass().getResource("Assets/Plus-Yellow.png").toExternalForm());
//        hBoxTwo.getChildren().add(imageView);
//
//        imageView = new ImageView(getClass().getResource("Assets/Plus-Center.png").toExternalForm());
//        hBoxTwo.getChildren().add(imageView);
//
//        imageView = new ImageView(getClass().getResource("Assets/Plus-Blue.png").toExternalForm());
//        hBoxTwo.getChildren().add(imageView);
//
//        imageView = new ImageView(getClass().getResource("Assets/Plus-Pink.png").toExternalForm());
//        hBoxThree.getChildren().add(imageView);
//
//        vBox.getChildren().addAll(hBoxOne, hBoxTwo, hBoxThree);
//
//        return vBox;
//    }
}
