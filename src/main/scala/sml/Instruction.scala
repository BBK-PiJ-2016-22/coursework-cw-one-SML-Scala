package sml

abstract class Instruction(label: String, opcode: String) {

  override def toString(): String = label + ": " + opcode

  def getLabel: String = label

  def execute(m: Machine): Unit

}