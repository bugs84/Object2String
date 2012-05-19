/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.vondr.obj2string.testobjects;

/**
 *
 * @author bugs
 */
public class IntString {
  private int number = 8;
  private String name = "John";

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public IntString setNumber(int number) {
        this.number = number;
        return this;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public IntString setName(String name) {
        this.name = name;
        return this;
    }
  
}
