package ata.usingstacksandqueues.amazonjava;

import com.amazon.ata.input.file.ATAFileReader;

import org.apache.commons.lang3.StringUtils;

import java.net.URL;
import java.util.List;

/**
 * A compiler for Amazon's version of Java. The first check the compiler will make is if the curly braces in
 * the provided Java file are balanced. For every opening curly brace '{' in the file, the file must also contain a
 * closing curly brace, '}'. Further checks will be added at a later date.
 */
public class AmazonJavaFileCompiler {

    private List<Character> fileChars;
    private BalancedCurlyBraceValidator balancedCurlyBraceValidator = new BalancedCurlyBraceValidator();

    public AmazonJavaFileCompiler(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            throw new IllegalArgumentException("Path to java file must not be null or empty!");
        }

        this.fileChars =  new ATAFileReader(filePath).readCharacters();
    }

    /**
     * Apply any compilation rules and return a boolean value indicating whether the file compiles.
     * @return true if the file passes all of the compilation checks, false otherwise
     */
    public boolean compile() {
        // TODO: uncomment to enable debug mode
         balancedCurlyBraceValidator.setDebug(true);
        return balancedCurlyBraceValidator.check(fileChars);
    }

    public static void main(String[] args) {
        ClassLoader classLoader = AmazonJavaFileCompiler.class.getClassLoader();
        classLoader.getResource("ValidClass.java");
        URL validClassUrl = classLoader.getResource("ValidClass.java");
        URL invalidClassUrl = classLoader.getResource("InvalidClass.java");
        URL anotherInvalidClassUrl = classLoader.getResource("AnotherInvalidClass.java");

        run(validClassUrl);
        run(invalidClassUrl);
        run(anotherInvalidClassUrl);
    }

    private static void run(URL url) {

        if (url == null) {
            throw new IllegalStateException(
                "Could not access Java file in resources! Please check with an instructor.");
        }

        AmazonJavaFileCompiler file1Compiler = new AmazonJavaFileCompiler(url.getPath());
        if(file1Compiler.compile()) {
            System.out.println("Successfully compiled file: " + url.getPath());
        }
        else {
            System.out.println("ERROR: Unable to compile file: " + url.getPath());
        }
    }
}
