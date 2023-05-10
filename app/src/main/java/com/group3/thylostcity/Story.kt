package com.group3.thylostcity

import android.view.View
import android.widget.Button


class Story (val game: GameScreen){

    var nxtPosition = ""
    var nxtPosition2 = ""
    var nxtPosition3 = ""
    var nxtPosition4 = ""
    private var cursedSword = false
    private var magicRope = false
    private var the_relic = false

    fun selectPosition(position: String){

        when(position){
            "startingPoint" -> startingPoint()
            "sign" -> sign()
            "pray" -> pray()
            "quicksand" -> sand()
            "die" -> death()
            "death" -> game.goTitleScreen()
            "sword" -> sword()
            "rope" -> rope()
            "tribe" -> tribe()
            "relic" -> relic()
            "cave" -> cave()
            "trap" -> trap()
            "treasure" -> treasure()
        }

    }

    fun setSword(value: Boolean) {
        this.cursedSword = value
    }

    fun getSword(): Boolean {
        return this.cursedSword
    }

    fun setRope(value: Boolean) {
        this.magicRope = value
    }

    fun getRope(): Boolean {
        return this.magicRope
    }

    fun setRelic(value: Boolean) {
        this.the_relic = value
    }

    fun getRelic(): Boolean {
        return this.the_relic
    }


    private fun renderButton(button: Button, text: String) {
        button.text = text
        button.visibility = View.VISIBLE
    }

    // renders all four buttons
    // each button is set to invisible, but if given text, becomes visible
    private fun renderButtons(text1: String? = "", text2: String? = "", text3: String? = "", text4: String? = "") {
        val btn = arrayOf(game.binding.choiceBtn1, game.binding.choiceBtn2, game.binding.choiceBtn3, game.binding.choiceBtn4)
        val btnTexts = arrayOf(text1, text2, text3,  text4)

        for (i in btn.indices)
        {
            btn[i].visibility = View.INVISIBLE
            if (!btnTexts[i].isNullOrBlank())
            {
                btn[i].text = btnTexts[i]
                btn[i].visibility = View.VISIBLE
            }
        }

    }

/*    private fun assignButtons(func1: String?, func2: String?, func3: String?, func4: String?) {
        val positions = arrayOf(nxtPosition, nxtPosition2, nxtPosition3, nxtPosition4)
        val assignments = arrayOf(func1, func2, func3, func4)

        for (i in positions.indices)
        {
            positions[i] = assignments[i].toString()
        }
    }*/

    fun startingPoint(){
        game.binding.gameImageView.setImageResource(R.drawable.sign)
        game.binding.gameTextView.setText(R.string.beginning)

        renderButtons(
            game.getString(R.string.left),
            game.getString(R.string.right),
            game.getString(R.string.pray),
            game.getString(R.string.read_sign)
        )

        nxtPosition = "tribe"
        nxtPosition2 = "quicksand"
        nxtPosition3 = "pray"
        nxtPosition4 = "sign"
    }

    fun sign(){
        game.binding.gameImageView.setImageResource(R.drawable.sign2)
        game.binding.gameTextView.setText(R.string.sign)

        renderButtons(
            game.getString(R.string.back)
        )

        nxtPosition = "startingPoint"
        nxtPosition2 = ""
        nxtPosition3 = ""
        nxtPosition4 = ""
    }

    fun pray(){
        game.binding.gameImageView.setImageResource(R.drawable.god)
        game.binding.gameTextView.setText(R.string.god_pray)

        renderButtons(
            game.getString(R.string.sword),
            game.getString(R.string.rope)
        )

        nxtPosition = "sword"
        nxtPosition2 = "rope"
        nxtPosition3 = ""
        nxtPosition4 = ""
    }

    fun sword(){
        game.binding.gameImageView.setImageResource(R.drawable.sword)
        game.binding.gameTextView.setText(R.string.swords)

        this.setSword(true)

        renderButtons(
            game.getString(R.string.nice)
        )

        nxtPosition = "startingPoint"
        nxtPosition2 = ""
        nxtPosition3 = ""
        nxtPosition4 = ""
    }

    fun rope(){
        game.binding.gameImageView.setImageResource(R.drawable.rope)
        game.binding.gameTextView.setText(R.string.ropes)

        this.setRope(true)

        renderButtons(
            game.getString(R.string.nice)
        )

        nxtPosition = "startingPoint"
        nxtPosition2 = ""
        nxtPosition3 = ""
        nxtPosition4 = ""
    }

    fun sand() {

        game.binding.gameImageView.setImageResource(R.drawable.sand)
        game.binding.gameTextView.setText(R.string.qsand)

        renderButtons(
            game.getString(R.string.forward),
            game.getString(R.string.back)
        )

        nxtPosition = "die"
        nxtPosition2 = "startingPoint"
        nxtPosition3 = ""
        nxtPosition4 = ""

        if (magicRope)
        {
            renderButton(game.binding.choiceBtn3, game.getString(R.string.use_rope))
            nxtPosition3 = "relic"
        }

    }

    fun relic(){
        game.binding.gameImageView.setImageResource(R.drawable.relic)
        game.binding.gameTextView.setText(R.string.relic)

        this.setRelic(true)

        renderButtons(game.getString(R.string.back))

        nxtPosition = "startingPoint"
        nxtPosition2 = ""
        nxtPosition3 = ""
        nxtPosition4 = ""
    }

    fun tribe(){

        game.binding.gameImageView.setImageResource(R.drawable.tribe)
        game.binding.gameTextView.setText(R.string.danger)

        renderButtons(
            game.getString(R.string.fight),
            game.getString(R.string.back),
            game.getString(R.string.escape)
        )

        nxtPosition = "die"
        nxtPosition2 = "startingPoint"
        nxtPosition3 = "cave"
        nxtPosition4 = ""

        if (cursedSword)
        {
            nxtPosition = "cave"
        }
    }

    fun cave(){
        game.binding.gameImageView.setImageResource(R.drawable.cave_2)
        game.binding.gameTextView.setText(R.string.lock)

        renderButtons(
            game.getString(R.string.force),
            game.getString(R.string.back)
        )

        nxtPosition = "trap"
        nxtPosition2 = "startingPoint"
        nxtPosition3 = ""
        nxtPosition4 = ""

        if (the_relic)
        {
            renderButton(game.binding.choiceBtn3, game.getString(R.string.key))
            nxtPosition3 = "treasure"
        }

    }

    fun treasure(){
        game.binding.gameImageView.setImageResource(R.drawable.treasure)
        game.binding.gameTextView.setText(R.string.treasure)

        renderButtons(
            game.getString(R.string.again)
        )

        nxtPosition = "death"
        nxtPosition2 = ""
        nxtPosition3 = ""
        nxtPosition4 = ""
    }

    fun death(){
        game.binding.gameImageView.setImageResource(R.drawable.trap)
        game.binding.gameTextView.setText(R.string.dead)

        renderButtons(
            game.getString(R.string.over)
        )

        nxtPosition = "death"
        nxtPosition2 = ""
        nxtPosition3 = ""
        nxtPosition4 = ""
    }

    fun trap(){
        game.binding.gameImageView.setImageResource(R.drawable.death)
        game.binding.gameTextView.setText(R.string.trap)

        renderButtons(
            game.getString(R.string.over)
        )

        nxtPosition = "death"
        nxtPosition2 = ""
        nxtPosition3 = ""
        nxtPosition4 = ""
    }


}