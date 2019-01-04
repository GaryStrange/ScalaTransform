package TestEnvironment

object EnvironmentPaths{
  def testFilePath(fileName: String): String = System.getProperty("user.dir") + "/src/test/" + fileName
}
