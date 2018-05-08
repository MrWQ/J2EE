package Test.com.computer.mapper.test;

import com.computer.model.ComputerModel;
import com.computer.model.MemoryModel;
import com.computer.service.IPersist;
import com.computer.service.ISelect;
import com.computer.thread.MemThread;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

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
public class ComputerMapperTest {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource
    private IPersist<ComputerModel> persistService;

    @Resource
    private ISelect<ComputerModel> selectService;


    @Test
    public void addComputer() {
        ComputerModel computerModel = new ComputerModel("addcomputers", "testadd", "i7", "gtx1050", 125, 10240, 8, 4500);
        try {
            persistService.addComputer(computerModel);
            logger.info("信息"+computerModel.getId()+computerModel.getBrand());
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    @Test
    public void deleteComputerById() {
        try {
            persistService.delComputerById(16);
//            persistService.delComputerById(17);
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    @Test
    public void updateComputerById() {
        ComputerModel computerModel = new ComputerModel("addcomputers", "testadd", "i7", "gtx1050", 125, 10240, 8, 4500);
        try {
            persistService.updateComputerById(computerModel,12);
            persistService.updateComputerById(computerModel,18);
            logger.info("信息"+computerModel.getId()+computerModel.getBrand());
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    @Test
    public void selectComputerById() {
        try {
            // 备注:同学,是看这里的findStudentById()方法，不是上边的那个单元测试的方法名
            ComputerModel computerModel = selectService.selectComputerById(1);
            logger.info(computerModel);
            System.out.println(computerModel);
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    @Test
    public void selectComputers() {
        try {
            List<ComputerModel> list  = selectService.selectComputers();
            logger.info("信息 selectComputers 完成");
//            for (int i =0;i<10000;i++){
//                System.out.println(list.get(i).getId()+list.get(i).getCpu());
//            }
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    @Test
    public void selectComputersByBrand() {
        try {
            List<ComputerModel> list  = selectService.selectComputersByBrand("hp");
            logger.info("信息 selectComputers 完成");
//            for (int i =0;i<list.size();i++){
//                System.out.println(list.get(i).getId()+list.get(i).getCpu());
//            }
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    @Test
    public void selectComputersByMemory() {
        try {
            List<ComputerModel> list  = selectService.selectStudentsByMemory(16);
            logger.info("信息 selectComputers 完成");
//            for (int i =0;i<list.size();i++){
//                System.out.println(list.get(i).getId()+list.get(i).getCpu());
//            }
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

  @Test
  public void addMemory(){

  }

}