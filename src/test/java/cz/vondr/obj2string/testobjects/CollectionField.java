package cz.vondr.obj2string.testobjects;


import java.util.ArrayList;
import java.util.Collection;

public class CollectionField {
    public String[] stringArray = new String[]{"aaa", "bbb"};
    public Collection<String> stringCollection = new ArrayList<String>() {{
        add("aaa");
        add("bbb");
    }};


}
