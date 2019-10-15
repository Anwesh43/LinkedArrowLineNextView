package com.anwesh.uiprojects.linkedarrowlinenextview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.arrowlinenextview.ArrowLineNextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ArrowLineNextView.create(this)
    }
}
