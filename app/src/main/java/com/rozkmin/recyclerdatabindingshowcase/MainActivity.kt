package com.rozkmin.recyclerdatabindingshowcase

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout.VERTICAL
import com.rozkmin.recyclerdatabindingshowcase.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    companion object {
        const val myUserId = "id_123"
    }

    var list = listOf<Item>(
            Item(UUID.randomUUID().toString(), "Frank", "Overtrees", 1, "Team Gnome"),
            Item(UUID.randomUUID().toString(), "Kate", "Whitewalker", 2, "Team Gnome"),
            Item(UUID.randomUUID().toString(), "Edward", "Baker", 3, "Team KDE"),
            Item(myUserId, "Tony", "Ashenberg", 4, "Team xfce"),
            Item(UUID.randomUUID().toString(), "Roman", "Antysoman", 5, "Team xfce"),
            Item(UUID.randomUUID().toString(), "Mike", "The Shroom", 6, "Team Gnome"),
            Item(UUID.randomUUID().toString(), "Dolan", "Dolański", 7, "Team KDE")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setAdapter()
    }

    private fun setAdapter() {
        binding.activityMainRecycler.layoutManager = LinearLayoutManager(this, VERTICAL, false)
        val itemAdapter = ItemAdapter()
        binding.activityMainRecycler.adapter = itemAdapter

        val viewModelList = list.map {
            ItemViewModel(it.position.toString(), "${it.firstName} ${it.lastName}", it.teamName, it.id.contentEquals(myUserId))
        }

        itemAdapter.items = viewModelList
    }
}
