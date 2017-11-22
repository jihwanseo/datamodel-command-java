package org.edge.json.format;

import java.util.ArrayList;

public class EdgeData {
  private static final String DEFAULT_VERSION = "json-1.0";
  private String version = null;
  private ArrayList<EdgeElement> edgeElements = null;
  
  public EdgeData(String version, ArrayList<EdgeElement> edgeElements){
    this.version = version;
    this.edgeElements = edgeElements; 
  }
  
  public EdgeData(String version){
    this.version = version;
    edgeElements = new ArrayList<EdgeElement>();
  }
  
  public EdgeData(ArrayList<EdgeElement> edgeElements){
    this.version = DEFAULT_VERSION;
    this.edgeElements = edgeElements;
  }
  
  public EdgeData(EdgeElement edgeElement){
    this.version = DEFAULT_VERSION;
    edgeElements = new ArrayList<EdgeElement>();
    edgeElements.add(edgeElement);
  }
  
  public EdgeData(String version, EdgeElement edgeElement){
    this.version = version;
    edgeElements = new ArrayList<EdgeElement>();
    edgeElements.add(edgeElement);
  }
  
  public EdgeData(){
    this.version = DEFAULT_VERSION;
    edgeElements = new ArrayList<EdgeElement>();
  }
  
  public void setVersion(String version){
    this.version = version;
  }
  
  public String getVersion(){
    return version;
  }
  
  public void setEdgeElementList(ArrayList<EdgeElement> edgeElements){
    this.edgeElements = edgeElements;
  }
  
  public ArrayList<EdgeElement> getEdgeElementList(){
    return edgeElements;
  }

  public void addEdgeElement(EdgeElement edgeElement){
    edgeElements.add(edgeElement);
  }
}
