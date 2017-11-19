package com.dhruvesh.xml2json;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;

public class XML2JSONRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:marshalEmployeexml2json")
                .to("log:?level=INFO&showBody=true")
                .marshal().xmljson()
                .to("log:?level=INFO&showBody=true");


        final XmlJsonDataFormat xmlJsonFormat = new XmlJsonDataFormat();
        xmlJsonFormat.setRootName("Employee");

        from("direct:unMarshalEmployeejson2xml")
                //.unmarshal().xmljson()
                .unmarshal(xmlJsonFormat)
                .to("log:?level=INFO&showBody=true");

    }

}