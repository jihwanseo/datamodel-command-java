/******************************************************************
 *
 * Copyright 2017 Samsung Electronics All Rights Reserved.
 *
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 ******************************************************************/
package org.command.json.format;

import java.util.List;

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
   * construct EdgeErrorIdentifier
   * 
   * @param code Error code number of EdgeErrorIdentifier
   * @param value Error message of EdgeErrorIdentifier
   * @param description Error description of EdgeErrorIdentifier
   */
  private EdgeErrorIdentifier(int code, String value, String description) {
    this.code = code;
    this.value = value;
    this.description = description;
  }

  /**
   * Get error code number of EdgeErrorIdentifier
   * 
   * @return Error code number of EdgeErrorIdentifier
   */
  public int getCode() {
    return code;
  }

  /**
   * Get error message of EdgeErrorIdentifier
   * 
   * @return Error message of EdgeErrorIdentifier
   */
  public String getValue() {
    return value;
  }

  /**
   * Get error description of EdgeErrorIdentifier
   * 
   * @return Error description of EdgeErrorIdentifier
   */
  public String getDescription() {
    return description;
  }
}
