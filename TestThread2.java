package decade.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread,实现多线程同步下载图片
public class TestThread2 extends Thread {
    private String url;//网络图片地址
    private String name;//保存的文件名
//无参构造
    public TestThread2() {

    }
//有参构造
    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }
    //下载图片线程的执行体
    @Override
    public void run() {
      WebDownloader webDownloader = new WebDownloader();
      webDownloader.downloader(url,name);
        System.out.println("下载了文件名为:"+name);
    }

    public static void main(String[] args) {
        TestThread2 testThread1 = new TestThread2("http://tiebapic.baidu.com/forum/w%3D580/sign=4d10a1377c01213fcf334ed464e636f8/66ec7f7eca806538ccd731fdd2dda144ac348224.jpg","1.jpg");
        TestThread2 testThread2 = new TestThread2("http://tiebapic.baidu.com/forum/w%3D580/sign=79af8592140fd9f9a0175561152cd42b/47048c166d224f4ab2f3d9fd4cf790529a22d1f3.jpg","2.jpg");
        TestThread2 testThread3 = new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201806%2F30%2F20180630111211_fihkb.thumb.700_0.jpg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1640255634&t=7c8ba10c047249f76bcf9bc24cc661b1","3.jpg");

        testThread1.start();
        testThread2.start();
        testThread3.start();
    }

}
//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
