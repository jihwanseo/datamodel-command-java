package org.command.json.format;

import java.util.ArrayList;
import java.util.List;

public class EdgeElement {
  private String elementTitle = null;
  private List<EdgeAttribute> edgeAttributes = null;

  public EdgeElement(String elementTitle) {
    this.setElementTitle(elementTitle);
    this.setEdgeAttributeList(new ArrayList<EdgeAttribute>());
  }

  public EdgeElement(String elementTitle, List<EdgeAttribute> edgeAttributes) {
    this.setElementTitle(elementTitle);
    this.setEdgeAttributeList(edgeAttributes);
  }

  public void setEdgeAttributeList(List<EdgeAttribute> edgeAttributes) {
    this.edgeAttributes = edgeAttributes;
  }

  public List<EdgeAttribute> getEdgeAttributeList() {
    return edgeAttributes;
  }

  public String getElementTitle() {
    return elementTitle;
  }

  public void setElementTitle(String elementTitle) {
    this.elementTitle = elementTitle;
  }
}
