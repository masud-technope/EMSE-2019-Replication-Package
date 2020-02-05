copyright ibm corporation rights reserved program accompanying materials terms eclipse license accompanies distribution http eclipse org legal epl html contributors ibm corporation initial api implementation org eclipse swt widgets org eclipse swt org eclipse swt events org eclipse swt graphics org eclipse swt internal win instances represent icons system tray task bar status area styles events default selection defaultselection menu detect menudetect selection intended subclassed tray item trayitem item tray parent image image string tool tip text tooltiptext visible constructs instance parent code tray code style describing behavior appearance item items maintained parent style style constants defined code swt code applicable instances built bitwise ing code code code swt code style constants description lists style constants applicable style bits inherited superclasses param parent composite control parent instance param style style control construct exception illegal argument exception illegalargumentexception error argument parent exception swtexception error thread invalid access called thread created parent error invalid subclass allowed subclass swt widget check subclass checksubclass widget get style getstyle tray item trayitem tray parent style parent style parent parent parent create item createitem parent get item count getitemcount create widget createwidget adds listener collection listeners notified receiver selected sending messages defined code selection listener selectionlistener code code widget selected widgetselected code called receiver selected code widget default selected widgetdefaultselected code called receiver clicked param listener listener notified exception illegal argument exception illegalargumentexception error argument listener exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver selection listener selectionlistener remove selection listener removeselectionlistener selection event selectionevent add selection listener addselectionlistener selection listener selectionlistener listener check widget checkwidget listener error swt error argument typed listener typedlistener typed listener typedlistener typed listener typedlistener listener add listener addlistener swt selection typed listener typedlistener add listener addlistener swt default selection defaultselection typed listener typedlistener check subclass checksubclass is valid subclass isvalidsubclass error swt error invalid subclass image create icon createicon image image image data imagedata data image get image data getimagedata data alpha data alpha data alphadata image data imagedata mask data get transparency mask gettransparencymask image display data mask width data width height data height h mask hmask h bitmap hbitmap h dc hdc get dc getdc dst hdc dsthdc create compatible dc createcompatibledc h dc hdc old dst bitmap olddstbitmap is win ce iswince win version version h bitmap hbitmap display create bit dib bitdib image handle data alpha data alpha data alphadata data transparent pixel transparentpixel h mask hmask create bitmap createbitmap width height old dst bitmap olddstbitmap select object selectobject dst hdc dsthdc h mask hmask pat blt patblt dst hdc dsthdc width height blackness h mask hmask display create mask from alpha createmaskfromalpha data width height icons black pixels mask transparent h bitmap hbitmap create compatible bitmap createcompatiblebitmap h dc hdc width height old dst bitmap olddstbitmap select object selectobject dst hdc dsthdc h bitmap hbitmap src hdc srchdc create compatible dc createcompatibledc h dc hdc old src bitmap oldsrcbitmap select object selectobject src hdc srchdc image handle pat blt patblt dst hdc dsthdc width height blackness bit blt bitblt dst hdc dsthdc width height src hdc srchdc srcinvert select object selectobject src hdc srchdc h mask hmask bit blt bitblt dst hdc dsthdc width height src hdc srchdc srcand select object selectobject src hdc srchdc image handle bit blt bitblt dst hdc dsthdc width height src hdc srchdc srcinvert select object selectobject src hdc srchdc old src bitmap oldsrcbitmap delete dc deletedc src hdc srchdc select object selectobject dst hdc dsthdc old dst bitmap olddstbitmap delete dc deletedc dst hdc dsthdc release dc releasedc h dc hdc iconinfo info iconinfo info f icon ficon info hbm color hbmcolor h bitmap hbitmap info hbm mask hbmmask h mask hmask h icon hicon create icon indirect createiconindirect info h icon hicon swt error swt error handles delete object deleteobject h bitmap hbitmap delete object deleteobject h mask hmask image win display swt icon h icon hicon create widget createwidget is win ce iswince notifyicondata icon data icondata is unicode isunicode notifyicondata notifyicondataw notifyicondataa icon data icondata cb size cbsize notifyicondata sizeof icon data icondata u id uid display next tray id nexttrayid icon data icondata h wnd hwnd display hwnd message hwndmessage icon data icondata u flags uflags nif message icon data icondata u callback message ucallbackmessage display swt trayiconmsg shell notify icon notifyicon nim add icon data icondata returns receiver tool text receiver tool text exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver string get tool tip text gettooltiptext check widget checkwidget tool tip text tooltiptext returns code code receiver visible code code receiver visibility exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver get visible getvisible check widget checkwidget visible message proc messageproc hwnd msg w param wparam l param lparam feature windows user clicks tray icon application foreground window event loop running problems menu user clicks menu cancel menu hidden event processed application foreground window menu hidden force tray icon message window foreground sending event l param lparam lbuttondown hooks swt selection set foreground window setforegroundwindow hwnd post event postevent swt selection lbuttondblclk rbuttondblclk hooks swt default selection defaultselection set foreground window setforegroundwindow hwnd post event postevent swt default selection defaultselection rbuttonup hooks swt menu detect menudetect set foreground window setforegroundwindow hwnd send event sendevent swt menu detect menudetect widget disposed point is disposed isdisposed display wake thread wakethread recreate create widget createwidget visible set visible setvisible text length set text settext text image set image setimage image tool tip text tooltiptext set tool tip text settooltiptext tool tip text tooltiptext release child releasechild release child releasechild parent destroy item destroyitem release widget releasewidget release widget releasewidget image image dispose image tool tip text tooltiptext is win ce iswince notifyicondata icon data icondata is unicode isunicode notifyicondata notifyicondataw notifyicondataa icon data icondata cb size cbsize notifyicondata sizeof icon data icondata u id uid icon data icondata h wnd hwnd display hwnd message hwndmessage shell notify icon notifyicon nim delete icon data icondata removes listener collection listeners notified receiver selected param listener listener longer notified exception illegal argument exception illegalargumentexception error argument listener exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver selection listener selectionlistener add selection listener addselectionlistener remove selection listener removeselectionlistener selection listener selectionlistener listener check widget checkwidget listener error swt error argument event table eventtable event table eventtable unhook swt selection listener event table eventtable unhook swt default selection defaultselection listener sets receiver image param image image exception illegal argument exception illegalargumentexception error invalid argument image disposed exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver set image setimage image image check widget checkwidget image image is disposed isdisposed error swt error invalid argument set image setimage image is win ce iswince image image dispose image h icon hicon image icon image icon icon type swt bitmap image create icon createicon image h icon hicon image handle swt icon h icon hicon icon handle notifyicondata icon data icondata is unicode isunicode notifyicondata notifyicondataw notifyicondataa icon data icondata cb size cbsize notifyicondata sizeof icon data icondata u id uid icon data icondata h wnd hwnd display hwnd message hwndmessage icon data icondata h icon hicon h icon hicon icon data icondata u flags uflags nif icon shell notify icon notifyicon nim modify icon data icondata sets receiver tool text argument indicating tool text param tool text exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver set tool tip text settooltiptext string check widget checkwidget tool tip text tooltiptext is win ce iswince notifyicondata icon data icondata is unicode isunicode notifyicondata notifyicondataw notifyicondataa tchar buffer tchar tool tip text tooltiptext tool tip text tooltiptext note size sz tip sztip field version shell dll length shell major is unicode isunicode sz tip sztip notifyicondataw icon data icondata sz tip sztip length math min length buffer length system arraycopy buffer chars sz tip sztip length sz tip sztip notifyicondataa icon data icondata sz tip sztip length math min length buffer length system arraycopy buffer bytes sz tip sztip length icon data icondata cb size cbsize notifyicondata sizeof icon data icondata u id uid icon data icondata h wnd hwnd display hwnd message hwndmessage icon data icondata u flags uflags nif shell notify icon notifyicon nim modify icon data icondata receiver visible argument code code invisible param visible visibility exception swtexception error widget disposed receiver disposed error thread invalid access called thread created receiver set visible setvisible visible check widget checkwidget visible visible visible application code disposed widget event send event sendevent swt is disposed isdisposed visible visible is win ce iswince notifyicondata icon data icondata is unicode isunicode notifyicondata notifyicondataw notifyicondataa icon data icondata cb size cbsize notifyicondata sizeof icon data icondata u id uid icon data icondata h wnd hwnd display hwnd message hwndmessage shell major visible icon data icondata u flags uflags nif message icon data icondata u callback message ucallbackmessage display swt trayiconmsg shell notify icon notifyicon nim add icon data icondata set image setimage image set tool tip text settooltiptext tool tip text tooltiptext shell notify icon notifyicon nim delete icon data icondata icon data icondata u flags uflags nif icon data icondata dw state dwstate visible nis hidden icon data icondata dw state mask dwstatemask nis hidden shell notify icon notifyicon nim modify icon data icondata visible send event sendevent swt hide