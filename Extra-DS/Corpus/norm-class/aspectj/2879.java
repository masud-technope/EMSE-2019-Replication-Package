copyright contributors rights reserved program accompanying materials terms eclipse license accompanies distribution http eclipse org legal epl html contributors adrian colyer initial implementation org aspectj weaver tools org aspectj util lang util langutil junit framework test case testcase author adrian pointcut designator handler tests pointcutdesignatorhandlertests test case testcase need to skip needtoskip set up setup exception set up setup need to skip needtoskip need to skip pointcut parser tests needtoskippointcutparsertests condition occur build machine complex need to skip pointcut parser tests needtoskippointcutparsertests lang util langutil vmor greater vmorgreater reflection based reference type delegate reflectionbasedreferencetypedelegate get class loader getclassloader for name forname org aspectj weaver reflect java reflection based reference type delegate reflectionbasedreferencetypedelegate get class getclass get class loader getclassloader class not found exception classnotfoundexception cnf ex cnfex test parse without handler testparsewithouthandler need to skip needtoskip pointcut parser pointcutparser get pointcut parser supporting all primitives and using context classloader for resolution getpointcutparsersupportingallprimitivesandusingcontextclassloaderforresolution parse pointcut expression parsepointcutexpression bean service fail parse bean service illegal argument exception illegalargumentexception assert true asserttrue bean get message getmessage index of indexof bean test parse with handler testparsewithhandler need to skip needtoskip pointcut parser pointcutparser parser pointcut parser pointcutparser get pointcut parser supporting all primitives and using context classloader for resolution getpointcutparsersupportingallprimitivesandusingcontextclassloaderforresolution bean designator handler beandesignatorhandler bean handler beanhandler bean designator handler beandesignatorhandler parser register pointcut designator handler registerpointcutdesignatorhandler bean handler beanhandler parser parse pointcut expression parsepointcutexpression bean service assert equals assertequals service bean handler beanhandler get expression last asked to parse getexpressionlastaskedtoparse test parse with handler and multiple segments testparsewithhandlerandmultiplesegments need to skip needtoskip pointcut parser pointcutparser parser pointcut parser pointcutparser get pointcut parser supporting all primitives and using context classloader for resolution getpointcutparsersupportingallprimitivesandusingcontextclassloaderforresolution bean designator handler beandesignatorhandler bean handler beanhandler bean designator handler beandesignatorhandler parser register pointcut designator handler registerpointcutdesignatorhandler bean handler beanhandler parser parse pointcut expression parsepointcutexpression bean org xyz someapp assert equals assertequals org xyz someapp bean handler beanhandler get expression last asked to parse getexpressionlastaskedtoparse test static match teststaticmatch exception need to skip needtoskip pointcut parser pointcutparser parser pointcut parser pointcutparser get pointcut parser supporting all primitives and using context classloader for resolution getpointcutparsersupportingallprimitivesandusingcontextclassloaderforresolution bean designator handler beandesignatorhandler bean handler beanhandler bean designator handler beandesignatorhandler parser register pointcut designator handler registerpointcutdesignatorhandler bean handler beanhandler pointcut expression pointcutexpression parser parse pointcut expression parsepointcutexpression bean my bean mybean default matching context defaultmatchingcontext context default matching context defaultmatchingcontext context add context binding addcontextbinding bean name beanname my bean mybean set matching context setmatchingcontext context shadow match shadowmatch matches method execution matchesmethodexecution object get method getmethod to string tostring assert true asserttrue always matches alwaysmatches context add context binding addcontextbinding bean name beanname not my bean notmybean matches method execution matchesmethodexecution object get method getmethod to string tostring assert true asserttrue never matches nevermatches test dynamic match testdynamicmatch exception need to skip needtoskip pointcut parser pointcutparser parser pointcut parser pointcutparser get pointcut parser supporting all primitives and using context classloader for resolution getpointcutparsersupportingallprimitivesandusingcontextclassloaderforresolution bean designator handler beandesignatorhandler bean handler beanhandler bean designator handler beandesignatorhandler bean handler beanhandler simulate dynamic test simulatedynamictest parser register pointcut designator handler registerpointcutdesignatorhandler bean handler beanhandler pointcut expression pointcutexpression parser parse pointcut expression parsepointcutexpression bean my bean mybean shadow match shadowmatch matches method execution matchesmethodexecution object get method getmethod to string tostring default matching context defaultmatchingcontext context default matching context defaultmatchingcontext assert true asserttrue maybe matches maybematches assert false assertfalse always matches alwaysmatches assert false assertfalse never matches nevermatches context add context binding addcontextbinding bean name beanname my bean mybean set matching context setmatchingcontext context assert true asserttrue matches join point matchesjoinpoint matches context add context binding addcontextbinding bean name beanname not my bean notmybean assert false assertfalse matches join point matchesjoinpoint matches test fast match testfastmatch need to skip needtoskip pointcut parser pointcutparser parser pointcut parser pointcutparser get pointcut parser supporting all primitives and using context classloader for resolution getpointcutparsersupportingallprimitivesandusingcontextclassloaderforresolution bean designator handler beandesignatorhandler bean handler beanhandler bean designator handler beandesignatorhandler parser register pointcut designator handler registerpointcutdesignatorhandler bean handler beanhandler pointcut expression pointcutexpression parser parse pointcut expression parsepointcutexpression bean my bean mybean default matching context defaultmatchingcontext context default matching context defaultmatchingcontext context add context binding addcontextbinding bean name beanname my bean mybean set matching context setmatchingcontext context assert true asserttrue could match join points in type couldmatchjoinpointsintype string context add context binding addcontextbinding bean name beanname your bean yourbean assert false assertfalse could match join points in type couldmatchjoinpointsintype string bean designator handler beandesignatorhandler pointcut designator handler pointcutdesignatorhandler string asked to parse askedtoparse simulate dynamic test simulatedynamictest string get designator name getdesignatorname bean javadoc org aspectj weaver tools pointcut designator handler pointcutdesignatorhandler parse java lang string context based matcher contextbasedmatcher parse string expression asked to parse askedtoparse expression bean pointcut expression beanpointcutexpression expression simulate dynamic test simulatedynamictest string get expression last asked to parse getexpressionlastaskedtoparse asked to parse askedtoparse bean pointcut expression beanpointcutexpression context based matcher contextbasedmatcher string bean name pattern beannamepattern simulate dynamic test simulatedynamictest bean pointcut expression beanpointcutexpression string bean name pattern beannamepattern simulate dynamic test simulatedynamictest bean name pattern beannamepattern bean name pattern beannamepattern simulate dynamic test simulatedynamictest simulate dynamic test simulatedynamictest could match join points in type couldmatchjoinpointsintype a class aclass javadoc org aspectj weaver tools context based matcher contextbasedmatcher could match join points in type couldmatchjoinpointsintype java lang could match join points in type couldmatchjoinpointsintype a class aclass matching context matchingcontext context bean name pattern beannamepattern equals context get binding getbinding bean name beanname javadoc org aspectj weaver tools context based matcher contextbasedmatcher may need dynamic test mayneeddynamictest may need dynamic test mayneeddynamictest simulate dynamic test simulatedynamictest fuzzy boolean fuzzyboolean matches statically matchesstatically matching context matchingcontext match context matchcontext simulate dynamic test simulatedynamictest fuzzy boolean fuzzyboolean bean name pattern beannamepattern equals match context matchcontext get binding getbinding bean name beanname fuzzy boolean fuzzyboolean fuzzy boolean fuzzyboolean javadoc org aspectj weaver tools context based matcher contextbasedmatcher matches dynamically matchesdynamically org aspectj weaver tools matching context matchingcontext matches dynamically matchesdynamically matching context matchingcontext match context matchcontext bean name pattern beannamepattern equals match context matchcontext get binding getbinding bean name beanname