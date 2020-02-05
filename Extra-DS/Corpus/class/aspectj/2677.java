/*******************************************************************************
 * Copyright (c) 2005 Contributors.
 * All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution and is available at 
 * http://eclipse.org/legal/epl-v10.html 
 * 
 * Contributors:
 *   Alexandre Vasseur         initial implementation
 *******************************************************************************/
package ataspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import junit.framework.TestCase;

/**
 * @author <a href="mailto:alex AT gnilux DOT com">Alexandre Vasseur</a>
 */
public class PerClauseInheritanceTest extends TestCase {

    static StringBuffer s_log = new StringBuffer();

    static void log(String s) {
        s_log.append(s).append(" ");
    }

    public static void main(String[] args) {
        TestHelper.runAndThrowOnFailure(suite());
    }

    public static junit.framework.Test suite() {
        return new junit.framework.TestSuite(PerClauseInheritanceTest.class);
    }

    public void hello() {
        log("hello");
    }

    public void testInheritance() {
        s_log = new StringBuffer();
        hello();
        assertEquals("aop hello ", s_log.toString());
        s_log = new StringBuffer();
        PerClauseInheritanceTest t = new PerClauseInheritanceTest();
        t.hello();
        assertEquals("aop hello ", s_log.toString());
        assertEquals(2, ChildAspect.COUNT);
    }

    @Aspect("perthis(execution(* ataspectj.PerClauseInheritanceTest.hello()))")
    abstract static class ParentAspect {

        @Pointcut("execution(* ataspectj.PerClauseInheritanceTest.hello())")
        void pc() {
        }
    }

    //perFromSuper
    @Aspect
    abstract static class MidParentAspect extends ParentAspect {
    }

    //perFromSuper
    @Aspect
    static class ChildAspect extends MidParentAspect {

        static int COUNT = 0;

        public  ChildAspect() {
            COUNT++;
        }

        @SuppressAjWarnings
        @Before("pc()")
        public void abefore() {
            log("aop");
        }
    }
}
