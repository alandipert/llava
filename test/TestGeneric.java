/**
 * Created       : 1999 Dec 28 (Tue) 05:43:41 by Harold Carr.
 * Last Modified : 2000 Feb 21 (Mon) 17:24:19 by Harold Carr.
 */

/*
Each of these says it takes an int.  Some will also take a long.

(sleep (.si 'currentThread 'java.lang.Thread) (new 'java.lang.Integer 1000))
(sleep (.si 'currentThread 'java.lang.Thread) (new 'java.lang.Long 1000))
(.si 'toHexString 'java.lang.Integer (new 'java.lang.Integer 15))
(.si 'toHexString 'java.lang.Integer (new 'java.lang.Long 15))
(compareTo 22 (new 'java.lang.Integer 21))
(compareTo 22 (new 'java.lang.Long 21))
(charAt "abc" (new 'java.lang.Integer 1))
(charAt "abc" (new 'java.lang.Long 1))
949513387412
9.49513387413E11
(load "import.scm")
(require 'java/lang/import)
(import "java.lang.System")
(System.currentTimeMillis)
(invoke-static 'java.lang.System 'currentTimeMillis)
(.si 'currentTimeMillis 'java.lang.System)
(define *which* 'skij)
(define *which* 'lava)
(define *which* 'silk)
(define (tt)
  (let ((t (case *which*
	     ((skij) (invoke-static 'java.lang.System 'currentTimeMillis))
	     ((lava) (.si 'currentTimeMillis 'java.lang.System))
	     ((silk) (System.currentTimeMillis))
	     (else (error "NO")))))
    (display (list t (+ t 1)))
    (< t (+ t 1))))
(tt)
 */

package testLava;

import lava.F;
import lava.lang.types.Symbol;
import libLava.rt.EnvironmentTopLevel;
import libLava.rt.UndefinedIdHandler;
import libLava.r1.FR1;
import libLava.r1.env.*;
import libLava.r1.procedure.generic.DI;
import libLava.r1.procedure.generic.GenericProcedure;

public class TestGeneric
{
    public static void testGeneric ()
    {
	testDI();
	testGenericProcedure();
    }

    public static void testGenericProcedure ()
    {
	TestCompilerAndEngine.topEnvironment.setUndefinedIdHandler
	    (new UndefinedIdHandlerImpl() { // REVISIT factory
		    public Object handle(EnvironmentTopLevel env, Symbol id) {
			GenericProcedure gp = FR1.newGenericProcedure();
			env.set(id, gp);
			return gp;
		    }
		}
            );

	TestCompilerAndEngine.topEnvironment.set(F.newSymbol("new"),
						 FR1.newPrimNew());

	Test.check("gen1", 
		   new Integer(123),
		   eval("(new (quote java.lang.Integer) 123)"));

	Test.check("gen2", 
		   new Double(123.0),
		   eval("(doubleValue (new (quote java.lang.Integer) 123))"));

    }

    public static Object eval(String s)
    {
	return TestCompilerAndEngine.eval(s);
    }

    public static void testDI ()
    {
	try {
	    Object v;
	    v = DI.newInstance(Integer.class, new Object[] { "123" });
	    Test.check("dyn1", new Integer(123), v);

	    v = DI.invoke("equals",
			  v,
			  new Object[] { new Integer("123") });
	    Test.check("dyn2", new Boolean(true), v);

	    v = DI.invokeStatic("parseInt",
				Integer.class,
				new Object[] { "F", new Integer(16) });
	    Test.check("dyn3", new Integer(15), v);

	    try {
		 v = DI.invokeStatic("test_i_iill",
				     testLava.TestGeneric.class,
				     new Object[]{new Integer(1),new Long(2),
						  new Integer(3),new Long(4)});
		 // I would like this to be the case, but no...
		 Test.check("dyn4", new Integer(10), v);
	    } catch (NoSuchMethodException e) {
	    }

	    v = DI.invokeStatic("test_l_iill",
				testLava.TestGeneric.class,
				new Object[]{new Integer(1),new Integer(2),
					     new Long(3),   new Long(4) });
	    // Note - Lava reader builds Integers but Java builds
	    // both Longs and Integers.
	    Test.check("dyn5", new Long(10), v);

	} catch (Throwable t) {
	    Test.bad("TestGeneric", "this should not happen", t);
	}
    }

    public static int test_i_iill (int i1, int i2, long l1, long l2)
    {
	return (int) (i1 + i2 + l1 + l2);
    }

    public static long test_l_iill (int i1, int i2, long l1, long l2)
    {
	return (long) (i1 + i2 + l1 + l2);
    }
}

// End of file.
