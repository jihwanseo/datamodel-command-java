package org.command.json.format;

import java.util.ArrayList;
import java.util.List;

public class EdgeElement {
  private String elementTitle = null;
  private List<EdgeAttribute> edgeAttributes = null;

  /**
   * construct EdgeElement without edgeAttributeList <br>
   * Use {@link #setElementTitle(String)} to set a elementTitle <br>
   * Use {@link #setEdgeAttributeList(List)} to set a edgeAttributeList
   * 
   * @param elementTitle EdgeElement's elementTitle
   */
  public EdgeElement(String elementTitle) {
    this.setElementTitle(elementTitle);
    this.setEdgeAttributeList(new ArrayList<EdgeAttribute>());
  }

  /**
   * construct EdgeElement <br>
   * Use {@link #setElementTitle(String)} to set a elementTitle <br>
   * Use {@link #setEdgeAttributeList(List)} to set a edgeAttributeList
   * 
   * @param elementTitle EdgeElement's elementTitle
   * @param edgeAttributes EdgeElement's list of edgeAttributeList
   */
  public EdgeElement(String elementTitle, List<EdgeAttribute> edgeAttributes) {
    this.setElementTitle(elementTitle);
    this.setEdgeAttributeList(edgeAttributes);
  }

  /**
   * Set EdgeElement's list of edgeAttributeList
   * 
   * @param edgeAttributes EdgeElement's list of edgeAttributeList
   */
  public void setEdgeAttributeList(List<EdgeAttribute> edgeAttributes) {
    this.edgeAttributes = edgeAttributes;
  }

  /**
   * Get EdgeData's dataTitle
   * 
   * @return EdgeElement's list of edgeAttributeList
   */
  public List<EdgeAttribute> getEdgeAttributeList() {
    return edgeAttributes;
  }

  /**
   * Get EdgeData's dataTitle
   * 
   * @return EdgeElement's ElementTitle
   */
  public String getElementTitle() {
    return elementTitle;
  }

  /**
   * Set EdgeElement's ElementTitle
   * 
   * @param elementTitle EdgeElement's ElementTitle
   */
  public void setElementTitle(String elementTitle) {
    this.elementTitle = elementTitle;
  }
}
