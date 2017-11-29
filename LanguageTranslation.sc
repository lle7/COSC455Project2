//String list to be translate later 
val chinese: List[String] = List("ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu", "shi")
val english: List[String] = List("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")
//test cases
val test1: List[String] = List("yi", "nine", "six", "ba")
val test2: List[String] = List("one", "nine", "six", "eight")
val test3 : List[String] = List("yi", "Josh", "three", "si")

// Method to convert the string list to int list
def translate (alist:List[String]): List[Int]={
  alist.map{
    case "ling" => 0
    case "yi" => 1
    case "er" => 2
    case "san" => 3
    case "si" => 4
    case "wu" => 5
    case "liu" => 6
    case "qi" => 7
    case "ba" => 8
    case "jiu" => 9
    case "shi" => 10
    case "zero" => 0
    case "one" => 1
    case "two" => 2
    case "three" => 3
    case "four" => 4
    case "five" => 5
    case "six" => 6
    case "seven" => 7
    case "eight" => 8
    case "nine" => 9
    case "ten" => 10

  }
}
// Method to add the list of int
def sum (alist : List[Int]):Int = {
  alist.foldLeft(0)(_+_)
}
//Method to mulitply the list of int
def multi (alist : List[Int]):Int={
  alist.foldLeft(1)(_*_)
}
//Method to filter the unknown word
def filter (alist : List[String]): List[String]={
  alist match{
    case Nil => Nil
    case head :: tail => if (chinese.contains(head)|| english.contains(head))
      head :: filter(tail)
      else
      filter(tail)
  }
}
// Method to convert the filtered list to a list of int
def convertToInt (alist : List[String]): List[Int]={
  translate(filter(alist))
}

//Main method to display all three
def go(alist : List[String]): Unit ={
  print("Translation ")
  print(convertToInt(alist).mkString(" "))
  println()

  print("Addition: ")
  print(convertToInt(alist).mkString(" + "))
  print(" = " + sum(convertToInt(alist)))
  println()

  print("Multiplication: ")
  print(convertToInt(alist).mkString(" * "))
  print(" = " + multi(convertToInt(alist)))
  println()

}

go(test1) //Translation 1 9 6 8
          //Addition: 1 + 9 + 6 + 8 = 24
          //Multiplication: 1 * 9 * 6 * 8 = 432
go(test2) //Translation 1 9 6 8
          // Addition: 1 + 9 + 6 + 8 = 24
          //Multiplication: 1 * 9 * 6 * 8 = 432
go(test3) //Translation 1 3 4
          //Addition: 1 + 3 + 4 = 8
          //Multiplication: 1 * 3 * 4 = 12



