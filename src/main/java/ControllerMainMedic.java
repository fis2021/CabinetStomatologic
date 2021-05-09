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

    private Stage window1;
    private Scene scene;
    private Parent root;

    public void goBackMedic(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Stage window1 = (Stage) BackButtonMedic.getScene().getWindow();
        window1.setScene(new Scene(root));
    }

    @FXML
    JFXButton vpButton;

    public void vp(MouseEvent event) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaPacienti.fxml"));
        root = loader.load();

        ControllerListaPacienti controllerListaPacienti = loader.getController();
        controllerListaPacienti.setItems();

        //Parent root = FXMLLoader.load(getClass().getResource("ListaPacienti.fxml"));
        window1 = (Stage) vpButton.getScene().getWindow();
        window1.setScene(new Scene(root, 600, 400));
    }

}
