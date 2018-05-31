package com.smm.model

object SMMModel {

  case object Start
  case object Spawn


  case class GetData(file: String)

  case class ProcessWords(token1: String, token2: String, token3: String)

}
