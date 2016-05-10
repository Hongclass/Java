import java.util.Scanner;   
import java.util.Stack;   
  
 class SimpleCalculator {   
    public  double calculate(String input) {   
        initialize();   
  
        this.scanner = new Scanner(input);   
        this.scanner.useDelimiter("\\s+|(?=[.0-9])(?<![.0-9])|(?![.0-9])(?<=[.0-9])|(?![.0-9])(?<![.0-9])");   
        Token currentToken = nextToken();   
        Token t = null;   
        while (null != currentToken) {   
            switch (currentToken.getKind()) {   
            case NUMBER:   
                this.eval.push(currentToken.getValue());   
                break;   
            case LPAREN:   
                this.ops.push(currentToken);   
                break;   
            case RPAREN:   
                for (t = this.ops.pop();   
                     TokenKind.LPAREN != t.getKind();   
                     t = this.ops.pop()) {   
                    if (ops.empty()) throw new Error("Syntax Error: unmatched parenthesis");   
                       
                    doOperation(t);   
                }   
                break;   
            default:   
                if (!ops.empty()) {   
                    for (t = this.ops.pop();   
                         currentToken.getKind().getPriority() < t.getKind().getPriority();   
                         t = this.ops.pop()) {                           
                        doOperation(t);   
                        if (this.ops.empty()) {   
                            t = null;   
                            break;   
                        }   
                    }   
                }   
                if (null != t) ops.push(t);   
                ops.push(currentToken);   
                break;   
            }   
                 
            // reinitialize   
            currentToken = nextToken();   
        }   
        while (!ops.empty()) {   
            t = this.ops.pop();   
            doOperation(t);   
        }   
           
        return this.eval.pop();   
    }   
       
    private void initialize() {   
        if (null == this.eval) this.eval = new Stack<Double>();   
        if (null == this.ops) this.ops = new Stack<Token>();   
        this.eval.clear();   
        this.ops.clear();   
    }   
       
    private Token nextToken() {   
        Token t = null;   
        if (this.scanner.hasNextDouble()) {   
            t = new Token(TokenKind.NUMBER, this.scanner.nextDouble());   
        } else if (this.scanner.hasNext()) {   
            String s = this.scanner.next("[-+*/()]");   
            if ("+".equals(s)) {   
                t = new Token(TokenKind.ADD);   
            } else if ("-".equals(s)) {   
                t = new Token(TokenKind.SUBTRACT);   
            } else if ("*".equals(s)) {   
                t = new Token(TokenKind.MULTIPLY);   
            } else if ("/".equals(s)) {   
                t = new Token(TokenKind.DIVIDE);   
            } else if ("(".equals(s)) {   
                t = new Token(TokenKind.LPAREN);   
            } else if (")".equals(s)) {   
                t = new Token(TokenKind.RPAREN);   
            }   
        }   
        return t;   
    }   
       
    private void doOperation(Token t) {   
        double y = this.eval.pop();   
        double x = this.eval.pop();   
        double temp = t.getKind().doOperation(x, y);   
        this.eval.push(temp);   
    }   
       
    private Scanner scanner;   
    private Stack<Double> eval;   
    private Stack<Token> ops;   
  
    public static void main(String[] args) {   
         
        double result = new SimpleCalculator().calculate("1+2*(3/5)");
        System.out.println(result);   
    }   
}   
  
enum TokenKind {   
    // operators   
    ADD(1) {   
        public double doOperation(double x, double y) {   
            return x + y;   
        }   
    },   
    SUBTRACT(1) {   
        public double doOperation(double x, double y) {   
            return x - y;   
        }   
    },   
    MULTIPLY(2) {   
        public double doOperation(double x, double y) {   
            return x * y;   
        }   
    },   
    DIVIDE(2) {   
        public double doOperation(double x, double y) {   
            return x / y;   
        }   
    },   
  
    // punctuation   
    LPAREN(0),   
    RPAREN(0),   
  
    // number   
    NUMBER(0);   
     
    TokenKind(int priority) {   
        this.priority = priority;   
    }   
       
    public int getPriority() {   
        return this.priority;   
    }   
       
    public double doOperation(double x, double y) {   
        return Double.NaN; // dummy, operation not supported   
    }   
       
    private int priority;   
}   
  
class Token {   
    public Token(TokenKind kind) {   
        this(kind, Double.NaN);   
    }   
  
    public Token(TokenKind kind, double value) {   
        this.kind = kind;   
        this.value = value;   
    }   
       
    public TokenKind getKind() {   
        return this.kind;   
    }   
       
    public double getValue() {   
        return this.value;   
    }   
  
    private TokenKind kind;   
    private double value;   
}  