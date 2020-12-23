package br.com.setis.axisdemoapp.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pan {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "motivo")
    public String motivo;

    @ColumnInfo(name = "dataInclusao")
    public int dataInclusao;

    @ColumnInfo(name = "panHash")
    public String panHash;

    @ColumnInfo(name = "panSeqNo")
    public int panSeqNo;

    @ColumnInfo(name = "panAceito")
    public int panAceito;
}
