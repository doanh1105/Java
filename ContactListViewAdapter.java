package com.example.bttuan2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactListViewAdapter extends BaseAdapter {

    ArrayList<Contacts> ListUser ;

    public ContactListViewAdapter(ArrayList<Contacts> listUser) {

        ListUser = listUser;
    }

    @Override
    public int getCount() {

        return this.ListUser.size();
    }

    @Override
    public Contacts getItem(int position ) {
        return this.ListUser.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.ListUser.get(position).getId();
    }

    @Override
    public View getView(int position , View view, ViewGroup viewGroup) {
        View UserView ;
        if(view == null ){
            UserView = view = View.inflate(viewGroup.getContext(), R.layout.item , null);
        }else {
            UserView = view;
        }
        ImageView imgAvatar = UserView.findViewById(R.id.imgAvatar);
        LinearLayout Online = UserView.findViewById(R.id.Online);
        TextView txtUser = UserView.findViewById(R.id.txtUser);

        imgAvatar.setImageResource(viewGroup.getResources().getIdentifier("com.example.bttuan2:drawable/"
                + ListUser.get(position).imgAvatar, null,null ));

        if (ListUser.get(position).online){
            Online.setBackground(viewGroup.getResources().getDrawable(R.drawable.onl_true));
        }else {
            Online.setBackground(viewGroup.getResources().getDrawable(R.drawable.onl_false));
        }

        txtUser.setText(ListUser.get(position).getName());


        return UserView ;
    }
}
