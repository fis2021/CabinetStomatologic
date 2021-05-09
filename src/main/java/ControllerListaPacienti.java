import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javax.swing.JOptionPane.showMessageDialog;


public class ControllerListaPacienti implements Initializable{

    private static int ok = 0;

    private Stage window1;
    private Scene scene;
    private Parent root;

    @FXML
    JFXButton backButton;

    public void goBack(MouseEvent event) throws Exception {

        if(ok == 0) {
            Parent root = FXMLLoader.load(getClass().getResource("Programare.fxml"));
            window1 = (Stage)backButton.getScene().getWindow();
            window1.setScene(new Scene(root));
        }
        else {
            Parent root = FXMLLoader.load(getClass().getResource("MainPageMedic.fxml"));
            window1 = (Stage)backButton.getScene().getWindow();
            window1.setScene(new Scene(root));
        }

    }

    @FXML
    Label label;

    private String nume;
    private String prenume;
    private String nr;
    private String data;

    public void setFields (String nume, String prenume, String nr, String data) throws Exception{

        this.nume = nume;
        this.prenume = prenume;
        this.nr = nr;
        this.data = data;

        table.setItems(getPersoana());
    }

    public void setItems () throws Exception{
        ok = 1;
        table.setItems(getPersoana());
    }


    @FXML
    TableView<Persoana> table;

    @FXML
    TableColumn<Persoana, String> Nume;

    @FXML
    TableColumn<Persoana, String> Prenume;

    @FXML
    TableColumn<Persoana, String> Numar;

    @FXML
    TableColumn<Persoana, String> Data;



    ObservableList<Persoana> getPersoana() throws IOException {

        ObservableList<Persoana> persoane = FXCollections.observableArrayList();

        ArrayList<Persoana> list = new ArrayList<>();

        int sw = 1;
        for (Persoana p : UserService.userRepository1.find()) {
                if (p.getNume().equals(this.nume)) {
                    sw = 0;
                    break;
                }

        }

        if(ok == 0) {
            if (sw == 1) {
                UserService.addUser1(this.nume, this.prenume, this.nr, this.data);
            } else {
                showMessageDialog(null, "Exista deja o programare pe acest nume!");
            }
        }


        for (Persoana p : UserService.userRepository1.find()) {
                list.add(p);
        }

        persoane.addAll(list);

        return  persoane;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ok = 0;

        Nume.setCellValueFactory(new PropertyValueFactory<Persoana, String>("nume"));
        Prenume.setCellValueFactory(new PropertyValueFactory<Persoana, String>("prenume"));
        Numar.setCellValueFactory(new PropertyValueFactory<Persoana, String>("nr"));
        Data.setCellValueFactory(new PropertyValueFactory<Persoana, String>("data"));

    }
}


