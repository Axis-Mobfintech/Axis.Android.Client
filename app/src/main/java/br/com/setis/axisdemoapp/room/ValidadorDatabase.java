package br.com.setis.axisdemoapp.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ValidadorInfo.class, Pan.class, Bin.class}, version = 1)
public abstract class ValidadorDatabase extends RoomDatabase {
    public abstract ValidadorInfoDAO validadorInfoDAO();

    public abstract PanDAO panDAO();

    public abstract BinDAO binDAO();
}
