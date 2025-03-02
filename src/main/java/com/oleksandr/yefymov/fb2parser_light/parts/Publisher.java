package com.oleksandr.yefymov.fb2parser_light.parts;


import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class Publisher extends Person {

  protected String lang;

  public Publisher() {
  }

  public Publisher(Node node) {
    super(node);
    NamedNodeMap map = node.getAttributes();
    for (int index = 0; index < map.getLength(); index++) {
      Node attr = map.item(index);
      if (attr.getNodeName().equals("lang")) {
        id = attr.getNodeValue();
      }
    }
  }

  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }
}
