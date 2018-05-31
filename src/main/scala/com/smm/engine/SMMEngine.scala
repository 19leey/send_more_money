package com.smm.engine

import akka.actor.ActorSystem
import scala.io._
import com.smm.actors.SMMSupervisor


object SMMApp {
  
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("smm-system")

    try {
      // Create top level supervisor
      val supervisor = system.actorOf(SMMSupervisor.props(), "smm-supervisor")
      // Exit the system after ENTER is pressed
      StdIn.readLine()
    }
    finally {
      system.terminate()
    }
  }
}
