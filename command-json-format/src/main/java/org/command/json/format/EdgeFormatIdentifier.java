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
   * @param code Format code number of EdgeFormatIdentifier
   * @param value Format value of EdgeFormatIdentifier
   * @param description Format description of EdgeFormatIdentifier
   */
  private EdgeFormatIdentifier(int code, String value, String description) {
    this.code = code;
    this.value = value;
    this.description = description;
  }

  /**
   * Get format code number of EdgeFormatIdentifier
   * 
   * @return Format code number of EdgeFormatIdentifier
   */
  public int getCode() {
    return code;
  }

  /**
   * Get format value of EdgeFormatIdentifier
   * 
   * @return Format value of EdgeFormatIdentifier
   */
  public String getValue() {
    return value;
  }

  /**
   * Get format description of EdgeFormatIdentifier
   * 
   * @return Format description of EdgeFormatIdentifier
   */
  public String getDescription() {
    return description;
  }
}
