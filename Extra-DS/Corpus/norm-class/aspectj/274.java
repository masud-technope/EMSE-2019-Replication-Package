copyright ibm rights reserved program accompanying materials terms common license accompanies distribution http eclipse org legal cpl html contributors andy clement initial implementation org aspectj apache bcel classfile tests java file java util array list arraylist java util list org aspectj apache bcel constants org aspectj apache bcel classfile attribute org aspectj apache bcel classfile java class javaclass org aspectj apache bcel classfile method org aspectj apache bcel classfile annotation annotation org aspectj apache bcel aload org aspectj apache bcel astore org aspectj apache bcel array type arraytype org aspectj apache bcel class gen classgen org aspectj apache bcel constant pool gen constantpoolgen org aspectj apache bcel org aspectj apache bcel instruction constants instructionconstants org aspectj apache bcel instruction factory instructionfactory org aspectj apache bcel instruction handle instructionhandle org aspectj apache bcel instruction list instructionlist org aspectj apache bcel local variable gen localvariablegen org aspectj apache bcel method gen methodgen org aspectj apache bcel object type objecttype org aspectj apache bcel push org aspectj apache bcel type org aspectj apache bcel annotation annotation element value gen annotationelementvaluegen org aspectj apache bcel annotation annotation gen annotationgen org aspectj apache bcel annotation array element value gen arrayelementvaluegen org aspectj apache bcel annotation element name value pair gen elementnamevaluepairgen org aspectj apache bcel annotation element value gen elementvaluegen org aspectj apache bcel annotation simple element value gen simpleelementvaluegen org aspectj apache bcel util synthetic repository syntheticrepository program tests generate hello world helloworld main string argv buffered reader bufferedreader buffered reader bufferedreader input stream reader inputstreamreader system string andy ioexception system println parameter annotations test parameterannotationstest bcel test case bceltestcase set up setup exception set up setup programmatically construct add annotation main method parameter argv test parameter annotations testparameterannotations built ok builtok class gen classgen clg create class gen createclassgen hello world helloworld constant pool gen constantpoolgen cpg clg get constant pool getconstantpool instruction list instructionlist instruction list instructionlist build class contents with annotated methods buildclasscontentswithannotatedmethods clg cpg clg get methods getmethods length assert true asserttrue methods method main method mainmethod clg get methods getmethods annotation annos main method mainmethod get annotations on parameter getannotationsonparameter assert true asserttrue annotation argv parameter main annos length annos length assert true asserttrue annotation string fruit apples annos to string tostring annos to string tostring index of indexof fruit apples assert true asserttrue annotation string fruit oranges annos to string tostring annos to string tostring index of indexof fruit oranges check save load constructed parameter annotations test parameter annotations testparameterannotations saved and loaded ok savedandloadedok class not found exception classnotfoundexception class gen classgen clg create class gen createclassgen hello world helloworld constant pool gen constantpoolgen cpg clg get constant pool getconstantpool instruction list instructionlist instruction list instructionlist build class contents with annotated methods buildclasscontentswithannotatedmethods clg cpg dump class dumpclass clg temp hello world helloworld java class javaclass get class from getclassfrom temp hello world helloworld clg class gen classgen clg get methods getmethods length assert true asserttrue methods method main method mainmethod clg get methods getmethods annotation annos main method mainmethod get annotations on parameter getannotationsonparameter assert true asserttrue annotation argv parameter main annos length annos length assert true asserttrue annotation string fruit apples annos to string tostring annos to string tostring index of indexof fruit apples assert true asserttrue annotation string fruit oranges annos to string tostring annos to string tostring index of indexof fruit oranges assert true asserttrue wipe temp hello world helloworld load existing add parameter annotations save reload test parameter annotations testparameterannotations loaded then modified then saved and loaded ok loadedthenmodifiedthensavedandloadedok class not found exception classnotfoundexception java class javaclass get class from getclassfrom testcode jar annotated parameters annotatedparameters class gen classgen clg class gen classgen constant pool gen constantpoolgen cpg clg get constant pool getconstantpool foo method foo simple annotation simpleannotation arg simple annotation simpleannotation annotation enum element annotationenumelement enumval simple enum simpleenum red string arg method find method findmethod clg foo assert true asserttrue find method foo couldn check number annotations get annotations on parameter getannotationsonparameter length assert true asserttrue annotations parameter add parameter annotation visible parameter build modifiable version foo method method gen methodgen method gen methodgen clg get class name getclassname cpg check annotations survived transform get annotations on parameter getannotationsonparameter size assert true asserttrue annotations parameter worked add parameter annotation add parameter annotation addparameterannotation create fruit annotation createfruitannotation cpg banana foo method foo simple annotation simpleannotation simple string annotation simplestringannotation fruit banana arg simple annotation simpleannotation annotation enum element annotationenumelement enumval simple enum simpleenum red string arg get annotations on parameter getannotationsonparameter size assert true asserttrue parameter annotations get annotations on parameter getannotationsonparameter to string tostring index of indexof fruit banana assert true asserttrue expected fruit banana annotation argument get annotations on parameter getannotationsonparameter to string tostring delete method add clg remove method removemethod clg add method addmethod get method getmethod dump disk dump class dumpclass clg temp annotated parameters annotatedparameters load verify annotations persisted java class javaclass get class from getclassfrom temp annotated parameters annotatedparameters get methods getmethods annotation annotations get annotations on parameter getannotationsonparameter annotation annotations get annotations on parameter getannotationsonparameter assert true asserttrue expected annotations parameter annotations length annotations length assert true asserttrue expected annotations parameter annotations length annotations length string expected string expectedstring simple annotation simpleannotation simple string annotation simplestringannotation fruit banana assert true asserttrue expected formatted string expected string expectedstring dump annotations dumpannotations annotations dump annotations dumpannotations annotations equals expected string expectedstring expected string expectedstring simple annotation simpleannotation annotation enum element annotationenumelement enumval red assert true asserttrue expected formatted string expected string expectedstring dump annotations dumpannotations annotations dump annotations dumpannotations annotations equals expected string expectedstring assert true asserttrue wipe temp annotated parameters annotatedparameters test attaching invisible runtime parameter annotations test parameter annotations testparameterannotations loaded then modified with invisible annotation then saved and loaded ok loadedthenmodifiedwithinvisibleannotationthensavedandloadedok class not found exception classnotfoundexception java class javaclass get class from getclassfrom testcode jar annotated parameters annotatedparameters class gen classgen clg class gen classgen constant pool gen constantpoolgen cpg clg get constant pool getconstantpool foo method foo simple annotation simpleannotation arg simple annotation simpleannotation annotation enum element annotationenumelement enumval simple enum simpleenum red string arg method find method findmethod clg foo assert true asserttrue find method foo couldn check number annotations get annotations on parameter getannotationsonparameter length assert true asserttrue annotations parameter add parameter annotation visible parameter build modifiable version foo method method gen methodgen method gen methodgen clg get class name getclassname cpg check annotations survived transform get annotations on parameter getannotationsonparameter size assert true asserttrue annotations parameter worked add parameter annotation add parameter annotation addparameterannotation create fruit annotation createfruitannotation cpg banana foo method foo simple annotation simpleannotation simple string annotation simplestringannotation fruit banana arg simple annotation simpleannotation annotation enum element annotationenumelement enumval simple enum simpleenum red string arg get annotations on parameter getannotationsonparameter size assert true asserttrue parameter annotations get annotations on parameter getannotationsonparameter to string tostring index of indexof fruit banana assert true asserttrue expected fruit banana annotation argument get annotations on parameter getannotationsonparameter to string tostring assert true asserttrue annotation runtime invisible annotation gen annotationgen get annotations on parameter getannotationsonparameter is runtime visible isruntimevisible delete method add clg remove method removemethod clg add method addmethod get method getmethod dump disk dump class dumpclass clg temp annotated parameters annotatedparameters load verify annotations persisted java class javaclass get class from getclassfrom temp annotated parameters annotatedparameters get methods getmethods annotation annotations get annotations on parameter getannotationsonparameter annotation annotations get annotations on parameter getannotationsonparameter assert true asserttrue expected annotations parameter annotations length annotations length assert true asserttrue expected annotations parameter annotations length annotations length string expected string expectedstring simple annotation simpleannotation simple string annotation simplestringannotation fruit banana assert true asserttrue expected formatted string expected string expectedstring dump annotations dumpannotations annotations dump annotations dumpannotations annotations equals expected string expectedstring expected string expectedstring simple annotation simpleannotation annotation enum element annotationenumelement enumval red assert true asserttrue expected formatted string expected string expectedstring dump annotations dumpannotations annotations dump annotations dumpannotations annotations equals expected string expectedstring assert true asserttrue annotation parameter runtime invisible annotations is runtime visible isruntimevisible assert true asserttrue wipe temp annotated parameters annotatedparameters verify annotations parameters unpacked attributes attributes vanish clg class gen classgen method gen methodgen clg get class name getclassname clg get constant pool getconstantpool attribute get attributes getattributes assert true asserttrue ripa rvpa get attributes getattributes length get attributes getattributes length list get annotations on parameter getannotationsonparameter assert true asserttrue annotations parameter size to string tostring size assert true asserttrue get attributes getattributes length get attributes getattributes length method find method findmethod class gen classgen string mname method get methods getmethods length get name getname equals mname dump class dumpclass class gen classgen string fname file create testdata file createtestdatafile fname get java class getjavaclass dump java ioexception system err println dump class dumpclass class gen classgen string dir string fname dump class dumpclass dir file separator fname build class contents with annotated methods buildclasscontentswithannotatedmethods class gen classgen constant pool gen constantpoolgen instruction list instructionlist add parameter annotations addparameterannotations create method main string argv method gen methodgen create method gen createmethodgen main instruction factory instructionfactory factory instruction factory instructionfactory add annotation addannotation create simple visible annotation createsimplevisibleannotation get constant pool getconstantpool define types object type objecttype stream object type objecttype java input stream inputstream object type objecttype stream object type objecttype java print stream printstream create variables call constructors execute buffered reader bufferedreader input stream reader inputstreamreader system reference buffered reader bufferedreader object stays top stack stored newly allocated variable append factory create new createnew java buffered reader bufferedreader predefined constant append instruction constants instructionconstants dup append factory create new createnew java input stream reader inputstreamreader append instruction constants instructionconstants dup append factory create field access createfieldaccess java lang system stream constants getstatic append factory create invoke createinvoke java input stream reader inputstreamreader init type type stream constants invokespecial append factory create invoke createinvoke java buffered reader bufferedreader init type type object type objecttype java reader constants invokespecial local variable gen localvariablegen add local variable addlocalvariable object type objecttype java buffered reader bufferedreader get index getindex valid set start setstart append astore create local variable initialize add local variable addlocalvariable type string get index getindex append instruction constants instructionconstants aconst valid set start setstart append astore create block remember start block read standard input store variable instruction handle instructionhandle start append factory create field access createfieldaccess java lang system stream constants getstatic append push enter append factory create invoke createinvoke java print stream printstream print type type type string constants invokevirtual append aload append factory create invoke createinvoke java buffered reader bufferedreader read line readline type string type args constants invokevirtual instruction handle instructionhandle start append push andy append astore normal execution jump exception handler target address instruction handle instructionhandle append add exception handler simply returns method local variable gen localvariablegen add local variable addlocalvariable type get type gettype ljava ioexception slot get index getindex instruction handle instructionhandle handler append astore slot set start setstart handler set end setend append instruction constants instructionconstants add exception handler addexceptionhandler start handler object type objecttype java ioexception normal code continues branch target instruction handle instructionhandle append factory create field access createfieldaccess java lang system stream constants getstatic set target settarget printing string concatenation compiles string buffer stringbuffer operations append factory create new createnew type stringbuffer append instruction constants instructionconstants dup append push append factory create invoke createinvoke java lang string buffer stringbuffer init type type type string constants invokespecial append aload append factory create invoke createinvoke java lang string buffer stringbuffer append type stringbuffer type type string constants invokevirtual append factory create invoke createinvoke java lang string buffer stringbuffer to string tostring type string type args constants invokevirtual append factory create invoke createinvoke java print stream printstream println type type type string constants invokevirtual append instruction constants instructionconstants finalization stack size computed fly add constructor method empty add parameter annotation addparameterannotation create fruit annotation createfruitannotation apples add parameter annotation addparameterannotation create fruit annotation createfruitannotation oranges set max stack setmaxstack set max locals setmaxlocals add method addmethod get method getmethod instruction handles reused dispose add empty constructor addemptyconstructor constants acc build class contents buildclasscontents class gen classgen constant pool gen constantpoolgen instruction list instructionlist create method main string argv method gen methodgen create method gen createmethodgen main instruction factory instructionfactory factory instruction factory instructionfactory define types object type objecttype stream object type objecttype java input stream inputstream object type objecttype stream object type objecttype java print stream printstream create variables call constructors execute buffered reader bufferedreader input stream reader inputstreamreader system reference buffered reader bufferedreader object stays top stack stored newly allocated variable append factory create new createnew java buffered reader bufferedreader predefined constant append instruction constants instructionconstants dup append factory create new createnew java input stream reader inputstreamreader append instruction constants instructionconstants dup append factory create field access createfieldaccess java lang system stream constants getstatic append factory create invoke createinvoke java input stream reader inputstreamreader init type type stream constants invokespecial append factory create invoke createinvoke java buffered reader bufferedreader init type type object type objecttype java reader constants invokespecial local variable gen localvariablegen add local variable addlocalvariable object type objecttype java buffered reader bufferedreader get index getindex valid set start setstart append astore create local variable initialize add local variable addlocalvariable type string get index getindex append instruction constants instructionconstants aconst valid set start setstart append astore create block remember start block read standard input store variable instruction handle instructionhandle start append factory create field access createfieldaccess java lang system stream constants getstatic append push enter append factory create invoke createinvoke java print stream printstream print type type type string constants invokevirtual append aload append factory create invoke createinvoke java buffered reader bufferedreader read line readline type string type args constants invokevirtual instruction handle instructionhandle start append push andy append astore normal execution jump exception handler target address instruction handle instructionhandle append add exception handler simply returns method local variable gen localvariablegen add local variable addlocalvariable type get type gettype ljava ioexception slot get index getindex instruction handle instructionhandle handler append astore slot set start setstart handler set end setend append instruction constants instructionconstants add exception handler addexceptionhandler start handler object type objecttype java ioexception normal code continues branch target instruction handle instructionhandle append factory create field access createfieldaccess java lang system stream constants getstatic set target settarget printing string concatenation compiles string buffer stringbuffer operations append factory create new createnew type stringbuffer append instruction constants instructionconstants dup append push append factory create invoke createinvoke java lang string buffer stringbuffer init type type type string constants invokespecial append aload append factory create invoke createinvoke java lang string buffer stringbuffer append type stringbuffer type type string constants invokevirtual append factory create invoke createinvoke java lang string buffer stringbuffer to string tostring type string type args constants invokevirtual append factory create invoke createinvoke java print stream printstream println type type type string constants invokevirtual append instruction constants instructionconstants finalization stack size computed fly add constructor method empty set max stack setmaxstack set max locals setmaxlocals add method addmethod get method getmethod instruction handles reused dispose add empty constructor addemptyconstructor constants acc java class javaclass get class from getclassfrom string string clazzname class not found exception classnotfoundexception synthetic repository syntheticrepository repos create repos createrepos repos load class loadclass clazzname helper methods class gen classgen create class gen createclassgen string classname class gen classgen classname java lang object generated constants acc constants acc method gen methodgen create method gen createmethodgen string methodname instruction list instructionlist constant pool gen constantpoolgen method gen methodgen access flags constants acc constants acc type type argument types type array type arraytype type string arg names string argv method methodname method hello world helloworld annotation gen annotationgen create simple visible annotation createsimplevisibleannotation constant pool gen constantpoolgen simple element value gen simpleelementvaluegen evg simple element value gen simpleelementvaluegen element value gen elementvaluegen primitive element name value pair gen elementnamevaluepairgen nv gen nvgen element name value pair gen elementnamevaluepairgen evg object type objecttype object type objecttype simple annotation simpleannotation list elements array list arraylist elements add nv gen nvgen annotation gen annotationgen annotation gen annotationgen elements annotation gen annotationgen create combined annotation createcombinedannotation constant pool gen constantpoolgen create annotation instance annotation gen annotationgen create simple visible annotation createsimplevisibleannotation array element value gen arrayelementvaluegen array array element value gen arrayelementvaluegen array add element addelement annotation element value gen annotationelementvaluegen element name value pair gen elementnamevaluepairgen nvp element name value pair gen elementnamevaluepairgen array list elements array list arraylist elements add nvp annotation gen annotationgen object type objecttype combined annotation combinedannotation elements annotation gen annotationgen create simple invisible annotation createsimpleinvisibleannotation constant pool gen constantpoolgen simple element value gen simpleelementvaluegen evg simple element value gen simpleelementvaluegen element value gen elementvaluegen primitive element name value pair gen elementnamevaluepairgen nv gen nvgen element name value pair gen elementnamevaluepairgen evg object type objecttype object type objecttype simple annotation simpleannotation list elements array list arraylist elements add nv gen nvgen annotation gen annotationgen annotation gen annotationgen elements tear down teardown exception tear down teardown