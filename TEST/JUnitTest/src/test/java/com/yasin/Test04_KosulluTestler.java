package com.yasin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class Test04_KosulluTestler {
    @Test
    @EnabledOnOs(OS.MAC)
    void test01(){
        System.out.println("Test01");
    }
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void test02(){
        System.out.println("Test01");
    }
}
