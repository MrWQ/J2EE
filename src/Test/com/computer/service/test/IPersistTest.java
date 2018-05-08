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
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 加载Spring的配置文件beans.xml
 */
@ContextConfiguration("/applicationContext.xml")
public class IPersistTest {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    private IPersist<ComputerModel> persistService;

    @Resource
    private ISelect<ComputerModel> selectService;
    @Test
    public void addComputer() {
        ComputerModel computerModel = new ComputerModel("testinsert", "test", "i7", "gtx1050", 125, 10240, 8, 4500);
        try {
            persistService.addComputer(computerModel);
            logger.info("信息"+computerModel.getId()+computerModel.getBrand());
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    @Test
    public void updateComputerById() {
    }

    @Test
    public void delComputerById() {
    }
}