package com.oleksandr.yefymov.fb2parser_light.parts;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class Person {

  protected String id;
  protected String firstName;
  protected String middleName;
  protected String lastName;
  protected String nickname;
  protected ArrayList<String> homePages;
  protected ArrayList<String> emails;

  public Person() {
  }

  Person(Node node) {
    NodeList nodeList = node.getChildNodes();
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node author = nodeList.item(i);
      switch (author.getNodeName()) {
        case "id":
          id = author.getTextContent();
          break;
        case "home-page":
          if (homePages == null) {
            homePages = new ArrayList<>();
          }
          homePages.add(author.getTextContent());
          break;
        case "email":
          if (emails == null) {
            emails = new ArrayList<>();
          }
          emails.add(author.getTextContent());
          break;
        case "nickname":
          nickname = author.getTextContent();
          break;
        case "first-name":
          firstName = author.getTextContent();
          break;
        case "middle-name":
          middleName = author.getTextContent();
          break;
        case "last-name":
          lastName = author.getTextContent();
          break;
      }
    }
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public void setEmails(ArrayList<String> emails) {
    this.emails = emails;
  }

  public void setHomePages(ArrayList<String> homePages) {
    this.homePages = homePages;
  }

  public String getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }


  public String getFullName() {
    return (firstName == null ? "" : firstName + " ")
           + (middleName == null ? "" : middleName + " ")
           + (lastName == null ? "" : lastName);
  }


  public ArrayList<String> getEmails() {
    return emails == null ? new ArrayList<String>() : emails;
  }


  public ArrayList<String> getHomePages() {
    return homePages == null ? new ArrayList<String>() : homePages;
  }
}
