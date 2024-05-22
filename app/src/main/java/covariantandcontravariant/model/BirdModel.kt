package covariantandcontravariant.model

data class Crow(
    val name:String = "Crow",
    val size:Int = 2
)
data class BirdCatchModel<out T>(
    var name:String,
    val bird: T,
    var message:String,
    var catchStatus: Boolean
)  {
companion object {
    fun <T> onCatchSucces(n: String, b: T):BirdCatchModel<T>{
        return BirdCatchModel(name = n , bird = b , message = "Catch Succesful" , true)
    }
    fun <T> onCatchFail(n: String, b: T):BirdCatchModel<T>{
        return BirdCatchModel(name = n , bird = b , message = "Catch Failed" , false)
    }
}}