package sk.akademiasovy.tipos.main;

import sk.akademiasovy.tipos.Tipos;
import sk.akademiasovy.tipos.database.MySQL;

public class Main
{
    public static void main(String[] args)
    {
        Tipos t1= new Tipos();

        t1.generate();
        t1.sort();
        t1.print();
        MySQL dbs = new MySQL();

        dbs.insertValuesIntoDrawHistory(t1.getArr());
    }
}