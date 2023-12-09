/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import gestaoProcessos.Usuario;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
public class Util {
    
    public static final byte ENCPASSWD = 0;
    public static final byte SALT = 1;
    
    public static String[] hash(
            String plainText) {
        return Util.hash(plainText, null);
    }

    public static String[] hash(
            String plainText, String previousSalt) {
        try {
            byte[] salt;
            if (previousSalt == null) {
                SecureRandom random = SecureRandom
                        .getInstance("SHA1PRNG");
                salt = new byte[16];
                random.nextBytes(salt);

                salt = Base64.getEncoder()
                        .withoutPadding()
                        .encode(salt);

            } else {
                salt = previousSalt.getBytes();
            }

            KeySpec spec = new PBEKeySpec(
                    plainText.toCharArray(),
                    salt,
                    2147,
                    128);

            SecretKeyFactory factory = SecretKeyFactory
                    .getInstance("PBKDF2WithHmacSHA1");

            byte[] hash = factory.generateSecret(spec)
                    .getEncoded();

            String encryptedPassword = new String(
                    Base64.getEncoder().withoutPadding()
                            .encode(hash));

            System.out.println(
                    ">>\rEncrypted password: "
                    + new String(hash)
                    + "\rEncrypted password Base64: "
                    + encryptedPassword
                    + "\rSalt Base64: "
                    + new String(salt));

            return new String[]{
                encryptedPassword,
                new String(salt)
            };

        } catch (NoSuchAlgorithmException
                | InvalidKeySpecException ex) {
            Logger.getLogger(Util.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean isAuthentic(
            String password, Usuario user) {
        if (password != null
                && user != null
                && user.getSenha()!= null
                && user.getSalt() != null) {
            if (hash(password, user.getSalt())[ENCPASSWD]
                    .equals(user.getSenha())) {
                return true;
            }
        }

        return false;
    }

    private static String byteArrayToHex(byte[] array)
            throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength
                = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format(
                    "%0" + paddingLength + "d", 0)
                    + hex;
        } else {
            return hex;
        }
    }

    private static byte[] hexToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ( //
                    (Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

}
