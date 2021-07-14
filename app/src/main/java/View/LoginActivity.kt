package View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.lucas.leagueoflegendsconsult.R
import com.lucas.leagueoflegendsconsult.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.txtCadastrar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        binding.btnEntrar.setOnClickListener {
            val email = binding.txtEmail.text.toString()
            val senha = binding.txtSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(
                    this,
                    "Preencha os campos solicitados!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                AutenticarUsuario()
            }
        }
    }

    private fun AutenticarUsuario() {
        val email = binding.txtEmail.text.toString()
        val senha = binding.txtSenha.text.toString()

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener {
            if (it.isSuccessful) {

                Toast.makeText(
                    this,
                    "Login efetuado com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()
                irMainActivity()
            }
        }.addOnFailureListener {
            Toast.makeText(
                this,
                "Erro ao fazer login!",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun irMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

