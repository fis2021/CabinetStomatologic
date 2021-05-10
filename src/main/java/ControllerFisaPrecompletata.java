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

    @FXML
    public javafx.scene.control.Label lb1, lb2, lb3;

    public void back(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MainPageMedic.fxml"));
        window1 = (Stage)BackButton.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    public void setFis(String s1, String s2, String s3) throws Exception {
        lb1.setText(s1);
        lb2.setText(s2);
        lb3.setText(s3);
    }

}
