import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.assertions.api.Assertions.assertThat;

class UserServiceTest {

    public static final String MEDIC = "Medic";

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
        UserService.initDatabase1();
        UserService.initDatabase2();

    }

    @AfterEach
    void tearDown(){
        System.out.println("after each");
    }

    @Test
    @DisplayName("UserRepository is initialized and no user is persisted")
    void testUserRepositoryIsInitializedAndNoUserIsPersisted() {

        assertThat(UserService.getAllUsers()).isNotNull();
        assertThat(UserService.getAllUsers()).isEmpty();
    }

    @Test
    @DisplayName("User is succsessfully persisted to UserRepository")
    void testUserIsAddedToUserRepository() throws UsernameAlreadyExistsException {
        UserService.addUser(MEDIC, MEDIC, MEDIC);
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
        User user = UserService.getAllUsers().get(0);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(MEDIC);
        assertThat(user.getPassword()).isEqualTo(UserService.encodePassword(MEDIC, MEDIC));
        assertThat(user.getRole()).isEqualTo(MEDIC);
    }

    @Test
    @DisplayName("User cannot be added twice to UserRepository")
    void testUserCannotBeAddedTwiceToUserRepository(){

        assertThrows(UsernameAlreadyExistsException.class, () -> {
            UserService.addUser(MEDIC, MEDIC, MEDIC);
            UserService.addUser(MEDIC, MEDIC, MEDIC);
        });
    }



    @Test
    @DisplayName("UserRepository1 is initialized and no user is persisted")
    void testUserRepository1IsInitializedAndNoUserIsPersisted() {
        assertThat(UserService.getAllUsers()).isNotNull();
        assertThat(UserService.getAllUsers()).isEmpty();
    }

    @Test
    @DisplayName("User is succsessfully persisted to UserRepository1")
    void testUserIsAddedToUserRepository1() throws UsernameAlreadyExistsException {
        UserService.addUser1("Rosa","Flavius", "0724562189", "05.04.2004");
        org.assertj.core.api.Assertions.assertThat(UserService.getAllUsers1()).size().isEqualTo(1);
        Persoana persoana = UserService.getAllUsers1().get(0);
        assertThat(persoana).isNotNull();
        assertThat(persoana.getNume()).isEqualTo("Rosa");
        assertThat(persoana.getPrenume()).isEqualTo("Flavius");
        assertThat(persoana.getNr()).isEqualTo("0724562189");
        assertThat(persoana.getData()).isEqualTo("05.04.2004");
    }

    @Test
    @DisplayName("User cannot be added twice to UserRepository1")
    void testUserCannotBeAddedTwiceToUserRepository1(){

        assertThrows(UsernameAlreadyExistsException.class, () -> {
            UserService.addUser1("Rosa","Flavius", "0724562189", "05.04.2004");
            UserService.addUser1("Rosa","Flavius", "0724562189", "05.04.2004");
        });
    }
}