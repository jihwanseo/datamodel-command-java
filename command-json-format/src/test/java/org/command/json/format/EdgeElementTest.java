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

public class EdgeElementTest {
  private final Logger logger = LoggerFactory.getLogger(getClass());

  //for EdgeElement construct test
  private static EdgeElement testEdgeElement = null;
  private static EdgeElement testEdgeElementWithoutAttributes = null;

  //for EdgeElement encode/decode test
  private static EdgeElement testEdgeElementHasAttributes = null;
  private static EdgeElement testEdgeElementAttributesIsNull = null;
  private static EdgeElement testEdgeElementElementTitleIsNull = null;
  private static EdgeElement testEdgeElementAttributesIsEmpty = null;
  private static EdgeAttribute testEdgeAttribute = null;

  @BeforeClass
  public static void start() {
    testEdgeElement = null;
    testEdgeElementWithoutAttributes = null;

    testEdgeAttribute = new EdgeAttribute(TestDefaultValue.STRING_NAME.getValue(),
        EdgeFormatIdentifier.STRING_TYPE.getValue(), TestDefaultValue.STRING_VALUE);
    testEdgeElementHasAttributes = new EdgeElement(TestDefaultValue.ELEMENT_TITLE.getValue());
    testEdgeElementHasAttributes.getEdgeAttributeList().add(testEdgeAttribute);

    testEdgeElementAttributesIsNull =
        new EdgeElement(TestDefaultValue.ELEMENT_TITLE.getValue(), null);
    testEdgeElementElementTitleIsNull = new EdgeElement(null);
    testEdgeElementAttributesIsEmpty = new EdgeElement(TestDefaultValue.ELEMENT_TITLE.getValue());
  }

  @AfterClass
  public static void stop() throws Exception {}

  @Test
  public void test_EdgeElement_Construct() throws Exception {
    logger.info("[TEST] test_EdgeElement_Construct");
    testEdgeElement =
        new EdgeElement(TestDefaultValue.ELEMENT_TITLE.getValue(), new ArrayList<EdgeAttribute>());
    assertNotNull(testEdgeElement);
    logger.info("[PASS] test_EdgeElement_Construct");
  }

  @Test
  public void test_EdgeElement_Construct_Without_EdgeAttributes() throws Exception {
    logger.info("[TEST] test_EdgeElement_Construct_Without_EdgeAttributes");
    testEdgeElementWithoutAttributes = new EdgeElement(TestDefaultValue.ELEMENT_TITLE.getValue());
    assertNotNull(testEdgeElementWithoutAttributes);
    logger.info("[PASS] test_EdgeElement_Construct_Without_EdgeAttributes");
  }


  @Test
  public void test_EncodeEdgeElementToJsonString_Is_Null() throws Exception {
    logger.info("[TEST] test_EncodeEdgeElementToJsonString_Is_Null");
    String jsonString = EdgeJsonFormatter.encodeEdgeElementToJsonString(null);
    EdgeElement result = EdgeJsonFormatter.decodeJsonStringToEdgeElement(jsonString);
    assertEquals(result, null);
    logger.info("[PASS] test_EncodeEdgeElementToJsonString_Is_Null");
  }


  @Test
  public void test_EncodeEdgeElementToJsonString_Has_EdgeAttribute() throws Exception {
    logger.info("[TEST] test_EncodeEdgeElementToJsonString_Has_EdgeAttribute");
    String jsonString =
        EdgeJsonFormatter.encodeEdgeElementToJsonString(testEdgeElementHasAttributes);
    EdgeElement result = EdgeJsonFormatter.decodeJsonStringToEdgeElement(jsonString);
    assertEquals(testEdgeElementHasAttributes.getElementTitle(), result.getElementTitle());
    assertEquals(testEdgeAttribute.getName(), result.getEdgeAttributeList().get(0).getName());
    assertEquals(testEdgeAttribute.getDataType(),
        result.getEdgeAttributeList().get(0).getDataType());
    assertEquals(testEdgeAttribute.getValue(), result.getEdgeAttributeList().get(0).getValue());
    logger.info("[PASS] test_EncodeEdgeElementToJsonString_Has_EdgeAttribute");
  }

  @Test
  public void test_EncodeEdgeElementToJsonString_EdgeAttribute_Is_Null() throws Exception {
    logger.info("[TEST] test_EncodeEdgeElementToJsonString_EdgeAttribute_Is_Null");
    String jsonString =
        EdgeJsonFormatter.encodeEdgeElementToJsonString(testEdgeElementAttributesIsNull);
    EdgeElement result = EdgeJsonFormatter.decodeJsonStringToEdgeElement(jsonString);
    assertEquals(result, null);
    logger.info("[PASS] test_EncodeEdgeElementToJsonString_EdgeAttribute_Is_Null");
  }

  @Test
  public void test_EncodeEdgeElementToJsonString_EdgeAttribute_Is_Empty() throws Exception {
    logger.info("[TEST] test_EncodeEdgeElementToJsonString_EdgeAttribute_Is_Empty");
    String jsonString =
        EdgeJsonFormatter.encodeEdgeElementToJsonString(testEdgeElementAttributesIsEmpty);
    EdgeElement result = EdgeJsonFormatter.decodeJsonStringToEdgeElement(jsonString);
    assertEquals(testEdgeElementAttributesIsEmpty.getElementTitle(), result.getElementTitle());
    assertTrue(result.getEdgeAttributeList().isEmpty());
    logger.info("[PASS] test_EncodeEdgeElementToJsonString_EdgeAttribute_Is_Empty");
  }

  @Test
  public void test_EncodeEdgeElementToJsonString_ElementTiTle_Is_Null() throws Exception {
    logger.info("[TEST] test_EncodeEdgeElementToJsonString_ElementTiTle_Is_Null");
    String jsonString =
        EdgeJsonFormatter.encodeEdgeElementToJsonString(testEdgeElementElementTitleIsNull);
    EdgeElement result = EdgeJsonFormatter.decodeJsonStringToEdgeElement(jsonString);
    assertEquals(result, null);
    logger.info("[PASS] test_EncodeEdgeElementToJsonString_ElementTiTle_Is_Null");
  }
}
