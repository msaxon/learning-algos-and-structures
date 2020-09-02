package com.maestro.testUtils

import java.util.concurrent.ConcurrentHashMap

import lombok.Getter
import lombok.extern.slf4j.Slf4j

@Slf4j
@Getter
class UnitTestTimer(className: String) {
  val timerMap: ConcurrentHashMap[String, Long] = new ConcurrentHashMap[String, Long]()

  def startTime(timerName: String): Unit = {
    timerMap.put(className + ": " + timerName, System.currentTimeMillis())
  }

  def stopTime(timerName: String): Unit = {
    val stopTime = System.currentTimeMillis()
    val differenceInMillis = stopTime - timerMap.get(className + ": " + timerName)
    timerMap.remove(className + ": " + timerName)
    System.out.println(className + ": " + timerName + " ran for " + differenceInMillis + " ms")
  }
}
