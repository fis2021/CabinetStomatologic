import org.apache.commons.io.FileUtils;
import org.dizitart.no2.Nitrite;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.assertions.api.Assertions.assertThat;

class UserServiceTest {

    public static final String MEDIC = "Medic";

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void setUp() throws Exception {

        FileSystemService.APPLICATION_FOLDER = ".test-cabinet-stomatologic";
        FileUtils.cleanDirectory(FileSystemService.getAplicationHomeFolder().toFile());

        UserService.initDatabase();
        UserService.initDatabase1();
        UserService.initDatabase2();

    }

    @AfterEach
    void tearDown() {
        UserService.closeDataBase();
        UserService.closeDataBase1();
        UserService.closeDataBase2();
    }

    @Test
    @DisplayName("UserRepository is initialized and no user is persisted")
    void testUserRepositoryIsInitializedAndNoUserIsPersisted() {

        assertThat(UserService.getAllUsers()).isNotNull();
        assertThat(UserService.getAllUsers()).isEmpty();
    }

    @Test
    @DisplayName("User is succsessfully persisted to UserRepository")
    void testUserIsAddedToUserRepository() throws UsernameAlreadyExistsException, NullPasswordException, Password5CharactersException, NullUsernameException {
        UserService.addUser(MEDIC, MEDIC, MEDIC);
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
        User user = UserService.getAllUsers().get(0);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(MEDIC);
        assertThat(user.getPassword()).isEqualTo(UserService.encodePassword(MEDIC, MEDIC));
        assertThat(user.getRole()).isEqualTo(MEDIC);
    }


    @Test
    @DisplayName("Username cannot be empty")
    void testUserUsernameCannotBeEmptyToUserRepository() {

        assertThrows(NullUsernameException.class, () -> {
            UserService.addUser("", MEDIC, MEDIC);

        });
    }

    @Test
    @DisplayName("Username cannot be empty")
    void testUserPasswordCannotBeEmptyToUserRepository() {

        assertThrows(NullPasswordException.class, () -> {
            UserService.addUser(MEDIC, "", MEDIC);

        });
    }
    @Test
    @DisplayName("Password must have minimum 5 characters")
    void testUserPasswordMinimum5CharacterstToUserRepository() {

        assertThrows(Password5CharactersException.class, () -> {
            UserService.addUser(MEDIC, "a", MEDIC);

        });
    }

    @Test
    @DisplayName("User cannot be added twice to UserRepository")
    void testUserCannotBeAddedTwiceToUserRepository() {

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
    void testUserIsAddedToUserRepository1() {
        UserService.addUser1("Rosa", "Flavius", "0724562189", "05.04.2004");
        org.assertj.core.api.Assertions.assertThat(UserService.getAllUsers1()).size().isEqualTo(1);
        Persoana persoana = UserService.getAllUsers1().get(0);
        assertThat(persoana).isNotNull();
        assertThat(persoana.getNume()).isEqualTo("Rosa");
        assertThat(persoana.getPrenume()).isEqualTo("Flavius");
        assertThat(persoana.getNr()).isEqualTo("0724562189");
        assertThat(persoana.getData()).isEqualTo("05.04.2004");
    }





    @Test
    @DisplayName("UserRepository1 is initialized and no user is persisted")
    void testUserRepository2IsInitializedAndNoUserIsPersisted() {
        assertThat(UserService.getAllUsers2()).isNotNull();
        assertThat(UserService.getAllUsers2()).isEmpty();
    }

    @Test
    @DisplayName("User is succsessfully persisted to UserRepository1")
    void testUserIsAddedToUserRepository2() {
        UserService.addFisa("Rosa Flavius", "0724562189", "02.09.2001", true, false, true, false, true, false, true, false, true, false);
        org.assertj.core.api.Assertions.assertThat(UserService.getAllUsers2()).size().isEqualTo(1);
        FisaMedicala fisaMedicala = UserService.getAllUsers2().get(0);
        assertThat(fisaMedicala).isNotNull();
        assertThat(fisaMedicala.getNume()).isEqualTo("Rosa Flavius");
        assertThat(fisaMedicala.getNumarTelefon()).isEqualTo("0724562189");
        assertThat(fisaMedicala.getData()).isEqualTo("02.09.2001");
        assertThat(fisaMedicala.isQ1()).isEqualTo(true);
        assertThat(fisaMedicala.isQ2()).isEqualTo(false);
        assertThat(fisaMedicala.isQ3()).isEqualTo(true);
        assertThat(fisaMedicala.isQ4()).isEqualTo(false);
        assertThat(fisaMedicala.isQ5()).isEqualTo(true);
        assertThat(fisaMedicala.isQ6()).isEqualTo(false);
        assertThat(fisaMedicala.isQ7()).isEqualTo(true);
        assertThat(fisaMedicala.isQ8()).isEqualTo(false);
        assertThat(fisaMedicala.isQ9()).isEqualTo(true);
        assertThat(fisaMedicala.isQ10()).isEqualTo(false);
    }





}