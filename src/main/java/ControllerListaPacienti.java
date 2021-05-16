import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javax.swing.JOptionPane.showMessageDialog;


public class ControllerListaPacienti implements Initializable {

    private static int ok = 0;

    private Stage window1;
    private Scene scene;
    private Parent root;

    @FXML
    JFXButton backButton;

    public void goBack(MouseEvent event) throws Exception {

        if (ok == 0) {
            Parent root = FXMLLoader.load(getClass().getResource("Programare.fxml"));
            window1 = (Stage) backButton.getScene().getWindow();
            window1.setScene(new Scene(root));
        } else if (ok == 1) {
            Parent root = FXMLLoader.load(getClass().getResource("MainPageMedic.fxml"));
            window1 = (Stage) backButton.getScene().getWindow();
            window1.setScene(new Scene(root));
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            window1 = (Stage) backButton.getScene().getWindow();
            window1.setScene(new Scene(root));
        }

    }

    @FXML
    Label label;

    private String nume;
    private String prenume;
    private String nr;
    private String data;

    public void setFields(String nume, String prenume, String nr, String data) throws Exception {

        this.nume = nume;
        this.prenume = prenume;
        this.nr = nr;
        this.data = data;

        table.setItems(getPersoana());
    }

    public void setItems() throws Exception {
        ok = 1;  //pentru medic
        table.setItems(getPersoana());
    }

    public void setItems1() throws Exception {
        ok = -1;  //pentru pacient
        table.setItems(getPersoana());
    }

    public void setRole(int k) throws Exception {
        if (k == 0) {
            name.setVisible(false);
            showFisButton.setVisible(false);
            deleteButton.setVisible(false);
        }
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

        if (ok == 0) {   //daca este pacient
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

        return persoane;
    }

    @FXML
    public javafx.scene.control.TextField name;
    @FXML
    public javafx.scene.control.Button showFisButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ok = 0;
        Nume.setCellValueFactory(new PropertyValueFactory<Persoana, String>("nume"));
        Prenume.setCellValueFactory(new PropertyValueFactory<Persoana, String>("prenume"));
        Numar.setCellValueFactory(new PropertyValueFactory<Persoana, String>("nr"));
        Data.setCellValueFactory(new PropertyValueFactory<Persoana, String>("data"));

    }


    public void show(MouseEvent event) throws Exception {



        try {
            UserService.checkNameInDataBaseFisaMedicala(name.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FisaPrecompletata.fxml"));
            root = loader.load();
            ControllerFisaPrecompletata controllerFisaPrecompletata = loader.getController();
            for (FisaMedicala p : UserService.userRepository2.find()) {
                if (p.getNume().equals(name.getText())) {
                    controllerFisaPrecompletata.setFis(p.getNume(), p.getData(), p.getNumarTelefon(), p.isQ1(), p.isQ2(), p.isQ3(), p.isQ4(), p.isQ5(), p.isQ6(), p.isQ7(), p.isQ8(), p.isQ9(), p.isQ10());
                    break;
                }
            }
            window1 = (Stage) showFisButton.getScene().getWindow();
            window1.setScene(new Scene(root, 600, 400));

        } catch (NoCompleteFisaException e) {
            showMessageDialog(null, e.getMessage());
        } catch (NullUsernameException e) {
            showMessageDialog(null, e.getMessage());
        }


    }

    @FXML
    public javafx.scene.control.Button deleteButton;

    public void delete(MouseEvent event) throws Exception {


        for (Persoana p : UserService.userRepository1.find()) {
            String s = p.getNume() + " " + p.getPrenume();
            if (s.equals(name.getText())) {
                UserService.userRepository1.remove(p);
                break;
            }

        }

        showMessageDialog(null, "Programarea a fost stearsa!");

        Parent root = FXMLLoader.load(getClass().getResource("MainPageMedic.fxml"));
        window1 = (Stage) deleteButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    private ScrollPane scenePane;

    Stage stage;

    public void close(MouseEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Inchide aplicatia");
        alert.setHeaderText("Sunteti sigur ca doriti sa parasiti aplicatia?");

        if (alert.showAndWait().get() == ButtonType.OK) {

            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
        }
    }


}


