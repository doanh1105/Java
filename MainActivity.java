package com.example.bttuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    Button btnDelete;
    ContactListViewAdapter contactListViewAdapter;
    ArrayList<Contacts> ListUser;
    String imgAvatar[] = {"tanh" ,"an" ,"concua","anh2","anh3","anh4"};
    String name [] = {"Trần TuyếtAnh" ,"An Ngáo" ,"Con Cua","Kiều Trang","Lê Phương","Thượng Đẳng"};
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addData();
        addView();
        addEvents();


    }

    private void addEvents() {
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Contacts clickUser = (Contacts) contactListViewAdapter.getItem(position);
                Toast.makeText(MainActivity.this, clickUser.getId() + " - "
                        + clickUser.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contactListViewAdapter.getCount() > 0 ){
                    ListUser.remove(0);
                    contactListViewAdapter.notifyDataSetChanged();
                     Toast.makeText(MainActivity.this,"Delete first user ," + contactListViewAdapter.getCount()
                                    + "left ..", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void addView() {
         lvContact = findViewById(R.id.lvContact);
         btnDelete = findViewById(R.id.btnDelete);
         ContactListViewAdapter contactListViewAdapter = new ContactListViewAdapter(ListUser);
         lvContact.setAdapter(contactListViewAdapter);

    }

    private void addData() {
        ListUser = new ArrayList<>();
        random = new Random();
        int a = 0;
         Contacts contact;
         Boolean Online = false;
        for (int i = 0 ; i < 100 ; i++){
            a = random.nextInt(imgAvatar.length);
            Online = random.nextBoolean();
            contact = new Contacts(Long.parseLong(i+"") ,imgAvatar[a], name[a], Online);
            ListUser.add(contact);
        }
    }
}