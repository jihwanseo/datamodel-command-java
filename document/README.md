# Command Data Model #

## Basic Format ##

{<br></br>
  "version" : A<br></br>
  "dataTile" : B<br></br>
  "edgeElements" : [<br></br>
     { <br></br>
       "elementTitle" : C<br></br>
       "edgeAttributes" : [<br></br>
          { <br></br>
             "name" : D<br></br>
             "dataType" : E<br></br>
             "value" : F<br></br>
          },<br></br>
          ...<br></br>
                          ]<br></br>
     },<br></br>
     ...<br></br>
                   ]<br></br>
}<br></br>

## Example for OPCUA Device Service ##

### READ ###

1. Request
{<br></br>
  "version" : "edge-1.0"<br></br>
  "dataTile" : "opcua"<br></br>
  "edgeElements" : [<br></br>
     { <br></br>
       "elementTitle" : "read"<br></br>
       "edgeAttributes" : [<br></br>
          { <br></br>
             "name" : "value_descriptor"<br></br>
             "dataType" : "string"<br></br>
             "value" : "temperature"<br></br>
          }<br></br>
                          ]<br></br>
     }<br></br>
                   ]<br></br>
}<br></br>
<br></br>
2. Response
{<br></br>
  "version" : "edge-1.0"<br></br>
  "dataTile" : "opcua"<br></br>
  "edgeElements" : [<br></br>
     { <br></br>
       "elementTitle" : "read"<br></br>
       "edgeAttributes" : [<br></br>
          { <br></br>
             "name" : "response_information"<br></br>
             "dataType" : "attribute"<br></br>
             "value" : [<br></br>
                {<br></br>
                    "name" : "value_descriptor"<br></br>
                    "dataType" : "string"<br></br>
                    "value" : "temperature"<br></br>
                },<br></br>
                {<br></br>
                    "name" : "value"<br></br>
                    "dataType" : "string"<br></br>
                    "value" : "80F"<br></br>
                }<br></br>
          },<br></br>
          {<br></br>
             "name" : "result"<br></br>
             "dataType" : "string"<br></br>
             "value" : "edge_response_ok"<br></br>
          }<br></br>
                          ]<br></br>
     }<br></br>
                   ]<br></br>
}<br></br>

