copyright palo alto center incorporated parc rights reserved program accompanying materials terms common license accompanies distribution http eclipse org legal cpl html contributors parc initial implementation alexandre vasseur support per clause perclause org aspectj ajdt internal compiler lookup java util array list arraylist java util collection java util collections java util list org aspectj ajdt internal compiler ast advice declaration advicedeclaration org aspectj ajdt internal compiler ast aspect declaration aspectdeclaration org aspectj ajdt internal compiler ast declare annotation declaration declareannotationdeclaration org aspectj ajdt internal compiler ast declare declaration declaredeclaration org aspectj ajdt internal compiler ast inter type declaration intertypedeclaration org aspectj ajdt internal compiler ast pointcut declaration pointcutdeclaration org aspectj ajdt internal core builder eclipse source context eclipsesourcecontext org aspectj bridge imessage org aspectj org eclipse jdt core compiler char operation charoperation org aspectj org eclipse jdt internal compiler ast astnode org aspectj org eclipse jdt internal compiler ast abstract method declaration abstractmethoddeclaration org aspectj org eclipse jdt internal compiler ast annotation org aspectj org eclipse jdt internal compiler ast compilation unit declaration compilationunitdeclaration org aspectj org eclipse jdt internal compiler ast normal annotation normalannotation org aspectj org eclipse jdt internal compiler ast single member annotation singlememberannotation org aspectj org eclipse jdt internal compiler ast string literal stringliteral org aspectj org eclipse jdt internal compiler ast type declaration typedeclaration org aspectj org eclipse jdt internal compiler ast type parameter typeparameter org aspectj org eclipse jdt internal compiler lookup binary type binding binarytypebinding org aspectj org eclipse jdt internal compiler lookup compiler modifiers compilermodifiers org aspectj org eclipse jdt internal compiler lookup field binding fieldbinding org aspectj org eclipse jdt internal compiler lookup reference binding referencebinding org aspectj org eclipse jdt internal compiler lookup source type binding sourcetypebinding org aspectj org eclipse jdt internal compiler lookup tag bits tagbits org aspectj weaver abstract reference type delegate abstractreferencetypedelegate org aspectj weaver annotation target kind annotationtargetkind org aspectj weaver annotation x annotationx org aspectj weaver reference type referencetype org aspectj weaver resolved member resolvedmember org aspectj weaver resolved pointcut definition resolvedpointcutdefinition org aspectj weaver resolved type resolvedtype org aspectj weaver type variable typevariable org aspectj weaver unresolved type unresolvedtype org aspectj weaver weaver state info weaverstateinfo org aspectj weaver patterns per clause perclause org aspectj weaver patterns per from super perfromsuper org aspectj weaver patterns per singleton persingleton supports viewing eclipse type declarations typedeclarations source type bindings sourcetypebindings resolved type resolvedtype author jim hugunin eclipse source type eclipsesourcetype abstract reference type delegate abstractreferencetypedelegate pointcut sig pointcutsig lorg aspectj lang annotation pointcut to char array tochararray aspect sig aspectsig lorg aspectj lang annotation aspect to char array tochararray resolved pointcut definition resolvedpointcutdefinition declared pointcuts declaredpointcuts resolved member resolvedmember declared methods declaredmethods resolved member resolvedmember declared fields declaredfields list declares array list arraylist list type mungers typemungers array list arraylist eclipse factory eclipsefactory factory source type binding sourcetypebinding binding type declaration typedeclaration declaration compilation unit declaration compilationunitdeclaration unit annotations resolved annotationsresolved resolved type resolvedtype resolved annotations resolvedannotations discovered annotation target kinds discoveredannotationtargetkinds annotation target kind annotationtargetkind annotation target kinds annotationtargetkinds eclipse factory eclipsefactory eclipse world eclipseworld factory eclipse source type eclipsesourcetype reference type referencetype resolved type x resolvedtypex eclipse factory eclipsefactory factory source type binding sourcetypebinding binding type declaration typedeclaration declaration compilation unit declaration compilationunitdeclaration unit resolved type x resolvedtypex factory factory binding binding declaration declaration unit unit set source context setsourcecontext eclipse source context eclipsesourcecontext declaration compilation result compilationresult resolved type x resolvedtypex set start pos setstartpos declaration source start sourcestart resolved type x resolvedtypex set end pos setendpos declaration source end sourceend is aspect isaspect is code style iscodestyle declaration aspect declaration aspectdeclaration is code style iscodestyle is code style iscodestyle is annotation style aspect isannotationstyleaspect is anonymous isanonymous declaration modifiers astnode anonymous and local mask anonymousandlocalmask is nested isnested declaration modifiers astnode is member type mask ismembertypemask is annotation style aspect isannotationstyleaspect declaration annotations resolved type resolvedtype annotations get annotation types getannotationtypes annotations length org aspectj lang annotation aspect equals annotations get name getname is annotation style pointcut isannotationstylepointcut annotation annotations annotations annotations length xxx early build inter typeand per clause buildintertypeandperclause annotations resolved type resolvedtype prevent resolving references pointcuts pointcut code style aspect sig annotations resolved type resolvedtype signature char operation charoperation equals pointcut sig pointcutsig sig weaver state info weaverstateinfo get weaver state getweaverstate resolved type resolvedtype get superclass getsuperclass binding is interface isinterface get resolved type x getresolvedtypex get world getworld get core type getcoretype unresolved type unresolvedtype object xxx java lang object eclipse world eclipseworld from eclipse fromeclipse binding superclass resolved type resolvedtype get declared interfaces getdeclaredinterfaces eclipse world eclipseworld from eclipse fromeclipse binding super interfaces superinterfaces fill declared members filldeclaredmembers list declared pointcuts declaredpointcuts array list arraylist list declared methods declaredmethods array list arraylist list declared fields declaredfields array list arraylist side call bindings completed binding methods abstract method declaration abstractmethoddeclaration methods declaration methods methods len methods length len abstract method declaration abstractmethoddeclaration amd methods amd amd ignore further investigation ignorefurtherinvestigation amd pointcut declaration pointcutdeclaration pointcut declaration pointcutdeclaration pointcut declaration pointcutdeclaration amd resolved pointcut definition resolvedpointcutdefinition make resolved pointcut definition makeresolvedpointcutdefinition factory declared pointcuts declaredpointcuts add amd inter type declaration intertypedeclaration handled separate pass amd declare declaration declaredeclaration surfaces annotated ajc method amd declare annotation declaration declareannotationdeclaration handled separate pass amd advice declaration advicedeclaration compilation weaving amd annotations is annotation style pointcut isannotationstylepointcut amd annotations pointcuts defined annotations resolved pointcut definition resolvedpointcutdefinition make resolved pointcut definition makeresolvedpointcutdefinition amd declared pointcuts declaredpointcuts add amd binding amd binding is valid binding isvalidbinding resolved member resolvedmember member factory make resolved member makeresolvedmember amd binding unit member set source context setsourcecontext eclipse source context eclipsesourcecontext unit compilation result compilationresult amd binding source start sourcestart member set position setposition amd binding source start sourcestart amd binding source end sourceend declared methods declaredmethods add member field binding fieldbinding fields binding fields len fields length len field binding fieldbinding fields declared fields declaredfields add factory make resolved member makeresolvedmember declared pointcuts declaredpointcuts resolved pointcut definition resolvedpointcutdefinition declared pointcuts declaredpointcuts to array toarray resolved pointcut definition resolvedpointcutdefinition declared pointcuts declaredpointcuts size declared methods declaredmethods resolved member resolvedmember declared methods declaredmethods to array toarray resolved member resolvedmember declared methods declaredmethods size declared fields declaredfields resolved member resolvedmember declared fields declaredfields to array toarray resolved member resolvedmember declared fields declaredfields size resolved pointcut definition resolvedpointcutdefinition make resolved pointcut definition makeresolvedpointcutdefinition abstract method declaration abstractmethoddeclaration resolved pointcut definition resolvedpointcutdefinition resolved pointcut declaration resolvedpointcutdeclaration resolved pointcut definition resolvedpointcutdefinition factory from binding frombinding binding declaring class declaringclass modifiers string selector factory from bindings frombindings binding parameters resolved pointcut declaration resolvedpointcutdeclaration set position setposition source start sourcestart source end sourceend resolved pointcut declaration resolvedpointcutdeclaration set source context setsourcecontext eclipse source context eclipsesourcecontext compilation result compilationresult resolved pointcut declaration resolvedpointcutdeclaration method fields include ajc init failure cause initfailurecause ajc per singleton instance persingletoninstance fields bug resolved member resolvedmember get declared fields getdeclaredfields declared fields declaredfields fill declared members filldeclaredmembers declared fields declaredfields method methods include clinit aspect of aspectof has aspect hasaspect ajc post clinit postclinit methods bug resolved member resolvedmember get declared methods getdeclaredmethods declared methods declaredmethods fill declared members filldeclaredmembers declared methods declaredmethods resolved member resolvedmember get declared pointcuts getdeclaredpointcuts declared pointcuts declaredpointcuts fill declared members filldeclaredmembers declared pointcuts declaredpointcuts get modifiers getmodifiers real java modifiers extra eclipse binding modifiers compiler modifiers compilermodifiers acc just flag accjustflag string to string tostring eclipse source type eclipsesourcetype string binding source name sourcename xxx applied classes interfaces check pointcut declarations checkpointcutdeclarations resolved member resolvedmember pointcuts get declared pointcuts getdeclaredpointcuts saw error sawerror len pointcuts length len pointcuts is abstract isabstract is aspect isaspect eclipse world eclipseworld show message showmessage imessage error pointcut allowed aspect pointcuts get name getname pointcuts get source location getsourcelocation saw error sawerror binding is abstract isabstract eclipse world eclipseworld show message showmessage imessage error pointcut concrete aspect pointcuts pointcuts get source location getsourcelocation saw error sawerror len pointcuts get name getname equals pointcuts get name getname eclipse world eclipseworld show message showmessage imessage error duplicate pointcut pointcuts get name getname pointcuts get source location getsourcelocation pointcuts get source location getsourcelocation saw error sawerror check inherited pointcuts handled saw error sawerror is aspect isaspect find pointcuts override check override legal signatures greater equal visibility find inherited pointcuts concretized concrete find inherited pointcuts don conflict odd construction get resolved type x getresolvedtypex get exposed pointcuts getexposedpointcuts crosscutting members crosscuttingmembers collect crosscutting members collectcrosscuttingmembers crosscutting members crosscuttingmembers isource location isourcelocation get source location getsourcelocation type declaration typedeclaration dec binding scope reference context referencecontext eclipse source location eclipsesourcelocation dec compilation result compilationresult dec source start sourcestart dec source end sourceend is interface isinterface binding is interface isinterface xxxaj constants eclipse compiler supports acc annotation acc enum is enum isenum binding get access flags getaccessflags acc enum is annotation isannotation binding get access flags getaccessflags acc annotation add annotation addannotation annotation x annotationx annotation x annotationx method called practice runtime exception runtimeexception eclipse source type eclipsesourcetype add annotation addannotation implemented is annotation with runtime retention isannotationwithruntimeretention is annotation isannotation binding get annotation tag bits getannotationtagbits tag bits tagbits annotation retention mask annotationretentionmask tag bits tagbits annotation runtime retention annotationruntimeretention string get retention policy getretentionpolicy is annotation isannotation binding get annotation tag bits getannotationtagbits tag bits tagbits annotation retention mask annotationretentionmask tag bits tagbits annotation runtime retention annotationruntimeretention runtime binding get annotation tag bits getannotationtagbits tag bits tagbits annotation retention mask annotationretentionmask tag bits tagbits annotation source retention annotationsourceretention source binding get annotation tag bits getannotationtagbits tag bits tagbits annotation retention mask annotationretentionmask tag bits tagbits annotation class retention annotationclassretention can annotation target type canannotationtargettype is annotation isannotation binding get annotation tag bits getannotationtagbits tag bits tagbits annotation for type annotationfortype annotation target kind annotationtargetkind get annotation target kinds getannotationtargetkinds discovered annotation target kinds discoveredannotationtargetkinds annotation target kinds annotationtargetkinds discovered annotation target kinds discoveredannotationtargetkinds idea target annotation hasn annotation target kinds annotationtargetkinds target kind targetkind is annotation isannotation list target kinds targetkinds array list arraylist binding get annotation tag bits getannotationtagbits tag bits tagbits annotation for annotation type annotationforannotationtype target kinds targetkinds add annotation target kind annotationtargetkind annotation type binding get annotation tag bits getannotationtagbits tag bits tagbits annotation for constructor annotationforconstructor target kinds targetkinds add annotation target kind annotationtargetkind constructor binding get annotation tag bits getannotationtagbits tag bits tagbits annotation for field annotationforfield target kinds targetkinds add annotation target kind annotationtargetkind field binding get annotation tag bits getannotationtagbits tag bits tagbits annotation for local variable annotationforlocalvariable target kinds targetkinds add annotation target kind annotationtargetkind local variable binding get annotation tag bits getannotationtagbits tag bits tagbits annotation for method annotationformethod target kinds targetkinds add annotation target kind annotationtargetkind method binding get annotation tag bits getannotationtagbits tag bits tagbits annotation for package annotationforpackage target kinds targetkinds add annotation target kind annotationtargetkind binding get annotation tag bits getannotationtagbits tag bits tagbits annotation for parameter annotationforparameter target kinds targetkinds add annotation target kind annotationtargetkind parameter binding get annotation tag bits getannotationtagbits tag bits tagbits annotation for type annotationfortype target kinds targetkinds add annotation target kind annotationtargetkind type target kinds targetkinds is empty isempty annotation target kinds annotationtargetkinds annotation target kind annotationtargetkind target kinds targetkinds size annotation target kind annotationtargetkind target kinds targetkinds to array toarray annotation target kinds annotationtargetkinds annotation target kinds annotationtargetkinds has annotation hasannotation unresolved type unresolvedtype of type oftype resolved annotations resolved annotationsresolved type declaration typedeclaration resolve annotations resolveannotations declaration static initializer scope staticinitializerscope declaration annotations binding annotations resolved annotationsresolved annotation declaration annotations length annotation annotation annotation resolved type resolvedtype result separate error message string tname char operation charoperation char to string chartostring annotation resolved type resolvedtype constant pool name constantpoolname unresolved type unresolvedtype for name forname tname equals of type oftype annotation x annotationx get annotations getannotations runtime exception runtimeexception missing implementation resolved type resolvedtype get annotation types getannotationtypes resolved annotations resolvedannotations resolved annotations resolvedannotations resolved annotations resolved annotationsresolved type declaration typedeclaration resolve annotations resolveannotations declaration static initializer scope staticinitializerscope declaration annotations binding annotations resolved annotationsresolved declaration annotations resolved annotations resolvedannotations resolved type resolvedtype resolved annotations resolvedannotations resolved type resolvedtype declaration annotations length annotation declaration annotations length annotation annotation resolved annotations resolvedannotations factory from type binding to rtx fromtypebindingtortx annotation type resolved type resolvedtype resolved annotations resolvedannotations per clause perclause get per clause getperclause stage compilation worth trouble is annotation style aspect isannotationstyleaspect declaration aspect declaration aspectdeclaration per clause perclause aspect declaration aspectdeclaration declaration per clause perclause per singleton persingleton aspect real kind don real per clause perclause perclause per clause perclause declaration aspect declaration aspectdeclaration aspect declaration aspectdeclaration declaration per clause perclause per clause perclause kind kind get per clause for type declaration getperclausefortypedeclaration declaration returning per from super perfromsuper correct kind hack per from super perfromsuper kind per clause perclause kind get per clause for type declaration getperclausefortypedeclaration type declaration typedeclaration type declaration typedeclaration annotation annotations type declaration typedeclaration annotations annotations length annotation annotation annotations char operation charoperation equals aspect sig aspectsig annotation resolved type resolvedtype signature aspect annotation member value pairs membervaluepairs annotation member value pairs membervaluepairs length aspect aspect per from super perfromsuper declaration aspect per clause perclause kind kind lookup per clause kind lookupperclausekind type declaration typedeclaration binding superclass aspect aspect singleton kind per clause perclause singleton kind annotation single member annotation singlememberannotation aspect single member annotation singlememberannotation the annotation theannotation single member annotation singlememberannotation annotation todo safe string clause string string literal stringliteral the annotation theannotation member value membervalue source determine per clause determineperclause type declaration typedeclaration clause annotation normal annotation normalannotation kind visitor aspect normal annotation normalannotation the annotation theannotation normal annotation normalannotation annotation the annotation theannotation member value pairs membervaluepairs the annotation theannotation member value pairs membervaluepairs length per clause perclause singleton todo safe string clause string string literal stringliteral the annotation theannotation member value pairs membervaluepairs source determine per clause determineperclause type declaration typedeclaration clause eclipse world eclipseworld show message showmessage imessage abort aspect annotation expected single member annotation singlememberannotation string unique element eclipse source location eclipsesourcelocation type declaration typedeclaration compilation result compilationresult type declaration typedeclaration source start sourcestart type declaration typedeclaration source end sourceend fallback strategy avoid npe per clause perclause singleton aspect annotation aspect per clause perclause kind determine per clause determineperclause type declaration typedeclaration type declaration typedeclaration string clause clause starts with startswith perthis per clause perclause perobject clause starts with startswith pertarget per clause perclause perobject clause starts with startswith percflow per clause perclause percflow clause starts with startswith percflowbelow per clause perclause percflow clause starts with startswith pertypewithin per clause perclause pertypewithin clause starts with startswith issingleton per clause perclause singleton eclipse world eclipseworld show message showmessage imessage abort determine per clause perclause clause eclipse source location eclipsesourcelocation type declaration typedeclaration compilation result compilationresult type declaration typedeclaration source start sourcestart type declaration typedeclaration source end sourceend fallback strategy avoid npe per clause perclause singleton adapted aspect declaration aspectdeclaration per clause perclause kind lookup per clause kind lookupperclausekind reference binding referencebinding binding per clause perclause kind kind binding binary type binding binarytypebinding resolved type resolvedtype super type x supertypex factory from eclipse fromeclipse binding per clause perclause per clause perclause super type x supertypex get per clause getperclause clause aspect classes coming bcel attributes per clause perclause kind super type x supertypex get per clause getperclause get kind getkind kind binding source type binding sourcetypebinding source type binding sourcetypebinding source sc sourcesc source type binding sourcetypebinding binding source sc sourcesc scope reference context referencecontext aspect declaration aspectdeclaration code style kind aspect declaration aspectdeclaration source sc sourcesc scope reference context referencecontext per clause perclause get kind getkind source sc sourcesc scope reference context referencecontext type declaration typedeclaration aspect per from super perfromsuper aspect anno kind get per clause for type declaration getperclausefortypedeclaration type declaration typedeclaration source sc sourcesc scope reference context referencecontext xxx happen kind xxx handle kind kind collection get declares getdeclares declares collection get privileged accesses getprivilegedaccesses collections empty list collection get type mungers gettypemungers type mungers typemungers does not expose shadow mungers doesnotexposeshadowmungers string get declared generic signature getdeclaredgenericsignature char operation charoperation char to string chartostring binding generic signature genericsignature is generic isgeneric binding is generic type isgenerictype type variable typevariable get type variables gettypevariables declaration type parameters typeparameters type variable typevariable type variable typevariable type variables typevariables type variable typevariable declaration type parameters typeparameters length type variables typevariables length type variables typevariables type parameter typeparameter type variable typevariable declaration type parameters typeparameters type variables typevariables type variable typevariable type parameter typeparameter type variable typevariable type parameter typeparameter a type parameter atypeparameter string string a type parameter atypeparameter reference binding referencebinding superclass binding superclassbinding a type parameter atypeparameter binding superclass unresolved type unresolvedtype superclass unresolved type unresolvedtype for signature forsignature string superclass binding superclassbinding signature unresolved type unresolvedtype superinterfaces reference binding referencebinding super interface bindings superinterfacebindings a type parameter atypeparameter binding super interfaces superinterfaces super interface bindings superinterfacebindings superinterfaces unresolved type unresolvedtype super interface bindings superinterfacebindings length super interface bindings superinterfacebindings length superinterfaces unresolved type unresolvedtype for signature forsignature string super interface bindings superinterfacebindings signature xxx binding type variable typevariable type variable typevariable superclass superinterfaces set declaring element setdeclaringelement factory from binding frombinding a type parameter atypeparameter binding declaring element declaringelement set rank setrank a type parameter atypeparameter binding rank ensure delegate consistent ensuredelegateconsistent inconsistent phew