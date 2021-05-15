import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        UserService.initDatabase();
        UserService.initDatabase1();
        UserService.initDatabase2();

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setTitle("Cabinet Stomatologic");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Stage window1;
    private Scene scene;
    private Parent root;

    @FXML
    JFXButton SignUpButton;

    public void switchToSignUp(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        window1 = (Stage)SignUpButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }



    @FXML
    private AnchorPane scenePane;

    Stage stage;


    public void close(javafx.event.ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close Program");
        alert.setHeaderText("Are you sure you want to close?");

        if(alert.showAndWait().get() == ButtonType.OK) {

            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
        }
    }





    @FXML
    JFXButton LogInButton;

    public void switchToLogIn(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        window1 = (Stage)LogInButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }





}
