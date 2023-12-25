package com.Lox;

import java.util.List;

public class LoxFunction implements LoxCallable {
    private final Stmt.Function declaration;

    LoxFunction(Stmt.Function declaration) {
        this.declaration = declaration;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        Environment environment = new Environment(interpreter.globals);
        for(int i = 0 ; i < declaration.Params.size(); i ++){
            environment.define(declaration.Params.get(i).lexeme,arguments.get(i));
        }
        interpreter.executeBlock(declaration.body,environment);
        return  null;
    }

    @Override
    public int arity() {
        return this.declaration.Params.size();
    }

    @Override
    public String toString(){
       return "<fn " + this.declaration.name.lexeme + " >" ;
    }
}