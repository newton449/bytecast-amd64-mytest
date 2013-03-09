/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sheng
 */
public class SimpleTest {

    public static void main(String[] args) {
        byte b = (byte) 0xB7;
        System.out.println(b - (byte) 0xB0);
        System.out.println(String.format("%x", (byte) (b >>> (byte) 4)));
    }
}
