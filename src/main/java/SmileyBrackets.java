import java.util.Stack;

public class SmileyBrackets {

    private static String checkMessage(String line) {
        line = replaceSmileys(line);
        Stack<Character> parens = new Stack();
        Stack<Character> smileys = new Stack();
        char[] charray = line.toCharArray();
        for(char c : charray) {
            if (c == '('){
                parens.push(c);
            } else if (c == '}'){
                smileys.push(c);
            } else if (c == ')'){
                if (parens.isEmpty()){
                    return "NO";
                }
                parens.pop();
            }
        }
        if (parens.size() == smileys.size()){
            return "YES";
        } else if (parens.isEmpty()){
            return "YES";
        }
        return "NO";
    }

    private static String replaceSmileys(String line) {
        line = line.replaceAll("}", "");
        line = line.replaceAll(":\\)", "}");
        line = line.replaceAll(":\\(", "");
        return line;
    }


    public static void main(String[] args) {
        System.out.println(checkMessage("(:)"));
        System.out.println(checkMessage(":)"));
        System.out.println(checkMessage(")"));
        System.out.println(checkMessage("("));
        System.out.println(checkMessage("(:)))"));
        System.out.println(checkMessage("(:fjgj::sfgjs)"));
        System.out.println(checkMessage("(:)"));
        System.out.println(checkMessage("(:})"));
        System.out.println(checkMessage("(()"));
        System.out.println(checkMessage("((:)"));
        System.out.println(checkMessage("(:):):):):))"));
    }



}
