package navigationpractice.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.apdlab1.R
import com.example.apdlab1.databinding.ActivityTwowaybindingpracticeBinding
import com.example.apdlab1.databinding.FirestoreuploadloginBinding
import com.example.apdlab1.databinding.NavigationPracticeHostActivityBinding
import firestore.viewmodel.FirestoreUploadViewmodel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import twowaybindingpractice.viewmodel.TwoWayViewModel

class NavigationHostActivity:AppCompatActivity() {

    lateinit var dataBinding: NavigationPracticeHostActivityBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.navigation_practice_host_activity)
        navController = findNavController(R.id.bottom_nav_fragment_container)

        dataBinding.bottomNavView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.homePage -> {
                    Toast.makeText(this@NavigationHostActivity, "Home is selected", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.homePage)
                }

                R.id.profilePage -> {
                    Toast.makeText(this@NavigationHostActivity, "Profile is selected", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.profilePage)
                }
            }
            true
            }
        }
    }