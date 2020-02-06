package computer.ui.login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import computer.classes.Employee;
import computer.databate.SuperController;
import computer.databate.connection;
import computer.ui.employee.home.home;
import computer.ui.employee.home.homeController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements Initializable{

    @FXML
    private AnchorPane layer0;

    @FXML
    private JFXProgressBar progress;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private AnchorPane splashScreen;

    @FXML
    private AnchorPane authentication;

    @FXML
    private AnchorPane mainRoot;

    @FXML
    private Label errorID;

    private SuperController supCon = new SuperController();
    private static double xOffset = 0;
    private static double yOffset = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*supCon.testConnection();
        TranslateTransition transition = new TranslateTransition(Duration.seconds(2), splashScreen);
        transition.setToX(-400);
        transition.play();
        if (!authentication.isVisible()){
            authentication.setVisible(true);
        }
*/
        authentication.setOnMousePressed(event -> {
            xOffset = txtEmail.getScene().getWindow().getX() - event.getScreenX();
            yOffset = txtEmail.getScene().getWindow().getY() - event.getScreenY();
        });

        authentication.setOnMouseDragged(event -> {
            txtEmail.getScene().getWindow().setX(event.getScreenX() + xOffset);
            txtEmail.getScene().getWindow().setY(event.getScreenY() + yOffset);
        });

    }

    @FXML
    private void emailValidator(){
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        if (!txtEmail.getText().equals("")){
            Matcher matcher = pattern.matcher(txtEmail.getText());

            if (!matcher.matches()){
                errorID.setText("Email address incorrect !");
                TranslateTransition transition = new TranslateTransition(Duration.seconds(1), errorID);
                errorID.setLayoutX(433);
                transition.setToY(-(mainRoot.getPrefHeight()-387));
                transition.play();
                txtEmail.setFocusColor(Color.color(0.9,0.3,0));
            }else {
                errorID.setText("Correct !");
                txtEmail.setFocusColor(Color.color(0.1,0.7,0.1));
                TranslateTransition transition = new TranslateTransition(Duration.seconds(1), errorID);
                errorID.setLayoutX(433);
                transition.setToY(mainRoot.getPrefHeight());
                transition.play();
            }
        }
    }

    @FXML
    public void signIn(){

        if (!txtEmail.getText().equals("") && !txtPassword.getText().equals("")) {
            Object[] emp = supCon.testSignIN(txtEmail.getText(), txtPassword.getText());
            System.out.println(Arrays.toString(emp));
            if (emp[0] != null){
                Employee mp = (Employee) emp[0];
                System.out.println("ID DE CET EMPLOYEE EST : "+mp.getId());
                System.out.println("connected to the App");

                //primaryStage.initStyle(StageStyle.UNDECORATED);

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/computer/ui/employee/home/home.fxml"));
                    Parent root = loader.load();

                    homeController homeContro = loader.getController();
                    homeContro.transfertEmpInfos(emp);

                    Stage stage = new Stage();
                    stage.setTitle("Home");
                    stage.setResizable(false);
                    stage.setScene(new Scene(root, 1200,700));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //close the current stage
                closeStage();
            }
            else{
                info("Login or password incorrect");
            }
        }else {
            if (txtEmail.getText().equals("")){
                txtEmail.setUnFocusColor(Color.color(1,0,0));
            }
            if (txtPassword.getText().equals("")){
                txtPassword.setUnFocusColor(Color.color(1,0,0));
            }
        }
    }

    private void info(String message){
        errorID.setText(message);
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), errorID);
        errorID.setLayoutX(433);
        transition.setToY(-(mainRoot.getPrefHeight()-387));
        transition.play();
    }

    @FXML
    private void normalE(){
        txtEmail.setUnFocusColor(Color.color(0.3,0.3,0.3));
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), errorID);
        errorID.setLayoutX(433);
        transition.setToY(mainRoot.getPrefHeight());
        System.out.println("reset");
        transition.play();
    }

    @FXML
    private void normalP(){
        txtPassword.setUnFocusColor(Color.color(0.3,0.3,0.3));
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), errorID);
        errorID.setLayoutX(433);
        transition.setToY(mainRoot.getPrefHeight());
        transition.play();
    }

    private void closeStage(){
        ((Stage)txtEmail.getScene().getWindow()).close();
    }

    @FXML
    public void cancle(){
        System.exit(0);
    }
}
