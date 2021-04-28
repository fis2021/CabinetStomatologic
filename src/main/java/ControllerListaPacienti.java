import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerListaPacienti {
    @FXML
    Label label;

    public void setLabel(String s){
        label.setText("Hello " + s);
    }
}
