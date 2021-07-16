package View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucas.leagueoflegendsconsult.R

class Pesquisar : Fragment() {

    companion object {
        fun newInstance(): Pesquisar{
            val fragmentPesquisar = Pesquisar()
            val argumentos = Bundle()
                fragmentPesquisar.arguments = argumentos
            return fragmentPesquisar
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pesquisar, container, false)
    }
}