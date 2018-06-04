package com.smm.actors

import akka.actor.{ Actor, ActorLogging, ActorRef, Props }
import com.smm.model.SMMModel._
//import com.smm.process.SMMController._


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
      val permut = Permute(query.split(","))

      for(p <- permut) {
        workers += context.actorOf(Props(new SMMWorker(("wrk-" + num), p)), ("wrk" + num))
        num += 1
      }
      num = 1

    case Work =>
      for(i <- 0 to 2)
        workers(i) ! "print"
  }

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

