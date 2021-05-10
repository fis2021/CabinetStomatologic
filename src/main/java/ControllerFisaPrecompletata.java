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

    @FXML
    public javafx.scene.control.RadioButton da1, da2, da3, da4, da5, da6, da7, da8, da9, da10;
    @FXML
    public javafx.scene.control.RadioButton nu1, nu2, nu3, nu4, nu5, nu6, nu7, nu8, nu9, nu10;

    public void setFis(String s1, String s2, String s3, Boolean b1, Boolean b2, Boolean b3, Boolean b4, Boolean b5, Boolean b6, Boolean b7, Boolean b8, Boolean b9, Boolean b10) throws Exception {
        lb1.setText(s1);
        lb2.setText(s2);
        lb3.setText(s3);

        if(b1 == true){
            da1.setSelected(true);
            nu1.setSelected(false);
        }
        else{
            da1.setSelected(false);
            nu1.setSelected(true);
        }
        if(b2 == true){
            da2.setSelected(true);
            nu2.setSelected(false);
        }
        else{
            da2.setSelected(false);
            nu2.setSelected(true);
        }
        if(b3 == true){
            da3.setSelected(true);
            nu3.setSelected(false);
        }
        else{
            da3.setSelected(false);
            nu3.setSelected(true);
        }
        if(b4 == true){
            da4.setSelected(true);
            nu4.setSelected(false);
        }
        else{
            da4.setSelected(false);
            nu4.setSelected(true);
        }
        if(b5 == true){
            da5.setSelected(true);
            nu5.setSelected(false);
        }
        else {
            da5.setSelected(false);
            nu5.setSelected(true);
        }
        if(b6 == true){
            da6.setSelected(true);
            nu6.setSelected(false);
        }
        else {
            da6.setSelected(false);
            nu6.setSelected(true);
        }
        if(b7 == true){
            da7.setSelected(true);
            nu7.setSelected(false);
        }
        else{
            da7.setSelected(false);
            nu7.setSelected(true);
        }
        if(b8 == true){
            da8.setSelected(true);
            nu8.setSelected(false);
        }
        else{
            da8.setSelected(false);
            nu8.setSelected(true);
        }
        if(b9 == true){
            da9.setSelected(true);
            nu9.setSelected(false);
        }
        else{
            da9.setSelected(false);
            nu9.setSelected(true);
        }
        if(b10 == true){
            da10.setSelected(true);
            nu10.setSelected(false);
        }
        else{
            da10.setSelected(false);
            nu10.setSelected(true);
        }
        da1.setDisable(true);
        nu1.setDisable(true);

        da2.setDisable(true);
        nu2.setDisable(true);

        da3.setDisable(true);
        nu3.setDisable(true);

        da4.setDisable(true);
        nu4.setDisable(true);

        da5.setDisable(true);
        nu5.setDisable(true);

        da6.setDisable(true);
        nu6.setDisable(true);

        da7.setDisable(true);
        nu7.setDisable(true);

        da8.setDisable(true);
        nu8.setDisable(true);

        da9.setDisable(true);
        nu9.setDisable(true);

        da10.setDisable(true);
        nu10.setDisable(true);
    }

}
