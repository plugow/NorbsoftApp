package com.plugow.norbsoftapp.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.plugow.norbsoftapp.R
import com.plugow.norbsoftapp.databinding.ActivityMainBinding
import com.plugow.norbsoftapp.ui.adapter.NSAdapter
import com.plugow.norbsoftapp.util.MainEvent
import com.plugow.norbsoftapp.viewModel.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import org.jetbrains.anko.toast


class MainActivity : DaggerAppCompatActivity() {
    @Inject internal lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject internal lateinit var adapter:NSAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
            viewModel = this@MainActivity.viewModel
            list.adapter = adapter
            list.layoutManager = LinearLayoutManager(this@MainActivity)
        }
        viewModel.initValues()
        viewModel.event.observe(this, Observer {
            when (it.getContentIfNotHandled()){
                MainEvent.ERROR -> toast(getString(R.string.wrong))
            }
        })
    }

}
