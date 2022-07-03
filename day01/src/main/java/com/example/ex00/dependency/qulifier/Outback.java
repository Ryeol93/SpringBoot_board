package com.example.ex00.dependency.qulifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("outback")
public class Outback implements Restaurant {
    @Override
    public int getSteakPrice() {
        return 20000;
    }

    @Override
    public boolean getSidebar() {
        return false;
    }
}
