package sample;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginContoller implements Initializable {

    public LoginModel loginModel = new LoginModel();
    @FXML
    public JFXTextField txtusername;
    @FXML
    public JFXPasswordField txtpassword;
    @FXML
    public AnchorPane loginpane;

    @FXML
    private Label isConnected;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (loginModel.isDbConnected()) {
            isConnected.setText("connected");
        } else {
            isConnected.setText("Not Connected");
        }
    }

    public void Login(ActionEvent actionEvent)  {
        try {
            if (loginModel.isLogin(txtusername.getText(), txtpassword.getText())){
                isConnected.setText("user name and password is correct");


                loadhome();
                //Stage primaryStage = new Stage();
                //FXMLLoader loader = new FXMLLoader();
                //Pane root = loader.load(getClass().getResource("sample.fxml").openStream());
                //Controller controller =(Controller)loader.getController();
                //Controller controller = new Controller();
                //controller.GetUser(txtusername.getText());
                //Scene scene = new Scene(root);
                //primaryStage.setTitle("Electricity Bill Calculator");
                //primaryStage.setScene(scene);
                //primaryStage.setResizable(false);
                //primaryStage.show();

            }else {
                isConnected.setText("user name and password is incorrect");
            }
        } catch (SQLException | IOException e) {
            isConnected.setText("user name and password is incorrect");
            e.printStackTrace();
        }
        /*catch (IOException e) {
            System.out.println("Load Failed");
        }*/

    }
    public void loadhome() throws IOException {
        AnchorPane homepane = FXMLLoader.load(
                getClass().getResource("sample.fxml"));
        loginpane.getChildren().setAll(homepane);
    }
}
