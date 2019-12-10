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

public class IntrantListAdapter extends RecyclerView.Adapter<IntrantListAdapter.IntrantViewHolder> {

    class IntrantViewHolder extends RecyclerView.ViewHolder {
        private final TextView intrantItemView;

        private IntrantViewHolder(View itemView) {
            super(itemView);
            intrantItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater inflater;
    private List<Intrant> intrants;

    public IntrantListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public IntrantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_intrant, parent, false);
        return new IntrantViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull IntrantViewHolder holder, int position) {
        if (intrants != null) {
            Intrant current = intrants.get(position);
            holder.intrantItemView.setText(current.getId());
        } else {
            holder.intrantItemView.setText("No intrants");
        }
    }

    public void setIntrants(List<Intrant> listIntrants) {
        this.intrants = listIntrants;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (intrants != null) {
            return intrants.size();
        } else return 0;
    }
}
