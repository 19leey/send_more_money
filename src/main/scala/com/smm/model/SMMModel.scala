package com.smm.model

object SMMModel {

  case object Start
  case object Spawn
  case object Work


  case class GetData(file: String)

  case class Permute(tokens: Array[String])

}
