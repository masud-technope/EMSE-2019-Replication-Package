copyright contributors rights reserved program accompanying materials terms eclipse license accompanies distribution http eclipse org legal epl html contributors ibm corporation initial api implementation helen hawkins iniital version org aspectj org eclipse jdt core dom java util map org eclipse core runtime iprogress monitor iprogressmonitor aj ast ajast ast creates aspect j aspectj syntax tree ast api rules param level api level level constants aj ast ajast level level creates aspect j aspectj syntax tree ast api rules clients method specifing link jls ast level cases dealing jdk param level api level level constants ast instance api rules exception illegal argument exception illegalargumentexception api level level constants aj ast ajast new aj ast newajast level level ast jls level ast jls illegal argument exception illegalargumentexception aj ast ajast level internal method method converts internal compiler ast source string compilation unit method intended called clients param level api level level constants param compilation unit declaration compilationunitdeclaration internal ast node compilation unit declaration param source string java compilation unit param options compiler options param working copy workingcopy working copy ast created param monitor progress monitor report progress request cancelation code code param is resolved isresolved compilation unit declaration resolved compilation unit node compilation unit compilationunit convert compilation unit convertcompilationunit level org aspectj org eclipse jdt internal compiler ast compilation unit declaration compilationunitdeclaration compilation unit declaration compilationunitdeclaration source map options is resolved isresolved org aspectj org eclipse jdt internal core compilation unit compilationunit working copy workingcopy iprogress monitor iprogressmonitor monitor astconverter converter aspect j aspectj extension factory astconverter get astconverter getastconverter options is resolved isresolved monitor create aj ast ajast difference method aj ast ajast ast aj ast ajast ast aj ast ajast new aj ast newajast level saved default node flag saveddefaultnodeflag ast get default node flag getdefaultnodeflag ast set default node flag setdefaultnodeflag astnode original binding resolver bindingresolver resolver is resolved isresolved default binding resolver defaultbindingresolver compilation unit declaration compilationunitdeclaration scope working copy workingcopy owner default binding resolver defaultbindingresolver binding tables bindingtables binding resolver bindingresolver ast set binding resolver setbindingresolver resolver converter set ast setast ast compilation unit compilationunit unit converter convert compilation unit declaration compilationunitdeclaration source unit set line end table setlineendtable compilation unit declaration compilationunitdeclaration compilation result compilationresult line separator positions lineseparatorpositions unit set java element setjavaelement working copy workingcopy ast set default node flag setdefaultnodeflag saved default node flag saveddefaultnodeflag unit creates unparented aspect declaration node owned ast aspect unspecified legal modifiers doc comment superclass superinterfaces empty body perclause privileged perclause method call code aspect declaration aspectdeclaration set per clause setperclause astnode code create privileged aspect method call code aspect declaration aspectdeclaration set privileged setprivileged code unparented aspect declaration node aspect declaration aspectdeclaration new aspect declaration newaspectdeclaration aspect declaration aspectdeclaration result aspect declaration aspectdeclaration result creates unparented ajtype declaration node owned ast unspecified legal modifiers doc comment superclass superinterfaces empty body create aspect method call code aj type declaration ajtypedeclaration set aspect setaspect code unparented ajtype declaration node aj type declaration ajtypedeclaration new aj type declaration newajtypedeclaration aj type declaration ajtypedeclaration result aj type declaration ajtypedeclaration result creates unparented advice declaration node owned ast declaration advice pointcut doc comment body opposed empty body unparented advice declaration node after advice declaration afteradvicedeclaration new after advice declaration newafteradvicedeclaration after advice declaration afteradvicedeclaration result after advice declaration afteradvicedeclaration result creates unparented returning advice declaration node owned ast declaration returning advice pointcut doc comment body opposed empty body unparented returning advice declaration node after returning advice declaration afterreturningadvicedeclaration new after returning advice declaration newafterreturningadvicedeclaration after returning advice declaration afterreturningadvicedeclaration result after returning advice declaration afterreturningadvicedeclaration result creates unparented throwing advice declaration node owned ast declaration throwing advice pointcut doc comment throwing body opposed empty body unparented throwing advice declaration node after throwing advice declaration afterthrowingadvicedeclaration new after throwing advice declaration newafterthrowingadvicedeclaration after throwing advice declaration afterthrowingadvicedeclaration result after throwing advice declaration afterthrowingadvicedeclaration result creates unparented advice declaration node owned ast declaration advice pointcut doc comment body opposed empty body unparented advice declaration node before advice declaration beforeadvicedeclaration new before advice declaration newbeforeadvicedeclaration before advice declaration beforeadvicedeclaration result before advice declaration beforeadvicedeclaration result creates unparented advice declaration node owned ast declaration advice pointcut doc comment type body opposed empty body unparented advice declaration node around advice declaration aroundadvicedeclaration new around advice declaration newaroundadvicedeclaration around advice declaration aroundadvicedeclaration result around advice declaration aroundadvicedeclaration result creates unparented declare constructor declaration node owned ast declaration declare annotation doc comment pattern node annotation declare kind unparented declare constructor declaration node exception unsupported operation exception unsupportedoperationexception operation jls ast declare at constructor declaration declareatconstructordeclaration new declare at constructor declaration newdeclareatconstructordeclaration declare at constructor declaration declareatconstructordeclaration result declare at constructor declaration declareatconstructordeclaration result creates unparented declare field declaration node owned ast declaration declare annotation doc comment pattern node annotation declare kind unparented declare field declaration node exception unsupported operation exception unsupportedoperationexception operation jls ast declare at field declaration declareatfielddeclaration new declare at field declaration newdeclareatfielddeclaration declare at field declaration declareatfielddeclaration result declare at field declaration declareatfielddeclaration result creates unparented declare method declaration node owned ast declaration declare annotation doc comment pattern node annotation declare kind unparented declare method declaration node exception unsupported operation exception unsupportedoperationexception operation jls ast declare at method declaration declareatmethoddeclaration new declare at method declaration newdeclareatmethoddeclaration declare at method declaration declareatmethoddeclaration result declare at method declaration declareatmethoddeclaration result creates unparented declare type declaration node owned ast declaration declare annotation doc comment pattern node annotation declare kind unparented declare type declaration node exception unsupported operation exception unsupportedoperationexception operation jls ast declare at type declaration declareattypedeclaration new declare at type declaration newdeclareattypedeclaration declare at type declaration declareattypedeclaration result declare at type declaration declareattypedeclaration result creates unparented declare error declaration node owned ast declaration declare error doc comment pointcut message unparented declare error declaration node declare error declaration declareerrordeclaration new declare error declaration newdeclareerrordeclaration declare error declaration declareerrordeclaration result declare error declaration declareerrordeclaration result creates unparented declare parents declaration node owned ast declaration declare parents doc comment child type pattern parent type pattern create declare parents method call code declare parents declaration declareparentsdeclaration set extends setextends code unparented declare parents declaration node declare parents declaration declareparentsdeclaration new declare parents declaration newdeclareparentsdeclaration declare parents declaration declareparentsdeclaration result declare parents declaration declareparentsdeclaration result creates unparented declare precedence declaration node owned ast declaration declare precedence doc comment type pattern list unparented declare precedence declaration node declare precedence declaration declareprecedencedeclaration new declare precedence declaration newdeclareprecedencedeclaration declare precedence declaration declareprecedencedeclaration result declare precedence declaration declareprecedencedeclaration result creates unparented declare soft declaration node owned ast declaration declare soft doc comment pointcut type pattern unparented declare soft declaration node declare soft declaration declaresoftdeclaration new declare soft declaration newdeclaresoftdeclaration declare soft declaration declaresoftdeclaration result declare soft declaration declaresoftdeclaration result creates unparented declare warning declaration node owned ast declaration declare warning doc comment pointcut message unparented declare warning declaration node declare warning declaration declarewarningdeclaration new declare warning declaration newdeclarewarningdeclaration declare warning declaration declarewarningdeclaration result declare warning declaration declarewarningdeclaration result creates unparented intertype field declaration node owned ast modifiers doc comment base type unspecified legal unparented intertype field declaration node inter type field declaration intertypefielddeclaration new inter type field declaration newintertypefielddeclaration inter type field declaration intertypefielddeclaration result inter type field declaration intertypefielddeclaration result creates unparented intertype method declaration node owned ast declaration method unspecified legal modifiers doc comment parameters type extra array dimensions thrown exceptions body opposed empty body unparented inter type method declaration node inter type method declaration intertypemethoddeclaration new inter type method declaration newintertypemethoddeclaration inter type method declaration intertypemethoddeclaration result inter type method declaration intertypemethoddeclaration result creates unparented pointcut declaration node owned ast declaration pointcut unspecified legal modifiers doc comment pointcut designator unparented pointcut declaration node pointcut declaration pointcutdeclaration new pointcut declaration newpointcutdeclaration pointcut declaration pointcutdeclaration result pointcut declaration pointcutdeclaration result creates unparented and pointcut andpointcut node owned ast declaration pointcut left pointcut designators unparented and pointcut andpointcut node and pointcut andpointcut new and pointcut newandpointcut and pointcut andpointcut result and pointcut andpointcut result creates unparented cflow pointcut cflowpointcut node owned ast declaration cflow pointcut body pointcut designator unparented cflow pointcut cflowpointcut node cflow pointcut cflowpointcut new cflow pointcut newcflowpointcut cflow pointcut cflowpointcut result cflow pointcut cflowpointcut result creates unparented not pointcut notpointcut node owned ast declaration pointcut body pointcut designator unparented not pointcut notpointcut node not pointcut notpointcut new not pointcut newnotpointcut not pointcut notpointcut result not pointcut notpointcut result creates unparented or pointcut orpointcut node owned ast declaration pointcut left pointcut designators unparented or pointcut orpointcut node or pointcut orpointcut new or pointcut neworpointcut or pointcut orpointcut result or pointcut orpointcut result creates unparented per cflow percflow node owned ast declaration percflow body pointcut designator unparented percflow node per cflow percflow new per cflow newpercflow per cflow percflow result per cflow percflow result creates unparented perobject node owned ast declaration perobject body pointcut designator unparented perobject node per object perobject new per object newperobject per object perobject result per object perobject result creates unparented pertypewithin node owned ast declaration pertypewithin unparented pertypewithin node per type within pertypewithin new per type within newpertypewithin per type within pertypewithin result per type within pertypewithin result creates unparented reference pointcut node owned ast declaration reference pointcut unparented reference pointcut node reference pointcut referencepointcut new reference pointcut newreferencepointcut reference pointcut referencepointcut result reference pointcut referencepointcut result creates unparented pointcut node owned ast declaration pointcut empty detail string edit detail string method call code default pointcut defaultpointcut set detail setdetail new string newstring code unparented pointcut node default pointcut defaultpointcut new default pointcut newdefaultpointcut default pointcut defaultpointcut result default pointcut defaultpointcut result creates unparented type pattern node owned ast declaration type pattern empty detail string edit detail string method call code default type pattern defaulttypepattern set detail setdetail new string newstring code unparented type pattern node default type pattern defaulttypepattern new default type pattern newdefaulttypepattern default type pattern defaulttypepattern result default type pattern defaulttypepattern result creates unparented signature pattern node owned ast declaration signature pattern empty detail string edit detail string method call code signature pattern signaturepattern set detail setdetail new string newstring code unparented signature pattern node signature pattern signaturepattern new signature pattern newsignaturepattern signature pattern signaturepattern result signature pattern signaturepattern result