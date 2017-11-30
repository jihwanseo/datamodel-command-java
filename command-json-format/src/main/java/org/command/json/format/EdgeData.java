package org.command.json.format;

import java.util.ArrayList;
import java.util.List;

public class EdgeData {
  private String version = null;
  private String dataTitle = null;
  private List<EdgeElement> edgeElements = null;

  public EdgeData(String version, String dataTitle, List<EdgeElement> edgeElementList) {
    this.setVersion(version);
    this.setDataTitle(dataTitle);
    this.setEdgeElementList(edgeElementList);
  }

  public EdgeData(String version, String dataTitle) {
    this.setVersion(version);
    this.setDataTitle(dataTitle);
    this.setEdgeElementList(new ArrayList<EdgeElement>());
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

  public void setEdgeElementList(List<EdgeElement> edgeElements) {
    this.edgeElements = edgeElements;
  }

  public List<EdgeElement> getEdgeElementList() {
    return edgeElements;
  }

  public void setDataTitle(String dataTitle) {
    this.dataTitle = dataTitle;
  }

  public String getDataTitle() {
    return dataTitle;
  }
}
