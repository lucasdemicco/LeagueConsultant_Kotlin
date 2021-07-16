package View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.lucas.leagueoflegendsconsult.R
import com.lucas.leagueoflegendsconsult.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var Content: FrameLayout? = null

    //Ativação de Leitura dos fragmentos passando através da ação WHEN
    private var mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when(item.itemId){
            R.id.inicio ->{
                val fragment = Home.newInstance()
                addFragment(fragment)
            }

            R.id.pesquisar ->{
                val fragment = Pesquisar.newInstance()
                addFragment(fragment)
            }

            R.id.estatisticas ->{
                val fragment = Estatisticas.newInstance()
                addFragment(fragment)
            }
        }
        false
    }

    //Adicionando Fragmentos para o Menu Bottom

    private fun addFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
            .commit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Content = binding.content
        binding.bottomMenu.setOnNavigationItemSelectedListener (mOnNavigationItemSelectedListener)

        val fragment = Home.newInstance()
        addFragment(fragment)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.deslogar -> {
                FirebaseAuth.getInstance().signOut()
                voltarTelaLogin()
            }
        }

        return super.onOptionsItemSelected(item)
    }



    private fun voltarTelaLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}