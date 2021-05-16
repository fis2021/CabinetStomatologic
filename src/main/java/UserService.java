import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;


public class UserService {

    private static Nitrite database;
    private static Nitrite database1;
    private static Nitrite database2;

    public static ObjectRepository<User> userRepository;
    public static ObjectRepository<Persoana> userRepository1;
    public static ObjectRepository<FisaMedicala> userRepository2;

    public static void initDatabase() {
        FileSystemService.initDirectory();
        database = Nitrite.builder()
                .filePath(FileSystemService.getPathToFile("cabinet-stomatologic.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }

    public static void closeDataBase() {
        database.close();
    }

    public static List<User> getAllUsers() {
        return userRepository.find().toList();
    }

    public static void initDatabase1() {
        database1 = Nitrite.builder()
                .filePath(FileSystemService.getPathToFile("lista-programari.db").toFile())
                .openOrCreate("test", "test");

        userRepository1 = database1.getRepository(Persoana.class);
    }

    public static void closeDataBase1() {
        database1.close();
    }


    public static List<Persoana> getAllUsers1() {
        return userRepository1.find().toList();
    }


    public static void initDatabase2() {
        database2 = Nitrite.builder()
                .filePath(FileSystemService.getPathToFile("fisa-medicala.db").toFile())
                .openOrCreate("test", "test");

        userRepository2 = database2.getRepository(FisaMedicala.class);
    }

    public static void closeDataBase2() {
        database2.close();
    }


    public static List<FisaMedicala> getAllUsers2() {
        return userRepository2.find().toList();
    }


    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException, NullPasswordException, Password5CharactersException, NullUsernameException {
        check(username, password);
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role));
    }

    public static void addUser1(String nume, String prenume, String nr, String data) {
        userRepository1.insert(new Persoana(nume, prenume, nr, data));
    }

    public static void addFisa(String nume, String numarTelefon, String data, boolean q1, boolean q2, boolean q3, boolean q4, boolean q5, boolean q6, boolean q7, boolean q8, boolean q9, boolean q10) {
        userRepository2.insert(new FisaMedicala(nume, numarTelefon, data, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10));

    }

    public static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }

    private static void check(String username, String password) throws NullUsernameException, NullPasswordException, Password5CharactersException {
        if (username.equals("")) {
            throw new NullUsernameException();
        } else if (password.equals("")) {
            throw new NullPasswordException();
        } else if (!password.equals("") && password.length() < 5) {
            throw new Password5CharactersException();
        }

    }


    public static int checkAccountInformation(String username, String password) throws NullUsernameException, NullPasswordException, LogInException {
        int sw = 0;
        String encryptedPassword = encodePassword(username, password);
        if (username.equals("")) {
            throw new NullUsernameException();
        } else if (password.equals("")) {
            throw new NullPasswordException();
        }

        for (User user : UserService.userRepository.find()) {
            if (Objects.equals(username, user.getUsername()) && Objects.equals(encryptedPassword, user.getPassword())) {
                sw = 1;
                if (user.getRole().equals("Pacient")) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        if (sw == 0) {
            throw new LogInException();
        }
        return 0;
    }


    private static void checkEmptyFieldsProgramare(String lastName, String firstName, String data, String nr, Boolean buton) throws NullDataException, NullCheckButtonException, NullFirstNameException, NullLastNameException, NullNumberException {
        if (lastName.equals("")) {
            throw new NullLastNameException();

        } else if (firstName.equals("")) {
            throw new NullFirstNameException();
        } else if (nr == "") {
            throw new NullNumberException();
        } else if (data.equals("")) {
            throw new NullDataException();
        } else if (buton.equals(false)) {
            throw new NullCheckButtonException();
        }
    }

    private static boolean isNumberValid(String nr) {
        char ch;

        if (nr.length() != 10) {
            return false;
        }

        for (int i = 0; i < nr.length(); i++) {
            ch = nr.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }

    public static void checkProgramare(String Nume, String Prenume, String data, String nr, Boolean checkButton) throws NullNumberException, WrongNumberException, NullDataException, NullFirstNameException, NullCheckButtonException, NullLastNameException {
        checkEmptyFieldsProgramare(Nume, Prenume, data, nr, checkButton);
        if (!isNumberValid(nr)) {
            throw new WrongNumberException();
        }
    }


    public static void checkFisaMedicala(TextField name, String number, String data, RadioButton da1, RadioButton da2, RadioButton da3, RadioButton da4, RadioButton da5, RadioButton da6, RadioButton da7, RadioButton da8, RadioButton da9, RadioButton da10, RadioButton nu1, RadioButton nu2, RadioButton nu3, RadioButton nu4, RadioButton nu5, RadioButton nu6, RadioButton nu7, RadioButton nu8, RadioButton nu9, RadioButton nu10) throws NullDataException, NullUsernameException, Null1OfChoicesException, AlreadyExistAppointmentException, NullNumberException, WrongNumberException {
        if (name.getText().equals("")) {
            throw new NullUsernameException();

        } else if (checkNameFisaMedicala(name) == 1) {
            throw new AlreadyExistAppointmentException();
        } else if (data.equals("")) {
            throw new NullDataException();
        } else if (checkNumberFisaMedicala(number) == 1) {
            throw new NullNumberException();
        } else if (checkNumberFisaMedicala(number) == 2) {
            throw new WrongNumberException();
        } else if (da1.isSelected() == nu1.isSelected() || da2.isSelected() == nu2.isSelected() || da3.isSelected() == nu3.isSelected() || da4.isSelected() == nu4.isSelected() || da5.isSelected() == nu5.isSelected() || da6.isSelected() == nu6.isSelected() || da7.isSelected() == nu7.isSelected() || da8.isSelected() == nu8.isSelected() || da9.isSelected() == nu9.isSelected() || da10.isSelected() == nu10.isSelected()) {
            throw new Null1OfChoicesException();

        }
    }

    private static int checkNameFisaMedicala(TextField nume) {
        for (FisaMedicala p : UserService.userRepository2.find()) {
            if (p.getNume().equals(nume.getText())) {
                return 1;
            }
        }
        return 0;
    }

    private static int checkNumberFisaMedicala(String numar) throws NullNumberException, WrongNumberException {
        int sw = 0;
        if (numar == "") {
            sw = 1;
        } else if (!isNumberValid(numar)) {
            sw = 2;
        }
        return sw;
    }


    private static int checkNameInDataBase(String name) {
        for (FisaMedicala p : UserService.userRepository2.find()) {
            if (p.getNume().equals(name)) {

                return 1;
            }
        }
        return 0;
    }

    private static void checkName(String name) throws NullUsernameException {
        if (name.equals("")) {
            throw new NullUsernameException();
        }
    }

    public static void checkNameInDataBaseFisaMedicala(String name) throws NoCompleteFisaException, NullUsernameException {
        checkName(name);
        if (checkNameInDataBase(name) == 0) {
            throw new NoCompleteFisaException();
        }
    }


    public static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }


}
