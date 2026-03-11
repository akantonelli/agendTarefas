package com.akantonelli.agendTarefas.infrastructure.exceptions;

public class ConflictExcepction extends RuntimeException{

    public ConflictExcepction(String msg){
        super(msg);
    }

    public ConflictExcepction (String msg, Throwable throwable){
        super();
    }
}
