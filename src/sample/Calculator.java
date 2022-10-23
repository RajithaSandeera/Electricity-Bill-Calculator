package sample;

import com.jfoenix.controls.JFXComboBox;
import com.sun.javafx.collections.ElementObservableListDecorator;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Calculator implements Initializable {
    public AnchorPane calculatorpane;
    public HBox menubar;
    public int i=0;
    @FXML
    public JFXComboBox category;
    @FXML
    public JFXComboBox no_of_units;
    @FXML
    public Button calculate2;
    @FXML
    public Label FinalAmount2;

    @FXML
    public TableView<Device> tableView;
    @FXML
    public TableColumn<Device,String> colDevice;
    @FXML
    public TableColumn<Device,Double> colTime;
    @FXML
    public TableColumn<Device,Integer> colWatt;
    @FXML
    public TableColumn<Device,Integer> colQuantity;
    @FXML
    public JFXComboBox device;
    @FXML
    public JFXComboBox hours;
    @FXML
    public JFXComboBox watt;
    @FXML
    public JFXComboBox quantity;
    @FXML
    public Label TableOutput;
    @FXML
    public AnchorPane AddNewDevicePane;
    @FXML
    public ImageView menu;
    @FXML
    public Label WarningLabel;
    @FXML
    public Pane ChartPane;
    @FXML
    private BarChart<?, ?> UnitChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;




    FadeTransition fadeTransition = new FadeTransition();
    TranslateTransition translateTransition = new TranslateTransition();

    String selectedCategory;
    int NumberOfUnits;
    double billAmount2;
    private ElementObservableListDecorator<Object> Doubles;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ChartPane.setVisible(false);
        menubar.setVisible(false);
        AddNewDevicePane.setVisible(false);

        String selectCategory[] ={"Domestic","Industrial 1","General Purpose 1","Gov.Universities","Gov.Hosp & Schools","Hotel 1","Religious & Charity"};

        ObservableList<String> categories = FXCollections.observableArrayList(selectCategory);
        category.setItems(categories);


        String selectDevice[] ={"Television","Refrigerator","Washing Machine","Water Pump","Fan","Iron","AC","Heater","Light Bulb","Other"};

        ObservableList<String> devices = FXCollections.observableArrayList(selectDevice);
        device.setItems(devices);



        List<Integer>  NoOfUnits = new ArrayList<Integer>();

        for(int i=0;i<=500;i++){

            NoOfUnits.add(i);
        }
        ObservableList<Integer> NumOfUnits = FXCollections.observableList(NoOfUnits);
        no_of_units.setItems(NumOfUnits);


        Double selectHours[] ={0.1,0.2,0.25,0.3,0.4,0.5,0.6,0.7,0.75,0.8,0.9,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,11.0,12.0,13.0,14.0,15.0
                                ,16.0,17.0,18.0,19.0,20.0,21.0,22.0,23.0,24.0};

        ObservableList<Double> NumOfHours = FXCollections.observableArrayList(selectHours);
        hours.setItems(NumOfHours);


        List<Integer>  NoOfWatt = new ArrayList<Integer>();

        for(int i=0;i<=2000;i++){

            NoOfWatt.add(i);
        }
        ObservableList<Integer> NomOfWatt = FXCollections.observableList(NoOfWatt);
        watt.setItems(NomOfWatt);


        List<Integer>  NoOfQuantity = new ArrayList<Integer>();

        for(int i=0;i<=100;i++){

            NoOfQuantity.add(i);
        }
        ObservableList<Integer> NomOfQuantity = FXCollections.observableList(NoOfQuantity);
        quantity.setItems(NomOfQuantity);





        colDevice.setCellValueFactory(new PropertyValueFactory<>("ColDevice"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("ColTime"));
        colWatt.setCellValueFactory(new PropertyValueFactory<>("ColWatt"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("ColQuantity"));
        tableView.setItems(observableList);


    }


    ObservableList<Device> observableList = FXCollections.observableArrayList(
            new Device("Bulb",3600,25,5)
    );





    public void homeclick(ActionEvent actionEvent) {
    }



    public void loadabout(ActionEvent actionEvent) throws IOException {
        AnchorPane aboutpane = FXMLLoader.load(
                getClass().getResource("about.fxml"));
        calculatorpane.getChildren().setAll(aboutpane);
    }

    public void quit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void loadhome(ActionEvent actionEvent) throws IOException {
        AnchorPane homepane = FXMLLoader.load(
                getClass().getResource("sample.fxml"));
        calculatorpane.getChildren().setAll(homepane);
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

    public void CategoryCalculate(ActionEvent actionEvent) {
if (category.getValue() != null && no_of_units.getValue() != null) {

    selectedCategory = (String) category.getValue();
    NumberOfUnits = (int) no_of_units.getValue();


    switch (selectedCategory) {

        case "Domestic":
            if (NumberOfUnits >= 0 && NumberOfUnits <= 30) {

                try {
                    billAmount2 = NumberOfUnits * 2.50 + 30/*fixed value*/;
                    FinalAmount2.setText("Rs "+Double.toString(billAmount2));
                } catch (NumberFormatException e) {
                    FinalAmount2.setText("Choose category and number of units");
                }

            } else if (NumberOfUnits >= 31 && NumberOfUnits <= 60) {

                try {
                    billAmount2 = (NumberOfUnits - 30) * 4.85 + 30 * 2.50 + 60/*fixed value*/;
                    FinalAmount2.setText("Rs "+Double.toString(billAmount2));
                } catch (NumberFormatException e) {
                    FinalAmount2.setText("Choose category and number of units");
                }

            } else if (NumberOfUnits >= 61 && NumberOfUnits <= 90) {
                try {
                    billAmount2 = (NumberOfUnits - 60) * 10 + 60 * 7.85 + 90/*fixed value*/;
                    FinalAmount2.setText("Rs "+Double.toString(billAmount2));
                } catch (NumberFormatException e) {
                    FinalAmount2.setText("Choose category and number of units");
                }

            } else if (NumberOfUnits >= 91 && NumberOfUnits <= 120) {
                try {
                    billAmount2 = (NumberOfUnits - 90) * 27.75 + 60 * 7.85 + 30 * 10 + 480/*fixed value*/;
                    FinalAmount2.setText("Rs "+Double.toString(billAmount2));
                } catch (NumberFormatException e) {
                    FinalAmount2.setText("Choose category and number of units");
                }

            } else if (NumberOfUnits >= 121 && NumberOfUnits <= 180) {

                try {
                    billAmount2 = (NumberOfUnits - 120) * 32 + 60 * 7.85 + 30 * 10 + 30 * 27.75 + 480/*fixed value*/;
                    FinalAmount2.setText("Rs "+Double.toString(billAmount2));
                } catch (NumberFormatException e) {
                    FinalAmount2.setText("Choose category and number of units");
                }

            } else if (NumberOfUnits >= 180 && NumberOfUnits <= 500) {

                try {
                    billAmount2 = (NumberOfUnits - 180) * 45 + 60 * 7.85 + 30 * 10 + 30 * 27.75 + 60 * 32 + 540/*fixed value*/;
                    FinalAmount2.setText("Rs "+Double.toString(billAmount2));
                } catch (NumberFormatException e) {
                    FinalAmount2.setText("Choose category and number of units");
                }

            }


            break;
        case "Industrial 1":

            try {
                billAmount2 = NumberOfUnits * 10.80 + 600;
                FinalAmount2.setText("Rs "+Double.toString(billAmount2));
            } catch (NumberFormatException e) {
                FinalAmount2.setText("Choose category and number of units");
            }

            break;
        case "General Purpose 1":
            try {
                billAmount2 = NumberOfUnits * 18.30 + 240;
                FinalAmount2.setText("Rs "+Double.toString(billAmount2));
            } catch (NumberFormatException e) {
                FinalAmount2.setText("Choose category and number of units");
            }

            break;
        case "Gov.Universities":
            try {
                billAmount2 = NumberOfUnits * 14.65 + 600;
                FinalAmount2.setText("Rs "+Double.toString(billAmount2));
            } catch (NumberFormatException e) {
                FinalAmount2.setText("Choose category and number of units");
            }

            break;
        case "Gov.Hosp & Schools":
            try {
                billAmount2 = NumberOfUnits * 14.65 + 600;
                FinalAmount2.setText("Rs "+Double.toString(billAmount2));
            } catch (NumberFormatException e) {
                FinalAmount2.setText("Choose category and number of units");
            }
            break;
        case "Hotel 1":
            try {
                billAmount2 = NumberOfUnits * 21.50 + 600;
                FinalAmount2.setText("Rs "+Double.toString(billAmount2));
            } catch (NumberFormatException e) {
                FinalAmount2.setText("Choose category and number of units");
            }
            break;
        case "Religious & Charity":

            if (NumberOfUnits >= 0 && NumberOfUnits <= 30) {
                try {
                    billAmount2 = NumberOfUnits * 1.90 + 30/*fixed value*/;
                    FinalAmount2.setText("Rs "+Double.toString(billAmount2));
                } catch (NumberFormatException e) {
                    FinalAmount2.setText("Choose category and number of units");
                }

            } else if (NumberOfUnits >= 31 && NumberOfUnits <= 90) {
                try {
                    billAmount2 = (NumberOfUnits - 30) * 2.80 + 30 * 1.90 + 60/*fixed value*/;
                    FinalAmount2.setText("Rs "+Double.toString(billAmount2));
                } catch (NumberFormatException e) {
                    FinalAmount2.setText("Choose category and number of units");
                }

            } else if (NumberOfUnits >= 91 && NumberOfUnits <= 120) {
                try {
                    billAmount2 = (NumberOfUnits - 90) * 6.75 + 60 * 2.80 + 30 * 1.90 + 180/*fixed value*/;
                    FinalAmount2.setText("Rs "+Double.toString(billAmount2));
                } catch (NumberFormatException e) {
                    FinalAmount2.setText("Choose category and number of units");
                }

            } else if (NumberOfUnits >= 121 && NumberOfUnits <= 180) {
                try {
                    billAmount2 = (NumberOfUnits - 120) * 7.50 + 30 * 6.75 + 60 * 2.80 + 30 * 1.90 + 180/*fixed value*/;
                    FinalAmount2.setText("Rs "+Double.toString(billAmount2));
                } catch (NumberFormatException e) {
                    FinalAmount2.setText("Choose category and number of units");
                }

            } else if (NumberOfUnits >= 180 && NumberOfUnits <= 500) {
                try {
                    billAmount2 = (NumberOfUnits - 180) * 9.40 + 60 * 7.50 + 30 * 6.75 + 60 * 2.80 + 30 * 1.90 + 240/*fixed value*/;
                    FinalAmount2.setText("Rs "+Double.toString(billAmount2));
                } catch (NumberFormatException e) {
                    FinalAmount2.setText("Choose category and number of units");
                }

            }
            break;

            }
        }else {
    FinalAmount2.setText("Select Data");
}
    }

    public void AddNewDevice(ActionEvent actionEvent) {

        if (device.getValue() != null && hours.getValue() != null && watt.getValue() != null && quantity.getValue() != null) {
            Device NewDevice = new Device((String) device.getValue(), (Double) hours.getValue(), (Integer) watt.getValue(), (Integer) quantity.getValue());
            tableView.getItems().add(NewDevice);
        }else {
            WarningLabel.setText("Please Select All Fields");

        }
    }

    public void DeleteDevice(MouseEvent mouseEvent) {

        ObservableList<Device> allDevices,selectedDevice;
        allDevices = tableView.getItems();
        selectedDevice = tableView.getSelectionModel().getSelectedItems();
        selectedDevice.forEach(allDevices::remove);
    }




    public void TableCalculate(MouseEvent mouseEvent) {



        double numberofunits = 0;
        double unitspermonth = 0;


        Device device = new Device();

        List <String> arrListDevice = new ArrayList<>();
        List <Double> arrListHours = new ArrayList<>();
        List <Double> arrListWatt = new ArrayList<>();
        List <Double> arrListQuantity = new ArrayList<>();


        for (int i=0; i<tableView.getItems().size(); i++){

            device =tableView.getItems().get(i);
            arrListDevice.add(device.getColDevice());
            arrListHours.add(device.getColTime());
            arrListWatt.add((double)device.getColWatt());
            arrListQuantity.add((double)device.getColQuantity());

        }

        String[] arrDevice = arrListDevice.toArray(new String[0]);
        double[] arrHours = arrListHours.stream().mapToDouble(Double::doubleValue).toArray();
        double[] arrWatt = arrListWatt.stream().mapToDouble(Double::doubleValue).toArray();
        double[] arrQuantity = arrListQuantity.stream().mapToDouble(Double::doubleValue).toArray();
        double[] unitsPerDay = new  double[tableView.getItems().size()];




        for (int i=0; i<tableView.getItems().size(); i++){

            numberofunits = numberofunits + arrHours[i] * arrWatt[i] * arrQuantity[i]/1000;
            unitsPerDay[i] = arrHours[i] * arrWatt[i] * arrQuantity[i]/1000;

        }

        System.out.println(numberofunits);

        unitspermonth = numberofunits*30;

        ChartDisplay(arrDevice,unitsPerDay);








        if (unitspermonth >= 0 && unitspermonth <= 30) {

            try {
                billAmount2 = unitspermonth * 2.50 + 30/*fixed value*/;
                TableOutput.setText("Rs "+Double.toString(billAmount2));
            } catch (NumberFormatException e) {
                TableOutput.setText("Error");
            }

        } else if (unitspermonth >= 31 && unitspermonth <= 60) {

            try {
                billAmount2 = (unitspermonth - 30) * 4.85 + 30 * 2.50 + 60/*fixed value*/;
                TableOutput.setText("Rs "+Double.toString(billAmount2));
            } catch (NumberFormatException e) {
                TableOutput.setText("Error");
            }

        } else if (unitspermonth >= 61 && unitspermonth <= 90) {
            try {
                billAmount2 = (unitspermonth - 60) * 10 + 60 * 7.85 + 90/*fixed value*/;
                TableOutput.setText("Rs "+Double.toString(billAmount2));
            } catch (NumberFormatException e) {
                TableOutput.setText("Error");
            }

        } else if (unitspermonth >= 91 && unitspermonth <= 120) {
            try {
                billAmount2 = (unitspermonth - 90) * 27.75 + 60 * 7.85 + 30 * 10 + 480/*fixed value*/;
                TableOutput.setText("Rs "+Double.toString(billAmount2));
            } catch (NumberFormatException e) {
                TableOutput.setText("Error");
            }

        } else if (unitspermonth >= 121 && unitspermonth <= 180) {

            try {
                billAmount2 = (unitspermonth - 120) * 32 + 60 * 7.85 + 30 * 10 + 30 * 27.75 + 480/*fixed value*/;
                TableOutput.setText("Rs "+Double.toString(billAmount2));
            } catch (NumberFormatException e) {
                TableOutput.setText("Error");
            }

        } else if (unitspermonth >= 180 && unitspermonth <= 500) {

            try {
                billAmount2 = (unitspermonth - 180) * 45 + 60 * 7.85 + 30 * 10 + 30 * 27.75 + 60 * 32 + 540/*fixed value*/;
                TableOutput.setText("Rs "+Double.toString(billAmount2));
            } catch (NumberFormatException e) {
                TableOutput.setText("Error");
            }

        }
    }


    public void ChartDisplay(String [] device,double [] units){


        XYChart.Series set1 = new XYChart.Series<>();

        for (int i =0;i<tableView.getItems().size(); i++){

            set1.getData().add(new XYChart.Data(device[i],units[i]));

        }

        UnitChart.getData().addAll(set1);
    }


    public void PopNewDevicePane(MouseEvent mouseEvent) {
        AddNewDevicePane.setVisible(true);

    }

    public void ShowChart(MouseEvent mouseEvent) {
        ChartPane.setVisible(true);
    }

    public void HideNewDevicePane(ActionEvent actionEvent) {
        AddNewDevicePane.setVisible(false);
    }

    public void HideChartPane(ActionEvent actionEvent) {
        UnitChart.getData().clear();
        ChartPane.setVisible(false);
    }
}
