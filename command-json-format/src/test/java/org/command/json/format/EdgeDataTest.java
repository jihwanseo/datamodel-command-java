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
import org.command.json.format.EdgeJsonFormatter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EdgeDataTest {
  private final Logger logger = LoggerFactory.getLogger(getClass());

  //for EdgeData construct test
  private static EdgeData testEdgeData = null;
  private static EdgeData testEdgeDataWithoutElements = null;
  //for EdgeData encode/decode test
  private static EdgeData testEdgeDataHasElements = null;
  private static EdgeData testEdgeDataElementsIsNull = null;
  private static EdgeData testEdgeDataVersionIsNull = null;
  private static EdgeData testEdgeDataDataTitleIsNull = null;
  private static EdgeData testEdgeDataElementIsEmpty = null;
  private static EdgeElement testEdgeElement = null;

  @BeforeClass
  public static void start() {
    testEdgeData = null;
    testEdgeDataWithoutElements = null;

    testEdgeElement = new EdgeElement(TestDefaultValue.ELEMENT_TITLE.getValue());
    testEdgeDataHasElements =
        new EdgeData(TestDefaultValue.VERSION.getValue(), TestDefaultValue.DATA_TITLE.getValue());
    testEdgeDataHasElements.getEdgeElementList().add(testEdgeElement);

    testEdgeDataElementsIsNull = new EdgeData(TestDefaultValue.VERSION.getValue(),
        TestDefaultValue.DATA_TITLE.getValue(), null);
    testEdgeDataVersionIsNull = new EdgeData(null, TestDefaultValue.DATA_TITLE.getValue());
    testEdgeDataDataTitleIsNull = new EdgeData(TestDefaultValue.VERSION.getValue(), null);
    testEdgeDataElementIsEmpty =
        new EdgeData(TestDefaultValue.VERSION.getValue(), TestDefaultValue.DATA_TITLE.getValue());
  }

  @AfterClass
  public static void stop() throws Exception {}

  @Test
  public void test_EdgeData_Construct() throws Exception {
    logger.info("[TEST] test_EdgeData_Construct");
    testEdgeData = new EdgeData(TestDefaultValue.VERSION.getValue(),
        TestDefaultValue.DATA_TITLE.getValue(), new ArrayList<EdgeElement>());
    assertNotNull(testEdgeData);
    logger.info("[PASS] test_EdgeData_Construct");
  }

  @Test
  public void test_EdgeElement_Construct_Without_EdgeAttributes() throws Exception {
    logger.info("[TEST] test_EdgeElement_Construct_Without_EdgeAttributes");
    testEdgeDataWithoutElements =
        new EdgeData(TestDefaultValue.VERSION.getValue(), TestDefaultValue.DATA_TITLE.getValue());
    assertNotNull(testEdgeDataWithoutElements);
    logger.info("[PASS] test_EdgeElement_Construct_Without_EdgeAttributes");
  }


  @Test
  public void test_EncodeEdgeDataToJsonString_Is_Null() throws Exception {
    logger.info("[TEST] test_EncodeEdgeDataToJsonString_Is_Null");
    String jsonString = EdgeJsonFormatter.encodeEdgeDataToJsonString(null);
    EdgeData result = EdgeJsonFormatter.decodeJsonStringToEdgeData(jsonString);
    assertEquals(result, null);
    logger.info("[PASS] test_EncodeEdgeDataToJsonString_Is_Null");
  }


  @Test
  public void test_EncodeEdgeDataToJsonString_Has_EdgeElements() throws Exception {
    logger.info("[TEST] test_EncodeEdgeDataToJsonString_Has_EdgeElements");
    String jsonString = EdgeJsonFormatter.encodeEdgeDataToJsonString(testEdgeDataHasElements);
    EdgeData result = EdgeJsonFormatter.decodeJsonStringToEdgeData(jsonString);
    assertEquals(testEdgeDataHasElements.getVersion(), result.getVersion());
    assertEquals(testEdgeDataHasElements.getDataTitle(), result.getDataTitle());
    assertEquals(testEdgeElement.getElementTitle(),
        result.getEdgeElementList().get(0).getElementTitle());
    logger.info("[PASS] test_EncodeEdgeDataToJsonString_Has_EdgeElements");
  }

  @Test
  public void test_EncodeEdgeDataToJsonString_EdgeElement_Is_Null() throws Exception {
    logger.info("[TEST] test_EncodeEdgeDataToJsonString_EdgeElement_Is_Null");
    String jsonString = EdgeJsonFormatter.encodeEdgeDataToJsonString(testEdgeDataElementsIsNull);
    EdgeData result = EdgeJsonFormatter.decodeJsonStringToEdgeData(jsonString);
    assertEquals(result, null);
    logger.info("[PASS] test_EncodeEdgeDataToJsonString_EdgeElement_Is_Null");
  }

  @Test
  public void test_EncodeEdgeDataToJsonString_EdgeElement_Is_Empty() throws Exception {
    logger.info("[TEST] test_EncodeEdgeDataToJsonString_EdgeElement_Is_Empty");
    String jsonString = EdgeJsonFormatter.encodeEdgeDataToJsonString(testEdgeDataElementIsEmpty);
    EdgeData result = EdgeJsonFormatter.decodeJsonStringToEdgeData(jsonString);
    assertEquals(testEdgeDataElementIsEmpty.getDataTitle(), result.getDataTitle());
    assertEquals(testEdgeDataElementIsEmpty.getVersion(), result.getVersion());
    assertTrue(result.getEdgeElementList().isEmpty());
    logger.info("[PASS] test_EncodeEdgeDataToJsonString_EdgeElement_Is_Empty");
  }

  @Test
  public void test_EncodeEdgeDatatToJsonString_DataTiTle_Is_Null() throws Exception {
    logger.info("[TEST] test_EncodeEdgeDatatToJsonString_DataTiTle_Is_Null");
    String jsonString = EdgeJsonFormatter.encodeEdgeDataToJsonString(testEdgeDataDataTitleIsNull);
    EdgeData result = EdgeJsonFormatter.decodeJsonStringToEdgeData(jsonString);
    assertEquals(result, null);
    logger.info("[PASS] test_EncodeEdgeDatatToJsonString_DataTiTle_Is_Null");
  }

  @Test
  public void test_EncodeEdgeDatatToJsonString_Version_Is_Null() throws Exception {
    logger.info("[TEST] test_EncodeEdgeDatatToJsonString_Version_Is_Null");
    String jsonString = EdgeJsonFormatter.encodeEdgeDataToJsonString(testEdgeDataVersionIsNull);
    EdgeData result = EdgeJsonFormatter.decodeJsonStringToEdgeData(jsonString);
    assertEquals(result, null);
    logger.info("[PASS] test_EncodeEdgeDatatToJsonString_Version_Is_Null");
  }
}
