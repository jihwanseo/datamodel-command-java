package org.command.json.format;

public enum EdgeFormatIdentifier {
  DEFAULT_VERSION(0, "edge-1.0", "edge-json-format version"),

  //Data Title
  OPCUA_TYPE(10, "opcua", "opcua protocol type"), 
  CNC_TYPE(11, "cnc", "CNC protocol type"), 
  PLC_TYPE(12, "plc", "PLC protocol type"),

  //Data Type
  ATTRIBUTES_TYPE(20, "attributes", "attribute list data type"),
  STRING_TYPE(21, "string", "string data type"),
  INTEGER_TYPE(22, "integer", "integer data type"),
  FLOAT_TYPE(23, "float", "float data type"),
  DOUBLE_TYPE(24, "double", "double data type");
  
  private int code;
  private String value;
  private String description;

  /**
   * @fn EdgeFormatIdentifier(int code, String value, String description)
   * @brief constructor
   * @param [in] code @int
   * @param [in] value @String
   * @param [in] description @String
   */
  private EdgeFormatIdentifier(int code, String value, String description) {
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
