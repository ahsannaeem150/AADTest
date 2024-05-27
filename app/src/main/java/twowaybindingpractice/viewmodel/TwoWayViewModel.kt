package twowaybindingpractice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import twowaybindingpractice.model.TwoWayModel

class TwoWayViewModel(application: Application):AndroidViewModel(application){
    var name:String = "Ahsan"
    val nameModelMLD:MutableLiveData<String> = MutableLiveData(name)
    var nameModelLD:LiveData<String> = nameModelMLD
}