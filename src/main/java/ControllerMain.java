import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMain implements Initializable {


    @FXML
    private Label Menu = new Label();

    @FXML
    private Label MenuClose = new Label();

    @FXML
    private AnchorPane slider=new AnchorPane();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        slider.setTranslateX(-176);
        Menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e)-> {
                Menu.setVisible(false);
                MenuClose.setVisible(true);
            });
        });

        MenuClose.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-176);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                Menu.setVisible(true);
                MenuClose.setVisible(false);
            });
        });
    }

    private Stage window1;
    private Scene scene;
    private Parent root;

    @FXML
    JFXButton BackButton;

    public void goBack(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        window1 = (Stage)BackButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    JFXButton DetailsButton;

    public void goDetails(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("DetaliiClinica.fxml"));
        window1 = (Stage)DetailsButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }


}
