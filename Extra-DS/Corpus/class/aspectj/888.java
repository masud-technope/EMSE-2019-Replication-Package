package com.nwalsh.xalan;

import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.SAXException;
import org.w3c.dom.*;
import org.apache.xml.utils.DOMBuilder;
import com.nwalsh.xalan.Callout;
import org.apache.xml.utils.AttList;

public class FormatDingbatCallout extends FormatCallout {

    int graphicsMax = 0;

    public  FormatDingbatCallout(int max, boolean fo) {
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
                    imgName = "inline";
                    imgAttr.addAttribute("", "font-family", "font-family", "CDATA", "ZapfDingbats");
                } else {
                    ns = "";
                    prefix = "";
                    imgName = "font";
                    imgAttr.addAttribute("", "face", "face", "CDATA", "ZapfDingbats");
                }
                startSpan(rtf);
                rtf.startElement(ns, imgName, prefix + imgName, imgAttr);
                char chars[] = new char[1];
                chars[0] = (char) (0x2775 + num);
                rtf.characters(chars, 0, 1);
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
