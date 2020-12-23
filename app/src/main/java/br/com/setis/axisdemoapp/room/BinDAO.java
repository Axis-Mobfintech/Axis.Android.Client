package br.com.setis.axisdemoapp.room;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface BinDAO {

    @Insert
    void insertBin(Bin... bin);

    @Query("SELECT * FROM Bin WHERE Bin.faixaInicial <= :bin AND Bin.faixaFinal >= :bin LIMIT 1")
    public Bin checkBin(int bin);

    @Query("DELETE FROM Bin")
    public void deleteAll();

    @Query("SELECT * FROM Bin")
    public List<Bin> getAll();
}
