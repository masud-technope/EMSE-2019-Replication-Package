copyright ibm corporation rights reserved program accompanying materials terms eclipse license accompanies distribution http eclipse org legal epl html contributors ibm corporation initial api implementation org eclipse swt widgets org eclipse swt internal win org eclipse swt org eclipse swt graphics org eclipse swt events list scrollable list proc listproc tchar list class listclass tchar listbox wndclass lp wnd class lpwndclass wndclass get class info getclassinfo list class listclass lp wnd class lpwndclass list proc listproc lp wnd class lpwndclass lpfn wnd proc lpfnwndproc constructs instance parent style describing behavior appearance style style constants defined code swt code applicable instances built bitwise ing code code code swt code style constants description lists style constants applicable style bits inherited superclasses param parent composite control parent instance param style style control construct exception illegal argument exception illegalargumentexception error argument parent exception swtexception error thread invalid access called thread created parent error invalid subclass allowed subclass swt single swt multi widget check subclass checksubclass widget get style getstyle list composite parent style parent check style checkstyle style adds argument receiver list param string item exception illegal argument exception illegalargumentexception error argument string exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver add string add string string check widget checkwidget string error swt error argument tchar buffer tchar get code page getcodepage string result send message sendmessage handle addstring buffer result err error swt error item result errspace error swt error item style swt scroll set scroll width setscrollwidth buffer adds argument receiver list relative note add item list result calling code get item count getitemcount code code add string code param string item param item exception illegal argument exception illegalargumentexception error argument string error invalid range number elements list inclusive exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver add string add string string check widget checkwidget string error swt error argument error swt error invalid range tchar buffer tchar get code page getcodepage string result send message sendmessage handle insertstring buffer result errspace error swt error item result err count send message sendmessage handle getcount count error swt error item error swt error invalid range style swt scroll set scroll width setscrollwidth buffer adds listener collection listeners notified receiver selection sending messages defined code selection listener selectionlistener code code widget selected widgetselected code called selection code widget default selected widgetdefaultselected code typically called item clicked param listener listener notified exception illegal argument exception illegalargumentexception error argument listener exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver selection listener selectionlistener remove selection listener removeselectionlistener selection event selectionevent add selection listener addselectionlistener selection listener selectionlistener listener check widget checkwidget listener error swt error argument typed listener typedlistener typed listener typedlistener typed listener typedlistener listener add listener addlistener swt selection typed listener typedlistener add listener addlistener swt default selection defaultselection typed listener typedlistener call window proc callwindowproc hwnd msg w param wparam l param lparam handle call window proc callwindowproc list proc listproc hwnd msg w param wparam l param lparam check style checkstyle style check bits checkbits style swt single swt multi point compute size computesize w hint whint h hint hhint changed check widget checkwidget width height w hint whint swt style swt scroll width send message sendmessage handle gethorizontalextent count send message sendmessage handle getcount new font newfont old font oldfont h dc hdc get dc getdc handle new font newfont send message sendmessage handle getfont new font newfont old font oldfont select object selectobject h dc hdc new font newfont rect rect rect flags calcrect singleline noprefix get code page getcodepage tchar buffer tchar count length send message sendmessage handle gettextlen length err length buffer length buffer tchar length result send message sendmessage handle gettext buffer result err draw text drawtext h dc hdc buffer length rect flags width math max width rect rect left new font newfont select object selectobject h dc hdc old font oldfont release dc releasedc handle h dc hdc h hint hhint swt count send message sendmessage handle getcount item height itemheight send message sendmessage handle getitemheight height count item height itemheight width width width height height height w hint whint swt width w hint whint h hint hhint swt height h hint hhint border get border width getborderwidth width border height border style swt scroll width get system metrics getsystemmetrics cxvscroll style swt scroll height get system metrics getsystemmetrics cyhscroll point width height default background defaultbackground get sys color getsyscolor color window deselects items relative indices receiver item relative receiver selected deselected item selected remains deselected indices range duplicate indices param indices array indices items deselect exception illegal argument exception illegalargumentexception error argument indices exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver deselect indices check widget checkwidget indices error swt error argument indices length style swt single old index oldindex send message sendmessage handle getcursel old index oldindex err indices length old index oldindex indices send message sendmessage handle setcursel indices length indices send message sendmessage handle setsel deselects item relative receiver item deselected remains deselected indices range param item deselect exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver deselect check widget checkwidget style swt single old index oldindex send message sendmessage handle getcursel old index oldindex err old index oldindex send message sendmessage handle setcursel send message sendmessage handle setsel deselects items relative indices receiver item relative receiver selected deselected item selected remains deselected range indices inclusive indices range param start start items deselect param items deselect exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver deselect start check widget checkwidget start style swt single old index oldindex send message sendmessage handle getcursel old index oldindex err start old index oldindex old index oldindex send message sendmessage handle setcursel ensure item contained range start note start selitemrangeex deselects item count send message sendmessage handle getcount start start count count start math min count math max start math min count math max send message sendmessage handle selitemrangeex start deselects selected items receiver exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver deselect all deselectall check widget checkwidget style swt single send message sendmessage handle setcursel send message sendmessage handle setsel returns relative item focus receiver item focus selected item exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver get focus index getfocusindex check widget checkwidget result send message sendmessage handle getcaretindex result count send message sendmessage handle getcount count result returns item relative receiver exception range param item item exception illegal argument exception illegalargumentexception error invalid range number elements list inclusive exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver string get item getitem check widget checkwidget length send message sendmessage handle gettextlen length err tchar buffer tchar get code page getcodepage length result send message sendmessage handle gettext buffer result err buffer to string tostring length count send message sendmessage handle getcount count error swt error item error swt error invalid range returns number items contained receiver number items exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver get item count getitemcount check widget checkwidget result send message sendmessage handle getcount result err error swt error count result returns height area display items list height item exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver get item height getitemheight check widget checkwidget result send message sendmessage handle getitemheight result err error swt error item height result returns empty array code string code items receiver note actual structure receiver maintain list items modifying array affect receiver items receiver list exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver string get items getitems check widget checkwidget count get item count getitemcount string result string count count result get item getitem result returns array code string code selected receiver order items unspecified empty array items selected note actual structure receiver maintain selection modifying array affect receiver array representing selection exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver string get selection getselection check widget checkwidget indices get selection indices getselectionindices string result string indices length indices length result get item getitem indices result returns number selected items contained receiver number selected items exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver get selection count getselectioncount check widget checkwidget style swt single result send message sendmessage handle getcursel result err result send message sendmessage handle getselcount result err error swt error count result returns relative item selected receiver item selected selected item exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver get selection index getselectionindex check widget checkwidget style swt single send message sendmessage handle getcursel count send message sendmessage handle getselcount count err error swt error selection count send message sendmessage handle getcaretindex result send message sendmessage handle getsel result err error swt error selection result buffer result send message sendmessage handle getselitems buffer result error swt error selection buffer returns relative indices items selected receiver order indices unspecified array empty items selected note actual structure receiver maintain selection modifying array affect receiver array indices selected items exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver get selection indices getselectionindices check widget checkwidget style swt single result send message sendmessage handle getcursel result err result length send message sendmessage handle getselcount length err error swt error selection indices length result send message sendmessage handle getselitems length indices result length error swt error selection indices returns relative item top receiver change items scrolled items removed top item exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver get top index gettopindex check widget checkwidget send message sendmessage handle gettopindex item list searched starting item equal search item item returned indexing based param string search item item exception illegal argument exception illegalargumentexception error argument string exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver index of indexof string string index of indexof string searches receiver list starting relative item equal argument returns item item starting range returns param string search item param start relative start search item exception illegal argument exception illegalargumentexception error argument string exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver index of indexof string string start check widget checkwidget string error swt error argument bug windows reason findstringexact find empty strings legal insert empty string list search list item time string length count get item count getitemcount start count string equals get item getitem findstringexact search item count send message sendmessage handle getcount start start count start tchar buffer tchar get code page getcodepage string send message sendmessage handle findstringexact buffer err string equals get item getitem returns code code item selected code code indices range param item visibility item exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver is selected isselected check widget checkwidget result send message sendmessage handle getsel result result err removes items receiver relative indices param indices array indices items exception illegal argument exception illegalargumentexception error invalid range number elements list inclusive error argument indices array exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver remove indices check widget checkwidget indices error swt error argument indices length new indices newindices indices length system arraycopy indices new indices newindices indices length sort new indices newindices start new indices newindices new indices newindices length new indices newindices count send message sendmessage handle getcount start start count error swt error invalid range top index topindex send message sendmessage handle gettopindex rect rect h dc hdc old font oldfont new font newfont new width newwidth style swt scroll rect rect h dc hdc get dc getdc handle new font newfont send message sendmessage handle getfont new font newfont old font oldfont select object selectobject h dc hdc new font newfont get code page getcodepage top count topcount new indices newindices length new indices newindices tchar buffer style swt scroll length send message sendmessage handle gettextlen length err buffer tchar length result send message sendmessage handle gettext buffer result err result send message sendmessage handle deletestring result err style swt scroll flags calcrect singleline noprefix draw text drawtext h dc hdc buffer rect flags new width newwidth math max new width newwidth rect rect left top index topindex top count topcount style swt scroll new font newfont select object selectobject h dc hdc old font oldfont release dc releasedc handle h dc hdc set scroll width setscrollwidth new width newwidth top count topcount top index topindex top count topcount send message sendmessage handle settopindex top index topindex new indices newindices length error swt error item removed removes item receiver relative param item exception illegal argument exception illegalargumentexception error invalid range number elements list inclusive exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver remove check widget checkwidget tchar buffer style swt scroll length send message sendmessage handle gettextlen length err error swt error item removed buffer tchar get code page getcodepage length result send message sendmessage handle gettext buffer result err error swt error item removed top index topindex send message sendmessage handle gettopindex result send message sendmessage handle deletestring result err count send message sendmessage handle getcount count error swt error item removed error swt error invalid range style swt scroll set scroll width setscrollwidth buffer top index topindex send message sendmessage handle settopindex top index topindex removes items receiver relative start indices inclusive param start start range param range exception illegal argument exception illegalargumentexception error invalid range start number elements list inclusive exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver remove start check widget checkwidget start count send message sendmessage handle getcount start start count error swt error invalid range start count remove all removeall top index topindex send message sendmessage handle gettopindex rect rect h dc hdc old font oldfont new font newfont new width newwidth style swt scroll rect rect h dc hdc get dc getdc handle new font newfont send message sendmessage handle getfont new font newfont old font oldfont select object selectobject h dc hdc new font newfont get code page getcodepage start flags calcrect singleline noprefix tchar buffer style swt scroll length send message sendmessage handle gettextlen start length err buffer tchar length result send message sendmessage handle gettext start buffer result err result send message sendmessage handle deletestring start result err style swt scroll draw text drawtext h dc hdc buffer rect flags new width newwidth math max new width newwidth rect rect left style swt scroll new font newfont select object selectobject h dc hdc old font oldfont release dc releasedc handle h dc hdc set scroll width setscrollwidth new width newwidth top index topindex top index topindex start send message sendmessage handle settopindex top index topindex error swt error item removed searches receiver list starting item item equal argument removes item list param string item remove exception illegal argument exception illegalargumentexception error argument string error invalid argument string list exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver remove string string check widget checkwidget string error swt error argument index of indexof string error swt error invalid argument remove removes items receiver exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver remove all removeall check widget checkwidget send message sendmessage handle resetcontent style swt scroll send message sendmessage handle sethorizontalextent removes listener collection listeners notified receiver selection param listener listener longer notified exception illegal argument exception illegalargumentexception error argument listener exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver selection listener selectionlistener add selection listener addselectionlistener remove selection listener removeselectionlistener selection listener selectionlistener listener check widget checkwidget listener error swt error argument event table eventtable event table eventtable unhook swt selection listener event table eventtable unhook swt default selection defaultselection listener selects items relative indices receiver current selection cleared items selected item selected selected item selected remains selected indices range duplicate indices receiver single select multiple indices indices param indices array indices items select exception illegal argument exception illegalargumentexception error argument array indices exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver list set selection setselection select indices check widget checkwidget indices error swt error argument length indices length length style swt single length select indices select indices scroll indices length indices select scroll show selection showselection selects item relative receiver list item selected remains selected indices range param item select exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver select check widget checkwidget select select scroll count send message sendmessage handle getcount count scroll style swt single send message sendmessage handle setcursel send message sendmessage handle setsel top index topindex send message sendmessage handle gettopindex rect item rect itemrect rect selected rect selectedrect send message sendmessage handle getitemrect item rect itemrect redraw draw count drawcount is window visible iswindowvisible handle redraw update window updatewindow handle send message sendmessage handle setredraw focus index focusindex style swt single old index oldindex send message sendmessage handle getcursel old index oldindex selected rect selectedrect rect send message sendmessage handle getitemrect old index oldindex selected rect selectedrect send message sendmessage handle setcursel focus index focusindex send message sendmessage handle getcaretindex send message sendmessage handle setsel style swt multi focus index focusindex send message sendmessage handle setcaretindex focus index focusindex send message sendmessage handle settopindex top index topindex redraw send message sendmessage handle setredraw validate rect validaterect handle invalidate rect invalidaterect handle item rect itemrect selected rect selectedrect invalidate rect invalidaterect handle selected rect selectedrect selects items range relative indices receiver range indices inclusive current selection cleared items selected item range selected selected item range selected remains selected indices range items selected start greater receiver single select item range indices param start start range param range exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver list set selection setselection select start check widget checkwidget start style swt single start count send message sendmessage handle getcount count start count start math max start math min count style swt single select start select start select start scroll note start selitemrangeex deselects item start select start scroll send message sendmessage handle selitemrangeex start scroll show selection showselection selects items receiver receiver single select exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver select all selectall check widget checkwidget style swt single send message sendmessage handle setsel set bounds setbounds width height flags bug windows receiver scrolled horizontally resized list redraw properly redraw control resizing deferred size previous size parent lpwp flags swp nosize set bounds setbounds width height flags rect rect rect get window rect getwindowrect handle rect old width oldwidth rect rect left old height oldheight rect bottom rect top set bounds setbounds width height flags old width oldwidth width old height oldheight height scrollinfo info scrollinfo info cb size cbsize scrollinfo sizeof info f mask fmask sif pos get scroll info getscrollinfo handle horz info info n pos npos invalidate rect invalidaterect handle set focus index setfocusindex check widget checkwidget count send message sendmessage handle getcount count send message sendmessage handle setcaretindex set font setfont font font check widget checkwidget set font setfont font style swt scroll set scroll width setscrollwidth sets text item receiver list relative string argument equivalent code remove code ing item code add code ing item param item param string text item exception illegal argument exception illegalargumentexception error invalid range number elements list inclusive error argument string exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver set item setitem string string check widget checkwidget string error swt error argument top index topindex get top index gettopindex is selected isselected is selected isselected remove add string is selected isselected select set top index settopindex top index topindex sets receiver items array items param items array items exception illegal argument exception illegalargumentexception error argument items array error invalid argument item items array exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver set items setitems string items check widget checkwidget items error swt error argument items length items error swt error invalid argument old proc oldproc get window long getwindowlong handle gwl wndproc set window long setwindowlong handle gwl wndproc list proc listproc redraw draw count drawcount is window visible iswindowvisible handle redraw send message sendmessage handle setredraw rect rect h dc hdc old font oldfont new font newfont new width newwidth style swt scroll rect rect h dc hdc get dc getdc handle new font newfont send message sendmessage handle getfont new font newfont old font oldfont select object selectobject h dc hdc new font newfont send message sendmessage handle sethorizontalextent length items length send message sendmessage handle resetcontent send message sendmessage handle initstorage length length get code page getcodepage length string string items tchar buffer tchar string result send message sendmessage handle addstring buffer result err result errspace style swt scroll flags calcrect singleline noprefix draw text drawtext h dc hdc buffer buffer length rect flags new width newwidth math max new width newwidth rect rect left style swt scroll new font newfont select object selectobject h dc hdc old font oldfont release dc releasedc handle h dc hdc send message sendmessage handle sethorizontalextent new width newwidth redraw send message sendmessage handle setredraw code intentionally commented window proc list box setredraw invalidate erase widget undocumented behavior commented code happening reminds relying undocumented behavior flags rdw erase rdw frame rdw invalidate redraw window redrawwindow handle flags set window long setwindowlong handle gwl wndproc old proc oldproc items length error swt error item set scroll width setscrollwidth new width newwidth rect rect rect new font newfont old font oldfont h dc hdc get dc getdc handle new font newfont send message sendmessage handle getfont new font newfont old font oldfont select object selectobject h dc hdc new font newfont get code page getcodepage count send message sendmessage handle getcount flags calcrect singleline noprefix count length send message sendmessage handle gettextlen length err tchar buffer tchar length result send message sendmessage handle gettext buffer result err draw text drawtext h dc hdc buffer rect flags new width newwidth math max new width newwidth rect rect left new font newfont select object selectobject h dc hdc old font oldfont release dc releasedc handle h dc hdc send message sendmessage handle sethorizontalextent new width newwidth set scroll width setscrollwidth tchar buffer grow rect rect rect new font newfont old font oldfont h dc hdc get dc getdc handle new font newfont send message sendmessage handle getfont new font newfont old font oldfont select object selectobject h dc hdc new font newfont flags calcrect singleline noprefix draw text drawtext h dc hdc buffer rect flags new font newfont select object selectobject h dc hdc old font oldfont release dc releasedc handle h dc hdc set scroll width setscrollwidth rect rect left grow set scroll width setscrollwidth new width newwidth grow width send message sendmessage handle gethorizontalextent grow new width newwidth width send message sendmessage handle sethorizontalextent new width newwidth new width newwidth width set scroll width setscrollwidth selects items relative indices receiver current selection cleared items selected indices range duplicate indices receiver single select multiple indices indices param indices indices items select exception illegal argument exception illegalargumentexception error argument array indices exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver list deselect all deselectall list select set selection setselection indices check widget checkwidget indices error swt error argument deselect all deselectall length indices length length style swt single length select indices style swt multi focus index focusindex indices focus index focusindex set focus index setfocusindex focus index focusindex sets receiver selection array items current selection cleared items selected items receiver receiver single select multiple items items param items array items exception illegal argument exception illegalargumentexception error argument array items exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver list deselect all deselectall list select list set selection setselection set selection setselection string items check widget checkwidget items error swt error argument deselect all deselectall length items length length style swt single length focus index focusindex length string string items string local focus localfocus index of indexof string local focus localfocus local focus localfocus select style swt single is selected isselected show selection showselection local focus localfocus focus index focusindex local focus localfocus style swt multi focus index focusindex set focus index setfocusindex focus index focusindex selects item relative receiver item selected remains selected current selection cleared item selected indices range param item select exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver list deselect all deselectall list select set selection setselection check widget checkwidget deselect all deselectall select style swt multi set focus index setfocusindex selects items range relative indices receiver range indices inclusive current selection cleared items selected indices range items selected start greater receiver single select item range indices param start start items select param items select exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver list deselect all deselectall list select set selection setselection start check widget checkwidget deselect all deselectall start style swt single start count send message sendmessage handle getcount count start count start math max start math min count style swt single select start select start set focus index setfocusindex start sets relative item top receiver change items scrolled items removed param top item exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver set top index settopindex check widget checkwidget result send message sendmessage handle settopindex result err count send message sendmessage handle getcount math min count math max send message sendmessage handle settopindex selection selection showing receiver method simply returns items scrolled selection visible exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver show selection showselection check widget checkwidget style swt single send message sendmessage handle getcursel indices result send message sendmessage handle getselitems indices indices result count send message sendmessage handle getcount count height send message sendmessage handle getitemheight force resize forceresize rect rect rect get client rect getclientrect handle rect top index topindex send message sendmessage handle gettopindex visible count visiblecount math max rect bottom height bottom index bottomindex math min top index topindex visible count visiblecount count top index topindex bottom index bottomindex new top newtop math min math max visible count visiblecount count send message sendmessage handle settopindex new top newtop widget style widgetstyle bits widget style widgetstyle lbs notify lbs nointegralheight style swt single bits style swt multi style swt simple bits lbs multiplesel bits lbs extendedsel bits tchar window class windowclass list class listclass window proc windowproc list proc listproc lresult wm command child wmcommandchild w param wparam l param lparam code w param wparam code lbn selchange post event postevent swt selection lbn dblclk post event postevent swt default selection defaultselection wm command child wmcommandchild w param wparam l param lparam