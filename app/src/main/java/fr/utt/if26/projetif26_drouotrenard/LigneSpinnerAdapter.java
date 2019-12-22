package fr.utt.if26.projetif26_drouotrenard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import fr.utt.if26.projetif26_drouotrenard.DataBase.Ligne;

public class LigneSpinnerAdapter extends BaseAdapter implements SpinnerAdapter {

    private LayoutInflater inflater;
    private List<Ligne> items;

    public LigneSpinnerAdapter(Context context, List<Ligne> items) {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = inflater.inflate(R.layout.support_simple_spinner_dropdown_item, parent, false);
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = inflater.inflate(R.layout.support_simple_spinner_dropdown_item, parent, false);
        }
        return view;
    }
}
