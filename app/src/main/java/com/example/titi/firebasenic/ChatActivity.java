package com.example.titi.firebasenic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatActivity extends AppCompatActivity {

    ListView listView;
    EditText msg;
    DatabaseReference mRef;
    FirebaseListAdapter<Chat> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        listView = (ListView) findViewById(R.id.lv);
        msg = (EditText) findViewById(R.id.ed_msg);

         mRef = FirebaseDatabase.getInstance().getReference().child("chat");
        mAdapter = new FirebaseListAdapter<Chat>(ChatActivity.this, Chat.class, android.R.layout.two_line_list_item, mRef) {
            @Override
            protected void populateView(View v, Chat model, int position) {
                ((TextView) v.findViewById(android.R.id.text1)).setText(model.getName());
                ((TextView) v.findViewById(android.R.id.text2)).setText(model.getMessage());
            }
        };
        listView.setAdapter(mAdapter);



    }

    public  void send(View v){
        String message = msg.getText().toString();
        Chat chat = new Chat(message, "innovation");
        mRef.push().setValue(chat);
    }
}
