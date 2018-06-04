package com.smm.process



object SMMController {
  def Permute(tokens: Array[String]): Iterator[List[String]] = {
   /*
    * 0 1 2
    * 1 2 0
    * 2 0 1
   */

    val permutations = Iterator(List(tokens(0), tokens(1), tokens(2)), List(tokens(1), tokens(2), tokens(0)), List(tokens(2), tokens(0), tokens(1)))

    return permutations
  }
}
/*
class SMMController() {

  def GetData(file: String) = {
    val words = Source.fromFile(file).getLines.toList
  }

}
*/
