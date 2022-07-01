package com.alirizakaygusuz.yourweightotherplanets

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alirizakaygusuz.yourweightotherplanets.databinding.ActivityMainBinding
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    val JUPITER = 2.34
    val MARS = 0.38
    val MERCURY = 0.38
    val SATURN = 1.06
    val VENUS = 0.91

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var tmpImageView: Int? = null
        var tmpRadioButtonID: Int? = null

        binding.radioGroupPlanets.setOnCheckedChangeListener { radioGroup, radioID ->
            if (R.id.radioBtnJupiter == radioID) {
                tmpImageView = R.drawable.customize_jupiter
            } else if (R.id.radioBtnMars == radioID) {
                tmpImageView = R.drawable.customize_mars
            } else if (R.id.radioBtnMercury == radioID) {
                tmpImageView = R.drawable.customize_mercury
            } else if (R.id.radioBtnSaturn == radioID) {
                tmpImageView = R.drawable.customize_saturn
            } else if (R.id.radioBtnVenus == radioID) {
                tmpImageView = R.drawable.customize_venus
            }

            tmpRadioButtonID = radioID
        }




        binding.btnCalculate.setOnClickListener {

            val user_weight = binding.eTxtYourWeight.text.toString()
            if (user_weight.isNotEmpty()) {
                binding.txtEarthWeight.text = "Your Weight in the World:${user_weight}"
                var tmp_weight: String = ""

                if (tmpImageView != null && tmpRadioButtonID != null) {
                    when (tmpRadioButtonID!!) {
                        R.id.radioBtnJupiter -> {
                            tmp_weight = (user_weight.toDouble() * JUPITER).formatVariable()

                        }
                        R.id.radioBtnMars -> {
                            tmp_weight = (user_weight.toDouble() * MARS).formatVariable()
                        }
                        R.id.radioBtnMercury -> {
                            tmp_weight = (user_weight.toDouble() * MERCURY).formatVariable()
                        }
                        R.id.radioBtnSaturn -> {
                            tmp_weight = (user_weight.toDouble() * SATURN).formatVariable()
                        }
                        R.id.radioBtnVenus -> {
                            tmp_weight = (user_weight.toDouble() * VENUS).formatVariable()
                        }
                    }
                    binding.txtSelectedWeight.text = tmp_weight
                    Glide.with(this).load(tmpImageView).into(binding.imvSelectedPlanet)


                }
            }

        }


    }

    @SuppressLint("DefaultLocale")
    fun Double.formatVariable() = java.lang.String.format("%.2f", this)


}