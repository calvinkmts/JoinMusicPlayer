package com.example.calvi.joinmusicplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {

    List<DataModel> dataModelList;
    Context mContext;

    public RecyclerAdapter(Context context, List<DataModel> dataModelList) {
        this.dataModelList = dataModelList;
        mContext = context;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView mTitle;
        TextView mAlbum;
        RelativeLayout mParentLayout;

        public MyHolder(View itemView) {
            super(itemView);

            //mParentLayout = new ConstraintLayout(mContext);
            mTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            mAlbum = (TextView) itemView.findViewById(R.id.textViewAlbum);
            mParentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemview, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder myHolder, int i) {
        DataModel dataModel = dataModelList.get(i);
        myHolder.mAlbum.setText(dataModel.getAlbum());
        myHolder.mTitle.setText(dataModel.getTitle());

        myHolder.mParentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext.getApplicationContext(), "Test", Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }
}
