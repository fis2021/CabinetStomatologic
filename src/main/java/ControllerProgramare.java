import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

import static javax.swing.JOptionPane.showMessageDialog;

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
    @FXML
    public javafx.scene.control.Label lb;
    @FXML
    public javafx.scene.control.CheckBox checkButton;

    public void goSubmit(MouseEvent event) throws Exception {

        String Nume = nume.getText();
        String Prenume = prenume.getText();
        String Nr = nr.getText();
        String Data = "";

        if(data.getValue() != null) {
             Data = data.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }

        if(Nume.equals("") || Prenume.equals("") || Nr.equals("") || (data.getValue() == null))
        {
            lb.setText("Toate campurile trebuie completate!");
        }
        else if(nr.getLength() != 10)
        {
            lb.setText("Introduceti un numar de telefon valid!");
        }
        else if(!checkButton.isSelected()){
            lb.setText("Trebuie sa aveti fisa medicala completata!");
        }
        else if(nr.getLength()==10) {
            int i, sw = 0;
            for (i = 0; i < Nr.length() && sw == 0; i++) {
                if (Nr.charAt(i) < '0' || Nr.charAt(i) > '9') {
                    sw = 1;
                }
            }
            if (sw == 1) {
                lb.setText("Numarul trebuie sa contina doar cifre!");
            }
            else
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaPacienti.fxml"));
                root = loader.load();

                ControllerListaPacienti controllerListaPacienti = loader.getController();

                controllerListaPacienti.setFields(Nume, Prenume, Nr, Data);

                //Parent root = FXMLLoader.load(getClass().getResource("ListaPacienti.fxml"));
                window1 = (Stage) submitButton.getScene().getWindow();
                window1.setScene(new Scene(root, 600, 400));
            }
        }

    }





}
