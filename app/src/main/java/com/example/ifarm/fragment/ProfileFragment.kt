package com.example.ifarm.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ifarm.activity.HomeActivity
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.fragment_profile.*
import android.widget.CompoundButton
import android.widget.Toast
import com.example.ifarm.R
import com.example.ifarm.activity.EditProfileActivity


class ProfileFragment : Fragment() {

    private val mParentRef by lazy { activity as HomeActivity }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }



    private fun initialization(){
        setToolBar()
        onViewClickListener()
    }

    private fun setToolBar(){
        mParentRef.tvToolBar.text="Profile"
        mParentRef.ivCartHome.setImageResource(R.drawable.ic_profile_edit_icon)
    }

    private fun onViewClickListener(){
        constraintExchangeproduct.visibility=View.GONE
        border5.visibility=View.GONE
        cbExchangeProducts.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
//                Toast.makeText(activity,"checked",Toast.LENGTH_SHORT).show()
                constraintExchangeproduct.visibility=View.VISIBLE
                border5.visibility=View.VISIBLE
            }
            else{
//                Toast.makeText(activity,"unChecked",Toast.LENGTH_SHORT).show()
                constraintExchangeproduct.visibility=View.GONE
                border5.visibility=View.GONE
            }
        }

        buttonSave.setOnClickListener {
            cbExchangeProducts.isChecked=false
            constraintExchangeproduct.visibility=View.GONE
            border5.visibility=View.GONE
        }

    }


}
