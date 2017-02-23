package sml

/**
  * Created by Casper on 23/02/2017.
  */
class OutInstruction(label: String, op: String, val register: Int ) extends Instruction(label, op){

  override def execute(m: Machine): Unit = {
    println(m.regs(register))
  }

  override def toString(): String = super.toString + " printing register " + register + "\n"
}

object OutInstruction {
  def apply(label: String, result: Int) =
    new OutInstruction(label, "add", result)
}
