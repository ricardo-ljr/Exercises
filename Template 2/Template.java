import java.io.*;
import java.util.*;
import java.util.regex.*;

public abstract class Template {

    protected String _dirName;
    protected String _filePattern;
    protected boolean _recurse;

    protected Matcher _fileMatcher;
    protected Matcher _searchMatcher;
    protected int _count;


    public Template(String dirName, String filePattern, boolean recurse) {
        _dirName = dirName;
        _filePattern = filePattern;
        _recurse = recurse;
        _fileMatcher = Pattern.compile(_filePattern).matcher("");
        _count = 0;

    }

    protected void searchDirectory(File dir) {
        if (!dir.isDirectory()) {
            nonDir(dir);
            return;
        }

        if (!dir.canRead()) {
            unreadableDir(dir);
            return;
        }

        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    searchFile(file);
                }
                else {
                    unreadableFile(file);
                }
            }
        }

        if (_recurse) {
            for (File file : dir.listFiles()) {
                if (file.isDirectory()) {
                    searchDirectory(file);
                }
            }
        }
    }


    protected void run() {
        searchDirectory(new File(_dirName));
    }

    protected void nonDir(File dir) {
        System.out.println(dir + " is not a directory");
    }

    protected void unreadableDir(File dir) {
        System.out.println("Directory " + dir + " is unreadable");
    }

    protected void unreadableFile(File file) {
        System.out.println("File " + file + " is unreadable");
    }

    protected String getFileName(File file) {
        try {
            return file.getCanonicalPath();
        }
        catch (IOException e) {
            return "";
        }
    }

    public static void usage(String usage) {
        System.out.println(usage);
    }

    public void searchFile(File file) {};


}
