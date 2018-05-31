package com.smm.actors

import akka.actor.{ Actor, ActorLogging, Props }
import com.smm.model.SMMModel._


object SMMWorker {
  def props(workerId: String): Props = Props(new SMMWorker(workerId))
}


class SMMWorker(workerId: String) extends Actor with ActorLogging {
  import SMMWorker._

  override def preStart(): Unit = log.info("SMM Worker {} started", workerId)
  override def postStop(): Unit = log.info("SMM Worker {} stopped", workerId)

  override def receive = {
    case _ =>
      println("Worker was spawned")
  }
}
