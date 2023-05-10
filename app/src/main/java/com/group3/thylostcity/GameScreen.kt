package com.group3.thylostcity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.group3.thylostcity.databinding.ActivityGameScreenBinding

class GameScreen : AppCompatActivity() {
    lateinit var binding: ActivityGameScreenBinding
    private lateinit var startPoint: String
    private val story = Story(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startPoint = savedInstanceState?.getString("STARTING_POSITION") ?: "startingPoint"

        binding.choiceBtn1.setOnClickListener {
            startPoint = story.nxtPosition
            story.selectPosition(story.nxtPosition)
        }

        binding.choiceBtn2.setOnClickListener {
            startPoint = story.nxtPosition2
            story.selectPosition(story.nxtPosition2)
        }

        binding.choiceBtn3.setOnClickListener {
            startPoint = story.nxtPosition3
            story.selectPosition(story.nxtPosition3)
        }

        binding.choiceBtn4.setOnClickListener {
            startPoint = story.nxtPosition4
            story.selectPosition(story.nxtPosition4)
        }

        story.setSword(savedInstanceState?.getBoolean("SWORD") ?: false)
        story.setRope(savedInstanceState?.getBoolean("ROPE") ?: false)
        story.setRelic(savedInstanceState?.getBoolean("RELIC") ?: false)
        story.selectPosition(startPoint)
    }

    override fun onSaveInstanceState(outState: Bundle){
        outState.putString("STARTING_POSITION",startPoint)
        outState.putBoolean("SWORD", story.getSword())
        outState.putBoolean("ROPE",story.getRope())
        outState.putBoolean("RELIC",story.getRelic())
        super.onSaveInstanceState(outState)
    }

    fun goTitleScreen(){
        val title = Intent(this, MainActivity::class.java)
        startActivity(title)
    }
}