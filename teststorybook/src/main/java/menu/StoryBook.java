package menu;

import javax.swing.*;
import java.awt.*;

import java.io.IOException;
import java.io.InputStream;

public class StoryBook extends JFrame {
    //成员变量
    private static JTextArea text01 = new JTextArea("");
    private String style = "宋体";
    private int pattern = Font.PLAIN;//字形(常规)
    private int size = 10;//字号
    private static String[] str = new String[3];

    private JPanel panel01=new JPanel();
    private JPanel panel02=new JPanel();
    private JButton btn_last=new JButton("上一页");
    private JButton btn_next=new JButton("下一页");
    private int papeNum=1;//当前的页码 1 2 3

    private JMenuBar jb = new JMenuBar();
    private JMenu fontsize = new JMenu("字号");
    private JMenuItem twelf = new JMenuItem("12");
    private JMenuItem fiveteen = new JMenuItem("15");
    private JMenuItem eighteen = new JMenuItem("18");
    private JMenuItem twenty = new JMenuItem("20");

    private JMenu font = new JMenu("字体");
    private JMenuItem song = new JMenuItem("宋体");
    private JMenuItem hei = new JMenuItem("黑体");
    private JMenuItem kai = new JMenuItem("楷体");

    private JMenu fontstyle = new JMenu("字形");
    private JMenuItem chang = new JMenuItem("常规");
    private JMenuItem jia = new JMenuItem("加粗");
    private JMenuItem qing = new JMenuItem("倾斜");

    private JMenu color = new JMenu("颜色");
    private JMenuItem red = new JMenuItem("红色");
    private JMenuItem green = new JMenuItem("绿色");
    private JMenuItem blue = new JMenuItem("蓝色");

    private JMenu intall = new JMenu("设置");
    private JMenuItem swap = new JMenuItem("换壁纸");

    private int photoNum=1;//当前显示背景图的序号
    private JPanel imagePanel;
    private ImageIcon bg= new ImageIcon("E://temp/test"+photoNum+".jpg");//背景图
    private JLabel label = new JLabel(bg);

    //
     StoryBook()
    {
        //设置字体
        text01.setLineWrap(true);//自动换行
        text01.setFont(new Font(style,pattern,size));
        this.add(text01,BorderLayout.CENTER);

        //设置当前第一页的上一页的按钮不可以点击，添加上下页按钮到边界布局的南方向
        btn_last.setEnabled(false);
        btn_next.setEnabled(true);
        panel01.add(btn_last);
        panel01.add(btn_next);
        this.add(panel01,BorderLayout.SOUTH);


        //添加菜单栏的菜单（字号、字体、字形、颜色、设置）
        jb.add(fontsize);
        jb.add(font);
        jb.add(fontstyle);
        jb.add(color);
        jb.add(intall);

        //添加字号的12、15、18、20
        fontsize.add(twelf);
        fontsize.add(fiveteen);
        fontsize.add(eighteen);
        fontsize.add(twenty);
        this.setJMenuBar(jb);

        //添加字体的宋体、黑体、楷体
        font.add(song);
        font.add(hei);
        font.add(kai);

        //添加字形的常规、加粗、倾斜
        fontstyle.add(chang);
        fontstyle.add(jia);
        fontstyle.add(qing);

        //添加颜色红色、绿色、蓝色
        color.add(red);
        color.add(green);
        color.add(blue);

        //添加设置换壁纸
        intall.add(swap);

    }

    public String readFile(InputStream inStream){//读取文件中的内容
        byte[] buffer =new byte[2048];
        int hasRead=0;//已经读取的字节数
        StringBuffer sBuffer=new StringBuffer();
        try{
            while( (hasRead = inStream.read(buffer))!=-1){//还没有读完
                sBuffer.append(new String(buffer,0,hasRead,"GBK"));
            }
            inStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return sBuffer.toString();
    }

    public static void main(String[] args)throws IOException {
    // TODO Auto-generated method stub
        StoryBook s = new StoryBook();
        s.setTitle("小故事大道理");
        s.setSize(600,500);
        s.setVisible(true);
    }
}
