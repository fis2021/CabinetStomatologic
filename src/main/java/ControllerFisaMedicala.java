import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    JFXButton sumbitFisaMedicala;

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

            showMessageDialog(null, "Numarul de telefon necorespunzator!");

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
                sw = 1;
                for (FisaMedicala p : UserService.userRepository2.find()) {
                    if(p.getNume().equals(nume.getText())){
                        sw = 0;
                        break;
                    }
                }

                if(sw == 1) {
                    UserService.addFisa(nume.getText(), numar.getText(), Data, da1.isSelected(), da2.isSelected(), da3.isSelected(), da4.isSelected(), da5.isSelected() ,da6.isSelected(), da7.isSelected(), da8.isSelected(), da9.isSelected(), da10.isSelected());
                    showMessageDialog(null, "Fisa medicala a fost salvata!");
                    Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                    window1 = (Stage)sumbitFisaMedicala.getScene().getWindow();
                    window1.setScene(new Scene(root));
                }
                else{
                    showMessageDialog(null, "Exista deja o programare pe acest nume!");
                }
            }
        }
    }

    @FXML
    JFXButton BackFromMedFis;

    public void switchToMainP(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        window1 = (Stage)BackFromMedFis.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    private ScrollPane scenePane;

    Stage stage1;
    public void close(MouseEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Inchide aplicatia");
        alert.setHeaderText("Sunteti sigur ca doriti sa parasiti aplicatia?");

        if(alert.showAndWait().get() == ButtonType.OK) {

            stage1 = (Stage) scenePane.getScene().getWindow();
            stage1.close();
        }
    }


}
