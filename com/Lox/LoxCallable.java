package com.Lox;

import java.util.List;

interface LoxCallable {
Object call(Interpreter interpreter, List<Object> arguments);
int arity();
}