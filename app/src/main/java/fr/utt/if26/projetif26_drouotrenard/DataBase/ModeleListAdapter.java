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

public class ModeleListAdapter extends RecyclerView.Adapter<ModeleListAdapter.ModeleViewHolder> {

    class ModeleViewHolder extends RecyclerView.ViewHolder {
        private final TextView modeleItemView;

        private ModeleViewHolder(View itemView) {
            super(itemView);
            modeleItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater inflater;
    private List<Modele> modeles;

    public ModeleListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ModeleListAdapter.ModeleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_modele, parent, false);
        return new ModeleListAdapter.ModeleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ModeleListAdapter.ModeleViewHolder holder, int position) {
        if (modeles != null) {
            Modele current = modeles.get(position);
            holder.modeleItemView.setText(current.getId());
        } else {
            holder.modeleItemView.setText("No modeles");
        }
    }

    public void setModeles(List<Modele> listModeles){
        this.modeles = listModeles;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (modeles != null) {
            return modeles.size();
        } else return 0;
    }
}
