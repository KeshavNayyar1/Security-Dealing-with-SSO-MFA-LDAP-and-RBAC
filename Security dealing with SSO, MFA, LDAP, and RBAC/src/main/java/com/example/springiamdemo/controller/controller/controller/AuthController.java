@RestController
public class AuthController {
    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticate(@RequestBody LoginRequest request) {
        if ("user".equals(request.getUsername()) && "password".equals(request.getPassword())) {
            String accessToken = JwtUtil.generateAccessToken(request.getUsername());
            String refreshToken = JwtUtil.generateRefreshToken(request.getUsername());
            Map<String, String> tokens = new HashMap<>();
            tokens.put("accessToken", accessToken);
            tokens.put("refreshToken", refreshToken);
            return ResponseEntity.ok(tokens);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refreshToken(@RequestBody Map<String, String> tokenRequest) {
        String refreshToken = tokenRequest.get("refreshToken");
        String username = JwtUtil.validateToken(refreshToken);
        if (username != null) {
            String newAccessToken = JwtUtil.generateAccessToken(username);
            return ResponseEntity.ok(newAccessToken);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
