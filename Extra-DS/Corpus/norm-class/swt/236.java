copyright ibm corporation rights reserved program accompanying materials terms eclipse license accompanies distribution http eclipse org legal epl html contributors ibm corporation initial api implementation org eclipse swt custom org eclipse swt swt org eclipse swt graphics styled text renderer styledtextrenderer renders content styled text styledtext widget subclasses provide device display printer render implement methods resources created device styled text renderer styledtextrenderer device render device device font regular font regularfont bold font boldfont italic font italicfont bold italic font bolditalicfont width pixels tab character tab width tabwidth ascent descent width pixels space represent delimiters line end space width lineendspacewidth creates instance styled text renderer styledtextrenderer param device device render param regular font regularfont font regular text param left margin leftmargin margin left text styled text renderer styledtextrenderer device device font regular font regularfont device device regular font regularfont regular font regularfont calculates height space width calculate line height calculatelineheight get gc getgc line end space width lineendspacewidth string extent stringextent don assume bold normal fonts height fixes bug font original font originalfont get font getfont font metrics fontmetrics metrics get font metrics getfontmetrics ascent math max ascent metrics get ascent getascent metrics get leading getleading descent math max descent metrics get descent getdescent set font setfont get font getfont swt bold metrics get font metrics getfontmetrics ascent math max ascent metrics get ascent getascent metrics get leading getleading descent math max descent metrics get descent getdescent set font setfont get font getfont swt italic metrics get font metrics getfontmetrics ascent math max ascent metrics get ascent getascent metrics get leading getleading descent math max descent metrics get descent getdescent set font setfont get font getfont swt bold swt italic metrics get font metrics getfontmetrics ascent math max ascent metrics get ascent getascent metrics get leading getleading descent math max descent metrics get descent getdescent set font setfont original font originalfont dispose gc disposegc clear font cache bold font boldfont bold font boldfont dispose italic font italicfont italic font italicfont dispose bold italic font bolditalicfont bold italic font bolditalicfont dispose bold font boldfont italic font italicfont bold italic font bolditalicfont disposes resource created receiver dispose bold font boldfont bold font boldfont dispose italic font italicfont italic font italicfont dispose bold italic font bolditalicfont bold italic font bolditalicfont dispose bold font boldfont italic font italicfont bold italic font bolditalicfont dispose subclasses reuse gcs param dispose dispose gc disposegc draws text location param draw param line index lineindex draw param paint y painty location draw param draw param widget background widgetbackground widget background color rendering color param widget foreground widgetforeground widget foreground color rendering color param clear background clearbackground background drawn explicitly draw line drawline string line index lineindex paint y painty color widget background widgetbackground color widget foreground widgetforeground clear background clearbackground line offset lineoffset get content getcontent get offset at line getoffsetatline line index lineindex line length linelength length point selection get selection getselection selection start selectionstart selection selection end selectionend selection left margin leftmargin get left margin getleftmargin color line background linebackground text layout textlayout layout get text layout gettextlayout line offset lineoffset rectangle client get client area getclientarea styled text event styledtextevent event get line background data getlinebackgrounddata line offset lineoffset event line background linebackground event line background linebackground line background linebackground line background linebackground widget background widgetbackground clear background clearbackground is full line selection isfulllineselection selection start selectionstart line offset lineoffset selection end selectionend line offset lineoffset line length linelength draw background full selection completely selected set background setbackground line background linebackground set foreground setforeground line background linebackground fill rectangle fillrectangle client left margin leftmargin paint y painty client width ascent descent paint x paintx client left margin leftmargin get horizontal pixel gethorizontalpixel selection start selectionstart selection end selectionend rectangle rect layout get line bounds getlinebounds draw line break selection drawlinebreakselection line offset lineoffset paint x paintx rect rect width paint y painty set foreground setforeground widget foreground widgetforeground set background setbackground line background linebackground selection start selectionstart selection end selectionend selection end selectionend line offset lineoffset selection start selectionstart line offset lineoffset line length linelength layout draw paint x paintx paint y painty start math max selection start selectionstart line offset lineoffset math min line length linelength selection end selectionend line offset lineoffset layout draw paint x paintx paint y painty start get selection foreground getselectionforeground get selection background getselectionbackground dispose text layout disposetextlayout layout draws background selection implemented subclasses optional selection rendering param draw param line offset lineoffset offset character relative start document param styles styles param paint y painty location draw param draw param bidi bidi object measuring rendering text bidi locales bidi mode draw line break selection drawlinebreakselection string line offset lineoffset paint x paintx paint y painty returns visible client area rendering visible client area rendering rectangle get client area getclientarea returns styled text content styledtextcontent offset calculations styled text content styledtextcontent offset calculations styled text content styledtextcontent get content getcontent returns device rendered device rendered device get device getdevice device get baseline getbaseline ascent returns text segments treated direction surrounding text param line offset lineoffset offset character based document param text bidi segments text segments treated direction surrounding text start segment relative start starts ends length exception illegal argument exception illegalargumentexception error invalid argument segment indices returned listener start ascending order exceed length duplicates get bidi segments getbidisegments line offset lineoffset string line text linetext returns font style font get font getfont style style swt bold bold font boldfont bold font boldfont bold font boldfont font device get font data getfontdata style swt italic italic font italicfont italic font italicfont italic font italicfont font device get font data getfontdata style swt bold swt italic bold italic font bolditalicfont bold italic font bolditalicfont bold italic font bolditalicfont font device get font data getfontdata style regular font regularfont font data fontdata get font data getfontdata style font data fontdata font datas fontdatas regular font regularfont get font data getfontdata font datas fontdatas length font datas fontdatas set style setstyle style font datas fontdatas returns rendering measuring subclasses reuse gcs rendering measuring get gc getgc returns horizontal scroll position horizontal scroll position get horizontal pixel gethorizontalpixel get left margin getleftmargin returns width pixels space represent delimiters width pixels space represent delimiters get line end space width getlineendspacewidth line end space width lineendspacewidth returns background data param line offset lineoffset offset start relative start content param background data background data styled text event styledtextevent get line background data getlinebackgrounddata line offset lineoffset string returns height pixels height pixels get line height getlineheight ascent descent returns style data line offset lineoffset segment logical stored styled text content styledtextcontent widget returned styles guaranteed partially segment param event styles logical param line offset lineoffset offset start relative start content param styles style data segment styles start start guaranteed partially styled text event styledtextevent get line style data getlinestyledata styled text event styledtextevent event line offset lineoffset string line length linelength length event styles get word wrap getwordwrap event styles get visual line style data getvisuallinestyledata event styles line offset lineoffset line length linelength event styles event styles style range stylerange event returns style data line style listener linestylelistener styles styled text event styledtextevent styles field initialized empty array param line offset lineoffset offset start relative start content param styles style data styles start start styled text event styledtextevent get line style data getlinestyledata line offset lineoffset string get orientation getorientation get right margin getrightmargin color get selection foreground getselectionforeground color get selection background getselectionbackground returns widget selection implemented subclasses optional selection rendering widget selection point get selection getselection returns styles visual wrapped param logical styles logicalstyles styles logical unwrapped param line offset lineoffset offset visual param line length linelength length visual styles logical styles logicalstyles array partially visual style range stylerange get visual line style data getvisuallinestyledata style range stylerange logical styles logicalstyles line offset lineoffset line length linelength line end lineend line offset lineoffset line length linelength old style count oldstylecount logical styles logicalstyles length new style count newstylecount old style count oldstylecount style range stylerange style logical styles logicalstyles style start line end lineend style start style length line offset lineoffset new style count newstylecount new style count newstylecount old style count oldstylecount style range stylerange new styles newstyles style range stylerange new style count newstylecount old style count oldstylecount style range stylerange style logical styles logicalstyles style start line end lineend style start style length line offset lineoffset new styles newstyles logical styles logicalstyles logical styles logicalstyles new styles newstyles logical styles logicalstyles returns word wrap word wrap word wrap lines extend side client area get word wrap getwordwrap returns widget created swt full selection style implemented subclasses optional selection rendering widget running full selection mode is full line selection isfulllineselection calculates width pixel tab character param tab length tablength number space characters represented tab character set tab length settablength tab length tablength get gc getgc string buffer stringbuffer tab buffer tabbuffer string buffer stringbuffer tab length tablength tab length tablength tab buffer tabbuffer append tab width tabwidth string extent stringextent tab buffer tabbuffer to string tostring dispose gc disposegc returns text layout textlayout array styles text layout textlayout get text layout gettextlayout string line offset lineoffset text layout textlayout layout create text layout createtextlayout line offset lineoffset layout set font setfont regular font regularfont layout set ascent setascent ascent layout set descent setdescent descent layout set text settext layout set orientation setorientation get orientation getorientation layout set segments setsegments get bidi segments getbidisegments line offset lineoffset layout set tabs settabs tab width tabwidth length length styled text event styledtextevent event get line style data getlinestyledata line offset lineoffset style range stylerange styles event event styles last offset lastoffset styles style index styleindex style index styleindex styles length style index styleindex style range stylerange style styles style index styleindex style is unstyled isunstyled start line offset lineoffset style start start math min length style length line offset lineoffset style start start style start line offset lineoffset math min length start style length start length last offset lastoffset start layout set style setstyle last offset lastoffset start text style textstyle text style textstyle text style textstyle get font getfont style font style fontstyle style foreground style background text style textstyle underline style underline text style textstyle strikeout style strikeout layout set style setstyle text style textstyle start last offset lastoffset math max last offset lastoffset last offset lastoffset length layout set style setstyle last offset lastoffset length layout text layout textlayout create text layout createtextlayout line offset lineoffset text layout textlayout device dispose text layout disposetextlayout text layout textlayout layout layout dispose