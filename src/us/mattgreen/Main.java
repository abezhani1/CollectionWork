package us.mattgreen;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String line;
        String[] words;
        Object wordFound;
     //   String[] fields;

        while ((line = indata.fileReadLine()) != null) {
            line=line.replace(",","").replace(".","")
                    .replace(";","").replace(":","")
                    .replace("'","").replace("\"","")
                    .replace("-","").replace("!","")
                    .replace("#","").replace("(","")
                    .replace(")","").replace("?","")
                    .replace("_","").replace("?","")
                    .toLowerCase().trim();
            words = line.split(" ");
            for (String s:words) {
                wordFound = map.get(s);
                if (wordFound == null) {
                    map.put(s, new Integer(1));
                }
                else {
                    map.put(s, map.get(s) + 1);
                }

            }

            //for (Map.Entry<String, Integer> entry : map.entrySet())
            //{
            //      System.out.println(entry.getKey() + " " + entry.getValue());
            //}
        }

        int wordsUsedOnc = 0;
        int wordsUsedMst = 0;
        String mostUsedWrd = "";

        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            //System.out.println(entry.getKey() + " " + entry.getValue());
            if(entry.getValue() > wordsUsedMst)
            {
                wordsUsedMst = entry.getValue();
                mostUsedWrd = entry.getKey();
            }
            if(entry.getValue() == 1)
            {
                wordsUsedOnc++;
            }

        }

        System.out.println("The most used word is: " + mostUsedWrd + " at " + wordsUsedMst + " times");
        System.out.println("The number of words used once is: " + wordsUsedOnc);
    }
    
}