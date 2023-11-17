package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.DigestInputStream;

public class FileComparator {
    public static boolean compareFiles(String outputFile, String resourcesFile)
            throws IOException, NoSuchAlgorithmException {
        if (isXmlFile(outputFile)) {
            String content1 = readFileContent(outputFile);
            String content2 = readFileContent(resourcesFile);
            return content1.equals(content2);
        } else {
            String hash1 = calculateFileHash(outputFile);
            String hash2 = calculateFileHash(resourcesFile);
            return hash1.equals(hash2);
        }
    }
    private static boolean isXmlFile(String filePath) {
        return filePath.toLowerCase().endsWith(".xml");
    }

    private static String readFileContent(String filePath) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        String content = new String(encoded);

        content = content.replaceAll("[\\t\\n\\x0B\\f\\r\\s]", "");

        return content;
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
