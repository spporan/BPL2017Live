package com.poran.bpl2017live;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class TimeShedeul extends RecyclerView.Adapter<TimeShedeul.ViewHolder>{

    private List<String>date;
    private List<String>time;
    private List<String>day;
    private List<String>vanue;
    private List<String>teamList1;
    private List<String>teamList2;





    public TimeShedeul( List<String>date, List<String>time, List<String>day,
                       List<String>vanue,List<String>teamList1,List<String>teamList2){

        this.date=date;
        this.time=time;
        this.day=day;
        this.vanue=vanue;
        this.teamList1=teamList1;
        this.teamList2=teamList2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvMatchNo;
        public TextView tvDate;
        public TextView tvday,tvtime,tvVanue,tvTitle;

        public View layout;

        public ViewHolder(View v){

            super(v);
            layout=v;
            tvMatchNo = (TextView) v.findViewById(R.id.matchNo);
            tvDate = (TextView) v.findViewById(R.id.date);
            tvday = (TextView) v.findViewById(R.id.day);
            tvtime = (TextView) v.findViewById(R.id.time);
            tvTitle = (TextView) v.findViewById(R.id.title);
            tvVanue = (TextView) v.findViewById(R.id.vanue);



        }




    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.activity_time_shedeul,parent,false);

        ViewHolder vh=new ViewHolder(v);


        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String dateSet= date.get(position);
        final String timeSet=time.get(position);
        final String dayset=day.get(position);
        final String vanueSet=vanue.get(position);
        final String titleSet=teamList1.get(position)+"  বনাম  "+teamList2.get(position);
        final String matchNoset= String.valueOf(position+1);

        holder.tvTitle.setText(titleSet);
        if(position<34){
            holder.tvDate.setText("তারিখঃ"+dateSet+" নভেম্বর");
        }else{
            holder.tvDate.setText("তারিখঃ"+dateSet+" ডিসেম্বর");
        }

        if(timeSet.equals("২")||timeSet.equals("২.৩০")){
            holder.tvtime.setText("সময়ঃ দুপুর "+timeSet+" টা");
        }
        else{
            holder.tvtime.setText("সময়ঃ সন্ধ্যা "+timeSet+" টা");
        }


        holder.tvday.setText(" বারঃ "+dayset);
        holder.tvVanue.setText("ভেন্যুঃ"+vanueSet);
        holder.tvMatchNo.setText(" ম্যাচ -"+matchNoset);








    }

    @Override
    public int getItemCount() {

        return date.size();
    }



}
