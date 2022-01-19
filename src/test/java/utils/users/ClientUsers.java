package utils.users;

public class ClientUsers {
    /**
     * This method is used to create user body needed for post request
     * @param name
     * @param gender
     * @param email
     * @return
     */
    public String getUserBody(String name, String gender, String email) {
        return "{\"name\":\"" + name + "\"," +
                " \"gender\":\"" + gender + "\"," +
                " \"email\":\"" + email + "\"," +
                " \"status\":\"active\"}";
    }
}
