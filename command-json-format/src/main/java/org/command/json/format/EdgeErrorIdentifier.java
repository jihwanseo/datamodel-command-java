package org.command.json.format;

public enum EdgeErrorIdentifier {
  EDGE_DS_ERROR_RESPONSE_NULL(0, "edge_ds_error_response_null", 
      "Edge DeviceService Response is null"),
  EDGE_DS_ERROR_RESPONSE_TIME_OUT(1, "edge_ds_error_time_out", 
      "Edge DeviceService Response is time out");

  private int code;
  private String value;
  private String description;

  private EdgeErrorIdentifier(int code, String value, String description) {
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
