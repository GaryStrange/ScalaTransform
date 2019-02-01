package Logging

object PrintLnLogger extends Logger {
  override def log(message: String): Unit = {
    println(message)
  }
}
