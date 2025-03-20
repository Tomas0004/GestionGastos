package com.model;

import java.security.Key;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

import io.github.cdimascio.dotenv.Dotenv;
import javax.crypto.Cipher;

public class Encryption {
    private static Dotenv dotenv = Dotenv.load();

    public static String encript(String text){
        try {
            Key key = new SecretKeySpec(dotenv.get("ENCRYPT_KEY").getBytes(), dotenv.get("ALGORITM"));
            Cipher cipher = Cipher.getInstance(dotenv.get("ALGORITM"));
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] bytes = cipher.doFinal(text.getBytes());

            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String encrypt){
        try {
            Key key = new SecretKeySpec(dotenv.get("ENCRYPT_KEY").getBytes(), dotenv.get("ALGORITM"));

            Cipher cipher = Cipher.getInstance(dotenv.get("ALGORITM"));
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(encrypt.replace("\n", "")));

            return new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
