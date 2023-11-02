package com.smartwalkie.voicepingdemo

import android.app.Application
import android.content.Context
import android.media.AudioFormat
import android.media.MediaRecorder
import android.media.MediaRecorder.AudioSource
import android.os.Build
import android.util.Log

import com.smartwalkie.voicepingsdk.VoicePing
import com.smartwalkie.voicepingsdk.model.AudioParam

class VoicePingClientApp : Application() {
    private val TAG = "VoicePingClientApp"

    override fun onCreate() {
        super.onCreate()
        context = this
        val audioSource = AudioSourceConfig.getSource()
        val audioParam = AudioParam.Builder()
//            .setAudioSource(audioSource)
            .setAudioSource(AudioSource.MIC)
            .setUsingOpusCodec(true)
            .build()
        val audioSourceText = AudioSourceConfig.getAudioSourceText(audioParam.audioSource)
        Log.d(TAG, "Manufacturer: ${Build.MANUFACTURER}, audio source: $audioSourceText")
        VoicePing.init(this, audioParam)

    }

    companion object {
        lateinit var context: Context
    }
}