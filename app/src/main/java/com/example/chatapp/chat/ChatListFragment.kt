package com.example.chatapp.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.R
import com.example.chatapp.chat.adapter.ChatLayoutItemAdapter
import com.example.chatapp.chat.model.ChatLayout
import kotlinx.android.synthetic.main.fragment_chat_list.view.*


class ChatListFragment : Fragment() {
    private val list = arrayListOf(
        ChatLayout("https://scontent.ftbs4-2.fna.fbcdn.net/v/t39.30808-6/232890809_7278072195643998_3788502222595005329_n.jpg?_nc_cat=104&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=WunPuQj-CjYAX9Qm86x&_nc_ht=scontent.ftbs4-2.fna&oh=00_AT8MAd31GBVG0Fjoc2wO5LDpoL_VqjuE4CwW5ZLZs3fqjg&oe=61EB0B2B",
            "Diana",
            "diana: OK."),
        ChatLayout("https://scontent.ftbs4-2.fna.fbcdn.net/v/t39.30808-6/245625944_199791562233829_1829198486390226525_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=b9115d&_nc_ohc=FAGorSRzi3sAX8aJHwB&_nc_ht=scontent.ftbs4-2.fna&oh=00_AT9Q9bDDxL6tkF6xjAv6fmN0NY13PL33T-mvocqhUvTaOg&oe=61EC17B0",
            "Miqa",
            "miqa: waaammoo ddcccc"),
        ChatLayout("https://scontent.ftbs4-2.fna.fbcdn.net/v/t1.6435-9/170198175_100728042140182_6750965491257972285_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=xQ2O-g-968cAX8f40K-&_nc_ht=scontent.ftbs4-2.fna&oh=00_AT8shjub2pe9jIJagah_ujvwuf0dUHw04uMWhrsu9d5P9w&oe=620E4FA7",
            "Giorgi",
            "you: Hello!"),
        ChatLayout("https://scontent.ftbs4-1.fna.fbcdn.net/v/t1.6435-9/68427205_457422191768396_8829850640520839168_n.jpg?_nc_cat=1&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=31KpjJYUD5sAX9S6Xlm&tn=GP2XeVcachQ1ti79&_nc_ht=scontent.ftbs4-1.fna&oh=00_AT_ciILpC372x27ACRDXNBHP31_RgpVlBtTSMa8TcFh5Mg&oe=620E8F03",
            "Sandro",
            "you: გიცნობ?"),
        ChatLayout("https://scontent.ftbs4-2.fna.fbcdn.net/v/t1.6435-9/69814332_1322354827938652_7473960762600325120_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=174925&_nc_ohc=rx79vVvWGewAX-jSnMP&_nc_ht=scontent.ftbs4-2.fna&oh=00_AT_WwkNAyyRi_vLDScq6NP4JbfDuUxIRiyruI6ttdBFlzg&oe=620E5EF6",
            "Mirian",
            "mirian: გახსენი ლინკი")
    )
    private lateinit var adapter: ChatLayoutItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chat_list, container, false)

        adapter = ChatLayoutItemAdapter(view.context, list)
        view.ChatListRecyclerView.adapter = adapter
        view.ChatListRecyclerView.layoutManager = LinearLayoutManager(context)
        view.ChatListRecyclerView.setHasFixedSize(true)

        return view
    }

}