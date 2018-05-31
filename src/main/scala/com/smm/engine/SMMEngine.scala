package com.smm.engine

import akka.actor.ActorSystem
import scala.io._
import com.smm.actors.SMMSupervisor
import com.smm.actors.SMMWorker
import com.smm.model.SMMModel._


object SMMApp {
  
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("smm-system")

    try {
      // Create top level supervisor
      val supervisor = system.actorOf(SMMSupervisor.props(), "smm-supervisor")

      supervisor ! Start
      supervisor ! Spawn

      // Exit the system after ENTER is pressed
      StdIn.readLine()
    }
    finally {
      system.terminate()
    }
  }
}
