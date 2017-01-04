package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(22), 23))
  val set1: Set = union(singletonSet(110),union(singletonSet(22),singletonSet(19)))
  val set2: Set = union(singletonSet(111),union(singletonSet(22),singletonSet(-20)))
  printSet(filter(set1,_ > 100))
  printSet(map(set1,x=> 2*x))
}
