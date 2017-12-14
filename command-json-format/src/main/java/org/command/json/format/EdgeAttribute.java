package org.command.json.format;

public class EdgeAttribute {
  private String name = null;
  private String dataType = null;
  private Object value = null;

  /**
   * construct EdgeAttribute <br>
   * Use {@link #setName(String)} to set a name <br>
   * Use {@link #setDataType(String)} to set a dataType <br>
   * Use {@link #setValue(Object)} to set a value
   * 
   * @param name name of EdgeAttribute' data
   * @param dataType dataType of EdgeAttribute' data
   * @param value value of EdgeAttribute' data
   */
  public EdgeAttribute(String name, String dataType, Object value) {
    this.setName(name);
    this.setDataType(dataType);
    this.setValue(value);
  }

  /**
   * Get EdgeAttribute's name
   * 
   * @return EdgeAttribute's name
   */
  public String getName() {
    return name;
  }

  /**
   * Set EdgeAttribute's name
   * 
   * @param name name of EdgeAttribute' data
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get EdgeAttribute's dataType
   * 
   * @return EdgeAttribute's dataType
   */
  public String getDataType() {
    return dataType;
  }

  /**
   * Set EdgeAttribute's dataType
   * 
   * @param dataType dataType of EdgeAttribute' data
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  /**
   * Get EdgeAttribute's value
   * 
   * @return EdgeAttribute's value
   */
  public Object getValue() {
    return value;
  }

  /**
   * Set EdgeAttribute's value
   * 
   * @param value value of EdgeAttribute' data
   */
  public void setValue(Object value) {
    this.value = value;
  }

}
