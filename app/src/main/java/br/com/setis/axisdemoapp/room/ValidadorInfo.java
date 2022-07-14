package br.com.setis.axisdemoapp.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ValidadorInfo {

    @PrimaryKey
    public int vid;

    @ColumnInfo(name = "idValidador")
    public String idValidador;

    @ColumnInfo(name = "idOperador")
    public String idOperador;

    @ColumnInfo(name = "nsLeitor")
    public String nsLeitor;

    @ColumnInfo(name = "nsValidador")
    public String nsValidador;

    @ColumnInfo(name = "codRegistro")
    public String codRegistro;      //B20

    @ColumnInfo(name = "nsuValidador")
    public int nsuValidador;        //N6

    @ColumnInfo(name = "vrsPrmEMV")
    public int vrsPrmEMV;           //N6

    @ColumnInfo(name = "vrsPrmBIN")
    public int vrsPrmBIN;           //N6

    @ColumnInfo(name = "vrsListaExc")
    public int vrsListaExc;         //N6

    @ColumnInfo(name = "idLinha")
    public String idLinha;          //A..15

    @ColumnInfo(name = "idVeiculo")
    public String idVeiculo;        //A..15

    @ColumnInfo(name = "geoValidador")
    public String geoValidador;     //A..20

    //Pan hash da ultima transação aprovada
    @ColumnInfo(name = "panHashUlt")
    public String panHashUlt;

    @ColumnInfo(name = "ksn")
    public String ksn;

}
