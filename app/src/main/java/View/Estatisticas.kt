package View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucas.leagueoflegendsconsult.R

class Estatisticas : Fragment() {

    companion object {
        fun newInstance(): Estatisticas{
            val fragmentEstatisticas = Estatisticas()
            val argumentos = Bundle()
            fragmentEstatisticas.arguments = argumentos
            return fragmentEstatisticas
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_estatisticas, container, false)
    }
}