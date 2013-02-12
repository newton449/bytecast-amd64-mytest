/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.syr.bytecast.amd64.impl.decoder;

import edu.syr.bytecast.amd64.api.constants.InstructionType;
import edu.syr.bytecast.amd64.api.instruction.IInstruction;
import edu.syr.bytecast.amd64.api.instruction.IOperand;
import java.util.List;

/**
 *
 * @author sheng
 */
public class MockInstruction implements IInstruction {
    

    private List<IOperand> operands;
    private String opCode;
    private InstructionType instructionType;

    public MockInstruction(List<IOperand> operands, String opCode, InstructionType instructionType) {
        this.operands = operands;
        this.opCode = opCode;
        this.instructionType = instructionType;
    }

    @Override
    public List<IOperand> getOperands() {
        return operands;
    }

    @Override
    public String getOpCode() {
        return opCode;
    }

    @Override
    public void addOperand(IOperand op) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setOpCode(String opcode) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public InstructionType getInstructiontype() {
        return instructionType;
    }
}
