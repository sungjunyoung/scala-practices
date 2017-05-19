/**
  * Created by junyoung on 2017. 5. 19..
  */

trait Shape {
  def area(): Int
}

// Shape 를 상속받는 정사각형 클래스
class Square(length: Int) extends Shape {
  def area = length * length
}

// Shape 를 상속받는 직사각형 클래스
class Rectangle(length: Int, width: Int) extends Shape {
  def area = length * width
}


object HelloScala extends App {
  // trait (Java interface 와 같으나 메소드 구현가능, 다수의 트레이트 상속가능
  val square = new Square(10)
  println("AREA : " + square.area)

  // 튜플 (첫번쨰 튜플 리턴)
  val tuple = ("10", true)
  println("First Tuple : " + tuple._1)
  println("Second Tuple : " + tuple._2)


  // 옵션 타입 (어떤 유형의 데이터를 가질 수 있으며 None 은 데이터가 없음을 나타냄
  def colorCode(color: String): Option[Int] = {
    color match {
      case "red" => Some(1)
      case "blue" => Some(2)
      case "green" => Some(3)
      case _ => None
    }
  }

  // 옵션 타입
  var code = colorCode("orange")
  code match {
    case Some(c) => println("code for orange is : " + c)
    case None => println("code not defined for orange")
  }

  //배열
  val arr = Array(10, 20, 30, 40)
  arr(0) = 50
  val first = arr(0)
  println("Array index 0 : " + first)

  //리스트 만들기
  val xs = List(10, 20, 30, 40)
  val ys = (1 to 100).toList
  val zs = arr.toList

  //벡터
  val v1 = Vector(0, 10, 20, 30, 40)
  val v2 = v1 :+ 50
  val v3 = v2 :+ 60
  val v4 = v3(4)
  val v5 = v3(5)
  println(v1)
  println(v2)
  println(v3)
  println(v4)
  println(v5)

  //세트 - 중복이 없는 엘리먼트의 비정렬 컬렉션 엘리면트의 중복이 없으며, 인덱스가 없어서 인덱스로 접근 불가
  val fruit = Set("apple", "orange", "pear", "banana")
  println("Is Set Contain apple?? : " + fruit.contains("apple"))

  // 맵
  val capitals = Map("USA" -> "Washington D.C", "UK" -> "London")
  val USACapital = capitals("USA")
  println("What is capital of USA? : " + USACapital)

  // 컬랙션 클래스의 고차원 메소드
  // 맵
  val xm = List(1, 2, 3, 4, 5)
  val ym = xm.map(x => x * 10)
  val zm = ym.map(_ * 10)
  println(ym)
  println(zm)

  //플랫맵
  val line = "Scala is fun"
  val SingleSpace = " "
  val words = line.split(SingleSpace)
  val arrayOfChars = words flatMap {_.toList}
  arrayOfChars.foreach(println)

  //필터
  val xf = (1 to 100).toList
  val even = xf.filter(_ % 2 == 0)
  //  even.foreach(println)

  //리듀스
  val xr = List(2,4,6,8,10)
  val sum = xr.reduce((x,y) => x+ y)
  val product = xr.reduce((x,y) => x*y)
  val max = xr.reduce((x,y) => if(x>y) x else y)
  val min = xr.reduce((x,y) => if(x<y) x else y)

  val testReduce = "Scala is fun, I am Junyoung Sung".split(" ")
  val longestWord = testReduce.reduce((x,y) => if(x.length > y.length) x else y)
  println(longestWord)
}
