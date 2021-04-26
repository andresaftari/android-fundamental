package com.andresaftari.mod10.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andresaftari.mod10.data.HasilBmi
import com.andresaftari.mod10.data.KategoriBmi

class HitungViewModel : ViewModel() {
    private val hasilBmi = MutableLiveData<HasilBmi>()

    fun hitungBmi(berat: String, tinggi: String, isMale: Boolean) {
        val tinggiCm = tinggi.toFloat() / 100
        val bmi = berat.toFloat() / (tinggiCm * tinggiCm)

        val kategori = if (isMale) when {
            bmi < 20.5 -> KategoriBmi.KURUS
            bmi >= 27.0 -> KategoriBmi.GEMUK
            else -> KategoriBmi.IDEAL
        }
        else when {
            bmi < 18.5 -> KategoriBmi.KURUS
            bmi >= 25.0 -> KategoriBmi.GEMUK
            else -> KategoriBmi.IDEAL
        }

        hasilBmi.value = HasilBmi(bmi, kategori)

    }

    fun getHasilBmi(): LiveData<HasilBmi?> = hasilBmi
}