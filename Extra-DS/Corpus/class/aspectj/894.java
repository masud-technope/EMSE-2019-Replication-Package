package com.nwalsh.xalan;

import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.SAXException;
import org.w3c.dom.*;
import org.apache.xml.utils.DOMBuilder;
import com.nwalsh.xalan.Callout;
import org.apache.xml.utils.AttList;

public class FormatGraphicCallout extends FormatCallout {

    String graphicsPath = "";

    String graphicsExt = "";

    int graphicsMax = 0;

    public  FormatGraphicCallout(String path, String ext, int max, boolean fo) {
        graphicsPath = path;
        graphicsExt = ext;
        graphicsMax = max;
        stylesheetFO = fo;
    }

    public void formatCallout(DOMBuilder rtf, Callout callout) {
        Element area = callout.getArea();
        int num = callout.getCallout();
        String label = areaLabel(area);
        try {
            if (label == null && num <= graphicsMax) {
                AttributesImpl imgAttr = new AttributesImpl();
                String ns = "";
                String prefix = "";
                String imgName = "";
                if (stylesheetFO) {
                    ns = foURI;
                    // FIXME: this could be a problem...
                    prefix = "fo:";
                    imgName = "external-graphic";
                    imgAttr.addAttribute("", "src", "src", "CDATA", graphicsPath + num + graphicsExt);
                    imgAttr.addAttribute("", "alt", "alt", "CDATA", label);
                } else {
                    ns = "";
                    prefix = "";
                    imgName = "img";
                    imgAttr.addAttribute("", "src", "src", "CDATA", graphicsPath + num + graphicsExt);
                    imgAttr.addAttribute("", "alt", "alt", "CDATA", label);
                }
                startSpan(rtf);
                rtf.startElement(ns, imgName, prefix + imgName, imgAttr);
                rtf.endElement(ns, imgName, prefix + imgName);
                endSpan(rtf);
            } else {
                formatTextCallout(rtf, callout);
            }
        } catch (SAXException e) {
            System.out.println("SAX Exception in graphics formatCallout");
        }
    }
}
