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

    @FXML
    JFXButton DetailsButton1;

    public void goDetails1(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("DetaliiClinica.fxml"));
        window1 = (Stage)DetailsButton1.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    JFXButton BackFromDetailsButton;

    public void goBackFromDetails(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        window1 = (Stage)BackFromDetailsButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    JFXButton piButton;

    public void gopi(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("PreturiInterventii.fxml"));
        window1 = (Stage)BackFromDetailsButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    JFXButton backfrompiButton;

    public void goBackfrompi(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("DetaliiClinica.fxml"));
        window1 = (Stage)backfrompiButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    JFXButton icButton;

    public void goic(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("IstoricClinica.fxml"));
        window1 = (Stage)icButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    JFXButton backfromicButton;

    public void goBackfromic(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("DetaliiClinica.fxml"));
        window1 = (Stage)backfromicButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    JFXButton lmButton;

    public void golm(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("ListaMedici.fxml"));
        window1 = (Stage)lmButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }
}
