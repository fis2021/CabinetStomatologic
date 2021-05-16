import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;



public class UserService {

   public static ObjectRepository<User> userRepository;
    public static ObjectRepository<Persoana> userRepository1;
    public static ObjectRepository<FisaMedicala> userRepository2;

    public static void initDatabase() {
        FileSystemService.initDirectory();
        Nitrite database = Nitrite.builder()
                .filePath(FileSystemService.getPathToFile("cabinet-stomatologic.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }

    public static List<User> getAllUsers(){
        return userRepository.find().toList();
    }

    public static void initDatabase1() {
        Nitrite database = Nitrite.builder()
                .filePath(FileSystemService.getPathToFile("lista-programari.db").toFile())
                .openOrCreate("test", "test");

        userRepository1 = database.getRepository(Persoana.class);
    }

    public static List<Persoana> getAllUsers1(){
        return userRepository1.find().toList();
    }

    public static void initDatabase2() {
        Nitrite database = Nitrite.builder()
                .filePath(FileSystemService.getPathToFile("fisa-medicala.db").toFile())
                .openOrCreate("test", "test");

        userRepository2 = database.getRepository(FisaMedicala.class);
    }

    public static List<FisaMedicala> getAllUsers2(){
        return userRepository2.find().toList();
    }

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role));
    }

    public static void addUser1(String nume, String prenume, String nr, String data)  {
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
