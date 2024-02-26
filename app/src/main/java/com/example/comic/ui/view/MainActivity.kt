package com.example.comic.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.bumptech.glide.Glide

import com.example.comic.databinding.ActivityMainBinding
import com.example.comic.ui.viewModel.ComicViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val comicViewModel : ComicViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerLiveData()
        comicViewModel.searchByComic()

        binding.Siguiente.setOnClickListener {
            comicViewModel.searchByComic()
        }
    }

    private fun registerLiveData() {
        comicViewModel.comicLiveData.observe(
            this, {
                    myComic->
                binding.Titulo.text = myComic.title
                Glide
                    .with(this)
                    .load(myComic.img)
                    .centerCrop()
                    .into(binding.imageViewComic)
                Toast.makeText(this, "Nuevo comic", Toast.LENGTH_LONG).show()

            }
        )

        comicViewModel.progressBarLiveData.observe(
            this, {
                    visible->
                binding.progressBar.isVisible = visible
            }
        )
    }
}