package sample;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class About implements Initializable {
    public AnchorPane aboutpane;
    public HBox menubar;

    public javafx.scene.image.ImageView biopic1;
    public javafx.scene.image.ImageView biopic2;
    public javafx.scene.image.ImageView biopic3;
    public javafx.scene.image.ImageView biopic4;
    public VBox biolabel1;
    public VBox biolabel2;
    public VBox biolabel3;
    public VBox biolabel4;
    public int i=0;

    FadeTransition fadeTransition = new FadeTransition();
    TranslateTransition translateTransition = new TranslateTransition();
    TranslateTransition translateTransition2 = new TranslateTransition();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        menubar.setVisible(false);

        biolabel1.setVisible(false);
        biolabel2.setVisible(false);
        biolabel3.setVisible(false);
        biolabel4.setVisible(false);



        roundCorners(biopic1);
        roundCorners(biopic2);
        roundCorners(biopic3);
        roundCorners(biopic4);



    }

    public void loadcalculator(ActionEvent actionEvent) throws IOException {
        AnchorPane calculatorpane =FXMLLoader.load(
                getClass().getResource("calculator.fxml"));
        aboutpane.getChildren().setAll(calculatorpane);
    }



    public void homeclick(ActionEvent actionEvent) {
    }

    public void quit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void loadhome(ActionEvent actionEvent) throws IOException {
        AnchorPane homepane = FXMLLoader.load(
                getClass().getResource("sample.fxml"));
        aboutpane.getChildren().setAll(homepane);
    }

    public void menu(MouseEvent mouseEvent) {

        if(i==0){
            menubar.setVisible(true);
            fadeTransition.setDuration(Duration.seconds(0.5));
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.setNode(menubar);
            fadeTransition.play();



            translateTransition.setDuration(Duration.seconds(0.5));
            translateTransition.setByX(15);
            translateTransition.setFromX(0);
            translateTransition.setToX(15);
            translateTransition.setNode(menubar);
            translateTransition.play();

            i=1;

        }
        else {


            fadeTransition.setDuration(Duration.seconds(0.5));
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.setNode(menubar);
            fadeTransition.play();

            translateTransition.setDuration(Duration.seconds(0.5));
            translateTransition.setByX(15);
            translateTransition.setFromX(15);
            translateTransition.setToX(0);
            translateTransition.setNode(menubar);
            translateTransition.play();
            i=0;
        }

    }

    public void bio1span(MouseEvent mouseEvent) {

        biospan(biolabel1,biopic1);


    }

    public void bio2span(MouseEvent mouseEvent) {

        biospan(biolabel2,biopic2);


    }

    public void bio3span(MouseEvent mouseEvent) {

        biospan(biolabel3,biopic3);

    }

    public void bio4span(MouseEvent mouseEvent) {

        biospan(biolabel4,biopic4);

    }

    public void biospan(VBox label, ImageView image) {

        label.setVisible(true);

        fadeTransition.setDuration(Duration.seconds(0.3));
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setNode(label);
        fadeTransition.play();

        translateTransition.setDuration(Duration.seconds(0.3));
        translateTransition.setByX(15);
        translateTransition.setFromX(0);
        //translateTransition.setToX(10);
        translateTransition.setNode(label);
        translateTransition.play();

        translateTransition2.setDuration(Duration.seconds(0.3));
        translateTransition2.setByX(-10);
        translateTransition2.setFromX(0);
        //translateTransition2.setToX(10);
        translateTransition2.setNode(image);
        translateTransition2.play();




    }

    public void transitionstop(MouseEvent mouseEvent) {
        biolabel1.setVisible(false);
        biolabel2.setVisible(false);
        biolabel3.setVisible(false);
        biolabel4.setVisible(false);
    }
    public void roundCorners(ImageView image){


        Rectangle clip = new Rectangle(
                image.getFitWidth(), image.getFitHeight()
        );
        clip.setArcWidth(50);
        clip.setArcHeight(50);
        image.setClip(clip);


        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage newimage = image.snapshot(parameters, null);


        image.setClip(null);


        //image.setEffect(new DropShadow(20, Color.BLACK));


        image.setImage(newimage);

    }
}
