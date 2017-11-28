package org.command.json.format;

import java.util.ArrayList;

public class EdgeData {
  private String version = null;
  private String protocolCategory = null;
  private ArrayList<EdgeElement> edgeElements = null;

  public EdgeData(String version, String protocolCategory, ArrayList<EdgeElement> edgeElements) {
    this.version = version;
    this.protocolCategory = protocolCategory;
    this.edgeElements = edgeElements;
  }

  public EdgeData(String version, String protocolCategory) {
    this.version = version;
    this.protocolCategory = protocolCategory;
    this.edgeElements = new ArrayList<EdgeElement>();
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

  public void setEdgeElementList(ArrayList<EdgeElement> edgeElements) {
    this.edgeElements = edgeElements;
  }

  public ArrayList<EdgeElement> getEdgeElementList() {
    return edgeElements;
  }

  public void setProtocolCategory(String protocolCategory) {
    this.protocolCategory = protocolCategory;
  }

  public String getProtocolCategory() {
    return protocolCategory;
  }
}
