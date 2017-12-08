package org.command.json.format;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class EdgeJsonFormatter {
  private static Gson gson = new Gson();

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
    return gson.fromJson(json, EdgeData.class);
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
    return gson.fromJson(json, EdgeElement.class);
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
    return gson.fromJson(json, EdgeAttribute.class);
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
    for (EdgeAttribute edgeAttr : edgeAttributeList) {
      if (edgeAttr.getName().equals(edgeAttributeName) == true
          && edgeAttr.getName().equalsIgnoreCase(EdgeFormatIdentifier.STRING_TYPE.getValue())) {
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
    for (EdgeAttribute edgeAttr : edgeAttributeList) {
      if (edgeAttr.getName().equals(edgeAttributeName) == true
          && edgeAttr.getName().equalsIgnoreCase(EdgeFormatIdentifier.DOUBLE_TYPE.getValue())) {
        return (Double) edgeAttr.getValue();
      } else if (edgeAttr.getDataType()
          .equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
        return getDoubleValueByName(covertAttrubiteListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return 0.0;
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
    for (EdgeAttribute edgeAttr : edgeAttributeList) {
      if (edgeAttr.getName().equals(edgeAttributeName) == true
          && edgeAttr.getName().equalsIgnoreCase(EdgeFormatIdentifier.INTEGER_TYPE.getValue())) {
        return (Integer) edgeAttr.getValue();
      } else if (edgeAttr.getDataType()
          .equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {

        return getIntegerValueByName(covertAttrubiteListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return 0;
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
    for (EdgeAttribute edgeAttr : edgeAttributeList) {
      if (edgeAttr.getName().equals(edgeAttributeName) == true
          && edgeAttr.getName().equalsIgnoreCase(EdgeFormatIdentifier.FLOAT_TYPE.getValue())) {
        return (Float) edgeAttr.getValue();
      } else if (edgeAttr.getDataType()
          .equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
        return getFloatValueByName(covertAttrubiteListFromObject(edgeAttr.getValue()),
            edgeAttributeName);
      }
    }
    return 0.0f;
  }

  /**
   * @fn List<EdgeAttribute> covertAttrubiteListFromObject(Object obj)
   * @brief Convert AttrubiteList From Object, When Object is List<EdgeAttribute> format
   * @param [in] obj @Object
   * @return @List<EdgeAttribute>
   */
  public static List<EdgeAttribute> covertAttrubiteListFromObject(Object obj) {
    return gson.fromJson(gson.toJson(obj), new TypeToken<List<EdgeAttribute>>() {}.getType());
  }
}
