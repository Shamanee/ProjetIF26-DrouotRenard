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

public class LigneListAdapter extends RecyclerView.Adapter<LigneListAdapter.LigneViewHolder> {

    class LigneViewHolder extends RecyclerView.ViewHolder {
        private final TextView ligneItemView;

        private LigneViewHolder(View itemView) {
            super(itemView);
            ligneItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater inflater;
    private List<Ligne> lignes;

    public LigneListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LigneListAdapter.LigneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_ligne, parent, false);
        return new LigneListAdapter.LigneViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LigneListAdapter.LigneViewHolder holder, int position) {
        if (lignes != null) {
            Ligne current = lignes.get(position);
            holder.ligneItemView.setText(current.getId());
        } else {
            holder.ligneItemView.setText("No lignes");
        }
    }

    public void setLignes(List<Ligne> listLignes){
        this.lignes = listLignes;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (lignes != null) {
            return lignes.size();
        } else return 0;
    }

}
