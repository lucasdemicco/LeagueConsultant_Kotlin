package View

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.lucas.leagueoflegendsconsult.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.btnCadastrar.setOnClickListener {
            val email = binding.txtEmailCadastro.text.toString()
            val senha = binding.txtSenhaCadastro.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(
                    this,
                    "Preencha os campos solicitados",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                cadastrarUsuario()
            }
        }
    }

    private fun cadastrarUsuario() {
        val email = binding.txtEmailCadastro.text.toString()
        val senha = binding.txtSenhaCadastro.text.toString()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(
                        this,
                        "Cadastro realizado com sucesso!",
                        Toast.LENGTH_SHORT
                    ).show()

                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
            }.addOnFailureListener {

            val erro = it

            when {
                erro is FirebaseAuthWeakPasswordException -> Toast.makeText(
                    this,
                    "Digite uma senha com no mínimo 6 caracteres", Toast.LENGTH_SHORT
                ).show()

                erro is FirebaseAuthUserCollisionException -> Toast.makeText(
                    this,
                    "Já existe um usuário com o e-mail informado!", Toast.LENGTH_SHORT
                ).show()

                erro is FirebaseNetworkException -> Toast.makeText(
                    this,
                    "Sem conexão com a internet!", Toast.LENGTH_SHORT
                ).show()

                else -> Toast.makeText(
                    this,
                    "Erro ao cadastrar o usuário!", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}