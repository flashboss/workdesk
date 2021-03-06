/* Generated By:JavaCC: Do not edit this line. OwExprParserConstants.java */
package com.wewebu.expression.parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface OwExprParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int SINGLE_LINE_COMMENT = 8;
  /** RegularExpression Id. */
  int FORMAL_COMMENT = 9;
  /** RegularExpression Id. */
  int MULTI_LINE_COMMENT = 10;
  /** RegularExpression Id. */
  int NULL = 12;
  /** RegularExpression Id. */
  int TRUE = 13;
  /** RegularExpression Id. */
  int FALSE = 14;
  /** RegularExpression Id. */
  int AND = 15;
  /** RegularExpression Id. */
  int OR = 16;
  /** RegularExpression Id. */
  int XOR = 17;
  /** RegularExpression Id. */
  int NOT = 18;
  /** RegularExpression Id. */
  int INTEGER_LITERAL = 19;
  /** RegularExpression Id. */
  int DECIMAL_LITERAL = 20;
  /** RegularExpression Id. */
  int HEX_LITERAL = 21;
  /** RegularExpression Id. */
  int OCTAL_LITERAL = 22;
  /** RegularExpression Id. */
  int FLOATING_POINT_LITERAL = 23;
  /** RegularExpression Id. */
  int DECIMAL_EXPONENT = 24;
  /** RegularExpression Id. */
  int STRING_LITERAL = 25;
  /** RegularExpression Id. */
  int IDENTIFIER = 26;
  /** RegularExpression Id. */
  int LETTER = 27;
  /** RegularExpression Id. */
  int PART_LETTER = 28;
  /** RegularExpression Id. */
  int LPAREN = 29;
  /** RegularExpression Id. */
  int RPAREN = 30;
  /** RegularExpression Id. */
  int LBRACKET = 31;
  /** RegularExpression Id. */
  int RBRACKET = 32;
  /** RegularExpression Id. */
  int LT = 33;
  /** RegularExpression Id. */
  int EQ = 34;
  /** RegularExpression Id. */
  int LE = 35;
  /** RegularExpression Id. */
  int GE = 36;
  /** RegularExpression Id. */
  int NE = 37;
  /** RegularExpression Id. */
  int PLUS = 38;
  /** RegularExpression Id. */
  int MINUS = 39;
  /** RegularExpression Id. */
  int STAR = 40;
  /** RegularExpression Id. */
  int SLASH = 41;
  /** RegularExpression Id. */
  int REM = 42;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int IN_FORMAL_COMMENT = 1;
  /** Lexical state. */
  int IN_MULTI_LINE_COMMENT = 2;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\f\"",
    "<token of kind 6>",
    "\"/*\"",
    "<SINGLE_LINE_COMMENT>",
    "\"*/\"",
    "\"*/\"",
    "<token of kind 11>",
    "\"null\"",
    "\"true\"",
    "\"false\"",
    "\"and\"",
    "\"or\"",
    "\"xor\"",
    "\"not\"",
    "<INTEGER_LITERAL>",
    "<DECIMAL_LITERAL>",
    "<HEX_LITERAL>",
    "<OCTAL_LITERAL>",
    "<FLOATING_POINT_LITERAL>",
    "<DECIMAL_EXPONENT>",
    "<STRING_LITERAL>",
    "<IDENTIFIER>",
    "<LETTER>",
    "<PART_LETTER>",
    "\"(\"",
    "\")\"",
    "\"[\"",
    "\"]\"",
    "\"<\"",
    "\"=\"",
    "\"<=\"",
    "\">=\"",
    "\"!=\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"%\"",
    "\"?\"",
    "\":\"",
    "\">\"",
    "\".\"",
    "\"{\"",
    "\"}\"",
    "\",\"",
  };

}
