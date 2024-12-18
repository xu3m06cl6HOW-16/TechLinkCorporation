package java2_3;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.ZipOutputStream;

//第五題:20份txt做壓縮
import java.io.*;
import java.util.zip.ZipEntry;

public class LottoToZip {
    public static void main(String[] args) {
    	
        String userHome = System.getProperty("user.home");
        String zipFilePath = userHome + File.separator + "Desktop" + File.separator + "Lotto_All.zip";

        LottoProduceTool lpt = new LottoProduceTool();

        try (
            // 建立 ZIP 輸出流
            FileOutputStream fos = new FileOutputStream(zipFilePath);
            ZipOutputStream zos = new ZipOutputStream(fos)
        ) {
            // 產生 20 份檔案的內容並寫入 ZIP 檔案
            for (int k = 1; k <= 20; k++) {
                String fileName;
                if (k < 10) {
                    fileName = "Lotto_0" + k + ".txt";
                } else {
                    fileName = "Lotto_" + k + ".txt";
                }

                // 在 ZIP 檔內加入新檔案
                ZipEntry zipEntry = new ZipEntry(fileName);
                zos.putNextEntry(zipEntry);

                // 使用 BufferedWriter 寫入內容 (不關閉底層流)
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(zos));
                for (int i = 1; i <= 100; i++) {
                    writer.write(Arrays.toString(lpt.playLotto()));
                    writer.newLine();
                }
                writer.flush();

                zos.closeEntry();
            }

            System.out.println("所有樂透檔案已壓縮到：" + zipFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

