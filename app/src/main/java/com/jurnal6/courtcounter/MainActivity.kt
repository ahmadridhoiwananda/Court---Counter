package com.jurnal6.courtcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jurnal6.courtcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val B: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        B.btnThreea.setOnClickListener {
            viewModel.addScore(3,"a")
        }
        B.btnTwoa.setOnClickListener {
            viewModel.addScore(2,"a")
        }
        B.btnFreea.setOnClickListener {
            viewModel.addScore(1,"a")
        }

        B.btnThreeb.setOnClickListener {
            viewModel.addScore(3,"b")
        }
        B.btnTwob.setOnClickListener {
            viewModel.addScore(2,"b")
        }
        B.btnFreeb.setOnClickListener {
            viewModel.addScore(1,"b")
        }
        B.btnReset.setOnClickListener {
            viewModel.resetScore()
        }

        viewModel.scorea.observe(this, Observer { newScorea ->
            B.tvScorea.text = newScorea.toString()
        })
        viewModel.scoreb.observe(this, Observer { newScoreb ->
            B.tvScoreb.text = newScoreb.toString()
        })

    }
}
