package cz.vondr.obj2string;

import java.lang.reflect.Field;


/**
 * Class which get events from test object "parser" and is responsible for creating result.
 * <p/>
 * INTERFACE OF THIS CLASS SHOULD BE SIMPLE, SO THAT EVERYONE CAN WRITE EASILY OWN FORMATTER
 *
 * @author bugs
 */
// Note: TODO - Formatter is not eanglish word - mabe choose another
public class Formatter {//TODO this will be interface in the end
    private StringBuilder sb;

    //I am not sure if here will reference to parser I hope
    private Parser parser;

    public Formatter() {
        this.sb = new StringBuilder();
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }


    public void field(String name, int modifiers, Object obj, Field field) {//TODO instead modifiers as int, return them as List of some enum
        sb.append("FieldName=").append(name).append(", ");
//        sb.append("Syntetic:").append(field.isSynthetic()).append(", ");
        sb.append("Value:").append(getValueToString(obj, field));
        sb.append('\n');
    }

    public void arrayStart() {
        sb.append("[");
    }

    public void arrayItem(Object arrayItem) {
        sb.append(arrayItem);
    }

    public void arrayBetweenElements() {
        sb.append(", ");
    }

    public void arrayEnd() {
        sb.append("]\n");
    }

    /** clear result */
    public void clear() {
        sb = new StringBuilder();
    }

    public String getResult() {
        return sb.toString();
    }


    /**
     * return value of field
     *
     * @param obj Object containing this field
     */
    public static String getValueToString(Object obj, Field field) {
        try {
            String value = null;
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }


            String typeName = field.getType().getName();
            Class<?> fieldType = field.getType();
            System.out.println("TypeName: " + typeName);
            System.out.println("GenericType: " + field.getGenericType());
            System.out.println("isAnnotation: " + fieldType.isAnnotation());
            System.out.println("isAnonymousClass: " + fieldType.isAnonymousClass());
            System.out.println("isArray: " + fieldType.isArray());
            System.out.println("isEnum: " + fieldType.isEnum());
            System.out.println("isInterface: " + fieldType.isInterface());
            System.out.println("isLocalClass: " + fieldType.isLocalClass());
            System.out.println("isMemberClass: " + fieldType.isMemberClass());
            System.out.println("isPrimitive: " + fieldType.isPrimitive());
            System.out.println("isSynthetic: " + fieldType.isSynthetic());
            System.out.println();


            if (fieldType.isPrimitive()) {
                return getPrimitiveFieldValue(obj, field);
            } else {

                return field.get(obj).toString();
            }

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /** field must be accesible and must be primitive */
    private static String getPrimitiveFieldValue(Object obj, Field field) {
        //TODO maybe that it can be done in more effective way...
        String typeName = field.getType().getName();
        try {
            if ("byte".equals(typeName)) {
                return String.valueOf(field.getByte(obj));
            }
            if ("short".equals(typeName)) {
                return String.valueOf(field.getShort(obj));
            }
            if ("int".equals(typeName)) {
                return String.valueOf(field.getInt(obj));
            }
            if ("long".equals(typeName)) {
                return String.valueOf(field.getLong(obj));
            }
            if ("float".equals(typeName)) {
                return String.valueOf(field.getFloat(obj));
            }
            if ("double".equals(typeName)) {
                return String.valueOf(field.getDouble(obj));
            }
            if ("boolean".equals(typeName)) {
                return String.valueOf(field.getBoolean(obj));
            }
            if ("char".equals(typeName)) {
                return String.valueOf(field.getChar(obj));
            }
            throw new IllegalArgumentException("Field must be primitive type, but was - " + typeName);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
