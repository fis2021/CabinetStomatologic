import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerLogIn{

    private Stage window1;
    private Scene scene;
    private Parent root;

    private String username,password,encryptedPassword;

    @FXML
     TextField LogInUsername;
    @FXML
     PasswordField LogInPassword;

    @FXML
    Button LOGINButton;

    private static int checkAccountInformation(String username, String password) {
        for (User user : UserService.userRepository.find()) {
            if (Objects.equals(username, user.getUsername()) && Objects.equals(password, user.getPassword()) )
                return 1;
        }
        return 0;
    }

    public void switchToMainPage(MouseEvent event) throws Exception {

        username = LogInUsername.getText();
        password = LogInPassword.getText();
        encryptedPassword=UserService.encodePassword(username,password);
        if(checkAccountInformation(username,encryptedPassword)==1)
        {
            Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            window1 = (Stage)LOGINButton.getScene().getWindow();
            window1.setScene(new Scene(root));
        }






    }

    @FXML
    Button BackFromLogInButton;

    public void switchToMainFromLogIn(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        window1 = (Stage)BackFromLogInButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }
}