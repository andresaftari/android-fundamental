package com.andresaftari.mod10.data

import com.andresaftari.mod10.db.BmiEntity

object HitungBmi {
    fun hitung(data: BmiEntity): HasilBmi {
        val tinggiCm = data.tinggi / 100
        val bmi = data.berat / (tinggiCm * tinggiCm)

        val kategori = if (data.isMale) when {
            bmi < 20.5 -> KategoriBmi.KURUS
            bmi >= 27.0 -> KategoriBmi.GEMUK
            else -> KategoriBmi.IDEAL
        } else when {
            bmi < 18.5 -> KategoriBmi.KURUS
            bmi >= 25.0 -> KategoriBmi.GEMUK
            else -> KategoriBmi.IDEAL
        }
        return HasilBmi(bmi, kategori)
    }
}