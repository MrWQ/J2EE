package Test.com.computer.service.test;

import com.computer.model.ComputerModel;
import com.computer.service.IPersist;
import com.computer.service.ISelect;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
/**
 * 使用Spring的测试框架
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载Spring的配置文件beans.xml
 */
@ContextConfiguration("/applicationContext.xml")
public class ISelectTest {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    private IPersist<ComputerModel> persistService;

    @Resource
    private ISelect<ComputerModel> selectService;


    @Test
    public void selectComputerById() {
//        try {
//            // 备注:同学,是看这里的findStudentById()方法，不是上边的那个单元测试的方法名
//            ComputerModel computerModel = selectService.selectComputerById(1);
//            logger.info("信息"+computerModel.getId()+computerModel.getBrand());
//        } catch (Exception e) {
//            logger.error("Error", e);
//        }
    }

    @Test
    public void selectComputers() {
    }

    @Test
    public void selectComputersByBrand() {
    }

    @Test
    public void selectStudentsByMemory() {
    }
}