package com.advanced.serialization.customizedSerialization;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class securePassword {

    // AES-GCM-NoPadding is the industry standard for symmetric encryption
    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final int AES_KEY_SIZE = 256; // Can also use 128
    private static final int IV_LENGTH_BYTE = 12; // Standard IV size for GCM
    private static final int TAG_LENGTH_BIT = 128; // Standard authentication tag length

    /**
     * Encrypts a plain text string using AES-GCM.
     */
    public static String encrypt(String plainText, SecretKey key) throws Exception {
        // 1. Generate a random Initialization Vector (IV)
        byte[] iv = new byte[IV_LENGTH_BYTE];
        SecureRandom.getInstanceStrong().nextBytes(iv);

        // 2. Initialize the Cipher for Encryption
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(TAG_LENGTH_BIT, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);

        // 3. Encrypt the cleartext bytes
        byte[] cipherText = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

        // 4. Prefix the IV to the ciphertext so it can be retrieved during decryption
        byte[] encryptedBuffer = new byte[iv.length + cipherText.length];
        System.arraycopy(iv, 0, encryptedBuffer, 0, iv.length);
        System.arraycopy(cipherText, 0, encryptedBuffer, iv.length, cipherText.length);

        // 5. Encode to Base64 safe-string format
        return Base64.getEncoder().encodeToString(encryptedBuffer);
    }

    /**
     * Decrypts an AES-GCM encrypted Base64 string back to plain text.
     */
    public static String decrypt(String encryptedBase64, SecretKey key) throws Exception {
        // 1. Decode the Base64 string back into bytes
        byte[] encryptedBuffer = Base64.getDecoder().decode(encryptedBase64);

        // 2. Extract the IV from the beginning of the buffer
        byte[] iv = new byte[IV_LENGTH_BYTE];
        System.arraycopy(encryptedBuffer, 0, iv, 0, iv.length);

        // 3. Extract the actual ciphertext
        int cipherTextLength = encryptedBuffer.length - IV_LENGTH_BYTE;
        byte[] cipherText = new byte[cipherTextLength];
        System.arraycopy(encryptedBuffer, IV_LENGTH_BYTE, cipherText, 0, cipherTextLength);

        // 4. Initialize the Cipher for Decryption using the extracted IV
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(TAG_LENGTH_BIT, iv);
        cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);

        // 5. Decrypt the ciphertext bytes and convert back to a String
        byte[] decryptedBytes = cipher.doFinal(cipherText);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    /**
     * Helper method to generate a secure random AES SecretKey.
     */
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(AES_KEY_SIZE);
        return keyGenerator.generateKey();
    }

    // Quick demonstration
    public static void main(String[] args) {
        try {
            SecretKey secretKey = generateKey();
            String originalText = "Hello, World! Secure this Java string.";

            // Execute Encryption
            String encryptedText = encrypt(originalText, secretKey);
            System.out.println("Encrypted (Base64): " + encryptedText);

            // Execute Decryption
            String decryptedText = decrypt(encryptedText, secretKey);
            System.out.println("Decrypted Text:      " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
