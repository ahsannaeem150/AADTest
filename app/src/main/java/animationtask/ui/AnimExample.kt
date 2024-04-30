package animationtask.ui

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.apdlab1.R
import com.example.apdlab1.databinding.AnimationExampleBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnimExample:AppCompatActivity() {

    lateinit var dataBinding: AnimationExampleBinding
    lateinit var animationThread:Job
    var startStopThread: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.animation_example)
        dataBinding.btn.setOnClickListener {
            if(startStopThread){
                animationThread.cancel()
            } else {
                animationThread = GlobalScope.launch {
                    while(true) {
                        withContext(Dispatchers.Main) {
                            val bounceUP = AnimationUtils.loadAnimation(this@AnimExample, R.anim.bounce)
                            val bounceRight = AnimationUtils.loadAnimation(this@AnimExample, R.anim.bounce_right)
                            val bounceLeft = AnimationUtils.loadAnimation(this@AnimExample, R.anim.bounce_left)
                            val bounceDown = AnimationUtils.loadAnimation(this@AnimExample , R.anim.bounce_down)
                            dataBinding.ball1.startAnimation(bounceUP)
                            dataBinding.ball2.startAnimation(bounceLeft)
                            dataBinding.ball3.startAnimation(bounceDown)
                            dataBinding.ball4.startAnimation(bounceRight
                            )
                        }
                        delay(1000)
                    }
                }

            }
            startStopThread = !startStopThread
            dataBinding.startStopStatus = startStopThread
        }

    }
}
