package com.anandmali.lifecyclestate

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anandmali.lifecyclestate.databinding.FragmentBlankBinding
import timber.log.Timber

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
        Timber.i("==> onAttach() ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
        Timber.i("==> onCreate() ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Timber.i("==> onCreateView() ")
        // Inflate the layout for this fragment
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("==> onViewCreated() ")
        binding.txt.text = param1

        val ld = this.viewLifecycleOwnerLiveData

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Timber.i("==> onViewStateRestored() ")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("==> onStart() ")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("==> onResume() ")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("==> onPause() ")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("==> onStop() ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.i("==> onSaveInstanceState() ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.i("==> onDestroyView() ")
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