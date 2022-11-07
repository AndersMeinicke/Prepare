package dto;
import org.mindrot.jbcrypt.BCrypt;
public class UserDTO {
    String username;
    String password;

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
