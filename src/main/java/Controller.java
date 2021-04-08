import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Controller {

    private Stage window1;
    private Scene scene;
    private Parent root;

    @FXML
    Button BackButton;

    public void switchToMain(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        window1 = (Stage)BackButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }



}