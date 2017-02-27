package sml

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines

    for (line <- lines) {
      val fields : Array[String] = line.split(" ")
      if (fields.nonEmpty) {
        labels.add(fields(0))
        val factory : InstructionFactory = new InstructionFactory
        val opcode = factory.getOpcode

        if(opcode.contains(fields(1))){
          program = program :+ factory.instructionSwitch(fields)
        }else{
          println("Unknown instruction " + fields(1))
        }

      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}
