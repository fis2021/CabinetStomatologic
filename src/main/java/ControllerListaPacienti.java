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
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerListaPacienti implements Initializable{


    private Stage window1;
    private Scene scene;
    private Parent root;

    @FXML
    JFXButton backButton;

    public void goBack(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Programare.fxml"));
        window1 = (Stage)backButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    Label label;

    private String nume;
    private String prenume;
    private String nr;
    private String data;

    public void setFields(String nume, String prenume, String nr, String data) {
        label.setText(nume);
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

    ObservableList<Persoana> getPersoana() {

        ObservableList<Persoana> persoane = FXCollections.observableArrayList();

        persoane.add(new Persoana(label.getText(), prenume, nr, data));

        return  persoane;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Nume.setCellValueFactory(new PropertyValueFactory<Persoana, String>("nume"));
        Prenume.setCellValueFactory(new PropertyValueFactory<Persoana, String>("prenume"));
        Numar.setCellValueFactory(new PropertyValueFactory<Persoana, String>("nr"));
        Data.setCellValueFactory(new PropertyValueFactory<Persoana, String>("data"));

        table.setItems(getPersoana());
    }
}


