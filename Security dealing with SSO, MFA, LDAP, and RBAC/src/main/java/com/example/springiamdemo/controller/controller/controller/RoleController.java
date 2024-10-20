@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/admin")
    public String adminEndpoint(@RequestHeader("Authorization") String token) {
        String username = JwtUtil.validateToken(token.replace("Bearer ", ""));
        String role = roleService.getRole(username);

        if (roleService.hasPermission(role, "MANAGE_USERS")) {
            return "Welcome, Admin!";
        }
        return "Access Denied!";
    }
}
