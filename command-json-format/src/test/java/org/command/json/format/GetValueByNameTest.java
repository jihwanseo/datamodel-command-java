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
import org.command.json.format.EdgeData;
import org.command.json.format.EdgeJsonFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetValueByNameTest {
  private final Logger logger = LoggerFactory.getLogger(getClass());

  private static EdgeAttribute testEdgeAttributeString = null;
  private static EdgeAttribute testEdgeAttributeDouble = null;
  private static EdgeAttribute testEdgeAttributeInteger = null;
  private static EdgeAttribute testEdgeAttributeFloat = null;
  private static EdgeAttribute testEdgeAttributeAttributesHasAll = null;
  private static EdgeAttribute testEdgeAttributeAttributesIsEmpty = null;


  private static final String NO_NAME = "no_name";
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

  private static final List<EdgeAttribute> testEdgeAttributeListIsEmpty =
      new ArrayList<EdgeAttribute>();
  private static List<EdgeAttribute> testEdgeAttributeListHasAll = null;

  @BeforeClass
  public static void start() {
    testEdgeAttributeString = new EdgeAttribute(STRING_NAME, STRING_DATATYPE, STRING_VALUE);
    testEdgeAttributeDouble = new EdgeAttribute(DOUBLE_NAME, DOUBLE_DATATYPE, DOUBLE_VALUE);
    testEdgeAttributeInteger = new EdgeAttribute(INTEGER_NAME, INTEGER_DATATYPE, INTEGER_VALUE);
    testEdgeAttributeFloat = new EdgeAttribute(FLOAT_NAME, FLOAT_DATATYPE, FLOAT_VALUE);

    testEdgeAttributeListHasAll = Arrays.asList(testEdgeAttributeString, testEdgeAttributeDouble,
        testEdgeAttributeInteger, testEdgeAttributeFloat);
  }

  @AfterClass
  public static void stop() throws Exception {}

  @Test
  public void test_getObjectValueByName() throws Exception {
    logger.info("[TEST] test_getObjectValueByName");
    Object value = EdgeJsonFormatter.getObjectValueByName(testEdgeAttributeListHasAll, STRING_NAME);
    assertNotNull(value);
    logger.info("[PASS] test_getObjectValueByName");
  }

  @Test
  public void test_getObjectValueByName_Name_Is_Null() throws Exception {
    logger.info("[TEST] test_getObjectValueByName_Name_Is_Null");
    Object value = EdgeJsonFormatter.getObjectValueByName(testEdgeAttributeListHasAll, null);
    assertEquals(value, null);
    logger.info("[PASS] test_getObjectValueByName_Name_Is_Null");
  }

  @Test
  public void test_getObjectValueByName_List_Is_Null() throws Exception {
    logger.info("[TEST] test_getObjectValueByName_List_Is_Null");
    Object value = EdgeJsonFormatter.getObjectValueByName(null, STRING_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getObjectValueByName_List_Is_Null");
  }

  @Test
  public void test_getObjectValueByName_List_Is_Empty() throws Exception {
    logger.info("[TEST] test_getObjectValueByName_List_Is_Empty");
    Object value =
        EdgeJsonFormatter.getObjectValueByName(testEdgeAttributeListIsEmpty, STRING_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getObjectValueByName_List_Is_Empty");
  }

  @Test
  public void test_getObjectValueByName_Name_is_unmatched() throws Exception {
    logger.info("[TEST] test_getObjectValueByName_Name_is_unmatched");
    Object value = EdgeJsonFormatter.getObjectValueByName(testEdgeAttributeListHasAll, NO_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getObjectValueByName_Name_is_unmatched");
  }

  @Test
  public void test_getStringValueByName() throws Exception {
    logger.info("[TEST] test_getStringValueByName");
    System.out.println(testEdgeAttributeListHasAll);
    String value = EdgeJsonFormatter.getStringValueByName(testEdgeAttributeListHasAll, STRING_NAME);
    assertEquals(STRING_VALUE, value);
    logger.info("[PASS] test_getStringValueByName");
  }

  @Test
  public void test_getStringValueByName_Name_Is_Null() throws Exception {
    logger.info("[TEST] test_getStringValueByName_Name_Is_Null");
    String value = EdgeJsonFormatter.getStringValueByName(testEdgeAttributeListHasAll, null);
    assertEquals(value, null);
    logger.info("[PASS] test_getStringValueByName_Name_Is_Null");
  }

  @Test
  public void test_getStringValueByName_List_Is_Null() throws Exception {
    logger.info("[TEST] test_getStringValueByName_List_Is_Null");
    String value = EdgeJsonFormatter.getStringValueByName(null, STRING_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getStringValueByName_List_Is_Null");
  }

  @Test
  public void test_getStringValueByName_List_Is_Empty() throws Exception {
    logger.info("[TEST] test_getStringValueByName_List_Is_Empty");
    String value =
        EdgeJsonFormatter.getStringValueByName(testEdgeAttributeListIsEmpty, STRING_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getStringValueByName_List_Is_Empty");
  }

  @Test
  public void test_getStringValueByName_is_unmatched() throws Exception {
    logger.info("[TEST] test_getStringValueByName_is_unmatched");
    String value = EdgeJsonFormatter.getStringValueByName(testEdgeAttributeListHasAll, NO_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getStringValueByName_is_unmatched");
  }
  
  @Test
  public void test_getDoubleValueByName() throws Exception {
    logger.info("[TEST] test_getDoubleValueByName");
    System.out.println(testEdgeAttributeListHasAll);
    Double value = EdgeJsonFormatter.getDoubleValueByName(testEdgeAttributeListHasAll, DOUBLE_NAME);
    assertEquals(DOUBLE_VALUE, value);
    logger.info("[PASS] test_getDoubleValueByName");
  }

  @Test
  public void test_getDoubleValueByName_Name_Is_Null() throws Exception {
    logger.info("[TEST] test_getDoubleValueByName_Name_Is_Null");
    Double value = EdgeJsonFormatter.getDoubleValueByName(testEdgeAttributeListHasAll, null);
    assertEquals(value, null);
    logger.info("[PASS] test_getDoubleValueByName_Name_Is_Null");
  }

  @Test
  public void test_getDoubleValueByName_List_Is_Null() throws Exception {
    logger.info("[TEST] test_getDoubleValueByName_List_Is_Null");
    Double value = EdgeJsonFormatter.getDoubleValueByName(null, DOUBLE_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getDoubleValueByName_List_Is_Null");
  }

  @Test
  public void test_getDoubleValueByName_List_Is_Empty() throws Exception {
    logger.info("[TEST] test_getDoubleValueByName_List_Is_Empty");
    Double value =
        EdgeJsonFormatter.getDoubleValueByName(testEdgeAttributeListIsEmpty, DOUBLE_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getDoubleValueByName_List_Is_Empty");
  }

  @Test
  public void test_getDoubleValueByName_is_unmatched() throws Exception {
    logger.info("[TEST] test_getDoubleValueByName_is_unmatched");
    Double value = EdgeJsonFormatter.getDoubleValueByName(testEdgeAttributeListHasAll, NO_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getDoubleValueByName_is_unmatched");
  }

  @Test
  public void test_getFloatValueByName() throws Exception {
    logger.info("[TEST] test_getFloatValueByName");
    System.out.println(testEdgeAttributeListHasAll);
    Float value = EdgeJsonFormatter.getFloatValueByName(testEdgeAttributeListHasAll, FLOAT_NAME);
    assertEquals(FLOAT_VALUE, value);
    logger.info("[PASS] test_getFloatValueByName");
  }

  @Test
  public void test_getFloatValueByName_Name_Is_Null() throws Exception {
    logger.info("[TEST] test_getFloatValueByName_Name_Is_Null");
    Float value = EdgeJsonFormatter.getFloatValueByName(testEdgeAttributeListHasAll, null);
    assertEquals(value, null);
    logger.info("[PASS] test_getFloatValueByName_Name_Is_Null");
  }

  @Test
  public void test_getFloatValueByName_List_Is_Null() throws Exception {
    logger.info("[TEST] test_getFloatValueByName_List_Is_Null");
    Float value = EdgeJsonFormatter.getFloatValueByName(null, FLOAT_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getFloatValueByName_List_Is_Null");
  }

  @Test
  public void test_getFloatValueByName_List_Is_Empty() throws Exception {
    logger.info("[TEST] test_getFloatValueByName_List_Is_Empty");
    Float value =
        EdgeJsonFormatter.getFloatValueByName(testEdgeAttributeListIsEmpty, FLOAT_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getFloatValueByName_List_Is_Empty");
  }

  @Test
  public void test_getFloatValueByName_is_unmatched() throws Exception {
    logger.info("[TEST] test_getFloatValueByName_is_unmatched");
    Float value = EdgeJsonFormatter.getFloatValueByName(testEdgeAttributeListHasAll, NO_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getFloatValueByName_is_unmatched");
  }

  @Test
  public void test_getIntegerValueByName() throws Exception {
    logger.info("[TEST] test_getIntegerValueByName");
    System.out.println(testEdgeAttributeListHasAll);
    Integer value = EdgeJsonFormatter.getIntegerValueByName(testEdgeAttributeListHasAll, INTEGER_NAME);
    assertEquals(INTEGER_VALUE, value);
    logger.info("[PASS] test_getIntegerValueByName");
  }

  @Test
  public void test_getIntegerValueByName_Name_Is_Null() throws Exception {
    logger.info("[TEST] test_getIntegerValueByName_Name_Is_Null");
    Integer value = EdgeJsonFormatter.getIntegerValueByName(testEdgeAttributeListHasAll, null);
    assertEquals(value, null);
    logger.info("[PASS] test_getIntegerValueByName_Name_Is_Null");
  }

  @Test
  public void test_getIntegerValueByName_List_Is_Null() throws Exception {
    logger.info("[TEST] test_getIntegerValueByName_List_Is_Null");
    Integer value = EdgeJsonFormatter.getIntegerValueByName(null, INTEGER_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getIntegerValueByName_List_Is_Null");
  }

  @Test
  public void test_getIntegerValueByName_List_Is_Empty() throws Exception {
    logger.info("[TEST] test_getIntegerValueByName_List_Is_Empty");
    Integer value =
        EdgeJsonFormatter.getIntegerValueByName(testEdgeAttributeListIsEmpty, INTEGER_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getIntegerValueByName_List_Is_Empty");
  }

  @Test
  public void test_getIntegerValueByName_is_unmatched() throws Exception {
    logger.info("[TEST] test_getIntegerValueByName_is_unmatched");
    Integer value = EdgeJsonFormatter.getIntegerValueByName(testEdgeAttributeListHasAll, NO_NAME);
    assertEquals(value, null);
    logger.info("[PASS] test_getIntegerValueByName_is_unmatched");
  }

}
