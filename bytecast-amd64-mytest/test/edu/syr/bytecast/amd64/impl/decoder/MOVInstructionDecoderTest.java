package edu.syr.bytecast.amd64.impl.decoder;

import edu.syr.bytecast.amd64.api.constants.InstructionType;
import edu.syr.bytecast.amd64.api.constants.RegisterType;
import edu.syr.bytecast.amd64.api.instruction.IInstruction;
import static edu.syr.bytecast.amd64.impl.decoder.TestUtils.*;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sheng
 */
public class MOVInstructionDecoderTest {

    /**
     * <code>49 89 d1             	mov    %rdx,%r9</code>
     */
    @Test
    public void testObjectdumpLine32() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0x49, (byte) 0x89, (byte) 0xd1));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asRegister(RegisterType.RDX), MockOperand.asRegister(RegisterType.R9)), "89", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>48 89 e2             	mov    %rsp,%rdx</code>
     */
    @Test
    public void testObjectdumpLine34() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0x48, (byte) 0x89, (byte) 0xe2));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asRegister(RegisterType.RSP), MockOperand.asRegister(RegisterType.RDX)), "89", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>49 c7 c0 00 05 40 00 	mov    $0x400500,%r8</code>
     */
    @Test
    public void testObjectdumpLine38() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0x49, (byte) 0xc7, (byte) 0xc0, (byte) 0x00, (byte) 0x05, (byte) 0x40, (byte) 0x00));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asImm(0x400500), MockOperand.asRegister(RegisterType.R8)), "c7", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>48 c7 c1 10 05 40 00 	mov    $0x400510,%rcx</code>
     */
    @Test
    public void testObjectdumpLine39() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0x48, (byte) 0xc7, (byte) 0xc1, (byte) 0x10, (byte) 0x05, (byte) 0x40, (byte) 0x00));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asImm(0x400510), MockOperand.asRegister(RegisterType.RCX)), "c7", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>48 c7 c7 e4 04 40 00 	mov    $0x4004e4,%rdi</code>
     */
    @Test
    public void testObjectdumpLine40() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0x48, (byte) 0xc7, (byte) 0xc7, (byte) 0xe4, (byte) 0x04, (byte) 0x40, (byte) 0x00));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asImm(0x4004e4), MockOperand.asRegister(RegisterType.RDI)), "c7", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>48 8b 05 31 04 20 00 	mov    0x200431(%rip),%rax</code>
     */
    @Test
    public void testObjectdumpLine48() {
        //TODO how to present "0x0(%rip)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>48 89 e5             	mov    %rsp,%rbp</code>(Also line 101, 116, 180.)
     */
    @Test
    public void testObjectdumpLine70() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0x48, (byte) 0x89, (byte) 0xe5));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asRegister(RegisterType.RSP), MockOperand.asRegister(RegisterType.RBP)), "89", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>bb b8 06 60 00       	mov    $0x6006b8,%ebx</code>
     */
    @Test
    public void testObjectdumpLine75() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0xbb, (byte) 0xb8, (byte) 0x06, (byte) 0x60, (byte) 0x00));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asImm(0x6006b8), MockOperand.asRegister(RegisterType.EBX)), "bb", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>48 8b 05 42 04 20 00 	mov    0x200442(%rip),%rax</code>
     */
    @Test
    public void testObjectdumpLine76() {
        //TODO how to present "0x0(%rip)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>48 89 05 1d 04 20 00 	mov    %rax,0x20041d(%rip)</code>
     */
    @Test
    public void testObjectdumpLine84() {
        //TODO how to present "0x0(%rip)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>48 8b 05 0f 04 20 00 	mov    0x20040f(%rip),%rax</code>
     */
    @Test
    public void testObjectdumpLine86() {
        //TODO how to present "0x0(%rip)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>c6 05 fb 03 20 00 01 	movb   $0x1,0x2003fb(%rip)</code>
     */
    @Test
    public void testObjectdumpLine89() {
        //TODO how to present "0x0(%rip)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>b8 00 00 00 00       	mov    $0x0,%eax</code>(Also line 119.)
     */
    @Test
    public void testObjectdumpLine103() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0xb8, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asImm(0x0), MockOperand.asRegister(RegisterType.EBX)), "b8", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>bf c0 06 60 00       	mov    $0x6006c0,%edi</code>
     */
    @Test
    public void testObjectdumpLine106() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0xbf, (byte) 0xc0, (byte) 0x06, (byte) 0x60, (byte) 0x00));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asImm(0x6006c0), MockOperand.asRegister(RegisterType.EDI)), "bf", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>bf ec 05 40 00       	mov    $0x4005ec,%edi</code>
     */
    @Test
    public void testObjectdumpLine117() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0xbf, (byte) 0xec, (byte) 0x05, (byte) 0x40, (byte) 0x00));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asImm(0x4005ec), MockOperand.asRegister(RegisterType.EDI)), "bf", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>48 89 6c 24 d8       	mov    %rbp,-0x28(%rsp)</code>
     */
    @Test
    public void testObjectdumpLine136() {
        //TODO how to present "-0x28(%rsp)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>4c 89 64 24 e0       	mov    %r12,-0x20(%rsp)</code>
     */
    @Test
    public void testObjectdumpLine137() {
        //TODO how to present "-0x28(%rsp)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>4c 89 6c 24 e8       	mov    %r13,-0x18(%rsp)</code>
     */
    @Test
    public void testObjectdumpLine140() {
        //TODO how to present "-0x28(%rsp)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>4c 89 74 24 f0       	mov    %r14,-0x10(%rsp)</code>
     */
    @Test
    public void testObjectdumpLine141() {
        //TODO how to present "-0x28(%rsp)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>4c 89 7c 24 f8       	mov    %r15,-0x8(%rsp)</code>
     */
    @Test
    public void testObjectdumpLine142() {
        //TODO how to present "-0x28(%rsp)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>48 89 5c 24 d0       	mov    %rbx,-0x30(%rsp)</code>
     */
    @Test
    public void testObjectdumpLine143() {
        //TODO how to present "-0x28(%rsp)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>41 89 fd             	mov    %edi,%r13d</code>
     */
    @Test
    public void testObjectdumpLine146() {
        // TODO what is %r13d?
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0x41, (byte) 0x89, (byte) 0xfd));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asRegister(RegisterType.EDI), MockOperand.asRegister(RegisterType.R13)), "89", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>49 89 f6             	mov    %rsi,%r14</code>
     */
    @Test
    public void testObjectdumpLine147() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0x49, (byte) 0x89, (byte) 0xf6));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asRegister(RegisterType.RSI), MockOperand.asRegister(RegisterType.R14)), "89", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>49 89 d7             	mov    %rdx,%r15</code>
     */
    @Test
    public void testObjectdumpLine149() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0x49, (byte) 0x89, (byte) 0xd7));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asRegister(RegisterType.RDX), MockOperand.asRegister(RegisterType.R15)), "89", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>4c 89 fa             	mov    %r15,%rdx</code>
     */
    @Test
    public void testObjectdumpLine155() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0x4c, (byte) 0x89, (byte) 0xfa));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asRegister(RegisterType.R15), MockOperand.asRegister(RegisterType.RDX)), "89", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>4c 89 f6             	mov    %r14,%rsi</code>
     */
    @Test
    public void testObjectdumpLine156() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0x4c, (byte) 0x89, (byte) 0xf6));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asRegister(RegisterType.R14), MockOperand.asRegister(RegisterType.RSI)), "89", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>44 89 ef             	mov    %r13d,%edi</code>
     */
    @Test
    public void testObjectdumpLine157() {
        // TODO what is %r13d?
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0x44, (byte) 0x89, (byte) 0xef));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asRegister(RegisterType.R13), MockOperand.asRegister(RegisterType.EDI)), "89", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>48 8b 5c 24 08       	mov    0x8(%rsp),%rbx</code>
     */
    @Test
    public void testObjectdumpLine162() {
        //TODO how to present "0x8(%rsp)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>48 8b 6c 24 10       	mov    0x10(%rsp),%rbp</code>
     */
    @Test
    public void testObjectdumpLine163() {
        //TODO how to present "0x8(%rsp)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>4c 8b 64 24 18       	mov    0x18(%rsp),%r12</code>
     */
    @Test
    public void testObjectdumpLine164() {
        //TODO how to present "0x8(%rsp)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>4c 8b 6c 24 20       	mov    0x20(%rsp),%r13</code>
     */
    @Test
    public void testObjectdumpLine165() {
        //TODO how to present "0x8(%rsp)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>4c 8b 74 24 28       	mov    0x28(%rsp),%r14</code>
     */
    @Test
    public void testObjectdumpLine166() {
        //TODO how to present "0x8(%rsp)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>4c 8b 7c 24 30       	mov    0x30(%rsp),%r15</code>
     */
    @Test
    public void testObjectdumpLine167() {
        //TODO how to present "0x8(%rsp)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>48 8b 05 f0 00 20 00 	mov    0x2000f0(%rip),%rax</code>
     */
    @Test
    public void testObjectdumpLine183() {
        //TODO how to present "0x28(%rsp)"?
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * <code>bb a0 06 60 00       	mov    $0x6006a0,%ebx</code>
     */
    @Test
    public void testObjectdumpLine186() {
        MOVInstructionDecoder decoder = new MOVInstructionDecoder();
        IInstruction actual = decoder.decodeInstruction(1L, Arrays.asList((byte) 0xbb, (byte) 0xa0, (byte) 0x06, (byte) 0x60, (byte) 0x00));
        IInstruction expected = new MockInstruction(Arrays.asList(MockOperand.asImm(0x6006a0), MockOperand.asRegister(RegisterType.EBX)), "bb", InstructionType.MOV);
        assertEquals(expected, actual);
    }

    /**
     * <code>48 8b 03             	mov    (%rbx),%rax</code>
     */
    @Test
    public void testObjectdumpLine190() {
        //TODO how to present "(%rbx)"?
        throw new UnsupportedOperationException("TODO");
    }
}
