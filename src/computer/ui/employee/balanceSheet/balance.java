package computer.ui.employee.balanceSheet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class balance extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("balance.fxml"));
        primaryStage.setTitle("Balance sheet");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1200,700));
        primaryStage.show();
    }
}
