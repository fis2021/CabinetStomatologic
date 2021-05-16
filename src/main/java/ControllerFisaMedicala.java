import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static javax.swing.JOptionPane.showMessageDialog;

public class ControllerFisaMedicala {

    private Stage window1;
    private Scene scene;
    private Parent root;

    private String Data = "";
    private String Numar = "";

    @FXML
    JFXButton sumbitFisaMedicala;

    @FXML
    TextField nume, numar;
    @FXML
    DatePicker data;
    @FXML
    RadioButton da1, da2, da3, da4, da5, da6, da7, da8, da9, da10;
    @FXML
    RadioButton nu1, nu2, nu3, nu4, nu5, nu6, nu7, nu8, nu9, nu10;


    private static boolean isNumberValid(String nr) {
        char ch;

        if (nr.length() != 10) {
            return false;
        }

        for (int i = 0; i < nr.length(); i++) {
            ch = nr.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }


    public void saveFisaMedicala(MouseEvent event) throws Exception {
        Numar = numar.getText();


        try {
            if (data.getValue() != null) {
                Data = data.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
            UserService.checkFisaMedicala(nume, Numar, Data, da1, da2, da3, da4, da5, da6, da7, da8, da9, da10, nu1, nu2, nu3, nu4, nu5, nu6, nu7, nu8, nu9, nu10);
            UserService.addFisa(nume.getText(), numar.getText(), Data, da1.isSelected(), da2.isSelected(), da3.isSelected(), da4.isSelected(), da5.isSelected(), da6.isSelected(), da7.isSelected(), da8.isSelected(), da9.isSelected(), da10.isSelected());
            showMessageDialog(null, "Fisa medicala a fost salvata!");
            Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            window1 = (Stage) sumbitFisaMedicala.getScene().getWindow();
            window1.setScene(new Scene(root));


        } catch (NullNumberException e) {
            showMessageDialog(null, e.getMessage());
        } catch (WrongNumberException e) {
            showMessageDialog(null, e.getMessage());
        } catch (NullUsernameException e) {
            showMessageDialog(null, e.getMessage());
        } catch (AlreadyExistAppointmentException e) {
            showMessageDialog(null, e.getMessage());
        } catch (NullDataException e) {
            showMessageDialog(null, e.getMessage());
        } catch (Null1OfChoicesException e) {
            showMessageDialog(null, e.getMessage());
        }

    }

    @FXML
    JFXButton BackFromMedFis;

    public void switchToMainP(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        window1 = (Stage) BackFromMedFis.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    private ScrollPane scenePane;

    Stage stage1;

    public void close(MouseEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Inchide aplicatia");
        alert.setHeaderText("Sunteti sigur ca doriti sa parasiti aplicatia?");

        if (alert.showAndWait().get() == ButtonType.OK) {

            stage1 = (Stage) scenePane.getScene().getWindow();
            stage1.close();
        }
    }


}
