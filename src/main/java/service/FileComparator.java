package service;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.DigestInputStream;

public class FileComparator {
    public static boolean compareFiles(String filePath1, String filePath2)
            throws IOException, NoSuchAlgorithmException {
        String hash1 = calculateFileHash(filePath1);
        String hash2 = calculateFileHash(filePath2);

        return hash1.equals(hash2);
    }
    private static String calculateFileHash(String filePath)
            throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        try (InputStream is = new FileInputStream(new File(filePath));
             DigestInputStream dis = new DigestInputStream(is, md)) {
            while (dis.read() != -1) ;
            byte[] digest = md.digest();

            StringBuilder result = new StringBuilder();
            for (byte b : digest) {
                result.append(String.format("%02x", b));
            }

            return result.toString();
        }
    }
}
