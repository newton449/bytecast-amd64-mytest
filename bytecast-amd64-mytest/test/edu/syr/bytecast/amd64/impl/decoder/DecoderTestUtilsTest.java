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
        assertArrayEquals(new byte[]{0x11, 0x22, 0x33, 0x44}, DecoderTestUtils.stringToByteArray("11 22 33 44"));
        assertArrayEquals(new byte[]{(byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xff}, DecoderTestUtils.stringToByteArray("aa bb cc ff"));
        assertArrayEquals(new byte[]{(byte) 0xAA, (byte) 0xBB, (byte) 0xCC, (byte) 0xFF}, DecoderTestUtils.stringToByteArray("AA BB CC FF"));
        assertArrayEquals(new byte[]{(byte) 0xF1}, DecoderTestUtils.stringToByteArray("F1"));

        // Abnormal agruments.
        try {
            DecoderTestUtils.stringToByteArray("");
            fail();
        } catch (RuntimeException ex) {
        }
        try {
            DecoderTestUtils.stringToByteArray("0xaa");
            fail();
        } catch (RuntimeException ex) {
        }
        try {
            DecoderTestUtils.stringToByteArray("0xAA");
            fail();
        } catch (RuntimeException ex) {
        }
        try {
            DecoderTestUtils.stringToByteArray("0xaa");
            fail();
        } catch (RuntimeException ex) {
        }
        try {
            DecoderTestUtils.stringToByteArray("1fd3");
            fail();
        } catch (RuntimeException ex) {
        }
        try {
            DecoderTestUtils.stringToByteArray("0G");
            fail();
        } catch (RuntimeException ex) {
        }
        try {
            DecoderTestUtils.stringToByteArray("!@#$%^");
            fail();
        } catch (RuntimeException ex) {
        }
    }
}
