package com.jongzazaal.sampletool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jongzazaal on 2/10/2559.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<String> mDataset;
    private ArrayList<Integer> mpicDateset;
    private ArrayList<String> mphoneDataset;
    private ArrayList<String> memailDataset;
    private Context mContext;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        // each data item is just a string in this case
        public TextView mTextView;
        private ItemClickListener clickListener;
        public ImageView imageView;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.info_text);
            imageView = (ImageView) v.findViewById(R.id.picView);

            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);



        }
        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }
        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }
        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, getPosition(), true);
            return true;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context contexts ,ArrayList<String> myDataset, ArrayList<Integer> picDataset,
    ArrayList<String> phone, ArrayList<String> email) {
        mDataset = myDataset;
        mpicDateset= picDataset;
        mphoneDataset = phone;
        memailDataset = email;
        this.mContext = contexts;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position));
        holder.imageView.setImageResource(mpicDateset.get(position));
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                    Toast.makeText(mContext, "#" + position + " - " + mDataset.get(position) + " (Long click)", Toast.LENGTH_SHORT).show();
                } else {
//                    Intent i = new Intent(mContext, Contact.class);
//                    i.putExtra("contact_name",mDataset.get(position) );
//                    //startActivityForResult(i, 1);
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    mContext.startActivity(i);
                    //MyActivity m = new MyActivity();
                    startActivityB(mContext, mDataset.get(position), mpicDateset.get(position), mphoneDataset.get(position), memailDataset.get(position));
                    Toast.makeText(mContext, "#" + position + " - " + mDataset.get(position), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public static void startActivityB(Context context, String name, Integer pic, String phone, String email) {
        Intent intent = new Intent(context, Contact.class);
        intent.putExtra("contact_name",name);
        intent.putExtra("contact_pic",pic);
        intent.putExtra("contact_phone",phone);
        intent.putExtra("contact_email",email);
        context.startActivity(intent);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}