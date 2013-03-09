/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.syr.bytecast.amd64.impl.decoder;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author sheng
 */
public class DecoderTestUtilsTest {

    @Test
    public void testStringToByteArray() {
        // Normal arguments.
        assertArrayEquals(new byte[]{0x11, 0x22, 0x33, 0x44}, ParserTestUtils.stringToByteArray("11 22 33 44"));
        assertArrayEquals(new byte[]{(byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xff}, ParserTestUtils.stringToByteArray("aa bb cc ff"));
        assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0xBB, (byte) 0xCC, (byte) 0xFF}, ParserTestUtils.stringToByteArray("AA BB CC FF"));
        assertArrayEquals(new byte[]{(byte) 0xF1}, ParserTestUtils.stringToByteArray("F1"));

        // Abnormal agruments.
        try {
            ParserTestUtils.stringToByteArray("");
            fail();
        } catch (RuntimeException ex) {
        }
        try {
            ParserTestUtils.stringToByteArray("0xaa");
            fail();
        } catch (RuntimeException ex) {
        }
        try {
            ParserTestUtils.stringToByteArray("0xAA");
            fail();
        } catch (RuntimeException ex) {
        }
        try {
            ParserTestUtils.stringToByteArray("0xaa");
            fail();
        } catch (RuntimeException ex) {
        }
        try {
            ParserTestUtils.stringToByteArray("1fd3");
            fail();
        } catch (RuntimeException ex) {
        }
        try {
            ParserTestUtils.stringToByteArray("0G");
            fail();
        } catch (RuntimeException ex) {
        }
        try {
            ParserTestUtils.stringToByteArray("!@#$%^");
            fail();
        } catch (RuntimeException ex) {
        }
    }
}
