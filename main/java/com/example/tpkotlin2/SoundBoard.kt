package com.example.tpkotlin2

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sound_board.*

class SoundBoard : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound_board)

        mediaPlayer = MediaPlayer.create(this, R.raw.death)
        mediaPlayer?.setOnPreparedListener{
            println("READY TO GO")
        }

        btnSound.setOnTouchListener{_, event ->
            handleTouch(event)
            true
        }


    }

    private fun handleTouch(event: MotionEvent) {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                println("down")
                mediaPlayer?.start()
            }
            MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> {
                println("up or cancel")
                mediaPlayer?.pause()
                mediaPlayer?.seekTo(0)
            }
            else -> {
                print("other")
            }
        }
    }
}

