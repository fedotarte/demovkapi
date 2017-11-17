package com.example.demovkapi;

import com.example.demovkapi.valuemapper.ValueMapper;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class MethodsTest {

    ValueMapper valueMapper = new ValueMapper();

    @Test
    public void testMapping(){

        //System.out.println(valueMapper.parseStringToURL("Hello World"));
        System.err.println(valueMapper.parseStringToURL("Hello world"));
    }

    @Test
    public void testLocalDatePArsing(){
        System.err.println(valueMapper.parseStringBirthDayToLocalDate("5.12"));
    }




}
