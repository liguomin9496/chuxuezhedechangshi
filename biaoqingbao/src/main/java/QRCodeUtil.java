import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeUtil {
    // 生成二维码的方法
    private static void generateQRCodeImage(String text, String filePath) throws WriterException, IOException {
        // 创建核心对象
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        // 设置二维码参数
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 400, 400);
        // 设置保存路径
        Path path = FileSystems.getDefault().getPath(filePath);
        // 保存二维码
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static void main(String[] args) {
        String url = "http://6hgakp.natappfree.cc";
        String savePath = "D:\\李国民9496\\职业体验\\FirstDemo\\img\\MyQRCode.png";
        try {
            generateQRCodeImage(url,savePath);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

    }

}