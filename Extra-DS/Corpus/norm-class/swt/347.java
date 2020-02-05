copyright ibm corporation rights reserved program accompanying materials terms eclipse license accompanies distribution http eclipse org legal epl html contributors ibm corporation initial api implementation org eclipse swt custom org eclipse swt org eclipse swt internal compatibility org eclipse swt widgets java util vector default content defaultcontent styled text content styledtextcontent string line delimiter linedelimiter system get property getproperty separator stores text listeners event sending vector text listeners textlisteners vector stores actual text text store textstore character position start gap gap start gapstart character position gap gap end gapend gap exists gap gap line gapline high watermark highwatermark low watermark lowwatermark array character positions lengths representing lines lines text number lines text line count linecount expansion exponent increase lines array exponentially expand exp expandexp expansion exponent increase lines array exponentially replace expand exp replaceexpandexp creates default content defaultcontent initializes code styled text content styledtextcontent empty default content defaultcontent set text settext adds indexes array increases size array code line count linecount code updated reflect entry param start start param length length add line index addlineindex start length size lines length line count linecount size expand lines powers new lines newlines size compatibility pow expand exp expandexp system arraycopy lines new lines newlines size lines new lines newlines expand exp expandexp range start length lines line count linecount range line count linecount adds code lines array linesarray code increases size array returns array param start start param length length param lines array linesarray array add param count position add array indexes add line index addlineindex start length lines array linesarray count size lines array linesarray length new lines newlines lines array linesarray count size new lines newlines size compatibility pow replace expand exp replaceexpandexp replace expand exp replaceexpandexp system arraycopy lines array linesarray new lines newlines size range start length new lines newlines count range new lines newlines adds code text change listener textchangelistener code listening code text changing event textchangingevent code code text changed event textchangedevent code code text changing event textchangingevent code text occur code text changed event textchangedevent code text occured param listener listener exception illegal argument exception illegalargumentexception error argument listener add text change listener addtextchangelistener text change listener textchangelistener listener listener error swt error argument styled text listener styledtextlistener typed listener typedlistener styled text listener styledtextlistener listener text listeners textlisteners add element addelement typed listener typedlistener adjusts gap accomodate text change occurring param position position change occurring param size hint sizehint size change param gap adjust gap adjustgap position size hint sizehint position gap start gapstart text inserted gap position size gap end gapend gap start gapstart size hint sizehint low watermark lowwatermark size size high watermark highwatermark position size hint sizehint gap start gapstart size hint sizehint text deleted gap position size gap end gapend gap start gapstart size hint sizehint low watermark lowwatermark size size high watermark highwatermark move and resize gap moveandresizegap position size hint sizehint calculates indexes text store assumes gap exists optimized checking index lines indexlines start line count linecount text length textlength text store textstore length start text length textlength text store textstore swt character text length textlength text store textstore swt add line index addlineindex start start start swt add line index addlineindex start start start add line index addlineindex start start returns character delimiter valid delimiters param character test delimiter is delimiter isdelimiter swt swt determine replace operation valid default content defaultcontent delimiter split partially deleted param start start offset text replace param replace length replacelength start offset text replace param new text newtext start offset text replace replace operation valid is valid replace isvalidreplace start replace length replacelength string new text newtext replace length replacelength inserting text delimiter split start start get char count getcharcount get text range gettextrange start char at charat get text range gettextrange start char at charat deleting text delimiter deleted start char startchar get text range gettextrange start char at charat start char startchar delete position start get text range gettextrange start char at charat end char endchar get text range gettextrange start replace length replacelength char at charat end char endchar delete position start replace length replacelength get char count getcharcount get text range gettextrange start replace length replacelength char at charat calculates indexes text range param offset logical start offset text lineate param length length text lineate includes gap param num lines numlines number lines initially allocate array passed efficiency exact number lines indexes array identified start offset length index lines indexlines offset length num lines numlines indexed lines indexedlines num lines numlines start line cnt linecnt replace expand exp replaceexpandexp start length location offset location gap start gapstart location gap end gapend ignore gap text store textstore location swt character location text store textstore length text store textstore location swt indexed lines indexedlines add line index addlineindex start start indexed lines indexedlines line cnt linecnt line cnt linecnt start swt indexed lines indexedlines add line index addlineindex start start indexed lines indexedlines line cnt linecnt line cnt linecnt start new lines newlines line cnt linecnt system arraycopy indexed lines indexedlines new lines newlines line cnt linecnt range start start new lines newlines line cnt linecnt range new lines newlines inserts text param position position insert text param text text insert insert position string text text length start line startline get line at offset getlineatoffset position change text length end insert endinsert position get char count getcharcount adjust gap adjustgap position change start line startline insert gap adjusted start position startline inserted text gap start line offset startlineoffset get offset at line getoffsetatline start line startline point start line length startlinelength include start newly inserted text start line length startlinelength get physical line getphysicalline start line startline length change shrink gap gap start gapstart change text length text store textstore position text char at charat figure number lines inserted new lines newlines index lines indexlines start line offset startlineoffset start line length startlinelength insert empty text num new lines numnewlines new lines newlines length new lines newlines num new lines numnewlines inserted end insert endinsert insert happening text leave num new lines numnewlines concatenated num new lines numnewlines num new lines numnewlines room lines expand lines by expandlinesby num new lines numnewlines shift lines replace line count linecount start line startline lines num new lines numnewlines lines insert lines num new lines numnewlines new lines newlines start line offset startlineoffset lines start line startline new lines newlines update inserted num new lines numnewlines new lines newlines length new lines newlines num new lines numnewlines start line offset startlineoffset lines start line startline num new lines numnewlines new lines newlines num new lines numnewlines line count linecount num new lines numnewlines gap line gapline get line at physical offset getlineatphysicaloffset gap start gapstart moves gap adjusts size anticipation text change gap resized actual size size moved position param position position change occurring param size size change param new gap line newgapline gap move and resize gap moveandresizegap position size new gap line newgapline content old size oldsize gap end gapend gap start gapstart new size newsize size new size newsize high watermark highwatermark size new size newsize low watermark lowwatermark size remove gap lines gap exists gapexists adjust length lines gap line gapline lines gap line gapline old size oldsize adjust offsets lines gap line gapline gap line gapline line count linecount lines lines old size oldsize new size newsize old size oldsize removing gap content text store textstore length old size oldsize system arraycopy text store textstore content gap start gapstart system arraycopy text store textstore gap end gapend content gap start gapstart content length gap start gapstart text store textstore content gap start gapstart gap end gapend position content text store textstore length new size newsize old size oldsize new gap start newgapstart position new gap end newgapend new gap start newgapstart new size newsize old size oldsize system arraycopy text store textstore content new gap start newgapstart system arraycopy text store textstore new gap start newgapstart content new gap end newgapend content length new gap end newgapend new gap start newgapstart gap start gapstart delta gap start gapstart new gap start newgapstart system arraycopy text store textstore content new gap start newgapstart system arraycopy text store textstore new gap start newgapstart content new gap end newgapend delta system arraycopy text store textstore gap end gapend content new gap end newgapend delta text store textstore length gap end gapend delta new gap start newgapstart gap start gapstart system arraycopy text store textstore content gap start gapstart system arraycopy text store textstore gap end gapend content gap start gapstart delta system arraycopy text store textstore gap end gapend delta content new gap end newgapend content length new gap end newgapend text store textstore content gap start gapstart new gap start newgapstart gap end gapend new gap end newgapend add gap lines gap exists gapexists gap line gapline new gap line newgapline adjust length gap length gaplength gap end gapend gap start gapstart lines gap line gapline lines gap line gapline gap length gaplength adjust offsets lines gap line gapline gap line gapline line count linecount lines lines gap length gaplength returns number lines text param start offset startoffset start text lineate param length length text lineate number lines line count linecount start offset startoffset length length line cnt linecnt count start offset startoffset gap start gapstart gap end gapend gap start gapstart count length gap start gapstart gap end gapend ignore gap text store textstore swt character text store textstore length text store textstore swt count line cnt linecnt swt line cnt linecnt count line cnt linecnt returns number lines text param text text lineate number lines text line count linecount string text line count linecount length text length length text char at charat swt length text char at charat swt line count linecount swt line count linecount line count linecount logical length text store get char count getcharcount length gap end gapend gap start gapstart text store textstore length length returns code code delimiters param logical text gap exception illegal argument exception illegalargumentexception error invalid argument range string get line getline line count linecount error swt error invalid argument start lines length lines start length gap exists gapexists gap start gapstart start gap end gapend gap length is delimiter isdelimiter text store textstore start length length string text store textstore start length gap range strip gap string buffer stringbuffer buf string buffer stringbuffer gap length gaplength gap end gapend gap start gapstart buf append text store textstore start gap start gapstart start buf append text store textstore gap end gapend length gap length gaplength gap start gapstart start length buf length length is delimiter isdelimiter buf char at charat length length buf to string tostring substring length returns delimiter styled text styledtext widget inserting lines delimiter delimiter code styled text content styledtextcontent code platform delimiter separator system property string get line delimiter getlinedelimiter line delimiter linedelimiter returns delimiters param logical text gap delimiters string get full line getfullline start lines length lines start length gap exists gapexists gap start gapstart start gap end gapend gap string text store textstore start length gap range strip gap string buffer stringbuffer buf string buffer stringbuffer gap length gaplength gap end gapend gap start gapstart buf append text store textstore start gap start gapstart start buf append text store textstore gap end gapend length gap length gaplength gap start gapstart start buf to string tostring returns physical delimiters gap param physical string get physical line getphysicalline start lines length lines get physical text getphysicaltext start length number lines text store get line count getlinecount line count linecount returns offset param char position charposition logical character offset include gap exception illegal argument exception illegalargumentexception error invalid argument char position charposition range get line at offset getlineatoffset char position charposition position char position charposition get char count getcharcount char position charposition error swt error invalid argument char position charposition gap start gapstart position gap position char position charposition position includes gap position char position charposition gap end gapend gap start gapstart character inserting line count linecount last line lastline line count linecount position lines last line lastline lines last line lastline last line lastline high line count linecount line count linecount high high line start linestart lines line end lineend line start linestart lines position line start linestart high position line end lineend high high returns physical offset param position physical character offset includes gap get line at physical offset getlineatphysicaloffset position high line count linecount line count linecount high high line start linestart lines line end lineend line start linestart lines position line start linestart high position line end lineend high high returns logical offset param line index lineindex logical starting offset lines get offset at line getoffsetatline valid call answer exception illegal argument exception illegalargumentexception error invalid argument line index lineindex range get offset at line getoffsetatline line index lineindex line index lineindex line index lineindex line count linecount line index lineindex error swt error invalid argument start lines line index lineindex start gap end gapend start gap end gapend gap start gapstart start increases indexes array accomodate lines param num lines numlines number increase array expand lines by expandlinesby num lines numlines size lines length size line count linecount num lines numlines new lines newlines size math max num lines numlines system arraycopy lines new lines newlines size lines new lines newlines reports swt error param code error code error code swt error code returns gap exists text store gap exists gap exists gapexists gap start gapstart gap end gapend returns string representing continous content text store param start physical start offset text param length physical length text text string get physical text getphysicaltext start length string text store textstore start length returns string representing logical content text store gap stripped param start logical start offset text param length logical length text text string get text range gettextrange start length text store textstore length start length gap exists gapexists gap start gapstart string text store textstore start length gap start gapstart start gap length gaplength gap end gapend gap start gapstart string text store textstore start gap length gaplength length string buffer stringbuffer buf string buffer stringbuffer buf append text store textstore start gap start gapstart start buf append text store textstore gap end gapend gap start gapstart buf to string tostring removes code text change listener textchangelistener code param listener listener exception illegal argument exception illegalargumentexception error argument listener remove text change listener removetextchangelistener text change listener textchangelistener listener listener error swt error argument text listeners textlisteners size typed listener typedlistener typed listener typedlistener typed listener typedlistener text listeners textlisteners element at elementat typed listener typedlistener get event listener geteventlistener listener text listeners textlisteners remove element at removeelementat replaces text code new text newtext code starting position code start code length code replace length replacelength code notifies listeners sending text changing event textchangingevent code new line count newlinecount code number lines inserted code replace line count replacelinecount code number lines deleted based change occurs visually replace text replacetext new text newtext replace line count replacelinecount new line count newlinecount param start start offset text replace param replace length replacelength start offset text replace param new text newtext start offset text replace exception swtexception error invalid argument text change multi delimiter split partially deleted splitting delimiter inserting text characters delimiter deleting delimiter supported replace text range replacetextrange start replace length replacelength string new text newtext check invalid replace operations is valid replace isvalidreplace start replace length replacelength new text newtext swt error swt error invalid argument inform listeners styled text event styledtextevent event styled text event styledtextevent event type styled text styledtext text changing textchanging event start start event replace line count replacelinecount line count linecount start replace length replacelength event text new text newtext event new line count newlinecount line count linecount new text newtext event replace char count replacecharcount replace length replacelength event new char count newcharcount new text newtext length send text event sendtextevent event delete text replaced delete start replace length replacelength event replace line count replacelinecount insert text insert start new text newtext inform listeners event styled text event styledtextevent event type styled text styledtext text changed textchanged send text event sendtextevent event print lines printlines sends text listeners text changed textchanged event send text event sendtextevent styled text event styledtextevent event text listeners textlisteners size styled text listener styledtextlistener text listeners textlisteners element at elementat handle event handleevent event sets content text removes gap predictions change occur param text text set text settext string text text store textstore text to char array tochararray gap start gapstart gap end gapend expand exp expandexp index lines indexlines styled text event styledtextevent event styled text event styledtextevent event type styled text styledtext text set textset event text send text event sendtextevent event deletes text param position position text delete starts param length length text delete param num lines numlines number lines deleted delete position length num lines numlines length start line startline get line at offset getlineatoffset position start line offset startlineoffset get offset at line getoffsetatline start line startline end line endline get line at offset getlineatoffset position length string end text endtext splitting delimiter splittingdelimiter position length get char count getcharcount end text endtext get text range gettextrange position length end text endtext char at charat swt end text endtext char at charat swt splitting delimiter splittingdelimiter adjust gap adjustgap position length length start line startline old lines oldlines index lines indexlines position length gap end gapend gap start gapstart num lines numlines left position length gap start gapstart gap start gapstart length gap end gapend length figure length concatenated finding delmiter position position eol text store textstore length eol gap start gapstart gap end gapend text store textstore is delimiter isdelimiter text store textstore length swt text store textstore swt eol update deletion started lines start line startline position start line offset startlineoffset position figure number lines deleted num old lines numoldlines old lines oldlines length splitting delimiter splittingdelimiter num old lines numoldlines offset length lines end line endline line count linecount lines num old lines numoldlines lines line count linecount num old lines numoldlines gap line gapline get line at physical offset getlineatphysicaloffset gap start gapstart