package org.command.json.format;

import java.util.List;

import com.google.gson.Gson;

public class EdgeJsonFormatter {
	private static Gson gson = new Gson();

	public static String encodeEdgeDataToJsonString(EdgeData edgeData) {
		return gson.toJson(edgeData);
	}

	public static EdgeData decodeJsonStringToEdgeData(String json) {
		return gson.fromJson(json, EdgeData.class);
	}

	public static Object getObjectValueByName(List<EdgeAttribute> edgeAttributeList, String edgeAttributeName) {
		for (EdgeAttribute edgeAttr : edgeAttributeList) {
			if (edgeAttr.getName().equals(edgeAttributeName) == true) {
				return edgeAttr.getValue();
			} else if (edgeAttr.getDataType().equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
				return getObjectValueByName((List<EdgeAttribute>) edgeAttr.getValue(), edgeAttributeName);
			}
		}
		return null;
	}

	public static String getStringValueByName(List<EdgeAttribute> edgeAttributeList, String edgeAttributeName) {
		for (EdgeAttribute edgeAttr : edgeAttributeList) {
			if (edgeAttr.getName().equals(edgeAttributeName) == true
					&& edgeAttr.getName().equalsIgnoreCase(EdgeFormatIdentifier.STRING_TYPE.getValue())) {
				return String.valueOf(edgeAttr.getValue());
			} else if (edgeAttr.getDataType().equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
				return getStringValueByName((List<EdgeAttribute>) edgeAttr.getValue(), edgeAttributeName);
			}
		}
		return null;
	}

	public static Double getDoubleValueByName(List<EdgeAttribute> edgeAttributeList, String edgeAttributeName) {
		for (EdgeAttribute edgeAttr : edgeAttributeList) {
			if (edgeAttr.getName().equals(edgeAttributeName) == true
					&& edgeAttr.getName().equalsIgnoreCase(EdgeFormatIdentifier.DOUBLE_TYPE.getValue())) {
				return (Double) edgeAttr.getValue();
			} else if (edgeAttr.getDataType().equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
				return getDoubleValueByName((List<EdgeAttribute>) edgeAttr.getValue(), edgeAttributeName);
			}
		}
		return -1.0;
	}

	public static Integer getIntegerValueByName(List<EdgeAttribute> edgeAttributeList, String edgeAttributeName) {
		for (EdgeAttribute edgeAttr : edgeAttributeList) {
			if (edgeAttr.getName().equals(edgeAttributeName) == true
					&& edgeAttr.getName().equalsIgnoreCase(EdgeFormatIdentifier.INTEGER_TYPE.getValue())) {
				return (Integer) edgeAttr.getValue();
			} else if (edgeAttr.getDataType().equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
				return getIntegerValueByName((List<EdgeAttribute>) edgeAttr.getValue(), edgeAttributeName);
			}
		}
		return -1;
	}

	public static float getFloatValueByName(List<EdgeAttribute> edgeAttributeList, String edgeAttributeName) {
		for (EdgeAttribute edgeAttr : edgeAttributeList) {
			if (edgeAttr.getName().equals(edgeAttributeName) == true
					&& edgeAttr.getName().equalsIgnoreCase(EdgeFormatIdentifier.FLOAT_TYPE.getValue())) {
				return (Float) edgeAttr.getValue();
			} else if (edgeAttr.getDataType().equals(EdgeFormatIdentifier.ATTRIBUTES_TYPE.getValue()) == true) {
				return getFloatValueByName((List<EdgeAttribute>) edgeAttr.getValue(), edgeAttributeName);
			}
		}
		return (float) 0.0;
	}
}
