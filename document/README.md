# Command Data Model #

## Basic Format ##

```
{
  "version" : A
  "dataTile" : B
  "edgeElements" : [
     {
       "elementTitle" : C
       "edgeAttributes" : [
          {
             "name" : D
             "dataType" : E
             "value" : F
          },
          ...
                          ]
     },
     ...
                   ]
}
```

## Example for OPCUA Device Service ##

### READ ###

1. Request
```
{
  "version" : "edge-1.0"
  "dataTile" : "opcua"
  "edgeElements" : [
     { 
       "elementTitle" : "read"
       "edgeAttributes" : [
          {
             "name" : "value_descriptor"
             "dataType" : "string"
             "value" : "temperature"
          }
                          ]
     }
                   ]
}
```

2. Response
```
{
  "version" : "edge-1.0"
  "dataTile" : "opcua"
  "edgeElements" : [
     {
       "elementTitle" : "read"
       "edgeAttributes" : [
          {
             "name" : "response_information"
             "dataType" : "attribute"
             "value" : [
                {
                    "name" : "value_descriptor"
                    "dataType" : "string"
                    "value" : "temperature"
                },
                {
                    "name" : "value"
                    "dataType" : "string"
                    "value" : "80F"
                }
          },
          {
             "name" : "result"
             "dataType" : "string"
             "value" : "edge_response_ok"
          }
                          ]
     }
                   ]
}
```

### WRITE ###

1. Request
```
{
  "version" : "edge-1.0"
  "dataTile" : "opcua"
  "edgeElements" : [
     { 
       "elementTitle" : "write"
       "edgeAttributes" : [
          {
             "name" : "value_descriptor"
             "dataType" : "string"
             "value" : "fan"
          },
          {
             "name" : "input_argument"
             "dataType" : "string"
             "value" : "off"
          }
                          ]
     }
                   ]
}
```

2. Response
```
{
  "version" : "edge-1.0"
  "dataTile" : "opcua"
  "edgeElements" : [
     {
       "elementTitle" : "write"
       "edgeAttributes" : [
          {
             "name" : "value_descriptor"
             "dataType" : "string"
             "value" : "fan"
          },
          {
             "name" : "result"
             "dataType" : "string"
             "value" : "edge_response_ok"
          }
                          ]
     }
                   ]
}
```

### SUBSCRIPTION ###

1. Request
```
{
  "version" : "edge-1.0"
  "dataTile" : "opcua"
  "edgeElements" : [
     { 
       "elementTitle" : "sub"
       "edgeAttributes" : [
          {
             "name" : "value_descriptor"
             "dataType" : "string"
             "value" : "temperature"
          },
          {
             "name" : "sampling_interval"
             "dataType" : "double"
             "value" : "1000.0"
          }
                          ]
     }
                   ]
}
```

2. Response
```
{
  "version" : "edge-1.0"
  "dataTile" : "opcua"
  "edgeElements" : [
     {
       "elementTitle" : "sub"
       "edgeAttributes" : [
          {
             "name" : "response_information"
             "dataType" : "attribute"
             "value" : [
                {
                    "name" : "value_descriptor"
                    "dataType" : "string"
                    "value" : "temperature"
                },
                {
                    "name" : "revised_sample_interval"
                    "dataType" : "double"
                    "value" : "1000.0"
                }
          },
          {
             "name" : "result"
             "dataType" : "string"
             "value" : "edge_response_ok"
          }
                          ]
     }
                   ]
}
```
