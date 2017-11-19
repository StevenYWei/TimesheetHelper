package utils;

import java.io.File;
import java.io.FilenameFilter;

public class FileManagement {

    private static String[] fullName;

    /**
     * Return the absolution path of the file
     *
     * @param fileName of the file to be upload
     * @return path as string
     */
    public static String getFileAbsolutePath(String fileName) {
        String root = new File(".").getAbsolutePath();
        root = root.substring(0, root.length() - 2);
        File dir = new File(root);
        fullName = fileName.split("\\.");
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                if (fullName.length == 2) {
                    return name.startsWith(fullName[0]) && name.endsWith(fullName[1]);
                } else if (fullName.length == 1) {
                    return name.startsWith(fullName[0]);
                }
                return false;
            }
        };
        File[] files = dir.listFiles(filter);
        return ((files != null) && (files.length > 0)) ? files[0].getAbsolutePath() : null;
    }

}
