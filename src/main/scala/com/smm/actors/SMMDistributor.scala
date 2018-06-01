package com.smm.actors

import akka.actor.{ Actor, ActorLogging, Props }
import com.smm.model.SMMModel._


object SMMDistributor {
  def props(distId: String, query: String): Props = Props(new SMMDistributor(distId, query))
}


class SMMDistributor(distId: String, query: String) extends Actor with ActorLogging {


  override def preStart(): Unit = log.info("SMM Distributor {} started", distId)
  override def postStop(): Unit = log.info("SMM Distributor {} stopped", distId)

  override def receive = {
    case _ =>
      //worker = context.actorOf(Props(new SMMWorker(("dist-" + num), line)), ("dist-" + num))
       val tokens = query.split(",")
       for(i <- 0 to 2)
         println(tokens(i) + " " + distId)
  }
}

