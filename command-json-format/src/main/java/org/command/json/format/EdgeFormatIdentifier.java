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
   * construct EdgeFormatIdentifier
   * 
   * @param code EdgeFormatIdentifier's format code number
   * @param value EdgeFormatIdentifier's format value
   * @param description EdgeFormatIdentifier's format description
   */
  private EdgeFormatIdentifier(int code, String value, String description) {
    this.code = code;
    this.value = value;
    this.description = description;
  }

  /**
   * Get EdgeFormatIdentifier's format code number
   * 
   * @return EdgeFormatIdentifier's format code number
   */
  public int getCode() {
    return code;
  }

  /**
   * Get EdgeFormatIdentifier's format value
   * 
   * @return EdgeFormatIdentifier's format value
   */
  public String getValue() {
    return value;
  }

  /**
   * Get EdgeFormatIdentifier's format description
   * 
   * @return EdgeFormatIdentifier's format description
   */
  public String getDescription() {
    return description;
  }
}
