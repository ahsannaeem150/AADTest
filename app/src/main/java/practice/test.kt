package practice


fun main(){
//    val a:MutableList<Person> = arrayListOf(
//        Person(name = "Ahsan", age = 20),
//        Person(name = "Ali", age = 22)
//    )
//      var filteredList =  a.filter { student ->
//          (student.age ?:0 ) > 21
//      }
//        println(filteredList)
//
//    var letPractice  =  a.let { person -> println(person) }
//    println(letPractice)
//    a.forEach { student -> println(student.age) }
//
    
    var num1:Int? = 10
    var num2:Int? = 20

    num1?.let{num1->
        num2?.let{num2->
            println(num1+num2)
        }
    }
}