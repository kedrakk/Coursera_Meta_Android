package com.app.p01videoplayer

import android.net.Uri
import android.net.Uri.parse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoView=findViewById<VideoView>(R.id.video_view)
        val mediaController=MediaController(this)
        mediaController.setAnchorView(videoView)

        var uri:Uri=parse("android.resource://$packageName/raw/hp")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}