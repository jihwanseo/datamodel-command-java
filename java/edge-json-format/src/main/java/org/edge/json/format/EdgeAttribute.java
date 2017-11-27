package org.edge.json.format;

public class EdgeAttribute {
  private String name = null;
  private String dataType = null;
  private Object value = null;

  public EdgeAttribute(String name, String dataType, Object value) {
    this.name = name;
    this.dataType = dataType;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDataType() {
    return dataType;
  }

  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

}
