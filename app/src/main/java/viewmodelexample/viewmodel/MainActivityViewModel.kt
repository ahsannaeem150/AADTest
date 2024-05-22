package viewmodelexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import viewmodelexample.model.CounterModel

class MainActivityViewModel(application: Application): AndroidViewModel(application) {
    val counterMLD: MutableLiveData<CounterModel> = MutableLiveData(CounterModel())
    val counterLD: LiveData<CounterModel> = counterMLD

    fun counterFunction(){
        counterMLD.postValue(CounterModel(counter = (counterLD.value?.counter?: 0)+1))
    }
}                                 