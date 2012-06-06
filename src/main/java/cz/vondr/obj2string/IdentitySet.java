package cz.vondr.obj2string;

import java.util.HashSet;
import java.util.Set;

/** Set that contains all identities of inserted objects. */
class IdentitySet {

    private Set<Integer> identitySet = new HashSet<Integer>();

    public void add(Object obj) {
        identitySet.add(System.identityHashCode(obj));
    }

    public boolean contains(Object obj) {
        return identitySet.contains(System.identityHashCode(obj));
    }
}
