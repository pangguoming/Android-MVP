package com.buildersaccess.haustalk.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.buildersaccess.haustalk.R;
import com.buildersaccess.haustalk.model.entity.HomevendorDat;

import java.util.List;

/**
 * Created by pangg_000 on 1/23/2016.
 */
public class TicketsAdapter extends BaseAdapter {

    private List<HomevendorDat> data;
    private LayoutInflater layoutInflater;
    private Context context;
    public TicketsAdapter(Context context, List<HomevendorDat> data){
        this.context=context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }
    public final class UIobj{
        public TextView tv_title;
        public TextView tv_detail;
    }
    @Override
    public int getCount() {
        if(data!=null){
            return data.size();
        }else{
            return 0;
        }
    }
    @Override
    public Object getItem(int position) {
        if(data!=null){
            return data.get(position);
        }else{
            return null;
        }

    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setContent(List<HomevendorDat> data){
        this.data=data;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UIobj UIobj=null;

        if(convertView==null){
            UIobj=new UIobj();
            convertView=layoutInflater.inflate(R.layout.item_tickets, null);
            UIobj.tv_title=(TextView)convertView.findViewById(R.id.tv_title);
            UIobj.tv_detail=(TextView)convertView.findViewById(R.id.tv_detail);
            convertView.setTag(UIobj);
        }else{
            UIobj=(UIobj)convertView.getTag();
        }
        if(data!=null){
            try{
                HomevendorDat homevendorDat=data.get(position);
                String title="Ticket #"+homevendorDat.getIdwebcare1()+" "+homevendorDat.getStatus()+"\n"+homevendorDat.getAddress();
                title=title.replace("<br>","\n");
                UIobj.tv_title.setText( title);
                String detail=homevendorDat.getAssignpm()+"\n"+homevendorDat.getVendorcontact();
                detail=detail.replace("<br>","\n");
                UIobj.tv_detail.setText(detail);
            }catch (Exception e){
                this.showError(e.getMessage());
            }
        }
        return convertView;
    }
    public void showError(String error) {
        Toast.makeText(this.context, error,
                Toast.LENGTH_SHORT).show();
    }
}

