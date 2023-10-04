package com.oleksandr.yefymov.fb2parser_light;

import java.io.File;

/**
 * Usage example.
 */
public class Fb2ParserExampleUsage {

  public static void main(String[] args) {
    try {
      System.out.println("Started FB 2 read...");

      FictionBookFb2 fictionBookFb2 = new FictionBookFb2(new File("/file.xml"));

      System.out.println("Completed FB 2 read...");

      System.out.println(fictionBookFb2.getTitle());
      System.out.println(fictionBookFb2.getAuthors());

      String bookContent = fictionBookFb2.getContentAsString();

      System.out.println("Result length: " + bookContent.length());
      System.out.println("-------------------------");
      System.out.println(bookContent);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}