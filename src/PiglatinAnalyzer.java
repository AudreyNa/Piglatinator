import java.util.Scanner;
/**
   Translates to pig latin

   @author  Audrey Na
   @version 10/20/23
   @author  Period - 5
   @author  Assignment - PigLatinator

   @author  Sources - TODO list collaborators
 */
public class PiglatinAnalyzer
{
    private String text;

    // Constructor: saves the text string
    public PiglatinAnalyzer(String text)
    {
        this.text = text;
    }

    /**
     * Converts a string to it piglatin form according to the following rules:
     *   a. If there are no vowels in englishWord, then pigLatinWord is just
     *      englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o',
     *      and 'u', and their uppercase counterparts.)
     *   b. Else, if englishWord begins with a vowel, then pigLatinWord is just
     *      englishWord + "yay".
     *   c. Otherwise (if englishWord has a vowel in it and yet doesn't start
     *      with a vowel), then pigLatinWord is end + start + "ay", where end
     *      and start are defined as follows:
     *        1. Let start be all of englishWord up to (but not including) its
     *           first vowel.
     *        2. Let end be all of englishWord from its first vowel on.
     *        3. But, if englishWord is capitalized, then capitalize end and
     *           "uncapitalize" start.
     *
     * @return   piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        text+=" ";
        String result ="";
        String word;

        int start = 0;

        int i = 0;

        while (i<text.length())
        {
            while (Character.isLetter(text.charAt(i)) == true && i < text.length())
            {
                i++;
            }
            word = wordToPigLatin(text.substring(start, i)); //start of word
            result += word;
            start = i;
            while (i < text.length() && Character.isLetter(text.charAt(i)) == false)
            {
                i++;
            }
            result += text.substring(start, i);
            start = i;
        }
        
        return result.substring(0,result.length()-1);
    }

    /**
     *  Converts an "english" word to its piglatin form
     *
     * @param  englishWord  a string representing an english word
     * @return              piglatin form of the english word
     */
    public String wordToPigLatin(String englishWord)
    {
        
        String pigLatinWord = "";
        String temp = englishWord.toLowerCase();
        int vowelValue;

        for (int i = 0; i < temp.length(); i++) 
        {
            if(temp.charAt(i) == 'a'|| temp.charAt(i) == 'e'|| temp.charAt(i) == 'i' || temp.charAt(i) == 'o' || temp.charAt(i) == 'u')
            {
                temp = temp.substring(0, i) + "#" + temp.substring(i + 1);
            }
        }

        vowelValue=temp.indexOf("#");

        if (englishWord.length()>0 && (Character.isLetter(englishWord.charAt(0))==true))
        {
            if (vowelValue == 0)
            {
                pigLatinWord = englishWord + "yay";
            }
            else if (vowelValue == -1)
            {
                pigLatinWord = englishWord + "ay";
            }
            else 
            {
                pigLatinWord = englishWord.substring(vowelValue) + englishWord.substring(0,vowelValue) + "ay";
            }
        }
        else {pigLatinWord=englishWord;}

        pigLatinWord = pigLatinWord.toLowerCase();
        if (englishWord.length()>0 && Character.isUpperCase(englishWord.charAt(0))==true)
        {
            pigLatinWord = Character.toUpperCase(pigLatinWord.charAt(0))+ pigLatinWord.substring(1);
        }

        return pigLatinWord;
    }
}









