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

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.command.json.format.EdgeJsonFormatter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EdgeAttributeTest {
  private final Logger logger = LoggerFactory.getLogger(getClass());

  private static EdgeAttribute testEdgeAttribute = null;

  private static EdgeAttribute testEdgeAttributeString = null;
  private static EdgeAttribute testEdgeAttributeDouble = null;
  private static EdgeAttribute testEdgeAttributeInteger = null;
  private static EdgeAttribute testEdgeAttributeFloat = null;
  private static EdgeAttribute testEdgeAttributeAttributesHasAll = null;
  private static EdgeAttribute testEdgeAttributeAttributesIsEmpty = null;

  private static EdgeAttribute testEdgeAttributeNameIsNull = null;
  private static EdgeAttribute testEdgeAttributeDataTypeIsNull = null;
  private static EdgeAttribute testEdgeAttributeValueIsNull = null;
  private static EdgeAttribute testEdgeAttributeDataTypeAndValueUnmatch = null;

  private static final String STRING_NAME = "edgeAttribute_string";
  private static final String STRING_DATATYPE = EdgeFormatIdentifier.STRING_TYPE.getValue();
  private static final String STRING_VALUE = "value";
  private static final String DOUBLE_NAME = "edgeAttribute_double";
  private static final String DOUBLE_DATATYPE = EdgeFormatIdentifier.DOUBLE_TYPE.getValue();
  private static final Double DOUBLE_VALUE = 0.5;
  private static final String INTEGER_NAME = "edgeAttribute_integer";
  private static final String INTEGER_DATATYPE = EdgeFormatIdentifier.INTEGER_TYPE.getValue();
  private static final Integer INTEGER_VALUE = 1;
  private static final String FLOAT_NAME = "edgeAttribute_float";
  private static final String FLOAT_DATATYPE = EdgeFormatIdentifier.FLOAT_TYPE.getValue();
  private static final Float FLOAT_VALUE = 1.0f;
  private static final String ATTRIBUTES_NAME = "edgeAttribute_attirbutes";
  private static final String ATTRIBUTES_DATATYPE = EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue();
  private static final List<EdgeAttribute> testEdgeAttributeListIsEmpty =
      new ArrayList<EdgeAttribute>();
  private static List<EdgeAttribute> testEdgeAttributeListHasAll = null;
  private static final String UNMATCH_NAME = "edgeAttribute_unmatch";
  private static final String UNMATCH_DATATYPE = EdgeFormatIdentifier.STRING_TYPE.getValue();
  private static final Double UNMATCH_VALUE = 1.0;

  @BeforeClass
  public static void start() {
    testEdgeAttribute = null;
    testEdgeAttributeString = new EdgeAttribute(STRING_NAME, STRING_DATATYPE, STRING_VALUE);
    testEdgeAttributeDouble = new EdgeAttribute(DOUBLE_NAME, DOUBLE_DATATYPE, DOUBLE_VALUE);
    testEdgeAttributeInteger = new EdgeAttribute(INTEGER_NAME, INTEGER_DATATYPE, INTEGER_VALUE);
    testEdgeAttributeFloat = new EdgeAttribute(FLOAT_NAME, FLOAT_DATATYPE, FLOAT_VALUE);

    testEdgeAttributeListHasAll = Arrays.asList(testEdgeAttributeString, testEdgeAttributeDouble,
        testEdgeAttributeInteger, testEdgeAttributeFloat);
    testEdgeAttributeAttributesHasAll =
        new EdgeAttribute(ATTRIBUTES_NAME, ATTRIBUTES_DATATYPE, testEdgeAttributeListHasAll);
    testEdgeAttributeAttributesIsEmpty =
        new EdgeAttribute(ATTRIBUTES_NAME, ATTRIBUTES_DATATYPE, testEdgeAttributeListIsEmpty);

    testEdgeAttributeNameIsNull = new EdgeAttribute(null, STRING_DATATYPE, STRING_VALUE);
    testEdgeAttributeDataTypeIsNull = new EdgeAttribute(STRING_NAME, null, STRING_VALUE);
    testEdgeAttributeValueIsNull = new EdgeAttribute(STRING_NAME, STRING_DATATYPE, null);
    testEdgeAttributeDataTypeAndValueUnmatch =
        new EdgeAttribute(UNMATCH_NAME, UNMATCH_DATATYPE, UNMATCH_VALUE);

  }

  @AfterClass
  public static void stop() throws Exception {}

  @Test
  public void test_EdgeAttribute_Construct() throws Exception {
    logger.info("[TEST] test_EdgeAttribute_Construct");
    testEdgeAttribute = new EdgeAttribute(null, null, null);
    assertNotNull(testEdgeAttribute);
    logger.info("[PASS] test_EdgeAttribute_Construct");
  }

  @Test
  public void test_EncodeEdgeAttributeToJsonString_is_Null() throws Exception {
    logger.info("[TEST] test_EncodeEdgeAttributeToJsonString_is_Null");
    String jsonString = EdgeJsonFormatter.encodeEdgeAttributeToJsonString(null);
    EdgeAttribute result = EdgeJsonFormatter.decodeJsonStringToEdgeAttribute(jsonString);
    assertEquals(result, null);
    logger.info("[PASS] test_EncodeEdgeAttributeToJsonString_is_Null");
  }
  
  @Test
  public void test_EncodeEdgeAttributeToJsonString_Value_is_String() throws Exception {
    logger.info("[TEST] test_EncodeEdgeAttributeToJsonString_Value_is_String");
    String jsonString = EdgeJsonFormatter.encodeEdgeAttributeToJsonString(testEdgeAttributeString);
    EdgeAttribute result = EdgeJsonFormatter.decodeJsonStringToEdgeAttribute(jsonString);
    assertEquals(testEdgeAttributeString.getName(), result.getName());
    assertEquals(testEdgeAttributeString.getDataType(), result.getDataType());
    assertEquals(testEdgeAttributeString.getValue(), result.getValue());
    logger.info("[PASS] test_EncodeEdgeAttributeToJsonString_Value_is_String");
  }

  @Test
  public void test_EncodeEdgeAttributeToJsonString_Value_is_Double() throws Exception {
    logger.info("[TEST] test_EncodeEdgeAttributeToJsonString_Value_is_Double");
    String jsonString = EdgeJsonFormatter.encodeEdgeAttributeToJsonString(testEdgeAttributeDouble);
    EdgeAttribute result = EdgeJsonFormatter.decodeJsonStringToEdgeAttribute(jsonString);
    assertEquals(testEdgeAttributeDouble.getName(), result.getName());
    assertEquals(testEdgeAttributeDouble.getDataType(), result.getDataType());
    assertEquals(testEdgeAttributeDouble.getValue(), result.getValue());
    logger.info("[PASS] test_EncodeEdgeAttributeToJsonString_Value_is_Double");
  }

  @Test
  public void test_EncodeEdgeAttributeToJsonString_Value_is_Integer() throws Exception {
    logger.info("[TEST] test_EncodeEdgeAttributeToJsonString_Value_is_Integer");
    String jsonString = EdgeJsonFormatter.encodeEdgeAttributeToJsonString(testEdgeAttributeInteger);
    EdgeAttribute result = EdgeJsonFormatter.decodeJsonStringToEdgeAttribute(jsonString);
    assertEquals(testEdgeAttributeInteger.getName(), result.getName());
    assertEquals(testEdgeAttributeInteger.getDataType(), result.getDataType());
    assertEquals(testEdgeAttributeInteger.getValue(), result.getValue());
    logger.info("[PASS] test_EncodeEdgeAttributeToJsonString_Value_is_Integer");
  }

  @Test
  public void test_EncodeEdgeAttributeToJsonString_Value_is_Float() throws Exception {
    logger.info("[TEST] test_EncodeEdgeAttributeToJsonString_Value_is_Float");
    String jsonString = EdgeJsonFormatter.encodeEdgeAttributeToJsonString(testEdgeAttributeFloat);
    EdgeAttribute result = EdgeJsonFormatter.decodeJsonStringToEdgeAttribute(jsonString);
    assertEquals(testEdgeAttributeFloat.getName(), result.getName());
    assertEquals(testEdgeAttributeFloat.getDataType(), result.getDataType());
    assertEquals(testEdgeAttributeFloat.getValue(), result.getValue());
    logger.info("[PASS] test_EncodeEdgeAttributeToJsonString_Value_is_Float");
  }

  @Test
  public void test_EncodeEdgeAttributeToJsonString_Value_is_AttributesHasAll() throws Exception {
    logger.info("[TEST] test_EncodeEdgeAttributeToJsonString_Value_is_AttributesHasAll");
    String jsonString =
        EdgeJsonFormatter.encodeEdgeAttributeToJsonString(testEdgeAttributeAttributesHasAll);
    EdgeAttribute result = EdgeJsonFormatter.decodeJsonStringToEdgeAttribute(jsonString);
    assertEquals(testEdgeAttributeAttributesHasAll.getName(), result.getName());
    assertEquals(testEdgeAttributeAttributesHasAll.getDataType(), result.getDataType());
    List<?> resultList = (List<?>) result.getValue();
    int edgeAttributeListSize = testEdgeAttributeListHasAll.size();
    for (int i = 0; i < edgeAttributeListSize; i++) {
      EdgeAttribute edgeAttribute = (EdgeAttribute) resultList.get(i);
      assertEquals(testEdgeAttributeListHasAll.get(i).getName(), edgeAttribute.getName());
      assertEquals(testEdgeAttributeListHasAll.get(i).getDataType(), edgeAttribute.getDataType());
      assertEquals(testEdgeAttributeListHasAll.get(i).getValue(), edgeAttribute.getValue());
    }
    logger.info("[PASS] test_EncodeEdgeAttributeToJsonString_Value_is_AttributesHasAll");
  }

  @Test
  public void test_EncodeEdgeAttributeToJsonString_Value_is_Attributes_Is_Empty() throws Exception {
    logger.info("[TEST] test_EncodeEdgeAttributeToJsonString_Value_is_Attributes_Is_Empty");
    String jsonString =
        EdgeJsonFormatter.encodeEdgeAttributeToJsonString(testEdgeAttributeAttributesIsEmpty);
    EdgeAttribute result = EdgeJsonFormatter.decodeJsonStringToEdgeAttribute(jsonString);
    assertEquals(testEdgeAttributeAttributesIsEmpty.getName(), result.getName());
    assertEquals(testEdgeAttributeAttributesIsEmpty.getDataType(), result.getDataType());
    List<?> resultList = (List<?>) result.getValue();
    int edgeAttributeListSize = testEdgeAttributeListIsEmpty.size();
    for (int i = 0; i < edgeAttributeListSize; i++) {
      EdgeAttribute edgeAttribute = (EdgeAttribute) resultList.get(i);
      assertEquals(testEdgeAttributeListHasAll.get(i).getName(), edgeAttribute.getName());
      assertEquals(testEdgeAttributeListHasAll.get(i).getDataType(), edgeAttribute.getDataType());
      assertEquals(testEdgeAttributeListHasAll.get(i).getValue(), edgeAttribute.getValue());
    }
    logger.info("[PASS] test_EncodeEdgeAttributeToJsonString_Value_is_Attributes_Is_Empty");
  }

  @Test
  public void test_EncodeEdgeAttributeToJsonString_Name_Is_Null() throws Exception {
    logger.info("[TEST] test_EncodeEdgeAttributeToJsonString_Name_Is_Null");
    String jsonString =
        EdgeJsonFormatter.encodeEdgeAttributeToJsonString(testEdgeAttributeNameIsNull);
    EdgeAttribute result = EdgeJsonFormatter.decodeJsonStringToEdgeAttribute(jsonString);
    assertEquals(result, null);
    logger.info("[PASS] test_EncodeEdgeAttributeToJsonString_Name_Is_Null");
  }

  @Test
  public void test_EncodeEdgeAttributeToJsonString_DataType_Is_Null() throws Exception {
    logger.info("[TEST] test_EncodeEdgeAttributeToJsonString_DataType_Is_Null");
    String jsonString =
        EdgeJsonFormatter.encodeEdgeAttributeToJsonString(testEdgeAttributeDataTypeIsNull);
    EdgeAttribute result = EdgeJsonFormatter.decodeJsonStringToEdgeAttribute(jsonString);
    assertEquals(result, null);
    logger.info("[PASS] test_EncodeEdgeAttributeToJsonString_DataType_Is_Null");
  }

  @Test
  public void test_EncodeEdgeAttributeToJsonString_Value_Is_Null() throws Exception {
    logger.info("[TEST] test_EncodeEdgeAttributeToJsonString_Value_Is_Null");
    String jsonString =
        EdgeJsonFormatter.encodeEdgeAttributeToJsonString(testEdgeAttributeValueIsNull);
    EdgeAttribute result = EdgeJsonFormatter.decodeJsonStringToEdgeAttribute(jsonString);
    assertEquals(result, null);
    logger.info("[PASS] test_EncodeEdgeAttributeToJsonString_Value_Is_Null");
  }


  @Test
  public void test_EncodeEdgeAttributeToJsonString_DataType_And_Value_Unmathch() throws Exception {
    logger.info("[TEST] test_EncodeEdgeAttributeToJsonString_DataType_And_Value_Unmathch");
    String jsonString =
        EdgeJsonFormatter.encodeEdgeAttributeToJsonString(testEdgeAttributeDataTypeAndValueUnmatch);
    EdgeAttribute result = EdgeJsonFormatter.decodeJsonStringToEdgeAttribute(jsonString);
    assertEquals(result, null);
    logger.info("[PASS] test_EncodeEdgeAttributeToJsonString_DataType_And_Value_Unmathch");
  }
}
