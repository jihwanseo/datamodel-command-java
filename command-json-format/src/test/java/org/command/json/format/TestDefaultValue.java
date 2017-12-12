package org.command.json.format;

public enum TestDefaultValue {
  //used in EdgeData
  VERSION(0, "edge-1.0", "default version for test"),
  DATA_TITLE(1, "opcua", "default data title for test"),

  //used in EdgeElement
  ELEMENT_TITLE(10, "read", "default element title for test"), 

  //used in EdgeAttribute
  STRING_NAME(20, "string_attribute", "string data type attribute's name"),
  DOUBLE_NAME(21, "double_attribute", "double data type attribute's name"),
  FLOAT_NAME(22, "float_attribute", "float data type attribute's name"),
  INTEGER_NAME(23, "integer_attribute", "integer data type attribute's name"),
  ATTRIBUTES_NAME(24, "attributes_attribute", "attributes data type attribute's name"),
  UNMATCHED_NAME(25, "unmatched_attribute", "unmatched data type attribute's name"); 
  public static final String STRING_VALUE = "value";
  public static final Double DOUBLE_VALUE = 0.5;
  public static final Integer INTEGER_VALUE = 1;
  public static final Float FLOAT_VALUE = 1.0f;
  
  private int code;
  private String value;
  private String description;

  /**
   * @fn TestDefaultValue(int code, String value, String description)
   * @brief constructor
   * @param [in] code @int
   * @param [in] value @String
   * @param [in] description @String
   */
  private TestDefaultValue(int code, String value, String description) {
    this.code = code;
    this.value = value;
    this.description = description;
  }

  /**
   * @fn int getCode()
   * @brief get enum code
   * @return code
   */
  public int getCode() {
    return code;
  }

  /**
   * @fn String getValue()
   * @brief get enum value
   * @return value
   */
  public String getValue() {
    return value;
  }

  /**
   * @fn String getDescription()
   * @brief get description
   * @return description
   */
  public String getDescription() {
    return description;
  }
}
