import javafx.fxml.FXMLLoader;
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

@ExtendWith(ApplicationExtension.class)
class RegistrationTest {

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
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setTitle("Cabinet Stomatologic");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Test
    public void test(FxRobot robot){
        robot.clickOn("#SignUpButton");

        robot.clickOn("#usernameField");
        robot.write("username");
        robot.clickOn("#passwordField");
        robot.write("password");
        robot.clickOn("#inregistrare");
        robot.clickOn("#inregistrare");

        robot.clickOn("#BackButton");


        robot.clickOn("#LogInButton");
        robot.clickOn("#LogInUsername");
        robot.write("username");
        robot.clickOn("#LogInPassword");
        robot.write("password");
        robot.clickOn("#LOGINButton");
    }
}