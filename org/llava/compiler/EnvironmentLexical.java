/**
 * Created       : 1999 Dec 21 (Tue) 00:04:24 by Harold Carr.
 * Last Modified : 2001 Mar 26 (Mon) 14:38:50 by Harold Carr.
 */

package lavaProfile.compiler;

import lava.lang.types.Pair;
import lava.lang.types.Symbol;

/**
 * Compiletime lexical environment.
 */

public abstract class EnvironmentLexical
{
    public class LocalVariable
    {
	private int level;
	private int slot;
	LocalVariable (int level, int slot) {
	    this.level = level;
	    this.slot  = slot;
	}
	public int getLevel() { return level; }
	public int getSlot()  { return slot; }
    }

    abstract public EnvironmentLexical newEnvironmentLexical (Pair names);

    abstract public EnvironmentLexical extend (EnvironmentLexical names);

    abstract public EnvironmentLexical extend (Pair names);

    abstract public LocalVariable determineIfLocalVariable (Symbol name);

}

// End of file.

