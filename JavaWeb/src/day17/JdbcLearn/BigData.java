package day17.JdbcLearn;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.*;

public class BigData {

    @Test
    public void fun1() throws SQLException, IOException {
        Connection connection = JdbcUtils.getConnection();
        String sql = "insert into tab_bin values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,1);
        preparedStatement.setString(2,"周杰伦搁浅.flac");


        //把文件转换成byte[]
        byte[] bytes = IOUtils.toByteArray(new FileInputStream("F:\\音乐\\周杰伦无损\\七里香\\周杰伦-搁浅.flac"));
        Blob blob = new SerialBlob(bytes);
        preparedStatement.setBlob(3,blob);

        preparedStatement.executeUpdate();
    }


    @Test
    public void fun2Read() throws SQLException, IOException {
        Connection connection = JdbcUtils.getConnection();
        String sql = "select * from tab_bin";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            Blob blob = resultSet.getBlob("data");

            InputStream in = blob.getBinaryStream();
            OutputStream outputStream = new FileOutputStream("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day17\\fileCollections\\test.flac");
            IOUtils.copy(in,outputStream);
        }


    }
}
