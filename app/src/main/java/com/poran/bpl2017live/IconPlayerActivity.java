package com.poran.bpl2017live;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class IconPlayerActivity extends RecyclerView.Adapter<IconPlayerActivity.ViewHolder> {
    private String playerName[]=new String[7];
    private String price[]=new String[7];
    private String team[]=new String[7];

    
    public IconPlayerActivity(){
        
    }



   public IconPlayerActivity(String playerName[],String price[],String team[]){
       this.playerName=playerName;
       this.price=price;
       this.team=team;


   }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView pName,price,pteam;
        ImageView playerimg;

        public View layout;

        public ViewHolder(View v){

            super(v);
            layout=v;
             pName= (TextView) v.findViewById(R.id.playerName);
            price = (TextView) v.findViewById(R.id.price);
            pteam = (TextView) v.findViewById(R.id.team);

            playerimg = (ImageView) v.findViewById(R.id.profile_image);



        }


    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.iconplayer,parent,false);

        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String name=playerName[position];
        final String pPrice=price[position];
        final String pteam=team[position];
        holder.pName.setText(name);

        holder.price.setText("মূল্যঃ "+pPrice+" লক্ষ");
        holder.pteam.setText("দলঃ"+pteam);






    }

    @Override
    public int getItemCount() {
        return team.length;
    }




}
