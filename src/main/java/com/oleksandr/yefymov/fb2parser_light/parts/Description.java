package com.oleksandr.yefymov.fb2parser_light.parts;

import org.w3c.dom.Document;

public class Description {

  protected TitleInfo titleInfo;
  protected SrcTitleInfo srcTitleInfo;
  protected DocumentInfo documentInfo;
  protected PublishInfo publishInfo;

  public Description() {
  }

  public Description(Document doc) {
    titleInfo = new TitleInfo(doc);
    srcTitleInfo = new SrcTitleInfo(doc);
    documentInfo = new DocumentInfo(doc);
    publishInfo = new PublishInfo(doc);
  }

  public DocumentInfo getDocumentInfo() {
    return documentInfo;
  }

  public TitleInfo getTitleInfo() {
    return titleInfo;
  }

  public PublishInfo getPublishInfo() {
    return publishInfo;
  }

  public SrcTitleInfo getSrcTitleInfo() {
    return srcTitleInfo;
  }
}
