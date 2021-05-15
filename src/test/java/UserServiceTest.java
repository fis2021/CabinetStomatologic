import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.assertions.api.Assertions.assertThat;

class UserServiceTest {

    public static final String MEDIC = "medic";

    @BeforeAll
    static void beforeAll(){
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("after all");
    }

    @BeforeEach
    void setUp() throws Exception{

        FileSystemService.APPLICATION_FOLDER = ".test-cabinet-stomatologic";
        FileUtils.cleanDirectory(FileSystemService.getAplicationHomeFolder().toFile());

        UserService.initDatabase();

    }

    @AfterEach
     void tearDown(){
        System.out.println("after each");
    }

    @Test
    @DisplayName("Database is initialized and no user is persisted")
    void testDatabaseIsInitializedAndNoUserIsPersisted() {

        assertThat(UserService.getAllUsers()).isNotNull();
        assertThat(UserService.getAllUsers()).isEmpty();
    }

    @Test
    @DisplayName("User is succsessfully persisted to Database")
    void testUserIsAddedToDatabase() throws UsernameAlreadyExistsException {
         UserService.addUser(MEDIC, "medic", "medic");
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
        User user = UserService.getAllUsers().get(0);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(MEDIC);
        assertThat(user.getPassword()).isEqualTo(UserService.encodePassword(MEDIC, MEDIC));
        assertThat(user.getRole()).isEqualTo(MEDIC);
    }

    @Test
    @DisplayName("User cannot be added twice")
    void testUserCannotBeAddedTwice(){

        assertThrows(UsernameAlreadyExistsException.class, () -> {
            UserService.addUser(MEDIC, MEDIC, MEDIC);
            UserService.addUser(MEDIC, MEDIC, MEDIC);
        });
    }
}