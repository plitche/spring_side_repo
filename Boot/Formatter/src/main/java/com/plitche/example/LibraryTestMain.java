package com.plitche.example;

import com.plitche.utils.Utils;

public class LibraryTestMain {
    public static void main(String[] args)
    {
        Library lib = new Library();
        lib.printMessage();

        System.out.println(Utils.getGreeting());
    }
}
