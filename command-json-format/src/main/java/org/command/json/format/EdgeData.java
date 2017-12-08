package org.command.json.format;

import java.util.ArrayList;
import java.util.List;

public class EdgeData {
  private String version = null;
  private String dataTitle = null;
  private List<EdgeElement> edgeElements = null;

  /**
   * @fn EdgeAttribute(String name, String dataType, Object value)
   * @brief constructor
   * @param [in] version @String
   * @param [in] dataTitle @String
   * @param [in] edgeElementList @List<EdgeElement>
   */
  public EdgeData(String version, String dataTitle, List<EdgeElement> edgeElementList) {
    this.setVersion(version);
    this.setDataTitle(dataTitle);
    this.setEdgeElementList(edgeElementList);
  }

  /**
   * @fn EdgeData(String version, String dataTitle)
   * @brief constructor
   * @param [in] version @String
   * @param [in] dataTitle @String
   */
  public EdgeData(String version, String dataTitle) {
    this.setVersion(version);
    this.setDataTitle(dataTitle);
    this.setEdgeElementList(new ArrayList<EdgeElement>());
  }

  /**
   * @fn void setVersion(String version)
   * @brief Set version
   * @param [in] version @String
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * @fn String getVersion()
   * @brief Get version
   * @return @String
   */
  public String getVersion() {
    return version;
  }

  /**
   * @fn void setEdgeElementList(List<EdgeElement> edgeElements)
   * @brief Set edgeElements
   * @param [in] edgeElements @List<EdgeElement>
   */
  public void setEdgeElementList(List<EdgeElement> edgeElements) {
    this.edgeElements = edgeElements;
  }

  /**
   * @fn List<EdgeElement> getEdgeElementList()
   * @brief Get edgeElementList
   * @return @List<EdgeElement>
   */
  public List<EdgeElement> getEdgeElementList() {
    return edgeElements;
  }

  /**
   * @fn void setDataTitle(String dataTitle)
   * @brief Set dataTitle
   * @param [in] dataTitle @String
   */
  public void setDataTitle(String dataTitle) {
    this.dataTitle = dataTitle;
  }

  /**
   * @fn String getDataTitle()
   * @brief Get dataTitle
   * @return @String
   */
  public String getDataTitle() {
    return dataTitle;
  }
}
