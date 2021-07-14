package View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.lucas.leagueoflegendsconsult.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar!!.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            abrirTelaLogin()
        },2000)
    }

    private fun abrirTelaLogin(){

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}