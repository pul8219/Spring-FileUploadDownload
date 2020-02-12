//package egovframework.example.sample.yrtest;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//// Oracle DB 연결 테스트. JUnit 으로 실행하기
//public class OracleConnectionTest {
//	private static final Logger Logger = LoggerFactory.getLogger(OracleConnectionTest.class);
//	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
//	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
//	private static final String USER = "system";
//	private static final String PW = "8243532";
//
//	@Test //JUnit이 테스트하는 코드
//	public void testConnection() throws Exception {
//	        Class.forName(DRIVER);
//	        try(Connection conn= DriverManager.getConnection(URL, USER, PW)) {
//	                Logger.info("오라클에 연결되었습니다.");
//	        }catch(Exception e) {
//	                e.printStackTrace();
//	        }
//	}
//	
//}
