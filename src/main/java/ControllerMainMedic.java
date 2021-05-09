import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerMainMedic {
    @FXML
    JFXButton BackButtonMedic;

    public void goBackMedic(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Stage window1 = (Stage) BackButtonMedic.getScene().getWindow();
        window1.setScene(new Scene(root));
    }
}
