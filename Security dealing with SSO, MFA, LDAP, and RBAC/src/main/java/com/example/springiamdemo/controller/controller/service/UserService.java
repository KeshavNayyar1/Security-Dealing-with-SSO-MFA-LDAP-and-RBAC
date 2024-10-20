import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static final Map<String, String> roles = new HashMap<>();

    static {
        roles.put("admin", "ADMIN");
        roles.put("user", "USER");
    }

    public String getRole(String username) {
        return roles.getOrDefault(username, "GUEST");
    }
}
