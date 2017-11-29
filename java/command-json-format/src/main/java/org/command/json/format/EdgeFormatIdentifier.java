package org.command.json.format;

public enum EdgeFormatIdentifier {
  DEFAULT_VERSION(0, "edge-1.0", "edge-json-format version"),

  //Data Title
  OPCUA_TYPE(10, "opcua", "opcua protocol type"), 
  CNC_TYPE(11, "cnc", "CNC protocol type"), 
  PLC_TYPE(12, "plc", "PLC protocol type"),

  //Data Type
  STRING_TYPE(12, "string", "string data type"),
  INTEGER_TYPE(12, "integer", "integer data type"),
  FLOAT_TYPE(12, "float", "float data type"),
  ATTRIBUTES_TYPE(12, "attributes", "attribute list data type");
  
  
  private int code;
  private String value;
  private String description;

  private EdgeFormatIdentifier(int code, String value, String description) {
    this.code = code;
    this.value = value;
    this.description = description;
  }

  public int getCode() {
    return code;
  }

  public String getValue() {
    return value;
  }

  public String getDescription() {
    return description;
  }
}
