/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.vondr.obj2string;

/**
 *
 * @author bugs
 */
public class O2S {

    public String toString(Object object) {

        return new Parser(new TokenOrder(), new Formatter()).parse(object);




//        sb = new StringBuilder();
//        for (Field field : object.getClass().getDeclaredFields()) {//vs. getFields()
//            sb.append("FieldName=").append(field.getName()).append(",");
//            sb.append("Syntetic:").append(field.isSynthetic());
//            sb.append('\n');
//        }
//
//        return sb.toString();
    }

}
