import java.util.Random;

public class MfaService {
    private String generatedOtp;

    public String generateOtp() {
        Random random = new Random();
        generatedOtp = String.format("%06d", random.nextInt(999999));
        return generatedOtp;
    }

    public boolean verifyOtp(String otp) {
        return generatedOtp != null && generatedOtp.equals(otp);
    }
}
 