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
   * @param value EdgeAttribute's value
   * 
   * @return value if value's type is string, otherwise null
   */
  private static Object convertStringFromObject(Object value) {
    if (value instanceof String) {
      return String.valueOf(value);
    } else {
      return null;
    }
  }

  /**
   * convert from Object to Double
   * 
   * @param value EdgeAttribute's value
   * 
   * @return value if value's type is Double, otherwise null
   */
  private static Object convertDoubleFromObject(Object value) {
    if (value instanceof Double) {
      return (Double) value;
    } else {
      return null;
    }
  }

  /**
   * convert from Object to Float
   * 
   * @param value EdgeAttribute's value
   * 
   * @return value if value's type is Float, otherwise null
   */
  private static Object convertFloatFromObject(Object value) {
    Float ret = null;
    if (value instanceof Double) {
      ret = ((Double) value).floatValue();
      if (((Double) value).equals(ret.doubleValue()) == false) {
        ret = null;
      }
    } else if (value instanceof Float) {
      ret = (Float) value;
    }
    return ret;
  }

  /**
   * convert from Object to Integer
   * 
   * @param value EdgeAttribute's value
   * 
   * @return value if value's type is Integer, otherwise null
   */
  private static Object convertIntegerFromObject(Object value) {
    Integer ret = null;
    if (value instanceof Double) {
      ret = ((Double) value).intValue();
      if (((Double) value).equals(ret.doubleValue()) == false) {
        ret = null;
      }
    } else if (value instanceof Integer) {
      ret = (Integer) value;
    }
    return ret;
  }

  /**
   * convert EdgeAttribute's value (data type is Object) <br>
   * Use {@link #convertStringFromObject(Object)} to convert EdgeAttribute's string value <br>
   * Use {@link #convertDoubleFromObject(Object)} to convert EdgeAttribute's double value <br>
   * Use {@link #convertFloatFromObject(Object)} to convert EdgeAttribute's float value <br>
   * Use {@link #convertIntegerFromObject(Object)} to convert EdgeAttribute's integer value <br>
   * Use {@link #convertAttrubiteListFromObject(Object)} to convert EdgeAttribute's list value
   * 
   * @param edgeAttribute EdgeAttribute to be converted
   * 
   * @return true if it is succeed to convert EdgeAttribute's value, otherwise false
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
        value = convertEdgeAttrubiteListFromObject(edgeAttribute.getValue());
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
   * Get EdgeAttribute's Object Value By EdgeAttribute's name in list of EdgeAttribute <br>
   * Use {@link #getObjectValueByName(List, String)} to find EdgeAttribute recursively <br>
   * Use {@link #convertEdgeAttrubiteListFromObject(Object)} to convert EdgeAttrubiteList From Object
   * 
   * @param edgeAttributeList list of EdgeAttribute
   * @param edgeAttributeName EdgeAttribute's name
   * 
   * @return EdgeAttribute's Object value 
   *         if it is succeed to find EdgeAttribute, otherwise null
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
        return getObjectValueByName(convertEdgeAttrubiteListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * Get EdgeAttribute's String Value By EdgeAttribute's name in list of EdgeAttribute <br>
   * Use {@link #getObjectValueByName(List, String)} to find EdgeAttribute recursively <br>
   * Use {@link #convertEdgeAttrubiteListFromObject(Object)} to convert EdgeAttrubiteList From Object
   * 
   * @param edgeAttributeList list of EdgeAttribute
   * @param edgeAttributeName EdgeAttribute's name
   * 
   * @return EdgeAttribute's String value 
   *         if it is succeed to find EdgeAttribute, otherwise null
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
        return getStringValueByName(convertEdgeAttrubiteListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * Get EdgeAttribute's Double Value By EdgeAttribute's name in list of EdgeAttribute <br>
   * Use {@link #getObjectValueByName(List, String)} to find EdgeAttribute recursively <br>
   * Use {@link #convertEdgeAttrubiteListFromObject(Object)} to convert EdgeAttrubiteList From Object
   * 
   * @param edgeAttributeList list of EdgeAttribute
   * @param edgeAttributeName EdgeAttribute's name
   * 
   * @return EdgeAttribute's Double value 
   *         if it is succeed to find EdgeAttribute, otherwise null
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
        return getDoubleValueByName(convertEdgeAttrubiteListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * Get EdgeAttribute's Integer Value By EdgeAttribute's name in list of EdgeAttribute <br>
   * Use {@link #getObjectValueByName(List, String)} to find EdgeAttribute recursively <br>
   * Use {@link #convertEdgeAttrubiteListFromObject(Object)} to convert EdgeAttrubiteList From Object
   * 
   * @param edgeAttributeList list of EdgeAttribute
   * @param edgeAttributeName EdgeAttribute's name
   * 
   * @return EdgeAttribute's Integer value 
   *         if it is succeed to find EdgeAttribute, otherwise null
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

        return getIntegerValueByName(convertEdgeAttrubiteListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * Get EdgeAttribute's Float Value By EdgeAttribute's name in list of EdgeAttribute <br>
   * Use {@link #getObjectValueByName(List, String)} to find EdgeAttribute recursively <br>
   * Use {@link #convertEdgeAttrubiteListFromObject(Object)} to convert EdgeAttrubiteList From Object
   * 
   * @param edgeAttributeList list of EdgeAttribute
   * @param edgeAttributeName EdgeAttribute's name
   * 
   * @return EdgeAttribute's Float value 
   *         if it is succeed to find EdgeAttribute, otherwise null
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
        return getFloatValueByName(convertEdgeAttrubiteListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * convert from Object to list of EdgeAttrubite <br>
   * Use {@link #convertEdgeAttribute(EdgeAttribute)} to convert EdgeAttribute
   * 
   * @param value EdgeAttribute's value
   * 
   * @return value if value's type is List of EdgeAttribute, otherwise null
   */
  public static List<EdgeAttribute> convertEdgeAttrubiteListFromObject(Object value) {
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
