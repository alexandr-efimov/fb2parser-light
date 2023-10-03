# Fb2 parser

## Simple parser of book format fb2 in java objects

Using:

```java
      System.out.println("Started FB 2 read...");

  FictionBook fictionBook = new FictionBook(new File("/file.xml"));

  System.out.println("Completed FB 2 read...");

  System.out.println(fictionBook.getTitle());
  System.out.println(fictionBook.getAuthors());

  String bookContent = fictionBook.getContentAsString();

  System.out.println("Result length: " + bookContent.length());
  System.out.println("-------------------------");
  System.out.println(bookContent);
```
