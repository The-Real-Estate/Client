package com.bishal.therealestate.Fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bishal.therealestate.LoginActivity
import com.bishal.therealestate.R
import com.bishal.therealestate.UpdateProfile

class SettingsFragments : Fragment() {
    //for textview
    private lateinit var tvFullname: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvUsername: TextView
    private lateinit var tvPassword: TextView
    private lateinit var btnLogout: Button
    private lateinit var btnEdit: Button

    //sensors
    private lateinit var sensorManager: SensorManager
    private var sensor: Sensor? = null
    private lateinit var sharedPreferences: SharedPreferences;
    private lateinit var editor : SharedPreferences.Editor;

    companion object {
        fun newInstance() = SettingsFragments()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_settings_fragments, container, false)
        sensorManager = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        if (checkSensor()) {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
//            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
        tvFullname=view.findViewById(R.id.tvFullname)
        tvAddress=view.findViewById(R.id.tvAddress)
        tvPhone=view.findViewById(R.id.tvPhone)
        tvUsername=view.findViewById(R.id.tvUsername)
        tvPassword=view.findViewById(R.id.tvPassword)
        btnLogout=view.findViewById(R.id.btnLogout)
        btnEdit=view.findViewById(R.id.btnEdit)

        btnEdit.setOnClickListener{
            val intent = (Intent(context, UpdateProfile::class.java))
            intent.putExtra("Fullname", tvFullname.text)
            intent.putExtra("Address", tvAddress.text)
            intent.putExtra("phoneNo", tvPhone.text)
            intent.putExtra("Username", tvUsername.text)
            intent.putExtra("Password", tvPassword.text)
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
//            editor.clear();
//            editor.commit();
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish()
        }



        return view
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
//        viewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
    }
    //sensor3
    private fun checkSensor(): Boolean {
        var flag = true
        if (sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) == null) {
            flag = false
        }
        return flag
    }
//    override fun onSensorChanged(event: SensorEvent?) {
//        val values = event!!.values[0]
//        if (values <= 4)
//            btnEdit.setText("ObjectNear")
//        else
//            btnEdit.setText("ObjectFar")
//
//    }
//    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
//    }

}