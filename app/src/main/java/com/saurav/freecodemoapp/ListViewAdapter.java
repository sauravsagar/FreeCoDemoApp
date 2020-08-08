package com.saurav.freecodemoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private List<CollegeNames> collegeNamesList = null;
    private ArrayList<CollegeNames> arraylist;

    public ListViewAdapter(Context context, List<CollegeNames> collegeNamesList) {
        mContext = context;
        this.collegeNamesList = collegeNamesList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<CollegeNames>();
        this.arraylist.addAll(collegeNamesList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return collegeNamesList.size();
    }

    @Override
    public CollegeNames getItem(int position) {
        return collegeNamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_view_items, null);
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(collegeNamesList.get(position).getCollegeName());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        collegeNamesList.clear();
        if (charText.length() == 0) {
            collegeNamesList.addAll(arraylist);
        } else {
            for (CollegeNames wp : arraylist) {
                if (wp.getCollegeName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    collegeNamesList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
