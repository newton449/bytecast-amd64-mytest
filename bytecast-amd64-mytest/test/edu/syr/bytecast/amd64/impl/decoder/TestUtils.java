/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.syr.bytecast.amd64.impl.decoder;

import edu.syr.bytecast.amd64.api.instruction.IInstruction;
import edu.syr.bytecast.amd64.api.instruction.IOperand;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author sheng
 */
public class TestUtils {

    public static void assertEquals(IOperand expectedOperand, IOperand actualOperand) {
        if (expectedOperand == null || actualOperand == null) {
            fail();
        }
        assertEquals("The operandTypes are not the same.", expectedOperand.getOperandType(), actualOperand.getOperandType());
        if (expectedOperand.getOperandValue() == null) {
            assertNull("The operandValues are not the same.", actualOperand.getOperandValue());
        } else {
            assertTrue("The operandValues are not the same.", expectedOperand.getOperandValue().equals(actualOperand.getOperandValue()));
        }
    }

    public static void assertEquals(IInstruction expectedInstruction, IInstruction actualInstruction) {
        if (expectedInstruction == null || actualInstruction == null) {
            fail();
        }
        assertEquals("The instructionType are not the same", expectedInstruction.getInstructiontype(), actualInstruction.getInstructiontype());
        assertEquals("The opCodes are not the same.", expectedInstruction.getOpCode(), actualInstruction.getOpCode());
        List<IOperand> expectedOperands = expectedInstruction.getOperands();
        List<IOperand> actualOperands = actualInstruction.getOperands();
        if (expectedOperands == null) {
            assertNull("The operands are not the same.", actualOperands);
        } else {
            assertNotNull(actualOperands);
            assertEquals(null, expectedOperands.size(), actualOperands.size());
            for (int i = 0; i < expectedOperands.size(); i++) {
                assertEquals(expectedOperands.get(i), actualOperands.get(i));
            }
        }
    }
}
