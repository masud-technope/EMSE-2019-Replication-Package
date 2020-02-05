package com.nwalsh.xalan;

import org.xml.sax.SAXException;
import org.w3c.dom.*;
import org.apache.xml.utils.DOMBuilder;
import com.nwalsh.xalan.Callout;
import org.apache.xml.utils.AttList;

public class FormatUnicodeCallout extends FormatCallout {

    int unicodeMax = 0;

    int unicodeStart = 0;

    public  FormatUnicodeCallout(int start, int max, boolean fo) {
        unicodeMax = max;
        unicodeStart = start;
        stylesheetFO = fo;
    }

    public void formatCallout(DOMBuilder rtf, Callout callout) {
        Element area = callout.getArea();
        int num = callout.getCallout();
        String label = areaLabel(area);
        try {
            if (label == null && num <= unicodeMax) {
                char chars[] = new char[1];
                chars[0] = (char) (unicodeStart + num - 1);
                startSpan(rtf);
                rtf.characters(chars, 0, 1);
                endSpan(rtf);
            } else {
                formatTextCallout(rtf, callout);
            }
        } catch (SAXException e) {
            System.out.println("SAX Exception in unicode formatCallout");
        }
    }
}
