package cz.vondr.obj2string;

import java.lang.reflect.Field;


/**
 * Class which get events from test object "parser" and is responsible for creating result.
 * @author bugs
 */
public class ResultBuilder {//TODO this will be interface in the end
    StringBuilder sb;

    public ResultBuilder() {
        this.sb = new StringBuilder();
    }

    public void field(String name, boolean synthetic, int modifiers, Field field) {//TODO instead modifiers as int, return them as List of some enum
        sb.append("FieldName=").append(field.getName()).append(",");
        sb.append("Syntetic:").append(field.isSynthetic());
        sb.append('\n');
    }

    /** clear result */
    public void clear() {
        sb = new StringBuilder();
    }

    public String getResult() {
        return sb.toString();
    }
}
