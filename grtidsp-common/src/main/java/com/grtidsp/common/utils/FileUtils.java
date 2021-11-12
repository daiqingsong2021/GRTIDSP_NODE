package com.grtidsp.common.utils;

import com.grtidsp.common.common.MyException;
import com.grtidsp.common.constants.GrtidspErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.overviewproject.mime_types.GetBytesException;
import org.overviewproject.mime_types.MimeTypeDetector;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件通用类
 *
 * @author daiqingsong
 * @Date 2021/10
 */
@Slf4j
public class FileUtils {
    private static MimeTypeDetector mimeTypeDetector = new MimeTypeDetector();

    /**
     * 用户下载功能，下载Excel
     **/
    public static void download(String filename, InputStream in, HttpServletResponse response) throws Exception {
        response.setContentType(mimeTypeDetector.detectMimeType(filename, in));
        // 设置Content-Disposition
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        OutputStream fileOutputStream = response.getOutputStream();
        // 创建缓冲区
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer)) > 0) {
            fileOutputStream.write(buffer, 0, len);
        }
        in.close();
        fileOutputStream.close();
        fileOutputStream.flush();
    }

    /**
     * 图片上传
     **/
    public static void pictureUpload(String fileName, String path, InputStream fileInputStream) throws Exception {
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        List<String> suffixs = new ArrayList<>();
        suffixs.add(".jpg");
        suffixs.add(".gif");
        suffixs.add(".png");
        suffixs.add(".bmp");
        suffixs.add(".jpeg");
        OutputStream fileOutputStream = null;
        try {
            if (suffixs.stream().noneMatch(x -> suffix.toLowerCase().equals(x))) {
                throw new MyException(GrtidspErrorCode.FILE_SUFFIX_ERROR);
            }
            String mimeType = mimeTypeDetector.detectMimeType(fileName, fileInputStream);
            Map<String, String> headerMap = new HashMap<>();
            headerMap.put("Content-Type", mimeType);
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            File pathName = new File(path + fileName);
            fileOutputStream = new FileOutputStream(pathName);
            // 创建缓冲区
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (GetBytesException e) {
            e.printStackTrace();
        } catch (IOException e) {
            log.error("图片上传异常：", e);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Exception e) {
                log.error("流关闭异常", e);
            }
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Exception e) {
                log.error("流关闭异常", e);
            }

        }

    }

    /**
     * 文件上传
     **/
    public static void fUpload(String fileName, String path, InputStream fileInputStream) throws Exception {
        OutputStream fileOutputStream = null;
        try {
            String mimeType = mimeTypeDetector.detectMimeType(fileName, fileInputStream);
            Map<String, String> headerMap = new HashMap<>();
            headerMap.put("Content-Type", mimeType);
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            File pathName = new File(path + fileName);
            fileOutputStream = new FileOutputStream(pathName);
            // 创建缓冲区
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (GetBytesException e) {
            e.printStackTrace();
        } catch (Exception e) {
            log.error("文件上传异常：", e);
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Exception e) {
                log.error("流关闭异常", e);
            }
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Exception e) {
                log.error("流关闭异常", e);
            }
        }

    }

    /**
     * excel上传通用功能
     **/
    @SuppressWarnings("resource")
    public static List<String[]> loadExcel(InputStream is) throws IOException {
        List<String[]> list = new ArrayList<String[]>();
        XSSFWorkbook hwk = new XSSFWorkbook(is);
        // 得到book 第一个工作薄sheet
        XSSFSheet sh = hwk.getSheetAt(0);
        // 总行数
        int rows = sh.getLastRowNum() + 1 - sh.getFirstRowNum();
        // System.out.println(rows);
        for (int i = 1; i < rows; i++) {
            XSSFRow row = sh.getRow(i);
            int cols = row.getLastCellNum() - row.getFirstCellNum();
            // 该行的总列数
            String[] str = new String[cols];
            // 用来存放该行每一列的值
            for (int j = 0; j < cols; j++) {
                Object col = row.getCell((short) j);
                // Object colNext = row.getCell((short) (j + 1));
                if (col != null) {
                    String data = col.toString();
                    if (!StringUtils.isEmpty(data) && data.contains(".")) {
                        data = data.substring(0, data.lastIndexOf("."));
                    }
                    str[j] = data;
                } else {
                    str[j] = "";
                }
            }
            list.add(str);
        }
        return list;
    }

    public static List<Map<String, Object>> loadExcelByMap(InputStream is) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        XSSFWorkbook hwk = new XSSFWorkbook(is);
        // 得到book 第一个工作薄sheet
        XSSFSheet sh = hwk.getSheetAt(0);
        // 总行数
        int rows = sh.getLastRowNum() + 1 - sh.getFirstRowNum();
        // System.out.println(rows);
        for (int i = 1; i < rows; i++) {
            XSSFRow row = sh.getRow(i);
            if (row != null) {
                int cols = row.getLastCellNum() - row.getFirstCellNum();
                // 该行的总列数
                Map<String, Object> str = new HashMap<>(cols);// String[cols];
                // 用来存放该行每一列的值
                for (int j = 0; j < cols; j++) {
                    Object col = row.getCell((short) j);
                    // Object colNext = row.getCell((short) (j + 1));
                    if (col != null) {
                        String data = col.toString();
                        /*
                         * if (!StringUtil.isEmpty(data) && data.contains(".")) { data =
                         * data.substring(0, data.lastIndexOf(".")); }
                         */
                        str.put("var" + j, data);
                    } else {
                        str.put("var" + j, "");
                    }
                }
                list.add(str);
            }
        }
        return list;
    }

    /**
     * 判断文件大小
     *
     * @param len  文件长度
     * @param size 限制大小
     * @param unit 限制单位（B,K,M,G）
     * @return
     */
    public static boolean checkFileSize(Long len, int size, String unit) {
        // long len = file.length();
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        if (fileSize > size) {
            return false;
        }
        return true;
    }

    /*
     * public static void main(String[] args) { try { InputStream fileInputStream =
     * new FileInputStream("D:\\xuexi\\客户模板.xlsx"); List<String[]> list =
     * FileUtils.loadExcel(fileInputStream); if (list != null) { for (String[] str :
     * list) { System.out.println(str); } } } catch (Exception e) {
     * e.printStackTrace(); } //FileUtil.checkFileSize(
     * multipartFile.getSize(),100,"M"); //
     * System.out.println(checkFileSize(10000000000L,10,"M")); }
     */
}
