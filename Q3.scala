import scala.io.StdIn.readLine

object FibonacciSequence {
    def main(args: Array[String]): Unit = {
      val n = readLine("Enter the number of Fibonacci numbers to print: ").toInt
      printFibonacciSequence(n)
    }
  
    def printFibonacciSequence(n: Int): Unit = {
      def fibonacci(num: Int): Int = num match {
        case 0 => 0
        case 1 => 1
        case _ => fibonacci(num - 1) + fibonacci(num - 2)
      }
  
      def printFibs(i: Int): Unit = {
        if (i < n) {
          println(fibonacci(i))
          printFibs(i + 1)
        }
      }
  
      printFibs(0)
    }
  }
  