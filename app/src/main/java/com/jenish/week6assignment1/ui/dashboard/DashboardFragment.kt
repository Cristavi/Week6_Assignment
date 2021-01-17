package com.jenish.week6assignment1.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jenish.week6assignment1.R
import com.jenish.week6assignment1.SoftwaricaActivity
import com.jenish.week6assignment1.models.Students

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var etName : EditText
    private lateinit var etAge : EditText
    private lateinit var rdoGroup : RadioGroup
    private lateinit var rdoMale : RadioButton
    private lateinit var rdoFemale : RadioButton
    private lateinit var rdOthers : RadioButton
    private lateinit var etAddress: EditText
    private lateinit var etUrl : EditText
    private lateinit var btnSave : Button
    private var gender = ""
    private var lstStudent = arrayListOf<Students>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        etName = root.findViewById(R.id.etName)
        etAge = root.findViewById(R.id.etAge)
        etAddress = root.findViewById(R.id.etAddress)
        rdoGroup = root.findViewById(R.id.rdoGroup)
        rdoMale = root.findViewById(R.id.rdoMale)
        rdoFemale = root.findViewById(R.id.rdoFemale)
        rdOthers = root.findViewById(R.id.rdOther)
        etUrl = root.findViewById(R.id.etUrl)
        btnSave = root.findViewById(R.id.btnSave)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it
            lstStudent = (activity as SoftwaricaActivity).listStudents
            rdoGroup.setOnCheckedChangeListener { radioGroup, i ->
                if (i == R.id.rdoMale) {
                    gender = "Male"
                }
                if (i == R.id.rdoFemale) {
                    gender = "Female"
                }
                if (i == R.id.rdOther) {
                    gender = "Others"
                }
            }
            btnSave.setOnClickListener {

                emptyBoxes()
            }
        })

        return root
    }

    private fun emptyBoxes(){
        etName.setText("")
        etUrl.setText("")
        etAddress.setText("")
        etAge.setText("")
    }
}