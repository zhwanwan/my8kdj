package com.xxx.crazyjava.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.List;

/**
 * @author zhwanwan
 * @create 2019-06-03 10:11 PM
 */
public class AttributeViewTest {
    public static void main(String[] args) {
        Path testPath = Paths.get("E:\\2019\\picc-platform\\my8kdj\\src\\main\\java\\com\\xxx\\crazyjava\\nio\\AttributeViewTest.java");
        BasicFileAttributeView basicView
                = Files.getFileAttributeView(testPath, BasicFileAttributeView.class);
//        System.out.println(basicView);
        try {
            // 获取访问基本属性的BasicFileAttributes
            BasicFileAttributes attributes = basicView.readAttributes();
//            System.out.println(attributes);
            // 访问文件的基本属性
            System.out.println("创建时间: " + attributes.creationTime().toInstant());
            System.out.println("最后访问时间: " + attributes.lastAccessTime().toInstant());
            System.out.println("最后修改时间: " + attributes.lastModifiedTime().toInstant());
            System.out.println("文件大小: " + attributes.size());

            // 获取访问文件属主信息的FileOwnerAttributeView
            FileOwnerAttributeView ownerAttributeView
                    = Files.getFileAttributeView(testPath, FileOwnerAttributeView.class);
            // 获取该文件所属的用户
            System.out.println("所属用户: " + ownerAttributeView.getOwner());
            // 获取系统中guest对应的用户
            UserPrincipal guest = FileSystems.getDefault()
                    .getUserPrincipalLookupService().lookupPrincipalByName("guest");
            System.out.println("guest 信息: " + guest);
            // 修改用户
            //ownerAttributeView.setOwner(guest);
            // 获取访问自定义属性的FileOwnerAttributeView
            UserDefinedFileAttributeView userView
                    = Files.getFileAttributeView(testPath, UserDefinedFileAttributeView.class);
            List<String> attrNames = userView.list();
            // 遍历所有的自定义属性
            ByteBuffer buf = null;
            for (String name : attrNames) {
                buf = ByteBuffer.allocate(userView.size(name));
                userView.read(name, buf);
                buf.flip();//锁定buf
                String value = Charset.defaultCharset().decode(buf).toString();
                System.out.println(name + "-->" + value);
            }

            // 添加一个自定义属性
            userView.write("发行者", Charset.defaultCharset()
                    .encode("疯狂Java联盟"));
            // 获取访问DOS属性的DosFileAttributeView
            DosFileAttributeView dosView = Files.getFileAttributeView(testPath
                    , DosFileAttributeView.class);
            // 将文件设置隐藏、只读
            dosView.setHidden(true);
            dosView.setReadOnly(true);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
