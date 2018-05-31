package com.smm.actors

import akka.actor.{ Actor, ActorLogging, Props }


object SMMWorker {
  def props(): Props = Props(new SMMWorker)
}


class SMMWorker extends Actor with ActorLogging {
  override def preStart(): Unit = log.info("SMM Worker started")
  override def postStop(): Unit = log.info("SMM Worker stopped")

  override def receive = Actor.emptyBehavior
}
