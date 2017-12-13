/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordstorage;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
;
import java.util.*;

/**
 *
 * @author Marcius
 */


public class Actions {

    public static void print(String text) {
        System.out.println(text);
    }

    public static boolean login(String username, String password) throws FileNotFoundException {
        Scanner read = new Scanner(new File("users.txt"));
        while(read.hasNextLine())
        {
        String temp_u = decode(read.next());
        String temp_p = decode(read.next());
        if(username.equals(temp_u) && temp_p.equals(password))
            return true;
        }
        return false;
        //return true;
    }
    public static void Add(String URL, String password, String username) throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
     try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(username+"pass.txt", true), "utf-8"))) {
            writer.append(" " + encode(URL) + " " + encode(password));
            writer.close();
        }
    }
    public static boolean exists(String username) throws FileNotFoundException {
        Scanner read = new Scanner(new File("users.txt"));
        while(read.hasNextLine())
        {
        String temp_u = read.next();
        String ignore = read.next();
        if(username.equals(decode(temp_u)))
            return true;
        }
        return false;
    }

    public static void register(String username, String password) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("users.txt", true), "utf-8"))) {
            writer.append(" " + encode(username) + " " + encode(password));
            writer.close();
        }
    }
     
    public static String encode(String Hash)
    {
        char temp[] = Hash.toCharArray();
        for (int i = 0; i < Hash.length(); i++) {
            temp[i] += 1;
        }
        return String.valueOf(temp);
    }
       public static boolean SymbolEx(String username, String password)
       {
           if(username.isEmpty() || password.isEmpty())
               return false;
           if(username.length() < 4 || password.length() < 4)
               return false;
        char temp[] = username.toCharArray();
        for (int i = 0; i < username.length(); i++) {
           if(!((temp[i] > 64 && temp[i]<91) || (temp[i]>47 && temp[i] < 58)  || (temp[i]>96 && temp[i] < 123)))
                   return false;
        }
        char tem[] = password.toCharArray();
        for (int i = 0; i < password.length(); i++) {
           if(!((tem[i] > 64 && tem[i]<91) || (tem[i]>47 && tem[i] < 58)  || (tem[i]>96 && tem[i] < 123)))
                   return false;
        }
        return true;
       }
    public static String decode(String Hash) {
        char temp[] = Hash.toCharArray();
        for (int i = 0; i < Hash.length(); i++) {
            temp[i] -= 1;
        }
        return String.valueOf(temp);
    }
}
