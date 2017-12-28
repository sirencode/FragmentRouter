package com.example.shenyonghe.fragmentrouter;

/**
 * Created by shenyonghe on 2017/12/28.
 */

public enum PosotionType {
    Home(1),
    Live(2),
    Quote(3),
    Trade(4),
    Me(5),
    Trade_Holding(42),
    Trade_Entrust(43),
    Trade_Entrusting(432),
    Trade_Query(44),
    Trade_Account(45);
    private int value;

    private PosotionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
