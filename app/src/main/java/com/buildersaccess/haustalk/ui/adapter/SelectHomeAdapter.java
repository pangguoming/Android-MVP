package com.buildersaccess.haustalk.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.buildersaccess.haustalk.R;
import com.buildersaccess.haustalk.model.entity.Ba_homepm;
import com.buildersaccess.haustalk.model.entity.Step1;

import java.util.List;

/**
 * Created by pangg_000 on 1/23/2016.
 */
public class SelectHomeAdapter extends BaseAdapter {

    private List<Step1.cAddressDat> data;
    private LayoutInflater layoutInflater;
    private Context context;
    public SelectHomeAdapter(Context context, List<Step1.cAddressDat> data){
        this.context=context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }
    public final class UIobj{
        public TextView tv_title;
    }
    @Override
    public int getCount() {
        if(data!=null){
            return data.size();
        }else{
            return 1;
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

    public void setContent(List<Step1.cAddressDat> data){
        this.data=data;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UIobj UIobj=null;

        if(convertView==null){
            UIobj=new UIobj();
            convertView=layoutInflater.inflate(R.layout.item_selecthome, null);
            UIobj.tv_title=(TextView)convertView.findViewById(R.id.tv_title);
            convertView.setTag(UIobj);
        }else{
            UIobj=(UIobj)convertView.getTag();
        }
        if(data!=null){
            try{
                Step1.cAddressDat cAddressDat =data.get(position);
                UIobj.tv_title.setText( cAddressDat.getAddress());
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

