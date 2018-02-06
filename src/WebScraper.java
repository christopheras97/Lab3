import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(String file) {
        file = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] wordArray = file.split("[\t\n!@#$%^&*()\\-_+\\[{\\]};:' `~=?.,<>/|]+");
        int count = 0;
        for (int i = 0; i < wordArray.length; i++) {
            count++;
        }
        return count;
    }

    public static int specificWordCount(String word) {
        String file = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] wordArray = file.split("[\t\n!@#$%^&*()\\-_+\\[{\\]};:' `~=?.,<>/|]+");
        int count = 0;
        for (int j = 0; j < wordArray.length; j++) {
            wordArray[j] = wordArray[j].toLowerCase();
            if (wordArray[j] == word) {
                count += 1;
            }
        }
        return count;
    }
    public static void main(String[] unused) {
        String fileToAccess = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(wordCount(fileToAccess));
        String theWord = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Word to look for?" + theWord);
        theWord = input.nextLine();
        System.out.println(specificWordCount(theWord));
    }
}
