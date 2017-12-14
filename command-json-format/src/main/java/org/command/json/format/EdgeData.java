package org.command.json.format;

import java.util.ArrayList;
import java.util.List;

public class EdgeData {
  private String version = null;
  private String dataTitle = null;
  private List<EdgeElement> edgeElements = null;

  /**
   * construct EdgeData <br>
   * Use {@link #setVersion(String)} to set a version <br>
   * Use {@link #setDataTitle(String)} to set a dataTitle <br>
   * Use {@link #setEdgeElementList(List)} to set a edgeElementList
   * 
   * @param version EdgeData's version
   * @param dataTitle EdgeData's dataTitle
   * @param edgeElementList EdgeData's list of EdgeElement
   */
  public EdgeData(String version, String dataTitle, List<EdgeElement> edgeElementList) {
    this.setVersion(version);
    this.setDataTitle(dataTitle);
    this.setEdgeElementList(edgeElementList);
  }

  /**
   * construct EdgeData without dataTitle <br>
   * Use {@link #setVersion(String)} to set a version <br>
   * Use {@link #setDataTitle(String)} to set a dataTitle <br>
   * Use {@link #setEdgeElementList(List)} to set a edgeElementList
   * 
   * @param version EdgeData's version
   * @param dataTitle EdgeData's dataTitle
   */
  public EdgeData(String version, String dataTitle) {
    this.setVersion(version);
    this.setDataTitle(dataTitle);
    this.setEdgeElementList(new ArrayList<EdgeElement>());
  }

  /**
   * Set EdgeData's version
   * 
   * @param version EdgeData's version
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * Get EdgeData's version
   * 
   * @return EdgeData's version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Set EdgeData's list of EdgeElement
   * 
   * @param edgeElements EdgeData's list of EdgeElement
   */
  public void setEdgeElementList(List<EdgeElement> edgeElements) {
    this.edgeElements = edgeElements;
  }

  /**
   * Get EdgeData's list of EdgeElement
   * 
   * @return EdgeData's list of EdgeElement
   */
  public List<EdgeElement> getEdgeElementList() {
    return edgeElements;
  }

  /**
   * Set EdgeData's dataTitle
   * 
   * @param dataTitle EdgeData's dataTitle
   */
  public void setDataTitle(String dataTitle) {
    this.dataTitle = dataTitle;
  }

  /**
   * Get EdgeData's dataTitle
   * 
   * @return EdgeData's dataTitle
   */
  public String getDataTitle() {
    return dataTitle;
  }
}
