package cz.vondr.obj2string;

import org.junit.Test;

import static org.junit.Assert.*;

public class IdentitySetTest {

    @Test
    public void testEmptyReturnFalse() throws Exception {
        IdentitySet idSet = new IdentitySet();
        assertFalse(idSet.contains("String"));
    }

    @Test
    public void testNull() throws Exception {
        IdentitySet idSet = new IdentitySet();
        idSet.add(null);
        assertFalse(idSet.contains(null));
    }

    @Test
    public void testHappyCase() throws Exception {
        IdentitySet idSet = new IdentitySet();
        Object a = new Object();
        Object b = new Object();
        assertFalse(idSet.contains(a));
        assertFalse(idSet.contains(a));
        idSet.add(a);
        assertTrue(idSet.contains(a));
        assertTrue(idSet.contains(a));
        assertFalse(idSet.contains(b));
        idSet.add(b);
        assertTrue(idSet.contains(b));

    }
}
