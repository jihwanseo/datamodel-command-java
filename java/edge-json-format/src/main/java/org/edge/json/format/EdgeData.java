package org.edge.json.format;

import java.util.ArrayList;

public class EdgeData {
  private String version = "json-1.0";
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
    this.edgeElements = edgeElements;
  }
  
  public EdgeData(EdgeElement edgeElement){
    edgeElements = new ArrayList<EdgeElement>();
    edgeElements.add(edgeElement);
  }
  
  public EdgeData(String version, EdgeElement edgeElement){
    this.version = version;
    edgeElements = new ArrayList<EdgeElement>();
    edgeElements.add(edgeElement);
  }
  
  public EdgeData(){
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
