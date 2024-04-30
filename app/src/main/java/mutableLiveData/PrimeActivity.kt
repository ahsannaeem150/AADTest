package mutableLiveData

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apdlab1.databinding.ActivityCounterBinding
import com.example.apdlab1.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PrimeActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityCounterBinding

    private val counterMLD: MutableLiveData<Int> = MutableLiveData(0)
    private val slowCountingMLD  : MutableLiveData<Int> = MutableLiveData(0)
    private val rapidCountingMLD : MutableLiveData<Int> = MutableLiveData(0)
    val counterLD: LiveData<Int> = counterMLD
    val slowCounterLD : LiveData<Int> = slowCountingMLD
    val rapidCounterLD : LiveData<Int> = rapidCountingMLD
    private var startStopFlag = false
    private lateinit var counterThread: Job
    private lateinit var slowCountingThread : Job
    private lateinit var rapidCountingThread : Job
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_counter)
        dataBinding.lifecycleOwner = this@PrimeActivity
        dataBinding.startStopState = startStopFlag
        this@PrimeActivity.counterLD.observe(this) { updatedCounterValue ->
            Log.e("CounterActivity", "onCreate: counterMLD -> $updatedCounterValue")
            dataBinding.count = updatedCounterValue
        }
        this.slowCounterLD.observe(this , {
            dataBinding.slowCount = it
        })
        this.rapidCounterLD.observe(this , {
            dataBinding.rapidCount = it
        })

        dataBinding.startStopBtn.setOnClickListener {
            if (startStopFlag) {
                counterThread.cancel()
                slowCountingThread.cancel()
                rapidCountingThread.cancel()
            } else {
                counterThread = GlobalScope.launch(Dispatchers.IO) {
                    var data:Int = 3
                    var isPrime:Boolean = true
                    while (true) {
                        for(i in 2 .. data-1){
                            if(data % i == 0){
                                isPrime = false
                                break
                            } else {
                                isPrime = true
                            }
                        }
                        if(isPrime){
                            counterMLD.postValue(data)
                            delay(1000)
                        }
                        isPrime = false
                        data++
                    }
//                    while (true) {
//                        counterMLD.postValue((counterMLD.value ?: 0) + 1)
//                        delay(1000)
//                    }
                }
                slowCountingThread = GlobalScope.launch (Dispatchers.Main){
                    while(true){
                        slowCountingMLD.postValue((slowCountingMLD.value ?: 0) + 1)
                        delay(5000)
                    }
                }
                rapidCountingThread = GlobalScope.launch (Dispatchers.Default){
                    while (true){
                        rapidCountingMLD.postValue((rapidCountingMLD.value ?: 0) + 1)
                        delay(10)

                    }
                }
            }
            startStopFlag = !startStopFlag
            dataBinding.startStopState = startStopFlag
        }
    }
}