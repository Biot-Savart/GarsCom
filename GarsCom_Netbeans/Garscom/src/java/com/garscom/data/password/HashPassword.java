/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garscom.data.password;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Ryno
 */
public class HashPassword
{

     public static String hashPassword(String password)
    {
        String hashedPassword = null;
        try
        {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes());
            BigInteger hash = new BigInteger(1, md5.digest());
            hashedPassword = hash.toString(16);

        } catch (NoSuchAlgorithmException nsae)
        {
        }
        return hashedPassword;
    }

}
