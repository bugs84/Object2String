package cz.vondr.obj2string;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;

public class Parser {

    private TokenOrder tokenOrder;
    private Formatter formatter;

    IdentitySet parsedObjects = new IdentitySet();

    public Parser(TokenOrder tokenOrder, Formatter resultBuilder) {
        this.tokenOrder = tokenOrder;
        this.formatter = resultBuilder;
        formatter.setParser(this);
    }

    /** Parser and return result */
    public String parse(Object obj) {
        parseInternal(obj);
        return formatter.getResult();
    }

    /** Parser and return result */
    protected void parseInternal(Object obj) {
        if (parsedObjects.contains(obj)) {
            //TODO what to do if object has already been parsed

            return;
        }
        parsedObjects.add(obj);
        try {
            //TODO while with switch over tokenOrder
            for (Field field : obj.getClass().getDeclaredFields()) {//vs. getFields()


                Class<?> fieldType = field.getType();

                if (fieldType.isPrimitive()) {
                    formatter.field(field.getName(), field.getModifiers(), obj, field);
                } else if (fieldType.isArray()) {
                    formatter.field(field.getName(), field.getModifiers(), obj, field);
                    Object arrayObj = field.get(obj);
                    formatter.arrayStart();
                    if (arrayObj != null) {
                        int arrayLength = Array.getLength(arrayObj);
                        for (int i = 0; i < arrayLength; i++) {
                            Object arrayItem = Array.get(arrayObj, i);
                            formatter.arrayItem(arrayItem);
                            //TODO Should I call parse on array item?
                            if (i < arrayLength - 1) {
                                formatter.arrayBetweenElements();
                            }

                        }
                    }
                    formatter.arrayEnd();
                } else if (obj instanceof Collection) {
                    Collection objCol = (Collection) obj;

                    formatter.field(field.getName(), field.getModifiers(), objCol, field);
                    formatter.arrayStart();
                    if (objCol != null) {
                        Iterator iterator = objCol.iterator();
                        while (iterator.hasNext()) {
                            Object arrayItem = iterator.next();
                            formatter.arrayItem(arrayItem);
                            if (iterator.hasNext()) {
                                formatter.arrayBetweenElements();
                            }

                        }
                    }
                    formatter.arrayEnd();


                } else {


                    formatter.field(field.getName(), field.getModifiers(), obj, field);

                    Object obj1 = field.get(obj);
                    System.out.println("ID hash: " + System.identityHashCode(obj));
                    parseInternal(obj1);

                }

            }
            return;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}
