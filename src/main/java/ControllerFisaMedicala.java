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

    public static void check(TextField name,  String number, javafx.scene.control.DatePicker data,RadioButton da1, RadioButton da2, RadioButton da3, RadioButton da4, RadioButton da5, RadioButton da6, RadioButton da7, RadioButton da8, RadioButton da9, RadioButton da10, RadioButton nu1, RadioButton nu2, RadioButton nu3, RadioButton nu4, RadioButton nu5, RadioButton nu6, RadioButton nu7, RadioButton nu8, RadioButton nu9, RadioButton nu10 ) throws NullDataException, NullUsernameException, Null1OfChoicesException, AlreadyExistAppointmentException
    {
        if(name.getText().equals(""))
        {
            throw new NullUsernameException();

        }
        else if(checkName(name)==1)
        {
            throw new AlreadyExistAppointmentException();
        }
        else if(data.getValue()==null)
        {
            throw new NullDataException();
        }
        else if(da1.isSelected()==nu1.isSelected() || da2.isSelected()==nu2.isSelected() || da3.isSelected()==nu3.isSelected() || da4.isSelected()==nu4.isSelected() || da5.isSelected()==nu5.isSelected() || da6.isSelected()==nu6.isSelected() || da7.isSelected()==nu7.isSelected() || da8.isSelected()==nu8.isSelected() || da9.isSelected()==nu9.isSelected() || da10.isSelected()==nu10.isSelected())

        {
            throw new Null1OfChoicesException();
        }
    }

    private static boolean isNumberValid(String nr){
        char ch;

        if(nr.length()!=10) {
            return false;
        }

        for(int i=0; i<nr.length();i++){
            ch=nr.charAt(i);
            if(!Character.isDigit(ch)){
                return false;
            }
        }

        return true;
    }

    private void checkNumber(String numar) throws NullNumberException, WrongNumberException {
        if(numar=="")
        {
            throw new NullNumberException();
        }
        else if(!isNumberValid(numar))
        {
            throw new WrongNumberException();
        }
    }

    private static int checkName(TextField nume) {
        for (FisaMedicala p : UserService.userRepository2.find()) {
            if(p.getNume().equals(nume.getText())){
                return 1;
            }
        }
        return 0;
    }

    public void saveFisaMedicala(MouseEvent event) throws Exception {
        Numar=numar.getText();
        try{
            check(nume,Numar,data,da1,da2,da3,da4,da5,da6,da7,da8,da9,da10,nu1,nu2,nu3,nu4,nu5,nu6,nu7,nu8,nu9,nu10);
            if(data.getValue() != null) {
                Data = data.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
                try{
                        checkNumber(Numar);
                        checkName(nume);
                        UserService.addFisa(nume.getText(), numar.getText(), Data, da1.isSelected(), da2.isSelected(), da3.isSelected(), da4.isSelected(), da5.isSelected() ,da6.isSelected(), da7.isSelected(), da8.isSelected(), da9.isSelected(), da10.isSelected());
                        showMessageDialog(null, "Fisa medicala a fost salvata!");
                        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                        window1 = (Stage)sumbitFisaMedicala.getScene().getWindow();
                        window1.setScene(new Scene(root));


                }
                catch(NullNumberException e)
                {
                    showMessageDialog(null, e.getMessage());
                }
                catch (WrongNumberException e)
                {
                    showMessageDialog(null, e.getMessage());
                }


        }catch(NullUsernameException e)
        {
            showMessageDialog(null, e.getMessage());
        }
        catch(AlreadyExistAppointmentException e)
        {
            showMessageDialog(null, e.getMessage());
        }
        catch(NullDataException e)
        {
            showMessageDialog(null, e.getMessage());
        }
        catch(Null1OfChoicesException e)
        {
            showMessageDialog(null, e.getMessage());
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
