package br.com.setis.axisdemoapp.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Bin {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "codigoEmissor")
    public int codigoEmissor;

    @ColumnInfo(name = "faixaInicial")
    public int faixaInicial;

    @ColumnInfo(name = "faixaFinal")
    public int faixaFinal;

    @ColumnInfo(name = "qtdTranSeq")
    public int qtdTranSeq;

}
