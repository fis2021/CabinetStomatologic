import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
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

    public static void check(String lastName, String firstName, String number, javafx.scene.control.DatePicker data, javafx.scene.control.CheckBox buton) throws NullDataException, NullCheckButtonException, NullFirstNameException, NullLastNameException
    {
        if(lastName.equals(""))
        {
            throw new NullLastNameException();

        }
        else if(firstName.equals(""))
        {
            throw new NullFirstNameException();
        }
        else if(!buton.isSelected())
        {
            throw new NullCheckButtonException();
        }
        else if(data.getValue()==null)
        {
            throw new NullDataException();
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

    private void checkNumber(String nr) throws NullNumberException, WrongNumberException {
        if(nr=="")
        {
            throw new NullNumberException();
        }
        else if(!isNumberValid(nr))
        {
            throw new WrongNumberException();
        }
    }



    public void goSubmit(MouseEvent event) throws Exception{

        String Nume = nume.getText();
        String Prenume = prenume.getText();
        String Nr = nr.getText();
        String Data = "";

        try{
            check(Nume,Prenume,Nr,data,checkButton);
            if(data.getValue() != null) {
                Data = data.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
                try {
                        checkNumber(Nr);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaPacienti.fxml"));
                        root = loader.load();

                        ControllerListaPacienti controllerListaPacienti = loader.getController();

                        controllerListaPacienti.setFields(Nume, Prenume, Nr, Data);
                        controllerListaPacienti.setRole(0);

                        window1 = (Stage) submitButton.getScene().getWindow();
                        window1.setScene(new Scene(root, 600, 400));

                }catch(NullNumberException e)
                {
                    lb.setText(e.getMessage());
                }
                catch (WrongNumberException e)
                {
                    lb.setText(e.getMessage());
                }
        }catch(NullLastNameException e)
        {
            lb.setText(e.getMessage());
        }catch(NullFirstNameException e)
        {
            lb.setText(e.getMessage());
        }
        catch (NullDataException e)
        {
            lb.setText(e.getMessage());
        }
        catch(NullCheckButtonException e)
        {
            lb.setText(e.getMessage());
        }



    }

    @FXML
    private BorderPane scenePane;

    Stage stage;
    public void close(MouseEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Inchide aplicatia");
        alert.setHeaderText("Sunteti sigur ca doriti sa parasiti aplicatia?");

        if(alert.showAndWait().get() == ButtonType.OK) {

            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
        }
    }





}
