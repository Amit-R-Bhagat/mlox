package org.example.lox;

public class Token {
    final TokenType type;
    final String lexeme;
    final Object literal;
    final int line;


    public Token(TokenType tokenType, String lexeme, Object literal, int line) {
        this.type = tokenType;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }

    @Override
    public String toString() {
        return type + " " + lexeme + " " + literal;
    }
}
