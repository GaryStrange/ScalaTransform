package SQLTransform

import scala.collection.mutable.ListBuffer

object TransformListToSql {
  def getSqlProjection(transforms: ListBuffer[TransformationStep])={
    val sb = new StringBuilder("SELECT ")
    for( step <- transforms)
      {
        sb.append(",")
        sb.append(processStep(step))
      }
    sb.delete(0,1)
    sb.toString()
  }

  def processStep(step: TransformationStep):String = {
    step.label match {
      case TransformLabel.Transform => step.label.toString()
    }
  }
}
