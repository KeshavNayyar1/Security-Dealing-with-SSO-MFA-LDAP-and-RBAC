import java.util.HashMap;
import java.util.Map;

public class RoleService {
    private static final Map<String, String> roles = new HashMap<>();
    private static final Map<String, String[]> permissions = new HashMap<>();

    static {
        roles.put("admin", "ADMIN");
        roles.put("user", "USER");

        permissions.put("ADMIN", new String[]{"READ", "WRITE", "DELETE", "MANAGE_USERS"});
        permissions.put("USER", new String[]{"READ", "WRITE"});
    }

    public String[] getPermissions(String role) {
        return permissions.getOrDefault(role, new String[]{"READ"});
    }

    public boolean hasPermission(String role, String permission) {
        String[] rolePermissions = getPermissions(role);
        for (String p : rolePermissions) {
            if (p.equals(permission)) {
                return true;
            }
        }
        return false;
    }
}
