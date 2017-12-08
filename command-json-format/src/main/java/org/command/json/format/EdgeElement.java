package org.command.json.format;

import java.util.ArrayList;
import java.util.List;

public class EdgeElement {
  private String elementTitle = null;
  private List<EdgeAttribute> edgeAttributes = null;

  /**
   * @fn EdgeElement(String elementTitle)
   * @brief constructor
   * @param [in] elementTitle @String
   */
  public EdgeElement(String elementTitle) {
    this.setElementTitle(elementTitle);
    this.setEdgeAttributeList(new ArrayList<EdgeAttribute>());
  }

  /**
   * @fn EdgeElement(String elementTitle, List<EdgeAttribute> edgeAttributes)
   * @brief constructor
   * @param [in] elementTitle @String
   * @param [in] edgeAttributes @List<EdgeAttribute>
   */
  public EdgeElement(String elementTitle, List<EdgeAttribute> edgeAttributes) {
    this.setElementTitle(elementTitle);
    this.setEdgeAttributeList(edgeAttributes);
  }

  /**
   * @fn void setEdgeAttributeList(List<EdgeAttribute> edgeAttributes)
   * @brief Set edgeAttributes
   * @param [in] edgeAttributes @List<EdgeAttribute>
   */
  public void setEdgeAttributeList(List<EdgeAttribute> edgeAttributes) {
    this.edgeAttributes = edgeAttributes;
  }

  /**
   * @fn List<EdgeAttribute> getEdgeAttributeList()
   * @brief Get edgeAttributes
   * @return @List<EdgeAttribute>
   */
  public List<EdgeAttribute> getEdgeAttributeList() {
    return edgeAttributes;
  }

  /**
   * @fn String getElementTitle()
   * @brief Get elementTitle
   * @return @String
   */
  public String getElementTitle() {
    return elementTitle;
  }

  /**
   * @fn void setElementTitle(String elementTitle)
   * @brief Set elementTitle
   * @param [in] elementTitle @String
   */
  public void setElementTitle(String elementTitle) {
    this.elementTitle = elementTitle;
  }
}
