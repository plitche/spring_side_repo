/*
 * (C) 2023 MyCompany
 * All rights reserved.
 */
package com.plitche.formatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.plitche.example.Library;
import com.plitche.utils.Utils;

@SpringBootApplication
public class FormatterApplication {

  // ./gradlew spotlessCheck
  // ./gradlew spotlessApply

  public static void main(String[] args) {
    SpringApplication.run(FormatterApplication.class, args);

    System.out.println("Hello from MainApp!");

    Library lib = new Library();
    lib.printMessage();

    System.out.println(Utils.getGreeting());
  }
}
