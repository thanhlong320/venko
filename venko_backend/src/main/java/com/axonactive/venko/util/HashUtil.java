package com.axonactive.venko.util;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    public static String hashTextMD5(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] mes = md.digest(text.getBytes());
            BigInteger bigInteger = new BigInteger(1, mes);
            String hashText = bigInteger.toString(16);
            return hashText;
        } catch (NoSuchAlgorithmException ex) {
            throw new WebApplicationException(Response.status(500).entity("System Error!").build());
        }
    }

    public static boolean compare(String hashText1, String hashText2){
        return hashText1.equals(hashText2);
    }

}
