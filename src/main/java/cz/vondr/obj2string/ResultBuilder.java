package cz.vondr.obj2string;

import java.lang.reflect.Field;


/**
 * Class which get events from test object "parser" and is responsible for creating result.
 *
 * @author bugs
 */
public class ResultBuilder {//TODO this will be interface in the end
    private StringBuilder sb;

    public ResultBuilder() {
        this.sb = new StringBuilder();
    }

    public void field(String name, int modifiers, Object obj, Field field) {//TODO instead modifiers as int, return them as List of some enum
        sb.append("FieldName=").append(name).append(", ");
        sb.append("Syntetic:").append(field.isSynthetic()).append(", ");
        sb.append("Value:").append(getFieldValueToString(obj, field));
        sb.append('\n');
    }

    /** clear result */
    public void clear() {
        sb = new StringBuilder();
    }

    public String getResult() {
        return sb.toString();
    }

    //HELPER
    public static String getFieldValueToString(Object obj, Field field) {
        try {
            String value = null;
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }


            String typeName = field.getType().getName();
            if ("byte".equals(typeName)) {
                value = String.valueOf(field.getByte(obj));
            }
            if ("short".equals(typeName)) {
                value = String.valueOf(field.getShort(obj));
            }
            if ("int".equals(typeName)) {
                value = String.valueOf(field.getInt(obj));
            }
            if ("long".equals(typeName)) {
                value = String.valueOf(field.getLong(obj));
            }
            if ("float".equals(typeName)) {
                value = String.valueOf(field.getFloat(obj));
            }
            if ("double".equals(typeName)) {
                value = String.valueOf(field.getDouble(obj));
            }
            if ("boolean".equals(typeName)) {
                value = String.valueOf(field.getBoolean(obj));
            }
            if ("char".equals(typeName)) {
                value = String.valueOf(field.getChar(obj));
            }


            System.out.println("Type:" + field.getType());
            System.out.println("GenericType:" + field.getGenericType());
            return value;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


//        //TODO JustTesting remove
//        try {
//            Class<?> type2 = field.getType();
//
//            Field f2 = obj.getClass().getDeclaredFields()[0];
//            f2.setAccessible(true);
//
//            f2.getInt(obj);
//
//            Field f = obj.getClass().getDeclaredFields()[1];
//            f.setAccessible(true);
//            f.get(obj);
//
//            return type2.toString();
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
    }


}
