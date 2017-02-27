package sml;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/**
 * factory class with switch function
 */
public class InstructionFactory {

    private static final String ADD = "add";
    private static final String LIN = "lin";
    private static final String BNZ = "bnz";
    private static final String MUL = "mul";
    private static final String SUB = "sub";
    private static final String OUT = "out";

    private List<String> opcode = Arrays.asList(ADD, LIN, MUL, SUB, OUT, BNZ);

    public List<String> getOpcode() {
        return opcode;
    }

    public Instruction instructionSwitch(String[] fields) {
        switch (fields[1]){
            case ADD :
                return add(fields[0], ADD, fields[2], fields[3], fields[4]);
            case LIN :
                return lin(fields[0], LIN, fields[2], fields[3]);
            case MUL :
                return mul(fields[0], MUL, fields[2], fields[3], fields[4]);
            case SUB :
                return sub(fields[0], SUB, fields[2], fields[3], fields[4]);
            case OUT :
                return out(fields[0], OUT, fields[2]);
            case BNZ :
                return bnz(fields[0], BNZ, fields[2], fields[3]);
            default :
                return null;
        }
    }

    private Instruction add(String label, String opcode, String result, String operation1, String operation2){

        Class<AddInstruction> reflectClass = AddInstruction.class;

        Object constructor = null;

        try {
            constructor =
                    reflectClass.getConstructor(String.class, String.class, int.class, int.class, int.class)
                            .newInstance(label,opcode, Integer.parseInt(result), Integer.parseInt(operation1),
                                    Integer.parseInt(operation2));

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return (Instruction) constructor;
    }

    private Instruction lin(String label, String opcode, String register, String value){

        Class<LinInstruction> reflectClass = LinInstruction.class;

        Object constructor = null;

        try {
            constructor =
                    reflectClass.getConstructor(String.class, String.class, int.class, int.class)
                            .newInstance(label,opcode, Integer.parseInt(register), Integer.parseInt(value));

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return (Instruction) constructor;
    }


    private Instruction mul(String label, String opcode, String result, String op1, String op2){

        Class<MulInstruction> reflectClass = MulInstruction.class;

        Object constructor = null;

        try {
            constructor =
                    reflectClass.getConstructor(String.class, String.class, int.class, int.class, int.class)
                            .newInstance(label,opcode, Integer.parseInt(result), Integer.parseInt(op1),
                            Integer.parseInt(op2));

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return (Instruction) constructor;
    }


    private Instruction sub(String label, String opcode, String result, String op1, String op2){

        Class<SubInstruction> reflectClass = SubInstruction.class;

        Object constructor = null;

        try {
            constructor =
                    reflectClass.getConstructor(String.class, String.class, int.class, int.class, int.class)
                            .newInstance(label,opcode, Integer.parseInt(result), Integer.parseInt(op1),
                                    Integer.parseInt(op2));

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return (Instruction) constructor;
    }

    private Instruction out(String label, String opcode, String register){

        Class<OutInstruction> reflectClass = OutInstruction.class;

        Object constructor = null;

        try {
            constructor =
                    reflectClass.getConstructor(String.class, String.class, int.class)
                            .newInstance(label,opcode, Integer.parseInt(register));

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return (Instruction) constructor;
    }

    private Instruction bnz(String label, String opcode,  String register, String jump){

        Class<BnzInstruction> reflectClass = BnzInstruction.class;

        Object constructor = null;

        try {
            constructor =
                    reflectClass.getConstructor(String.class, String.class, int.class, String.class)
                            .newInstance(label,opcode, Integer.parseInt(register), jump);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return (Instruction) constructor;
    }
}
