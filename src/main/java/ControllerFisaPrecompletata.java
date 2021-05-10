import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerFisaPrecompletata {

    private Stage window1;
    private Scene scene;
    private Parent root;

    @FXML
    JFXButton BackButton;

    public void back(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainPageMedic.fxml"));
        window1 = (Stage)BackButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }
}
