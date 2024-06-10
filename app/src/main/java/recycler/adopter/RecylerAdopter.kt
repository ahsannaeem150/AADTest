package recycler.adopter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.example.apdlab1.databinding.RecyclerRowBinding
import recycler.model.Person
import recycler.viewmodel.RecyclerViewModel

//class RecylerAdopter(viewmodel: RecyclerViewModel) : ListAdapter<Person , RecylerAdopter.PersonViewHolder>(personDifferenceCallBack) {
//    class PersonViewHolder(var binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {
//
//    }
//    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PersonViewHolder {
//        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(p0.context), p0, false)
//        return PersonViewHolder(binding = binding)
//    }
//    override fun onBindViewHolder(p0: PersonViewHolder, location: Int) {
//        p0.binding.person = getItem(location)
//    }
//
//    private object personDifferenceCallBack : DiffUtil.ItemCallback<Person>() {
//        override fun areItemsTheSame(p0: Person, p1: Person): Boolean {
//            return p0.email == p1.email;
//        }
//
//        override fun areContentsTheSame(p0: Person, p1: Person): Boolean {
//            return p0.email == p1.email;
//        }
//    }
//}

class RecylerAdopter (viewModel: RecyclerViewModel) : ListAdapter<Person , RecylerAdopter.PersonViewHolder>(personDiffCallback){
    class PersonViewHolder(var binding : RecyclerRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return PersonViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.binding.person = getItem(position)
    }

    object personDiffCallback:DiffUtil.ItemCallback<Person>(){
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            TODO("Not yet implemented")
        }

    }
    
}