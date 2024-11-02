package String;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class RemoveSubFolderFromFileSystem {
    public static void main(String[] args) {
//        folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
    }

    public static List<String> removeSubfolders(String[] folder) {

        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
        List<String> result = new ArrayList<>();

        // Iterate over each folder in the array
        for (String currFolder : folder) {
            boolean isSubFolder = false;
            String tempFolder = currFolder;

            // Continue until currFolder is empty
            while (!currFolder.isEmpty()) {
                int position = currFolder.lastIndexOf('/');  // Find the last occurrence of '/'
                if (position == -1) break;  // Exit if there are no more '/' characters

                currFolder = currFolder.substring(0, position);  // Get the parent folder

                // Check if the parent folder exists in the set
                if (folderSet.contains(currFolder)) {
                    isSubFolder = true;  // It is a sub-folder
                    break;
                }
            }

            // If it's not a sub-folder, add it to the result list
            if (!isSubFolder) {
                result.add(tempFolder);
            }

        }

        return result;
    }
}
