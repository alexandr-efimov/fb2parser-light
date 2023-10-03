package com.kursx.parser.fb2.parts;

import com.kursx.parser.fb2.fonts.Emphasis;
import com.kursx.parser.fb2.fonts.StrikeThrough;
import com.kursx.parser.fb2.fonts.Strong;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class P extends Element {

  protected ArrayList<Emphasis> emphasis;
  protected ArrayList<Strong> strong;
  protected ArrayList<StrikeThrough> strikeThrough;

  public P() {
    super();
  }

  public P(Node p) {
    super(p);
    NodeList nodeList = p.getChildNodes();
    for (int index = 0; index < nodeList.getLength(); index++) {
      Node node = nodeList.item(index);
      switch (nodeList.item(index).getNodeName()) {
        case "image":
          break;
        case "strikethrough":
          if (strikeThrough == null) {
            strikeThrough = new ArrayList<>();
          }
          strikeThrough.add(new StrikeThrough(node.getTextContent(), p.getTextContent()));
          break;
        case "strong":
          if (strong == null) {
            strong = new ArrayList<>();
          }
          strong.add(new Strong(node.getTextContent(), p.getTextContent()));
          break;
        case "emphasis":
          if (emphasis == null) {
            emphasis = new ArrayList<>();
          }
          emphasis.add(new Emphasis(node.getTextContent(), p.getTextContent()));
          break;
        case "subtitle":
          if (emphasis == null) {
            emphasis = new ArrayList<>();
          }
          emphasis.add(new Emphasis(node.getTextContent(), p.getTextContent()));
          break;
      }
    }
  }

  public P(String p) {
    super(p);
  }
}
