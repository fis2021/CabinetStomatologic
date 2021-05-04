import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

import static javax.swing.JOptionPane.showMessageDialog;

public class ControllerFisaMedicala {

    private Stage window1;
    private Scene scene;
    private Parent root;

    private String Data="";

    @FXML
    Button sumbitFisaMedicala;

    @FXML
    TextField nume,numar;
    @FXML
    DatePicker data;
    @FXML
    RadioButton da1,da2,da3,da4,da5,da6,da7,da8,da9,da10;


    public void saveFisaMedicala(MouseEvent event) throws Exception {

        Data = data.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        UserService.addFisa(nume.getText(), numar.getText(), Data, da1.isSelected(), da2.isSelected(), da3.isSelected(), da4.isSelected(), da5.isSelected() ,da6.isSelected(), da7.isSelected(), da8.isSelected(), da9.isSelected(), da10.isSelected());
        showMessageDialog(null, "Fisa medicala a fost salvata!");
    }


}
