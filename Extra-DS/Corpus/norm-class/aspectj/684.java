copyright ibm corporation rights reserved program accompanying materials terms common license accompanies distribution http eclipse org legal cpl html contributors ibm corporation initial api implementation org aspectj ajdt internal core builder java util array list arraylist java util collection java util hash map hashmap java util locale java util map java util properties org aspectj ajdt core aspect jcore aspectjcore org aspectj ajdt internal compiler compiler adapter compileradapter org aspectj ajdt internal compiler ibinary source provider ibinarysourceprovider org aspectj ajdt internal compiler icompiler adapter icompileradapter org aspectj ajdt internal compiler icompiler adapter factory icompileradapterfactory org aspectj ajdt internal compiler iintermediate results requestor iintermediateresultsrequestor org aspectj ajdt internal compiler ioutput class file name provider ioutputclassfilenameprovider org aspectj ajdt internal compiler interim compilation result interimcompilationresult org aspectj ajdt internal compiler lookup aj lookup environment ajlookupenvironment org aspectj ajdt internal compiler lookup eclipse factory eclipsefactory org aspectj ajdt internal compiler problem aj problem reporter ajproblemreporter org aspectj bridge abort exception abortexception org aspectj bridge imessage org aspectj bridge imessage handler imessagehandler org aspectj bridge imessage kind org aspectj org eclipse jdt core ijava model marker ijavamodelmarker org aspectj org eclipse jdt core java core javacore org aspectj org eclipse jdt core java model exception javamodelexception org aspectj org eclipse jdt internal compiler compilation result compilationresult org aspectj org eclipse jdt internal compiler compiler org aspectj org eclipse jdt internal compiler default error handling policies defaulterrorhandlingpolicies org aspectj org eclipse jdt internal compiler problem default problem factory defaultproblemfactory org aspectj org eclipse jdt internal core builder batch image builder batchimagebuilder org aspectj org eclipse jdt internal core builder build notifier buildnotifier org aspectj org eclipse jdt internal core builder incremental image builder incrementalimagebuilder org aspectj org eclipse jdt internal core builder java builder javabuilder org aspectj weaver lint org aspectj weaver bcel bcel weaver bcelweaver org aspectj weaver bcel bcel world bcelworld org eclipse core resources imarker org eclipse core resources iproject org eclipse core runtime core exception coreexception org eclipse core runtime ipath org eclipse core runtime iprogress monitor iprogressmonitor org eclipse core runtime path author colyer builder ajdt org eclipse ajdt core plugin references aspect jbuilder aspectjbuilder java builder javabuilder icompiler adapter factory icompileradapterfactory builder instance project bcel weaver bcelweaver my weaver myweaver bcel world bcelworld my bcel world mybcelworld eclipse class path manager eclipseclasspathmanager cp manager cpmanager unwoven result collector unwovenresultcollector unwoven result collector unwovenresultcollector output file name provider outputfilenameprovider file name provider filenameprovider is batch build isbatchbuild javadoc org eclipse core internal events internal builder internalbuilder build java util map org eclipse core runtime iprogress monitor iprogressmonitor iproject build kind map iprogress monitor iprogressmonitor monitor core exception coreexception method construction xxximage builder xxximagebuilder construction compiler detected adapter compiler adapter compileradapter set compiler adapter factory setcompileradapterfactory build kind monitor batch image builder batchimagebuilder get batch image builder getbatchimagebuilder is batch build isbatchbuild aj batch image builder ajbatchimagebuilder incremental image builder incrementalimagebuilder get incremental image builder getincrementalimagebuilder is batch build isbatchbuild aj incremental image builder ajincrementalimagebuilder javadoc org eclipse jdt internal compiler icompiler adapter factory icompileradapterfactory get adapter getadapter org eclipse jdt internal compiler compiler icompiler adapter icompileradapter get adapter getadapter compiler for compiler forcompiler map java options javaoptions for compiler forcompiler options get map getmap todo aspectj options project add map aj compiler options ajcompileroptions aj options ajoptions aj compiler options ajcompileroptions java options javaoptions for compiler forcompiler options aj options ajoptions is batch build isbatchbuild my bcel world mybcelworld my weaver myweaver init world and weaver initworldandweaver aj options ajoptions update name environment nameenvironment time compile cp manager cpmanager set name environment setnameenvironment name environment nameenvironment eclipse factory create aj lookup environment ajlookupenvironment hide aj build manager ajbuildmanager field aj problem reporter ajproblemreporter aj problem reporter ajproblemreporter default error handling policies defaulterrorhandlingpolicies proceed with all problems proceedwithallproblems for compiler forcompiler options default problem factory defaultproblemfactory locale get default getdefault for compiler forcompiler problem reporter problemreporter aj lookup environment ajlookupenvironment aj lookup environment ajlookupenvironment for compiler forcompiler for compiler forcompiler options name environment nameenvironment eclipse factory eclipsefactory e factory efactory eclipse factory eclipsefactory my bcel world mybcelworld aj options ajoptions x serializable aspects xserializableaspects factory e factory efactory for compiler forcompiler lookup environment lookupenvironment aj build notifier ajbuildnotifier aj notifier ajnotifier aj build notifier ajbuildnotifier notifier file name provider filenameprovider file name provider filenameprovider output file name provider outputfilenameprovider get project getproject binary source entries compile analyzing deltas batch full binary source entries project iaspect jproject iaspectjproject todo deal inpath injars ibinary source provider ibinarysourceprovider bs provider bsprovider null binary source provider nullbinarysourceprovider map full binary source entries fullbinarysourceentries hash map hashmap intermediate result batch compile is batch build isbatchbuild unwoven result collector unwovenresultcollector unwoven result collector unwovenresultcollector collection result set for full weave resultsetforfullweave unwoven result collector unwovenresultcollector get intermediate results getintermediateresults unsupported operation exception unsupportedoperationexception aspect jbuilder aspectjbuilder aj compiler adapter ajcompileradapter for compiler forcompiler is batch build isbatchbuild my bcel world mybcelworld my weaver myweaver e factory efactory unwoven result collector unwovenresultcollector aj notifier ajnotifier file name provider filenameprovider bs provider bsprovider full binary source entries fullbinarysourceentries result set for full weave resultsetforfullweave aj options ajoptions no weave noweave aj options ajoptions proceed on error proceedonerror aj options ajoptions no at aspect jprocessing noataspectjprocessing javadoc org eclipse jdt internal core builder java builder javabuilder create build notifier createbuildnotifier org eclipse core runtime iprogress monitor iprogressmonitor org eclipse core resources iproject build notifier buildnotifier create build notifier createbuildnotifier iprogress monitor iprogressmonitor monitor iproject current project currentproject aj build notifier ajbuildnotifier monitor current project currentproject init world and weaver initworldandweaver aj compiler options ajcompileroptions options cp manager cpmanager eclipse class path manager eclipseclasspathmanager name environment nameenvironment my bcel world mybcelworld bcel world bcelworld cp manager cpmanager unhandled message handler unhandledmessagehandler get project getproject xref handler xrefhandler my bcel world mybcelworld set behave in java setbehaveinjava options behave in java behaveinjava my bcel world mybcelworld set target aspectj runtime level settargetaspectjruntimelevel options target aspectj runtime level targetaspectjruntimelevel my bcel world mybcelworld set xno inline setxnoinline options x no inline xnoinline my bcel world mybcelworld set xlazy tjp setxlazytjp options x lazy this join point xlazythisjoinpoint my bcel world mybcelworld set xhas member support enabled setxhasmembersupportenabled options x has member xhasmember my bcel world mybcelworld set pinpoint mode setpinpointmode options xdev pinpoint xdevpinpoint set lint properties setlintproperties my bcel world mybcelworld options my weaver myweaver bcel weaver bcelweaver my bcel world mybcelworld my weaver myweaver set reweavable mode setreweavablemode options x not reweavable xnotreweavable todo deal injars inpath aspectpath set lint properties setlintproperties bcel world bcelworld aj compiler options ajcompileroptions options properties properties lint lint settings lintsettings get lint getlint map map options get map getmap lint settings lintsettings invalid absolute type name invalidabsolutetypename get name getname map aj compiler options ajcompileroptions option report invalid absolute type name reportinvalidabsolutetypename lint settings lintsettings invalid wildcard type name invalidwildcardtypename get name getname map aj compiler options ajcompileroptions option report invalid wildcard type name reportinvalidwildcardtypename lint settings lintsettings unresolvable member unresolvablemember get name getname map aj compiler options ajcompileroptions option report unresolvable member reportunresolvablemember lint settings lintsettings type not exposed to weaver typenotexposedtoweaver get name getname map aj compiler options ajcompileroptions option report type not exposed to weaver reporttypenotexposedtoweaver lint settings lintsettings shadow not in structure shadownotinstructure get name getname map aj compiler options ajcompileroptions option report shadow not in structure reportshadownotinstructure lint settings lintsettings unmatched super type in call unmatchedsupertypeincall get name getname map aj compiler options ajcompileroptions option report unmatched super type in call reportunmatchedsupertypeincall lint settings lintsettings can not implement lazy tjp cannotimplementlazytjp get name getname map aj compiler options ajcompileroptions option report cannot implement lazy tjp reportcannotimplementlazytjp lint settings lintsettings needs serial version uidfield needsserialversionuidfield get name getname map aj compiler options ajcompileroptions option report need serial version uidfield reportneedserialversionuidfield lint settings lintsettings serial version uidbroken serialversionuidbroken get name getname map aj compiler options ajcompileroptions option report incompatible serial version reportincompatibleserialversion lint settings lintsettings set from properties setfromproperties unwoven result collector unwovenresultcollector iintermediate results requestor iintermediateresultsrequestor collection array list arraylist javadoc org aspectj ajdt internal compiler iintermediate results requestor iintermediateresultsrequestor accept result acceptresult org aspectj ajdt internal compiler interim compilation result interimcompilationresult accept result acceptresult interim compilation result interimcompilationresult int res intres add int res intres collection get intermediate results getintermediateresults unhandled message handler unhandledmessagehandler imessage handler imessagehandler iproject project unhandled message handler unhandledmessagehandler iproject project javadoc org aspectj bridge imessage handler imessagehandler handle message handlemessage org aspectj bridge imessage handle message handlemessage imessage message abort exception abortexception imarker marker project create marker createmarker ijava model marker ijavamodelmarker java model problem marker marker set attribute setattribute imarker message message get message getmessage marker set attribute setattribute imarker severity message is error iserror imarker severity error imarker severity warning core exception coreexception aspect jcore aspectjcore get plugin getplugin get log getlog log get status getstatus javadoc org aspectj bridge imessage handler imessagehandler is ignoring isignoring org aspectj bridge imessage kind is ignoring isignoring kind kind kind imessage debug kind imessage info org aspectj bridge imessage handler imessagehandler is ignoring isignoring org aspectj bridge imessage kind param kind dont ignore dontignore imessage kind kind output file name provider outputfilenameprovider ioutput class file name provider ioutputclassfilenameprovider ipath output location outputlocation output file name provider outputfilenameprovider iproject output location outputlocation java core javacore create get output location getoutputlocation java model exception javamodelexception output location outputlocation path aspect jcore aspectjcore get plugin getplugin get log getlog log get status getstatus javadoc org aspectj ajdt internal compiler ioutput class file name provider ioutputclassfilenameprovider get output class file name getoutputclassfilename org eclipse jdt internal compiler compilation result compilationresult string get output class file name getoutputclassfilename eclipse class file name eclipseclassfilename compilation result compilationresult result ajdt implementation write xxx image builder xxximagebuilder accept result acceptresult simply output directory project string filename string eclipse class file name eclipseclassfilename ipath output location outputlocation append filename add file extension addfileextension to osstring toosstring impl implementation extended cope inpath injars null binary source provider nullbinarysourceprovider ibinary source provider ibinarysourceprovider javadoc org aspectj ajdt internal compiler ibinary source provider ibinarysourceprovider get binary sources for this weave getbinarysourcesforthisweave map get binary sources for this weave getbinarysourcesforthisweave hash map hashmap