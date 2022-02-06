package com.anandmali.lifecyclestate

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anandmali.lifecyclestate.databinding.FragmentBlankBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {

    private val logTag = BlankFragment::class.java.simpleName

    private lateinit var binding: FragmentBlankBinding

    private var param1: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(logTag, "==> onAttach() ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
        Log.i(logTag, "==> onCreate() ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(logTag, "==> onCreateView() ")
        // Inflate the layout for this fragment
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(logTag, "==> onViewCreated() ")
        binding.txt.text = param1
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.i(logTag, "==> onViewStateRestored() ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(logTag, "==> onStart() ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(logTag, "==> onResume() ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(logTag, "==> onPause() ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(logTag, "==> onStop() ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(logTag, "==> onSaveInstanceState() ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(logTag, "==> onDestroyView() ")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param activityName Parameter 1.
         * @return A new instance of fragment BlankFragment.
         */
        @JvmStatic
        fun newInstance(activityName: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, activityName)
                }
            }
    }
}