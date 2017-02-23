package sml

/**
  * Created by Casper on 22/02/2017.
  */

class BnzInstruction(label: String, op: String, val register: Int, val goto: String)
  extends Instruction(label,  op) {

  override def getLabel: String = super.getLabel

  override def execute(m: Machine): Unit = {
    if(m.regs(register) != 0){
      m.pc = m.prog.map(a => a.getLabel).toList.indexOf(goto)
    }
  }

  override def toString(): String = super.toString + " branching to " + goto + "\n"

}

object BnzInstruction{

  def apply(label: String, register: Int, goto: String) =
    new BnzInstruction(label, "bnz", register, goto)

}