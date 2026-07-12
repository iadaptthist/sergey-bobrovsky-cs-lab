import java.util.*;

public class Level1
{
    public static int PrintingCosts(String Line)
      {
        java.util.HashMap<Character, Integer> tonerCosts = new java.util.HashMap<>();

        tonerCosts.put(' ',  0); tonerCosts.put('!',  9); tonerCosts.put('"',  6); tonerCosts.put('#', 24); tonerCosts.put('$', 29); tonerCosts.put('%', 22);
        tonerCosts.put('&', 24); tonerCosts.put('\'', 3); tonerCosts.put('(', 12); tonerCosts.put(')', 12); tonerCosts.put('*', 17); tonerCosts.put('+', 13);
        tonerCosts.put(',',  7); tonerCosts.put('-',  7); tonerCosts.put('.',  4); tonerCosts.put('/', 10); tonerCosts.put('0', 22); tonerCosts.put('1', 19);
        tonerCosts.put('2', 22); tonerCosts.put('3', 23); tonerCosts.put('4', 21); tonerCosts.put('5', 27); tonerCosts.put('6', 26); tonerCosts.put('7', 16);
        tonerCosts.put('8', 23); tonerCosts.put('9', 26); tonerCosts.put(':',  8); tonerCosts.put(';', 11); tonerCosts.put('<', 10); tonerCosts.put('=', 14);
        tonerCosts.put('>', 10); tonerCosts.put('?', 15); tonerCosts.put('@', 32); tonerCosts.put('A', 24); tonerCosts.put('B', 29); tonerCosts.put('C', 20);
        tonerCosts.put('D', 26); tonerCosts.put('E', 26); tonerCosts.put('F', 20); tonerCosts.put('G', 25); tonerCosts.put('H', 25); tonerCosts.put('I', 18);
        tonerCosts.put('J', 18); tonerCosts.put('K', 21); tonerCosts.put('L', 16); tonerCosts.put('M', 28); tonerCosts.put('N', 25); tonerCosts.put('O', 26);
        tonerCosts.put('P', 23); tonerCosts.put('Q', 31); tonerCosts.put('R', 28); tonerCosts.put('S', 25); tonerCosts.put('T', 16); tonerCosts.put('U', 23);
        tonerCosts.put('V', 19); tonerCosts.put('W', 26); tonerCosts.put('X', 18); tonerCosts.put('Y', 14); tonerCosts.put('Z', 22); tonerCosts.put('[', 18);
        tonerCosts.put('\\', 10); tonerCosts.put(']', 18); tonerCosts.put('^',  7); tonerCosts.put('_',   8); tonerCosts.put('`',  3); tonerCosts.put('a', 23);
        tonerCosts.put('b', 25); tonerCosts.put('c', 17); tonerCosts.put('d', 25); tonerCosts.put('e', 23); tonerCosts.put('f', 18); tonerCosts.put('g', 30);
        tonerCosts.put('h', 21); tonerCosts.put('i', 15); tonerCosts.put('j', 20); tonerCosts.put('k', 21); tonerCosts.put('l', 16); tonerCosts.put('m', 22);
        tonerCosts.put('n', 18); tonerCosts.put('o', 20); tonerCosts.put('p', 25); tonerCosts.put('q', 25); tonerCosts.put('r', 13); tonerCosts.put('s', 21);
        tonerCosts.put('t', 17); tonerCosts.put('u', 17); tonerCosts.put('v', 13); tonerCosts.put('w', 19); tonerCosts.put('x', 13); tonerCosts.put('y', 24);
        tonerCosts.put('z', 19); tonerCosts.put('{', 18); tonerCosts.put('|', 12); tonerCosts.put('}', 18); tonerCosts.put('~',  9);

        int totalTonerCost = 0;
        for(int i = 0; i < Line.length(); i++) {
            totalTonerCost += tonerCosts.getOrDefault(Line.charAt(i), 23);
        }
        return totalTonerCost;
    }
}

