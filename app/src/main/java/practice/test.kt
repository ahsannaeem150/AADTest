package practice


fun main(){
    val a:MutableList<Person> = arrayListOf(
        Person(name = "Ahsan", age = 20),
        Person(name = "Ali", age = 22)
    )
      var filteredList =  a.filter { student ->
          (student.age ?:0 ) > 21
      }
        println(filteredList)

    var letPractice  =  a.let { person -> println(person) }
    println(letPractice)
    a.forEach { student -> println(student.age) }
}