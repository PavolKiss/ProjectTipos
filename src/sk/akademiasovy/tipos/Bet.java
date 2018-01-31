package sk.akademiasovy.tipos;

import java.util.Date;

public class Bet {
    private int idt;
    private int idUser;
    private Date date;
    private int draw_id;
    private int bet1;
    private int bet2;
    private int bet3;
    private int bet4;
    private int bet5;

    public Bet(int idt, int idUser, Date date, int bet1, int bet2, int bet3, int bet4, int bet5) {
        this.idt = idt;
        this.idUser = idUser;
        this.date = date;
        this.bet1 = bet1;
        this.bet2 = bet2;
        this.bet3 = bet3;
        this.bet4 = bet4;
        this.bet5 = bet5;
    }


}
