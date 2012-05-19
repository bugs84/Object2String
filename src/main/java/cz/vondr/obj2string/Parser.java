package cz.vondr.obj2string;

import java.lang.reflect.Field;

public class Parser {

    private TokenOrder tokenOrder;
    private Formatter formatter;

    public Parser(TokenOrder tokenOrder, Formatter resultBuilder) {
        this.tokenOrder = tokenOrder;
        this.formatter = resultBuilder;
        formatter.setParser(this);
    }

    /** Parser and return result */
    public String parse(Object obj) {
        try {
            //TODO while with switch over tokenOrder
            for (Field field : obj.getClass().getDeclaredFields()) {//vs. getFields()


                Class<?> fieldType = field.getType();

                if (fieldType.isPrimitive()) {
                    formatter.field(field.getName(), field.getModifiers(), obj, field);
                }

                if (fieldType.isArray()) {
                    Object[] array = (Object[]) field.get(obj);
                    formatter.arrayStart();
                    if (array != null) {
                        for (int i = 0; i < array.length; i++) {
                            Object arrayItem = array[i];
                            formatter.arrayItem(arrayItem);
                            if (i < array.length - 1){
                                formatter.arrayBetweenElements();
                            }

                        }
                    }


                    formatter.arrayEnd();
                }


                formatter.field(field.getName(), field.getModifiers(), obj, field);
                if (!fieldType.isPrimitive()) {
                    Object obj1 = field.get(obj);
                    parse(obj1);
                }

            }
            return formatter.getResult();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
