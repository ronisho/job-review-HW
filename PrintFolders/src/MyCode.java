import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCode {

	public static void AddFoldersToList(File[] listOfFiles, List<String> foldersPathList) {
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isDirectory()) {
				foldersPathList.add(listOfFiles[i].getPath());
			}
		}
	}
	
	public static void main(String[] args) {
		//Override toString of map.
		@SuppressWarnings("serial")
		Map<String, File[]> filesMap = new HashMap<String, File[]>() {
			@Override
			public String toString() {
			  StringBuilder stb = new StringBuilder();
			  for(Entry<String, File[]> entry : entrySet()) {
				  stb.append(entry.getKey()).append("\n");
				  if (entry.getValue().length == 0) stb.append("	The folder is empty!!!\n");
				  for(File file : entry.getValue()) {
					  stb.append("	" + file.getPath() + "\n");
				  }
			  } 
			  return stb.toString();
			}
		}; 
		
		List<String> foldersPathList = new ArrayList<String>();
		foldersPathList.add(args[0]); //Add the root directory path(Came from arguments).
		for (int j = 0; j < foldersPathList.size(); j++) { //Go over all the folders (This list update in AddFoldersToList func)
			File folder = new File(foldersPathList.get(j));
			File[] listOfFiles = folder.listFiles();
			AddFoldersToList(listOfFiles, foldersPathList);
			filesMap.put(foldersPathList.get(j), listOfFiles);
		}
		System.out.println(filesMap.toString());
	}
}
