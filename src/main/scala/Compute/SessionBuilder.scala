package Compute

import org.apache.spark.sql.SparkSession

case class SessionConfig(
                          isLocal: Boolean,
                          servicePrincipleClientId: String,
                          servicePrincipleClientSecret: String,
                          tenantId: String
                        )

object SessionBuilder {

  def getSessionFrom(config: SessionConfig) = {
    import SparkBuilderExtension._

    SparkSession.builder
      .configForLocal(config.isLocal)
      .config("dfs.adls.oauth2.access.token.provider.type", "ClientCredential")
      .config("dfs.adls.oauth2.client.id", config.servicePrincipleClientId)
      .config("dfs.adls.oauth2.credential", config.servicePrincipleClientSecret)
      .config("dfs.adls.oauth2.refresh.url", s"https://login.microsoftonline.com/${config.tenantId}/oauth2/token")
      .getOrCreate()
  }
}

object SparkBuilderExtension {
  implicit class EnrichSparkSessionBuilder(builder: SparkSession.Builder) {
    def configForLocal(isLocal: Boolean) = {
      if (isLocal) builder.master("local")
      builder
    }
  }
}

object MyExtensions {
  implicit class EnrichSprakSessiont(session: SparkSession) {
    def addAuthSettings(config: SessionConfig) =
      {
        session.conf.set("dfs.adls.oauth2.access.token.provider.type", "ClientCredential")
        session.conf.set("dfs.adls.oauth2.client.id", config.servicePrincipleClientId)
        session.conf.set("dfs.adls.oauth2.credential", config.servicePrincipleClientSecret)
        session.conf.set("dfs.adls.oauth2.refresh.url", s"https://login.microsoftonline.com/${config.tenantId}/oauth2/token")
      }
  }
}
