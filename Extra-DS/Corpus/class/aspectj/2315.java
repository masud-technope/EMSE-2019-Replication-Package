package com.nwalsh.xalan;

import org.w3c.dom.*;
import org.apache.xml.utils.DOMBuilder;
import com.nwalsh.xalan.Callout;
import org.apache.xml.utils.AttList;

public class FormatTextCallout extends FormatCallout {

    public  FormatTextCallout(boolean fo) {
        stylesheetFO = fo;
    }

    public void formatCallout(DOMBuilder rtf, Callout callout) {
        formatTextCallout(rtf, callout);
    }
}
