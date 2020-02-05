copyright ibm corporation rights reserved program accompanying materials terms eclipse license accompanies distribution http eclipse org legal epl html contributors ibm corporation initial api implementation org eclipse swt ole win org eclipse swt java file org eclipse swt internal ole win org eclipse swt internal win org eclipse swt internal win tchar ole constants create active x activex control ole document definitions constants msdn ole swt functions semantically result function succeeded function succeeded unspecified failure fail invalid argument invalidarg query interface queryinterface recognize requested nointerface implemented notimpl nls string iid iunknown nls string iid idispatch verbs invoked client close ole object discard undo oleiverb discardundostate hide ole object oleiverb hide open ole editing place oleiverb inplaceactivate open ole object editing separate window oleiverb open opens ole object editing oleiverb primary request ole object properties dialog oleiverb properties ole object oleiverb activate ole object oleiverb uiactivate property changing property changed error code ole error oleerror specific error hresult unspecified error code ole error oleerror failed create file error create file error code ole error oleerror failed create ole client error create object error code ole error oleerror file exist accessible user correct format error open file error code ole error oleerror failed find requested ole object error error code ole error oleerror registry error invalid classid error code ole error oleerror failed factory class id classid error access classfactory error code ole error oleerror failed create licensed instance error create licensed object error code ole error oleerror memory error memory error code ole error oleerror failed change variant type error change variant type error code ole error oleerror invalid address received ole error invalid address error code ole error oleerror unable find application error application error code ole error oleerror action performed error action performed olecmdf supported olecmdf enabled olecmdf latched olecmdf ninched olecmdtextf olecmdtextf olecmdtextf status olecmdexecopt dodefault olecmdexecopt promptuser olecmdexecopt dontpromptuser olecmdexecopt showhelp olecmdid open olecmdid olecmdid save olecmdid saveas olecmdid savecopyas olecmdid print olecmdid printpreview olecmdid pagesetup olecmdid spell olecmdid properties olecmdid cut olecmdid copy olecmdid paste olecmdid pastespecial olecmdid undo olecmdid redo olecmdid selectall olecmdid clearselection olecmdid zoom olecmdid getzoomrange olecmdid updatecommands olecmdid refresh olecmdid olecmdid hidetoolbars olecmdid setprogressmax olecmdid setprogresspos olecmdid setprogresstext olecmdid settitle olecmdid setdownloadstate olecmdid stopdownload ole property description flags varflag freadonly varflag fsource varflag fbindable varflag frequestedit varflag fdisplaybind varflag fdefaultbind varflag fhidden varflag frestricted varflag fdefaultcollelem varflag fuidefault varflag fnonbrowsable varflag freplaceable varflag fimmediatebind ole property description kind perinstance dispatch ole parameter description flags idlflag idlflag fin idlflag fout idlflag flcid idlflag fretval ole description types bool binary string bstr reference combined othre values byref currency idispatch dispatch empty scodes error signed signed real real unsigned unsigned iunknown unknown variant variant ptr userdefined hresult decimal uint safearray carray lpstr lpwstr record filetime blob stream storage streamed object stored object blob object clsid versioned stream bstr blob xfff vector array ole function description invoke kind values invoke func invoke propertyget invoke propertyput invoke propertyputref ole function description function kind func virtual func purevirtual func nonvirtual func func dispatch ole function description function flags funcflag frestricted funcflag fsource funcflag fbindable funcflag frequestedit funcflag fdisplaybind funcflag fdefaultbind funcflag fhidden funcflag fusesgetlasterror funcflag fdefaultcollelem funcflag fuidefault funcflag fnonbrowsable funcflag freplaceable funcflag fimmediatebind ole function description calling convention fastcall cdecl mscpascal pascal macpascal stdcall fpfastcall syscall mpwcdecl mpwpascal max nls string error implemented msg required functionality supported nls string error create file msg failed create file nls string error create object msg failed create ole client nls string error open file msg file exist accessible user correct format nls string error msg failed find requested ole object nls string error invalid classid msg registry nls string error access classfactory msg failed factory class id classid nls string error create licensed object msg failed create licensed instance nls string error memory msg memory nls string error change variant type msg failed change variant type nls string error invalid address msg invalid address received ole nls string error application msg unable find application nls string error action performed msg action performed error code error code error code hresult code illegal arguments fatal error invalid address illegal argument exception illegalargumentexception error invalid address msg swt errors fatal error create file string msg error create file msg nls hresult msg result hresult swtexception code msg error create object string msg error create object msg nls hresult msg result hresult nls swtexception code msg error open file string msg error open file msg nls hresult msg result hresult swtexception code msg error string msg error msg nls hresult msg result hresult swtexception code msg error invalid classid string msg error invalid classid msg nls hresult msg result hresult swtexception code msg error access classfactory string msg error access classfactory msg nls hresult msg result hresult swtexception code msg error create licensed object string msg error create licensed object msg nls hresult msg result hresult swtexception code msg error change variant type string msg error change variant type msg nls hresult msg result hresult swtexception code msg error application string msg error application msg nls hresult msg result hresult swtexception code msg error action performed string msg error action performed msg nls hresult msg result hresult swtexception code msg failure limit fatal occur platforms error memory string msg error action performed msg nls hresult msg result hresult swterror code msg unknown undefined error swt error code finds ole program extension extension platforms support ole empty string returned param extension program extension string ole program empty string exception illegal argument exception illegalargumentexception error argument extension string find program id findprogramid string extension extension swt error swt error argument nls extension length nls extension char at charat extension extension character encoding locale tchar extension key extensionkey tchar extension string result get key value getkeyvalue extension key extensionkey result program id programid not insertable notinsertable nls tchar not insertable key notinsertablekey tchar result not insertable notinsertable nls get key exists getkeyexists not insertable key notinsertablekey program id programid insertable nls tchar insertable key insertablekey tchar result insertable get key exists getkeyexists insertable key insertablekey result program id programid protocol std file editing stdfileediting server nls tchar server key serverkey tchar result protocol std file editing stdfileediting server get key exists getkeyexists server key serverkey result nls string get key value getkeyvalue tchar key phk result phkresult reg open key ex regopenkeyex hkey classes root key key read phk result phkresult string result lpcb data lpcbdata reg query value ex regqueryvalueex phk result phkresult tchar tchar lpcb data lpcbdata length lpcb data lpcbdata tchar sizeof length result character encoding locale tchar lp data lpdata tchar length reg query value ex regqueryvalueex phk result phkresult lp data lpdata lpcb data lpcbdata length math max lp data lpdata length result lp data lpdata to string tostring length phk result phkresult reg close key regclosekey phk result phkresult result get key exists getkeyexists tchar key phk result phkresult reg open key ex regopenkeyex hkey classes root key key read phk result phkresult phk result phkresult reg close key regclosekey phk result phkresult returns file ole storage format note empty files extension param file file checked file ole storage format is ole file isolefile file file file file exists file is directory isdirectory stg is storage file stgisstoragefile file get absolute path getabsolutepath to char array tochararray