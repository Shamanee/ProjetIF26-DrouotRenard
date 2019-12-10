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
        private final TextView parametreItemView;

        private ParametreViewHolder(View itemView) {
            super(itemView);
            parametreItemView = itemView.findViewById(R.id.textView);
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
            holder.parametreItemView.setText(current.getId());
        } else {
            holder.parametreItemView.setText("No parametres");
        }
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
