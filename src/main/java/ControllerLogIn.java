import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

public class ControllerLogIn {

    private Stage window1;
    private Scene scene;
    private Parent root;
    private String username,password,encryptedPassword;

    @FXML
     TextField LogInUsername;
    @FXML
     PasswordField LogInPassword;


    @FXML
    JFXButton LOGINButton;
    @FXML
    Label FailedLogInMessage;


    public void switchToMainPage(MouseEvent event) throws Exception {

        username = LogInUsername.getText();
        password = LogInPassword.getText();


        try{
            int aux=UserService.checkAccountInformation(username,password);
            if(aux==1)
            {
                Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                window1 = (Stage)LOGINButton.getScene().getWindow();
                window1.setScene(new Scene(root));
            }
            else if(aux==2)
            {
                Parent root = FXMLLoader.load(getClass().getResource("MainPageMedic.fxml"));
                window1 = (Stage)LOGINButton.getScene().getWindow();
                window1.setScene(new Scene(root));
            }

        }catch (NullUsernameException e)
        {
            FailedLogInMessage.setText(e.getMessage());
        }
        catch (NullPasswordException e)
        {
            FailedLogInMessage.setText(e.getMessage());
        }
        catch (LogInException e)
        {
            FailedLogInMessage.setText((e.getMessage()));
        }

    }

    @FXML
    JFXButton BackFromLogInButton;

    public void switchToMainFromLogIn(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        window1 = (Stage)BackFromLogInButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    private BorderPane scenePane2;

    Stage stage1;
    public void close(MouseEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Inchide aplicatia");
        alert.setHeaderText("Sunteti sigur ca doriti sa parasiti aplicatia?");

        if(alert.showAndWait().get() == ButtonType.OK) {

            stage1 = (Stage) scenePane2.getScene().getWindow();
            stage1.close();
        }
    }



}