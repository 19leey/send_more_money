package com.smm.actors

import akka.actor.{ Actor, ActorLogging, Props }
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
      println(query + " " + workerId)
  }
}
