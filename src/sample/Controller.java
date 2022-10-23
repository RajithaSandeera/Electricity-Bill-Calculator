package sample;


import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;




public class Controller implements Initializable {





    @FXML
    public ImageView menu;
    public int i=0;

    public AnchorPane homepane;
    @FXML
    public Label paragraph1;
    @FXML
    public AnchorPane mainContent;
    @FXML
    public VBox sidebar;
    @FXML
    public Label banner;
    @FXML
    public HBox menubar;
    @FXML
    public Button quit;
    @FXML
    public Label UserId;
    @FXML
    public WebView CounterWebView1;

    private List<Image> list =new ArrayList<Image>();

    private List<Image> images = new ArrayList<Image>();

    private List<String> words = new ArrayList<String>();

    FadeTransition fadeTransition = new FadeTransition();
    TranslateTransition translateTransition = new TranslateTransition();


    final int NUM_FRAMES = 10;
    final int PAUSE_BETWEEN_FRAMES = 5;
    int j = 0;

    @FXML
    Button lbutton, rbutton;
    @FXML
    ImageView imageView = new ImageView();
    @FXML
    ImageView imageView2 = new ImageView();

//Start of initialize method
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        menubar.setVisible(false);

        words.add("Sri Lanka's per capita electricity consumption was 626kWh/person in 2017,lower than India and many of the developing countries in Southeast Asia.");
        words.add("Biomass and petroleum are the dominant primary energy sources in Sri Lanka.In 2017 ,petroleum accounted for about 43% of primary energy supply,biomass provided 37%,and coal provided 11%.");
        words.add("There were 93.7MW of rooftop solar PV systems connected to the national grid in Sri Lanka by end of 2017");
        words.add("By end 2017,Sri Lanka had a total installed generation capacity of 131MW from wind resources.It is estimated that the country can gain a utilizable wind power potential of 5600MW.");
        words.add("Sri Lanka has a load curve with a steep peak in the late evening.From about 6.00 p.m the load grows to about 2500MW by 7.30 p.m and falls off after about 8.30 p.m");
        words.add("The majority of energy used by home electronics is actually while they are turned off and plugged in.");
        words.add("Americans account for only about 5% of the world’s population, but they use over 25% of the world’s energy.");
        words.add("75% of the energy we use comes from non-renewable energy such as oil, fossil fuels, coal, natural gas and nuclear energy.");
        words.add("One wind turbine can produce enough electricity to power up to 300 homes!");
        words.add("Washing clothes at 60 degrees (C) uses almost twice the energy as a 40 degree (C) wash.");

        list.add(new Image("21.jpg"));
        list.add(new Image("22.jpg"));
        list.add(new Image("23.jpg"));
        list.add(new Image("24.jpg"));
        list.add(new Image("25.jpg"));
        list.add(new Image("26.jpg"));
        list.add(new Image("27.jpg"));
        list.add(new Image("28.jpg"));
        list.add(new Image("29.jpg"));
        list.add(new Image("30.jpg"));

        imageView2.setImage(list.get(0));

        System.out.println("hi");


        Timeline timeline = new Timeline();

        images.add(new Image("1.jpg"));
        images.add(new Image("2.jpg"));
        images.add(new Image("3.jpg"));
        images.add(new Image("4.jpg"));
        images.add(new Image("5.jpg"));
        images.add(new Image("6.jpg"));
        images.add(new Image("7.jpg"));
        images.add(new Image("8.jpg"));
        images.add(new Image("9.jpg"));
        images.add(new Image("10.jpg"));


        for (int i = 0; i < NUM_FRAMES; i++) {
            timeline.getKeyFrames().add(
                    new KeyFrame(
                            Duration.seconds(i * PAUSE_BETWEEN_FRAMES),
                            new KeyValue(imageView.imageProperty(), images.get(i))
                                )
                                        );
                                            }


        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        paragraph1.setText(words.get(0));
        System.out.println("finished");



    }

//End of initialize method






    public void rb(ActionEvent actionEvent) {

        j = j + 1;
        if (j == list.size()) {
            j = 0;
        }
        imageView2.setImage(list.get(j));
        paragraph1.setText(words.get(j));

    }

    public void lb(ActionEvent actionEvent) {

        j = j - 1;
        if (j == 0 || j > list.size() + 1 || j == -1) {
            j = list.size() - 1;
        }
        imageView2.setImage(list.get(j));
        paragraph1.setText(words.get(j));
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



    public void homeclick(ActionEvent actionEvent) {

        banner.setText("Hi");
    }

    public void quit(ActionEvent actionEvent) {

        System.exit(0);
    }


    public void loadabout(ActionEvent actionEvent) throws IOException {

        AnchorPane aboutpane =FXMLLoader.load(
                getClass().getResource("about.fxml"));
       homepane.getChildren().setAll(aboutpane);
    }

    public void loadcalculator(ActionEvent actionEvent) throws IOException {
        AnchorPane calculatorpane =FXMLLoader.load(
                getClass().getResource("calculator.fxml"));
        homepane.getChildren().setAll(calculatorpane);
    }

    public void openWebview(ActionEvent actionEvent) {

        CounterWebView1.getEngine().loadContent("<iframe title='Terajoules of energy used' src='https://www.theworldcounts.com/embed/challenges/25?background_color=white&color=black&font_family=%22Helvetica+Neue%22%2C+Arial%2C+sans-serif&font_size=14' style='border: none' height='100' width='300'></iframe>");


    }



/*
    public void GetUser(String user){
        UserId.setText(user);
    }*/
}



        /*List<String> fileNames = new ArrayList<>();
    File folder = new File(Environment.getExternalStorageDirectory(), "");
    if (!folder.exists()) folder.mkdir();
        for (File file : folder.listFiles()) {
        String filename = file.getName().toLowerCase();
        if (filename.endsWith(".jpg") || filename.endsWith("jpeg")) {
        fileNames.add(filename);
        }
        }*/


