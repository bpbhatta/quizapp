package com.bhatta.bp.jsonlistview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> ID;
    ArrayList<String> question_c;
    ArrayList<String> opta_c;
    ArrayList<String> optb_c;
    ArrayList<String> optc_c;
    ArrayList<String> answer_c;



    public ListAdapter(
            Context context2,
            ArrayList<String> id,
            ArrayList<String> question,
                    ArrayList<String> opta,
                    ArrayList<String> optb,
                    ArrayList<String> optc,
                    ArrayList<String> answer


    )
    {

        this.context = context2;
        this.ID = id;
        this.question_c=question;
        this.opta_c=opta;
        this.optb_c=optb;
        this.optc_c=optc;
        this.answer_c=answer;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return ID.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int position, View child, ViewGroup parent) {

        Holder holder;

        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            child = layoutInflater.inflate(R.layout.items, null);

            holder = new Holder();
            holder.quesiton=(TextView) child.findViewById(R.id.tv_question);
            holder.opta=(RadioButton) child.findViewById(R.id.rb_opta);
            holder.optb=(RadioButton) child.findViewById(R.id.rb_optb);
            holder.optc=(RadioButton) child.findViewById(R.id.rb_optc);
            holder.answer=(RadioButton) child.findViewById(R.id.rb_answer);
            child.setTag(holder);

        } else {

            holder = (Holder) child.getTag();
        }
        holder.quesiton.setText(question_c.get(position));
        holder.opta.setText(opta_c.get(position));
        holder.optb.setText(optb_c.get(position));
        holder.optc.setText(optc_c.get(position));
        holder.answer.setText(answer_c.get(position));



        return child;
    }

    public class Holder {

        TextView quesiton;
        RadioButton opta,optb,optc,answer;
    }

}