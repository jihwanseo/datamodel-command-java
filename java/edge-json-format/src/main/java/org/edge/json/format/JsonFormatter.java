package org.edge.json.format;

import com.google.gson.Gson;

public class JsonFormatter {
  private static Gson gson = new Gson();

  public static String encodeEdgeDataToJsonString(EdgeData edgeData) {
    return gson.toJson(edgeData);
  }

  public static EdgeData decodeJsonStringToEdgeData(String json) {
    return gson.fromJson(json, EdgeData.class);
  }
}
