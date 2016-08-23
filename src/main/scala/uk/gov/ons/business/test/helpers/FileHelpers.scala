package uk.gov.ons.business.test.helpers

import java.nio.file.Files

trait FileHelpers {

  def createTemporaryOutputPath(fileName: String): String = {
    s"${Files.createTempDirectory(getClass.getSimpleName)}/$fileName"
  }

}
