import java.util.*;
import java.net.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class WCrawler {
    public static void main(String [] args) throws Exception {
        WCrawler wc = new WCrawler();
        String url = "https://www.52doutu.cn/rand/";
        String html = wc.getHtml(url);
        List<String> imageUrl = wc.getImageUrl(html);
        wc.Download(imageUrl);
    }
    //获取img标签正则
    private static  final  String IMGURL_REG="<(img|IMG)(.*?)(/>|></img>|>)";
    //获取src路径正则
    private static  final  String IMGSRC_REG="(data-backup)=(\"|\')(.*?)(\"|\')";
    //获取网址url正则
    private static  final  String URL="(https://)(.*)(.jpg)";
    private String getHtml(String address)throws Exception {
        URL url = new URL(address);
        InputStream in = url.openStream();
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null) {
            sb.append(line, 0, line.length());
            sb.append('\n');
        }
        br.close();
        isr.close();
        in.close();//先开始的流后关闭
        return sb.toString();
    }
    private List<String>getImageUrl(String html){
        List<String>li = new ArrayList<String>();
        Matcher matcher = Pattern.compile(IMGURL_REG).matcher(html);
        while(matcher.find()){
            Matcher matcher2 = Pattern.compile(IMGSRC_REG).matcher(matcher.group());
            while (matcher2.find()){
                Matcher matcher3 = Pattern.compile(URL).matcher(matcher2.group());
                while (matcher3.find()){
                    // 放到集合中
                    li.add(matcher3.group());
                }
            }
        }
        return li;
    }
    private void Download(List<String> listImgSrc){
        InputStream in = null;
        FileOutputStream fo = null;
        try {
            int i = 1;
            for (String url : listImgSrc) {
                // 从图片地址中获取图片后缀名
                String imageName = url.substring(url.lastIndexOf("."), url.length());
                URL uri = new URL(url);
                in = uri.openStream();
                fo = new FileOutputStream(new File("D:\\李国民9496\\职业体验\\FirstDemo\\img\\" + i + imageName));
                byte[] buf = new byte[1024];
                int length = 0;
                System.out.println("开始下载:" + url);
                while ((length = in.read(buf)) != -1) {
                    fo.write(buf, 0, length);
                }
                System.out.println(i+imageName + "下载完成");
                i++;
            }
        } catch (Exception e) {
            System.out.println("下载失败");
        }finally {
            try {
                in.close();
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}


