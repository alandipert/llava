package testLava;

import java.io.*;

interface Collection<A> {
    public void add(A x);
    public Iterator<A> iterator();
}
interface Iterator<A> {
    public A next();
    public boolean hasNext();
}
class NoSuchElementException extends RuntimeException {}
class LinkedList<A> implements Collection<A> {
    protected class Node {
	A elt;
	Node next = null;
	Node (A elt) { this.elt=elt; }
    }
    protected Node head = null, tail = null;
    public LinkedList () {}
    public void add (A elt) {
	if (head==null) { head=new Node(elt); tail=head; }
	else { tail.next=new Node(elt); tail=tail.next; }
    }
    public Iterator<A> iterator () {
	return new Iterator<A> () {
	    protected Node ptr=head;
	    public boolean hasNext () { return ptr!=null; }
	    public A next () {
		if (ptr!=null) {
		    A elt=ptr.elt; ptr=ptr.next; return elt;
		} else throw new NoSuchElementException ();
	    }
	};
    }
}

public class TestGJ {
    public static void main (String[] args) {
	// byte collection
	LinkedList<Byte> xs = new LinkedList<Byte>();
	xs.add(new Byte((byte)0)); xs.add(new Byte((byte)1));
	Byte x = xs.iterator().next();
	System.out.println(x);
	// boolean collection
	LinkedList<Boolean> ys = new LinkedList<Boolean>();
	ys.add(new Boolean(false)); ys.add(new Boolean(true));
	Boolean y = ys.iterator().next();
	System.out.println(y);

	String foo = "foo";
	System.out.println(foo.intern());
	System.out.println(foo.intern());
	String fooX = "foo";
	System.out.println(foo == fooX);
	System.out.println(fooX.intern());
	System.out.println(foo.intern() == fooX.intern());
	System.out.println(null instanceof Object);
    }
}

// End of file.

