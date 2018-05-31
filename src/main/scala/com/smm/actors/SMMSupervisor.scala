package com.smm.actors

import akka.actor.{ Actor, ActorLogging, Props }
import scala.io._

object SMMSupervisor {
  def props(): Props = Props(new SMMSupervisor)
}


class SMMSupervisor extends Actor with ActorLogging {
  // Collect word data
  
  val words = Source.fromFile("words.txt").getLines.toList

  if(words.isEmpty)
    log.info("[FAILED]")
  else
    log.info("[SUCCESS] " + words.size + " elements collected")

  // Process word data
  println("working...")
  println((0 until (words.size)).toSeq.combinations(3).size)
  println("done...")

  override def preStart(): Unit = log.info("SMM Application started")
  override def postStop(): Unit = log.info("SMM Application stopped")

  // No need to handle any messages
  override def receive = Actor.emptyBehavior

}
