import kotlin.math.absoluteValue

class MyMath
{
    companion object
    {
        fun factorial(number: Int): Int = (1..number).fold(1) { a, b -> a * b }
    }
}

fun main()
{
    val numbers = arrayListOf(1, 2, 3)
    println(numbers)
    numbers.removeLast()
    println(numbers)
    val months = arrayOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
    class SimpleDate1(var month: String)
    fun monthsUntilWinterBreak(from: SimpleDate1): Int = months.indexOf("December") - months.indexOf(from.month)
    class SimpleDate2(var month: String)
    {
        fun monthsUntilWinterBreak(from: SimpleDate2): Int = months.indexOf("December") - months.indexOf(from.month)
    }
    val date2 = SimpleDate2("October")
    println(date2.monthsUntilWinterBreak(date2))

//    Introducing this
    class SimpleDate3(var month: String)
    {
        fun monthsUntilWinterBreak(): Int = months.indexOf("December") - months.indexOf(this.month)
    }
    val date3 = SimpleDate3("September")
    println(date3.monthsUntilWinterBreak())

//    Companion object method
    println(MyMath.factorial(6))

//    Extension method
    class SimpleDate()
    {
        var month: String = "January"
        fun monthsUntilWinterBreak(): Int = months.indexOf("December") - months.indexOf(month)
    }
    fun SimpleDate.monthsUntilSummerBreak(): Int
    {
        val monthIndex = months.indexOf(month)
        return if (monthIndex in 0..months.indexOf("June"))
        {
            months.indexOf("June") - months.indexOf(month)
        }
        else if (monthIndex in months.indexOf("June")..months.indexOf("August"))
        {
            0
        }
        else
        {
            months.indexOf("June") + (12 - months.indexOf(month))
        }
    }
    val date = SimpleDate()
    date.month = "December"
    println(date.monthsUntilSummerBreak())
    fun Int.abs(): Int
    {
        return if (this < 0) - this else this
    }
    println(4.abs())
    println((-4).abs())
}