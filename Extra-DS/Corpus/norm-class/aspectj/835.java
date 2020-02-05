copyright contributors rights reserved program accompanying materials terms common license accompanies distribution http eclipse org legal cpl html contributors adrian colyer initial implementation org aspectj apache bcel classfile tests org aspectj apache bcel classfile generic signature parser genericsignatureparser org aspectj apache bcel classfile java class javaclass org aspectj apache bcel classfile method org aspectj apache bcel classfile signature org aspectj apache bcel classfile signature class signature classsignature org aspectj apache bcel classfile signature class type signature classtypesignature org aspectj apache bcel classfile signature field type signature fieldtypesignature org aspectj apache bcel classfile signature simple class type signature simpleclasstypesignature org aspectj apache bcel util synthetic repository syntheticrepository junit framework test case testcase generic signature parser test genericsignatureparsertest test case testcase generic signature parser genericsignatureparser parser test simple tokenize testsimpletokenize string tokens parser tokenize ljava lang string assert equals assertequals string ljava lang string tokens test tokenize with wild type arguments testtokenizewithwildtypearguments string tokens parser tokenize ljava lang string assert equals assertequals string ljava lang string tokens test tokenize with extends type arguments testtokenizewithextendstypearguments string tokens parser tokenize ljava util list assert equals assertequals string ljava util list tokens test tokenize with super type arguments testtokenizewithsupertypearguments string tokens parser tokenize ljava util list assert equals assertequals string ljava util list tokens test tokenize array type testtokenizearraytype string tokens parser tokenize ljava lang string assert equals assertequals string ljava lang string tokens test tokenize formal type parameters testtokenizeformaltypeparameters string tokens parser tokenize ljava lang string ljava util comparable assert equals assertequals string ljava lang string ljava util comparable tokens test parse class signature simple testparseclasssignaturesimple class signature classsignature sig parser parse as class signature parseasclasssignature ljava lang string assert equals assertequals type parameters sig formal type parameters formaltypeparameters length assert equals assertequals superinterfaces sig super interface signatures superinterfacesignatures length assert equals assertequals ljava lang string sig superclass signature superclasssignature class signature classsignature simple class type signature simpleclasstypesignature outer type outertype sig superclass signature superclasssignature outer type outertype assert equals assertequals ljava lang string outer type outertype identifier assert equals assertequals type args outer type outertype type arguments typearguments length test parse class signature type args testparseclasssignaturetypeargs class signature classsignature sig parser parse as class signature parseasclasssignature ljava util list ljava lang string assert equals assertequals type parameters sig formal type parameters formaltypeparameters length assert equals assertequals superinterfaces sig super interface signatures superinterfacesignatures length assert equals assertequals ljava util list ljava lang string sig superclass signature superclasssignature class signature classsignature simple class type signature simpleclasstypesignature outer type outertype sig superclass signature superclasssignature outer type outertype assert equals assertequals ljava util list outer type outertype identifier assert equals assertequals type arg outer type outertype type arguments typearguments length assert true asserttrue outer type outertype type arguments typearguments is plus isplus assert equals assertequals ljava lang string outer type outertype type arguments typearguments to string tostring test parse class signature the full monty testparseclasssignaturethefullmonty class signature classsignature sig parser parse as class signature parseasclasssignature ljava lang string ljava lang number ljava util list ljava util comparable assert equals assertequals formal parameter sig formal type parameters formaltypeparameters length assert equals assertequals sig formal type parameters formaltypeparameters identifier class type signature classtypesignature fsig class type signature classtypesignature sig formal type parameters formaltypeparameters class bound classbound assert equals assertequals ljava lang string fsig class signature classsignature assert equals assertequals bound sig formal type parameters formaltypeparameters interface bounds interfacebounds length class type signature classtypesignature isig class type signature classtypesignature sig formal type parameters formaltypeparameters interface bounds interfacebounds assert equals assertequals ljava lang number isig class signature classsignature assert equals assertequals ljava util list sig superclass signature superclasssignature class signature classsignature assert equals assertequals type argument sig superclass signature superclasssignature outer type outertype type arguments typearguments length assert equals assertequals sig superclass signature superclasssignature outer type outertype type arguments typearguments to string tostring assert equals assertequals sig super interface signatures superinterfacesignatures length assert equals assertequals ljava util comparable sig super interface signatures superinterfacesignatures to string tostring test class signature parsing in jdk testclasssignatureparsinginjdk exception synthetic repository syntheticrepository repository synthetic repository syntheticrepository get instance getinstance string test classes testclasses string java lang comparable java lang iterable java lang java lang enum java lang inheritable thread local inheritablethreadlocal java lang thread local threadlocal java util collection java util comparator java util enumeration java util iterator java util list java util list iterator listiterator java util map java util map entry java util queue java util java util sorted map sortedmap java util sorted set sortedset test classes testclasses length java class javaclass repository load class loadclass test classes testclasses string sig get generic signature getgenericsignature parser parse as class signature parseasclasssignature sig test field signature parsing class type testfieldsignatureparsingclasstype field type signature fieldtypesignature fsig parser parse as field signature parseasfieldsignature ljava lang string assert true asserttrue class type signature classtypesignature fsig class type signature classtypesignature assert equals assertequals ljava lang string fsig to string tostring test field signature parsing array type testfieldsignatureparsingarraytype field type signature fieldtypesignature fsig parser parse as field signature parseasfieldsignature ljava lang string assert true asserttrue array type signature arraytypesignature fsig signature array type signature arraytypesignature assert equals assertequals ljava lang string fsig to string tostring test field signature parsing type variable testfieldsignatureparsingtypevariable field type signature fieldtypesignature fsig parser parse as field signature parseasfieldsignature assert true asserttrue type variable signature typevariablesignature fsig signature type variable signature typevariablesignature assert equals assertequals fsig to string tostring test simple method signature parsing testsimplemethodsignatureparsing signature method type signature methodtypesignature m sig msig parser parse as method signature parseasmethodsignature assert equals assertequals type parameters m sig msig formal type parameters formaltypeparameters length assert equals assertequals parameters m sig msig parameters length assert equals assertequals type m sig msig return type returntype to string tostring assert equals assertequals m sig msig throws signatures throwssignatures length test method signature type params testmethodsignaturetypeparams signature method type signature methodtypesignature m sig msig parser parse as method signature parseasmethodsignature assert equals assertequals type parameter m sig msig formal type parameters formaltypeparameters length assert equals assertequals m sig msig formal type parameters formaltypeparameters identifier assert equals assertequals ljava lang object m sig msig formal type parameters formaltypeparameters class bound classbound to string tostring assert equals assertequals parameter m sig msig parameters length assert equals assertequals m sig msig parameters to string tostring assert equals assertequals type m sig msig return type returntype to string tostring assert equals assertequals m sig msig throws signatures throwssignatures length test method signature generic return testmethodsignaturegenericreturn signature method type signature methodtypesignature m sig msig parser parse as method signature parseasmethodsignature assert equals assertequals type parameter m sig msig formal type parameters formaltypeparameters length assert equals assertequals m sig msig formal type parameters formaltypeparameters identifier assert equals assertequals ljava lang object m sig msig formal type parameters formaltypeparameters class bound classbound to string tostring assert equals assertequals parameters m sig msig parameters length assert equals assertequals type m sig msig return type returntype to string tostring assert equals assertequals m sig msig throws signatures throwssignatures length test method signature throws testmethodsignaturethrows signature method type signature methodtypesignature m sig msig parser parse as method signature parseasmethodsignature ljava lang exception ljava lang runtime exception runtimeexception assert equals assertequals type parameter m sig msig formal type parameters formaltypeparameters length assert equals assertequals m sig msig formal type parameters formaltypeparameters identifier assert equals assertequals ljava lang object m sig msig formal type parameters formaltypeparameters class bound classbound to string tostring assert equals assertequals parameter m sig msig parameters length assert equals assertequals m sig msig parameters to string tostring assert equals assertequals type m sig msig return type returntype to string tostring assert equals assertequals m sig msig throws signatures throwssignatures length assert equals assertequals ljava lang exception m sig msig throws signatures throwssignatures to string tostring assert equals assertequals ljava lang runtime exception runtimeexception m sig msig throws signatures throwssignatures to string tostring test method signature primitive params testmethodsignatureprimitiveparams signature method type signature methodtypesignature m sig msig parser parse as method signature parseasmethodsignature iljava lang object assert equals assertequals parameters m sig msig parameters length assert equals assertequals m sig msig parameters to string tostring assert equals assertequals ljava lang object m sig msig parameters to string tostring test method signature parsing in jdk testmethodsignatureparsinginjdk exception synthetic repository syntheticrepository repository synthetic repository syntheticrepository get instance getinstance string test classes testclasses string java lang comparable java lang iterable java lang java lang enum java lang inheritable thread local inheritablethreadlocal java lang thread local threadlocal java util collection java util comparator java util enumeration java util iterator java util list java util list iterator listiterator java util map java util map entry java util queue java util java util sorted map sortedmap java util sorted set sortedset test classes testclasses length java class javaclass repository load class loadclass test classes testclasses method methods get methods getmethods methods length string sig methods get generic signature getgenericsignature sig parser parse as method signature parseasmethodsignature sig test fully qualified superclass after type params testfullyqualifiedsuperclassaftertypeparams signature field type signature fieldtypesignature c sig csig parser parse as field signature parseasfieldsignature ljava util list fail expected illegal state exception illegalstateexception illegal state exception illegalstateexception assert true asserttrue get message getmessage index of indexof ljava util list test pr testpr parser parse as method signature parseasmethodsignature lcom cibc responders mapping common data bean scenario commondatabeanscenario ljava lang object lcom cibc responders response formatter bljava lang object parser parse as class signature parseasclasssignature parent ljava lang object child ljava lang object ljava lang object assert equals assertequals string expected string actual actual length expected length shorter math min expected length actual length shorter actual equals expected fail expected expected position actual fail expected expected length tokens actual length tokens to string tokenstostring actual actual length actual equals expected fail expected expected position actual string tokens to string tokenstostring string tokens string buffer stringbuffer string buffer stringbuffer append tokens tokens length append append tokens to string tostring set up setup exception set up setup parser generic signature parser genericsignatureparser