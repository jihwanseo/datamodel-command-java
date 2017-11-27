package org.edge.json.format;

public enum FormatDefaultValue {
  VERSION(0, "edge-1.0", "edge-json-format version"),
  
  OPCUA_TYPE(10, "opcua", "edge-json-format opcua protocol type");
 
  private int code;
  private String value;
  private String description;

  private FormatDefaultValue(int code, String value, String description) {
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
