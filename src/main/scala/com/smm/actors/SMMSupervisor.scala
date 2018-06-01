package com.smm.actors

import akka.actor.{ Actor, ActorLogging, ActorRef, Props }
import scala.io._
import com.smm.model.SMMModel._


object SMMSupervisor {
  def props(): Props = Props(new SMMSupervisor)
}


class SMMSupervisor extends Actor with ActorLogging {
  private var num = 1
  private val distributors = collection.mutable.Buffer[ActorRef]()
  private var words = Iterator[String]()

  override def preStart(): Unit = log.info("SMM Application started")
  override def postStop(): Unit = log.info("SMM Application stopped")

  override def receive = {
    case Start =>
      // Collect word data
      val wordbuff = Source.fromFile("smmdata_test.txt")
      words = wordbuff.getLines()
      //log.info(words.size + " element(s) collected")
      //wordbuff.close()

    case Spawn =>
      for(line <- words) {
        distributors += context.actorOf(Props(new SMMDistributor(("dist-" + num), line)), ("dist-" + num))
        distributors(num - 1) ! "bang"
        num += 1
      }
  }
}
