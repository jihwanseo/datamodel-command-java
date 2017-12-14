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
   * @param elementTitle ElementTitle of EdgeElement
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
   * @param elementTitle ElementTitle of EdgeElement
   * @param edgeAttributes List of edgeAttributeList in EdgeElement
   */
  public EdgeElement(String elementTitle, List<EdgeAttribute> edgeAttributes) {
    this.setElementTitle(elementTitle);
    this.setEdgeAttributeList(edgeAttributes);
  }

  /**
   * Set List of edgeAttributeList in EdgeElement
   * 
   * @param edgeAttributes List of edgeAttributeList in EdgeElement
   */
  public void setEdgeAttributeList(List<EdgeAttribute> edgeAttributes) {
    this.edgeAttributes = edgeAttributes;
  }

  /**
   * Get List of edgeAttributeList in EdgeElement
   * 
   * @return List of edgeAttributeList in EdgeElement
   */
  public List<EdgeAttribute> getEdgeAttributeList() {
    return edgeAttributes;
  }

  /**
   * Get ElementTitle of EdgeElement
   * 
   * @return ElementTitle of EdgeElement
   */
  public String getElementTitle() {
    return elementTitle;
  }

  /**
   * Set ElementTitle of EdgeElement
   * 
   * @param ElementTitle of EdgeElement
   */
  public void setElementTitle(String elementTitle) {
    this.elementTitle = elementTitle;
  }
}
