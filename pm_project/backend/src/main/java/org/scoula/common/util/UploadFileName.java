package org.scoula.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class UploadFileName {
    public static String getUniqueName(String filename) {

        int ix = filename.lastIndexOf(".");
        String name = filename.substring(0, ix);		// 파일명 추출
        String ext =  filename.substring(ix+1);		// 확장명 추출

        return String.format("%s-%d.%s", name, System.currentTimeMillis(), ext);
    }
}
