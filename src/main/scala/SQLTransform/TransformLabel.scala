package SQLTransform

object TransformLabel extends Enumeration {
  type TransformLabel = Value
  val Explode, Project, Transform, Branch = Value
}
