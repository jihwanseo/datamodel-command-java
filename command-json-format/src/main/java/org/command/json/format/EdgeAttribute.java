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

public class EdgeAttribute {
  private String name = null;
  private String dataType = null;
  private Object value = null;

  /**
   * construct EdgeAttribute <br>
   * Use {@link #setName(String)} to set a name <br>
   * Use {@link #setDataType(String)} to set a dataType <br>
   * Use {@link #setValue(Object)} to set a value
   * 
   * @param name Name of EdgeAttribute
   * @param dataType DataType of EdgeAttribute
   * @param value Value of EdgeAttribute
   */
  public EdgeAttribute(String name, String dataType, Object value) {
    this.setName(name);
    this.setDataType(dataType);
    this.setValue(value);
  }

  /**
   * Get name of EdgeAttribute
   * 
   * @return Name of EdgeAttribute
   */
  public String getName() {
    return name;
  }

  /**
   * Set name of EdgeAttribute
   * 
   * @param name Name of EdgeAttribute
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get dataType of EdgeAttribute
   * 
   * @return DataType of EdgeAttribute
   */
  public String getDataType() {
    return dataType;
  }

  /**
   * Set dataType of EdgeAttribute
   * 
   * @param dataType DataType of EdgeAttribute
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  /**
   * Get value of EdgeAttribute
   * 
   * @return Value of  EdgeAttribute
   */
  public Object getValue() {
    return value;
  }

  /**
   * Set value of EdgeAttribute
   * 
   * @param value Value of EdgeAttribute
   */
  public void setValue(Object value) {
    this.value = value;
  }

}
