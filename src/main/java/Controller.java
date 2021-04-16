import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Stage window1;
    private Scene scene;
    private Parent root;

    @FXML
    Button BackButton;

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
            if(passwordField.getText().equals("")) {
                registrationMessage.setText("Pasword cannot be empty!");
            }
             if(usernameField.getText().equals("")){
                registrationMessage.setText("Username cannot be empty!");
            }

             if(!passwordField.getText().equals("") && passwordField.getText().length()<5){
                 registrationMessage.setText("Choose a password of at least 5 characters!");
             }
             else  if(!passwordField.getText().equals("") && !usernameField.getText().equals("")) {
                UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
                registrationMessage.setText("Account created successfully!");
            }
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }

    @FXML
    Button LOGINButton;

    public void switchToMainPage(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        window1 = (Stage)LOGINButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }


}