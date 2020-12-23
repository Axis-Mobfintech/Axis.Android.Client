package br.com.setis.axisdemoapp.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ValidadorInfoDAO {

    @Query("SELECT * FROM ValidadorInfo LIMIT 1")
    ValidadorInfo getInfo();

    @Insert
    void insertBaseValues(ValidadorInfo... info);

    @Query("DELETE FROM ValidadorInfo")
    void deleteAll();

    @Query("UPDATE ValidadorInfo SET vrsPrmEMV = :version")
    void updateVersionEmv(int version);

    @Query("UPDATE ValidadorInfo SET vrsPrmBIN = :version")
    void updateVersionBin(int version);

    @Query("UPDATE ValidadorInfo SET vrsListaExc = :version")
    void updateVersionListaExc(int version);

    @Query("UPDATE ValidadorInfo SET nsuValidador = :value")
    void updateNsu(int value);

    @Query("UPDATE ValidadorInfo SET panHashUlt = :panHash")
    void updateLastPanHash(String panHash);
}
