package com.example.tableforyou.Data

import androidx.activity.ComponentActivity

class InitDB: ComponentActivity() {
    override fun onStart()  {
        super.onStart()
        for (i in 0..RestorantList.list.size - 1) {
            MyData().writeRestorant(RestorantList.list[i], RestorantList.list[i].name)
        }

    }
}