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
    private String Numar="";

    @FXML
    Button sumbitFisaMedicala;

    @FXML
    TextField nume,numar;
    @FXML
    DatePicker data;
    @FXML
    RadioButton da1,da2,da3,da4,da5,da6,da7,da8,da9,da10;
    @FXML
    RadioButton nu1, nu2, nu3, nu4, nu5, nu6, nu7, nu8, nu9, nu10;


    public void saveFisaMedicala(MouseEvent event) throws Exception {

        Numar=numar.getText();
        if(data.getValue() != null)
        {
            Data = data.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }

        if(nume.getText().equals(""))
        {
            showMessageDialog(null, "Completati casuta nume si prenume!");
        }

        else if(Data.equals(""))
        {
            showMessageDialog(null,"Va rugam sa alegeti o data!");
        }

        else if(numar.getLength()!=10)
        {

            showMessageDialog(null, "Numar de telefon necorespunzator!");

        }
        else if(numar.getLength()==10)
        {
            int i,sw=0;
            for(i=0; i<Numar.length() && sw==0; i++)
            {
                if(Numar.charAt(i)<'0' || Numar.charAt(i)>'9')
                {
                    sw=1;
                }
            }
            if(sw==1)
            {
                showMessageDialog(null, "Numar trebuie sa contina doar cifre!");
            }
            if(da1.isSelected()==nu1.isSelected() || da2.isSelected()==nu2.isSelected() || da3.isSelected()==nu3.isSelected() || da4.isSelected()==nu4.isSelected() || da5.isSelected()==nu5.isSelected() || da6.isSelected()==nu6.isSelected() || da7.isSelected()==nu7.isSelected() || da8.isSelected()==nu8.isSelected() || da9.isSelected()==nu9.isSelected() || da10.isSelected()==nu10.isSelected())
            {
                showMessageDialog(null, "Nu ati completat toate casutele!");
            }
            else
            {
                UserService.addFisa(nume.getText(), numar.getText(), Data, da1.isSelected(), da2.isSelected(), da3.isSelected(), da4.isSelected(), da5.isSelected() ,da6.isSelected(), da7.isSelected(), da8.isSelected(), da9.isSelected(), da10.isSelected());
                showMessageDialog(null, "Fisa medicala a fost salvata!");
                Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                window1 = (Stage)sumbitFisaMedicala.getScene().getWindow();
                window1.setScene(new Scene(root));
            }
        }
    }

    @FXML
    Button BackFromMedFis;

    public void switchToMainP(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        window1 = (Stage)BackFromMedFis.getScene().getWindow();
        window1.setScene(new Scene(root));
    }


}
