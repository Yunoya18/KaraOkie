package LoginExample;

/**
 *
 * @author noey
 */
public class UserAuthentication {
    public boolean authenticate(String username, String password) {
        // This method should check the credentials against the database
        // For simplicity, we're just checking if the username is "user" and the password is "password"
        return username.equals("user") && password.equals("password");
    }
}

