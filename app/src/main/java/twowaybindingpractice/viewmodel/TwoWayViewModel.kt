package twowaybindingpractice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import twowaybindingpractice.model.TwoWayModel

class TwoWayViewModel(application: Application):AndroidViewModel(application){
    val nameModelMLD:MutableLiveData<TwoWayModel> = MutableLiveData(TwoWayModel())
    var nameModelLD:LiveData<TwoWayModel> = nameModelMLD
}