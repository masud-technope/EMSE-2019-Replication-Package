copyright contributors rights reserved program accompanying materials terms eclipse license accompanies distribution http eclipse org legal epl html contributors andy clement initial implementation org aspectj weaver bcel java file java ioexception java util enumeration java util zip zip entry zipentry java util zip zip file zipfile org aspectj weaver abstract reference type delegate abstractreferencetypedelegate org aspectj weaver abstract world test case abstractworldtestcase org aspectj weaver aj attribute ajattribute org aspectj weaver annotation x annotationx org aspectj weaver bcweaver tests bcweavertests org aspectj weaver reference type referencetype org aspectj weaver reference type delegate referencetypedelegate org aspectj weaver resolved member resolvedmember org aspectj weaver resolved member impl resolvedmemberimpl org aspectj weaver resolved type resolvedtype org aspectj weaver shadow munger shadowmunger org aspectj weaver type variable typevariable org aspectj weaver unresolved type unresolvedtype org aspectj weaver org aspectj weaver aj attribute ajattribute effective signature attribute effectivesignatureattribute org aspectj weaver asm asm delegate asmdelegate org aspectj weaver asm asm field asmfield org aspectj weaver asm asm method asmmethod test name type nametype parts worlds asm delegate tests asmdelegatetests abstract world test case abstractworldtestcase bcel world bcelworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar asm delegate tests asmdelegatetests string get world getworld testcode test we dont go bang testwedontgobang resolved type resolvedtype resolve simple aspect simpleaspect reference type delegate referencetypedelegate delegate reference type referencetype get delegate getdelegate assert true asserttrue asm delegate delegate get class getclass delegate get class getclass to string tostring equals org aspectj weaver asm asm delegate asmdelegate test differentiating between aspect and class testdifferentiatingbetweenaspectandclass reference type referencetype rt aspect rtaspect reference type referencetype resolve simple aspect simpleaspect reference type referencetype rt string rtstring reference type referencetype resolve java lang string assert true asserttrue simple aspect simpleaspect aspect rt aspect rtaspect is aspect isaspect assert true asserttrue string aspect rt string rtstring is aspect isaspect assert true asserttrue persingleton rt aspect rtaspect get per clause getperclause rt aspect rtaspect get per clause getperclause to string tostring starts with startswith persingleton test recognizing different types testrecognizingdifferenttypes resolved type resolvedtype rt annotation rtannotation resolve simple annotation simpleannotation resolved type resolvedtype rt enum rtenum resolve simple enum simpleenum resolved type resolvedtype rt string rtstring resolve java lang string assert true asserttrue annotation type rt annotation rtannotation is annotation isannotation assert true asserttrue enum type rt enum rtenum is enum isenum assert true asserttrue annotation enum type rt string rtstring is annotation isannotation rt string rtstring is enum isenum test annotations behaving testannotationsbehaving reference type referencetype rt annotation rtannotation reference type referencetype resolve simple annotation simpleannotation assert true asserttrue source rt annotation rtannotation get retention policy getretentionpolicy rt annotation rtannotation get retention policy getretentionpolicy equals source reference type referencetype rt annotation rtannotation reference type referencetype resolve simple annotation simpleannotation assert true asserttrue rt annotation rtannotation get retention policy getretentionpolicy rt annotation rtannotation get retention policy getretentionpolicy equals reference type referencetype rt annotation rtannotation reference type referencetype resolve simple annotation simpleannotation assert true asserttrue runtime rt annotation rtannotation get retention policy getretentionpolicy rt annotation rtannotation get retention policy getretentionpolicy equals runtime reference type referencetype rt annotation rtannotation reference type referencetype resolve simple annotation simpleannotation assert true asserttrue rt annotation rtannotation get retention policy getretentionpolicy rt annotation rtannotation get retention policy getretentionpolicy equals test interfaceflag testinterfaceflag reference type referencetype rt string rtstring reference type referencetype resolve java lang string assert true asserttrue string rt string rtstring is interface isinterface reference type referencetype rt serializable rtserializable reference type referencetype resolve java serializable assert true asserttrue serializable rt serializable rtserializable is interface isinterface test compare delegates testcomparedelegates bcel world bcelworld slow world slowworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar slow world slowworld set fast delegate support setfastdelegatesupport bcel world bcelworld fast world fastworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar reference type referencetype bcel list bcellist reference type referencetype slow world slowworld resolve java util list reference type referencetype asm list asmlist reference type referencetype fast world fastworld resolve java util list assert true asserttrue bcel delegate bcel list bcellist get delegate getdelegate get class getclass bcel list bcellist get delegate getdelegate get class getclass to string tostring equals org aspectj weaver bcel bcel object type bcelobjecttype assert true asserttrue asm delegate asm list asmlist get delegate getdelegate get class getclass asm list asmlist get delegate getdelegate get class getclass to string tostring equals org aspectj weaver asm asm delegate asmdelegate type variable typevariable bcel tvars bceltvars bcel list bcellist get type variables gettypevariables type variable typevariable asm tvars asmtvars asm list asmlist get type variables gettypevariables asm tvars asmtvars length type variable typevariable variable asm tvars asmtvars string bcelsig bcel list bcellist get signature getsignature string asmsig asm list asmlist get signature getsignature assert true asserttrue signatures bcelsig asmsig bcelsig equals asmsig string bcelerasuresig bcel list bcellist get erasure signature geterasuresignature string asmerasuresig asm list asmlist get erasure signature geterasuresignature assert true asserttrue erasure signatures bcelerasuresig asmerasuresig bcelerasuresig equals asmerasuresig resolved member resolvedmember bcelfields bcel list bcellist get declared fields getdeclaredfields resolved member resolvedmember asmfields asm list asmlist get declared fields getdeclaredfields bcelfields length asmfields length fail dont number fields bcel bcelfields length asm asmfields length asmfields length resolved member resolvedmember member asmfields bcelfields equals asmfields fail differing fields bcelfields asmfields test compare delegates complex testcomparedelegatescomplex bcel world bcelworld slow world slowworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar slow world slowworld set fast delegate support setfastdelegatesupport bcel world bcelworld fast world fastworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar reference type referencetype b complex bcomplex reference type referencetype slow world slowworld resolve complex reference type referencetype a complex acomplex reference type referencetype fast world fastworld resolve complex check equivalent checkequivalent abstract reference type delegate abstractreferencetypedelegate a complex acomplex get delegate getdelegate abstract reference type delegate abstractreferencetypedelegate b complex bcomplex get delegate getdelegate methods transformed signatures checks methods java lang viewed asm bcel delegate test compare generic methods testcomparegenericmethods bcel world bcelworld slow world slowworld bcel world bcelworld slow world slowworld set fast delegate support setfastdelegatesupport slow world slowworld set behave in java setbehaveinjava bcel world bcelworld fast world fastworld bcel world bcelworld fast world fastworld set behave in java setbehaveinjava resolved type resolvedtype bcel java lang class bceljavalangclass slow world slowworld resolve unresolved type unresolvedtype for name forname java lang resolved type resolvedtype asm java lang class asmjavalangclass fast world fastworld resolve unresolved type unresolvedtype for name forname java lang bcel java lang class bceljavalangclass bcel java lang class bceljavalangclass get generic type getgenerictype asm java lang class asmjavalangclass asm java lang class asmjavalangclass get generic type getgenerictype bcel java lang class bceljavalangclass resolved member resolvedmember bcel methods bcelmethods bcel java lang class bceljavalangclass get declared methods getdeclaredmethods resolved member resolvedmember asm methods asmmethods asm java lang class asmjavalangclass get declared methods getdeclaredmethods bcel methods bcelmethods length forget asm delegates dont bcel methods bcelmethods set parameter names setparameternames string bcel methods bcelmethods to debug string todebugstring string asm methods asmmethods to debug string todebugstring equals fail methods viewed asm bcel n bcel nbcel bcel methods bcelmethods to debug string todebugstring asm asm methods asmmethods to debug string todebugstring parameterized check bcel methods bcelmethods can be parameterized canbeparameterized assert true asserttrue asm method asm methods asmmethods to debug string todebugstring parameterized bcel variant asm methods asmmethods can be parameterized canbeparameterized special as subclass assubclass clazz resolved member resolvedmember bcel subclass method bcelsubclassmethod bcel methods bcelmethods length bcel methods bcelmethods get name getname equals as subclass assubclass bcel subclass method bcelsubclassmethod bcel methods bcelmethods resolved member resolvedmember asm subclass method asmsubclassmethod asm methods asmmethods length asm methods asmmethods get name getname equals as subclass assubclass asm subclass method asmsubclassmethod asm methods asmmethods type variable typevariable tvs bcel subclass method bcelsubclassmethod get type variables gettypevariables assert true asserttrue type variable bcel version format tvs tvs tvs length tvs asm subclass method asmsubclassmethod get type variables gettypevariables assert true asserttrue type variable asm version format tvs tvs tvs length string format type variable typevariable tvs tvs string buffer stringbuffer string buffer stringbuffer append tvs length append tvs tvs length append append to string tostring test compare generic fields testcomparegenericfields bcel world bcelworld slow world slowworld bcel world bcelworld slow world slowworld set fast delegate support setfastdelegatesupport slow world slowworld set behave in java setbehaveinjava bcel world bcelworld fast world fastworld bcel world bcelworld fast world fastworld set behave in java setbehaveinjava resolved type resolvedtype bcel java lang class bceljavalangclass slow world slowworld resolve unresolved type unresolvedtype for name forname java lang resolved type resolvedtype asm java lang class asmjavalangclass fast world fastworld resolve unresolved type unresolvedtype for name forname java lang bcel java lang class bceljavalangclass bcel java lang class bceljavalangclass get generic type getgenerictype asm java lang class asmjavalangclass asm java lang class asmjavalangclass get generic type getgenerictype bcel java lang class bceljavalangclass resolved member resolvedmember bcel fields bcelfields bcel java lang class bceljavalangclass get declared fields getdeclaredfields resolved member resolvedmember asm fields asmfields asm java lang class asmjavalangclass get declared fields getdeclaredfields bcel fields bcelfields length unresolved type unresolvedtype bcel field type bcelfieldtype bcel fields bcelfields get generic return type getgenericreturntype unresolved type unresolvedtype asm field type asmfieldtype asm fields asmfields get generic return type getgenericreturntype bcel fields bcelfields get generic return type getgenericreturntype to debug string todebugstring equals asm fields asmfields get generic return type getgenericreturntype to debug string todebugstring fail fields viewed asm bcel n bcel nbcel bcel field type bcelfieldtype to debug string todebugstring asm asm field type asmfieldtype to debug string todebugstring test compare delegates monster testcomparedelegatesmonster bcel world bcelworld slow world slowworld bcel world bcelworld lib aspectj lib aspectjtools jar slow world slowworld set fast delegate support setfastdelegatesupport bcel world bcelworld fast world fastworld bcel world bcelworld lib aspectj lib aspectjtools jar resolved member impl resolvedmemberimpl show parameter names showparameternames file file lib aspectj lib aspectjtools jar assert true asserttrue find aspectjtools test get absolute path getabsolutepath exists zip file zipfile zip file zipfile enumeration entries entries entries has more elements hasmoreelements zip entry zipentry zfe zip entry zipentry entries next element nextelement string classfile name classfilename zfe get name getname classfile name classfilename ends with endswith string clazzname classfile name classfilename substring classfile name classfilename length replace reference type referencetype reference type referencetype slow world slowworld resolve clazzname reference type referencetype reference type referencetype fast world fastworld resolve clazzname check equivalent checkequivalent comparison number abstract reference type delegate abstractreferencetypedelegate get delegate getdelegate abstract reference type delegate abstractreferencetypedelegate get delegate getdelegate system err println compared entries ioexception print stack trace printstacktrace fail get message getmessage test compare delegates loading performance testcomparedelegatesloadingperformance bcel world bcelworld slow world slowworld bcel world bcelworld lib aspectj lib aspectjtools jar slow world slowworld set fast delegate support setfastdelegatesupport bcel world bcelworld fast world fastworld bcel world bcelworld lib aspectj lib aspectjtools jar resolved member impl resolvedmemberimpl show parameter names showparameternames file file lib aspectj lib aspectjtools jar assert true asserttrue find aspectjtools test get absolute path getabsolutepath exists zip file zipfile zip file zipfile stime system current time millis currenttimemillis enumeration entries entries entries has more elements hasmoreelements zip entry zipentry zfe zip entry zipentry entries next element nextelement string classfile name classfilename zfe get name getname classfile name classfilename ends with endswith string clazzname classfile name classfilename substring classfile name classfilename length replace reference type referencetype reference type referencetype slow world slowworld resolve clazzname etime system current time millis currenttimemillis system err println time load entries bcel etime stime system err println compared entries ioexception print stack trace printstacktrace fail get message getmessage file file lib aspectj lib aspectjtools jar assert true asserttrue find aspectjtools test get absolute path getabsolutepath exists zip file zipfile zip file zipfile stime system current time millis currenttimemillis enumeration entries entries entries has more elements hasmoreelements zip entry zipentry zfe zip entry zipentry entries next element nextelement string classfile name classfilename zfe get name getname classfile name classfilename ends with endswith string clazzname classfile name classfilename substring classfile name classfilename length replace reference type referencetype reference type referencetype fast world fastworld resolve clazzname etime system current time millis currenttimemillis system err println time load entries asm etime stime system err println compared entries ioexception print stack trace printstacktrace fail get message getmessage check equivalent checkequivalent string prefix abstract reference type delegate abstractreferencetypedelegate asm type asmtype abstract reference type delegate abstractreferencetypedelegate bcel type bceltype assert true asserttrue bcel delegate bcel type bceltype get class getclass bcel type bceltype get class getclass to string tostring equals org aspectj weaver bcel bcel object type bcelobjecttype assert true asserttrue asm delegate asm type asmtype get class getclass asm type asmtype get class getclass to string tostring equals org aspectj weaver asm asm delegate asmdelegate string asm string asmstring asm type asmtype stringify delegate stringifydelegate string bcel string bcelstring bcel type bceltype stringify delegate stringifydelegate asm string asmstring equals bcel string bcelstring fail prefix delegates don match bcel type bceltype get resolved type x getresolvedtypex asm asm string asmstring bcel bcel string bcelstring compare annotations compareannotations string bcel world bcelworld asm world asmworld reference type referencetype bcel t bcelt reference type referencetype bcel world bcelworld resolve reference type referencetype asm t asmt reference type referencetype asm world asmworld resolve ensure the same ensurethesame bcel t bcelt get annotations getannotations asm t asmt get annotations getannotations ensure the same ensurethesame annotation x annotationx bcel set bcelset annotation x annotationx asm set asmset string bcel string bcelstring stringify bcel set bcelset string asm string asmstring stringify asm set asmset bcel set bcelset length asm set asmset length fail lengths good start n bcel nbcel reports bcel string bcelstring asm reports asm string asmstring assert true asserttrue answers n bcel nbcel reports bcel string bcelstring asm reports asm string asmstring bcel string bcelstring equals asm string asmstring string stringify annotation x annotationx annotations annotations string buffer stringbuffer string buffer stringbuffer annotations length annotation x annotationx annotation x annotationx annotations append annotation x annotationx to string tostring append to string tostring test different annotation kinds testdifferentannotationkinds bcel world bcelworld slow world slowworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar slow world slowworld set fast delegate support setfastdelegatesupport bcel world bcelworld fast world fastworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar compare annotations compareannotations annotated class annotatedclass slow world slowworld fast world fastworld compare annotations compareannotations annotated fields annotatedfields slow world slowworld fast world fastworld compare annotations compareannotations annotated methods annotatedmethods slow world slowworld fast world fastworld compare annotations compareannotations annotated with class class annotatedwithclassclass slow world slowworld fast world fastworld compare annotations compareannotations annotated with combined annotation annotatedwithcombinedannotation slow world slowworld fast world fastworld compare annotations compareannotations annotated with enum class annotatedwithenumclass slow world slowworld fast world fastworld compare annotations compareannotations annotation class element annotationclasselement slow world slowworld fast world fastworld compare annotations compareannotations annotation enum element annotationenumelement slow world slowworld fast world fastworld compare annotations compareannotations complex annotation complexannotation slow world slowworld fast world fastworld compare annotations compareannotations combined annotation combinedannotation slow world slowworld fast world fastworld compare annotations compareannotations complex annotated class complexannotatedclass slow world slowworld fast world fastworld load aspect from hell aspectfromhell test loading attributes for types testloadingattributesfortypes bcel world bcelworld slow world slowworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar slow world slowworld set fast delegate support setfastdelegatesupport bcel world bcelworld fast world fastworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar reference type referencetype bcel t bcelt reference type referencetype slow world slowworld resolve aspect from hell aspectfromhell reference type referencetype asm t asmt reference type referencetype fast world fastworld resolve aspect from hell aspectfromhell asm delegate asmdelegate asm d asmd asm delegate asmdelegate asm t asmt get delegate getdelegate string asm attribute names asmattributenames asm d asmd get attribute names getattributenames bcel object type bcelobjecttype bcel d bceld bcel object type bcelobjecttype bcel t bcelt get delegate getdelegate string bcel attribute names bcelattributenames bcel d bceld get attribute names getattributenames won number asm processes discards effectively stored delegate processed type mungers aj attribute ajattribute asm type mungers asmtypemungers asm d asmd get attributes getattributes org aspectj weaver type munger typemunger aj attribute ajattribute bcel type mungers bceltypemungers bcel d bceld get attributes getattributes org aspectj weaver type munger typemunger assert true asserttrue type mungers asm asm type mungers asmtypemungers length bcel bcel type mungers bceltypemungers length asm type mungers asmtypemungers length bcel type mungers bceltypemungers length test loading attributes for methods testloadingattributesformethods debug bcel world bcelworld slow world slowworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar slow world slowworld set fast delegate support setfastdelegatesupport bcel world bcelworld fast world fastworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar reference type referencetype bcel t bcelt reference type referencetype slow world slowworld resolve aspect from hell aspectfromhell reference type referencetype asm t asmt reference type referencetype fast world fastworld resolve aspect from hell aspectfromhell resolved member resolvedmember bcel methods bcelmethods bcel t bcelt get declared methods getdeclaredmethods resolved member resolvedmember asm methods asmmethods asm t asmt get declared methods getdeclaredmethods bcel methods bcelmethods length bcel method bcelmethod bmember bcel method bcelmethod bcel methods bcelmethods asm method asmmethod amember asm method asmmethod asm methods asmmethods assert true asserttrue muddle amember get name getname bmember get name getname amember get name getname equals bmember get name getname debug system err println bmember string bcel member attributes bcelmemberattributes bmember get attribute names getattributenames string asm member attributes asmmemberattributes amember get attribute names getattributenames system err println bcel stringify string array stringifystringarray bcel member attributes bcelmemberattributes system err println asm stringify string array stringifystringarray asm member attributes asmmemberattributes compare attribute names compareattributenames bcel member attributes bcelmemberattributes asm member attributes asmmemberattributes org aspectj weaver aj synthetic ajsynthetic bmember is aj synthetic isajsynthetic assert true asserttrue isnt asm method ajsynthetic amember to debug string todebugstring amember is aj synthetic isajsynthetic assert true asserttrue asm method ajsynthetic amember to debug string todebugstring amember is aj synthetic isajsynthetic org aspectj weaver effective signature effectivesignature effective signature attribute effectivesignatureattribute bcel esa bcelesa bmember get effective signature geteffectivesignature effective signature attribute effectivesignatureattribute asm esa asmesa amember get effective signature geteffectivesignature bcel esa bcelesa assert true asserttrue isnt asm effective signature asm esa asmesa asm esa asmesa asm esa asmesa fail asm effective signature bcel effective signature bcel esa bcelesa to string tostring assert true asserttrue bcel esa bcelesa to string tostring asm esa asmesa to string tostring bcel esa bcelesa to string tostring equals asm esa asmesa to string tostring org aspectj weaver method declaration line number methoddeclarationlinenumber b line bline bmember get declaration line number getdeclarationlinenumber a line aline amember get declaration line number getdeclarationlinenumber assert true asserttrue number b line bline a line aline b line bline a line aline org aspectj weaver advice shadow munger shadowmunger bcel sm bcelsm bmember get associated shadow munger getassociatedshadowmunger shadow munger shadowmunger asm sm asmsm amember get associated shadow munger getassociatedshadowmunger bcel sm bcelsm assert true asserttrue isnt asm effective signature asm sm asmsm asm sm asmsm asm sm asmsm fail asm effective signature bcel effective signature bcel sm bcelsm to string tostring assert true asserttrue bcel sm bcelsm to string tostring asm sm asmsm to string tostring bcel sm bcelsm to string tostring equals asm sm asmsm to string tostring aj asmattribute ajasmattribute org aspectj weaver source context sourcecontext simple annotation simpleannotation simple annotation simpleannotation string test loading annotations for fields testloadingannotationsforfields debug bcel world bcelworld slow world slowworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar slow world slowworld set fast delegate support setfastdelegatesupport bcel world bcelworld fast world fastworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar reference type referencetype bcel t bcelt reference type referencetype slow world slowworld resolve annotated fields annotatedfields reference type referencetype asm t asmt reference type referencetype fast world fastworld resolve annotated fields annotatedfields resolved member resolvedmember bcel fields bcelfields bcel t bcelt get declared fields getdeclaredfields resolved member resolvedmember asm fields asmfields asm t asmt get declared fields getdeclaredfields bcel fields bcelfields length bcel field bcelfield bmember bcel field bcelfield bcel fields bcelfields asm field asmfield amember asm field asmfield asm fields asmfields assert true asserttrue muddle amember get name getname bmember get name getname amember get name getname equals bmember get name getname debug system err println bmember resolved type resolvedtype b anns banns bmember get annotation types getannotationtypes resolved type resolvedtype a anns aanns amember get annotation types getannotationtypes assert true asserttrue annotation bcel field b anns banns b anns banns length assert true asserttrue annotation asm field a anns aanns a anns aanns length assert true asserttrue bcel annotation simple annotation simpleannotation b anns banns to string tostring b anns banns to string tostring equals simple annotation simpleannotation assert true asserttrue asm annotation simple annotation simpleannotation a anns aanns to string tostring a anns aanns to string tostring equals simple annotation simpleannotation annotation x annotationx b xs bxs bmember get annotations getannotations annotation x annotationx a xs axs amember get annotations getannotations assert true asserttrue annotation bcel field b xs bxs b xs bxs length assert true asserttrue annotation asm field a xs axs a xs axs length string exp exp annotation lsimple annotation lsimpleannotation runtime visible runtimevisible exp annotation lsimple annotation lsimpleannotation runtime visible runtimevisible assert true asserttrue bcel annotation exp b xs bxs to string tostring b xs bxs to string tostring equals exp assert true asserttrue asm annotation exp a xs axs to string tostring a xs axs to string tostring equals exp simple annotation simpleannotation method simple annotation simpleannotation method test loading annotations for methods testloadingannotationsformethods debug bcel world bcelworld slow world slowworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar slow world slowworld set fast delegate support setfastdelegatesupport bcel world bcelworld fast world fastworld bcel world bcelworld bcweaver tests bcweavertests testdata path for asm delegate testing forasmdelegatetesting stuff jar reference type referencetype bcel t bcelt reference type referencetype slow world slowworld resolve annotated methods annotatedmethods reference type referencetype asm t asmt reference type referencetype fast world fastworld resolve annotated methods annotatedmethods resolved member resolvedmember bcel methods bcelmethods bcel t bcelt get declared methods getdeclaredmethods resolved member resolvedmember asm methods asmmethods asm t asmt get declared methods getdeclaredmethods bcel methods bcelmethods length bcel method bcelmethod bmember bcel method bcelmethod bcel methods bcelmethods asm method asmmethod amember asm method asmmethod asm methods asmmethods bmember get name getname starts with startswith method assert true asserttrue muddle amember get name getname bmember get name getname amember get name getname equals bmember get name getname debug system err println bmember resolved type resolvedtype b anns banns bmember get annotation types getannotationtypes resolved type resolvedtype a anns aanns amember get annotation types getannotationtypes assert true asserttrue annotation bcel method b anns banns b anns banns length assert true asserttrue annotation asm method a anns aanns a anns aanns length assert true asserttrue bcel annotation simple annotation simpleannotation b anns banns to string tostring b anns banns to string tostring equals simple annotation simpleannotation assert true asserttrue asm annotation simple annotation simpleannotation a anns aanns to string tostring a anns aanns to string tostring equals simple annotation simpleannotation annotation x annotationx b xs bxs bmember get annotations getannotations annotation x annotationx a xs axs amember get annotations getannotations assert true asserttrue annotation bcel method b xs bxs b xs bxs length assert true asserttrue annotation asm method a xs axs a xs axs length string exp exp annotation lsimple annotation lsimpleannotation runtime visible runtimevisible exp annotation lsimple annotation lsimpleannotation runtime visible runtimevisible assert true asserttrue bcel annotation exp b xs bxs to string tostring b xs bxs to string tostring equals exp assert true asserttrue asm annotation exp a xs axs to string tostring a xs axs to string tostring equals exp compare attribute names compareattributenames string asmlist string bcellist string astring stringify string array stringifystringarray asmlist string bstring stringify string array stringifystringarray bcellist asmlist length bcellist length fail differing lengths n bcel nbcel bstring asm astring string stringify string array stringifystringarray string string buffer stringbuffer string buffer stringbuffer length append append to string tostring