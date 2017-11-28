package org.command.json.format;

import java.util.ArrayList;

public class EdgeElement {
  private ArrayList<EdgeAttribute> edgeAttributes = null;

  public EdgeElement() {
    edgeAttributes = new ArrayList<EdgeAttribute>();
  }

  public EdgeElement(EdgeAttribute edgeAttribute) {
    edgeAttributes = new ArrayList<EdgeAttribute>();
    edgeAttributes.add(edgeAttribute);
  }

  public EdgeElement(ArrayList<EdgeAttribute> edgeAttributes) {
    this.edgeAttributes = edgeAttributes;
  }

  public void setAttributeList(ArrayList<EdgeAttribute> edgeAttributes) {
    this.edgeAttributes = edgeAttributes;
  }

  public ArrayList<EdgeAttribute> getAttributeList() {
    return edgeAttributes;
  }
}
