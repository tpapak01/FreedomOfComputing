package nl.tudelft.trustchain.FOC

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nl.tudelft.ipv8.android.IPv8Android
import nl.tudelft.trustchain.FOC.databinding.BlankFragmentBinding
import nl.tudelft.trustchain.common.DemoCommunity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: BlankFragmentBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = BlankFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        //val ipv8 = IPv8Android.getInstance()
        //val demoCommunity = ipv8.getOverlay<DemoCommunity>()!!
        //demoCommunity.giveContext(activity?.applicationContext)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.findPeersButton.setOnClickListener { view ->
            val ipv8 = IPv8Android.getInstance()
            val demoCommunity = ipv8.getOverlay<DemoCommunity>()!!
            val peers = demoCommunity.getPeers()

            Log.i("personal", "n:" + peers.size.toString())
            for (peer in peers) {
                Log.i("personal", peer.mid)
            }

            demoCommunity.broadcastGreeting();
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
