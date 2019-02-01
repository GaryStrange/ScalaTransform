package Logging

trait Logger {
  //def defaultTelemetryProperties: TelemetryProperties
  //def info(message: String, telemetry: TelemetryProperties = defaultTelemetryProperties): Unit
  //def warn(message: String, telemetry: TelemetryProperties = defaultTelemetryProperties): Unit
  //def error(message: String, exception: Exception, telemetry: TelemetryProperties = defaultTelemetryProperties): Unit
  def log(message: String)
  //def time[R](dependencyName: String, commandName: String, block: () => R): R
  //def flush(): Unit
}