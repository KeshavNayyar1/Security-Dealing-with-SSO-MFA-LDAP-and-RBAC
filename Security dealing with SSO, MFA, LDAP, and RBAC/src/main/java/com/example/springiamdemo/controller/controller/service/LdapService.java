import java.util.HashMap;
import java.util.Map;

public class LdapService {
    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("admin", "adminpassword"); // Mock LDAP entries
        users.put("user", "userpassword");
    }

    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
