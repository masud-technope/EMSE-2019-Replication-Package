org aspectj apache bcel verifier structurals java util array list arraylist java util hash map hashmap java util hashtable org aspectj apache bcel athrow org aspectj apache bcel branch instruction branchinstruction org aspectj apache bcel goto instruction gotoinstruction org aspectj apache bcel instruction org aspectj apache bcel instruction handle instructionhandle org aspectj apache bcel jsr instruction jsrinstruction org aspectj apache bcel method gen methodgen org aspectj apache bcel ret org aspectj apache bcel return instruction returninstruction org aspectj apache bcel select org aspectj apache bcel verifier exc assertion violated exception assertionviolatedexception org aspectj apache bcel verifier exc structural code constraint exception structuralcodeconstraintexception represents control flow graph method version control flow graph controlflowgraph java aclement exp author href http inf berlin ehaase enver haase control flow graph controlflowgraph objects represent node control flow graph controlflowgraph nodes instructions basic blocks instruction context impl instructioncontextimpl instruction context instructioncontext tag field external temporary flagging graph colouring get tag gettag set tag settag tag instruction handle instructionhandle instruction context instructioncontext wrapped instruction handle instructionhandle instruction incoming execution frames key executed jsr hash map hashmap in frames inframes outgoing execution frames key executed jsr hash map hashmap out frames outframes execution predecessors list type instruction context instructioncontext instances execute order type instruction context instructioncontext array list arraylist execution predecessors executionpredecessors creates instruction handle impl instructionhandleimpl object instruction handle instructionhandle creation instruction handle instructionhandle suffices don create instruction context impl instructioncontextimpl instruction handle instructionhandle inst inst assertion violated exception assertionviolatedexception instantiate instruction context impl instructioncontextimpl instruction inst in frames inframes java util hash map hashmap out frames outframes java util hash map hashmap satisfies instruction context instructioncontext get tag gettag get tag gettag tag satisfies instruction context instructioncontext set tag settag set tag settag tag tag tag returns exception handlers instruction exception handler exceptionhandler get exception handlers getexceptionhandlers exceptionhandlers get exception handlers getexceptionhandlers get instruction getinstruction returns clone outgoing frame situation respect execution chain executionchain frame get out frame getoutframe array list arraylist exec chain execchain execution predecessors executionpredecessors exec chain execchain frame org instruction context instructioncontext jsr last execution jsr lastexecutionjsr org frame out frames outframes jsr org assertion violated exception assertionviolatedexception out frame outframe n execution chain nexecutionchain get execution chain getexecutionchain n out frames noutframes out frames outframes org get clone getclone merges vmspec incoming frame situation executes instructions symbolically calculates outgoing frame situation returns iff incoming frame situation changed merging in frame inframe exec preds execpreds array list arraylist instruction context instructioncontext objects executed correct order execution path needed correctly merge special ret successor inst constraint visitor instconstraintvisitor execution visitor executionvisitor instances correctly outgoing frame situation changed execute ing execute frame in frame inframe array list arraylist exec preds execpreds inst constraint visitor instconstraintvisitor icv execution visitor executionvisitor execution predecessors executionpredecessors array list arraylist exec preds execpreds clone sanity check last execution jsr lastexecutionjsr subroutines subroutine of subroutineof get instruction getinstruction subroutines get top level gettoplevel assertion violated exception assertionviolatedexception huh subroutine last execution jsr lastexecutionjsr subroutines subroutine of subroutineof get instruction getinstruction subroutines get top level gettoplevel assertion violated exception assertionviolatedexception huh subroutine frame in f inf frame in frames inframes last execution jsr lastexecutionjsr incoming frame in f inf in frames inframes last execution jsr lastexecutionjsr in frame inframe in f inf in frame inframe in frame inframe shortcut merge equal frames in f inf equals in frame inframe merge in frames mergeinframes in frame inframe in frame inframe changed in frame inframe merged frame working frame workingframe in f inf get clone getclone verifies instruction constraint instructionconstraint current instruction modify working frame workingframe object inst constraint visitor instconstraintvisitor icv inst constraint visitor instconstraintvisitor get instance getinstance verifier factory verifierfactory get verifier getverifier method gen get class name getclassname icv set frame setframe working frame workingframe get instruction getinstruction accept icv structural code constraint exception structuralcodeconstraintexception extend message extendmessage n instruction handle ninstructionhandle get instruction getinstruction extend message extendmessage n execution nexecution frame working frame workingframe extend message with flow extendmessagewithflow executes instruction working frame workingframe object modified execution visitor executionvisitor execution visitor executionvisitor get instance getinstance verifier factory verifierfactory get verifier getverifier method gen get class name getclassname set frame setframe working frame workingframe get instruction getinstruction accept get instruction getinstruction accept execution visitor executionvisitor with frame withframe working frame workingframe out frames outframes last execution jsr lastexecutionjsr working frame workingframe in frame inframe in frame inframe merging yielded in frame inframe returns simple string representation instruction context instructioncontext string to string tostring todo brackets exception handler exceptionhandler ret start subroutine string ret get instruction getinstruction to string tostring instruction context instructioncontext ret actual merging vmspec returns iff in frame inframe changed merging in frame inframe merge in frames mergeinframes frame in frame inframe todo performance improved frame in f inf frame in frames inframes last execution jsr lastexecutionjsr operand stack operandstack oldstack in f inf get stack getstack get clone getclone local variables localvariables oldlocals in f inf get locals getlocals get clone getclone in f inf get stack getstack merge in frame inframe get stack getstack in f inf get locals getlocals merge in frame inframe get locals getlocals structural code constraint exception structuralcodeconstraintexception sce extend message with flow extendmessagewithflow sce sce oldstack equals in f inf get stack getstack oldlocals equals in f inf get locals getlocals returns control flow execution chain built execute frame array list arraylist ing code represented surrounding control flow graph controlflowgraph string get execution chain getexecutionchain string to string tostring execution predecessors executionpredecessors size execution predecessors executionpredecessors structural code constraint exception structuralcodeconstraintexception object extended message extended message reflect execution flow needed constraint violation triggered throwing object extend message with flow extendmessagewithflow structural code constraint exception structuralcodeconstraintexception string execution flow extend message extendmessage get execution chain getexecutionchain fulfils contract instruction context instructioncontext get instruction getinstruction instruction handle instructionhandle get instruction getinstruction instruction returns instruction context impl instructioncontextimpl jsr jsr execution chain executionchain ret called returns called top level instruction context impl instructioncontextimpl last execution jsr lastexecutionjsr size execution predecessors executionpredecessors size retcount size instruction context impl instructioncontextimpl current instruction context impl instructioncontextimpl execution predecessors executionpredecessors instruction currentlast current get instruction getinstruction get instruction getinstruction currentlast ret retcount currentlast jsr instruction jsrinstruction retcount retcount current satisfies instruction context instructioncontext get successors getsuccessors instruction context instructioncontext get successors getsuccessors contexts of contextsof get successors getsuccessors utility method calculates successors instruction handle instructionhandle ret successors defined jsr instruction jsrinstruction target successor opposed physical successor defined todo implement caching instruction handle instructionhandle get successors getsuccessors instruction handle instructionhandle empty instruction handle instructionhandle instruction handle instructionhandle single instruction handle instructionhandle instruction handle instructionhandle pair instruction handle instructionhandle instruction inst get instruction getinstruction get instruction getinstruction inst ret subroutine subroutines subroutine of subroutineof get instruction getinstruction empty ret dead code empty correct answer surrounding project assertion violated exception assertionviolatedexception successors ret dead code todo remove assertion violated exception assertionviolatedexception ret succs instruction handle instructionhandle jsrs get entering jsr instructions getenteringjsrinstructions instruction handle instructionhandle ret instruction handle instructionhandle jsrs length jsrs length ret jsrs get next getnext ret terminates method inst return instruction returninstruction empty subroutines exception handlers inst athrow empty method comment inst jsr instruction jsrinstruction single jsr instruction jsrinstruction inst get target gettarget single inst goto instruction gotoinstruction single goto instruction gotoinstruction inst get target gettarget single inst branch instruction branchinstruction inst select bcel get targets gettargets returns targets eli tilevich reporting instruction handle instructionhandle match targets matchtargets select inst get targets gettargets instruction handle instructionhandle ret instruction handle instructionhandle match targets matchtargets length ret select inst get target gettarget system arraycopy match targets matchtargets ret match targets matchtargets length ret pair get instruction getinstruction get next getnext pair branch instruction branchinstruction inst get target gettarget pair fall single get instruction getinstruction get next getnext single instruction context impl instructioncontextimpl methof gen methofgen object working method gen methodgen method gen subroutines object method control flow represented control flow graph controlflowgraph subroutines subroutines exception handlers exceptionhandlers object method control flow represented control flow graph controlflowgraph exception handlers exceptionhandlers exceptionhandlers instruction context instructioncontext instances control flow graph controlflowgraph instruction handle instructionhandle values instruction context impl instructioncontextimpl hashtable instruction contexts instructioncontexts hashtable control flow graph control flow graph controlflowgraph method gen methodgen method gen subroutines subroutines method gen exceptionhandlers exception handlers exceptionhandlers method gen instruction handle instructionhandle instructionhandles method gen get instruction list getinstructionlist get instruction handles getinstructionhandles instructionhandles length instruction contexts instructioncontexts instructionhandles instruction context impl instructioncontextimpl instructionhandles method gen method gen returns instruction context instructioncontext instruction instruction context instructioncontext context of contextof instruction handle instructionhandle inst instruction context instructioncontext instruction context instructioncontext instruction contexts instructioncontexts inst assertion violated exception assertionviolatedexception instruction context instructioncontext requested instruction handle instructionhandle returns instruction context instructioncontext instruction handle instructionhandle naturally ordered manner instruction context instructioncontext contexts of contextsof instruction handle instructionhandle insts instruction context instructioncontext ret instruction context instructioncontext insts length insts length ret context of contextof insts ret returns instruction context instructioncontext instruction context instructioncontext instances method control flow represented control flow graph controlflowgraph ordered instruction context instructioncontext get instruction contexts getinstructioncontexts instruction context instructioncontext ret instruction context instructioncontext instruction contexts instructioncontexts values size instruction context instructioncontext instruction contexts instructioncontexts values to array toarray ret returns instruction reachable control flow graph controlflowgraph is dead isdead instruction handle instructionhandle instruction contexts instructioncontexts contains key containskey