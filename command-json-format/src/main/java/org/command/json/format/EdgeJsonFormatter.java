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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class EdgeJsonFormatter {
  private static Gson gson = new Gson();

  /**
   * convert from Object to String
   *
   * @param value Object value of EdgeAttribute
   *
   * @return value if type of value is string, otherwise null
   */
  private static Object convertStringFromObject(Object value) {
    try {
      return String.valueOf(value);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * convert from Object to Double
   *
   * @param value Object value of EdgeAttribute
   *
   * @return value if type of value is double, otherwise null
   */

  private static Object convertDoubleFromObject(Object value) {
    try {
      return Double.parseDouble(value.toString());
    } catch(NumberFormatException e){
      return null;
    } catch(Exception e) {
      return null;
    }
  }

  /**
   * convert from Object to Float
   *
   * @param value Object value of EdgeAttribute
   *
   * @return value if type of value is float, otherwise null
   */
  private static Object convertFloatFromObject(Object value) {
    try {
      return Float.parseFloat(value.toString());
    } catch(NumberFormatException e){
      return null;
    } catch(Exception e) {
      return null;
    }
  }

  /**
   * convert from Object to Integer
   *
   * @param value Object value of EdgeAttribute
   *
   * @return value if type of value is integer, otherwise null
   */
  private static Object convertIntegerFromObject(Object value) {
    Object convertValue = EdgeJsonFormatter.convertFloatFromObject(value);
    if(convertValue == null) {
      return null;
    } else {
      return Math.round((float) convertValue);
    }
  }

  /**
   * convert Object value of EdgeAttribute <br>
   * Use {@link #convertStringFromObject(Object)} to convert string value of EdgeAttribute <br>
   * Use {@link #convertDoubleFromObject(Object)} to convert double value of EdgeAttribute <br>
   * Use {@link #convertFloatFromObject(Object)} to convert float value of EdgeAttribute <br>
   * Use {@link #convertIntegerFromObject(Object)} to convert integer value of EdgeAttribute <br>
   * Use {@link #convertEdgeAttributeListFromObject(Object)} to convert list value of EdgeAttribute
   *
   * @param edgeAttribute EdgeAttribute to be converted
   *
   * @return true if it is succeed to convert value of EdgeAttribute, otherwise false
   */
  private static boolean convertEdgeAttribute(EdgeAttribute edgeAttribute) {
    boolean ret = true;
    if (edgeAttribute == null) {
      ret = false;
    } else if (edgeAttribute.getName() == null || edgeAttribute.getDataType() == null
        || edgeAttribute.getValue() == null) {
      ret = false;
    } else {
      Object value = null;
      if (edgeAttribute.getDataType().equals(EdgeFormatIdentifier.STRING_TYPE.getValue())) {
        value = convertStringFromObject(edgeAttribute.getValue());
      } else if (edgeAttribute.getDataType().equals(EdgeFormatIdentifier.DOUBLE_TYPE.getValue())) {
        value = convertDoubleFromObject(edgeAttribute.getValue());
      } else if (edgeAttribute.getDataType().equals(EdgeFormatIdentifier.FLOAT_TYPE.getValue())) {
        value = convertFloatFromObject(edgeAttribute.getValue());
      } else if (edgeAttribute.getDataType().equals(EdgeFormatIdentifier.INTEGER_TYPE.getValue())) {
        value = convertIntegerFromObject(edgeAttribute.getValue());
      } else if (edgeAttribute.getDataType()
          .equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue())) {
        value = convertEdgeAttributeListFromObject(edgeAttribute.getValue());
      }
      if (ret == true && value != null) {
        edgeAttribute.setValue(value);
      } else {
        ret = false;
      }
    }

    return ret;
  }

  /**
   * Encode EdgeData To JsonString
   *
   * @param edgeData EdgeData to be encoded
   *
   * @return string of json format if it is succeed to encode EdgeData to JsonString, otherwise null
   */
  public static String encodeEdgeDataToJsonString(EdgeData edgeData) {
    return gson.toJson(edgeData);
  }

  /**
   * Decoded JsonString To EdgeData <br>
   * Use {@link #convertEdgeAttribute(EdgeAttribute)} to convert EdgeAttribute
   *
   * @param json JsonString to be decoded
   *
   * @return EdgeData if it is succeed to decoded JsonString to EdgeData, otherwise null
   */
  public static EdgeData decodeJsonStringToEdgeData(String json) {
    EdgeData edgeData = gson.fromJson(json, EdgeData.class);
    if (edgeData != null) {
      if (edgeData.getDataTitle() == null || edgeData.getVersion() == null
          || edgeData.getEdgeElementList() == null) {
        return null;
      }
      for (EdgeElement edgeElement : edgeData.getEdgeElementList()) {
        if (edgeElement.getEdgeAttributeList() == null || edgeElement.getElementTitle() == null) {
          return null;
        }
        for (EdgeAttribute edgeAttribute : edgeElement.getEdgeAttributeList()) {
          if (convertEdgeAttribute(edgeAttribute) == false) {
            return null;
          }
        }
      }
    }
    return edgeData;
  }

  /**
   * Encode EdgeElement To JsonString
   *
   * @param edgeElement EdgeElement to be encoded
   *
   * @return string of json format if it is succeed to encode EdgeElement to JsonString, otherwise
   *         null
   */
  public static String encodeEdgeElementToJsonString(EdgeElement edgeElement) {
    return gson.toJson(edgeElement);
  }

  /**
   * Decoded JsonString To EdgeElement <br>
   * Use {@link #convertEdgeAttribute(EdgeAttribute)} to convert EdgeAttribute
   *
   * @param json JsonString to be decoded
   *
   * @return EdgeElement if it is succeed to decoded JsonString to EdgeElement, otherwise null
   */
  public static EdgeElement decodeJsonStringToEdgeElement(String json) {
    EdgeElement edgeElement = gson.fromJson(json, EdgeElement.class);
    if (edgeElement != null) {
      if (edgeElement.getEdgeAttributeList() == null || edgeElement.getElementTitle() == null) {
        return null;
      }
      for (EdgeAttribute edgeAttribute : edgeElement.getEdgeAttributeList()) {
        if (convertEdgeAttribute(edgeAttribute) == false) {
          return null;
        }
      }
    }
    return edgeElement;
  }

  /**
   * Encode EdgeAttribute To JsonString
   *
   * @param edgeAttribute EdgeAttribute to be encoded
   *
   * @return string of json format if it is succeed to encode EdgeAttribute to JsonString, otherwise
   *         null
   */
  public static String encodeEdgeAttributeToJsonString(EdgeAttribute edgeAttribute) {
    return gson.toJson(edgeAttribute);
  }

  /**
   * Decoded JsonString To EdgeAttribute <br>
   * Use {@link #convertEdgeAttribute(EdgeAttribute)} to convert EdgeAttribute
   *
   * @param json JsonString to be decoded
   *
   * @return EdgeAttribute if it is succeed to decoded JsonString to EdgeAttribute, otherwise null
   */
  public static EdgeAttribute decodeJsonStringToEdgeAttribute(String json) {
    EdgeAttribute edgeAttribute = gson.fromJson(json, EdgeAttribute.class);
    if (edgeAttribute != null) {
      if (convertEdgeAttribute(edgeAttribute) == false) {
        return null;
      }
    }
    return edgeAttribute;
  }

  /**
   * Get Object Value of EdgeAttribute By name of EdgeAttribute in list of EdgeAttribute <br>
   * Use {@link #getObjectValueByName(List, String)} to find EdgeAttribute recursively <br>
   * Use {@link #convertEdgeAttributeListFromObject(Object)} to convert EdgeAttrubiteList From
   * Object
   *
   * @param edgeAttributeList list of EdgeAttribute
   * @param edgeAttributeName name of EdgeAttribute
   *
   * @return Object value of EdgeAttribute if it is succeed to find EdgeAttribute, otherwise null
   */
  public static Object getObjectValueByName(List<EdgeAttribute> edgeAttributeList,
      String edgeAttributeName) {
    if (edgeAttributeList == null || edgeAttributeName == null) {
      return null;
    }
    for (EdgeAttribute edgeAttr : edgeAttributeList) {
      if (edgeAttr.getName().equals(edgeAttributeName) == true) {
        return edgeAttr.getValue();
      } else if (edgeAttr.getDataType()
          .equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
        return getObjectValueByName(convertEdgeAttributeListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * Get String Value of EdgeAttribute By name of EdgeAttribute in list of EdgeAttribute <br>
   * Use {@link #getObjectValueByName(List, String)} to find EdgeAttribute recursively <br>
   * Use {@link #convertEdgeAttributeListFromObject(Object)} to convert EdgeAttrubiteList From
   * Object
   *
   * @param edgeAttributeList list of EdgeAttribute
   * @param edgeAttributeName name of EdgeAttribute
   *
   * @return String value of EdgeAttribute if it is succeed to find EdgeAttribute, otherwise null
   */
  public static String getStringValueByName(List<EdgeAttribute> edgeAttributeList,
      String edgeAttributeName) {
    if (edgeAttributeList == null || edgeAttributeName == null) {
      return null;
    }
    for (EdgeAttribute edgeAttr : edgeAttributeList) {
      if (edgeAttr.getName().equals(edgeAttributeName) == true
          && edgeAttr.getDataType().equalsIgnoreCase(EdgeFormatIdentifier.STRING_TYPE.getValue())) {
        return String.valueOf(edgeAttr.getValue());
      } else if (edgeAttr.getDataType()
          .equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
        return getStringValueByName(convertEdgeAttributeListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * Get Double Value of EdgeAttribute By name of EdgeAttribute in list of EdgeAttribute <br>
   * Use {@link #getObjectValueByName(List, String)} to find EdgeAttribute recursively <br>
   * Use {@link #convertEdgeAttributeListFromObject(Object)} to convert EdgeAttrubiteList From
   * Object
   *
   * @param edgeAttributeList list of EdgeAttribute
   * @param edgeAttributeName name of EdgeAttribute
   *
   * @return Double value of EdgeAttribute if it is succeed to find EdgeAttribute, otherwise null
   */
  public static Double getDoubleValueByName(List<EdgeAttribute> edgeAttributeList,
      String edgeAttributeName) {
    if (edgeAttributeList == null || edgeAttributeName == null) {
      return null;
    }
    for (EdgeAttribute edgeAttr : edgeAttributeList) {
      if (edgeAttr.getName().equals(edgeAttributeName) == true
          && edgeAttr.getDataType().equalsIgnoreCase(EdgeFormatIdentifier.DOUBLE_TYPE.getValue())) {
        return (Double) edgeAttr.getValue();
      } else if (edgeAttr.getDataType()
          .equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
        return getDoubleValueByName(convertEdgeAttributeListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * Get Integer Value of EdgeAttribute By name of EdgeAttribute in list of EdgeAttribute <br>
   * Use {@link #getObjectValueByName(List, String)} to find EdgeAttribute recursively <br>
   * Use {@link #convertEdgeAttributeListFromObject(Object)} to convert EdgeAttrubiteList From
   * Object
   *
   * @param edgeAttributeList list of EdgeAttribute
   * @param edgeAttributeName name of EdgeAttribute
   *
   * @return Integer value of EdgeAttribute if it is succeed to find EdgeAttribute, otherwise null
   */
  public static Integer getIntegerValueByName(List<EdgeAttribute> edgeAttributeList,
      String edgeAttributeName) {
    if (edgeAttributeList == null || edgeAttributeName == null) {
      return null;
    }
    for (EdgeAttribute edgeAttr : edgeAttributeList) {
      if (edgeAttr.getName().equals(edgeAttributeName) == true && edgeAttr.getDataType()
          .equalsIgnoreCase(EdgeFormatIdentifier.INTEGER_TYPE.getValue())) {
        return (Integer) edgeAttr.getValue();
      } else if (edgeAttr.getDataType()
          .equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {

        return getIntegerValueByName(convertEdgeAttributeListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * Get Float Value of EdgeAttribute By name of EdgeAttribute in list of EdgeAttribute <br>
   * Use {@link #getObjectValueByName(List, String)} to find EdgeAttribute recursively <br>
   * Use {@link #convertEdgeAttributeListFromObject(Object)} to convert EdgeAttrubiteList From
   * Object
   *
   * @param edgeAttributeList list of EdgeAttribute
   * @param edgeAttributeName name of EdgeAttribute
   *
   * @return Float value of EdgeAttribute if it is succeed to find EdgeAttribute, otherwise null
   */
  public static Float getFloatValueByName(List<EdgeAttribute> edgeAttributeList,
      String edgeAttributeName) {
    if (edgeAttributeList == null || edgeAttributeName == null) {
      return null;
    }
    for (EdgeAttribute edgeAttr : edgeAttributeList) {
      if (edgeAttr.getName().equals(edgeAttributeName) == true
          && edgeAttr.getDataType().equalsIgnoreCase(EdgeFormatIdentifier.FLOAT_TYPE.getValue())) {
        return (Float) edgeAttr.getValue();
      } else if (edgeAttr.getDataType()
          .equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
        return getFloatValueByName(convertEdgeAttributeListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * convert from Object to list of EdgeAttrubite <br>
   * Use {@link #convertEdgeAttribute(EdgeAttribute)} to convert EdgeAttribute
   *
   * @param value Object value of EdgeAttribute
   *
   * @return value if type of value is List of EdgeAttribute, otherwise null
   */
  public static List<EdgeAttribute> convertEdgeAttributeListFromObject(Object value) {
    List<EdgeAttribute> edgeAttributeList = null;
    if (value instanceof List) {
      List<?> listObj = (List<?>) value;
      if (listObj.isEmpty() == true) {
        edgeAttributeList = new ArrayList<EdgeAttribute>();
      } else if (listObj.get(0).getClass().equals(EdgeAttribute.class)) {
        edgeAttributeList = new ArrayList<EdgeAttribute>();
        for (Object obj : listObj) {
          edgeAttributeList.add((EdgeAttribute) obj);
        }
      } else {
        edgeAttributeList =
            gson.fromJson(gson.toJson(value), new TypeToken<List<EdgeAttribute>>() {}.getType());
        for (EdgeAttribute edgeAttribute : edgeAttributeList) {
          if (convertEdgeAttribute(edgeAttribute) == false) {
            return null;
          }
        }
      }
    }
    return edgeAttributeList;
  }
}
