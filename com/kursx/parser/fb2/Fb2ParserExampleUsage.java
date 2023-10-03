package com.kursx.parser.fb2;

import java.io.File;

/**
 * Usage example.
 */
public class Fb2ParserExampleUsage {

  public static void main(String[] args) {
    try {
      System.out.println("Started FB 2 read...");

      FictionBook fictionBook = new FictionBook(new File("path-fb2/file.xml"));

      System.out.println("Completed FB 2 read...");

      System.out.println(fictionBook.getTitle());
      System.out.println(fictionBook.getAuthors());

      String bookContent = fictionBook.getContentAsString();

      System.out.println("Result length: " + bookContent.length());
      System.out.println("-------------------------");
      System.out.println(bookContent);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
//todo remove