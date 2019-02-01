package Data

abstract class StoragePaths(domainCategory: String) {
  private val UNRESTRICTED_ROOT = "/unrestricted"

  private val STAGING_DIRECTORY = "/staging"

  private val SOURCE_DIRECTORY = "/landing"

  private val PATH_SUFFIX = "/pqtsnappy/snapshot/"

  def cleanDomainCategory = {
    if (domainCategory.length > 0 && domainCategory.charAt(0) == '/')
      domainCategory
    else
      "/" + domainCategory
  }

  def landingPath = UNRESTRICTED_ROOT + SOURCE_DIRECTORY + cleanDomainCategory + PATH_SUFFIX

  def stagingPath = UNRESTRICTED_ROOT + STAGING_DIRECTORY + cleanDomainCategory + PATH_SUFFIX
}
