//package com.computer.mapper;
//
//
//import com.computer.model.ComputerModel;
//import com.computer.util.SessionFactory;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.log4j.Logger;
//import org.apache.log4j.xml.DOMConfigurator;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.List;
//
//public class ComputerMapperTest {
//    Logger logger;
//
//    @Before
//    public void getLogger() {
//        try {
//            DOMConfigurator.configure("src/log4j.xml");
//            logger = Logger.getLogger(ComputerMapperTest.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @org.junit.Test
//    public void addComputer() {
//        SqlSessionFactory sqlSessionFactory = SessionFactory.getSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        ComputerMapper computerMapper = sqlSession.getMapper(ComputerMapper.class);
//        ComputerModel computerModel = new ComputerModel("testinsert", "test", "i7", "gtx1050", 125, 10240, 8, 4500);
//        computerMapper.addComputer(computerModel);
//        sqlSession.commit();
//        sqlSession.close();
//        logger.info("Computer test1 添加成功!");
//
//    }
//
//    @org.junit.Test
//    public void deleteComputerById() {
//        SqlSessionFactory sqlSessionFactory = SessionFactory.getSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        ComputerMapper computerMapper = sqlSession.getMapper(ComputerMapper.class);
//        int id = 262124;
//        computerMapper.deleteComputerById(id);
//        sqlSession.commit();
//        sqlSession.close();
//        logger.info("Computer id = " + id + " 删除成功!");
//    }
//
//    @org.junit.Test
//    public void updateComputerById() {
//        SqlSessionFactory sqlSessionFactory = SessionFactory.getSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        ComputerMapper computerMapper = sqlSession.getMapper(ComputerMapper.class);
//        ComputerModel computerModel = new ComputerModel("testupdate", "test", "i7", "gtx1050", 125, 10240, 8, 4500);
//        int id = 262125;
//        computerMapper.updateComputerById(computerModel, id);
//        sqlSession.commit();
//        sqlSession.close();
//        logger.info("Computer id = " + id + " 更改成功!");
//    }
//
//    @org.junit.Test
//    public void selectComputerById() {
//        SqlSessionFactory sqlSessionFactory = SessionFactory.getSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        ComputerMapper computerMapper = sqlSession.getMapper(ComputerMapper.class);
//        int id = 262125;
//        ComputerModel computerModel;
//        computerModel = computerMapper.selectComputerById(id);
//        sqlSession.commit();
//        sqlSession.close();
//        logger.info("Computer id = " + id + " 查询成功!");
//        logger.info("查询结果: "+"name:"+computerModel.getName()+" brand:"+computerModel.getBrand()+" cpu:"+computerModel.getCpu()+" gpu:"+computerModel.getGpu()
//        +" ssd:"+computerModel.getSsd()+" hdd:"+computerModel.getHdd()+" memory:"+computerModel.getMemory()+" price:"+computerModel.getPrice() );
//    }
//    @org.junit.Test
//    public void selectComputers(){
//        SqlSessionFactory sqlSessionFactory = SessionFactory.getSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        ComputerMapper computerMapper = sqlSession.getMapper(ComputerMapper.class);
//        List<ComputerModel> computerList;
//        computerList = computerMapper.selectComputers();
//        sqlSession.commit();
//        sqlSession.close();
//        logger.info("Computers  全部查询成功!"+" last id:"+computerList.get(computerList.size()).getId() );
//    }
//
//}