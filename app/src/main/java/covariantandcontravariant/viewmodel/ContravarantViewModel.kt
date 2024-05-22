package covariantandcontravariant.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ContravarantViewModel(application: Application): AndroidViewModel(application) {
    val catchStatusMLD: MutableLiveData<Boolean> = MutableLiveData(false)
    val catchStatusLD: LiveData<Boolean> = catchStatusMLD
fun catchBird(){
    if((0..100).random() > 50){
        catchStatusMLD.postValue(true)
    } else {
        catchStatusMLD.postValue(false)
    }
}
}