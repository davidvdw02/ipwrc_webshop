package nl.david.ipwrc_webshop.service;

import java.util.Arrays;
import java.util.Base64;

public class ImageValidatorService {
    private static final byte[] PNG_MAGIC_NUMBER = { (byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A };

    public static boolean validateImage(String base64Image) {
        if (base64Image == null || !base64Image.matches("data:image/png;base64,[a-zA-Z0-9+/]+={0,2}")) {
            return false;
        }
        return isBase64Png(base64Image) && hasPngExtension(base64Image);
    }

    static boolean isBase64Png(String base64Image) {
        try {
            String base64Data = base64Image.split(",")[1];
            if (base64Data.length() % 4 != 0) {
                return false;
            }

            byte[] decodedBytes = Base64.getDecoder().decode(base64Data);

            if (decodedBytes.length < 8) {
                return false;
            }

            byte[] fileSignature = Arrays.copyOfRange(decodedBytes, 0, 8);

            return Arrays.equals(fileSignature, PNG_MAGIC_NUMBER);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static boolean hasPngExtension(String base64Image) {
        String base64Data = base64Image.split(",")[0];
        return base64Data.endsWith("data:image/png;base64");
    }

}
