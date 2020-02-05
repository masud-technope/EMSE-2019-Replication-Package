package com.nwalsh.saxon;

import org.xml.sax.SAXException;
import org.w3c.dom.*;
import javax.xml.transform.TransformerException;
import com.icl.saxon.om.NamePool;
import com.icl.saxon.output.Emitter;
import com.nwalsh.saxon.Callout;

public class FormatTextCallout extends FormatCallout {

    public  FormatTextCallout(NamePool nPool, boolean fo) {
        super(nPool, fo);
    }

    public void formatCallout(Emitter rtfEmitter, Callout callout) {
        formatTextCallout(rtfEmitter, callout);
    }
}
