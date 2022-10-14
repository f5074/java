package practice.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

	public static void main(String[] args) {

		String res = "practice/mybatis/config.xml";

		try {
			
//            // mybatis환경 설정 파일을 읽어오기 위한 스트림 객체
//            InputStream is = Resources.getResourceAsStream(res);
//
//            //SqlSessionFactory 객체 얻어오기
//            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
//
//            //sql문장을 호출하는 sqlSession객체 얻어오기
//            SqlSession session = factory.openSession();
//            MemberVo vo = new MemberVo("batis1","1111","batis@co.kr","010", null);
//
//            //insert("호출할 sql구문 id", 파라미터객체 );
//            int n=session.insert("add", vo); //xml의 insert태그 id, 파라미터
//
//            if(n>0){
//                //커밋하기
//                session.commit();
//                System.out.println("추가 성공");
//            }else{
//                session.rollback();
//                System.out.println("추가 실패");
//            }

			
//			InputStream is = Resources.getResourceAsStream(res);
//			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//			SqlSession session = factory.openSession();
//            int n = session.delete("remove", "batis1");
//            System.out.println("delete 처리건수:" + n);            
//            session.commit();

			
						
			InputStream is = Resources.getResourceAsStream(res);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			List<MemberVo> list = session.selectList("getlist");
			for (MemberVo vo : list) {
				System.out.println("id:" + vo.getId());
				System.out.println("pwd:" + vo.getPwd());
				System.out.println("email:" + vo.getEmail());
				System.out.println("phone:" + vo.getPhone());
				System.out.println("regdate:" + vo.getregdate());
				System.out.println();

			}
//			String findId = "batis1";
//			MemberVo vo1 = session.selectOne("find", findId);
//			if (vo1 == null) {
//				System.out.println("검색된 회원이 없어요!");
//			} else {
//				System.out.println("id:" + vo1.getId());
//				System.out.println("pwd:" + vo1.getPwd());
//				System.out.println("email:" + vo1.getEmail());
//				System.out.println("phone:" + vo1.getPhone());
//				System.out.println("regdate:" + vo1.getregdate());
//				System.out.println();
//			}
//
//			HashMap<String, Object> map = session.selectOne("practice.mybatis.memberMapper.getInfo", "batis2");
//			// key : 칼럼명, value : 내용.
//			String id = (String) map.get("id");
//			String pwd = (String) map.get("pwd");
//			String email = (String) map.get("email");
//			String phone = (String) map.get("phone");
//			Timestamp regdate = (Timestamp) map.get("regdate");
//			System.out.println("[[  정보 검색 (map 사용)  ]]");
//			System.out.println("id:" + id);
//			System.out.println("pwd:" + pwd);
//			System.out.println("email:" + email);
//			System.out.println("phone:" + phone);
//			System.out.println("regdate:" + regdate);
			session.close();

		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
	}

}
