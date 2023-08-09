package com.example.woof.ui.theme.kittys

import com.example.woof.R
import com.example.woof.ui.theme.kat.Kitty


class CatResource{
        fun getAll() : List<Kitty>{
            return listOf(
                Kitty(R.string.s2,R.string.t2,R.drawable.cat2),
                Kitty(R.string.s1,R.string.t1,R.drawable.cat1),
                Kitty(R.string.s3,R.string.t3,R.drawable.cat3),
                Kitty(R.string.s4,R.string.t4,R.drawable.cat4),
                Kitty(R.string.s5,R.string.t5,R.drawable.cat5),
                Kitty(R.string.s6,R.string.t6,R.drawable.cat6),
                Kitty(R.string.s7,R.string.t7,R.drawable.cat7),
                Kitty(R.string.s8,R.string.t8,R.drawable.cat8),
                Kitty(R.string.s9,R.string.t9,R.drawable.cat9),
                Kitty(R.string.s10,R.string.t10,R.drawable.cat10),

            )
        }
    }
