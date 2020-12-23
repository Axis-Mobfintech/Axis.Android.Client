package br.com.setis.axisdemoapp.room;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface PanDAO {

    @Insert
    public void insertPan(Pan... pan);

    @Query("SELECT * FROM Pan WHERE Pan.panHash = :panHash LIMIT 1")
    public Pan checkPan(String panHash);

    @Query("DELETE FROM Pan")
    public void deleteAll();

    @Query("SELECT * FROM Pan")
    public List<Pan> getAll();

    @Query("UPDATE Pan SET panSeqNo = :value WHERE panHash = :panHash")
    public void updatePanSeqNum(int value, String panHash);

}
