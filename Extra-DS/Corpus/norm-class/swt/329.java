copyright ibm corporation rights reserved program accompanying materials terms eclipse license accompanies distribution http eclipse org legal epl html contributors ibm corporation initial api implementation org eclipse swt ole win org eclipse swt org eclipse swt internal ole win org eclipse swt internal win variant ole mechanism passing data types common ole automation oleautomation object property setting property invoking method ole control ole document variant variant takes bytes matter store objects strings arrays physically stored variant cases bytes variant hold object reference pointer string array actual data stored sizeof ole type type boolean data booleandata float data floatdata int data intdata short data shortdata string string data stringdata by ref ptr byrefptr idispatch dispatch data dispatchdata iunknown unknown data unknowndata create empty variant object type empty variant type empty create variant object represents java param val java variant represents variant val type float data floatdata val create variant object represents java param val java variant represents variant val type int data intdata val create variant object reference data transferred creating byref variant full variant type including byref pre code by ref type byreftype ole bstr ole byref code pre param ptr pointer data transferred param by ref type byreftype type data transferred ole bstr ole byref variant ptr by ref type byreftype type by ref type byreftype by ref ptr byrefptr ptr create variant object represents idispatch dispatch param automation ole automation oleautomation object variant represents variant ole automation oleautomation automation type dispatch dispatch data dispatchdata idispatch automation get address getaddress create variant object represents idispatch dispatch caller expected appropriately invoked unknown add ref addref creating variant param idispatch idispatch object variant represents variant idispatch idispatch type dispatch dispatch data dispatchdata idispatch create variant object represents iunknown unknown caller expected appropriately invoked unknown add ref addref creating variant param unknown iunknown object variant represents variant iunknown unknown type unknown unknown data unknowndata unknown create variant object represents java string bstr param string java string variant represents variant string string type bstr string data stringdata string create variant object represents java param val java variant represents variant val type short data shortdata val create variant object represents java bool param val java variant represents variant val type bool boolean data booleandata val calling dispose release resources variant resource idispatch iunknown release called resource by ref byref pointer released dispose type byref byref type empty bool bstr dispatch dispatch data dispatchdata release unknown unknown data unknowndata release returns ole automation oleautomation object represented variant variant ole automation oleautomation object attempt coerce variant type ole automation oleautomation object fails error thrown note ole automation oleautomation objects disposed longer needed ole automation oleautomation object represented variant exception swtexception error change variant type type variant coerced ole automation oleautomation object ole automation oleautomation get automation getautomation type empty ole error ole error change variant type type dispatch ole automation oleautomation dispatch data dispatchdata coerce desired type old ptr oldptr global alloc globalalloc gmem fixed gmem zeroinit sizeof new ptr newptr global alloc globalalloc gmem fixed gmem zeroinit sizeof get data getdata old ptr oldptr result variant change type variantchangetype new ptr newptr old ptr oldptr dispatch result ole error ole error change variant type result variant auto var autovar variant auto var autovar set data setdata new ptr newptr auto var autovar get automation getautomation variant clear variantclear old ptr oldptr global free globalfree old ptr oldptr note absolutely variant clear variantclear new ptr newptr ole automation oleautomation object created variant clear result release performed dispatch object global free globalfree new ptr newptr returns idispatch object represented variant variant idispatch object attempt coerce variant type idispatch object fails error thrown idispatch object represented variant exception swtexception error change variant type type variant coerced idispatch object idispatch get dispatch getdispatch type empty ole error ole error change variant type type dispatch dispatch data dispatchdata coerce desired type old ptr oldptr global alloc globalalloc gmem fixed gmem zeroinit sizeof new ptr newptr global alloc globalalloc gmem fixed gmem zeroinit sizeof get data getdata old ptr oldptr result variant change type variantchangetype new ptr newptr old ptr oldptr dispatch result ole error ole error change variant type result variant auto var autovar variant auto var autovar set data setdata new ptr newptr auto var autovar get dispatch getdispatch variant clear variantclear old ptr oldptr global free globalfree old ptr oldptr note absolutely variant clear variantclear new ptr newptr ole automation oleautomation object created variant clear result release performed dispatch object global free globalfree new ptr newptr returns java represented variant variant java attempt coerce variant type java fails error thrown java represented variant exception swtexception error change variant type type variant coerced get boolean getboolean type empty ole error ole error change variant type type bool boolean data booleandata coerce desired type old ptr oldptr global alloc globalalloc gmem fixed gmem zeroinit sizeof new ptr newptr global alloc globalalloc gmem fixed gmem zeroinit sizeof get data getdata old ptr oldptr result variant change type variantchangetype new ptr newptr old ptr oldptr bool result ole error ole error change variant type result variant bool var boolvar variant bool var boolvar set data setdata new ptr newptr bool var boolvar get boolean getboolean variant clear variantclear old ptr oldptr global free globalfree old ptr oldptr variant clear variantclear new ptr newptr global free globalfree new ptr newptr returns pointer referenced data represented variant variant reference data returned pointer referenced data represented variant get by ref getbyref type empty ole error ole error change variant type type byref byref by ref ptr byrefptr get data getdata p data pdata p data pdata ole error ole error memory variant init variantinit p data pdata type byref byref move memory movememory p data pdata type move memory movememory p data pdata by ref ptr byrefptr type empty bool move memory movememory p data pdata type move memory movememory p data pdata boolean data booleandata variant variant move memory movememory p data pdata type move memory movememory p data pdata float data floatdata move memory movememory p data pdata type move memory movememory p data pdata int data intdata dispatch dispatch data dispatchdata add ref addref move memory movememory p data pdata type move memory movememory p data pdata dispatch data dispatchdata get address getaddress unknown unknown data unknowndata add ref addref move memory movememory p data pdata type move memory movememory p data pdata unknown data unknowndata get address getaddress move memory movememory p data pdata type move memory movememory p data pdata short data shortdata bstr move memory movememory p data pdata type data string data stringdata to char array tochararray ptr sys alloc string sysallocstring data move memory movememory p data pdata ptr ole error swt error implemented returns java represented variant variant java attempt coerce variant type java fails error thrown java represented variant exception swtexception error change variant type type variant coerced get float getfloat type empty ole error ole error change variant type type float data floatdata coerce desired type old ptr oldptr global alloc globalalloc gmem fixed gmem zeroinit sizeof new ptr newptr global alloc globalalloc gmem fixed gmem zeroinit sizeof get data getdata old ptr oldptr result variant change type variantchangetype new ptr newptr old ptr oldptr result ole error ole error change variant type result variant float var floatvar variant float var floatvar set data setdata new ptr newptr float var floatvar get float getfloat variant clear variantclear old ptr oldptr global free globalfree old ptr oldptr variant clear variantclear new ptr newptr global free globalfree new ptr newptr returns java represented variant variant java attempt coerce variant type java fails error thrown java represented variant exception swtexception error change variant type type variant coerced get int getint type empty ole error ole error change variant type type int data intdata coerce desired type old ptr oldptr global alloc globalalloc gmem fixed gmem zeroinit sizeof new ptr newptr global alloc globalalloc gmem fixed gmem zeroinit sizeof get data getdata old ptr oldptr result variant change type variantchangetype new ptr newptr old ptr oldptr result ole error ole error change variant type result variant int var intvar variant int var intvar set data setdata new ptr newptr int var intvar get int getint variant clear variantclear old ptr oldptr global free globalfree old ptr oldptr variant clear variantclear new ptr newptr global free globalfree new ptr newptr returns java represented variant variant java attempt coerce variant type java fails error thrown java represented variant exception swtexception error change variant type type variant coerced get short getshort type empty ole error ole error change variant type type short data shortdata coerce desired type old ptr oldptr global alloc globalalloc gmem fixed gmem zeroinit sizeof new ptr newptr global alloc globalalloc gmem fixed gmem zeroinit sizeof get data getdata old ptr oldptr result variant change type variantchangetype new ptr newptr old ptr oldptr result ole error ole error change variant type result variant short var shortvar variant short var shortvar set data setdata new ptr newptr short var shortvar get short getshort variant clear variantclear old ptr oldptr global free globalfree old ptr oldptr variant clear variantclear new ptr newptr global free globalfree new ptr newptr returns java string represented variant variant java string attempt coerce variant type java string fails error thrown java string represented variant exception swtexception error change variant type type variant coerced string string get string getstring type empty ole error ole error change variant type type bstr string data stringdata coerce desired type old ptr oldptr global alloc globalalloc gmem fixed gmem zeroinit sizeof new ptr newptr global alloc globalalloc gmem fixed gmem zeroinit sizeof get data getdata old ptr oldptr result variant change type variantchangetype new ptr newptr old ptr oldptr bstr result ole error ole error change variant type result variant string var stringvar variant string var stringvar set data setdata new ptr newptr string var stringvar get string getstring variant clear variantclear old ptr oldptr global free globalfree old ptr oldptr variant clear variantclear new ptr newptr global free globalfree new ptr newptr returns type variant type ole bitwise combination ole values ole bstr ole byref type variant data get type gettype type returns iunknown object represented variant variant iunknown object attempt coerce variant type iunknown object fails error thrown iunknown object represented variant exception swtexception error change variant type type variant coerced iunknown object iunknown get unknown getunknown type empty ole error ole error change variant type type unknown unknown data unknowndata coerce desired type old ptr oldptr global alloc globalalloc gmem fixed gmem zeroinit sizeof new ptr newptr global alloc globalalloc gmem fixed gmem zeroinit sizeof get data getdata old ptr oldptr result variant change type variantchangetype new ptr newptr old ptr oldptr unknown result ole error ole error change variant type result variant unknown var unknownvar variant unknown var unknownvar set data setdata new ptr newptr unknown var unknownvar get unknown getunknown variant clear variantclear old ptr oldptr global free globalfree old ptr oldptr note absolutely variant clear variantclear new ptr newptr iunknown object created variant clear result release performed dispatch object global free globalfree new ptr newptr update reference variant param val exception swtexception error change variant type type variant byref bool object set by ref setbyref val type byref type bool ole error ole error change variant type move memory movememory by ref ptr byrefptr val variant variant update reference variant param val exception swtexception error change variant type type variant byref object set by ref setbyref val type byref type ole error ole error change variant type move memory movememory by ref ptr byrefptr val update reference variant integer param val integer exception swtexception error change variant type type variant byref object set by ref setbyref val type byref type ole error ole error change variant type move memory movememory by ref ptr byrefptr val update reference variant param val exception swtexception error change variant type type variant byref object set by ref setbyref val type byref type ole error ole error change variant type move memory movememory by ref ptr byrefptr val set data setdata p data pdata p data pdata ole error ole error invalid argument data type datatype move memory movememory data type datatype p data pdata type data type datatype type byref byref new by ref ptr newbyrefptr move memory movememory new by ref ptr newbyrefptr p data pdata by ref ptr byrefptr new by ref ptr newbyrefptr type empty bool new boolean data newbooleandata move memory movememory new boolean data newbooleandata p data pdata boolean data booleandata new boolean data newbooleandata variant new float data newfloatdata move memory movememory new float data newfloatdata p data pdata float data floatdata new float data newfloatdata new int data newintdata move memory movememory new int data newintdata p data pdata int data intdata new int data newintdata dispatch ppv object ppvobject move memory movememory ppv object ppvobject p data pdata ppv object ppvobject type empty dispatch data dispatchdata idispatch ppv object ppvobject dispatch data dispatchdata add ref addref unknown ppv object ppvobject move memory movememory ppv object ppvobject p data pdata ppv object ppvobject type empty unknown data unknowndata iunknown ppv object ppvobject unknown data unknowndata add ref addref new short data newshortdata move memory movememory new short data newshortdata p data pdata short data shortdata new short data newshortdata bstr address memory string resides h mem hmem move memory movememory h mem hmem p data pdata h mem hmem type empty size string size expressed number bytes unicode character bytes size sys string byte len sysstringbytelen h mem hmem size unicode character array global memory create string add avoid rounding errors buffer size move memory movememory buffer h mem hmem size string data stringdata string buffer nls string data stringdata nls coercing forms new pdata newpdata global alloc globalalloc gmem fixed gmem zeroinit variant sizeof variant change type variantchangetype new pdata newpdata p data pdata set data setdata new pdata newpdata variant change type variantchangetype new pdata newpdata p data pdata set data setdata new pdata newpdata variant change type variantchangetype new pdata newpdata p data pdata bstr set data setdata new pdata newpdata variant clear variantclear new pdata newpdata global free globalfree new pdata newpdata returns string concise human readable description receiver string representation event string to string tostring type bool bool boolean data booleandata short data shortdata int data intdata float data floatdata bstr bstr string data stringdata dispatch dispatch dispatch data dispatchdata dispatch data dispatchdata get address getaddress unknown unknown unknown data unknowndata unknown data unknowndata get address getaddress empty empty type byref byref type byref by ref ptr byrefptr unsupported type type