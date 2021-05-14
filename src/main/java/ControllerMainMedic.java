import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMainMedic implements Initializable {
    @FXML
    JFXButton BackButtonMedic;
    @FXML
    JFXButton BackButtonMedic1;

    @FXML
    private Label Menu = new Label();

    @FXML
    private Label MenuClose1 = new Label();

    @FXML
    private AnchorPane slider1=new AnchorPane();

    private Stage window1;
    private Scene scene;
    private Parent root;

    public void goBackMedic(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Stage window1 = (Stage) BackButtonMedic.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    public void goBackMedic1(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Stage window1 = (Stage) BackButtonMedic1.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    JFXButton vpButton;

    public void vp(MouseEvent event) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaPacienti.fxml"));
        root = loader.load();

        ControllerListaPacienti controllerListaPacienti = loader.getController();
        controllerListaPacienti.setItems();

        //Parent root = FXMLLoader.load(getClass().getResource("ListaPacienti.fxml"));
        window1 = (Stage) vpButton.getScene().getWindow();
        window1.setScene(new Scene(root, 600, 400));
    }

    @FXML
    JFXButton vpButton1;

    public void vp1(MouseEvent event) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaPacienti.fxml"));
        root = loader.load();

        ControllerListaPacienti controllerListaPacienti = loader.getController();
        controllerListaPacienti.setItems();

        //Parent root = FXMLLoader.load(getClass().getResource("ListaPacienti.fxml"));
        window1 = (Stage) vpButton1.getScene().getWindow();
        window1.setScene(new Scene(root, 600, 400));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        slider1.setTranslateX(-176);
        Menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.2));
            slide.setNode(slider1);

            slide.setToX(0);
            slide.play();

            slider1.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e)-> {
                Menu.setVisible(false);
                MenuClose1.setVisible(true);
            });
        });

        MenuClose1.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.2));
            slide.setNode(slider1);

            slide.setToX(-176);
            slide.play();

            slider1.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                Menu.setVisible(true);
                MenuClose1.setVisible(false);
            });
        });
    }

    @FXML
    private AnchorPane scenePane4;

    Stage stage1;
    public void close(MouseEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Inchide aplicatia");
        alert.setHeaderText("Sunteti sigur ca doriti sa parasiti aplicatia?");

        if(alert.showAndWait().get() == ButtonType.OK) {

            stage1 = (Stage) scenePane4.getScene().getWindow();
            stage1.close();
        }
    }
}
