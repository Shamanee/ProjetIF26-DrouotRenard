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

public class FeuilleListAdapter extends RecyclerView.Adapter<FeuilleListAdapter.FeuilleViewHolder> {

    class FeuilleViewHolder extends RecyclerView.ViewHolder {
        private final TextView feuilleItemView;

        private FeuilleViewHolder(View itemView) {
            super(itemView);
            feuilleItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater inflater;
    private List<Feuille> feuilles;

    public FeuilleListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FeuilleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_feuille, parent, false);
        return new FeuilleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeuilleViewHolder holder, int position) {
        if (feuilles != null) {
            Feuille current = feuilles.get(position);
            holder.feuilleItemView.setText(current.getId());
        } else {
            holder.feuilleItemView.setText("No feuilles");
        }
    }

    public void setFeuilles(List<Feuille> listFeuilles){
        this.feuilles = listFeuilles;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (feuilles != null) {
            return feuilles.size();
        } else return 0;
    }
}
