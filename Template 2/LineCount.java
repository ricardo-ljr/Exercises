import java.io.*;
import java.util.*;
import java.util.regex.*;

public class LineCount extends Template {

	
	public LineCount(String directory, String pattern, boolean recurse) {
		super(directory, pattern, recurse);

	}

	@Override
	protected void run() {
		super.run();
		System.out.println("TOTAL: " + _count);
	}
	
	private void countLinesInDir(File dir) {
		if (dir.isDirectory())
		{
			if (dir.canRead())
			{
				for (File file : dir.listFiles()) {
					if (file.isFile()) {
						if (file.canRead()) {
							searchFile(file);
						}
						else {
							System.out.println("File " + file + " is unreadable");
						}
					}
				}
					
				if (_recurse) {
					for (File file : dir.listFiles()) {
						if (file.isDirectory()) {
							countLinesInDir(file);
						}
					}
				}
			}
			else {
				System.out.println("Directory " + dir + " is unreadable");
			}
		}
		else {
			System.out.println(dir + " is not a directory");
		}
	}

	@Override
	public void searchFile(File file) {
		String fileName = getFileName(file);
		_fileMatcher.reset(fileName);
		if (_fileMatcher.find()) {
			try {
				Reader reader = new BufferedReader(new FileReader(file));
				int curLineCount = 0;
				try {
					curLineCount = 0;		
					Scanner input = new Scanner(reader);
					while (input.hasNextLine()) {
						String line = input.nextLine();											
						++curLineCount;
						++_count;
					}
				}
				finally {
					System.out.println(curLineCount + "  " + file);					
					reader.close();
				}
			}
			catch (IOException e) {
				System.out.println("File " + file + " is unreadable");
			}
		}
	}

	
	public static void main(String[] args) {
		String directory = "";
		String pattern = "";
		boolean recurse = false;
		String usage = "USAGE: java FileSearch {-r} <dir> <file-pattern> <search-pattern>";
		
		if (args.length == 2) {
			recurse = false;
			directory = args[0];
			pattern = args[1];
		}
		else if (args.length == 3 && args[0].equals("-r")) {
			recurse = true;
			directory = args[1];
			pattern = args[2];
		}
		else {
			usage(usage);
			return;
		}
		
		LineCount lineCounter = new LineCount(directory, pattern, recurse);
		lineCounter.run();
	}


}
