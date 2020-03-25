package com.example.FOC

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.frostwire.jlibtorrent.TorrentInfo
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main_foc.*
import java.io.File
import java.io.IOException
import java.io.RandomAccessFile
import java.nio.channels.FileChannel


class MainActivityFOC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_foc)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            MainFunctionsInJava.getTorrent();
        }

        MainFunctionsInJava.requestPermission(this);

    }

    //a
    //blablablablaballalalalla



}
