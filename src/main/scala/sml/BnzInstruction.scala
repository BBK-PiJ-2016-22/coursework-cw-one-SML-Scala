package sml

/**
  * Created by Casper on 22/02/2017.
  */
class BnzInstruction(label: String, op: String, val register: Int, val goto: String) extends Instruction(label,  op) {
  override def execute(m: Machine): Unit = ???

  override def toString(): String = super.toString()

}
