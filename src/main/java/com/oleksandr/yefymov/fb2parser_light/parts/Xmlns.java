package com.oleksandr.yefymov.fb2parser_light.parts;

import org.w3c.dom.Node;

public class Xmlns {

  protected String name;
  protected String value;

  public Xmlns() {
  }

  public Xmlns(Node node) {
    this.name = node.getNodeName();
    this.value = node.getNodeValue();
  }

  public String getName() {
    return name;
  }

  public String getValue() {
    return value;
  }
}
