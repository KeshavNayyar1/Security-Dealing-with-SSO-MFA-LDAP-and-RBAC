@RestController
public class LdapController {
    private LdapService ldapService = new LdapService();

    @PostMapping("/ldap/authenticate")
    public boolean authenticate(@RequestBody LoginRequest request) {
        return ldapService.authenticate(request.getUsername(), request.getPassword());
    }
}
