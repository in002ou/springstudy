package com.gdu.staff;

import static org.junit.Assert.assertSame;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Component
public class StaffUnitTest {
	
	@Autowired
	private StaffMapper staffMapper;
	
	@BeforeClass	// MemberUnitTest 클래스(테스트 파일) 실행 이전에 한 번 먼저 실행된다. (static 처리가 되어 있어야 한다.)
	public static void a1삽입테스트() {
		StaffDTO staffDTO = new StaffDTO("99999", "김기획", "기획부", 5000);
		assertSame(staffDTO, staffMapper.);
	}
	
}
