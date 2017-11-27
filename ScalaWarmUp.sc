/*
Create a function, named prime, that takes an integer and returns a
Boolean indicating whether the integer parameter is a prime number. A prime number is an
integer greater than 1 that has no positive divisors other than 1 and itself.
 */
def prime ( a: Int) : Boolean ={
  if(a <= 1)
    false
  else if(a == 2)
    true
  else
    Range(2 , a-1).filter(a % _ == 0).length == 0
}
prime(7) // true
/*
 Create a function, named twinprimes, that takes 2 integer parameters
and returns a Boolean indicating whether the parameters are twin primes. A twin prime is a
prime number that differs from another prime number by two, for example the twin prime
pair (41, 43). For example, twinprimes (41, 43) should return true and twinprimes (43, 47)
would return false.
 */
def twinPrimes (a :Int, b : Int): Boolean = {
    if(prime(a) && prime(b) && Math.abs(a-b) == 2)
        true
    else
        false
}
twinPrimes(41,43) //true
twinPrimes(43, 47)//false

/*
Create a function, named twinprimeslist, that takes an integer, n,
parameter and returns an integer list of all the twin primes starting up to n. For example,
twinprimeslist (50) should return [3, 5, 7, 11, 13, 17, 19, 29, 31, 41, 43] (no duplicates).
 */
def twinPrimeList(n : Int):List[Int] ={
    n match{
        case a if a < 2 => Nil
        case _ =>
            if (twinPrimes(n-2, n) || twinPrimes(n+2,n)){
            n :: twinPrimeList(n-1)}

            else twinPrimeList(n-1)
        }
}
twinPrimeList(50).reverse // List[Int] = List(3, 5, 7, 11, 13, 17, 19, 29, 31, 41, 43)

/*
Create a function, named goldbach, that takes an integer
and prints the solution satisfying the Goldbach Conjecture. The Goldbach Conjecture states
that every positive even number greater than 2 is the sum of two prim numbers. For example,
28 = 5 + 23. Your function is to find the two prime numbers that sum up to a given even
integer and print the composition. For example goldbach(28) would print 5 + 23 = 28. You
should provide error checking to make sure the integer parameter is even and greater than 2.
 */
//Find all the prime number up to the given number
def primeNum (n: Int ) : List[Int] = {
    n match {
        case a if a < 2 => Nil
        case _ => if(prime(n)){
            n :: primeNum(n-1)}
        else primeNum(n-1)

    }
}
//Find all the pairs in the array that add up to the given number
def goldBachDemo(n: Int, primeList : List[Int]) ={
    var binMap = new Array[Boolean](1000000)
    for(i <- 0 to primeList.size-1){
        var temp : Int = n - primeList(i)

        if (temp >= 0 && binMap(temp)){
            println(n + " = " + primeList(i) + " + "+ temp)
        }
        binMap(primeList(i)) = true
    }
}
def goldBach(n : Int ) = {
    (n%2 == 1, n <=2) match {
        case (true, false) => print("Number is not even!!!")
        case (false, true) => print("Number must be greater than 2!!!")
        case (false, false) => goldBachDemo(n, primeNum(n))
    }
}
goldBach(2)//Number must be greater than 2!!!res4: Unit = ()
goldBach(3)//Number is not even!!!res5: Unit = ()
goldBach(28)//28 = 11 + 17
            //28 = 5 + 23



