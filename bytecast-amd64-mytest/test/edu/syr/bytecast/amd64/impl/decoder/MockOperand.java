/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.syr.bytecast.amd64.impl.decoder;

import edu.syr.bytecast.amd64.api.constants.OperandType;
import edu.syr.bytecast.amd64.api.constants.RegisterType;
import edu.syr.bytecast.amd64.api.instruction.IOperand;

/**
 *
 * @author sheng
 */
public class MockOperand implements IOperand {

    public static IOperand asRegister(RegisterType registerType) {
        return new MockOperand(OperandType.REGISTER, registerType);
    }

    public static IOperand asImm(int value) {
        return new MockOperand(OperandType.NUMBER, value);
    }
    private OperandType operandType;
    private Object operandValue;

    public MockOperand(OperandType operandType, Object operandValue) {
        this.operandType = operandType;
        this.operandValue = operandValue;
    }

    @Override
    public OperandType getOperandType() {
        return operandType;
    }

    @Override
    public Object getOperandValue() {
        return operandValue;
    }
}
