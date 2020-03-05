package com.example.ifarm.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifarm.R
import com.example.ifarm.activity.HomeActivity
import com.example.ifarm.adapter.ChatListAdapter
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.ChatResult
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment : Fragment(),OnItemClickListner {

    private val mParentRef by lazy { activity as HomeActivity }
    private var mChatListAdapter:ChatListAdapter? = null
    private var mChatList=ArrayList<ChatResult>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    override fun onButtonMainClick(activity_name: String) {
    }

    override fun onDataClick(text: String, pos: Int, key_text: String) {
    }

    private fun initialization(){
        setToolBar()
        setAdapter()
    }

    private fun setToolBar(){
        mParentRef.tvToolBar.text="Chat"
        mParentRef.ivCartHome.setImageResource(R.drawable.ic_cart)
    }

    private fun setChatData(){
        val chatResult1=ChatResult(
            "0","Robert Hall","Like a person reading quietly",
            R.drawable.chatuser,"1 min ago")
        val chatResult2=ChatResult(
            "1","Ella","Like a person reading quietly",
            R.drawable.chatuser,"Yesterday")
        val chatResult3=ChatResult(
            "2","Ruth","Like a person reading quietly",
            R.drawable.chatuser,"Yesterday")
        val chatResult4=ChatResult(
            "3","Dora","Like a person reading quietly",
            R.drawable.chatuser,"Yesterday")
        val chatResult5=ChatResult(
            "4","Kayla","Like a person reading quietly",
            R.drawable.chatuser,"10/02/2020")
        val chatResult6=ChatResult(
            "5","Robert Hall","Like a person reading quietly",
            R.drawable.chatuser,"10/02/2020")
        val chatResult7=ChatResult(
            "5","Dora","Like a person reading quietly",
            R.drawable.chatuser,"10/02/2020")
        val chatResult8=ChatResult(
            "5","Kayla","Like a person reading quietly",
            R.drawable.chatuser,"10/02/2020")
        val chatResult9=ChatResult(
            "5","Ella","Like a person reading quietly",
            R.drawable.chatuser,"10/02/2020")
        mChatList.add(chatResult1)
        mChatList.add(chatResult2)
        mChatList.add(chatResult3)
        mChatList.add(chatResult4)
        mChatList.add(chatResult5)
        mChatList.add(chatResult6)
        mChatList.add(chatResult7)
        mChatList.add(chatResult8)
        mChatList.add(chatResult9)
    }

    private fun setAdapter(){
        setChatData()
        val mLayoutManager: LinearLayoutManager by lazy(LazyThreadSafetyMode.PUBLICATION) {
            LinearLayoutManager(activity) }
        rvChat.layoutManager = mLayoutManager
        rvChat.setHasFixedSize(true)
        mChatListAdapter = ChatListAdapter(mChatList,this,1)
        rvChat.adapter = mChatListAdapter
    }
}
