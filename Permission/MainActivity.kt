package com.example.permission

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.os.*
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import java.io.File


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AudioRecorderScreen()
        }
    }
}

@Composable
fun AudioRecorderScreen() {

    val context = LocalContext.current

    var isRecording by remember { mutableStateOf(false) }
    var recorder by remember { mutableStateOf<MediaRecorder?>(null) }
    var audioFile by remember { mutableStateOf<File?>(null) }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->

        if (granted) {
            val result = startRecording(context)
            recorder = result.first
            audioFile = result.second
            isRecording = true

            Toast.makeText(context, "Recording started 🎤", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Microphone permission denied ❌", Toast.LENGTH_SHORT).show()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Button(onClick = {

                val permission = Manifest.permission.RECORD_AUDIO

                if (ContextCompat.checkSelfPermission(context, permission)
                    == PackageManager.PERMISSION_GRANTED
                ) {
                    val result = startRecording(context)
                    recorder = result.first
                    audioFile = result.second
                    isRecording = true

                    Toast.makeText(context, "Recording started 🎤", Toast.LENGTH_SHORT).show()

                } else {
                    permissionLauncher.launch(permission) // 🔥 SHOWS POPUP
                }
            }) {
                Text(if (!isRecording) "Start Recording 🎤" else "Recording...")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    stopRecording(recorder)
                    recorder = null
                    isRecording = false
                    Toast.makeText(context, "Recording saved 📁", Toast.LENGTH_SHORT).show()
                },
                enabled = isRecording
            ) {
                Text("Stop ⏹")
            }
        }
    }
}

fun startRecording(context: android.content.Context): Pair<MediaRecorder, File> {

    val file = File(context.filesDir, "audio_${System.currentTimeMillis()}.m4a")

    val recorder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        MediaRecorder(context)
    } else {
        MediaRecorder()
    }

    recorder.apply {
        setAudioSource(MediaRecorder.AudioSource.VOICE_RECOGNITION)
        setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        setAudioSamplingRate(44100)
        setAudioEncodingBitRate(128000)
        setOutputFile(file.absolutePath)

        prepare()
        start()
    }

    return Pair(recorder, file)
}

fun stopRecording(recorder: MediaRecorder?) {
    try {
        recorder?.apply {
            stop()
            reset()
            release()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
