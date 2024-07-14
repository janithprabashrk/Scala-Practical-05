import scala.io.StdIn.readLine

object InventoryManagementSystem {
  def main(args: Array[String]): Unit = {
    val products = getProductList()
    printProductList(products)
    val totalProducts = getTotalProducts(products)
    println("Total products: " + totalProducts)
  }

  def getProductList(): List[String] = {
    def promptForProducts(acc: List[String]): List[String] = {
      val input = readLine("Enter product name (or type 'done' to finish) : ")
      if (input.toLowerCase == "done") acc
      else promptForProducts(acc :+ input)
    }

    promptForProducts(Nil)
  }

  def printProductList(products: List[String]): Unit = {
    for(i <- products.indices) {
      println("Product " + (i + 1) + " : " + products(i))
    }
  }

  def getTotalProducts(products: List[String]): Int = {
    products.length
  }
}
