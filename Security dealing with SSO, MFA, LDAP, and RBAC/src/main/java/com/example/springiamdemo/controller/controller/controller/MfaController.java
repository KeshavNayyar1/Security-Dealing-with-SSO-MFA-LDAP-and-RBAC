@RestController
public class MfaController {
    @Autowired
    private MfaService mfaService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/mfa/sendOtp")
    public String sendOtp(@RequestParam String email) {
        String otp = mfaService.generateOtp();
        emailService.sendOtpEmail(email, otp);
        return "OTP sent to " + email;
    }

    @PostMapping("/mfa/verifyOtp")
    public boolean verifyOtp(@RequestParam String otp) {
        return mfaService.verifyOtp(otp);
    }
}
