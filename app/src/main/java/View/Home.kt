package View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucas.leagueoflegendsconsult.R

class Home : Fragment() {

    //Criação da nova instância de fragmento para ser lida na Main
    companion object{
        fun newInstance(): Home{
            val fragmentHome = Home()
                val argumentos = Bundle()
                     fragmentHome.arguments = argumentos
            return fragmentHome
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}