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

public class GetValueByNameTest {
  private final Logger logger = LoggerFactory.getLogger(getClass());

  private static EdgeAttribute testEdgeAttributeString = null;
  private static EdgeAttribute testEdgeAttributeDouble = null;
  private static EdgeAttribute testEdgeAttributeInteger = null;
  private static EdgeAttribute testEdgeAttributeFloat = null;
  private static EdgeAttribute testEdgeAttributeAttributes = null;

  private static List<EdgeAttribute> testEdgeAttributeListIsEmpty = null;
  private static List<EdgeAttribute> testEdgeAttributeListHasAll = null;

  @BeforeClass
  public static void start() {
    testEdgeAttributeString = new EdgeAttribute(TestDefaultValue.STRING_NAME.getValue(),
        EdgeFormatIdentifier.STRING_TYPE.getValue(), TestDefaultValue.STRING_VALUE);
    testEdgeAttributeDouble = new EdgeAttribute(TestDefaultValue.DOUBLE_NAME.getValue(),
        EdgeFormatIdentifier.DOUBLE_TYPE.getValue(), TestDefaultValue.DOUBLE_VALUE);
    testEdgeAttributeInteger = new EdgeAttribute(TestDefaultValue.INTEGER_NAME.getValue(),
        EdgeFormatIdentifier.INTEGER_TYPE.getValue(), TestDefaultValue.INTEGER_VALUE);
    testEdgeAttributeFloat = new EdgeAttribute(TestDefaultValue.FLOAT_NAME.getValue(),
        EdgeFormatIdentifier.FLOAT_TYPE.getValue(), TestDefaultValue.FLOAT_VALUE);
    testEdgeAttributeAttributes = new EdgeAttribute(TestDefaultValue.ATTRIBUTES_NAME.getValue(),
        EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue(),
        Arrays.asList(testEdgeAttributeInteger, testEdgeAttributeFloat));

    testEdgeAttributeListHasAll = Arrays.asList(testEdgeAttributeString, testEdgeAttributeDouble,
        testEdgeAttributeAttributes);
    testEdgeAttributeListIsEmpty = new ArrayList<EdgeAttribute>();
  }

  @AfterClass
  public static void stop() throws Exception {}

  @Test
  public void test_getObjectValueByName() throws Exception {
    logger.info("[TEST] test_getObjectValueByName");
    Object value = EdgeJsonFormatter.getObjectValueByName(testEdgeAttributeListHasAll,
        TestDefaultValue.STRING_NAME.getValue());
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
    Object value =
        EdgeJsonFormatter.getObjectValueByName(null, TestDefaultValue.STRING_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getObjectValueByName_List_Is_Null");
  }

  @Test
  public void test_getObjectValueByName_List_Is_Empty() throws Exception {
    logger.info("[TEST] test_getObjectValueByName_List_Is_Empty");
    Object value = EdgeJsonFormatter.getObjectValueByName(testEdgeAttributeListIsEmpty,
        TestDefaultValue.STRING_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getObjectValueByName_List_Is_Empty");
  }

  @Test
  public void test_getObjectValueByName_Name_is_unmatched() throws Exception {
    logger.info("[TEST] test_getObjectValueByName_Name_is_unmatched");
    Object value = EdgeJsonFormatter.getObjectValueByName(testEdgeAttributeListHasAll,
        TestDefaultValue.UNMATCHED_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getObjectValueByName_Name_is_unmatched");
  }

  @Test
  public void test_getStringValueByName() throws Exception {
    logger.info("[TEST] test_getStringValueByName");
    String value = EdgeJsonFormatter.getStringValueByName(testEdgeAttributeListHasAll,
        TestDefaultValue.STRING_NAME.getValue());
    assertEquals(TestDefaultValue.STRING_VALUE, value);
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
    String value =
        EdgeJsonFormatter.getStringValueByName(null, TestDefaultValue.STRING_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getStringValueByName_List_Is_Null");
  }

  @Test
  public void test_getStringValueByName_List_Is_Empty() throws Exception {
    logger.info("[TEST] test_getStringValueByName_List_Is_Empty");
    String value = EdgeJsonFormatter.getStringValueByName(testEdgeAttributeListIsEmpty,
        TestDefaultValue.STRING_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getStringValueByName_List_Is_Empty");
  }

  @Test
  public void test_getStringValueByName_is_unmatched() throws Exception {
    logger.info("[TEST] test_getStringValueByName_is_unmatched");
    String value = EdgeJsonFormatter.getStringValueByName(testEdgeAttributeListHasAll,
        TestDefaultValue.UNMATCHED_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getStringValueByName_is_unmatched");
  }

  @Test
  public void test_getDoubleValueByName() throws Exception {
    logger.info("[TEST] test_getDoubleValueByName");
    Double value = EdgeJsonFormatter.getDoubleValueByName(testEdgeAttributeListHasAll,
        TestDefaultValue.DOUBLE_NAME.getValue());
    assertEquals(TestDefaultValue.DOUBLE_VALUE, value);
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
    Double value =
        EdgeJsonFormatter.getDoubleValueByName(null, TestDefaultValue.DOUBLE_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getDoubleValueByName_List_Is_Null");
  }

  @Test
  public void test_getDoubleValueByName_List_Is_Empty() throws Exception {
    logger.info("[TEST] test_getDoubleValueByName_List_Is_Empty");
    Double value = EdgeJsonFormatter.getDoubleValueByName(testEdgeAttributeListIsEmpty,
        TestDefaultValue.DOUBLE_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getDoubleValueByName_List_Is_Empty");
  }

  @Test
  public void test_getDoubleValueByName_is_unmatched() throws Exception {
    logger.info("[TEST] test_getDoubleValueByName_is_unmatched");
    Double value = EdgeJsonFormatter.getDoubleValueByName(testEdgeAttributeListHasAll,
        TestDefaultValue.UNMATCHED_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getDoubleValueByName_is_unmatched");
  }

  @Test
  public void test_getFloatValueByName() throws Exception {
    logger.info("[TEST] test_getFloatValueByName");
    Float value = EdgeJsonFormatter.getFloatValueByName(testEdgeAttributeListHasAll,
        TestDefaultValue.FLOAT_NAME.getValue());
    assertEquals(TestDefaultValue.FLOAT_VALUE, value);
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
    Float value =
        EdgeJsonFormatter.getFloatValueByName(null, TestDefaultValue.FLOAT_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getFloatValueByName_List_Is_Null");
  }

  @Test
  public void test_getFloatValueByName_List_Is_Empty() throws Exception {
    logger.info("[TEST] test_getFloatValueByName_List_Is_Empty");
    Float value = EdgeJsonFormatter.getFloatValueByName(testEdgeAttributeListIsEmpty,
        TestDefaultValue.FLOAT_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getFloatValueByName_List_Is_Empty");
  }

  @Test
  public void test_getFloatValueByName_is_unmatched() throws Exception {
    logger.info("[TEST] test_getFloatValueByName_is_unmatched");
    Float value = EdgeJsonFormatter.getFloatValueByName(testEdgeAttributeListHasAll,
        TestDefaultValue.UNMATCHED_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getFloatValueByName_is_unmatched");
  }

  @Test
  public void test_getIntegerValueByName() throws Exception {
    logger.info("[TEST] test_getIntegerValueByName");
    Integer value = EdgeJsonFormatter.getIntegerValueByName(testEdgeAttributeListHasAll,
        TestDefaultValue.INTEGER_NAME.getValue());
    assertEquals(TestDefaultValue.INTEGER_VALUE, value);
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
    Integer value =
        EdgeJsonFormatter.getIntegerValueByName(null, TestDefaultValue.INTEGER_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getIntegerValueByName_List_Is_Null");
  }

  @Test
  public void test_getIntegerValueByName_List_Is_Empty() throws Exception {
    logger.info("[TEST] test_getIntegerValueByName_List_Is_Empty");
    Integer value = EdgeJsonFormatter.getIntegerValueByName(testEdgeAttributeListIsEmpty,
        TestDefaultValue.INTEGER_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getIntegerValueByName_List_Is_Empty");
  }

  @Test
  public void test_getIntegerValueByName_is_unmatched() throws Exception {
    logger.info("[TEST] test_getIntegerValueByName_is_unmatched");
    Integer value = EdgeJsonFormatter.getIntegerValueByName(testEdgeAttributeListHasAll,
        TestDefaultValue.UNMATCHED_NAME.getValue());
    assertEquals(value, null);
    logger.info("[PASS] test_getIntegerValueByName_is_unmatched");
  }

}
