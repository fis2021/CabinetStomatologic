import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene scene = new Scene(root, 700, 500);

        primaryStage.setTitle("FXML Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Stage window1;
    private Scene scene;
    private Parent root;

    @FXML
    Button SignUpButton;

    public void switchToSignUp(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        window1 = (Stage)SignUpButton.getScene().getWindow();
        window1.setScene(new Scene(root, 750,500));
    }


    @FXML
    Button BackButton;

    public void switchToMain(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        window1 = (Stage)BackButton.getScene().getWindow();
        window1.setScene(new Scene(root, 750,500));
    }
}
