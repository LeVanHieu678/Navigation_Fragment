package com.vti.rxjavawithretrofit

import android.os.Environment

object Utils {
    const val downloadDirectory = "Androhub Downloads"
    const val mainUrl = "https://androhub.com/demo/"
    const val downloadPdfUrl = "https://androhub.com/demo/demo.pdf"
    const val downloadDocUrl = "https://androhub.com/demo/demo.doc"
    const val downloadZipUrl = "https://androhub.com/demo/demo.zip"
    const val downloadVideoUrl = "https://androhub.com/demo/demo.mp4"
    const val downloadMp3Url = "https://androhub.com/demo/demo.mp3"

    fun isSDCardPresent(): Boolean {
        return Environment.getExternalStorageState() ==
                Environment.MEDIA_MOUNTED
    }
}