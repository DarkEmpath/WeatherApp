package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.MainViewModel
import com.example.weather.R
import com.example.weather.adapters.WeatherAdapter
import com.example.weather.databinding.FragmentDaysBinding


class DaysFragment : Fragment() {

    lateinit var adapter: WeatherAdapter
    lateinit var binding : FragmentDaysBinding
    private val model : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        model.liveDataList.observe(viewLifecycleOwner){
            adapter.submitList(it.subList(1, it.size))
        }
    }

    private fun init() = with (binding){
        adapter = WeatherAdapter()
        rcViewDays.layoutManager = LinearLayoutManager(activity)
        rcViewDays.adapter = adapter
    }



    companion object {

        @JvmStatic
        fun newInstance() = DaysFragment()
    }
}