copyright xerox corporation palo alto center incorporated parc rights reserved program accompanying materials terms common license accompanies distribution http eclipse org legal cpl html contributors xerox parc initial implementation mik kersten port aspect j aspectj code base org aspectj tools ajdoc java java util hashtable java util iterator java util list org aspectj asm asm manager asmmanager org aspectj asm iprogram element iprogramelement author mik kersten stub file generator stubfilegenerator hashtable decl idtable declidtable do files dofiles hashtable table file input files inputfiles file signature files signaturefiles doc exception docexception decl idtable declidtable table input files inputfiles length process file processfile input files inputfiles signature files signaturefiles process file processfile file input file inputfile file signature file signaturefile doc exception docexception string path structure util structureutil translate aj path name translateajpathname signature file signaturefile get canonical path getcanonicalpath print writer printwriter writer print writer printwriter buffered writer bufferedwriter file writer filewriter path string package name packagename structure util structureutil get package declaration from file getpackagedeclarationfromfile input file inputfile package name packagename package name packagename writer println package name packagename iprogram element iprogramelement file node filenode iprogram element iprogramelement asm manager asmmanager get default getdefault get hierarchy gethierarchy find element for source file findelementforsourcefile input file inputfile get absolute path getabsolutepath iterator file node filenode get children getchildren iterator has next hasnext iprogram element iprogramelement node iprogram element iprogramelement node get kind getkind equals iprogram element iprogramelement kind reference process import declaration processimportdeclaration node writer process type declaration processtypedeclaration node writer doc exception docexception doc exception docexception file invalid input file inputfile to string tostring error don contents file writer close ioexception system err println get message getmessage print stack trace printstacktrace process import declaration processimportdeclaration iprogram element iprogramelement node print writer printwriter writer ioexception list imports node get children getchildren iterator imports iterator has next hasnext iprogram element iprogramelement import node importnode iprogram element iprogramelement writer print writer print import node importnode get name getname writer println process type declaration processtypedeclaration iprogram element iprogramelement class node classnode print writer printwriter writer doc exception docexception string formal comment formalcomment add decl id adddeclid class node classnode class node classnode get formal comment getformalcomment writer println formal comment formalcomment structure util structureutil gen signature gensignature class node classnode string signature gen source signature gensourcesignature class node classnode signature doc exception docexception java file invalid system err println signature class node classnode get name getname structure util structureutil is anonymous isanonymous class node classnode class node classnode get name getname equals undefined writer println signature process members processmembers class node classnode get children getchildren writer class node classnode get kind getkind equals iprogram element iprogramelement kind writer println writer println process members processmembers list iprogram element iprogramelement members print writer printwriter writer declaring type is interface declaringtypeisinterface doc exception docexception iterator members iterator has next hasnext iprogram element iprogramelement member iprogram element iprogramelement member get kind getkind is type istype member get parent getparent get kind getkind equals iprogram element iprogramelement kind method don print anonymous types structure util structureutil is anonymous isanonymous member system err println member get name getname member get parent getparent process type declaration processtypedeclaration member writer string formal comment formalcomment add decl id adddeclid member member get formal comment getformalcomment writer println formal comment formalcomment string signature member get kind getkind equals iprogram element iprogramelement kind pointcut member get kind getkind equals iprogram element iprogramelement kind advice structure util structureutil gen signature gensignature member signature member get source signature getsourcesignature member get kind getkind equals iprogram element iprogramelement kind enum members index of indexof member members size iprogram element iprogramelement members get kind getkind equals iprogram element iprogramelement kind enum member enum signature signature signature signature member get kind getkind is declare isdeclare system err println skipping declare ajdoc limitation member to label string tolabelstring signature signature member get kind getkind is inter type member isintertypemember member get kind getkind equals iprogram element iprogramelement kind initializer structure util structureutil is anonymous isanonymous member writer print signature system err println skipping member get kind getkind member get kind getkind equals iprogram element iprogramelement kind method member get kind getkind equals iprogram element iprogramelement kind constructor member get parent getparent get kind getkind equals iprogram element iprogramelement kind signature index of indexof writer println writer println member get kind getkind equals iprogram element iprogramelement kind field writer println translates aspect aspect string gen source signature gensourcesignature iprogram element iprogramelement class node classnode string signature class node classnode get source signature getsourcesignature signature signature index of indexof aspect signature char at charat signature signature substring signature substring signature length signature next decl id nextdeclid string add decl id adddeclid iprogram element iprogramelement decl string formal comment formalcomment string decl id declid next decl id nextdeclid decl idtable declidtable decl id declid decl add to formal addtoformal formal comment formalcomment config decl string decl id declid config decl terminator period comment adds place holder period replaced string add to formal addtoformal string formal comment formalcomment string string append period appendperiod formal comment formalcomment formal comment formalcomment equals formal comment formalcomment formal comment formalcomment append period appendperiod formal comment formalcomment formal comment formalcomment trim atsign pos atsignpos formal comment formalcomment index of indexof end pos endpos formal comment formalcomment index of indexof period pos periodpos formal comment formalcomment index of indexof position string period place holder periodplaceholder period pos periodpos position period pos periodpos atsign pos atsignpos string string position atsign pos atsignpos end pos endpos string string position end pos endpos error silent error failed append formal comment comment formal comment formalcomment formal comment formalcomment substring position period place holder periodplaceholder string formal comment formalcomment substring position