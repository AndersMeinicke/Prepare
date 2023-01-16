package dto;
import entities.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    String username;
    String password;

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public UserDTO(User user) {
    }

    public static List<UserDTO> getUserDTOs(List<User> users) {
        List<UserDTO> userDTOList = new ArrayList<>();
        users.forEach(user -> {
            userDTOList.add(new UserDTO(user));
        });
        return userDTOList;
    }
}
