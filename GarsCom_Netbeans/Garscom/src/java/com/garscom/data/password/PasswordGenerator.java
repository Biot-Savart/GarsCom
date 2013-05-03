/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garscom.data.password;

import java.util.Random;

/**
 *
 * @author Ryno Myburgh
 */
public class PasswordGenerator
{

    private static final String charset = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getPassword(int length)
    {
        Random rand = new Random(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++)
        {
            int pos = rand.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        }
        
        return sb.toString();
    }

    public static String getPassword()
    {
        return getPassword(6);
    }
}
