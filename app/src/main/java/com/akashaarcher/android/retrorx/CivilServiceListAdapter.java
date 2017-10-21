package com.akashaarcher.android.retrorx;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.id.list;

/**
 * Created by Akasha on 10/19/17.
 */

public class CivilServiceListAdapter extends RecyclerView.Adapter<CivilServiceListAdapter.CivilServiceListViewHolder> {

    private List<CivilServiceList> listResults;

    public CivilServiceListAdapter(List<CivilServiceList> listResults) {
        this.listResults = listResults;
    }

    @Override
    public CivilServiceListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_civil_service_list, parent, false);
        CivilServiceListViewHolder vh = new CivilServiceListViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(CivilServiceListViewHolder holder, int position) {
        CivilServiceList civilServiceList = listResults.get(position);
        holder.bind(civilServiceList);
    }

    @Override
    public int getItemCount() {
        return listResults.size();
    }

    public void setData(List<CivilServiceList> listResults) {
        this.listResults = listResults;
        notifyDataSetChanged();
    }


    public class CivilServiceListViewHolder extends RecyclerView.ViewHolder {

        @BindView (R.id.firstName)
        TextView firstNameTv;

        @BindView(R.id.lastName)
        TextView lastNameTv;

        @BindView(R.id.listTitle)
        TextView listTitleTv;

        @BindView(R.id.examNum)
        TextView examNumTv;

        @BindView(R.id.listNum)
        TextView listNumTv;

        @BindView(R.id.finalAverage)
        TextView finalAverageTv;


        public CivilServiceListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind (CivilServiceList civilServiceList) {
            firstNameTv.setText(civilServiceList.getFirstName());
            lastNameTv.setText(civilServiceList.getLastName());
            listTitleTv.setText(civilServiceList.getListTitleDesc());
            examNumTv.setText(civilServiceList.getExamNo());
            listNumTv.setText(civilServiceList.getListNo());
            finalAverageTv.setText(civilServiceList.getAdjFa());
        }
    }

}
