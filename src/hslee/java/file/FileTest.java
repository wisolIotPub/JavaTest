package hslee.java.file;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		new FileTest();
	}

	public FileTest() {
		listupFiles("d:\\javaFile");
	}
	
	private void listupFiles(String pPath){
		File pDir = makeDir(pPath);
		File file=new File(pDir,"fileName.json");
		String n="";
		
		FilenameFilter filter = new FilenameFilter() {
			
			public boolean accept(File arg0, String arg1) {
				return arg1.endsWith(".txt");
			}
		};
		
		for(File pFile:pDir.listFiles(filter)){
			n+=pFile.getName()+"\n";
			System.out.println(pFile.getAbsolutePath());
		}
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(n);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void makeDummyFiles(int pFileCount) {
		File pDir = makeDir("d:\\javaFile");
		try {

			for (int i = 0; i < pFileCount; i++) {
				FileWriter fw = new FileWriter(new File(pDir, "t" + String.valueOf(i) + ".txt"));

				for (int j = 0; j < (1500); j++) {
					fw.write(String.valueOf(j) + " : file write test\r\n");
				}
				fw.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private File makeDir(String path) {
		File pFile = null;

		pFile = new File(path);
		if (pFile.exists()) {
			System.out.println("folder is exist");
		} else {
			pFile.mkdirs();
		}

		return pFile;
	}

}
