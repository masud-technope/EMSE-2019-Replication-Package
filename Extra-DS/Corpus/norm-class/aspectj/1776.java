org aspectj apache bcel classfile apache software license version copyright apache software foundation rights reserved redistribution source binary forms modification permitted conditions met redistributions source code retain copyright notice list conditions disclaimer redistributions binary form reproduce copyright notice list conditions disclaimer documentation materials distribution user documentation included redistribution include acknowledgment product includes software developed apache software foundation http apache org alternately acknowledgment software party acknowledgments names apache apache software foundation apache bcel endorse promote products derived software prior written permission written permission contact apache apache org products derived software called apache apache bcel apache prior written permission apache software foundation software expressed implied warranties including limited implied warranties merchantability fitness purpose disclaimed event apache software foundation contributors liable direct indirect incidental special exemplary consequential damages including limited procurement substitute goods services loss data profits business interruption caused theory liability contract strict liability tort including negligence arising software advised possibility damage software consists voluntary contributions individuals behalf apache software foundation apache software foundation http apache org java util stack org aspectj apache bcel classfile annotation runtime invisible annotations runtimeinvisibleannotations org aspectj apache bcel classfile annotation runtime invisible parameter annotations runtimeinvisibleparameterannotations org aspectj apache bcel classfile annotation runtime visible annotations runtimevisibleannotations org aspectj apache bcel classfile annotation runtime visible parameter annotations runtimevisibleparameterannotations traverses java class javaclass visitor object piggy backed applied components java class javaclass object supplies traversal strategy classes version descending visitor descendingvisitor java aclement exp author href mailto markus dahm berlin dahm descending visitor descendingvisitor visitor java class javaclass clazz visitor visitor stack stack stack container current entitity predecessor traversal object predecessor predecessor param level nesting level returns direct predecessor container current entitity predecessor traversal object predecessor level size stack size size level size current stack element at elementat size level current object object current stack peek param clazz traverse param visitor visitor object apply components descending visitor descendingvisitor java class javaclass clazz visitor visitor clazz clazz visitor visitor start traversal visit clazz accept visit java class visitjavaclass java class javaclass clazz stack push clazz clazz accept visitor field fields clazz get fields getfields fields length fields accept method methods clazz get methods getmethods methods length methods accept attribute attributes clazz get attributes getattributes attributes length attributes accept clazz get constant pool getconstantpool accept stack pop visit field visitfield field field stack push field field accept visitor attribute attributes field get attributes getattributes attributes length attributes accept stack pop visit constant value visitconstantvalue constant value constantvalue stack push accept visitor stack pop visit method visitmethod method method stack push method method accept visitor attribute attributes method get attributes getattributes attributes length attributes accept stack pop visit exception table visitexceptiontable exception table exceptiontable table stack push table table accept visitor stack pop visit code visitcode code code stack push code code accept visitor code exception codeexception table code get exception table getexceptiontable table length table accept attribute attributes code get attributes getattributes attributes length attributes accept stack pop visit code exception visitcodeexception code exception codeexception stack push accept visitor stack pop visit line number table visitlinenumbertable line number table linenumbertable table stack push table table accept visitor line number linenumber numbers table get line number table getlinenumbertable numbers length numbers accept stack pop visit line number visitlinenumber line number linenumber number stack push number number accept visitor stack pop visit local variable table visitlocalvariabletable local variable table localvariabletable table stack push table table accept visitor local variable localvariable vars table get local variable table getlocalvariabletable vars length vars accept stack pop visit stack map visitstackmap stack map stackmap table stack push table table accept visitor stack map entry stackmapentry vars table get stack map getstackmap vars length vars accept stack pop visit stack map entry visitstackmapentry stack map entry stackmapentry stack push accept visitor stack pop visit local variable visitlocalvariable local variable localvariable stack push accept visitor stack pop visit constant pool visitconstantpool constant pool constantpool stack push accept visitor constant constants get constant pool getconstantpool constants length constants constants accept stack pop visit constant class visitconstantclass constant class constantclass constant stack push constant constant accept visitor stack pop visit constant double visitconstantdouble constant double constantdouble constant stack push constant constant accept visitor stack pop visit constant fieldref visitconstantfieldref constant fieldref constantfieldref constant stack push constant constant accept visitor stack pop visit constant float visitconstantfloat constant float constantfloat constant stack push constant constant accept visitor stack pop visit constant integer visitconstantinteger constant integer constantinteger constant stack push constant constant accept visitor stack pop visit constant interface methodref visitconstantinterfacemethodref constant interface methodref constantinterfacemethodref constant stack push constant constant accept visitor stack pop visit constant long visitconstantlong constant long constantlong constant stack push constant constant accept visitor stack pop visit constant methodref visitconstantmethodref constant methodref constantmethodref constant stack push constant constant accept visitor stack pop visit constant name and type visitconstantnameandtype constant name and type constantnameandtype constant stack push constant constant accept visitor stack pop visit constant string visitconstantstring constant string constantstring constant stack push constant constant accept visitor stack pop visit constant utf visitconstantutf constant utf constantutf constant stack push constant constant accept visitor stack pop visit inner classes visitinnerclasses inner classes innerclasses stack push accept visitor inner class innerclass ics get inner classes getinnerclasses ics length ics accept stack pop visit inner class visitinnerclass inner class innerclass stack push accept visitor stack pop visit deprecated visitdeprecated deprecated attribute stack push attribute attribute accept visitor stack pop visit signature visitsignature signature attribute stack push attribute attribute accept visitor stack pop support visit enclosing method visitenclosingmethod enclosing method enclosingmethod attribute stack push attribute attribute accept visitor stack pop visit runtime visible annotations visitruntimevisibleannotations runtime visible annotations runtimevisibleannotations attribute stack push attribute attribute accept visitor stack pop visit runtime invisible annotations visitruntimeinvisibleannotations runtime invisible annotations runtimeinvisibleannotations attribute stack push attribute attribute accept visitor stack pop visit runtime visible parameter annotations visitruntimevisibleparameterannotations runtime visible parameter annotations runtimevisibleparameterannotations attribute stack push attribute attribute accept visitor stack pop visit runtime invisible parameter annotations visitruntimeinvisibleparameterannotations runtime invisible parameter annotations runtimeinvisibleparameterannotations attribute stack push attribute attribute accept visitor stack pop visit annotation default visitannotationdefault annotation default annotationdefault attribute stack push attribute attribute accept visitor stack pop visit local variable type table visitlocalvariabletypetable local variable type table localvariabletypetable table stack push table table accept visitor local variable localvariable vars table get local variable type table getlocalvariabletypetable vars length vars accept stack pop visit source file visitsourcefile source file sourcefile attribute stack push attribute attribute accept visitor stack pop visit synthetic visitsynthetic synthetic attribute stack push attribute attribute accept visitor stack pop visit unknown visitunknown unknown attribute stack push attribute attribute accept visitor stack pop