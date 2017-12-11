package org.command.json.format;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class EdgeJsonFormatter {
  private static Gson gson = new Gson();

  /**
   * @fn Object convertStringFromObject(EdgeAttribute edgeAttribute)
   * @brief convert String From Object
   * @param [in] edgeAttribute @EdgeAttribute
   * @return @Object
   */
  private static Object convertStringFromObject(EdgeAttribute edgeAttribute) {
    if (edgeAttribute.getDataType().equals(EdgeFormatIdentifier.STRING_TYPE.getValue())) {
      return String.valueOf(edgeAttribute.getValue());
    } else {
      return null;
    }
  }

  /**
   * @fn Object convertNumericFromObject(EdgeAttribute edgeAttribute)
   * @brief convert Numeric From Object
   * @param [in] edgeAttribute @EdgeAttribute
   * @return @Object
   */
  private static Object convertNumericFromObject(EdgeAttribute edgeAttribute) {
    Object value = null;
    if (edgeAttribute.getDataType().equals(EdgeFormatIdentifier.DOUBLE_TYPE.getValue())) {
      value = (Double) edgeAttribute.getValue();
    } else if (edgeAttribute.getDataType().equals(EdgeFormatIdentifier.INTEGER_TYPE.getValue())) {
      value = ((Double) edgeAttribute.getValue()).intValue();
      if (((Double) edgeAttribute.getValue()).equals(((Integer) value).doubleValue()) == false) {
        value = null;
      }
    } else if (edgeAttribute.getDataType().equals(EdgeFormatIdentifier.FLOAT_TYPE.getValue())) {
      value = ((Double) edgeAttribute.getValue()).floatValue();
      if (((Double) edgeAttribute.getValue()).equals(((Float) value).doubleValue()) == false) {
        value = null;
      }
    }
    return value;
  }

  /**
   * @fn boolean convertFromEdgeAttribute(EdgeAttribute edgeAttribute)
   * @brief convert From EdgeAttribute
   * @param [in] edgeAttribute @EdgeAttribute
   * @return @boolean
   */
  private static boolean convertFromEdgeAttribute(EdgeAttribute edgeAttribute) {
    boolean ret = true;
    if (edgeAttribute == null) {
      ret = false;
    } else if (edgeAttribute.getName() == null || edgeAttribute.getDataType() == null
        || edgeAttribute.getValue() == null) {
      ret = false;
    } else {
      Object value = null;
      if (edgeAttribute.getValue() instanceof String) {
        value = convertStringFromObject(edgeAttribute);
      } else if (edgeAttribute.getValue() instanceof Double) {
        value = convertNumericFromObject(edgeAttribute);
      } else if (edgeAttribute.getValue() instanceof List
          && edgeAttribute.getDataType().equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue())) {
        List<EdgeAttribute> listValue = covertAttrubiteListFromObject(edgeAttribute.getValue());
        if (listValue != null) {
          for (EdgeAttribute edgeAttribue : listValue) {
            if (convertFromEdgeAttribute(edgeAttribue) == false) {
              ret = false;
              break;
            }
          }
          value = listValue;
        }
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
   * @fn String encodeEdgeDataToJsonString(EdgeData edgeData)
   * @brief Encode EdgeData To JsonString
   * @param [in] edgeData @EdgeData
   * @return @String
   */
  public static String encodeEdgeDataToJsonString(EdgeData edgeData) {
    return gson.toJson(edgeData);
  }

  /**
   * @fn EdgeData decodeJsonStringToEdgeData(String json)
   * @brief Decode JsonString To EdgeData
   * @param [in] json @String
   * @return @EdgeData
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
          if (convertFromEdgeAttribute(edgeAttribute) == false) {
            return null;
          }
        }
      }
    }
    return edgeData;
  }

  /**
   * @fn String encodeEdgeElementToJsonString(EdgeElement edgeElement)
   * @brief Encode edgeElement To JsonString
   * @param [in] edgeElement @EdgeElement
   * @return @String
   */
  public static String encodeEdgeElementToJsonString(EdgeElement edgeElement) {
    return gson.toJson(edgeElement);
  }

  /**
   * @fn EdgeData decodeJsonStringToEdgeElement(String json)
   * @brief Decode JsonString To EdgeElement
   * @param [in] json @String
   * @return @EdgeElement
   */
  public static EdgeElement decodeJsonStringToEdgeElement(String json) {
    EdgeElement edgeElement = gson.fromJson(json, EdgeElement.class);
    if (edgeElement != null) {
      if (edgeElement.getEdgeAttributeList() == null || edgeElement.getElementTitle() == null) {
        return null;
      }
      for (EdgeAttribute edgeAttribute : edgeElement.getEdgeAttributeList()) {
        if (convertFromEdgeAttribute(edgeAttribute) == false) {
          return null;
        }
      }
    }
    return edgeElement;
  }

  /**
   * @fn String encodeEdgeAttributeToJsonString(EdgeAttribute edgeAttribute)
   * @brief Encode EdgeAttribute To JsonString
   * @param [in] edgeAttribute @EdgeAttribute
   * @return @String
   */
  public static String encodeEdgeAttributeToJsonString(EdgeAttribute edgeAttribute) {
    return gson.toJson(edgeAttribute);
  }

  /**
   * @fn EdgeData decodeJsonStringToEdgeAttribute(String json)
   * @brief Decode JsonString To EdgeAttribute
   * @param [in] json @String
   * @return @EdgeAttribute
   */
  public static EdgeAttribute decodeJsonStringToEdgeAttribute(String json) {
    EdgeAttribute edgeAttribute = gson.fromJson(json, EdgeAttribute.class);
    if (edgeAttribute != null) {
      if (convertFromEdgeAttribute(edgeAttribute) == false) {
        return null;
      }
    }
    return edgeAttribute;
  }

  /**
   * @fn Object getObjectValueByName(List<EdgeAttribute> edgeAttributeList, String
   *     edgeAttributeName)
   * @brief Get ObjectValue By Name in edgeAttributeList (recursive)
   * @param [in] edgeAttributeList @List<EdgeAttribute>
   * @param [in] edgeAttributeName @String
   * @return @Object
   */
  public static Object getObjectValueByName(List<EdgeAttribute> edgeAttributeList,
      String edgeAttributeName) {
    if(edgeAttributeList == null || edgeAttributeName == null){
      return null;
    }
    for (EdgeAttribute edgeAttr : edgeAttributeList) {
      if (edgeAttr.getName().equals(edgeAttributeName) == true) {
        return edgeAttr.getValue();
      } else if (edgeAttr.getDataType()
          .equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
        return getObjectValueByName(covertAttrubiteListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * @fn String getStringValueByName(List<EdgeAttribute> edgeAttributeList, String
   *     edgeAttributeName)
   * @brief Get StringValue By Name in edgeAttributeList (recursive)
   * @param [in] edgeAttributeList @List<EdgeAttribute>
   * @param [in] edgeAttributeName @String
   * @return @String
   */
  public static String getStringValueByName(List<EdgeAttribute> edgeAttributeList,
      String edgeAttributeName) {
    if(edgeAttributeList == null || edgeAttributeName == null){
      return null;
    }
    for (EdgeAttribute edgeAttr : edgeAttributeList) {
      if (edgeAttr.getName().equals(edgeAttributeName) == true
          && edgeAttr.getDataType().equalsIgnoreCase(EdgeFormatIdentifier.STRING_TYPE.getValue())) {
        return String.valueOf(edgeAttr.getValue());
      } else if (edgeAttr.getDataType()
          .equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
        return getStringValueByName(covertAttrubiteListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * @fn Double getDoubleValueByName(List<EdgeAttribute> edgeAttributeList, String
   *     edgeAttributeName)
   * @brief Get DoubleValue By Name in edgeAttributeList (recursive)
   * @param [in] edgeAttributeList @List<EdgeAttribute>
   * @param [in] edgeAttributeName @String
   * @return @Double
   */
  public static Double getDoubleValueByName(List<EdgeAttribute> edgeAttributeList,
      String edgeAttributeName) {
    if(edgeAttributeList == null || edgeAttributeName == null){
      return null;
    }
    for (EdgeAttribute edgeAttr : edgeAttributeList) {
      if (edgeAttr.getName().equals(edgeAttributeName) == true
          && edgeAttr.getDataType().equalsIgnoreCase(EdgeFormatIdentifier.DOUBLE_TYPE.getValue())) {
        return (Double) edgeAttr.getValue();
      } else if (edgeAttr.getDataType()
          .equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
        return getDoubleValueByName(covertAttrubiteListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * @fn Integer getIntegerValueByName(List<EdgeAttribute> edgeAttributeList, String
   *     edgeAttributeName)
   * @brief Get IntegerValue By Name in edgeAttributeList (recursive)
   * @param [in] edgeAttributeList @List<EdgeAttribute>
   * @param [in] edgeAttributeName @String
   * @return @Integer
   */
  public static Integer getIntegerValueByName(List<EdgeAttribute> edgeAttributeList,
      String edgeAttributeName) {
    if(edgeAttributeList == null || edgeAttributeName == null){
      return null;
    }
    for (EdgeAttribute edgeAttr : edgeAttributeList) {
      if (edgeAttr.getName().equals(edgeAttributeName) == true
          && edgeAttr.getDataType().equalsIgnoreCase(EdgeFormatIdentifier.INTEGER_TYPE.getValue())) {
        return (Integer) edgeAttr.getValue();
      } else if (edgeAttr.getDataType()
          .equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {

        return getIntegerValueByName(covertAttrubiteListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * @fn Float getFloatValueByName(List<EdgeAttribute> edgeAttributeList, String edgeAttributeName)
   * @brief Get FloatValue By Name in edgeAttributeList (recursive)
   * @param [in] edgeAttributeList @List<EdgeAttribute>
   * @param [in] edgeAttributeName @String
   * @return @Float
   */
  public static Float getFloatValueByName(List<EdgeAttribute> edgeAttributeList,
      String edgeAttributeName) {
    if(edgeAttributeList == null || edgeAttributeName == null){
      return null;
    }
    for (EdgeAttribute edgeAttr : edgeAttributeList) {
      if (edgeAttr.getName().equals(edgeAttributeName) == true
          && edgeAttr.getDataType().equalsIgnoreCase(EdgeFormatIdentifier.FLOAT_TYPE.getValue())) {
        return (Float) edgeAttr.getValue();
      } else if (edgeAttr.getDataType()
          .equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
        return getFloatValueByName(covertAttrubiteListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return null;
  }

  /**
   * @fn List<EdgeAttribute> covertAttrubiteListFromObject(Object obj)
   * @brief Convert AttrubiteList From Object, When Object is List<EdgeAttribute> format
   * @param [in] obj @Object
   * @return @List<EdgeAttribute>
   */
  public static List<EdgeAttribute> covertAttrubiteListFromObject(Object obj) {
    if (obj instanceof List) {
      return gson.fromJson(gson.toJson(obj), new TypeToken<List<EdgeAttribute>>() {}.getType());
    } else {
      return null;
    }
  }
}
