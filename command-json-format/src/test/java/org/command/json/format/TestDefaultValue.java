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
   * construct TestDefaultValue
   * 
   * @param code code number of TestDefaultValue
   * @param value value of TestDefaultValue
   * @param description description of TestDefaultValue
   */
  private TestDefaultValue(int code, String value, String description) {
    this.code = code;
    this.value = value;
    this.description = description;
  }

  /**
   * Get code number of TestDefaultValue
   * 
   * @return code number of TestDefaultValue
   */
  public int getCode() {
    return code;
  }

  /**
   * Get value of TestDefaultValue
   * 
   * @return value of TestDefaultValue
   */
  public String getValue() {
    return value;
  }

  /**
   * Get description of TestDefaultValue
   * 
   * @return description of TestDefaultValue
   */
  public String getDescription() {
    return description;
  }
}
