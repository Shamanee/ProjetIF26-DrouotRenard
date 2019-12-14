package fr.utt.if26.projetif26_drouotrenard.DataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {
        Feuille.class,
        Intrant.class,
        Ligne.class,
        Modele.class,
        Module.class,
        Parametre.class,
        ModeleFeuilleJoin.class
}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract FeuilleDao feuilleDao();
    public abstract IntrantDao intrantDao();
    public abstract LigneDao ligneDao();
    public abstract ModeleDao modeleDao();
    public abstract ModuleDao moduleDao();
    public abstract ParametreDao parametreDao();
    public abstract ModeleFeuilleJoinDao modeleFeuilleJoinDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context) {

        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class, "app_database").build();
                }
            }
        }

        return INSTANCE;
    }

    private static AppDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class,
                "app_database")
//                .addCallback(new Callback() {
//            @Override
//            public void onCreate(@NonNull SupportSQLiteDatabase db) {
//                super.onCreate(db);
//                Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        getDatabase(context).parametreDao().insertAll(Parametre.populateData());
//                    }
//                });
//            }
//        })
                .build();
    }
}
