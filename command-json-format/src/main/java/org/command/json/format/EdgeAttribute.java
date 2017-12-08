package org.command.json.format;

public class EdgeAttribute {
  private String name = null;
  private String dataType = null;
  private Object value = null;

  /**
   * @fn EdgeAttribute(String name, String dataType, Object value)
   * @brief constructor
   * @param [in] name @String
   * @param [in] dataType @String
   * @param [in] value @String
   */
  public EdgeAttribute(String name, String dataType, Object value) {
    this.setName(name);
    this.setDataType(dataType);
    this.setValue(value);
  }

  /**
   * @fn String getName()
   * @brief Get name
   * @return @String
   */
  public String getName() {
    return name;
  }

  /**
   * @fn void setName(String name)
   * @brief Set name
   * @param [in] name @String
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @fn String getDataType()
   * @brief Get dataType
   * @return @String
   */
  public String getDataType() {
    return dataType;
  }

  /**
   * @fn void setDataType(String dataType)
   * @brief Set dataType
   * @param [in] name @String
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  /**
   * @fn String getValue()
   * @brief Get value
   * @return @Object
   */
  public Object getValue() {
    return value;
  }

  /**
   * @fn void setValue(Object value)
   * @brief Set value
   * @param [in] value @Object
   */
  public void setValue(Object value) {
    this.value = value;
  }

}
