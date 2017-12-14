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
   * @param version Version of EdgeData
   * @param dataTitle Data Title of EdgeData
   * @param edgeElementList List of EdgeElement in EdgeElement
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
   * @param version Version of EdgeData
   * @param dataTitle DataTitle of EdgeData
   */
  public EdgeData(String version, String dataTitle) {
    this.setVersion(version);
    this.setDataTitle(dataTitle);
    this.setEdgeElementList(new ArrayList<EdgeElement>());
  }

  /**
   * Set version of EdgeData
   * 
   * @param version Version of EdgeData
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * Get version of EdgeData
   * 
   * @return Version of EdgeData
   */
  public String getVersion() {
    return version;
  }

  /**
   * Set list of EdgeElement in EdgeElement
   * 
   * @param edgeElements List of EdgeElement in EdgeElement
   */
  public void setEdgeElementList(List<EdgeElement> edgeElements) {
    this.edgeElements = edgeElements;
  }

  /**
   * Get list of EdgeElement in EdgeElement
   * 
   * @return List of EdgeElement in EdgeElement
   */
  public List<EdgeElement> getEdgeElementList() {
    return edgeElements;
  }

  /**
   * Set dataTitle of EdgeData
   * 
   * @param dataTitle Data Title of EdgeData
   */
  public void setDataTitle(String dataTitle) {
    this.dataTitle = dataTitle;
  }

  /**
   * Get dataTitle of EdgeData
   * 
   * @return DataTitle of EdgeData
   */
  public String getDataTitle() {
    return dataTitle;
  }
}
