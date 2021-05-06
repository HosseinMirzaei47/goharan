package com.carpet.goharshad

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.carpet.goharshad.databinding.ActivityMainBinding
import com.carpet.goharshad.ui.utils.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentNavController: LiveData<NavController>? = null

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = viewModel
        }

        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        newBase?.let {
            val newContext = SettingsHelper(it).getModifiedContext()
            super.attachBaseContext(newContext)
        }
    }

    private fun setupBottomNavigationBar() {

        val navGraphIds = listOf(R.navigation.task_graph)

        val controller = binding.bottomNav.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

        currentNavController = controller
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}