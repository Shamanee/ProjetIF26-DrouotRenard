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

public class ModuleListAdapter extends RecyclerView.Adapter<ModuleListAdapter.ModuleViewHolder> {

    class ModuleViewHolder extends RecyclerView.ViewHolder {
        private final TextView moduleItemView;

        private ModuleViewHolder(View itemView) {
            super(itemView);
            moduleItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater inflater;
    private List<Module> modules;

    public ModuleListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ModuleListAdapter.ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_module, parent, false);
        return new ModuleListAdapter.ModuleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleListAdapter.ModuleViewHolder holder, int position) {
        if (modules != null) {
            Module current = modules.get(position);
            holder.moduleItemView.setText(current.getId());
        } else {
            holder.moduleItemView.setText("No modules");
        }
    }

    public void setModules(List<Module> listModules){
        this.modules = listModules;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (modules != null) {
            return modules.size();
        } else return 0;
    }
}
