/*
 * (C) 2023 MyCompany
 * All rights reserved.
 */
package com.plitche.formatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormatterApplication {

  // ./gradlew spotlessCheck
  // ./gradlew spotlessApply

  public static void main(String[] args) {
    SpringApplication.run(FormatterApplication.class, args);

    System.out.println("Hello from MainApp!");
  }
}
