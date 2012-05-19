package cz.vondr.obj2string.develop;

import cz.vondr.obj2string.O2S;
import cz.vondr.obj2string.testobjects.ArrayAndCollection;

public class MainArrayAndCollection {

    public static void main(String[] args) {
        System.out.println("Result:");
        Object obj = new ArrayAndCollection();
        System.out.println(new O2S().toString(obj));

        System.out.println();
        System.out.println();

    }
}

