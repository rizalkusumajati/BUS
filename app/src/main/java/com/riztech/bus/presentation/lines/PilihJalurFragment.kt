package com.riztech.bus.presentation.lines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.riztech.bus.R
import kotlinx.android.synthetic.main.fragment_pilih_jalur.*


/**
 * A simple [Fragment] subclass.
 * Use the [PilihJalurFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PilihJalurFragment : Fragment(),
    JalurAdapter.OnClickItem {
    lateinit var adapter: JalurAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pilih_jalur, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvJalur.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = JalurAdapter(
                arrayListOf(),
                this@PilihJalurFragment
            )
        }
    }

    override fun clickJalur(string: String) {
        TODO("Not yet implemented")
    }


}