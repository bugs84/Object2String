package cz.vondr.obj2string;

import java.lang.reflect.Field;

public class Parser {

    private TokenOrder tokenOrder;
    private ResultBuilder builder;

    public Parser(TokenOrder tokenOrder, ResultBuilder resultBuilder) {
        this.tokenOrder = tokenOrder;
        this.builder = resultBuilder;
    }

    /** Parser and return result */
    public String parse(Object obj) {
        //TODO while with switch over tokenOrder
        for (Field field : obj.getClass().getDeclaredFields()) {//vs. getFields()
            builder.field(field.getName(), field.isSynthetic(), field.getModifiers(), field);

        }
        return builder.getResult();
    }



}
