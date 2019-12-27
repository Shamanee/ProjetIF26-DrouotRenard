package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.utt.if26.projetif26_drouotrenard.R;

public class ParametreListAdapter extends RecyclerView.Adapter<ParametreListAdapter.ParametreViewHolder> {

    class ParametreViewHolder extends RecyclerView.ViewHolder {
        private final TextView id;
        private final TextView type;
        private final TextView value;

        private ParametreViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.parametre_id);
            type = itemView.findViewById(R.id.parametre_type);
            value = itemView.findViewById(R.id.parametre_value);
        }
    }

    private final LayoutInflater inflater;
    private List<Parametre> parametres;

    public ParametreListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ParametreListAdapter.ParametreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_parametre, parent, false);
        return new ParametreListAdapter.ParametreViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ParametreListAdapter.ParametreViewHolder holder, int position) {
        if (parametres != null) {
            Parametre current = parametres.get(position);
            holder.id.setText(Integer.toString(current.getId()));
            holder.type.setText(current.getType());
            holder.value.setText(current.getValue());
        } else {
            holder.id.setText("");
            holder.type.setText("");
            holder.value.setText("");
        }
    }

    public List<Parametre> getParametres() {
        return parametres;
    }

    public void setParametres(List<Parametre> listParametres){
        this.parametres = listParametres;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (parametres != null) {
            return parametres.size();
        } else return 0;
    }
}
