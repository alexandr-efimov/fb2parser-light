# Fb2 parser

## Simple parser of book format fb2 in java objects

Using:

```java
try{
  FictionBook fb2=new FictionBook(new File("book.fb2"));
  }catch(ParserConfigurationException|IOException|SAXException e){
  e.printStackTrace();
  }
```
