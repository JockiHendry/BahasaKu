grammar BahasaKu;

//
// Parser Rules
//

file
    : (statement NEWLINE)* statement NEWLINE?
    ;

statement
    : tampilkan 
    | expr
    | assignment     
    ;

tampilkan
    : TAMPILKAN expr
    ;

assignment
    : IDENTIFIER ASSIGNMENT expr  
    ;

exprList
    : expr (KOMA expr)* 
    ;

arguments
    : KURUNG_BUKA exprList? KURUNG_TUTUP
    ;

expr
    :   expr op=(TITIK|SELF) IDENTIFIER arguments       # PanggilMethod    
    |   BUAT qualifiedName arguments                    # BuatObject
    |   expr KALI expr                                  # Perkalian
    |   expr BAGI expr                                  # Pembagian
    |   expr TAMBAH expr                                # Penjumlahan
    |   expr KURANG expr                                # Pengurangan    
    |   ANGKA                                           # Angka                                 
    |   BOOLEAN_TRUE                                    # BooleanTrue
    |   BOOLEAN_FALSE                                   # BooleanFalse
    |   STRING                                          # String
    |   IDENTIFIER                                      # Identifier                                                  
    ;

qualifiedName
    : IDENTIFIER ('.' IDENTIFIER)* 
    ;


//
// Lexer Rules
//

TAMPILKAN: 'tampilkan' ;

BUAT: 'buat' ;

BOOLEAN_TRUE: 'iya' ;

BOOLEAN_FALSE: 'tidak' ;

ASSIGNMENT: '<-' ;

KOMA: ',' ;

TITIK: '.' ;

SELF: '#' ;

TAMBAH: '+' ;

KURANG: '-' ;

KALI: '*' ;

BAGI: '/' ;

KURUNG_BUKA: '(' ;

KURUNG_TUTUP: ')' ;

STRING: '\'' .*? '\'' ;

IDENTIFIER: [a-zA-Z$_] [a-zA-Z0-9$_]* ;   

ANGKA:  [0-9]+ ;

NEWLINE:    '\r'? '\n' ;

WS  :   [ \t\r\n]+ -> skip ;
