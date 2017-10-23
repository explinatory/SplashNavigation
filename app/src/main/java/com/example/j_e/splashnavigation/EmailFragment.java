package com.example.j_e.splashnavigation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



public class EmailFragment extends Fragment {

    EditText editEmail, editSubject, editMessage;
    Button btn_Send;

    public EmailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //return
        View view = inflater.inflate(R.layout.fragment_email, container, false);

        editEmail = (EditText) view.findViewById(R.id.editEmail);
        editSubject = (EditText) view.findViewById(R.id.editSubject);
        editMessage = (EditText) view.findViewById(R.id.editMessage);
        btn_Send = (Button) view.findViewById(R.id.btn_send);
        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to = editEmail.getText().toString();
                String subject = editSubject.getText().toString();
                String message = editMessage.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);

                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent, "Select Email app"));
            }
        });
        return view;
    }
}