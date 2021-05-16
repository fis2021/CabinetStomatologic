import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Stage window1;
    private Scene scene;
    private Parent root;

    @FXML
    JFXButton BackButton;

    public void switchToMain(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        window1 = (Stage)BackButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    private ChoiceBox<String> role;
    private String []tipuri = {"Pacient", "Medic"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        role.getItems().addAll(tipuri);
        role.setValue("Pacient");

    }

    @FXML
    private Label registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;





    @FXML
    public void handleRegisterAction() {

        try {
                UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
                registrationMessage.setText("Contul s-a creat cu succes!");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
        catch(NullUsernameException e){
            registrationMessage.setText(e.getMessage());
        }
        catch(NullPasswordException e){
            registrationMessage.setText(e.getMessage());
        }
        catch(Password5CharactersException e){
            registrationMessage.setText(e.getMessage());
        }
    }


    @FXML
    private BorderPane scenePane1;

    Stage stage1;
    public void close(MouseEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Inchide aplicatia");
        alert.setHeaderText("Sunteti sigur ca doriti sa parasiti aplicatia?");

        if(alert.showAndWait().get() == ButtonType.OK) {

            stage1 = (Stage) scenePane1.getScene().getWindow();
            stage1.close();
        }
    }


}