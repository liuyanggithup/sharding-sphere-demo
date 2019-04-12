//package com.seventeen.component.mybatis.plus;
//
//import com.baomidou.mybatisplus.core.config.GlobalConfig;
//import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
//import com.baomidou.mybatisplus.core.toolkit.StringPool;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import StringUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * 基于MyBatis-Plus的代码生成器
// * @author seventeen
// * @date 2018/11/14
// */
//
//public class CodeGenerator {
//
//    /**
//     * 读取控制台内容
//     */
//    public static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append("请输入" + tip + "：");
//        System.out.println(help.toString());
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//            if (StringUtils.isNotEmpty(ipt)) {
//                return ipt;
//            }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }
//
//    public static void main(String[] args) {
//        AutoGenerator mpg = new AutoGenerator();
//        String projectPath = System.getProperty("user.dir");
//
//        /**
//         * 数据源配置
//         */
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8");
//        // dsc.setSchemaName("public");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("123456");
//        mpg.setDataSource(dsc);
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));
//        pc.setModuleName();
//        pc.setEntity("com.seventeen.model.po");
//        pc.setService("com.seventeen.biz.service");
//        pc.setServiceImpl("com.seventeen.biz.service.impl");
//        pc.setMapper("com.seventeen.biz.dao");
//        pc.setXml("classpath:mapper/");
//        pc.setController("com.seventeen.webapps.controller");
//
//        pc.setParent("com.baomidou.ant");
//        mpg.setPackageInfo(pc);
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//        mpg.setTemplate(new TemplateConfig().setXml(null));
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.seventeen.model.po.BasePO");
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
//        strategy.setInclude(scanner("表名"));
//        strategy.setSuperEntityColumns("id");
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
//        mpg.setStrategy(strategy);
//        // 切换模板引擎，需要引入freemarker依赖
////        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
//    }
//
//}
