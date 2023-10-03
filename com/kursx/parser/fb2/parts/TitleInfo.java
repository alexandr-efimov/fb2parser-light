package com.kursx.parser.fb2.parts;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class TitleInfo {

  protected ArrayList<String> keywords = new ArrayList<>();
  protected String bookTitle;
  protected String date;
  protected String lang;
  protected String srcLang;
  protected ArrayList<Person> authors = new ArrayList<>();
  protected ArrayList<Person> translators = new ArrayList<>();
  protected Annotation annotation;
  protected Sequence sequence;

  public TitleInfo() {
  }

  TitleInfo(Document document) {
    NodeList description = document.getElementsByTagName("title-info");
    for (int item = 0; item < description.getLength(); item++) {
      NodeList map = description.item(item).getChildNodes();
      for (int index = 0; index < map.getLength(); index++) {
        Node node = map.item(index);
        switch (node.getNodeName()) {
          case "sequence":
            sequence = new Sequence(node);
            break;
          case "coverpage":
            break;
          case "elements":
            this.annotation = new Annotation(node);
            break;
          case "date":
            date = node.getTextContent();
            break;
          case "author":
            authors.add(new Person(node));
            break;
          case "translator":
            translators.add(new Person(node));
            break;
          case "keywords":
            keywords.add(node.getTextContent());
            break;
          case "genre":
            break;
          case "book-title":
            bookTitle = node.getTextContent();
            break;
          case "lang":
            lang = node.getTextContent();
            break;
          case "src-lang":
            srcLang = node.getTextContent();
            break;
        }
      }
    }
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public String getDate() {
    return date;
  }

  public String getLang() {
    return lang;
  }

  public String getSrcLang() {
    return srcLang;
  }

  public ArrayList<Person> getAuthors() {
    return authors;
  }

  public ArrayList<Person> getTranslators() {
    return translators;
  }

  public Annotation getAnnotation() {
    return annotation;
  }

  public Sequence getSequence() {
    return sequence;
  }

  public ArrayList<String> getKeywords() {
    return keywords;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }
}
