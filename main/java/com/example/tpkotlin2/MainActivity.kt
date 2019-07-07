package com.example.tpkotlin2

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MotionEvent
//import android.support.v7.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.pnj)
        mediaPlayer?.setOnPreparedListener{
            println("READY TO GO")
        }

        btnSoundBoard.setOnClickListener {
            val intent = Intent(this, SoundBoard::class.java)
            startActivity(intent)
        }

        buttonPlay.setOnClickListener {
            val intent = Intent(this, Game::class.java)
            startActivity(intent)
        }


    }

}
