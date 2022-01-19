package utils.users.pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String name;
    private String email;
    private String gender;
    private String status;

//    public User(String name, String email, String gender, String status) {
//        this.name = name;
//        this.email = email;
//        this.gender = gender;
//        this.status = status;
//    }
}
