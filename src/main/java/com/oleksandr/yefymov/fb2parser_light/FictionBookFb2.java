package com.oleksandr.yefymov.fb2parser_light;

import com.oleksandr.yefymov.fb2parser_light.parts.Annotation;
import com.oleksandr.yefymov.fb2parser_light.parts.Body;
import com.oleksandr.yefymov.fb2parser_light.parts.Description;
import com.oleksandr.yefymov.fb2parser_light.parts.Element;
import com.oleksandr.yefymov.fb2parser_light.parts.Person;
import com.oleksandr.yefymov.fb2parser_light.parts.Section;
import com.oleksandr.yefymov.fb2parser_light.parts.Xmlns;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Entry point to lib usage for parsing FB2 files.
 */
public class FictionBookFb2 {

  protected Xmlns[] xmlns;
  protected Description description;
  protected List<Body> bodies = new ArrayList<>();

  private FictionBookFb2() {
  }

  /**
   * Entry point to create Fb2 object for further work with.
   */
  public FictionBookFb2(File file) throws ParserConfigurationException, IOException, SAXException, OutOfMemoryError {
    DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

    Document document = documentBuilder.parse(file);

    initXmlns(document);

    description = new Description(document);

    NodeList bodyNodes = document.getElementsByTagName("body");

    for (int item = 0; item < bodyNodes.getLength(); item++) {
      bodies.add(new Body(bodyNodes.item(item)));
    }
  }

  protected void setXmlns(ArrayList<Node> nodeList) {
    xmlns = new Xmlns[nodeList.size()];
    for (int index = 0; index < nodeList.size(); index++) {
      Node node = nodeList.get(index);
      xmlns[index] = new Xmlns(node);
    }
  }

  protected void initXmlns(Document doc) {
    NodeList fictionBook = doc.getElementsByTagName("FictionBook");
    ArrayList<Node> xmlns = new ArrayList<>();
    for (int item = 0; item < fictionBook.getLength(); item++) {
      NamedNodeMap map = fictionBook.item(item).getAttributes();
      for (int index = 0; index < map.getLength(); index++) {
        Node node = map.item(index);
        xmlns.add(node);
      }
    }
    setXmlns(xmlns);
  }

  public ArrayList<Person> getAuthors() {
    return description.getDocumentInfo().getAuthors();
  }

  public Xmlns[] getXmlns() {
    return xmlns;
  }

  public Description getDescription() {
    return description;
  }

  public Body getBody() {
    return getBody(null);
  }

  public Body getNotes() {
    return getBody("notes");
  }

  public Body getComments() {
    return getBody("comments");
  }

  private Body getBody(String name) {
    for (Body body : bodies) {
      if (Objects.equals(name, body.getName())) {
        return body;
      }
    }

    return bodies.get(0);
  }

  public String getTitle() {
    return description.getTitleInfo().getBookTitle();
  }

  public String getLang() {
    return description.getTitleInfo().getLang();
  }

  public Annotation getAnnotation() {
    return description.getTitleInfo().getAnnotation();
  }

  /**
   * Get Content of the book joined with new lines.
   * <p>
   * Important: read all the content.
   *
   * @return content as string
   */

  public String getContentAsString() {
    StringBuilder stringBuilder = new StringBuilder();

    Body body = getBody();

    for (int i = 0; i < body.getSections().size(); i++) {
      Section section = body.getSections().get(i);

      ofNullable(section.getTitleString("\n", "\n"))
        .ifPresent(title -> stringBuilder.append("\n").append(title).append("\n"));

      List<Element> sectionElements = section.getElements();
      sectionElements.forEach(sectionElement -> stringBuilder.append(sectionElement.getText()).append("\n"));
    }


    return stringBuilder.toString();
  }
}

