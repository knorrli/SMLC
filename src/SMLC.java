/* SMLC.java */
/* Generated By:JavaCC: Do not edit this line. SMLC.java */
        package smlc;

        import java.io.PrintStream ;

        public class SMLC implements SMLCConstants {
                public static void main(String args []) throws ParseException, TokenMgrError {
                        SMLC parser = new SMLC( System.in ) ;
                        System.out.println("Welcome to SMLI V2 - The Interactive SML Parser");
                        System.out.println("Please enter your SML expression");
                        System.out.print("=? ");

                        parser.Start(System.out) ;
                }

/* specify the parser */
  final public 
void Start(PrintStream printStream) throws ParseException, NumberFormatException {double value;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OPAR:
      case SIN:
      case COS:
      case TAN:
      case PLUS:
      case MINUS:
      case MULT:
      case DIV:
      case POWER:
      case NUMBER:
      case EOL:
      case HELP:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OPAR:
      case SIN:
      case COS:
      case TAN:
      case PLUS:
      case MINUS:
      case MULT:
      case DIV:
      case POWER:
      case NUMBER:
      case EOL:{
        value = Expression();
        jj_consume_token(EOL);
printStream.println( "=> " + value );
printStream.print("=? ");
        break;
        }
      case HELP:{
        jj_consume_token(HELP);
        jj_consume_token(EOL);
printStream.println("HELP - SMLI Spec:");
printStream.println("add: 'r1 + r2'");
printStream.println("subtract: 'r1 - r2'");
printStream.println("multiply: 'r1 * r2'");
printStream.println("divide: 'r1 / r2'");
printStream.println("quit: 'q'");
printStream.print("=? ");
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case QUIT:{
      jj_consume_token(QUIT);
printStream.println("Goodbye");
      break;
      }
    case 0:{
      jj_consume_token(0);
printStream.println("Goodbye");
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/* Expression: Consists of Operands (arguments of +|- operation) */
  final public double Expression() throws ParseException, NumberFormatException {double i ;
        double value ;
    value = MultExpression();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:
      case MINUS:{
        ;
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:{
        jj_consume_token(PLUS);
        i = MultExpression();
value = value + i ;
        break;
        }
      case MINUS:{
        jj_consume_token(MINUS);
        i = MultExpression();
value = value - i ;
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
{if ("" != null) return value ;}
    throw new Error("Missing return statement in function");
  }

/* Operand: consists of Factors (arguments of *|/ operation) */
  final public double MultExpression() throws ParseException, NumberFormatException {double i ;
        double value ;
    value = PowExpression();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case MULT:
      case DIV:{
        ;
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case MULT:{
        jj_consume_token(MULT);
        i = PowExpression();
value = value * i ;
        break;
        }
      case DIV:{
        jj_consume_token(DIV);
        i = PowExpression();
value = value / i ;
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
{if ("" != null) return value ;}
    throw new Error("Missing return statement in function");
  }

/* PowExpression: a TrigExpression to the power of the result of a trig expression */
  final public double PowExpression() throws ParseException, NumberFormatException {double power ;
        double value ;
    value = TrigExpression();
    label_4:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_4;
      }
      jj_consume_token(POWER);
      power = PowExpression();
value =  Math.pow(value, power) ;
    }
{if ("" != null) return value ;}
    throw new Error("Missing return statement in function");
  }

  final public double TrigExpression() throws ParseException, NumberFormatException {double value ;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case OPAR:
    case MINUS:
    case NUMBER:{
      value = Num();
{if ("" != null) return value;}
      break;
      }
    default:
      jj_la1[9] = jj_gen;
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case SIN:
        case COS:
        case TAN:{
          ;
          break;
          }
        default:
          jj_la1[7] = jj_gen;
          break label_5;
        }
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case SIN:{
          jj_consume_token(SIN);
          value = Num();
{if ("" != null) return Math.sin(value);}
          break;
          }
        case COS:{
          jj_consume_token(COS);
          value = Num();
{if ("" != null) return Math.cos(value);}
          break;
          }
        case TAN:{
          jj_consume_token(TAN);
          value = Num();
{if ("" != null) return Math.tan(value);}
          break;
          }
        default:
          jj_la1[8] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public double Num() throws ParseException, NumberFormatException {Token t ;
        double value ;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NUMBER:{
      t = jj_consume_token(NUMBER);
value = Double.parseDouble (t.image);
{if ("" != null) return value ;}
      break;
      }
    case OPAR:{
      jj_consume_token(OPAR);
      value = Expression();
      jj_consume_token(CPAR);
{if ("" != null) return value ;}
      break;
      }
    case MINUS:{
      jj_consume_token(MINUS);
      t = jj_consume_token(NUMBER);
value = (Double.parseDouble(t.image) * -1);
{if ("" != null) return value ;}
      break;
      }
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3R_14()
 {
    if (jj_scan_token(MINUS)) return true;
    return false;
  }

  private boolean jj_3R_16()
 {
    if (jj_scan_token(COS)) return true;
    return false;
  }

  private boolean jj_3R_6()
 {
    if (jj_3R_7()) return true;
    return false;
  }

  private boolean jj_3R_15()
 {
    if (jj_scan_token(SIN)) return true;
    return false;
  }

  private boolean jj_3R_13()
 {
    if (jj_scan_token(OPAR)) return true;
    return false;
  }

  private boolean jj_3R_11()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_3R_17()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_9()
 {
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_11()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_10()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_12()) {
    jj_scanpos = xsp;
    if (jj_3R_13()) {
    jj_scanpos = xsp;
    if (jj_3R_14()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_12()
 {
    if (jj_scan_token(NUMBER)) return true;
    return false;
  }

  private boolean jj_3R_7()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_8()) {
    jj_scanpos = xsp;
    if (jj_3R_9()) return true;
    }
    return false;
  }

  private boolean jj_3R_8()
 {
    if (jj_3R_10()) return true;
    return false;
  }

  private boolean jj_3_1()
 {
    if (jj_scan_token(POWER)) return true;
    if (jj_3R_6()) return true;
    return false;
  }

  private boolean jj_3R_17()
 {
    if (jj_scan_token(TAN)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public SMLCTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[11];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xdff4,0xdff4,0x10001,0x180,0x180,0x600,0x600,0x70,0x70,0x1104,0x1104,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public SMLC(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public SMLC(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new SMLCTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
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
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public SMLC(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new SMLCTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public SMLC(SMLCTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(SMLCTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  @SuppressWarnings("serial")
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
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
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
    jj_gen++;
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

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[17];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 11; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 17; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

        }
