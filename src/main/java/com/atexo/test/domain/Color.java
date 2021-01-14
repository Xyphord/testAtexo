package com.atexo.test.domain;

import java.util.EnumSet;
import java.util.Optional;

public enum Color {
    DIAMONDS(0), HEART(1), SPADES(2), CLUBS(3);
    private int order;

    Color(int order) {
        this.order = order;
    }

    public static Color getColorOrderByValue(int _status) {
        EnumSet<Color> colors = EnumSet.allOf(Color.class) ;
        Optional<Color> result =  colors.stream()
                .filter(num -> num.order == _status).findFirst();
        if(result.isEmpty())
            return null;
        return result.get();
    }

    public int getOrder() {
        return this.order;
    }

    public static int getSize(){
        EnumSet<Color> colors = EnumSet.allOf(Color.class) ;
        return colors.size();
    }
}
