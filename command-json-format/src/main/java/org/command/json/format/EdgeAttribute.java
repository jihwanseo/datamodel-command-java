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
   * @param name Name of EdgeAttribute
   * @param dataType DataType of EdgeAttribute
   * @param value Value of EdgeAttribute
   */
  public EdgeAttribute(String name, String dataType, Object value) {
    this.setName(name);
    this.setDataType(dataType);
    this.setValue(value);
  }

  /**
   * Get name of EdgeAttribute
   * 
   * @return Name of EdgeAttribute
   */
  public String getName() {
    return name;
  }

  /**
   * Set name of EdgeAttribute
   * 
   * @param name Name of EdgeAttribute
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get dataType of EdgeAttribute
   * 
   * @return DataType of EdgeAttribute
   */
  public String getDataType() {
    return dataType;
  }

  /**
   * Set dataType of EdgeAttribute
   * 
   * @param dataType DataType of EdgeAttribute
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  /**
   * Get value of EdgeAttribute
   * 
   * @return Value of  EdgeAttribute
   */
  public Object getValue() {
    return value;
  }

  /**
   * Set value of EdgeAttribute
   * 
   * @param value Value of EdgeAttribute
   */
  public void setValue(Object value) {
    this.value = value;
  }

}
