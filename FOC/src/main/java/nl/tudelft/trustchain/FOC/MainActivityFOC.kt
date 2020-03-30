package nl.tudelft.trustchain.FOC

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main_foc.*
import nl.tudelft.ipv8.Overlay
import nl.tudelft.ipv8.android.IPv8Android
import nl.tudelft.trustchain.common.DemoCommunity
import java.util.*
import kotlin.math.roundToInt


class MainActivityFOC : AppCompatActivity() {
    //private val binding by viewBinding(BlankFragment::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_foc)
        setSupportActionBar(toolbar)

        //binding = BlankFragment.

        /*
        var b1 = findViewById<Button>(R.id.findPeersButton)
        b1.setOnClickListener { view ->
            val ipv8 = IPv8Android.getInstance()
            val demoCommunity = ipv8.getOverlay<DemoCommunity>()!!
            val peers = demoCommunity.getPeers()

            Log.i("personal", "n:" + peers.size.toString())
            for (peer in peers) {
                Log.i("personal", peer.mid)
            }
        }

         */

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            MainFunctionsJava.getTorrent();
        }

        MainFunctionsJava.requestPermission(this);

        /*
        lifecycleScope.launchWhenStarted {
            while (isActive) {
                val ipv8 = IPv8Android.getInstance()
                val demoCommunity = ipv8.getOverlay<DemoCommunity>()!!
                val peers = demoCommunity.getPeers()

                Log.i("personal", "n:" + peers.size.toString())
                for (peer in peers) {
                    Log.i("personal", peer.mid)
                }
                //printPeersInfo(demoCommunity);
            }
        }

         */
    }

    private fun printPeersInfo(overlay: Overlay) {
        val peers = overlay.getPeers()
        Log.i("personal", overlay::class.simpleName + ": ${peers.size} peers")
        for (peer in peers) {
            val avgPing = peer.getAveragePing()
            val lastRequest = peer.lastRequest
            val lastResponse = peer.lastResponse

            val lastRequestStr = if (lastRequest != null)
                "" + ((Date().time - lastRequest.time) / 1000.0).roundToInt() + " s" else "?"

            val lastResponseStr = if (lastResponse != null)
                "" + ((Date().time - lastResponse.time) / 1000.0).roundToInt() + " s" else "?"

            val avgPingStr = if (!avgPing.isNaN()) "" + (avgPing * 1000).roundToInt() + " ms" else "? ms"
            Log.i("personal","${peer.mid} (S: ${lastRequestStr}, R: ${lastResponseStr}, ${avgPingStr})")
        }
    }

    //a
    //blabla



}
