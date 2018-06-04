package com.smm.actors

import akka.actor.{ Actor, ActorLogging, Props }
import scala.math._
import com.smm.model.SMMModel._


object SMMWorker {
  def props(workerId: String, query: List[String]): Props = Props(new SMMWorker(workerId, query))
}


class SMMWorker(workerId: String, query: List[String]) extends Actor with ActorLogging {
  import SMMWorker._


  override def preStart(): Unit = log.info("SMM Worker {} started", workerId)
  override def postStop(): Unit = log.info("SMM Worker {} stopped", workerId)

  override def receive = {
    case _ =>
      if(query(0).length <= query(2).length && query(1).length <= query(2).length) {
        if(query(0).length >= (query(2).length - 1) && query(1).length >= (query(2).length - 1))
        println(query + " " + workerId)
      }
  }
}
