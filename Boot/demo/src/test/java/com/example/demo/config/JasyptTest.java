package com.example.demo.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JasyptTest {

    @Test
    void encryptTest() {
        String id = "root";
        String password = "dkssudgktpdy";

        System.out.println("jasyptEncoding(id) = " + jasyptEncoding(id));
        System.out.println("jasyptEncoding(password) = " + jasyptEncoding(password));
    }

    public String jasyptEncoding(String value) {
        String key = "around_hub_studio";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }
}
