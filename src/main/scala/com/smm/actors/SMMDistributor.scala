package com.smm.actors

import akka.actor.{ Actor, ActorLogging, ActorRef, Props }
import com.smm.model.SMMModel._


object SMMDistributor {
  def props(distId: String, query: String): Props = Props(new SMMDistributor(distId, query))
}


class SMMDistributor(distId: String, query: String) extends Actor with ActorLogging {
  private var num = 1
  private val workers = collection.mutable.Buffer[ActorRef]()

  override def preStart(): Unit = log.info("SMM Distributor {} started", distId)
  override def postStop(): Unit = log.info("SMM Distributor {} stopped", distId)

  override def receive = {
    case Start =>
      val permut = query.split(",").toList.permutations

      for(p <- permut) {
        workers += context.actorOf(Props(new SMMWorker(("wrk-" + num), p)), ("wrk" + num))
        num += 1
      }

    case Work =>
      for(i <- 0 to 5)
        workers(i) ! "print"
  }
}

