/*
Copyright (c) 1997 - 2004 Harold Carr

This work is licensed under the Creative Commons Attribution License.
To view a copy of this license, visit 
  http://creativecommons.org/licenses/by/2.0/
or send a letter to
  Creative Commons, 559 Nathan Abbott Way, Stanford, California 94305, USA.
------------------------------------------------------------------------------
*/

/**
 * Created       : 1999 Dec 23 (Thu) 18:36:42 by Harold Carr.
 * Last Modified : 2004 Dec 07 (Tue) 19:08:09 by Harold Carr.
 */

package org.llava.impl.procedure;

import org.llava.F;
import org.llava.Pair;
import org.llava.runtime.Engine;

import org.llava.impl.procedure.PrimitiveProcedure;

public class Prim_LT
    extends
	PrimitiveProcedure
{
    public Prim_LT ()
    {
    }

    public Prim_LT newPrim_LT ()
    {
	return new Prim_LT();
    }

    public Object apply (Pair args, Engine engine)
    {
	return Prim_NumHelp.doOpBoolean(Prim_NumHelp.LT, args);
    }
}

// End of file.