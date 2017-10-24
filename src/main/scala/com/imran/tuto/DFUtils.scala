package com.imran.tuto

import org.apache.log4j.Logger

object DFUtils  extends Serializable {
  @transient lazy val logger = Logger.getLogger(getClass.getName)

  def pointlessUDF(raw: String) = {
    raw
  }

}