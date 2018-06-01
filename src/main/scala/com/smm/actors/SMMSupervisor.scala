package com.smm.actors

import akka.actor.{ Actor, ActorLogging, ActorRef, Props }
import scala.io._
import com.smm.model.SMMModel._


object SMMSupervisor {
  def props(): Props = Props(new SMMSupervisor)
}


class SMMSupervisor extends Actor with ActorLogging {
  private var num = 0
  private val workers = collection.mutable.Buffer[ActorRef]()

  override def preStart(): Unit = log.info("SMM Application started")
  override def postStop(): Unit = log.info("SMM Application stopped")

  override def receive = {
    case Start =>
      // Collect word data
      val words = Source.fromFile("smmdata.txt")
      log.info(words.getLines().size + " element(s) collected")
      //for(line <- words.getLines())
        //println(line)
      words.close()

    case Spawn =>
      for(i <- 1 to 5) {
        workers += context.actorOf(Props(new SMMWorker(("w_" + num))), ("worker_" + num))
        num += 1
      }
  }
}
