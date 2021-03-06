/* Generated By:JavaCC: Do not edit this line. OwExprParser.java */
package com.wewebu.expression.parser;
import com.wewebu.expression.language.*;
import java.util.*;

import java.io.*;

/**
 *<p>
 * Expression Language Parser.
 *</p>
 *
 *<p><font size="-2">
 * Alfresco Workdesk<br>
 * Copyright (c) Alfresco Software, Inc. All Rights Reserved.
 *</font></p>
 */
public class OwExprParser implements OwExprParserConstants {
    public static OwExprExpression parse(String expressionString_p) throws ParseException
    {
        OwExprParser parser = new OwExprParser(new StringReader(expressionString_p));
        OwExprExpression expression = parser.ExprExpression();
        return expression;
    }

  void error_skipto(int kind,OwExprException exprException_p) throws ParseException {
  ParseException e = generateParseException();  // generate the exception object.
  if (exprException_p!=null)
  {

  }
  System.out.println(e.getMessage()+(exprException_p!=null?exprException_p.getMessage():""));  // print the error message
  Token t;
  do {
    t = getNextToken();
  } while (t.kind != kind);
  }

/***********************************************
 * THE EXPRESSION  LANGUAGE GRAMMAR STARTS HERE *
 ***********************************************/





/*
 * Expression syntax follows.
 */
  final public OwExprExpression ExprExpression() throws ParseException {
OwExprExpression expression;
    expression = Expression(new OwExprSymbolTable(),new OwExprErrorTable(){
              protected String currentLocationInfo()
             {
                  Token errortok = token;
                  int line = errortok.beginLine, column = errortok.beginColumn;
    
    
                  return "at line " + line + ", column " + column ;
              }
        });
         {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public OwExprExpression Expression(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
OwExprExpression expression;
    try {
      expression = ConditionalExpression(symTable_p,errorTable_p);
      jj_consume_token(0);
          {if (true) return expression;}
    } catch (ParseException e) {
                             {if (true) return new OwExprUnparsableExpression(symTable_p,errorTable_p,e);}
    } catch (TokenMgrError e) {
                            {if (true) return new OwExprUnparsableExpression(symTable_p,errorTable_p,e);}
    }
    throw new Error("Missing return statement in function");
  }

  final public OwExprExpression ConditionalExpression(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
OwExprExpression expression;
OwExprExpression test;
OwExprExpression trueExpr;
OwExprExpression falseExpr;
    test = ConditionalOrExpression(symTable_p,errorTable_p);
                                                       expression=test;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 43:
      jj_consume_token(43);
      trueExpr = ConditionalExpression(symTable_p,errorTable_p);
      jj_consume_token(44);
      falseExpr = ConditionalExpression(symTable_p,errorTable_p);
  expression=new OwExprConditionalExpression(symTable_p,errorTable_p,test,trueExpr,falseExpr);
      break;
    default:
      ;
    }
   {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public OwExprExpression ConditionalOrExpression(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
OwExprExpression  expression;
OwExprExpression  expressionPart;
OwExprBooleanOperator bo;
    expression = ConditionalAndExpression(symTable_p,errorTable_p);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
        ;
        break;
      default:
        break label_1;
      }
      jj_consume_token(OR);
        bo=OwExprOrOperator.INSTANCE;
      expressionPart = ConditionalAndExpression(symTable_p,errorTable_p);
     expression=new OwExprBinaryExpression(symTable_p,errorTable_p,expression,bo,expressionPart);
    }
     {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public OwExprExpression ConditionalAndExpression(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
OwExprExpression  expression;
OwExprExpression expressionPart;
OwExprBooleanOperator bo;
    expression = ExclusiveOrExpression(symTable_p,errorTable_p);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        break label_2;
      }
      jj_consume_token(AND);
         bo=OwExprAndOperator.INSTANCE;
      expressionPart = ExclusiveOrExpression(symTable_p,errorTable_p);
    expression=new OwExprBinaryExpression(symTable_p,errorTable_p,expression,bo,expressionPart);
    }
     {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public OwExprExpression ExclusiveOrExpression(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
OwExprExpression  expression;
OwExprExpression expressionPart;
OwExprXorOperator xo;
    expression = EqualityExpression(symTable_p,errorTable_p);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case XOR:
        ;
        break;
      default:
        break label_3;
      }
      jj_consume_token(XOR);
            xo=OwExprXorOperator.INSTANCE;
      expressionPart = EqualityExpression(symTable_p,errorTable_p);
       expression=new OwExprBinaryExpression(symTable_p,errorTable_p,expression,xo,expressionPart);
    }
     {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public OwExprExpression EqualityExpression(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
OwExprExpression  expression;
OwExprExpression expressionPart;
OwExprEqualityOperator ro;
    expression = RelationalExpression(symTable_p,errorTable_p);
    label_4:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQ:
        jj_consume_token(EQ);
              ro=OwExprEqualityOperator.EQUAL_INSTANCE;
        break;
      case NE:
        jj_consume_token(NE);
              ro=OwExprEqualityOperator.NOTEQUAL_INSTANCE;
        break;
      default:
        jj_consume_token(-1);
        throw new ParseException();
      }
      expressionPart = RelationalExpression(symTable_p,errorTable_p);
          expression=new OwExprBinaryExpression(symTable_p,errorTable_p,expression,ro,expressionPart);
    }
       {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public OwExprExpression RelationalExpression(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
OwExprExpression  expression;
OwExprExpression expressionPart;
OwExprBinaryOperator ro;
    expression = AdditiveExpression(symTable_p,errorTable_p);
    label_5:
    while (true) {
      if (jj_2_2(2)) {
        ;
      } else {
        break label_5;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LT:
        jj_consume_token(LT);
                          ro=OwExprLessOperator.INSTANCE;
        break;
      case 45:
        jj_consume_token(45);
                        ro=OwExprGreaterOperator.INSTANCE;
        break;
      case LE:
        jj_consume_token(LE);
                          ro=OwExprLessEqOperator.INSTANCE;
        break;
      case GE:
        jj_consume_token(GE);
                          ro=OwExprGreaterEqOperator.INSTANCE;
        break;
      default:
        jj_consume_token(-1);
        throw new ParseException();
      }
      expressionPart = AdditiveExpression(symTable_p,errorTable_p);
                      expression=new OwExprBinaryExpression(symTable_p,errorTable_p,expression,ro,expressionPart);
    }
                   {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public OwExprExpression AdditiveExpression(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
OwExprExpression  expression;
OwExprExpression expressionPart;
OwExprBinaryOperator ao;
    expression = MultiplicativeExpression(symTable_p,errorTable_p);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        break label_6;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
                            ao=OwExprPlusOperator.INSTANCE;
        break;
      case MINUS:
        jj_consume_token(MINUS);
                             ao=OwExprMinusOperator.INSTANCE;
        break;
      default:
        jj_consume_token(-1);
        throw new ParseException();
      }
      expressionPart = MultiplicativeExpression(symTable_p,errorTable_p);
                        expression=new OwExprBinaryExpression(symTable_p,errorTable_p,expression,ao,expressionPart);
    }
                    {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public OwExprExpression MultiplicativeExpression(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
OwExprExpression expression;
OwExprExpression unaryExpression;
OwExprMultiplicativeOperator mo;
    expression = UnaryExpression(symTable_p,errorTable_p);
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
      case SLASH:
      case REM:
        ;
        break;
      default:
        break label_7;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
        jj_consume_token(STAR);
                  mo=OwExprMultiplyOperator.INSTANCE;
        break;
      case SLASH:
        jj_consume_token(SLASH);
                  mo=OwExprDivideOperator.INSTANCE;
        break;
      case REM:
        jj_consume_token(REM);
                 mo=OwExprRemainderOperator.INSTANCE;
        break;
      default:
        jj_consume_token(-1);
        throw new ParseException();
      }
      unaryExpression = UnaryExpression(symTable_p,errorTable_p);
           expression=new OwExprBinaryExpression(symTable_p,errorTable_p,expression,mo,unaryExpression);
    }
        {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public OwExprExpression UnaryExpression(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
OwExprExpression expression=null;
OwExprUnaryOperator uo;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
         uo=OwExprUnaryPlusOperator.INSTANCE;
        break;
      case MINUS:
        jj_consume_token(MINUS);
          uo=OwExprUnaryMinusOperator.INSTANCE;
        break;
      default:
        jj_consume_token(-1);
        throw new ParseException();
      }
      expression = UnaryExpression(symTable_p,errorTable_p);
      expression=new OwExprUnaryExpression(symTable_p,errorTable_p,uo,expression);
      break;
    case NULL:
    case TRUE:
    case FALSE:
    case NOT:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case 47:
      expression = UnaryExpressionNotPlusMinus(symTable_p,errorTable_p);
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public OwExprExpression UnaryExpressionNotPlusMinus(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
OwExprExpression expression=null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
      jj_consume_token(NOT);
      expression = UnaryExpression(symTable_p,errorTable_p);
   expression=new OwExprUnaryExpression(symTable_p,errorTable_p,OwExprUnaryNegateOperator.INSTANCE,expression);
      break;
    case NULL:
    case TRUE:
    case FALSE:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case 47:
      expression = PrimaryExpression(symTable_p,errorTable_p);
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
   {if (true) return expression;}
    throw new Error("Missing return statement in function");
  }

  final public OwExprExpression PrimaryExpression(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
OwExprPrimaryPrefix prefix;
    prefix = PrimaryPrefix(symTable_p,errorTable_p);
    label_8:
    while (true) {
      if (jj_2_3(2)) {
        ;
      } else {
        break label_8;
      }
      prefix = PrimarySuffix(symTable_p,errorTable_p,prefix);
    }
       {if (true) return prefix.expression();}
    throw new Error("Missing return statement in function");
  }

  final public OwExprScopeSelector ScopeSelector(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p,OwExprPrimaryPrefix prefix_p) throws ParseException {
 Token t;
    jj_consume_token(46);
    t = jj_consume_token(IDENTIFIER);
                      {if (true) return new OwExprScopeSelector(symTable_p,errorTable_p,t.image,prefix_p);}
    throw new Error("Missing return statement in function");
  }

  final public OwExprPrimaryPrefix PrimaryPrefix(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
OwExprPrimaryPrefix prefix=null;
OwExprExpression expression;
Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NULL:
    case TRUE:
    case FALSE:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
      prefix = Literal(symTable_p,errorTable_p);
      break;
    case 47:
      prefix = StaticArray(symTable_p,errorTable_p);
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      expression = ConditionalExpression(symTable_p,errorTable_p);
      jj_consume_token(RPAREN);
   prefix=new OwExprPrimaryPrefixExpression(symTable_p,errorTable_p,new OwExprDebugBracketsExpression(symTable_p,errorTable_p,expression));
      break;
    default:
      if (jj_2_4(3)) {
        t = jj_consume_token(IDENTIFIER);
                  prefix=new OwExprScopeSelector(symTable_p,errorTable_p,t.image,prefix);
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    {if (true) return prefix;}
    throw new Error("Missing return statement in function");
  }

  final public OwExprPrimaryPrefix PrimarySuffix(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p,OwExprPrimaryPrefix prefix_p) throws ParseException {
OwExprPrimaryPrefix suffix=null;
OwExprExpression expression;
    if (jj_2_5(3)) {
      suffix = ScopeSelector(symTable_p,errorTable_p,prefix_p);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRACKET:
        jj_consume_token(LBRACKET);
        expression = ConditionalExpression(symTable_p,errorTable_p);
        jj_consume_token(RBRACKET);
   suffix=new OwExprArraySelectorSuffix(symTable_p,errorTable_p,prefix_p,expression);
        break;
      case LPAREN:
        suffix = Arguments(symTable_p,errorTable_p,prefix_p);
        break;
      default:
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  {if (true) return suffix;}
    throw new Error("Missing return statement in function");
  }

  final public OwExprStaticArray StaticArray(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
OwExprStaticArray exprArray;
OwExprExpression expression;
    if (jj_2_6(2)) {
      jj_consume_token(47);
      jj_consume_token(48);
             {if (true) return new OwExprStaticArray(symTable_p,errorTable_p);}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 47:
        jj_consume_token(47);
        expression = ConditionalExpression(symTable_p,errorTable_p);
                  exprArray=new OwExprStaticArray(symTable_p,errorTable_p);
                  exprArray.add(expression);
        label_9:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case 49:
            ;
            break;
          default:
            break label_9;
          }
          jj_consume_token(49);
          expression = ConditionalExpression(symTable_p,errorTable_p);
                                                                       exprArray.add(expression);
        }
        jj_consume_token(48);
          {if (true) return exprArray;}
        break;
      default:
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public OwExprLiteral Literal(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
Token literalToken;
OwExprLiteral literal;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      literalToken = jj_consume_token(INTEGER_LITERAL);
                                  {if (true) return OwExprIntegerLiteral.instance(literalToken.image,symTable_p,errorTable_p);}
      break;
    case FLOATING_POINT_LITERAL:
      literalToken = jj_consume_token(FLOATING_POINT_LITERAL);
                                         {if (true) return  OwExprFloatingPointLiteral.instance(literalToken.image,symTable_p,errorTable_p);}
      break;
    case STRING_LITERAL:
      literalToken = jj_consume_token(STRING_LITERAL);
                                 {if (true) return OwExprStringLiteral.instance(literalToken.image,symTable_p,errorTable_p);}
      break;
    case TRUE:
    case FALSE:
      literal = BooleanLiteral(symTable_p,errorTable_p);
                                                  {if (true) return literal;}
      break;
    case NULL:
      literal = NullLiteral(symTable_p,errorTable_p);
                                                {if (true) return literal;}
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public OwExprBooleanLiteral BooleanLiteral(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
      jj_consume_token(TRUE);
          {if (true) return  OwExprBooleanLiteral.instance(true,symTable_p,errorTable_p);}
      break;
    case FALSE:
      jj_consume_token(FALSE);
           {if (true) return OwExprBooleanLiteral.instance(false,symTable_p,errorTable_p);}
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public OwExprNullLiteral NullLiteral(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
    jj_consume_token(NULL);
          {if (true) return OwExprNullLiteral.instance(symTable_p,errorTable_p);}
    throw new Error("Missing return statement in function");
  }

  final public OwExprArgumentsSuffix Arguments(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p,OwExprPrimaryPrefix prefix_p) throws ParseException {
List arguments=new ArrayList();
    jj_consume_token(LPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NULL:
    case TRUE:
    case FALSE:
    case NOT:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case IDENTIFIER:
    case LPAREN:
    case PLUS:
    case MINUS:
    case 47:
      arguments = ArgumentList(symTable_p,errorTable_p);
      break;
    default:
      ;
    }
    jj_consume_token(RPAREN);
    {if (true) return new OwExprArgumentsSuffix(symTable_p,errorTable_p,prefix_p,arguments);}
    throw new Error("Missing return statement in function");
  }

  final public List ArgumentList(OwExprSymbolTable symTable_p,OwExprErrorTable errorTable_p) throws ParseException {
List arguments=new ArrayList();
OwExprExpression e;
    e = ConditionalExpression(symTable_p,errorTable_p);
                                                     arguments.add(e);
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 49:
        ;
        break;
      default:
        break label_10;
      }
      jj_consume_token(49);
      e = ConditionalExpression(symTable_p,errorTable_p);
                                                              arguments.add(e);
    }
    {if (true) return arguments;}
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
  }

  private boolean jj_3R_34() {
    if (jj_3R_38()) return true;
    return false;
  }

  private boolean jj_3R_23() {
    if (jj_3R_26()) return true;
    return false;
  }

  private boolean jj_3R_22() {
    if (jj_scan_token(LBRACKET)) return true;
    if (jj_3R_25()) return true;
    return false;
  }

  private boolean jj_3R_21() {
    if (jj_3R_24()) return true;
    return false;
  }

  private boolean jj_3_5() {
    if (jj_3R_20()) return true;
    return false;
  }

  private boolean jj_3R_19() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_5()) {
    jj_scanpos = xsp;
    if (jj_3R_22()) {
    jj_scanpos = xsp;
    if (jj_3R_23()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_29() {
    if (jj_3R_34()) return true;
    return false;
  }

  private boolean jj_3R_17() {
    if (jj_scan_token(GE)) return true;
    return false;
  }

  private boolean jj_3R_16() {
    if (jj_scan_token(LE)) return true;
    return false;
  }

  private boolean jj_3R_14() {
    if (jj_scan_token(LT)) return true;
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_scan_token(45)) return true;
    return false;
  }

  private boolean jj_3R_18() {
    if (jj_3R_21()) return true;
    return false;
  }

  private boolean jj_3_4() {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  private boolean jj_3_2() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_14()) {
    jj_scanpos = xsp;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_3R_17()) return true;
    }
    }
    }
    if (jj_3R_18()) return true;
    return false;
  }

  private boolean jj_3R_44() {
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  private boolean jj_3R_35() {
    if (jj_3R_25()) return true;
    return false;
  }

  private boolean jj_3R_43() {
    if (jj_3R_46()) return true;
    return false;
  }

  private boolean jj_3R_42() {
    if (jj_3R_45()) return true;
    return false;
  }

  private boolean jj_3R_30() {
    if (jj_3R_35()) return true;
    return false;
  }

  private boolean jj_3R_41() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_42()) {
    jj_scanpos = xsp;
    if (jj_3R_43()) {
    jj_scanpos = xsp;
    if (jj_3R_44()) {
    jj_scanpos = xsp;
    if (jj_3_4()) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_25() {
    if (jj_3R_29()) return true;
    return false;
  }

  private boolean jj_3R_26() {
    if (jj_scan_token(LPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_30()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3R_13() {
    if (jj_3R_18()) return true;
    return false;
  }

  private boolean jj_3R_20() {
    if (jj_scan_token(46)) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_3R_19()) return true;
    return false;
  }

  private boolean jj_3R_54() {
    if (jj_scan_token(NULL)) return true;
    return false;
  }

  private boolean jj_3R_12() {
    if (jj_scan_token(NE)) return true;
    return false;
  }

  private boolean jj_3R_56() {
    if (jj_scan_token(FALSE)) return true;
    return false;
  }

  private boolean jj_3R_11() {
    if (jj_scan_token(EQ)) return true;
    return false;
  }

  private boolean jj_3R_39() {
    if (jj_3R_41()) return true;
    return false;
  }

  private boolean jj_3R_55() {
    if (jj_scan_token(TRUE)) return true;
    return false;
  }

  private boolean jj_3R_53() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_55()) {
    jj_scanpos = xsp;
    if (jj_3R_56()) return true;
    }
    return false;
  }

  private boolean jj_3_1() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_11()) {
    jj_scanpos = xsp;
    if (jj_3R_12()) return true;
    }
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3R_51() {
    if (jj_3R_54()) return true;
    return false;
  }

  private boolean jj_3R_50() {
    if (jj_3R_53()) return true;
    return false;
  }

  private boolean jj_3R_40() {
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3R_37() {
    if (jj_3R_39()) return true;
    return false;
  }

  private boolean jj_3R_49() {
    if (jj_scan_token(STRING_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_48() {
    if (jj_scan_token(FLOATING_POINT_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_36() {
    if (jj_scan_token(NOT)) return true;
    return false;
  }

  private boolean jj_3R_47() {
    if (jj_scan_token(INTEGER_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_45() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_47()) {
    jj_scanpos = xsp;
    if (jj_3R_48()) {
    jj_scanpos = xsp;
    if (jj_3R_49()) {
    jj_scanpos = xsp;
    if (jj_3R_50()) {
    jj_scanpos = xsp;
    if (jj_3R_51()) return true;
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_33() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_36()) {
    jj_scanpos = xsp;
    if (jj_3R_37()) return true;
    }
    return false;
  }

  private boolean jj_3R_28() {
    if (jj_3R_33()) return true;
    return false;
  }

  private boolean jj_3R_38() {
    if (jj_3R_40()) return true;
    return false;
  }

  private boolean jj_3R_32() {
    if (jj_scan_token(MINUS)) return true;
    return false;
  }

  private boolean jj_3R_52() {
    if (jj_scan_token(47)) return true;
    return false;
  }

  private boolean jj_3R_31() {
    if (jj_scan_token(PLUS)) return true;
    return false;
  }

  private boolean jj_3R_46() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_6()) {
    jj_scanpos = xsp;
    if (jj_3R_52()) return true;
    }
    return false;
  }

  private boolean jj_3R_27() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_31()) {
    jj_scanpos = xsp;
    if (jj_3R_32()) return true;
    }
    return false;
  }

  private boolean jj_3_6() {
    if (jj_scan_token(47)) return true;
    if (jj_scan_token(48)) return true;
    return false;
  }

  private boolean jj_3R_24() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_27()) {
    jj_scanpos = xsp;
    if (jj_3R_28()) return true;
    }
    return false;
  }

  /** Generated Token Manager. */
  public OwExprParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;

  /** Constructor with InputStream. */
  public OwExprParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public OwExprParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new OwExprParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
  }

  /** Constructor. */
  public OwExprParser(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new OwExprParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
  }

  /** Constructor with generated Token Manager. */
  public OwExprParser(OwExprParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
  }

  /** Reinitialise. */
  public void ReInit(OwExprParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      return token;
    }
    token = oldToken;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    Token errortok = token.next;
    int line = errortok.beginLine, column = errortok.beginColumn;
    String mess = (errortok.kind == 0) ? tokenImage[0] : errortok.image;
    return new ParseException("Parse error at line " + line + ", column " + column + ".  Encountered: " + mess);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
