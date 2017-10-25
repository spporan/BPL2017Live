package com.poran.bpl2017live;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TeamList extends  RecyclerView.Adapter<TeamList.ViewHolder> {
    private  Context context;
    private String team[]=new String[7];
    private String budget[]=new String[7];


    public TeamList(String team[],String budget[]){
        this.team=team;
        this.budget=budget;

    }
    
    public TeamList(){
        
    }





    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvteam,tvbudget;

        View v;

        public ViewHolder(View itemView) {
            super(itemView);
            v=itemView;
            context=itemView.getContext();
            tvteam= (TextView) itemView.findViewById(R.id.team);
            tvbudget= (TextView) itemView.findViewById(R.id.totalPrice);


        }


    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.activity_team_list,parent,false);

       ViewHolder vh=new ViewHolder(v);


        return vh;


    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int  position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent;
               // Toast.makeText( view.getContext(),"Recycle Click" + position, Toast.LENGTH_SHORT).show();



                     intent=new Intent(context,PlayerList.class);
                    intent.putExtra("position",position);
                    context.startActivity(intent);




            }
        });

        holder.tvteam.setText(team[position]);
        holder.tvbudget.setText(budget[position]+" টাকা");





    }




    @Override
    public int getItemCount() {
        return team.length;
    }




}
