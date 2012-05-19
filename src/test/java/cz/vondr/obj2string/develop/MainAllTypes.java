package cz.vondr.obj2string.develop;

import cz.vondr.obj2string.O2S;
import cz.vondr.obj2string.testobjects.AllTypes;
import cz.vondr.obj2string.testobjects.IntComposed;

public class MainAllTypes {

    public static void main(String[] args) {
        System.out.println("Result:");
        Object obj = new AllTypes();
        System.out.println(new O2S().toString(obj));

        System.out.println();
        System.out.println();
        System.out.println("Main1 done");

    }
}

