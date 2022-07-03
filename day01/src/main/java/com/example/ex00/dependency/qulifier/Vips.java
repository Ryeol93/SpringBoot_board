package com.example.ex00.dependency.qulifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("vips") @Primary
public class Vips implements Restaurant{
    @Override
    public int getSteakPrice() {
        return 40000;
    }

    @Override
    public boolean getSidebar() {
        return true;
    }
}
