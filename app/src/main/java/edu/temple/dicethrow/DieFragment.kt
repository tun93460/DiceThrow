package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    lateinit var dieTextView: TextView
    var dieNumber: Int = 0

    var dieSides: Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedInstanceState?.run {
            dieNumber = getInt(DIESIDE, 0)
        }
        if (dieNumber == 0) {
            throwDie()
        } else {
            dieTextView.text = dieNumber.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(DIESIDE, dieNumber)
    }

    fun throwDie() {
        dieNumber = (Random.nextInt(dieSides) + 1)
        dieTextView.text = dieNumber.toString()

    }

    companion object {
        private const val DIESIDE = "sidenumber"

        fun newInstance(dieSides: Int) =
            DieFragment().apply {
                arguments = Bundle().apply {
                    putInt(DIESIDE, dieSides)
                }
            }
    }
}