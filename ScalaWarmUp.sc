def prime ( a: Int) : Boolean ={
  if(a <= 1)
    false
  else if(a == 2)
    true
  else
    Range(2 , a-1).filter(a % _ == 0).length == 0
}
prime(7)

def twinPrimes (a :Int, b : Int): Boolean = {
    if(prime(a) && prime(b) && Math.abs(a-b) == 2)
        true
    else
        false
}
twinPrimes(41,43)

def twinPrimeList(n : Int):List[Int] ={
    n match{
        case a if a < 2 => Nil
        case _ =>
            if (twinPrimes(n-2, n) || twinPrimes(n+2,n)){
            n :: twinPrimeList(n-1)}

            else twinPrimeList(n-1)
        }
}
twinPrimeList(100).reverse


def primeNum (n: Int ) : List[Int] = {
    n match {
        case a if a < 2 => Nil
        case _ => if(prime(n)){
            n :: primeNum(n-1)}

        else primeNum(n-1)

    }
}

primeNum(28).reverse

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
goldBach(2)
goldBach(3)
goldBach(28)


