package sml

/**
  * Created by Casper on 22/02/2017.
  */

class BnzInstruction(label: String, op: String, val register: Int, val jump: String)
  extends Instruction(label,  op) {

  override def getLabel: String = super.getLabel

  override def execute(m: Machine): Unit = {
    if(m.regs(register) != 0){
      m.pc = m.prog.map(a => a.getLabel).toList.indexOf(jump)
    }
  }

  override def toString(): String = super.toString + " branching to " + jump + "\n"

}

object BnzInstruction{

  def apply(label: String, register: Int, jump: String) =
    new BnzInstruction(label, "bnz", register, jump)

}