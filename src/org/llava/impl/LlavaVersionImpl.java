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
 * Created       : 2000 Jan 19 (Wed) 17:30:46 by Harold Carr.
 * Last Modified : 2004 Dec 05 (Sun) 12:33:07 by Harold Carr.
 */

package org.llava.impl;

import org.llava.LlavaVersion;

public class LlavaVersionImpl
    implements
	LlavaVersion
{
    public LlavaVersionImpl ()
    {
    }

    public LlavaVersion newLlavaVersion ()
    {
	return new LlavaVersionImpl();
    }

    public String toString ()
    {
      return "llava version $VERSION$";
    }
}

// End of file.
