package org.command.json.format;

public enum EdgeErrorIdentifier {
  EDGE_DS_ERROR_RESPONSE_NULL(0, "edge_ds_error_response_null",
      "Edge Device Service Response is null"), EDGE_DS_ERROR_RESPONSE_TIME_OUT(1,
          "edge_ds_error_time_out",
          "Edge Device Service Response is time out"), EDGE_DS_ERROR_INVALID_PARAM(2,
              "edge_ds_error_invalid_param",
              "Edge Device Service Reuqest is invalid parameter"), EDGE_RESPONSE_OK(30,
                  "edge_response_ok", "Edge Device Service Response is good");

  private int code;
  private String value;
  private String description;

  /**
   * @fn EdgeErrorIdentifier(int code, String value, String description)
   * @brief constructor
   * @param [in] code @int
   * @param [in] value @String
   * @param [in] description @String
   */
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
