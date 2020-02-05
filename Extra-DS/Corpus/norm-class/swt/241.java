copyright ibm corporation rights reserved program accompanying materials terms eclipse license accompanies distribution http eclipse org legal epl html contributors ibm corporation initial api implementation org eclipse swt widgets org eclipse swt internal win org eclipse swt org eclipse swt graphics instances support layout selectable tool bar items item children instances type code tool item toolitem code note subclass code composite code sense add code control code children layout styles flat wrap horizontal vertical shadow events note styles horizontal vertical intended subclassed tool bar toolbar composite last focus id lastfocusid tool item toolitem items ignore resize ignoreresize ignore mouse ignoremouse image list imagelist image list imagelist disabled image list disabledimagelist hot image list hotimagelist tool bar proc toolbarproc tchar tool bar class toolbarclass tchar toolbarclassname wndclass lp wnd class lpwndclass wndclass get class info getclassinfo tool bar class toolbarclass lp wnd class lpwndclass tool bar proc toolbarproc lp wnd class lpwndclass lpfn wnd proc lpfnwndproc windows sdk setbuttonsize application explicitly button size size defaults pixels width height constructs instance parent style describing behavior appearance style style constants defined code swt code applicable instances built bitwise ing code code code swt code style constants description lists style constants applicable style bits inherited superclasses param parent composite control parent instance param style style control construct exception illegal argument exception illegalargumentexception error argument parent exception swtexception error thread invalid access called thread created parent error invalid subclass allowed subclass swt flat swt wrap swt swt horizontal swt shadow swt vertical widget check subclass checksubclass widget get style getstyle tool bar toolbar composite parent style parent check style checkstyle style ensure horizontal vertical note horizontal vertical values scroll scroll clear bits avoid scroll bars reset bits original style supplied programmer note ccs vert style applied widget created conflict style swt vertical style swt vertical bits get window long getwindowlong handle gwl style set window long setwindowlong handle gwl style bits ccs vert style swt horizontal call window proc callwindowproc hwnd msg w param wparam l param lparam handle bug windows reason processing syschar tool bar window proc call window proc causing mnemonics menu bar call window proc syschar msg syschar def window proc defwindowproc hwnd msg w param wparam l param lparam call window proc callwindowproc tool bar proc toolbarproc hwnd msg w param wparam l param lparam check style checkstyle style windows flat tool bars traversed style swt flat style swt focus vertical tool bar wrap setrows fails toobar tbstyle wrapable style swt vertical style swt wrap legal create widget scroll bars serve purpose automatically scroll widget client area clear swt style style swt scroll swt scroll check subclass checksubclass is valid subclass isvalidsubclass error swt error invalid subclass point compute size computesize w hint whint h hint hhint changed check widget checkwidget width height style swt vertical rect rect rect tbbutton lp button lpbutton tbbutton count send message sendmessage handle buttoncount count send message sendmessage handle getitemrect rect height math max height rect bottom send message sendmessage handle getbutton lp button lpbutton lp button lpbutton fs style fsstyle btns sep tbbuttoninfo info tbbuttoninfo info cb size cbsize tbbuttoninfo sizeof info dw mask dwmask tbif size send message sendmessage handle getbuttoninfo lp button lpbutton id command idcommand info width math max width info width math max width rect rect old rect oldrect rect get window rect getwindowrect handle old rect oldrect old width oldwidth old rect oldrect old rect oldrect left old height oldheight old rect oldrect bottom old rect oldrect top border get border width getborderwidth new width newwidth w hint whint swt fff w hint whint border new height newheight h hint hhint swt fff h hint hhint border redraw draw count drawcount is window visible iswindowvisible handle ignore resize ignoreresize redraw update window updatewindow handle flags swp noactivate swp nomove swp noredraw swp nozorder set window pos setwindowpos handle new width newwidth new height newheight flags count send message sendmessage handle buttoncount count rect rect rect send message sendmessage handle getitemrect count rect width math max width rect height math max height rect bottom set window pos setwindowpos handle old width oldwidth old height oldheight flags redraw validate rect validaterect handle ignore resize ignoreresize windows sdk setbuttonsize application explicitly button size size defaults pixels width width width height height height w hint whint swt width w hint whint h hint hhint swt height h hint hhint rectangle trim compute trim computetrim width height width trim width height trim height point width height rectangle compute trim computetrim width height check widget checkwidget rectangle trim compute trim computetrim width height bits get window long getwindowlong handle gwl style bits ccs nodivider trim height trim create handle createhandle create handle createhandle canvas feature windows tbstyle flat create flat toolbar reason tbstyle transparent toolbar flicker moved resized clear tbstyle transparent note work unnecessary flickering clearing tbstyle transparent interferes theme style swt flat comctl major is app themed isappthemed bits get window long getwindowlong handle gwl style bits tbstyle transparent set window long setwindowlong handle gwl style bits feature windows fact tool text tooltip honour ttm setmaxtipwidth ttm setmaxtipwidth large lines intentionally commented tool bar sets ttm setmaxtipwidth hwnd tool tip hwndtooltip send message sendmessage handle gettooltips send message sendmessage hwnd tool tip hwndtooltip ttm setmaxtipwidth fff feature windows control created system font hfont created destroyed control destroyed program queries font control font control destroys control font unexpectedly destroyed control assign font time control created control destroy font create h font hfont get stock object getstockobject system font send message sendmessage handle setfont h font hfont button struct bitmap button sizes send message sendmessage handle buttonstructsize tbbutton sizeof send message sendmessage handle setbitmapsize send message sendmessage handle setbuttonsize extended style bits bits tbstyle drawddarrows tbstyle mixedbuttons tbstyle hideclippedbuttons comctl major bits tbstyle doublebuffer send message sendmessage handle setextendedstyle bits create item createitem tool item toolitem item count send message sendmessage handle buttoncount count error swt error invalid range items length items items length tool item toolitem new items newitems tool item toolitem items length system arraycopy items new items newitems items length items new items newitems bits item widget style widgetstyle tbbutton lp button lpbutton tbbutton lp button lpbutton id command idcommand lp button lpbutton fs style fsstyle bits lp button lpbutton fs state fsstate tbstate enabled bug windows fact image list item windows assumes image item valid item inserted image image inserted assigned image item draws image image item created item btns sep style separators images bits btns sep lp button lpbutton i bitmap ibitmap imagenone send message sendmessage handle insertbutton lp button lpbutton error swt error item items item item style swt vertical set row count setrowcount count layout items layoutitems create widget createwidget create widget createwidget items tool item toolitem last focus id lastfocusid default background defaultbackground is win ce iswince get sys color getsyscolor color btnface default background defaultbackground destroy item destroyitem tool item toolitem item tbbuttoninfo info tbbuttoninfo info cb size cbsize tbbuttoninfo sizeof info dw mask dwmask tbif image tbif style send message sendmessage handle getbuttoninfo item info feature windows reason tool item style btns sep imagenone queried image fact attempt assign image item result operations image list wrong random ensure tool item separator image separators image assigned problem info fs style fsstyle btns sep info i image iimage imagenone image list imagelist image list imagelist info i image iimage hot image list hotimagelist hot image list hotimagelist info i image iimage disabled image list disabledimagelist disabled image list disabledimagelist info i image iimage send message sendmessage handle deletebutton item last focus id lastfocusid last focus id lastfocusid items item item count send message sendmessage handle buttoncount count image list imagelist send message sendmessage handle setimagelist display release tool image list releasetoolimagelist image list imagelist hot image list hotimagelist send message sendmessage handle sethotimagelist display release tool hot image list releasetoolhotimagelist hot image list hotimagelist disabled image list disabledimagelist send message sendmessage handle setdisabledimagelist display release tool disabled image list releasetooldisabledimagelist disabled image list disabledimagelist image list imagelist hot image list hotimagelist disabled image list disabledimagelist items tool item toolitem style swt vertical set row count setrowcount count layout items layoutitems enable widget enablewidget enabled enable widget enablewidget enabled bug windows tool item style btns check btns checkgroup selected disabled item draw disabled image disabled image image lists items length tool item toolitem item items item item style swt check swt radio item update images updateimages enabled item get enabled getenabled image list imagelist get disabled image list getdisabledimagelist disabled image list disabledimagelist image list imagelist get hot image list gethotimagelist hot image list hotimagelist image list imagelist get image list getimagelist image list imagelist returns item relative receiver exception range param item item exception illegal argument exception illegalargumentexception error invalid range number elements list inclusive exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver tool item toolitem get item getitem check widget checkwidget count send message sendmessage handle buttoncount count error swt error invalid range tbbutton lp button lpbutton tbbutton result send message sendmessage handle getbutton lp button lpbutton result error swt error item items lp button lpbutton id command idcommand returns item point receiver item exists point coordinate system receiver param point point locate item item point exception illegal argument exception illegalargumentexception error argument point exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver tool item toolitem get item getitem point point check widget checkwidget point error swt error argument tool item toolitem items get items getitems items length rectangle rect items get bounds getbounds rect point items returns number items contained receiver number items exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver get item count getitemcount check widget checkwidget send message sendmessage handle buttoncount returns array code tool item toolitem code items receiver note actual structure receiver maintain list items modifying array affect receiver items receiver exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver tool item toolitem get items getitems check widget checkwidget count send message sendmessage handle buttoncount tbbutton lp button lpbutton tbbutton tool item toolitem result tool item toolitem count count send message sendmessage handle getbutton lp button lpbutton result items lp button lpbutton id command idcommand result returns number rows receiver receiver code wrap code style number rows greater number rows number items exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver get row count getrowcount check widget checkwidget style swt vertical send message sendmessage handle buttoncount send message sendmessage handle getrows searches receiver list starting item item equal argument returns item item returns param item search item item exception illegal argument exception illegalargumentexception error argument tool item error invalid argument tool item disposed exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver index of indexof tool item toolitem item check widget checkwidget item error swt error argument item is disposed isdisposed error swt error invalid argument send message sendmessage handle commandtoindex item layout items layoutitems style swt wrap send message sendmessage handle autosize tool bar vertical width button width widest button tool bar note tool bar drop item account extra padding style swt vertical tbbuttoninfo info tbbuttoninfo info cb size cbsize tbbuttoninfo sizeof info dw mask dwmask tbif size size send message sendmessage handle getbuttonsize info size x ffff xffff items length tool item toolitem item items item item style swt drop items length padding send message sendmessage handle getpadding info padding x ffff xffff items length tool item toolitem item items item item style swt separator send message sendmessage handle setbuttoninfo item info items length tool item toolitem item items item item resize control resizecontrol mnemonic hit mnemonichit key display wcs to mbcs wcstombcs send message sendmessage handle mapaccelerator key style swt flat set tab group focus settabgroupfocus send message sendmessage handle commandtoindex send message sendmessage handle sethotitem items click mnemonic match mnemonicmatch key display wcs to mbcs wcstombcs send message sendmessage handle mapaccelerator key feature windows mapaccelerator matches mnemonic character character tool item behavior undocumented unwanted ensure tool item mnemonic mapaccelerator returns send message sendmessage handle commandtoindex find mnemonic findmnemonic items text release widget releasewidget items length tool item toolitem item items item item is disposed isdisposed item release images releaseimages item release resources releaseresources items image list imagelist send message sendmessage handle setimagelist display release tool image list releasetoolimagelist image list imagelist hot image list hotimagelist send message sendmessage handle sethotimagelist display release tool hot image list releasetoolhotimagelist hot image list hotimagelist disabled image list disabledimagelist send message sendmessage handle setdisabledimagelist display release tool disabled image list releasetooldisabledimagelist disabled image list disabledimagelist image list imagelist hot image list hotimagelist disabled image list disabledimagelist release widget releasewidget remove control removecontrol control control remove control removecontrol control items length tool item toolitem item items item item control control item set control setcontrol set background pixel setbackgroundpixel pixel set background pixel setbackgroundpixel pixel feature windows tbstyle transparent tool bar drawing background image image list include transparency draw correctly clear tbstyle transparent depending background color note work unnecessary tbstyle transparent style cleared platform style swt flat comctl major is app themed isappthemed bits get window long getwindowlong handle gwl style pixel bits tbstyle transparent bits tbstyle transparent set window long setwindowlong handle gwl style bits set bounds setbounds width height flags feature windows reason tool bar repositioned defer window pos deferwindowpos hdwp toolbar redraws defeating puropse defer window pos deferwindowpos defered positioning tool bar ensuring tool bar position deferred time parent lpwp draw count drawcount is window visible iswindowvisible handle parent set resize children setresizechildren parent set resize children setresizechildren set bounds setbounds width height flags set default font setdefaultfont set default font setdefaultfont send message sendmessage handle setbitmapsize send message sendmessage handle setbuttonsize set disabled image list setdisabledimagelist image list imagelist image list imagelist disabled image list disabledimagelist image list imagelist h image list himagelist disabled image list disabledimagelist image list imagelist h image list himagelist disabled image list disabledimagelist get handle gethandle send message sendmessage handle setdisabledimagelist h image list himagelist set font setfont font font check widget checkwidget set font setfont font bug windows setfont tool bar separators bitmap button sizes reset sizes font changed tool bar separators mask swt push swt check swt radio swt drop items length tool item toolitem item items item item style mask items length send message sendmessage handle setbitmapsize send message sendmessage handle setbuttonsize layout items layoutitems set hot image list sethotimagelist image list imagelist image list imagelist hot image list hotimagelist image list imagelist h image list himagelist hot image list hotimagelist image list imagelist h image list himagelist hot image list hotimagelist get handle gethandle send message sendmessage handle sethotimagelist h image list himagelist set image list setimagelist image list imagelist image list imagelist image list imagelist image list imagelist h image list himagelist image list imagelist image list imagelist h image list himagelist image list imagelist get handle gethandle send message sendmessage handle setimagelist h image list himagelist set parent setparent composite parent check widget checkwidget set parent setparent parent send message sendmessage handle setparent parent handle set row count setrowcount count style swt vertical feature windows setrows number rows tool bar tool bar resized items unexpected save restore current size tool bar rect rect rect get window rect getwindowrect handle rect map window points mapwindowpoints parent handle rect ignore resize ignoreresize feature windows button tool bar style btns sep setrows number rows tool bar depending number buttons toolbar wrap items style btns check f larger flarger flags force number rows larger number items number rows larger actual number rows tool bar items number rows item larger count tool bar laid properly items removed setting number rows item count number rows causing setrows choosing row increment fixes cases count send message sendmessage handle setrows count flags swp noactivate swp nomove swp nozorder set window pos setwindowpos handle rect rect left rect bottom rect top flags ignore resize ignoreresize set tab item focus settabitemfocus items length tool item toolitem item items item item style swt separator item get enabled getenabled items length set tab item focus settabitemfocus string tool tip text tooltiptext nmttdispinfo hdr hdr u flags uflags ttf idishwnd nls has cursor hascursor hdr id from idfrom hwnd tool tip hwndtooltip send message sendmessage handle gettooltips hwnd tool tip hwndtooltip hdr hwnd from hwndfrom nls tool tip text tooltiptext items length tool item toolitem item items item item tool tip text tooltiptext tool tip text tooltiptext hdr widget style widgetstyle bits widget style widgetstyle ccs noresize tbstyle tooltips tbstyle customerase style swt shadow bits ccs nodivider style swt wrap bits tbstyle wrapable style swt flat bits tbstyle flat style swt bits tbstyle list bits tchar window class windowclass tool bar class toolbarclass window proc windowproc tool bar proc toolbarproc lresult capturechanged w param wparam l param lparam lresult result capturechanged w param wparam l param lparam result result bug windows tool bar loses capture item pressed lbuttondown item remains pressed unpress item setstate get key state getkeystate lbutton items length tool item toolitem item items item fs state fsstate send message sendmessage handle getstate item fs state fsstate tbstate pressed fs state fsstate tbstate pressed send message sendmessage handle setstate item fs state fsstate lresult w param wparam l param lparam lresult result w param wparam l param lparam result result w param wparam send message sendmessage handle gethotitem tbbutton lp button lpbutton tbbutton code send message sendmessage handle getbutton lp button lpbutton code items lp button lpbutton id command idcommand click lresult result lresult command w param wparam l param lparam feature windows toolbar window proc processes command forwards message parent children control send message type parent notify control parent control typically application window window message control message applications subclass control window message control window subclassed swt message delivered swt message forwarded window proc avoid calling window proc control lresult result command w param wparam l param lparam result result lresult lresult getdlgcode w param wparam l param lparam lresult result getdlgcode w param wparam l param lparam dlgc button mnemonics processed needing press alt key widget focus result result lresult dlgc button lresult keydown w param wparam l param lparam lresult result keydown w param wparam l param lparam result result w param wparam space ensure window proc process space handled application opportunity cancel operation lresult result lresult killfocus w param wparam l param lparam send message sendmessage handle gethotitem tbbutton lp button lpbutton tbbutton code send message sendmessage handle getbutton lp button lpbutton code last focus id lastfocusid lp button lpbutton id command idcommand killfocus w param wparam l param lparam lresult lbuttondown w param wparam l param lparam ignore mouse ignoremouse lbuttondown w param wparam l param lparam lresult lbuttonup w param wparam l param lparam ignore mouse ignoremouse lbuttonup w param wparam l param lparam lresult notify w param wparam l param lparam feature windows toolbar window proc processes notify forwards message parent children control send message type parent notify control parent control typically application window window message control message applications subclass control window message control window subclassed swt message delivered swt message forwarded window proc avoid calling window proc control lresult result notify w param wparam l param lparam result result lresult lresult setfocus w param wparam l param lparam lresult result setfocus w param wparam l param lparam last focus id lastfocusid handle get focus getfocus send message sendmessage handle commandtoindex last focus id lastfocusid send message sendmessage handle sethotitem result lresult size w param wparam l param lparam ignore resize ignoreresize code call window proc callwindowproc handle size w param wparam l param lparam code lresult lresult code lresult result size w param wparam l param lparam is disposed isdisposed result bug windows code windows determines tool items wrap window bounds client area tool bars style tbstyle hideclippedbuttons client area buttons overlap border hidden wrapped compute tbstyle hideclippedbuttons time tool bar resized style swt border style swt wrap rect window rect windowrect rect get window rect getwindowrect handle window rect windowrect border get border width getborderwidth rect rect rect count send message sendmessage handle buttoncount count send message sendmessage handle getitemrect rect map window points mapwindowpoints handle rect rect window rect windowrect border bits send message sendmessage handle getextendedstyle count bits tbstyle hideclippedbuttons bits tbstyle hideclippedbuttons send message sendmessage handle setextendedstyle bits layout items layoutitems result lresult windowposchanging w param wparam l param lparam lresult result windowposchanging w param wparam l param lparam result result ignore resize ignoreresize result bug windows flat tool bar wrapped windows draws horizontal separator rows tool bar draw pixels separator toolbar resized bigger area drawn pixels blank drawn separator leaves garbage screen damage pixels draw count drawcount result style swt wrap result is window visible iswindowvisible handle result send message sendmessage handle getrows result windowpos lpwp windowpos move memory movememory lpwp l param lparam windowpos sizeof lpwp flags swp nosize swp noredraw result rect old rect oldrect rect get client rect getclientrect handle old rect oldrect rect new rect newrect rect set rect setrect new rect newrect lpwp lpwp send message sendmessage handle nccalcsize new rect newrect old width oldwidth old rect oldrect old rect oldrect left new width newwidth new rect newrect new rect newrect left new width newwidth old width oldwidth rect rect rect new height newheight new rect newrect bottom new rect newrect top set rect setrect rect old width oldwidth old width oldwidth new height newheight invalidate rect invalidaterect handle rect result lresult wm command child wmcommandchild w param wparam l param lparam tool item toolitem child items w param wparam x ffff xffff child child wm command child wmcommandchild w param wparam l param lparam lresult wm notify child wmnotifychild w param wparam l param lparam nmhdr hdr nmhdr move memory movememory hdr l param lparam nmhdr sizeof hdr code tbn dropdown nmtoolbar lpnmtb nmtoolbar move memory movememory lpnmtb l param lparam nmtoolbar sizeof tool item toolitem child items lpnmtb i item iitem child event event event event detail swt arrow send message sendmessage handle commandtoindex lpnmtb i item iitem rect rect rect send message sendmessage handle getitemrect rect event rect left event rect bottom child post event postevent swt selection event customdraw find theme control findthemecontrol background nmcustomdraw nmcd nmcustomdraw move memory movememory nmcd l param lparam nmcustomdraw sizeof nmcd dw draw stage dwdrawstage cdds preerase lresult cdrf notifyposterase cdds posterase draw background drawbackground nmcd hdc tbn hotitemchange is win ce iswince nmtbhotitem lpnmhi nmtbhotitem move memory movememory lpnmhi l param lparam nmtbhotitem sizeof lpnmhi dw flags dwflags hicf arrowkeys rect client rect get client rect getclientrect handle client send message sendmessage handle commandtoindex lpnmhi id new idnew rect rect rect send message sendmessage handle getitemrect rect rect client rect bottom client bottom lresult wm notify child wmnotifychild w param wparam l param lparam