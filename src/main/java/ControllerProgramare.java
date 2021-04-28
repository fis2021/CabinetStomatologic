import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

public class ControllerProgramare {


    private Stage window1;
    private Scene scene;
    private Parent root;

    @FXML
    JFXButton backButton;

    public void goBack(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        window1 = (Stage)backButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }



    @FXML
    public javafx.scene.control.TextField nume;
    @FXML
    public javafx.scene.control.TextField prenume;
    @FXML
    public javafx.scene.control.TextField nr;
    @FXML
    public javafx.scene.control.DatePicker data;
    @FXML
    JFXButton submitButton;

    public void goSubmit(MouseEvent event) throws Exception {

        String Nume = nume.getText();
        String Prenume = prenume.getText();
        String Nr = nr.getText();
        String Data = data.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));


        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaPacienti.fxml"));
        root = loader.load();

        ControllerListaPacienti controllerListaPacienti = loader.getController();
        controllerListaPacienti.setLabel(Data);

        //Parent root = FXMLLoader.load(getClass().getResource("ListaPacienti.fxml"));
        window1 = (Stage)submitButton.getScene().getWindow();
        window1.setScene(new Scene(root, 600, 400));
    }





}
