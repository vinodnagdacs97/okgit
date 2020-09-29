package com.example;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class GreetService implements Serializable {

    public String greet(String name) {
        if (name == null || name.isEmpty()) {
            return "Hello anonymous user";
        } else {
            return "Hello " + name;
        }
    }
    static String printString(String str, String ch) {

        int count = 0, i;
        String p=ch;

//        str.charAt(i) == ch
        for (i = 0; i < str.length(); i++) {
            char m= str.charAt(i);
            String q=Character.toString(m);
            boolean bool=p.equalsIgnoreCase(q);
            if (bool)
                count++;
            if (count == 1)
                break;
        }

        if (i < str.length() - 1)
            return str.substring(i + 1);
        else
            return "Not Found";
    }

}
