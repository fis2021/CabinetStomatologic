import javafx.fxml.FXMLLoader;
import javafx.geometry.VerticalDirection;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static java.math.RoundingMode.DOWN;

@ExtendWith(ApplicationExtension.class)
class ControllerMainPacientTest {

    @BeforeEach
    void setUp() throws Exception {

        FileSystemService.APPLICATION_FOLDER = ".test-cabinet-stomatologic";
        FileUtils.cleanDirectory(FileSystemService.getAplicationHomeFolder().toFile());

        UserService.initDatabase();
        UserService.initDatabase1();
        UserService.initDatabase2();

    }

    @Start
    public void start(Stage primaryStage) throws Exception {

        UserService.initDatabase();
        UserService.initDatabase1();
        UserService.initDatabase2();

        primaryStage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setTitle("Cabinet Stomatologic");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Test
    public void testDetaliiClinica(FxRobot robot){
        robot.clickOn("#DetailsButton1");
        robot.clickOn("#piButton");
        robot.clickOn("#backfrompiButton");
        robot.clickOn("#lmButton");
        robot.clickOn("#backfrompiButton");
        robot.clickOn("#icButton");
        robot.clickOn("#backfromicButton");
        robot.clickOn("#BackFromDetailsButton");

    }

    @Test
    public void testFisaMedicala(FxRobot robot){
        robot.clickOn("#medFisButton");
        robot.clickOn("#nume");
        robot.write("Rusu Radu");
        robot.clickOn("#data");
        robot.write("12/6/2000");
        robot.clickOn("#numar");
        robot.write("1234567890");
        robot.clickOn("#da1");
        robot.clickOn("#da2");
        robot.scroll(10);
        robot.clickOn("#nu3");
        robot.clickOn("#nu4");
        robot.scroll(5);
        robot.clickOn("#da5");
        robot.clickOn("#da6");
        robot.scroll(10);
        robot.clickOn("#nu7");
        robot.clickOn("#da8");
        robot.scroll(10);
        robot.clickOn("#da9");
        robot.clickOn("#da10");
        robot.clickOn("#sumbitFisaMedicala");
        robot.clickOn("#BackFromMedFis");

    }

    @Test
    public void testProgramare(FxRobot robot){
        robot.clickOn("#progrButton");
        robot.clickOn("#nume");
        robot.write("Rusu");
        robot.clickOn("#prenume");
        robot.write("Radu");
        robot.clickOn("#nr");
        robot.write("1234567890");
        robot.clickOn("#data");
        robot.write("5/8/2011");
        robot.clickOn("#checkButton");
        robot.clickOn("#submitButton");
        robot.clickOn("#backButton");

    }

    @Test
    public void testVeziProgramari(FxRobot robot){
        robot.clickOn("#programari");
        robot.clickOn("#table");
        robot.scroll(50);
        robot.clickOn("#backButton");
    }

    @Test
    public void testVeziProgramariMeniu(FxRobot robot){

        robot.clickOn("#MenuClose");
        robot.clickOn("#programari1");
        robot.clickOn("#table");
        robot.scroll(50);
        robot.clickOn("#backButton");
    }

    @Test
    public void testProgramareMeniu(FxRobot robot){
        robot.clickOn("#MenuClose");
        robot.clickOn("#progrButton1");
        robot.clickOn("#nume");
        robot.write("Rusu");
        robot.clickOn("#prenume");
        robot.write("Radu");
        robot.clickOn("#nr");
        robot.write("1234567890");
        robot.clickOn("#data");
        robot.write("5/8/2011");
        robot.clickOn("#checkButton");
        robot.clickOn("#submitButton");
        robot.clickOn("#backButton");

    }

    @Test
    public void testFisaMedicalaMeniu(FxRobot robot){
        robot.clickOn("#MenuClose");
        robot.clickOn("#MedFisButtonUp");
        robot.clickOn("#nume");
        robot.write("Rusu Radu");
        robot.clickOn("#data");
        robot.write("12/6/2000");
        robot.clickOn("#numar");
        robot.write("1234567890");
        robot.clickOn("#da1");
        robot.clickOn("#da2");
        robot.scroll(10);
        robot.clickOn("#nu3");
        robot.clickOn("#nu4");
        robot.scroll(10);
        robot.clickOn("#da5");
        robot.clickOn("#da6");
        robot.scroll(10);
        robot.clickOn("#nu7");
        robot.clickOn("#da8");
        robot.scroll(10);
        robot.clickOn("#da9");
        robot.clickOn("#da10");
        robot.clickOn("#sumbitFisaMedicala");
        robot.clickOn("#BackFromMedFis");

    }

    @Test
    public void testDetaliiClinicaMeniu(FxRobot robot){
        robot.clickOn("#Menu");
        robot.clickOn("#MenuClose");
        robot.clickOn("#DetailsButton");
        robot.clickOn("#piButton");
        robot.clickOn("#backfrompiButton");
        robot.clickOn("#lmButton");
        robot.clickOn("#backfrompiButton");
        robot.clickOn("#icButton");
        robot.clickOn("#backfromicButton");
        robot.clickOn("#BackFromDetailsButton");

    }


}