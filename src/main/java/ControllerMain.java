import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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

    @FXML
    private ListView<String> list = new ListView<>();
    @FXML
    private Label lab;

    @FXML
    private ListView<String> medList = new ListView<>();

    @FXML
    private Label medLab;

    String[] interventii = {"Extractie      40 Ron", "Carie           70 Ron", "Albire          90 Ron"};
    String interventiaCurenta;

    String[] medici = {"Rusu Radu", "Rosa Flavius", "Bogosel Ovidiu"};
    String[] poze = {"1.jpg", "2.jpg", "3.jpg"};
    String medicCurent;

    @FXML
    ImageView medpic = new ImageView();

    public String getpic(String med)
    {
        int i;

        for(i = 0 ; i < medici.length; i++){
            if(med.equals(medici[i])){
                return poze[i];
            }
        }
        return "";
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        medList.getItems().addAll(medici);
        medList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                medicCurent = medList.getSelectionModel().getSelectedItem();
                medLab.setText(medicCurent);
                Image img = new Image(getpic(medicCurent));
                medpic.setImage(img);
            }
        });

        list.getItems().addAll(interventii);
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                interventiaCurenta = list.getSelectionModel().getSelectedItem();
                lab.setText(interventiaCurenta);
            }
        });
        slider.setTranslateX(-176);
        Menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.2));
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
            slide.setDuration(Duration.seconds(0.2));
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

    @FXML
    JFXButton progrButton;

    public void goProgr(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Programare.fxml"));
        window1 = (Stage)progrButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    JFXButton progrButton1;

    public void goProgr1(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Programare.fxml"));
        window1 = (Stage)progrButton1.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    JFXButton medFisButton;

    public void goToMedFis(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("FisaMedicala.fxml"));
        window1 = (Stage)medFisButton.getScene().getWindow();
        window1.setScene(new Scene(root, 600, 500));
        window1.resizableProperty().setValue(Boolean.FALSE);
    }

    @FXML
    JFXButton MedFisButtonUp;

    public void goToMedFisUP(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("FisaMedicala.fxml"));
        window1 = (Stage)MedFisButtonUp.getScene().getWindow();
        window1.setScene(new Scene(root, 600, 400));
        window1.resizableProperty().setValue(Boolean.FALSE);
    }

    @FXML
    JFXButton programari;
    @FXML
    JFXButton programari1;

    public void goProgramari(MouseEvent event) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaPacienti.fxml"));
        root = loader.load();

        ControllerListaPacienti controllerListaPacienti = loader.getController();

        controllerListaPacienti.setItems1();

        controllerListaPacienti.setRole(0);

        window1 = (Stage) programari.getScene().getWindow();
        window1.setScene(new Scene(root, 600, 400));
    }

    public void goProgramari1(MouseEvent event) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaPacienti.fxml"));
        root = loader.load();

        ControllerListaPacienti controllerListaPacienti = loader.getController();
        controllerListaPacienti.setItems1();
        window1 = (Stage) programari1.getScene().getWindow();
        window1.setScene(new Scene(root, 600, 400));
    }

    @FXML
    private AnchorPane scenePane3;

    Stage stage1;
    public void close(MouseEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Inchide aplicatia");
        alert.setHeaderText("Sunteti sigur ca doriti sa parasiti aplicatia?");

        if(alert.showAndWait().get() == ButtonType.OK) {

            stage1 = (Stage) scenePane3.getScene().getWindow();
            stage1.close();
        }
    }









}
