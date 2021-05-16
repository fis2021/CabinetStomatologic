import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import org.apache.commons.io.FileUtils;
import org.dizitart.no2.Nitrite;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.assertions.api.Assertions.assertThat;

class UserServiceTest {

    public static final String MEDIC = "Medic";
    public static final String ROSA = "Rosa";
    public static final String FLAVIUS = "Flavius";
    public static final String DATA = "05.02.2014";
    public static final String NR = "0724567142";

    // RadioButton da1, da2, da3, da4, da5, da6, da7, da8, da9, da10, nu1, nu2, nu3, nu4, nu5, nu6, nu7, nu8, nu9, nu10;

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
    @DisplayName("Username cannot be empty when login")
    void testUserCannotBeEmptyLogIn() {
        assertThrows(NullUsernameException.class, () -> {
            UserService.checkAccountInformation("",MEDIC);
        });
    }

    @Test
    @DisplayName("Password cannot be empty when login")
    void testPasswordCannotBeEmptyLogIn() {

        assertThrows(NullPasswordException.class, () -> {
            UserService.checkAccountInformation(MEDIC,"");
        });
    }

    @Test
    @DisplayName("Credentials are wrong")
    void testCredentialsNotFoundLogIn() {
        assertDoesNotThrow(()-> {
            UserService.addUser(MEDIC,MEDIC,MEDIC);
        });
        assertThrows(LogInException.class, () -> {
            UserService.checkAccountInformation("wrong","wrong");
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
        UserService.addUser1(ROSA, FLAVIUS, "0724562189", "05.04.2004");
        org.assertj.core.api.Assertions.assertThat(UserService.getAllUsers1()).size().isEqualTo(1);
        Persoana persoana = UserService.getAllUsers1().get(0);
        assertThat(persoana).isNotNull();
        assertThat(persoana.getNume()).isEqualTo(ROSA);
        assertThat(persoana.getPrenume()).isEqualTo(FLAVIUS);
        assertThat(persoana.getNr()).isEqualTo("0724562189");
        assertThat(persoana.getData()).isEqualTo("05.04.2004");
    }

    @Test
    @DisplayName("LastName cannot be empty when appointment")
    void testPersoanaLastNameCannotBeEmptyAppointment() {
        assertThrows(NullLastNameException.class, () -> {
            UserService.checkProgramare("", FLAVIUS, DATA, NR, true);
        });
    }

    @Test
    @DisplayName("FirstName cannot be empty when appointment")
    void testPersoanaFirstNameCannotBeEmptyAppointment() {
        assertThrows(NullFirstNameException.class, () -> {
            UserService.checkProgramare(ROSA, "", DATA, NR, true);
        });
    }

    @Test
    @DisplayName("Data cannot be empty when appointment")
    void testPersoanaDataCannotBeEmptyAppointment() {
        assertThrows(NullDataException.class, () -> {
            UserService.checkProgramare(ROSA, FLAVIUS, "", NR, true);
        });
    }
    @Test
    @DisplayName("Number cannot be empty when appointment")
    void testPersoanaNumberCannotBeEmptyAppointment() {
        assertThrows(NullNumberException.class, () -> {
            UserService.checkProgramare(ROSA, FLAVIUS, DATA, "", true);
        });
    }

    @Test
    @DisplayName("Wrong number when appointment")
    void testPersoanaWrongNumberAppointment() {
        assertThrows(WrongNumberException.class, () -> {
            UserService.checkProgramare(ROSA, FLAVIUS, DATA, "012", true);
        });
    }
    @Test
    @DisplayName("Wrong number when appointment")
    void testPersoanaWrongNumber1Appointment() {
        assertThrows(WrongNumberException.class, () -> {
            UserService.checkProgramare(ROSA, FLAVIUS, DATA, "075489247a", true);
        });
    }

    @Test
    @DisplayName("Wrong number when appointment")
    void testPersoanaWrongNumber2Appointment() {
        assertThrows(WrongNumberException.class, () -> {
            UserService.checkProgramare(ROSA, FLAVIUS, DATA, "07548924788", true);
        });
    }

    @Test
    @DisplayName("Must check the box when appointment")
    void testPersoanaCheckBoxNotSelectedAppointment() {
        assertThrows(NullCheckButtonException.class, () -> {
            UserService.checkProgramare(ROSA, FLAVIUS, DATA, NR, false);
        });
    }





    @Test
    @DisplayName("UserRepository2 is initialized and no user is persisted")
    void testUserRepository2IsInitializedAndNoUserIsPersisted() {
        assertThat(UserService.getAllUsers2()).isNotNull();
        assertThat(UserService.getAllUsers2()).isEmpty();
    }

    @Test
    @DisplayName("User is succsessfully persisted to UserRepository2")
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

    @Test
    @DisplayName("Username cannot be empty when medical file")
    void testUsernameCannotBeEmptyMedicalFile() {
        assertThrows(NullUsernameException.class, () -> {
            UserService.checkFisaMedicala("",NR,DATA,true, false,true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true, false ,true);
        });
    }

    @Test
    @DisplayName("Data cannot be empty when medical file")
    void testDataCannotBeEmptyMedicalFile() {
        assertThrows(NullDataException.class, () -> {
            UserService.checkFisaMedicala("Rosa Flavius",NR,"",true, false,true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true, false ,true);
        });
    }

    @Test
    @DisplayName("Number cannot be empty when medical file")
    void testNumberCannotBeEmptyMedicalFile() {
        assertThrows(NullNumberException.class, () -> {
            UserService.checkFisaMedicala("Rosa Flavius","",DATA,true, false,true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true, false ,true);
        });
    }

    @Test
    @DisplayName("Wrong number when medical file")
    void testWrongNumberMedicalFile() {
        assertThrows(WrongNumberException.class, () -> {
            UserService.checkFisaMedicala("Rosa Flavius","123",DATA,true, false,true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true, false ,true);
        });
    }

    @Test
    @DisplayName("Wrong number when medical file")
    void testWrongNumber1MedicalFile() {
        assertThrows(WrongNumberException.class, () -> {
            UserService.checkFisaMedicala("Rosa Flavius","07245672133",DATA,true, false,true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true, false ,true);
        });
    }

    @Test
    @DisplayName("Wrong number when medical file")
    void testWrongNumber2MedicalFile() {
        assertThrows(WrongNumberException.class, () -> {
            UserService.checkFisaMedicala("Rosa Flavius","072456721a",DATA,true, false,true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true, false ,true);
        });
    }

    @Test
    @DisplayName("This appointment already exists medical file")
    void testAlreadyExistAppointmentMedicalFile() {
        assertDoesNotThrow(()-> {
            UserService.addFisa("Rosa Flavius", NR, DATA, true, false, true, false, true, false, true, false, true, false);

        });
        assertThrows(AlreadyExistAppointmentException.class, () -> {
            UserService.checkFisaMedicala("Rosa Flavius",NR,DATA,true, false,true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true, false ,true);

        });
    }

    @Test
    @DisplayName("Please select all fields1")
    void test1orMoreUnselctedChoiseMedicalFile() {
        assertThrows(Null1OfChoicesException.class, () -> {
            UserService.checkFisaMedicala("Rosa Flavius",NR,DATA,true, false,true, false, true, false, true, false, true, false, true, true, false, true, false, true, false, true, false ,true);
        });
    }
    @Test
    @DisplayName("Please select all fields2")
    void test1orMoreUnselctedChoise1MedicalFile() {
        assertThrows(Null1OfChoicesException.class, () -> {
            UserService.checkFisaMedicala("Rosa Flavius",NR,DATA,true, false,true, false, true, false, true, false, true, false, false, false, false, true, false, true, false, true, false ,true);
        });
    }
    @Test
    @DisplayName("Please select all fields3")
    void test1orMoreUnselctedChoise2MedicalFile() {
        assertThrows(Null1OfChoicesException.class, () -> {
            UserService.checkFisaMedicala("Rosa Flavius",NR,DATA,true, false,true, false, true, false, true, false, true, false, false, true, true, true, false, true, false, true, false ,true);
        });
    }

    @Test
    @DisplayName("Username cannot be empty when verify medical file")
    void testUsernameCannotBeEmptyVerifyMedicalFile() {
        assertThrows(NullUsernameException.class, () -> {
            UserService.checkNameInDataBaseFisaMedicala("");
        });
    }

    @Test
    @DisplayName("Medical file isn't completed yet!")
    void testMedicalFileIsNotCompletedVerifyMedicalFile() {

        assertThrows(NoCompleteFisaException.class, () -> {
            UserService.checkNameInDataBaseFisaMedicala("Rosa Flavius");
        });
    }






}