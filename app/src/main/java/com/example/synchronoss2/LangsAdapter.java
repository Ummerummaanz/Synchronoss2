package com.example.synchronoss2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LangsAdapter extends RecyclerView.Adapter<LangsAdapter.LViewHolder> {
    public static String TAG = LangsAdapter.class.getSimpleName();
    String[] mLanguages;

    public LangsAdapter(String[] languages) {
        mLanguages = languages;
    }

    @NonNull
    @Override
    public LViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "Nikhil has bought a plank from market");
        View plankBought = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_rview, parent, false);
        return new LViewHolder(plankBought);
    }


    @Override
    public void onBindViewHolder(@NonNull LViewHolder holder, int position) {
        Log.i(TAG, "ruman writing the dish name on the Plank " + mLanguages[position]);
        holder.rowTextView.setText(mLanguages[position]);
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "megha counting the no of items in the data sets");
        return mLanguages.length;
    }

    class LViewHolder extends RecyclerView.ViewHolder {

        TextView rowTextView;
        public LViewHolder(@NonNull View plankBought) {
            super(plankBought);
            Log.i(TAG,"Abdul is storing the plank");
            rowTextView = plankBought.findViewById(R.id.tvRow);
        }
    }
}



