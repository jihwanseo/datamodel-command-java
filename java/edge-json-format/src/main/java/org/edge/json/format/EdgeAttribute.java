package org.edge.json.format;

public class EdgeAttribute {
  private String name = null;
  private String data_type = null;
  private Object value = null;

  public EdgeAttribute(String name, String data_type, Object value) {
    this.name = name;
    this.data_type = data_type;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getData_type() {
    return data_type;
  }

  public void setData_type(String data_type) {
    this.data_type = data_type;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
